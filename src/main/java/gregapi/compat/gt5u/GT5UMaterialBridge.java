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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import gregapi.code.ModData;
import gregapi.data.MD;
import gregapi.data.TD;
import gregapi.oredict.OreDictMaterial;
import gregapi.render.TextureSet;

/**
 * Makes the GregTech 6 Materials that GregTech 5 Unofficial also has use the GregTech 5 data.
 * <p>
 * Both Mods maintain their own Material Table and both register their Items in the OreDictionary, which is what makes
 * the Items interchangeable in the first place. What this Bridge adds is that the shared Name is not just a Name: a
 * GregTech 6 Material whose Name GregTech 5 also uses is marked as coming from GregTech 5, and it takes over the
 * identity data GregTech 5 knows about it.
 * <p>
 * Adopted is only identity data, and only where GregTech 6 has nothing of its own to say:
 * <ul>
 * <li>the localised Name, if GregTech 6 never set one and only displays the internal Name,</li>
 * <li>the chemical Formula, if GregTech 6 has none,</li>
 * <li>Protons and Neutrons, whenever GregTech 5 knows the Element of the Material,</li>
 * <li>the Mod the Material originated from, if nothing but GregTech itself claimed it.</li>
 * </ul>
 * Everything else stays GregTech 6 data on purpose. Colours, the melting, boiling and plasma points, the Ore yield and
 * the Tool stats form coherent sets that GregTech 5 stores as single values, and they are part of the GregTech 6
 * balancing and of the Materials.cfg overrides that are applied after this Bridge runs.
 * <p>
 * Materials that only GregTech 6 has are left completely untouched. Those are the variants this Bridge has to preserve:
 * the isotopes, the extra Alloys and everything else that GregTech 5 never had.
 * <p>
 * Materials that only GregTech 5 has get a GregTech 6 Material of their own, in the ID range the Material Table
 * reserves for Materials that are not GregTech's own, so that the GregTech 6 Variants can be generated for them too.
 * They take GregTech 5's Colour and Texture Set, which is what makes those extra Variants look like the Material.
 * <p>
 * The Variants of a shared Material are handed over to GregTech 5 as well, see {@link GT5UMaterialVariants}.
 */
public class GT5UMaterialBridge {

    /** The ID range OreDictMaterial reserves for Materials that do not come from GregTech itself. */
    private static final int CUSTOM_ID_FIRST = 32000, CUSTOM_ID_LAST = 32765;

    private static final Map<String, GT5UMaterialSnapshot> ADOPTED = new LinkedHashMap<>(),
        CREATED = new LinkedHashMap<>();
    private static final List<String> GREGTECH_6_ONLY = new ArrayList<>(), NOT_CREATED = new ArrayList<>();
    private static int sNextID = CUSTOM_ID_FIRST;
    private static boolean APPLIED = false;

    /**
     * Adopts the GregTech 5 data for every shared Material Name and creates the missing Materials for the Names only
     * GregTech 5 has. Does nothing if GregTech 5 is absent or if its Material Table cannot be read, and repeated calls
     * are no-ops.
     */
    public static void apply() {
        if (APPLIED) return;
        APPLIED = true;

        Map<String, GT5UMaterialSnapshot> tGregTech5 = GT5UMaterialSource.readAll();
        if (tGregTech5.isEmpty()) return;

        for (Map.Entry<String, OreDictMaterial> tEntry : OreDictMaterial.MATERIAL_MAP.entrySet()) {
            // Negative IDs belong to the placeholders and to the Materials the OreDict creates on the fly.
            if (tEntry.getValue().mID < 0) continue;
            GT5UMaterialSnapshot tSnapshot = tGregTech5.get(tEntry.getKey());
            if (tSnapshot == null) {
                GREGTECH_6_ONLY.add(tEntry.getKey());
                continue;
            }
            adopt(tEntry.getValue(), tSnapshot);
            ADOPTED.put(tEntry.getKey(), tSnapshot);
        }

        // GregTech 5 keeps its own order, which is what makes the IDs a Run gets reproducible.
        for (Map.Entry<String, GT5UMaterialSnapshot> tEntry : tGregTech5.entrySet())
            if (!ADOPTED.containsKey(tEntry.getKey())) create(tEntry.getValue());

        Collections.sort(GREGTECH_6_ONLY);
        Collections.sort(NOT_CREATED);

        // The Variants depend on the adopted and created names, so they come last, and they have to be handed over
        // before the PrefixItems register their OreDictionary entries.
        GT5UMaterialVariants.apply();
    }

    /** True once {@link #apply()} ran, whether or not GregTech 5 turned out to be present. */
    public static boolean isApplied() {
        return APPLIED;
    }

    /** The shared Names, mapped to the GregTech 5 data that was adopted, in no particular order. */
    public static Map<String, GT5UMaterialSnapshot> getAdopted() {
        return Collections.unmodifiableMap(ADOPTED);
    }

    /**
     * The Names GregTech 6 did not have and created so GregTech 5 Materials get GregTech 6 Variants too, mapped to the
     * GregTech 5 data they were created from.
     */
    public static Map<String, GT5UMaterialSnapshot> getCreated() {
        return Collections.unmodifiableMap(CREATED);
    }

