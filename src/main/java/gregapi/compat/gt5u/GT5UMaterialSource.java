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

package gregapi.compat.gt5u;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import gregapi.oredict.OreDictMaterial;

/**
 * Reads the Material Table of GregTech 5 Unofficial without linking against it.
 * <p>
 * GregTech 6 has to stay runnable on its own, so nothing in here is a compile time or class loading reference to
 * GregTech 5. Everything is looked up by name, and every failure is folded into {@link #getUnavailableReason()} so a
 * present but incompatible GregTech 5 simply leaves the GregTech 6 Materials alone instead of crashing the game.
 * <p>
 * The Materials are read through the Registry GregTech 5 publishes for exactly this purpose: its "getMaterialsMap()"
 * together with the getters on its Materials. Builds without that Registry are still handled by falling back to the
 * public static Material fields, so the Bridge does not quietly stop working when the GregTech 5 build changes.
 * <p>
 * The Names are run through {@link OreDictMaterial#sanitize(String)}, which is the very same function that created the
 * GregTech 6 Names, so both sides are comparable without guessing at formatting rules.
 */
public class GT5UMaterialSource {

    /** The GregTech 5 Material Table. Looked up by name on purpose, see the class comment. */
    private static final String MATERIALS_CLASS = "gregtech.api.enums.Materials";
    /** The GregTech 5 Prefix Table. Same reasoning as the Material one. */
    private static final String PREFIXES_CLASS = "gregtech.api.enums.OrePrefixes";

    private static Map<String, GT5UMaterialSnapshot> MATERIALS = null;
    private static final Map<String, Object> MATERIAL_OBJECTS = new LinkedHashMap<>(),
        PREFIX_OBJECTS = new LinkedHashMap<>();
    private static final Map<String, String> SANITIZED = new LinkedHashMap<>();
    private static Method sGetPrefix = null, sDoGenerateItem = null;
    private static boolean sPrefixApiChecked = false;
    private static String UNAVAILABLE_REASON = null;

    /** True if the GregTech 5 Material Table was found and read successfully. */
    public static boolean isAvailable() {
        readAll();
        return !MATERIALS.isEmpty();
    }

    /** Why the GregTech 5 Material Table could not be read, or null if it could. */
    public static String getUnavailableReason() {
        readAll();
        return UNAVAILABLE_REASON;
    }

    /** Name of every GregTech 5 Material, Sanitized the same way the GregTech 6 Names are. */
    public static Map<String, GT5UMaterialSnapshot> readAll() {
        if (MATERIALS == null) MATERIALS = read();
        return Collections.unmodifiableMap(MATERIALS);
    }

    /** The GregTech 5 Material with the given Sanitized Name, or null if GregTech 5 does not have it. */
    public static GT5UMaterialSnapshot find(String aName) {
        return readAll().get(sanitize(aName));
    }

    /**
     * True if GregTech 5 itself generates the given Prefix for the given Material, which is the same question as
     * whether its Variant of that Material exists. False is the safe answer: it means GregTech 6 keeps its own
     * Variant, so an incompatible GregTech 5 can never leave Items missing.
     */
    public static boolean doesGenerate(String aPrefixName, String aMaterialName) {
        Object tPrefix = prefix(aPrefixName), tMaterial = MATERIAL_OBJECTS.get(sanitize(aMaterialName));
        if (tPrefix == null || tMaterial == null || sDoGenerateItem == null) return false;
        Object tValue = invoke(sDoGenerateItem, tPrefix, tMaterial);
        return tValue instanceof Boolean && (Boolean) tValue;
    }

    /**
     * True if GregTech 5 has a Prefix of that Name at all. This is what tells the Prefixes apart that only GregTech 6
     * brings, which are the ones worth generating for the Materials GregTech 5 does not have either.
     */
    public static boolean hasPrefix(String aPrefixName) {
        readAll();
        return prefix(aPrefixName) != null;
    }

