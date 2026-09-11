/**
 * Copyright (c) 2025 GregTech-6 Team
 *
 * This file is part of GregTech.
 *
 * GregTech is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GregTech is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GregTech. If not, see <http://www.gnu.org/licenses/>.
 */

package gregapi.data.materials;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The ordered pipeline that fills the Material Table.
 * <p>
 * The Table used to be one single field declaration statement of several thousand initialisers, which repeatedly ran
 * into the 65536 byte limit of a class initialiser and forced every Material to be declared in a strictly enforced
 * order. Registration is now split into Categories that are executed one after another, so each Category gets its own
 * initialiser and new Materials can be added in a place that makes sense instead of at the end of a huge list.
 * <p>
 * Mods may extend the Table by registering their own Category. A Category that only adds Materials can be registered
 * at any time, it runs right away once the Table is already loaded. A Category that the built in ones should depend on
 * has to be placed with {@link #registerBefore(String, IMaterialCategory)} or
 * {@link #registerAfter(String, IMaterialCategory)} during Mod construction.
 * <p>
 * This class is deliberately not thread safe. It is executed during Forge's single threaded Mod loading phase, which
 * is the same guarantee the monolithic class initialiser it replaces relied upon.
 */
public class MaterialRegistry {

    private static final List<IMaterialCategory> CATEGORIES = new ArrayList<>();

    private static boolean sLoading = false, sLoaded = false;
    private static String sCurrentCategory = null;

    /**
     * Appends a Category to the end of the pipeline. The Category runs after everything that was registered before it.
     * <p>
     * Registering after the Material Table was already loaded is allowed and runs the Category right away, so a Mod
     * that only finds out about GregTech during its own PreInit can still add its Materials. Doing it that way means
     * the Category sees the finished Table and must not expect to be a dependency of a built in Category.
     */
    public static void register(IMaterialCategory aCategory) {
        if (aCategory == null) throw new IllegalArgumentException("A Material Category may not be null!");
        if (sLoading) throw new IllegalStateException(
            "The Material Category '" + aCategory.getName()
                + "' was registered while the Material Table was loading. Register it during Mod construction, or after the Table finished loading.");
        CATEGORIES.add(aCategory);
        if (sLoaded) run(aCategory);
    }

    /**
     * Inserts a Category directly in front of the Category with the given Name, so it runs before that one. Used by
     * Mods that have to provide Materials which a built in Category depends on, which means it has to happen before
     * the Material Table is loaded, during Mod construction.
     */
    public static void registerBefore(String aCategoryName, IMaterialCategory aCategory) {
        insert(aCategoryName, aCategory, 0);
    }

    /**
     * Inserts a Category directly behind the Category with the given Name, so it runs after that one and before
     * everything that followed it. Has to happen before the Material Table is loaded, during Mod construction.
     */
    public static void registerAfter(String aCategoryName, IMaterialCategory aCategory) {
        insert(aCategoryName, aCategory, 1);
    }

    /**
     * Runs every registered Category in order. Repeated calls are no-ops, so this can be used as the idempotent entry
     * point of the Material Table.
     */
    public static void load() {
        // Re-entrant calls happen when a Category touches a class whose initialiser asks for the Material Table again.
        // Returning immediately is what the monolithic initialiser did implicitly, and it avoids locking this class
        // while a class initialiser lock is already held.
        if (sLoading || sLoaded) return;
        sLoading = true;
        try {
            // Indexed, because a Category is allowed to register another one while the Table is not loading yet.
            for (int i = 0; i < CATEGORIES.size(); i++) run(CATEGORIES.get(i));
            sLoaded = true;
        } finally {
            sCurrentCategory = null;
            sLoading = false;
        }
    }

    /** True while the Categories are being executed, which means the Material Table is only partially filled. */
    public static boolean isLoading() {
        return sLoading;
    }

    /** True once every Category finished, which means the Material Table is complete. */
    public static boolean isLoaded() {
        return sLoaded;
    }

    /** The Name of the Category that is currently being executed, or null while nothing is running. */
    public static String getCurrentCategory() {
        return sCurrentCategory;
    }

    /** The registered Categories in execution order, for diagnostics. */
    public static List<IMaterialCategory> getCategories() {
        return Collections.unmodifiableList(CATEGORIES);
    }

    private static void insert(String aCategoryName, IMaterialCategory aCategory, int aOffset) {
        if (aCategory == null) throw new IllegalArgumentException("A Material Category may not be null!");
        if (sLoading || sLoaded) throw new IllegalStateException(
            "The Material Category '" + aCategory.getName()
                + "' was registered too late. Inserting Categories relative to a built in one only works before the Material Table is loaded.");
        int tIndex = indexOf(aCategoryName);
        if (tIndex < 0) throw new IllegalArgumentException(
            "There is no Material Category named '" + aCategoryName
                + "' to insert '"
                + aCategory.getName()
                + "' relative to.");
        CATEGORIES.add(tIndex + aOffset, aCategory);
    }

    private static void run(IMaterialCategory aCategory) {
        sCurrentCategory = aCategory.getName();
        aCategory.load();
    }

    private static int indexOf(String aCategoryName) {
        for (int i = 0; i < CATEGORIES.size(); i++) if (CATEGORIES.get(i)
            .getName()
            .equals(aCategoryName)) return i;
        return -1;
    }
}
