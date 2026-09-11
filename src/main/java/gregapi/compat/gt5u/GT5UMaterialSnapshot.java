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

/**
 * What GregTech 5 Unofficial knows about one of its Materials.
 * <p>
 * A plain data holder on purpose: {@link GT5UMaterialSource} fills it through reflection and
 * {@link GT5UMaterialBridge} is the only place that decides what GregTech 6 does with it. That keeps every decision
 * about adopting GregTech 5 data in one readable spot instead of spreading reflection calls around.
 * <p>
 * Only the identity of a Material is in here. The energetic triple, the Ore yield and the Tool stats are deliberately
 * missing: GregTech 5 keeps one value where GregTech 6 keeps a coherent set of values, and the ones GregTech 6 has are
 * part of its own balancing and of the Materials.cfg overrides. The Colour and the Texture Set are in here because a
 * Material that GregTech 6 has to create for GregTech 5 needs to look like something.
 */
public class GT5UMaterialSnapshot {

    /** The OreDictionary Name of the GregTech 5 Material, sanitized the same way the GregTech 6 Names are. */
    public final String mName;
    /** The localised Name, as GregTech 5 would display it, never null. */
    public final String mLocalName;
    /** The chemical Formula, or null if GregTech 5 does not know one either. */
    public final String mChemicalFormula;
    /** The Protons of the Element this Material is made of, 0 if it is not a plain Element. */
    public final long mProtons;
    /** The Neutrons of the Element this Material is made of, 0 if it is not a plain Element. */
    public final long mNeutrons;
    /** The Colour of the GregTech 5 Material, packed as 0xRRGGBB. */
    public final int mRGBa;
    /** The Name of the Texture Set GregTech 5 renders this Material with, null if it has none. */
    public final String mTextureSetName;

    public GT5UMaterialSnapshot(String aName, String aLocalName, String aChemicalFormula, long aProtons, long aNeutrons,
        int aRGBa, String aTextureSetName) {
        mName = aName;
        mLocalName = aLocalName == null || aLocalName.isEmpty() ? aName : aLocalName;
        mChemicalFormula = usableFormula(aChemicalFormula) ? aChemicalFormula : null;
        mProtons = aProtons;
        mNeutrons = aNeutrons;
        mRGBa = aRGBa;
        mTextureSetName = aTextureSetName;
    }

    /** True if GregTech 5 knows which Element this Material is made of. */
    public boolean hasElement() {
        return mProtons > 0 || mNeutrons > 0;
    }

    /** GregTech 5 writes "?" into Materials it has no Formula for, which is not worse than having none. */
    private static boolean usableFormula(String aFormula) {
        return aFormula != null && !aFormula.isEmpty() && !"?".equals(aFormula) && !"(?)".equals(aFormula);
    }

    @Override
    public String toString() {
        return mName;
    }
}