    /**
     * Sanitizes a Name, memoized. The Variant check runs once per Prefix and Material, so this is called hundreds of
     * thousands of times with the very same few hundred Names.
     */
    private static String sanitize(String aName) {
        String rName = SANITIZED.get(aName);
        if (rName == null) {
            rName = OreDictMaterial.sanitize(aName);
            SANITIZED.put(aName, rName);
        }
        return rName;
    }

    private static Object prefix(String aName) {
        readAll();
        if (PREFIX_OBJECTS.containsKey(aName)) return PREFIX_OBJECTS.get(aName);
        Object rPrefix = null;
        if (!sPrefixApiChecked) {
            sPrefixApiChecked = true;
            try {
                Class<?> tPrefixClass = Class.forName(PREFIXES_CLASS);
                sGetPrefix = tPrefixClass.getMethod("getPrefix", String.class);
                sDoGenerateItem = tPrefixClass.getMethod("doGenerateItem", Class.forName(MATERIALS_CLASS));
            } catch (Throwable e) {
                sGetPrefix = null;
                sDoGenerateItem = null;
            }
        }
        if (sGetPrefix != null) rPrefix = invoke(sGetPrefix, null, aName);
        PREFIX_OBJECTS.put(aName, rPrefix);
        return rPrefix;
    }

    private static Object invoke(Method aMethod, Object aInstance, Object aArgument) {
        if (aMethod == null) return null;
        try {
            return aMethod.invoke(aInstance, aArgument);
        } catch (Throwable e) {
            return null;
        }
    }

    private static Map<String, GT5UMaterialSnapshot> read() {
        Map<String, GT5UMaterialSnapshot> rMaterials = new LinkedHashMap<>();
        try {
            Class<?> tMaterialClass = Class.forName(MATERIALS_CLASS);
            Reader tReader = new Reader(tMaterialClass);
            readRegistry(tReader, rMaterials);
            if (rMaterials.isEmpty()) readStaticFields(tReader, rMaterials);
            if (rMaterials.isEmpty()) UNAVAILABLE_REASON = "The GregTech 5 Material Table is empty.";
        } catch (Throwable e) {
            // An absent or incompatible GregTech 5 is a normal situation, not an error worth crashing over.
            UNAVAILABLE_REASON = e.getClass()
                .getSimpleName() + ": "
                + e.getMessage();
            rMaterials.clear();
        }
        return rMaterials;
    }

    /** Reads every Material the GregTech 5 Registry knows about. */
    private static void readRegistry(Reader aReader, Map<String, GT5UMaterialSnapshot> aOut) {
        Method tRegistry = aReader.method("getMaterialsMap");
        if (tRegistry == null) return;
        try {
            Object tValue = tRegistry.invoke(null);
            if (!(tValue instanceof Map)) return;
            for (Object tMaterial : ((Map<?, ?>) tValue).values()) aReader.add(aOut, tMaterial, null);
        } catch (Throwable e) {
            aOut.clear();
        }
    }

    /** Fallback for GregTech 5 builds without that Registry: every public static field holding a Material. */
    private static void readStaticFields(Reader aReader, Map<String, GT5UMaterialSnapshot> aOut) {
        for (Field tField : aReader.mClass.getFields()) {
            if (!Modifier.isStatic(tField.getModifiers())) continue;
            try {
                aReader.add(aOut, tField.get(null), tField.getName());
            } catch (Throwable e) {
                // A field that cannot be read simply is not a Material we can use.
            }
        }
    }

    /** Caches the reflective handles of one GregTech 5 Material class. */
    private static class Reader {

        private final Class<?> mClass;
        private final Method mGetName, mGetLocalName, mGetChemicalFormula, mGetRGBa, mGetTextureSet;
        private final Field mElement;

        private Reader(Class<?> aClass) {
            mClass = aClass;
            mGetName = method("getName");
            mGetLocalName = method("getDefaultLocalName");
            mGetChemicalFormula = method("getChemicalFormula");
            mGetRGBa = method("getRGBA");
            mGetTextureSet = method("getTextureSet");
            mElement = field("mElement");
        }