    /** The Names only GregTech 6 has, which are the variants GregTech 5 never had. Sorted. */
    public static List<String> getGregTech6OnlyNames() {
        return Collections.unmodifiableList(GREGTECH_6_ONLY);
    }

    /**
     * The Names that are GregTech 5's alone and could not be created, either because GregTech 6 refuses the Name or
     * because its reserved ID range is used up. Sorted.
     */
    public static List<String> getNotCreatedNames() {
        return Collections.unmodifiableList(NOT_CREATED);
    }

    private static void adopt(OreDictMaterial aMaterial, GT5UMaterialSnapshot aGregTech5) {
        applyIdentity(aMaterial, aGregTech5);

        if (isGregTechOrigin(aMaterial.mOriginalMod) && !aMaterial.contains(TD.Atomic.ELEMENT))
            aMaterial.setOriginalMod(MD.GT5U);
    }

    /**
     * Creates a GregTech 6 Material for a Name only GregTech 5 has, so that the GregTech 6 Variants of that Material
     * have something to be generated for. It only ever generates the Variants GregTech 5 lacks, which the handover in
     * {@link GT5UMaterialVariants} takes care of.
     */
    private static void create(GT5UMaterialSnapshot aGregTech5) {
        int tID = freeID();
        if (tID < 0) {
            NOT_CREATED.add(aGregTech5.mName);
            return;
        }
        try {
            OreDictMaterial rMaterial = OreDictMaterial.createMaterial(tID, aGregTech5.mName, aGregTech5.mLocalName);
            // Names GregTech 6 rejects and Names that already exist come back without the requested ID.
            if (rMaterial.mID != tID) {
                NOT_CREATED.add(aGregTech5.mName);
                return;
            }
            rMaterial.setTextures(textureSet(aGregTech5.mTextureSetName));
            rMaterial
                .setRGBa((aGregTech5.mRGBa >> 16) & 0xFF, (aGregTech5.mRGBa >> 8) & 0xFF, aGregTech5.mRGBa & 0xFF, 255);
            applyIdentity(rMaterial, aGregTech5);
            rMaterial.setOriginalMod(MD.GT5U);
            CREATED.put(aGregTech5.mName, aGregTech5);
        } catch (Throwable e) {
            // Every Material GregTech 6 will not take is simply left to GregTech 5.
            NOT_CREATED.add(aGregTech5.mName);
        }
    }

    /** The Material data both the adopted and the created Materials take over from GregTech 5. */
    private static void applyIdentity(OreDictMaterial aMaterial, GT5UMaterialSnapshot aGregTech5) {
        // The localised Name and the Formula are only filled in. GregTech 6 sets those on purpose where it wants a
        // Name of its own, and it keeps its own where GregTech 5 has nothing to offer.
        if (aMaterial.mNameLocal.equals(aMaterial.mNameInternal)) aMaterial.setLocal(aGregTech5.mLocalName);

        if (aMaterial.mTooltipChemical == null || aMaterial.mTooltipChemical.isEmpty())
            aMaterial.mTooltipChemical = aGregTech5.mChemicalFormula;

        // The Element data is GregTech 5's whenever GregTech 5 knows the Element, which is the more precise source
        // even for the Isotopes, since GregTech 5 gives those their own Element with their own Neutron count.
        if (aGregTech5.hasElement()) {
            aMaterial.mProtons = aGregTech5.mProtons;
            aMaterial.mNeutrons = aGregTech5.mNeutrons;
            aMaterial.mElectrons = aGregTech5.mProtons;
            aMaterial.mMass = aMaterial.mProtons + aMaterial.mNeutrons;
        }
    }

    /** The lowest free ID of the range OreDictMaterial reserves for Materials that are not GregTech's own. */
    private static int freeID() {
        while (sNextID <= CUSTOM_ID_LAST) {
            if (OreDictMaterial.MATERIAL_ARRAY[sNextID] == null) return sNextID;
            sNextID++;
        }
        return -1;
    }

    /**
     * The Texture Set GregTech 6 uses for a Material that GregTech 5 renders with the Set of the given Name. The two
     * Mods share those Names, so a Material that only GregTech 5 had keeps looking like itself in the Variants
     * GregTech 6 adds. Falls back to the dull Set, which is what GregTech 6 gives most Metals anyway.
     */
    private static TextureSet[] textureSet(String aGregTech5Name) {
        if (aGregTech5Name != null) try {
            Object tValue = TextureSet.class.getField(aGregTech5Name)
                .get(null);
            if (tValue instanceof TextureSet[]) return (TextureSet[]) tValue;
        } catch (Throwable e) {
            // Falls through to the dull Set below.
        }
        return TextureSet.SET_DULL;
    }

    /**
     * True for the attributions GregTech 6 gives to its own Materials. Elements are excluded by the caller on purpose:
     * GregTech 6 labels those as coming from the Periodic Table of Elements, which says more than naming a Mod, and
     * GregTech 5 has the very same Elements anyway.
     */
    private static boolean isGregTechOrigin(ModData aMod) {
        return aMod == null || aMod == MD.GAPI || aMod == MD.GT || aMod == MD.GT6U;
    }
}