        private Method method(String aName) {
            try {
                return mClass.getMethod(aName);
            } catch (Throwable e) {
                return null;
            }
        }

        private Field field(String aName) {
            try {
                return mClass.getField(aName);
            } catch (Throwable e) {
                return null;
            }
        }

        private void add(Map<String, GT5UMaterialSnapshot> aOut, Object aMaterial, String aFallbackName) {
            if (aMaterial == null || !mClass.isInstance(aMaterial)) return;
            String tRegisteredName = invokeString(mGetName, aMaterial);
            if (tRegisteredName == null || tRegisteredName.isEmpty()) tRegisteredName = aFallbackName;
            if (tRegisteredName == null) return;
            String tSanitizedName = OreDictMaterial.sanitize(tRegisteredName);
            if (tSanitizedName.isEmpty()) return;
            long[] tElement = readElement(aMaterial);
            MATERIAL_OBJECTS.put(tSanitizedName, aMaterial);
            aOut.put(
                tSanitizedName,
                new GT5UMaterialSnapshot(
                    tSanitizedName,
                    invokeString(mGetLocalName, aMaterial),
                    invokeString(mGetChemicalFormula, aMaterial),
                    tElement[0],
                    tElement[1],
                    color(invoke(mGetRGBa, aMaterial)),
                    enumName(invoke(mGetTextureSet, aMaterial))));
        }

        /** Packs the RGBA GregTech 5 uses into the 0xRRGGBB GregTech 6 works with. */
        private static int color(Object aValue) {
            if (!(aValue instanceof short[]) || ((short[]) aValue).length < 3) return 0xFFFFFF;
            short[] tRGBa = (short[]) aValue;
            return ((tRGBa[0] & 0xFF) << 16) | ((tRGBa[1] & 0xFF) << 8) | (tRGBa[2] & 0xFF);
        }

        /** The constant Name of an Enum value, which is how a Texture Set is identified across the two Mods. */
        private static String enumName(Object aValue) {
            if (aValue == null) return null;
            return invokeString(methodOf(aValue.getClass(), "name"), aValue);
        }

        /**
         * Reads the Element of a Material. The Element field has no getter, its numbers do, and only a real Element
         * counts: the values GregTech 5 derives for a Compound come from its density and mean nothing to GregTech 6,
         * which is why a Material without an Element reports zeroes instead.
         */
        private long[] readElement(Object aMaterial) {
            long[] rProtonsAndNeutrons = new long[] { 0, 0 };
            if (mElement == null) return rProtonsAndNeutrons;
            Object tElement;
            try {
                tElement = mElement.get(aMaterial);
            } catch (Throwable e) {
                return rProtonsAndNeutrons;
            }
            if (tElement == null) return rProtonsAndNeutrons;
            rProtonsAndNeutrons[0] = invokeNumber(methodOf(tElement.getClass(), "getProtons"), tElement);
            rProtonsAndNeutrons[1] = invokeNumber(methodOf(tElement.getClass(), "getNeutrons"), tElement);
            return rProtonsAndNeutrons;
        }

        private static Method methodOf(Class<?> aClass, String aName) {
            try {
                return aClass.getMethod(aName);
            } catch (Throwable e) {
                return null;
            }
        }

        private static String invokeString(Method aMethod, Object aInstance) {
            Object tValue = invoke(aMethod, aInstance);
            return tValue instanceof String ? (String) tValue : null;
        }

        private static long invokeNumber(Method aMethod, Object aInstance) {
            Object tValue = invoke(aMethod, aInstance);
            return tValue instanceof Number ? ((Number) tValue).longValue() : 0;
        }

        private static Object invoke(Method aMethod, Object aInstance) {
            if (aMethod == null) return null;
            try {
                return aMethod.invoke(aInstance);
            } catch (Throwable e) {
                return null;
            }
        }
    }
}
