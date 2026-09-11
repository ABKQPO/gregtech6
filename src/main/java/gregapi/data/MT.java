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

package gregapi.data;

import static gregapi.data.CS.*;
import static gregapi.data.TD.Atomic.*;
import static gregapi.data.TD.Compounds.*;
import static gregapi.data.TD.ItemGenerator.*;
import static gregapi.data.TD.Processing.*;
import static gregapi.data.TD.Properties.*;
import static gregapi.render.TextureSet.*;

import net.minecraft.enchantment.Enchantment;

import gregapi.code.HashSetNoNulls;
import gregapi.code.TagData;
import gregapi.data.materials.MaterialsInit;
import gregapi.oredict.OreDictItemData;
import gregapi.oredict.OreDictManager;
import gregapi.oredict.OreDictMaterial;
import gregapi.oredict.configurations.OreDictConfigurationComponent;
import gregapi.render.TextureSet;
import gregapi.util.OM;

/**
 * @author Gregorius Techneticies
 * 
 *         List of all Materials. The Short Name is for ease of overview and stands for "MaTerial".
 * 
 *         Note: I wrote those shortcuts not only because of overview Reasons. I have hit the 65536 Limit of the static
 *         initialiser multiple times by now.
 */
public class MT {

    /** This Set is for GregTech usage only, do not add your Materials to this! */
    public static final HashSetNoNulls<OreDictMaterial> ALL_MATERIALS_REGISTERED_HERE = new HashSetNoNulls<>();

    /**
     * Making the Table a little bit more overviewable. DO NOT USE THESE FUNCTIONS YOURSELF!!! Use
     * "OreDictMaterial.createMaterial(YOUR-ID-AS-SPECIFIED-IN-THE-ID-RANGES, OREDICT-NAME, LOCALISED-NAME)"
     */
    static OreDictMaterial tier(String aNameOreDict) {
        return create(-1, aNameOreDict).put(UNUSED_MATERIAL, DONT_SHOW_THIS_COMPONENT, IGNORE_IN_COLOR_LOG, MD.GAPI)
            .setAllToTheOutputOf(null, 0, 1);
    }

    static OreDictMaterial unused(String aNameOreDict) {
        return create(-1, aNameOreDict).put(UNUSED_MATERIAL, DONT_SHOW_THIS_COMPONENT);
    }

    static OreDictMaterial deprecated(String aNameOreDict) {
        return create(-1, aNameOreDict).put(UNUSED_MATERIAL, DONT_SHOW_THIS_COMPONENT);
    }

    static OreDictMaterial invalid(String aNameOreDict) {
        return create(-1, aNameOreDict).put(UNUSED_MATERIAL, DONT_SHOW_THIS_COMPONENT, INVALID_MATERIAL);
    }

    static OreDictMaterial create(int aID, String aNameOreDict) {
        if (aID >= 10000) return null;
        OreDictMaterial rMaterial = OreDictMaterial.createMaterial(aID, aNameOreDict, aNameOreDict);
        ALL_MATERIALS_REGISTERED_HERE.add(rMaterial);
        if (aID > 0) rMaterial.setOriginalMod(MD.GAPI);
        return rMaterial.handle(ANY.WoodPlastic);
    }

    static OreDictMaterial create(int aID, String aNameOreDict, TextureSet[] aSets) {
        return create(aID, aNameOreDict).setTextures(aSets);
    }

    static OreDictMaterial create(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, aSets).setRGBa(aR, aG, aB, aA)
            .put(aRandomData, aR == 256 ? UNUSED_MATERIAL : null)
            .hide(aR == 256);
    }

    /**
     * Making the Table a little bit more overviewable. DO NOT USE THESE FUNCTIONS YOURSELF!!! Use
     * "OreDictMaterial.createMaterial(YOUR-ID-AS-SPECIFIED-IN-THE-ID-RANGES, OREDICT-NAME, LOCALISED-NAME)"
     */
    static OreDictMaterial element(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, long aA, Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData)
            .setStats(aProtonsAndElectrons, aNeutrons, aMeltingPoint, aBoilingPoint, aGramPerCubicCentimeter)
            .put(ELEMENT)
            .tooltip(aSymbol);
    }

    static OreDictMaterial metal(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, long aA, Object... aRandomData) {
        return element(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            aA,
            aRandomData).put(
                METAL,
                G_INGOT_ORES,
                SMITHABLE,
                MELTING,
                EXTRUDER,
                aMeltingPoint <= 1200 ? new Object[] { EXTRUDER_SIMPLE, FURNACE, MORTAR } : null);
    }

    static OreDictMaterial metalloid(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, long aA, Object... aRandomData) {
        return element(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            aA,
            aRandomData).put(
                METALLOID,
                G_INGOT_ORES,
                SMITHABLE,
                MELTING,
                MOLTEN,
                EXTRUDER,
                aMeltingPoint <= 1200 ? new Object[] { EXTRUDER_SIMPLE, FURNACE, MORTAR } : null);
    }

    static OreDictMaterial nonmetal(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, long aA, Object... aRandomData) {
        return element(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            aA,
            aRandomData).put(NONMETAL);
    }

    static OreDictMaterial diatomic(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, long aA, Object... aRandomData) {
        return nonmetal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            aA,
            aRandomData).put(DIATOMIC_NONMETAL);
    }

    static OreDictMaterial diatomicgas(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, long aA, Object... aRandomData) {
        return diatomic(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            aA,
            aRandomData).put(GASES);
    }

    static OreDictMaterial polyatomic(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, long aA, Object... aRandomData) {
        return nonmetal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            aA,
            aRandomData).put(POLYATOMIC_NONMETAL);
    }

    static OreDictMaterial noblegas(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, Object... aRandomData) {
        return nonmetal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            15,
            aRandomData).put(NOBLE_GAS, GASES);
    }

    static OreDictMaterial alkali(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, Object... aRandomData) {
        return metal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            255,
            aRandomData).put(ALKALI_METAL, MOLTEN);
    }

    static OreDictMaterial alkaline(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, Object... aRandomData) {
        return metal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            255,
            aRandomData).put(ALKALINE_EARTH_METAL, MOLTEN);
    }

    static OreDictMaterial lanthanide(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, Object... aRandomData) {
        return metal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            255,
            aRandomData).put(LANTHANIDE);
    }

    static OreDictMaterial actinide(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, Object... aRandomData) {
        return metal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            255,
            aRandomData).put(ACTINIDE);
    }

    static OreDictMaterial transmetal(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, long aA, Object... aRandomData) {
        return metal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            aA,
            aRandomData).put(TRANSITION_METAL);
    }

    static OreDictMaterial precmetal(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, Object... aRandomData) {
        return transmetal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            255,
            aRandomData).put(PRECIOUS_METAL);
    }

    static OreDictMaterial noblemetal(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, Object... aRandomData) {
        return precmetal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            aRandomData).put(NOBLE_METAL);
    }

    static OreDictMaterial refractmetal(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, long aA, Object... aRandomData) {
        return transmetal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            aA,
            aRandomData).put(REFRACTORY_METAL, WASHING_FIRESTONE);
    }

    static OreDictMaterial platingroup(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, Object... aRandomData) {
        return precmetal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            aRandomData).put(PLATINUM_GROUP);
    }

    static OreDictMaterial posttrans(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        long aR, long aG, long aB, Object... aRandomData) {
        return metal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            aR,
            aG,
            aB,
            255,
            aRandomData).put(POST_TRANSITION_METAL);
    }

    /**
     * Making the Table a little bit more overviewable. DO NOT USE THESE FUNCTIONS YOURSELF!!! Use
     * "OreDictMaterial.createMaterial(YOUR-ID-AS-SPECIFIED-IN-THE-ID-RANGES, OREDICT-NAME, LOCALISED-NAME)"
     */
    static OreDictMaterial element(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        TagData... aTags) {
        return create(aID, aNameOreDict, aSets, 256, 256, 256, 255)
            .setStats(aProtonsAndElectrons, aNeutrons, aMeltingPoint, aBoilingPoint, aGramPerCubicCentimeter)
            .put(aTags, ELEMENT)
            .tooltip(aSymbol);
    }

    static OreDictMaterial element(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        TagData[] aTags2, TagData... aTags) {
        return create(aID, aNameOreDict, aSets, 256, 256, 256, 255)
            .setStats(aProtonsAndElectrons, aNeutrons, aMeltingPoint, aBoilingPoint, aGramPerCubicCentimeter)
            .put(aTags, aTags2, ELEMENT)
            .tooltip(aSymbol);
    }

    static OreDictMaterial element(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        TagData aTag3, TagData[] aTags2, TagData... aTags) {
        return create(aID, aNameOreDict, aSets, 256, 256, 256, 255)
            .setStats(aProtonsAndElectrons, aNeutrons, aMeltingPoint, aBoilingPoint, aGramPerCubicCentimeter)
            .put(aTags, aTags2, aTag3, ELEMENT)
            .tooltip(aSymbol);
    }

    static OreDictMaterial unknown(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, TagData... aTags) {
        return element(aID, aNameOreDict, aSymbol, aProtonsAndElectrons, aNeutrons, 1000, 3000, 0, SET_SHINY).put(aTags)
            .hide()
            .aspects(TC.RADIO, 1);
    }

    static OreDictMaterial metalloid(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        TagData... aTags) {
        return element(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            256,
            256,
            256,
            255).put(
                aTags,
                METALLOID,
                G_INGOT_ORES,
                SMITHABLE,
                MELTING,
                MOLTEN,
                EXTRUDER,
                aMeltingPoint <= 1200 ? new Object[] { EXTRUDER_SIMPLE, FURNACE, MORTAR } : null);
    }

    static OreDictMaterial alkali(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        TagData... aTags) {
        return metal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            256,
            256,
            256,
            255).put(aTags, ALKALI_METAL, MOLTEN);
    }

    static OreDictMaterial alkaline(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        TagData... aTags) {
        return metal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            256,
            256,
            256,
            255).put(aTags, ALKALINE_EARTH_METAL, MOLTEN);
    }

    static OreDictMaterial lanthanide(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        TagData... aTags) {
        return metal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            256,
            256,
            256,
            255).put(aTags, LANTHANIDE);
    }

    static OreDictMaterial actinide(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        TagData... aTags) {
        return metal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            256,
            256,
            256,
            255).put(aTags, ACTINIDE);
    }

    static OreDictMaterial transmetal(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        TagData... aTags) {
        return metal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            256,
            256,
            256,
            255).put(aTags, TRANSITION_METAL);
    }

    static OreDictMaterial posttrans(int aID, String aNameOreDict, String aSymbol, long aProtonsAndElectrons,
        long aNeutrons, long aMeltingPoint, long aBoilingPoint, double aGramPerCubicCentimeter, TextureSet[] aSets,
        TagData... aTags) {
        return metal(
            aID,
            aNameOreDict,
            aSymbol,
            aProtonsAndElectrons,
            aNeutrons,
            aMeltingPoint,
            aBoilingPoint,
            aGramPerCubicCentimeter,
            aSets,
            256,
            256,
            256,
            255).put(aTags, POST_TRANSITION_METAL);
    }

    /**
     * Making the Table a little bit more overviewable. DO NOT USE THESE FUNCTIONS YOURSELF!!! Use
     * "OreDictMaterial.createMaterial(YOUR-ID-AS-SPECIFIED-IN-THE-ID-RANGES, OREDICT-NAME, LOCALISED-NAME)"
     */
    static OreDictMaterial dcmp(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial cent(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return dcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial elec(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return dcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial gas(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(G_CONTAINERS, CONTAINERS_GAS);
    }

    static OreDictMaterial gasdcmp(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gas(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial gasflam(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gas(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial gasexpl(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gas(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial gascent(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gasdcmp(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial gaselec(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gasdcmp(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial lqud(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(G_CONTAINERS, CONTAINERS_FLUID);
    }

    static OreDictMaterial lqudflam(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return lqud(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(FLAMMABLE);
    }

    static OreDictMaterial lqudexpl(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return lqud(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(FLAMMABLE, EXPLOSIVE);
    }

    static OreDictMaterial lquddcmp(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return lqud(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial lqudcent(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return lquddcmp(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial lqudelec(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return lquddcmp(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial gaschem(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(G_CONTAINERS, CONTAINERS_GAS);
    }

    static OreDictMaterial gaschemdcmp(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gaschem(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial gaschemflam(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gaschem(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(FLAMMABLE);
    }

    static OreDictMaterial gaschemexpl(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gaschem(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(FLAMMABLE, EXPLOSIVE);
    }

    static OreDictMaterial gaschemcent(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gaschemdcmp(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial gaschemelec(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gaschemdcmp(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial lqudchem(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(G_CONTAINERS, CONTAINERS_FLUID);
    }

    static OreDictMaterial lqudchemdcmp(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return lqudchem(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial lqudchemflam(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return lqudchem(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(FLAMMABLE);
    }

    static OreDictMaterial lqudchemexpl(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return lqudchem(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(FLAMMABLE, EXPLOSIVE);
    }

    static OreDictMaterial lqudchemcent(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return lqudchemdcmp(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial lqudchemelec(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return lqudchemdcmp(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial gasacid(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(G_CONTAINERS, CONTAINERS_GAS, ACID);
    }

    static OreDictMaterial gasaciddcmp(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gasacid(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial gasacidflam(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gasacid(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(FLAMMABLE);
    }

    static OreDictMaterial gasacidexpl(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gasacid(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(FLAMMABLE, EXPLOSIVE);
    }

    static OreDictMaterial gasacidcent(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gasaciddcmp(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial gasacidelec(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gasaciddcmp(aID, aNameOreDict, SET_GAS, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial lqudacid(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData)
            .put(G_CONTAINERS, CONTAINERS_FLUID, ACID);
    }

    static OreDictMaterial lqudaciddcmp(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return lqudacid(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial lqudacidflam(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return lqudacid(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(FLAMMABLE);
    }

    static OreDictMaterial lqudacidexpl(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return lqudacid(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(FLAMMABLE, EXPLOSIVE);
    }

    static OreDictMaterial lqudacidcent(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return lqudaciddcmp(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial lqudacidelec(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return lqudaciddcmp(aID, aNameOreDict, SET_FLUID, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial gas(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(G_CONTAINERS, CONTAINERS_GAS);
    }

    static OreDictMaterial gasdcmp(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gas(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial gascent(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gasdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial gaselec(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gasdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial lqud(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(G_CONTAINERS, CONTAINERS_FLUID);
    }

    static OreDictMaterial lquddcmp(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return lqud(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial lqudcent(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return lquddcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial lqudelec(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return lquddcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial gaschem(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(G_CONTAINERS, CONTAINERS_GAS);
    }

    static OreDictMaterial gaschemdcmp(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return gaschem(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial gaschemcent(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return gaschemdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial gaschemelec(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return gaschemdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial lqudchem(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(G_CONTAINERS, CONTAINERS_FLUID);
    }

    static OreDictMaterial lqudchemdcmp(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return lqudchem(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial lqudchemcent(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return lqudchemdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial lqudchemelec(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return lqudchemdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial gasacid(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(G_CONTAINERS, CONTAINERS_GAS, ACID);
    }

    static OreDictMaterial gasaciddcmp(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return gasacid(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial gasacidcent(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return gasaciddcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial gasacidelec(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return gasaciddcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial lqudacid(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(G_CONTAINERS, CONTAINERS_FLUID, ACID);
    }

    static OreDictMaterial lqudaciddcmp(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return lqudacid(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial lqudacidcent(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return lqudaciddcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial lqudacidelec(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return lqudaciddcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    /**
     * Making the Table a little bit more overviewable. DO NOT USE THESE FUNCTIONS YOURSELF!!! Use
     * "OreDictMaterial.createMaterial(YOUR-ID-AS-SPECIFIED-IN-THE-ID-RANGES, OREDICT-NAME, LOCALISED-NAME)"
     */
    static OreDictMaterial dust(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(G_DUST, MORTAR)
            .setPriorityPrefix(2);
    }

    static OreDictMaterial dustdcmp(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return dust(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial dustcent(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return dustdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial dustelec(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return dustdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial glowstone(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return oredustcent(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData)
            .put(
                PLATES,
                STICKS,
                MORTAR,
                BRITTLE,
                MELTING,
                CRYSTAL,
                CRYSTALLISABLE,
                G_GEM_ORES_TRANSPARENT,
                ANY.Glowstone,
                MOLTEN,
                GLOWING,
                LIGHTING)
            .setPriorityPrefix(2)
            .setOreMultiplier(4);
    }

    static OreDictMaterial redstone(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return oredustcent(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData)
            .put(PLATES, STICKS, MORTAR, BRITTLE, MELTING, CRYSTAL, CRYSTALLISABLE, G_GEM_ORES_TRANSPARENT)
            .setPriorityPrefix(2)
            .setOreMultiplier(4);
    }

    static OreDictMaterial coal(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return elec(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData)
            .put(G_GEM_ORES, BRITTLE, FLAMMABLE, MORTAR, INGOTS, COAL)
            .setPriorityPrefix(1);
    }

    static OreDictMaterial wax(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return dust(aID, aNameOreDict, SET_FOOD, aR, aG, aB, aA, aRandomData)
            .put(ANY.Wax, FOILS, PLATES, INGOTS, PARTS, FURNACE, MELTING, BRITTLE, MORTAR, EXTRUDER, EXTRUDER_SIMPLE);
    }

    static OreDictMaterial meat(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return dustfood(aID, aNameOreDict, SET_FINE, aR, aG, aB, aA, aRandomData)
            .put(MEAT, INGOTS, MELTING, EXTRUDER, EXTRUDER_SIMPLE);
    }

    static OreDictMaterial grain(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return dustfood(aID, aNameOreDict, SET_POWDER, aR, aG, aB, aA, aRandomData)
            .put(ANY.Grains, ANY.FlourGrains, FLAMMABLE)
            .aspects(TC.MESSIS, 2)
            .setBurning(Ash, U9);
    }

    static OreDictMaterial food(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(FOOD, MORTAR);
    }

    static OreDictMaterial orefood(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return oredust(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(FOOD, MORTAR);
    }

    static OreDictMaterial dustfood(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return dust(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(FOOD, MORTAR);
    }

    static OreDictMaterial mixfood(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return mixdust(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(FOOD, MORTAR);
    }

    static OreDictMaterial food(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, SET_FOOD, aR, aG, aB, aA, aRandomData).put(FOOD, MORTAR);
    }

    static OreDictMaterial orefood(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return oredust(aID, aNameOreDict, SET_FINE, aR, aG, aB, aA, aRandomData).put(FOOD, MORTAR);
    }

    static OreDictMaterial dustfood(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return dust(aID, aNameOreDict, SET_FINE, aR, aG, aB, aA, aRandomData).put(FOOD, MORTAR);
    }

    static OreDictMaterial mixfood(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return mixdust(aID, aNameOreDict, SET_FINE, aR, aG, aB, aA, aRandomData).put(FOOD, MORTAR);
    }

    static OreDictMaterial dye(int aID, String aNameOreDict, long aR, long aG, long aB, Object... aRandomData) {
        return dust(aID, aNameOreDict, SET_FOOD, aR, aG, aB, 255, aRandomData).aspects(TC.SENSUS, 1)
            .put(DONT_SHOW_THIS_COMPONENT);
    }

    static OreDictMaterial quartz(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, SET_QUARTZ, aR, aG, aB, aA, aRandomData)
            .put(G_QUARTZ_ORES, ANY.Quartz, ANY.SiO2, MORTAR, BRITTLE, QUARTZ, BLACKLISTED_SMELTER)
            .setSmelting(SiO2, U)
            .setPriorityPrefix(1)
            .setOreMultiplier(2);
    }

    static OreDictMaterial gem(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(G_GEM_ORES)
            .setPriorityPrefix(1);
    }

    static OreDictMaterial gemdcmp(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gem(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial gemcent(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gemdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial gemelec(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gemdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial stonedcmp(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return stone(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial stonecent(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return stonedcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial stoneelec(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return stonedcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial stone(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return stone(aID, aNameOreDict, SET_STONE, aR, aG, aB, aA, aRandomData);
    }

    static OreDictMaterial stonedcmp(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return stonedcmp(aID, aNameOreDict, SET_STONE, aR, aG, aB, aA, aRandomData);
    }

    static OreDictMaterial stonecent(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return stonecent(aID, aNameOreDict, SET_STONE, aR, aG, aB, aA, aRandomData);
    }

    static OreDictMaterial stoneelec(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return stoneelec(aID, aNameOreDict, SET_STONE, aR, aG, aB, aA, aRandomData);
    }

    static OreDictMaterial brickdcmp(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return stone(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial brickcent(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return brickdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial brickelec(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return brickdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial brick(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return stone(aID, aNameOreDict, SET_BRICK, aR, aG, aB, aA, aRandomData);
    }

    static OreDictMaterial brickdcmp(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return brickdcmp(aID, aNameOreDict, SET_BRICK, aR, aG, aB, aA, aRandomData);
    }

    static OreDictMaterial brickcent(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return brickcent(aID, aNameOreDict, SET_BRICK, aR, aG, aB, aA, aRandomData);
    }

    static OreDictMaterial brickelec(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return brickelec(aID, aNameOreDict, SET_BRICK, aR, aG, aB, aA, aRandomData);
    }

    static OreDictMaterial crystal(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(G_GEM_ORES_TRANSPARENT, CRYSTAL)
            .setPriorityPrefix(1);
    }

    static OreDictMaterial crystaldcmp(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return crystal(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial crystalcent(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return crystaldcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial crystalelec(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return crystaldcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial crystal_tc(int aID, String aNameOreDict, long aR, long aG, long aB, byte aColor,
        Object... aRandomData) {
        return crystal(aID, aNameOreDict, SET_SHARDS, aR, aG, aB, 255, aRandomData).lens(aColor)
            .put(MD.TC, ANY.ThaumCrystal, COMMON_ORE, MAGICAL, UNBURNABLE)
            .handle(ANY.WoodMagical)
            .setOreMultiplier(2)
            .visDefault();
    }

    static OreDictMaterial hexorium(int aID, long aR, long aG, long aB, byte aColor, Object... aRandomData) {
        return crystal(aID, "Hexorium" + DYE_NAMES[aColor], SET_HEX, aR, aG, aB, 127, aRandomData).lens(aColor)
            .put(MD.HEX, ANY.Hexorium, COMMON_ORE, GLOWING, MORTAR, BRITTLE, CRYSTALLISABLE, BLACKLISTED_SMELTER)
            .setSmelting(null, 0)
            .setOreMultiplier(aColor == DYE_INDEX_Black || aColor == DYE_INDEX_White ? 3 : 4)
            .aspects(
                TC.VITREUS,
                3,
                aColor == DYE_INDEX_Black ? TC.TENEBRAE : aColor == DYE_INDEX_White ? TC.LUX : TC.SENSUS,
                4)
            .setLocal(DYE_NAMES[aColor] + " Hexorium")
            .qual(2, 5.0, aColor == DYE_INDEX_Black ? 512 : aColor == DYE_INDEX_White ? 384 : 256, 2)
            .visDefault();
    }

    static OreDictMaterial valgem(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return gem(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData)
            .put(G_GEM_ORES_TRANSPARENT, CRYSTAL, VALUABLE);
    }

    static OreDictMaterial valgemdcmp(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return valgem(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE)
            .setSmelting(null, 0);
    }

    static OreDictMaterial valgemcent(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return valgemdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial valgemelec(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return valgemdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial diamond(int aID, String aNameOreDict, long aR, long aG, long aB, byte aColor,
        Object... aRandomData) {
        return valgemdcmp(aID, aNameOreDict, SET_DIAMOND, aR, aG, aB, 127, aRandomData).lens(aColor)
            .put(ANY.Diamond, COMMON_ORE)
            .steal(C)
            .aspects(TC.VITREUS, 3, TC.LUCRUM, 4)
            .qual(3, 8.0, 1280, 3)
            .setSmelting(C, 2 * U)
            .setBurning(Ash, U);
    }

    static OreDictMaterial sapphire(int aID, String aNameOreDict, long aR, long aG, long aB, byte aColor,
        Object... aRandomData) {
        return valgemcent(aID, aNameOreDict, SET_GEM_VERTICAL, aR, aG, aB, 127, aRandomData).lens(aColor)
            .put(ANY.Sapphire, COMMON_ORE, MELTING, RANDOM_SMALL_GEM_ORE)
            .aspects(TC.VITREUS, 3, TC.LUCRUM, 4)
            .qual(3, 7.0, 512, 3)
            .setSmelting(Al2O3, 3 * U4)
            .addSourceOf(Al);
    }

    static OreDictMaterial emerald(int aID, String aNameOreDict, long aR, long aG, long aB, byte aColor,
        Object... aRandomData) {
        return valgemelec(aID, aNameOreDict, SET_EMERALD, aR, aG, aB, 127, aRandomData).lens(aColor)
            .put(ANY.Emerald, COMMON_ORE, MELTING, RANDOM_SMALL_GEM_ORE)
            .aspects(TC.VITREUS, 3, TC.LUCRUM, 3)
            .qual(3, 9.0, 128, 2)
            .setSmelting(Be, U36)
            .addSourceOf(Be);
    }

    static OreDictMaterial garnet(int aID, String aNameOreDict, long aR, long aG, long aB, byte aColor,
        Object... aRandomData) {
        return valgemelec(aID, aNameOreDict, SET_RUBY, aR, aG, aB, 127, aRandomData).lens(aColor)
            .put(ANY.Garnet, MD.GT, RANDOM_SMALL_GEM_ORE)
            .aspects(TC.VITREUS, 3, TC.LUCRUM, 1)
            .qual(3, 7.0, 128, 2);
    }

    static OreDictMaterial jasper(int aID, String aNameOreDict, long aR, long aG, long aB, byte aColor,
        Object... aRandomData) {
        return valgemelec(aID, aNameOreDict, SET_GLASS, aR, aG, aB, 150, aRandomData).lens(aColor)
            .put(ANY.Jasper, MD.RH, RANDOM_SMALL_GEM_ORE)
            .aspects(TC.VITREUS, 2, TC.LUCRUM, 2, TC.METALLUM, 1)
            .qual(3, 7.0, 256, 2)
            .uumMcfg(0, SiO2, 2 * U, Fe, 1 * U);
    }

    static OreDictMaterial tigereye(int aID, String aNameOreDict, long aR, long aG, long aB, byte aColor,
        Object... aRandomData) {
        return valgemelec(aID, aNameOreDict, SET_GLASS, aR, aG, aB, 200, aRandomData).lens(aColor)
            .put(ANY.TigerEye, MD.RH, RANDOM_SMALL_GEM_ORE)
            .aspects(TC.VITREUS, 2, TC.LUCRUM, 1, TC.TERRA, 1)
            .qual(3, 7.0, 256, 2)
            .uumMcfg(0, SiO2, 1 * U);
    }

    static OreDictMaterial aventurine(int aID, String aNameOreDict, long aR, long aG, long aB, byte aColor,
        Object... aRandomData) {
        return valgemelec(aID, aNameOreDict, SET_GLASS, aR, aG, aB, 200, aRandomData).lens(aColor)
            .put(ANY.Aventurine, MD.RH, RANDOM_SMALL_GEM_ORE)
            .aspects(TC.VITREUS, 2, TC.LUCRUM, 1, TC.POTENTIA, 1)
            .qual(3, 7.0, 256, 2)
            .uumMcfg(0, SiO2, 1 * U);
    }

    static OreDictMaterial fluorite(int aID, String aNameOreDict, long aR, long aG, long aB, Object... aRandomData) {
        return gem(aID, aNameOreDict, SET_RUBY, aR, aG, aB, 255, aRandomData)
            .put(ANY.CaF2, COMMON_ORE, MD.ReC, RANDOM_SMALL_GEM_ORE)
            .aspects(TC.VITREUS, 2, TC.VENEMUM, 2)
            .uumMcfg(0, Ca, 1 * U, F, 2 * U)
            .addSourceOf(F)
            .heat(1633)
            .put(DECOMPOSABLE, ACID, MELTING, MORTAR, BRITTLE, CRYSTALLISABLE)
            .setSmelting("Fluorite".equals(aNameOreDict) ? null : CaF2, U);
    }

    static OreDictMaterial blaze(int aID, String aNameOreDict, long aR, long aG, long aB, Object... aRandomData) {
        return create(aID, aNameOreDict, SET_POWDER, aR, aG, aB, 255, aRandomData).put(ANY.Blaze, COMMON_ORE)
            .aspects(TC.PRAECANTIO, 2)
            .qual(1, 2.0, 16, 1)
            .handle(ANY.Blaze)
            .put(G_BLAZE, GLOWING, MAGICAL, BRITTLE, MORTAR);
    }

    static OreDictMaterial clay(int aID, String aNameOreDict, long aR, long aG, long aB, OreDictMaterial aTrace,
        Object... aRandomData) {
        return oredustelec(aID, aNameOreDict, SET_ROUGH, aR, aG, aB, 255, aRandomData).put(ANY.Clay, MORTAR, PLATES)
            .aspects(TC.TERRA, 1)
            .uumMcfg(18, aTrace, 1 * U, Clay, 18 * U)
            .heat(2000)
            .setSmelting(Ceramic, U);
    }

    static OreDictMaterial mix(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return dcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial mixdust(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return dustcent(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData);
    }

    static OreDictMaterial oredust(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(G_DUST_ORES);
    }

    static OreDictMaterial oredustdcmp(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return oredust(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(DECOMPOSABLE);
    }

    static OreDictMaterial oredustcent(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return oredustdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(CENTRIFUGE);
    }

    static OreDictMaterial oredustelec(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return oredustdcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ELECTROLYSER);
    }

    static OreDictMaterial metal_(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(G_INGOT, SMITHABLE, MELTING, EXTRUDER);
    }

    static OreDictMaterial metalore_(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return metal(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(G_INGOT_ORES);
    }

    static OreDictMaterial metalmachine_(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return metal(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(G_INGOT_MACHINE);
    }

    static OreDictMaterial metalmachore_(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(G_INGOT_MACHINE_ORES);
    }

    static OreDictMaterial metal_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, aA, aRandomData)
            .put(G_INGOT, SMITHABLE, MELTING, EXTRUDER);
    }

    static OreDictMaterial metalore_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, aA, aRandomData).put(G_INGOT_ORES);
    }

    static OreDictMaterial metalmachine_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, aA, aRandomData).put(G_INGOT_MACHINE);
    }

    static OreDictMaterial metalmachore_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, aA, aRandomData).put(G_INGOT_MACHINE_ORES);
    }

    static OreDictMaterial setal_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, SET_SHINY, aR, aG, aB, aA, aRandomData)
            .put(G_INGOT, SMITHABLE, MELTING, EXTRUDER);
    }

    static OreDictMaterial setalore_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_SHINY, aR, aG, aB, aA, aRandomData).put(G_INGOT_ORES);
    }

    static OreDictMaterial setalmachine_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_SHINY, aR, aG, aB, aA, aRandomData).put(G_INGOT_MACHINE);
    }

    static OreDictMaterial setalmachore_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, SET_SHINY, aR, aG, aB, aA, aRandomData).put(G_INGOT_MACHINE_ORES);
    }

    static OreDictMaterial cetal_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, SET_COPPER, aR, aG, aB, aA, aRandomData)
            .put(G_INGOT, SMITHABLE, MELTING, EXTRUDER);
    }

    static OreDictMaterial cetalore_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_COPPER, aR, aG, aB, aA, aRandomData).put(G_INGOT_ORES);
    }

    static OreDictMaterial cetalmachine_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_COPPER, aR, aG, aB, aA, aRandomData).put(G_INGOT_MACHINE);
    }

    static OreDictMaterial cetalmachore_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, SET_COPPER, aR, aG, aB, aA, aRandomData).put(G_INGOT_MACHINE_ORES);
    }

    static OreDictMaterial alloy_(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloyore_(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return metalore(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloymachine_(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloymachore_(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return metalmachore(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloy_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloyore_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metalore(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloymachine_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloymachore_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metalmachore(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial slloy_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_SHINY, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial slloyore_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metalore(aID, aNameOreDict, SET_SHINY, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial slloymachine_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, SET_SHINY, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial slloymachore_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metalmachore(aID, aNameOreDict, SET_SHINY, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial clloy_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_COPPER, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial clloyore_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metalore(aID, aNameOreDict, SET_COPPER, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial clloymachine_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, SET_COPPER, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial clloymachore_(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metalmachore(aID, aNameOreDict, SET_COPPER, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial metalnd(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData)
            .put(G_INGOT_ND, SMITHABLE, MELTING, EXTRUDER);
    }

    static OreDictMaterial metalmachnd(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return metalnd(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(G_INGOT_ND_MACHINE);
    }

    static OreDictMaterial alloynd(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return metalnd(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloymachnd(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        long aA, Object... aRandomData) {
        return metalmachnd(aID, aNameOreDict, aSets, aR, aG, aB, aA, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial metal(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, 255, aRandomData)
            .put(G_INGOT, SMITHABLE, MELTING, EXTRUDER);
    }

    static OreDictMaterial metalore(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, aSets, aR, aG, aB, aRandomData).put(G_INGOT_ORES);
    }

    static OreDictMaterial metalmachine(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, aSets, aR, aG, aB, aRandomData).put(G_INGOT_MACHINE);
    }

    static OreDictMaterial metalmachore(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, aSets, aR, aG, aB, aRandomData).put(G_INGOT_MACHINE_ORES);
    }

    static OreDictMaterial metal(int aID, String aNameOreDict, long aR, long aG, long aB, Object... aRandomData) {
        return create(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, 255, aRandomData)
            .put(G_INGOT, SMITHABLE, MELTING, EXTRUDER);
    }

    static OreDictMaterial metalore(int aID, String aNameOreDict, long aR, long aG, long aB, Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, aRandomData).put(G_INGOT_ORES);
    }

    static OreDictMaterial metalmachine(int aID, String aNameOreDict, long aR, long aG, long aB,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, aRandomData).put(G_INGOT_MACHINE);
    }

    static OreDictMaterial metalmachore(int aID, String aNameOreDict, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, aRandomData).put(G_INGOT_MACHINE_ORES);
    }

    static OreDictMaterial setal(int aID, String aNameOreDict, long aR, long aG, long aB, Object... aRandomData) {
        return create(aID, aNameOreDict, SET_SHINY, aR, aG, aB, 255, aRandomData)
            .put(G_INGOT, SMITHABLE, MELTING, EXTRUDER);
    }

    static OreDictMaterial setalore(int aID, String aNameOreDict, long aR, long aG, long aB, Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_SHINY, aR, aG, aB, aRandomData).put(G_INGOT_ORES);
    }

    static OreDictMaterial setalmachine(int aID, String aNameOreDict, long aR, long aG, long aB,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_SHINY, aR, aG, aB, aRandomData).put(G_INGOT_MACHINE);
    }

    static OreDictMaterial setalmachore(int aID, String aNameOreDict, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, SET_SHINY, aR, aG, aB, aRandomData).put(G_INGOT_MACHINE_ORES);
    }

    static OreDictMaterial cetal(int aID, String aNameOreDict, long aR, long aG, long aB, Object... aRandomData) {
        return create(aID, aNameOreDict, SET_COPPER, aR, aG, aB, 255, aRandomData)
            .put(G_INGOT, SMITHABLE, MELTING, EXTRUDER);
    }

    static OreDictMaterial cetalore(int aID, String aNameOreDict, long aR, long aG, long aB, Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_COPPER, aR, aG, aB, aRandomData).put(G_INGOT_ORES);
    }

    static OreDictMaterial cetalmachine(int aID, String aNameOreDict, long aR, long aG, long aB,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_COPPER, aR, aG, aB, aRandomData).put(G_INGOT_MACHINE);
    }

    static OreDictMaterial cetalmachore(int aID, String aNameOreDict, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, SET_COPPER, aR, aG, aB, aRandomData).put(G_INGOT_MACHINE_ORES);
    }

    static OreDictMaterial alloy(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        Object... aRandomData) {
        return metal(aID, aNameOreDict, aSets, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloyore(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalore(aID, aNameOreDict, aSets, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloymachine(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, aSets, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloymachore(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalmachore(aID, aNameOreDict, aSets, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloy(int aID, String aNameOreDict, long aR, long aG, long aB, Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloyore(int aID, String aNameOreDict, long aR, long aG, long aB, Object... aRandomData) {
        return metalore(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloymachine(int aID, String aNameOreDict, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloymachore(int aID, String aNameOreDict, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalmachore(aID, aNameOreDict, SET_METALLIC, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial slloy(int aID, String aNameOreDict, long aR, long aG, long aB, Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_SHINY, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial slloyore(int aID, String aNameOreDict, long aR, long aG, long aB, Object... aRandomData) {
        return metalore(aID, aNameOreDict, SET_SHINY, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial slloymachine(int aID, String aNameOreDict, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, SET_SHINY, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial slloymachore(int aID, String aNameOreDict, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalmachore(aID, aNameOreDict, SET_SHINY, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial clloy(int aID, String aNameOreDict, long aR, long aG, long aB, Object... aRandomData) {
        return metal(aID, aNameOreDict, SET_COPPER, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial clloyore(int aID, String aNameOreDict, long aR, long aG, long aB, Object... aRandomData) {
        return metalore(aID, aNameOreDict, SET_COPPER, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial clloymachine(int aID, String aNameOreDict, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalmachine(aID, aNameOreDict, SET_COPPER, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial clloymachore(int aID, String aNameOreDict, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalmachore(aID, aNameOreDict, SET_COPPER, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial metalnd(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        Object... aRandomData) {
        return create(aID, aNameOreDict, aSets, aR, aG, aB, 255, aRandomData)
            .put(G_INGOT_ND, SMITHABLE, MELTING, EXTRUDER);
    }

    static OreDictMaterial metalmachnd(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalnd(aID, aNameOreDict, aSets, aR, aG, aB, aRandomData).put(G_INGOT_ND_MACHINE);
    }

    static OreDictMaterial alloynd(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalnd(aID, aNameOreDict, aSets, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial alloymachnd(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB,
        Object... aRandomData) {
        return metalmachnd(aID, aNameOreDict, aSets, aR, aG, aB, aRandomData).put(ALLOY, DECOMPOSABLE);
    }

    static OreDictMaterial wood(int aID, String aNameOreDict, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        return wood(aID, aNameOreDict, SET_WOOD, aR, aG, aB, aA, aRandomData);
    }

    /**
     * Making the Table a little bit more overviewable. DO NOT USE THESE FUNCTIONS YOURSELF!!! Use
     * "OreDictMaterial.createMaterial(YOUR-ID-AS-SPECIFIED-IN-THE-ID-RANGES, OREDICT-NAME, LOCALISED-NAME)"
     */
    static OreDictMaterial wood(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        OreDictMaterial rMaterial = create(
            aID,
            aNameOreDict,
            aSets,
            aR,
            aG,
            aB,
            aA,
            aRandomData,
            G_WOOD,
            ANY.Wood,
            ANY.WoodPlastic,
            WOOD,
            MORTAR);
        String tPlank = "plank" + rMaterial.mNameInternal;
        OreDictManager.INSTANCE.addAutoBlackListing(tPlank);
        OreDictManager.INSTANCE.addReRegistration(tPlank, OD.plankAnyWood);
        if ("Wood".equalsIgnoreCase(rMaterial.mNameInternal)) return rMaterial;
        OreDictManager.INSTANCE.setAutomaticItemData(tPlank, new OreDictItemData(rMaterial, U));
        OreDictManager.INSTANCE.addReRegistrationWithReversal("plate" + rMaterial.mNameInternal, tPlank);
        return rMaterial;
    }

    /**
     * Making the Table a little bit more overviewable. DO NOT USE THESE FUNCTIONS YOURSELF!!! Use
     * "OreDictMaterial.createMaterial(YOUR-ID-AS-SPECIFIED-IN-THE-ID-RANGES, OREDICT-NAME, LOCALISED-NAME)"
     */
    static OreDictMaterial woodnormal(int aID, String aNameOreDict, String aLocal, long aR, long aG, long aB,
        double aSpeed, long aDurability, Object... aRandomData) {
        OreDictMaterial rMaterial = create(
            aID,
            aNameOreDict,
            SET_WOOD,
            aR,
            aG,
            aB,
            255,
            aRandomData,
            G_WOOD,
            ANY.Wood,
            ANY.WoodPlastic,
            ANY.WoodNormal,
            ANY.WoodDefault,
            ANY.WoodUntreated,
            WOOD,
            MORTAR,
            TICKS_PER_SMELT / 2,
            FLAMMABLE,
            APPROXIMATE).setLocal(aLocal)
                .uumMcfg(0, C, 6 * U, H2O, 15 * U)
                .aspects(TC.ARBOR, 1)
                .setBurning(Ash, U9)
                .setSmelting(Ash, U4)
                .qual(1, aSpeed, aDurability, 0)
                .heat(400, 500);
        String tPlank = "plank" + rMaterial.mNameInternal, tStick = "stick" + rMaterial.mNameInternal;
        OreDictManager.INSTANCE.addAutoBlackListing(tPlank);
        OreDictManager.INSTANCE.addReRegistration(tStick, OD.stickWood);
        OreDictManager.INSTANCE.addReRegistration(tPlank, OD.plankWood);
        OreDictManager.INSTANCE.setAutomaticItemData(tPlank, new OreDictItemData(rMaterial, U));
        OreDictManager.INSTANCE.addReRegistrationWithReversal("plate" + rMaterial.mNameInternal, tPlank);
        return rMaterial;
    }

    /**
     * Making the Table a little bit more overviewable. DO NOT USE THESE FUNCTIONS YOURSELF!!! Use
     * "OreDictMaterial.createMaterial(YOUR-ID-AS-SPECIFIED-IN-THE-ID-RANGES, OREDICT-NAME, LOCALISED-NAME)"
     */
    static OreDictMaterial stone(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        Object... aRandomData) {
        OreDictMaterial rMaterial = create(
            aID,
            aNameOreDict,
            aSets,
            aR,
            aG,
            aB,
            aA,
            aRandomData,
            G_STONE,
            ANY.Stone,
            STONE,
            BRITTLE,
            MORTAR,
            FURNACE,
            EXTRUDER,
            EXTRUDER_SIMPLE);
        String tStone = "stone" + rMaterial.mNameInternal;
        OreDictManager.INSTANCE.addAutoBlackListing(tStone);
        OreDictManager.INSTANCE.setAutomaticItemData(
            tStone,
            new OreDictItemData(rMaterial, "stoneNetherbrick".equalsIgnoreCase(tStone) ? U * 4 : U * 9));
        return rMaterial;
    }

    /**
     * Making the Table a little bit more overviewable. DO NOT USE THESE FUNCTIONS YOURSELF!!! Use
     * "OreDictMaterial.createMaterial(YOUR-ID-AS-SPECIFIED-IN-THE-ID-RANGES, OREDICT-NAME, LOCALISED-NAME)"
     */
    static OreDictMaterial gem_aa(int aID, String aNameOreDict, TextureSet[] aSets, long aR, long aG, long aB, long aA,
        OreDictMaterial aCopy, Object... aRandomData) {
        return dcmp(aID, aNameOreDict, aSets, aR, aG, aB, aA, G_GEM_TRANSPARENT, CRYSTAL, BRITTLE, MD.AA)
            .uumMcfg(0, aCopy, U)
            .steal(aCopy)
            .setAllToTheOutputOf(aCopy)
            .visDefault();
    }

    /**
     * Making the Table a little bit more overviewable. DO NOT USE THESE FUNCTIONS YOURSELF!!! Use
     * "OreDictMaterial.createMaterial(YOUR-ID-AS-SPECIFIED-IN-THE-ID-RANGES, OREDICT-NAME, LOCALISED-NAME)"
     */
    static OreDictMaterial unknown(int aID, long aNeutrons, Object... aRandomData) {
        int aProtonsAndElectrons = aID / 10;
        String aNameOreDict, aSymbol;

        switch (aProtonsAndElectrons / 100) {
            case 1:
                aNameOreDict = "Un";
                aSymbol = "U";
                break;
            case 2:
                aNameOreDict = "Bi";
                aSymbol = "B";
                break;
            case 3:
                aNameOreDict = "Tri";
                aSymbol = "T";
                break;
            case 4:
                aNameOreDict = "Quad";
                aSymbol = "Q";
                break;
            case 5:
                aNameOreDict = "Pent";
                aSymbol = "P";
                break;
            case 6:
                aNameOreDict = "Hex";
                aSymbol = "H";
                break;
            case 7:
                aNameOreDict = "Sept";
                aSymbol = "S";
                break;
            case 8:
                aNameOreDict = "Oct";
                aSymbol = "O";
                break;
            case 9:
                aNameOreDict = "Enn";
                aSymbol = "E";
                break;
            default:
                throw new IllegalArgumentException("Disallowed Parameter");
        }
        switch ((aProtonsAndElectrons / 10) % 10) {
            case 0:
                aNameOreDict += "nil";
                aSymbol += "n";
                break;
            case 1:
                aNameOreDict += "un";
                aSymbol += "u";
                break;
            case 2:
                aNameOreDict += "bi";
                aSymbol += "b";
                break;
            case 3:
                aNameOreDict += "tri";
                aSymbol += "t";
                break;
            case 4:
                aNameOreDict += "quad";
                aSymbol += "q";
                break;
            case 5:
                aNameOreDict += "pent";
                aSymbol += "p";
                break;
            case 6:
                aNameOreDict += "hex";
                aSymbol += "h";
                break;
            case 7:
                aNameOreDict += "sept";
                aSymbol += "s";
                break;
            case 8:
                aNameOreDict += "oct";
                aSymbol += "o";
                break;
            case 9:
                aNameOreDict += "enn";
                aSymbol += "e";
                break;
        }
        switch (aProtonsAndElectrons % 10) {
            case 0:
                aNameOreDict += "nilium";
                aSymbol += "n";
                break;
            case 1:
                aNameOreDict += "unium";
                aSymbol += "u";
                break;
            case 2:
                aNameOreDict += "bium";
                aSymbol += "b";
                break;
            case 3:
                aNameOreDict += "trium";
                aSymbol += "t";
                break;
            case 4:
                aNameOreDict += "quadium";
                aSymbol += "q";
                break;
            case 5:
                aNameOreDict += "pentium";
                aSymbol += "p";
                break;
            case 6:
                aNameOreDict += "hexium";
                aSymbol += "h";
                break;
            case 7:
                aNameOreDict += "septium";
                aSymbol += "s";
                break;
            case 8:
                aNameOreDict += "octium";
                aSymbol += "o";
                break;
            case 9:
                aNameOreDict += "ennium";
                aSymbol += "e";
                break;
        }
        return element(aID, aNameOreDict, aSymbol, aProtonsAndElectrons, aNeutrons, 1000, 3000, 0, SET_RAD)
            .put(aRandomData)
            .hide()
            .aspects(TC.RADIO, aProtonsAndElectrons / 50);
    }

    static OreDictMaterial hydrogen() {
        return diatomicgas(10, "Hydrogen", "H", 1, 0, 14, 20, 0.00008988, SET_DULL, 0, 0, 255, 15, UUM, CONTAINERS_GAS)
            .aspects(TC.AQUA, 1);
    }

    static OreDictMaterial deuterium() {
        return diatomicgas(
            11,
            "Deuterium",
            "D",
            1,
            1,
            14,
            20,
            0.00008988,
            SET_RAD,
            255,
            255,
            0,
            15,
            FUSION,
            CONTAINERS_GAS).aspects(TC.AQUA, 2);
    }

    static OreDictMaterial tritium() {
        return diatomicgas(12, "Tritium", "T", 1, 2, 14, 20, 0.00008988, SET_RAD, 255, 0, 0, 15, FUSION, CONTAINERS_GAS)
            .aspects(TC.AQUA, 3);
    }

    static OreDictMaterial helium() {
        return noblegas(
            20,
            "Helium",
            "He",
            2,
            2,
            1,
            4,
            0.0001785,
            SET_SHINY,
            255,
            255,
            120,
            UUM,
            FUSION,
            CONTAINERS_GAS).aspects(TC.AER, 2);
    }

    static OreDictMaterial helium3() {
        return noblegas(21, "Helium-3", "He-3", 2, 1, 1, 4, 0.0001785, SET_RAD, 255, 255, 140, FUSION, CONTAINERS_GAS)
            .aspects(TC.AER, 3);
    }

    static OreDictMaterial lithium() {
        return alkali(
            30,
            "Lithium",
            "Li",
            3,
            4,
            453,
            1560,
            0.534,
            SET_ROUGH,
            225,
            220,
            255,
            UUM,
            FUSION,
            TICKS_PER_SMELT * 10,
            WASHING_MERCURY).aspects(TC.VITREUS, 1, TC.POTENTIA, 2);
    }

    static OreDictMaterial lithium6() {
        return alkali(
            31,
            "Lithium-6",
            "Li-6",
            3,
            3,
            453,
            1560,
            0.534,
            SET_RAD,
            230,
            225,
            255,
            FUSION,
            TICKS_PER_SMELT * 10,
            WASHING_MERCURY).aspects(TC.VITREUS, 1, TC.POTENTIA, 1, TC.RADIO, 1);
    }

    static OreDictMaterial beryllium() {
        return alkaline(
            40,
            "Beryllium",
            "Be",
            4,
            5,
            1560,
            2742,
            1.85,
            SET_METALLIC,
            100,
            180,
            100,
            UUM,
            FUSION,
            G_INGOT_ORES,
            MORTAR).aspects(TC.METALLUM, 2, TC.LUCRUM, 1);
    }

    static OreDictMaterial beryllium7() {
        return alkaline(41, "Beryllium-7", "Be-7", 4, 3, 1560, 2742, 1.85, SET_RAD, 110, 190, 110, FUSION, G_INGOT_ORES)
            .aspects(TC.METALLUM, 2, TC.LUCRUM, 1, TC.RADIO, 1);
    }

    static OreDictMaterial beryllium8() {
        return alkaline(42, "Beryllium-8", "Be-8", 4, 4, 1560, 2742, 1.85, SET_RAD, 110, 200, 110, FUSION, G_INGOT_ORES)
            .aspects(TC.METALLUM, 2, TC.LUCRUM, 1, TC.RADIO, 1);
    }

    static OreDictMaterial boron() {
        return metalloid(
            50,
            "Boron",
            "B",
            5,
            5,
            2349,
            4200,
            2.34,
            SET_DULL,
            250,
            250,
            250,
            255,
            UUM,
            FUSION,
            ICOSAGEN,
            G_INGOT_ORES).aspects(TC.METALLUM, 1, TC.VITREUS, 1, TC.ELECTRUM, 1);
    }

    static OreDictMaterial boron11() {
        return metalloid(
            51,
            "Boron-11",
            "B-11",
            5,
            6,
            2349,
            4200,
            2.34,
            SET_RAD,
            240,
            240,
            240,
            255,
            FUSION,
            ICOSAGEN,
            G_INGOT_ORES).aspects(TC.METALLUM, 1, TC.VITREUS, 1, TC.RADIO, 1);
    }

    static OreDictMaterial carbon() {
        return polyatomic(
            60,
            "Carbon",
            "C",
            6,
            6,
            3800,
            4300,
            2.267,
            SET_FINE,
            20,
            20,
            20,
            255,
            UUM,
            FUSION,
            CRYSTALLOGEN,
            G_DUST_ORES,
            TICKS_PER_SMELT * 4,
            FLAMMABLE,
            MELTING,
            MOLTEN,
            MORTAR,
            STICKS).aspects(TC.VITREUS, 1, TC.IGNIS, 1);
    }

    static OreDictMaterial carbon13() {
        return polyatomic(
            61,
            "Carbon-13",
            "C-13",
            6,
            7,
            3800,
            4300,
            2.267,
            SET_RAD,
            25,
            25,
            25,
            255,
            FUSION,
            CRYSTALLOGEN,
            G_DUST_ORES,
            TICKS_PER_SMELT * 4,
            FLAMMABLE,
            MELTING,
            MOLTEN).aspects(TC.VITREUS, 1, TC.IGNIS, 1, TC.RADIO, 1);
    }

    static OreDictMaterial carbon14() {
        return polyatomic(
            62,
            "Carbon-14",
            "C-14",
            6,
            8,
            3800,
            4300,
            2.267,
            SET_RAD,
            30,
            30,
            30,
            255,
            FUSION,
            CRYSTALLOGEN,
            G_DUST_ORES,
            TICKS_PER_SMELT * 4,
            FLAMMABLE,
            MELTING,
            MOLTEN).aspects(TC.VITREUS, 1, TC.IGNIS, 1, TC.RADIO, 1);
    }

    static OreDictMaterial nitrogen() {
        return diatomicgas(
            70,
            "Nitrogen",
            "N",
            7,
            7,
            63,
            77,
            0.0012506,
            SET_DULL,
            0,
            150,
            200,
            15,
            UUM,
            FUSION,
            PNICTOGEN,
            CONTAINERS_GAS).aspects(TC.AER, 1);
    }

    static OreDictMaterial oxygen() {
        return diatomicgas(
            80,
            "Oxygen",
            "O",
            8,
            8,
            54,
            90,
            0.001429,
            SET_DULL,
            0,
            100,
            200,
            15,
            UUM,
            FUSION,
            CHALCOGEN,
            CONTAINERS_GAS).aspects(TC.AER, 1);
    }

    static OreDictMaterial fluorine() {
        return diatomicgas(
            90,
            "Fluorine",
            "F",
            9,
            9,
            53,
            85,
            0.001696,
            SET_DULL,
            64,
            192,
            0,
            255,
            UUM,
            FUSION,
            HALOGEN,
            CONTAINERS_GAS).aspects(TC.PERDITIO, 2);
    }

    static OreDictMaterial neon() {
        return noblegas(
            100,
            "Neon",
            "Ne",
            10,
            10,
            24,
            27,
            0.0008999,
            SET_SHINY,
            250,
            180,
            180,
            UUM,
            FUSION,
            CONTAINERS_GAS).aspects(TC.AER, 3);
    }

    static OreDictMaterial sodium() {
        return alkali(
            110,
            "Sodium",
            "Na",
            11,
            11,
            370,
            1156,
            0.971,
            SET_ROUGH,
            0,
            0,
            150,
            UUM,
            FUSION,
            TICKS_PER_SMELT * 20,
            "Natrium").aspects(TC.VITREUS, 2, TC.LUX, 1);
    }

    static OreDictMaterial magnesium() {
        return alkaline(
            120,
            "Magnesium",
            "Mg",
            12,
            12,
            923,
            1363,
            1.738,
            SET_COPPER,
            255,
            200,
            200,
            UUM,
            FUSION,
            TICKS_PER_SMELT * 4,
            FLAMMABLE).aspects(TC.METALLUM, 2, TC.SANO, 1);
    }

    static OreDictMaterial aluminium() {
        return posttrans(
            130,
            "Aluminium",
            "Al",
            13,
            13,
            933,
            2792,
            2.698,
            SET_COPPER,
            128,
            200,
            240,
            UUM,
            FUSION,
            ICOSAGEN,
            G_INGOT_MACHINE_ORES,
            RAILS,
            MOLTEN,
            SOFT,
            "Aluminum").aspects(TC.METALLUM, 2, TC.VOLATUS, 1);
    }

    static OreDictMaterial silicon() {
        return metalloid(
            140,
            "Silicon",
            "Si",
            14,
            14,
            1687,
            3538,
            2.3296,
            SET_COPPER,
            60,
            60,
            80,
            255,
            UUM,
            FUSION,
            CRYSTALLOGEN).aspects(TC.METALLUM, 2, TC.TENEBRAE, 1);
    }

    static OreDictMaterial phosphor() {
        return polyatomic(
            150,
            "Phosphor",
            "P",
            15,
            15,
            317,
            550,
            1.82,
            SET_FINE,
            255,
            255,
            0,
            255,
            UUM,
            FUSION,
            PNICTOGEN,
            G_CRYSTAL_ORES,
            TICKS_PER_SMELT * 5,
            FLAMMABLE,
            EXPLOSIVE,
            BRITTLE,
            MORTAR).aspects(TC.IGNIS, 2, TC.POTENTIA, 1);
    }

    static OreDictMaterial sulfur() {
        return polyatomic(
            160,
            "Sulfur",
            "S",
            16,
            16,
            388,
            717,
            2.067,
            SET_FINE,
            234,
            234,
            0,
            255,
            UUM,
            FUSION,
            CHALCOGEN,
            G_CRYSTAL_ORES,
            TICKS_PER_SMELT * 5,
            FLAMMABLE,
            MELTING,
            MOLTEN,
            BRITTLE,
            MORTAR,
            "Sulphur").aspects(TC.IGNIS, 1);
    }

    static OreDictMaterial chlorine() {
        return diatomicgas(
            170,
            "Chlorine",
            "Cl",
            17,
            18,
            171,
            239,
            0.003214,
            SET_DULL,
            0,
            240,
            255,
            255,
            UUM,
            FUSION,
            HALOGEN,
            CONTAINERS_FLUID).aspects(TC.AQUA, 2, TC.PANNUS, 1);
    }

    static OreDictMaterial argon() {
        return noblegas(
            180,
            "Argon",
            "Ar",
            18,
            22,
            83,
            87,
            0.0017837,
            SET_SHINY,
            0,
            255,
            0,
            UUM,
            FUSION,
            CONTAINERS_GAS).aspects(TC.AER, 3);
    }

    static OreDictMaterial potassium() {
        return alkali(190, "Potassium", "K", 19, 20, 336, 1032, 0.862, SET_ROUGH, 250, 250, 250, UUM, FUSION, "Kalium")
            .aspects(TC.VITREUS, 1, TC.POTENTIA, 1);
    }

    static OreDictMaterial calcium() {
        return alkaline(200, "Calcium", "Ca", 20, 20, 1115, 1757, 1.54, SET_METALLIC, 255, 245, 245, UUM, FUSION)
            .aspects(TC.SANO, 1, TC.TUTAMEN, 1);
    }

    static OreDictMaterial scandium() {
        return transmetal(210, "Scandium", "Sc", 21, 24, 1814, 3109, 2.989, SET_METALLIC, UUM, FUSION, SCANDIUM_GROUP)
            .aspects(TC.METALLUM, 2, TC.GELUM, 1);
    }

    static OreDictMaterial titanium() {
        return refractmetal(
            220,
            "Titanium",
            "Ti",
            22,
            26,
            1941,
            3560,
            4.54,
            SET_METALLIC,
            220,
            160,
            240,
            255,
            UUM,
            FUSION,
            TITANIUM_GROUP,
            G_INGOT_MACHINE_ORES,
            RAILS,
            MOLTEN,
            NEVER_FURNACE,
            "Titan").aspects(TC.METALLUM, 2, TC.TUTAMEN, 1);
    }

    static OreDictMaterial vanadium() {
        return refractmetal(
            230,
            "Vanadium",
            "V",
            23,
            28,
            2183,
            3680,
            6.11,
            SET_METALLIC,
            50,
            50,
            50,
            255,
            UUM,
            FUSION,
            VANADIUM_GROUP,
            MOLTEN).aspects(TC.METALLUM, 2, TC.ELECTRUM, 1);
    }

    static OreDictMaterial chromium() {
        return refractmetal(
            240,
            "Chromium",
            "Cr",
            24,
            28,
            2180,
            2944,
            7.15,
            SET_SHINY,
            255,
            230,
            230,
            255,
            UUM,
            FUSION,
            CHROMIUM_GROUP,
            G_INGOT_MACHINE_ORES,
            MOLTEN,
            "Chrome").aspects(TC.METALLUM, 2, TC.MACHINA, 1);
    }

    static OreDictMaterial manganese() {
        return transmetal(
            250,
            "Manganese",
            "Mn",
            25,
            30,
            1519,
            2334,
            7.44,
            SET_DULL,
            250,
            250,
            250,
            255,
            UUM,
            FUSION,
            MANGANESE_GROUP,
            MAGNETIC_PASSIVE,
            MOLTEN).aspects_met_rad(3, 0);
    }

    static OreDictMaterial iron() {
        return transmetal(
            260,
            "Iron",
            "Fe",
            26,
            30,
            1811,
            3134,
            7.874,
            SET_METALLIC,
            200,
            200,
            200,
            255,
            UUM,
            FUSION,
            IRON_GROUP,
            G_INGOT_MACHINE_ORES,
            MOLTEN,
            RAILS,
            MORTAR,
            MAGNETIC_PASSIVE,
            NEVER_FURNACE).aspects_met_rad(3, 0);
    }

    static OreDictMaterial cobalt() {
        return transmetal(
            270,
            "Cobalt",
            "Co",
            27,
            32,
            1768,
            3200,
            8.86,
            SET_METALLIC,
            80,
            80,
            250,
            255,
            UUM,
            COBALT_GROUP,
            WASHING_PERSULFATE,
            MORTAR,
            MAGNETIC_PASSIVE,
            MOLTEN).aspects(TC.METALLUM, 2, TC.INSTRUMENTUM, 1);
    }

    static OreDictMaterial cobalt60() {
        return transmetal(
            278,
            "Cobalt-60",
            "Co-60",
            27,
            33,
            1768,
            3200,
            8.86,
            SET_RAD,
            90,
            90,
            250,
            255,
            COBALT_GROUP,
            WASHING_PERSULFATE,
            MORTAR,
            MAGNETIC_PASSIVE,
            "Co60").aspects(TC.METALLUM, 1, TC.INSTRUMENTUM, 1, TC.RADIO, 1);
    }

    static OreDictMaterial nickel() {
        return transmetal(
            280,
            "Nickel",
            "Ni",
            28,
            30,
            1728,
            3186,
            8.912,
            SET_METALLIC,
            250,
            250,
            200,
            255,
            UUM,
            NICKEL_GROUP,
            WASHING_PERSULFATE,
            MORTAR,
            MAGNETIC_PASSIVE,
            MOLTEN).aspects(TC.METALLUM, 2, TC.IGNIS, 1);
    }

    static OreDictMaterial copper() {
        return noblemetal(
            290,
            "Copper",
            "Cu",
            29,
            34,
            1357,
            2835,
            8.96,
            SET_COPPER,
            255,
            130,
            90,
            UUM,
            COPPER_GROUP,
            G_INGOT_MACHINE_ORES,
            WASHING_PERSULFATE,
            SOFT,
            FURNACE,
            EXTRUDER_SIMPLE,
            MORTAR,
            MOLTEN,
            RAILS).aspects(TC.METALLUM, 2, TC.PERMUTATIO, 1);
    }

    static OreDictMaterial zinc() {
        return transmetal(
            300,
            "Zinc",
            "Zn",
            30,
            35,
            692,
            1180,
            7.134,
            SET_COPPER,
            250,
            240,
            240,
            255,
            UUM,
            ZINC_GROUP,
            WASHING_PERSULFATE,
            SOFT,
            WASHING_MERCURY,
            MOLTEN).aspects(TC.METALLUM, 2, TC.SANO, 1);
    }

    static OreDictMaterial gallium() {
        return posttrans(
            310,
            "Gallium",
            "Ga",
            31,
            39,
            302,
            2477,
            5.907,
            SET_COPPER,
            220,
            220,
            255,
            UUM,
            ICOSAGEN,
            BRITTLE).aspects(TC.METALLUM, 2, TC.ELECTRUM, 1);
    }

    static OreDictMaterial germanium() {
        return metalloid(
            320,
            "Germanium",
            "Ge",
            32,
            40,
            1211,
            3106,
            5.323,
            SET_COPPER,
            212,
            212,
            212,
            255,
            UUM,
            CRYSTALLOGEN,
            G_INGOT_MACHINE_ORES,
            FURNACE,
            EXTRUDER_SIMPLE,
            MORTAR,
            "Osmium").aspects(TC.METALLUM, 2, TC.ELECTRUM, 1);
    }

    static OreDictMaterial arsenic() {
        return metalloid(330, "Arsenic", "As", 33, 42, 887, 1090, 5.776, SET_SHINY, 103, 103, 86, 255, UUM, PNICTOGEN)
            .aspects(TC.METALLUM, 1, TC.VENEMUM, 2);
    }

    static OreDictMaterial selenium() {
        return polyatomic(
            340,
            "Selenium",
            "Se",
            34,
            45,
            453,
            958,
            4.809,
            SET_DULL,
            111,
            20,
            20,
            255,
            UUM,
            CHALCOGEN,
            G_CRYSTAL_ORES,
            BRITTLE).aspects(TC.VITREUS, 1, TC.SPIRITUS, 2);
    }

    static OreDictMaterial bromine() {
        return diatomic(
            350,
            "Bromine",
            "Br",
            35,
            45,
            265,
            332,
            3.122,
            SET_FLUID,
            80,
            10,
            10,
            255,
            UUM,
            HALOGEN,
            CONTAINERS_FLUID,
            LIQUID,
            MELTING).aspects(TC.METALLUM, 1, TC.AQUA, 1, TC.TEMPESTAS, 1);
    }

    static OreDictMaterial krypton() {
        return noblegas(
            360,
            "Krypton",
            "Kr",
            36,
            48,
            115,
            119,
            0.003733,
            SET_DIAMOND,
            128,
            255,
            128,
            UUM,
            CONTAINERS_GAS).aspects(TC.AER, 3);
    }

    static OreDictMaterial rubidium() {
        return alkali(370, "Rubidium", "Rb", 37, 48, 312, 961, 1.532, SET_SHINY, 240, 30, 30, UUM)
            .aspects(TC.METALLUM, 2, TC.VITREUS, 1);
    }

    static OreDictMaterial strontium() {
        return alkaline(380, "Strontium", "Sr", 38, 49, 1050, 1655, 2.64, SET_METALLIC, 200, 200, 200, UUM)
            .aspects(TC.METALLUM, 2, TC.STRONTIO, 1);
    }

    static OreDictMaterial yttrium() {
        return transmetal(
            390,
            "Yttrium",
            "Y",
            39,
            50,
            1799,
            3609,
            4.469,
            SET_METALLIC,
            220,
            250,
            220,
            255,
            UUM,
            SCANDIUM_GROUP).aspects_met_rad(3, 0);
    }

    static OreDictMaterial zirconium() {
        return refractmetal(
            400,
            "Zirconium",
            "Zr",
            40,
            51,
            2128,
            4682,
            6.506,
            SET_DIAMOND,
            200,
            255,
            255,
            127,
            UUM,
            TITANIUM_GROUP,
            G_GEM_ORES_TRANSPARENT,
            CRYSTAL,
            VALUABLE).aspects(TC.METALLUM, 2, TC.VITREUS, 1);
    }

    static OreDictMaterial niobium() {
        return refractmetal(
            410,
            "Niobium",
            "Nb",
            41,
            53,
            2750,
            5017,
            8.57,
            SET_METALLIC,
            190,
            180,
            200,
            255,
            UUM,
            VANADIUM_GROUP,
            "Columbium").aspects(TC.METALLUM, 2, TC.IGNIS, 1);
    }

    static OreDictMaterial molybdenum() {
        return refractmetal(
            420,
            "Molybdenum",
            "Mo",
            42,
            53,
            2896,
            4912,
            10.22,
            SET_COPPER,
            180,
            180,
            220,
            255,
            UUM,
            CHROMIUM_GROUP,
            MOLTEN).aspects(TC.METALLUM, 2, TC.INSTRUMENTUM, 1);
    }

    static OreDictMaterial technetium() {
        return transmetal(
            430,
            "Technetium",
            "Tc",
            43,
            55,
            2430,
            4538,
            11.5,
            SET_RAD,
            66,
            66,
            99,
            255,
            MANGANESE_GROUP,
            "Gregorium").aspects_met_rad(2, 1);
    }

    static OreDictMaterial ruthenium() {
        return platingroup(440, "Ruthenium", "Ru", 44, 57, 2607, 4423, 12.37, SET_SHINY, 155, 155, 155, UUM, IRON_GROUP)
            .aspects(TC.METALLUM, 3, TC.NEBRISUM, 1);
    }

    static OreDictMaterial rhodium() {
        return platingroup(450, "Rhodium", "Rh", 45, 58, 2237, 3968, 12.41, SET_SHINY, 144, 144, 144, UUM, COBALT_GROUP)
            .aspects(TC.METALLUM, 3, TC.NEBRISUM, 1);
    }

    static OreDictMaterial palladium() {
        return platingroup(
            460,
            "Palladium",
            "Pd",
            46,
            60,
            1828,
            3236,
            12.02,
            SET_SHINY,
            128,
            128,
            128,
            UUM,
            NICKEL_GROUP,
            G_INGOT_MACHINE_ORES).aspects(TC.METALLUM, 3, TC.NEBRISUM, 1);
    }

    static OreDictMaterial silver() {
        return noblemetal(
            470,
            "Silver",
            "Ag",
            47,
            60,
            1234,
            2435,
            10.501,
            SET_SHINY,
            220,
            220,
            255,
            UUM,
            COPPER_GROUP,
            G_INGOT_MACHINE_ORES,
            RAILS,
            WASHING_MERCURY,
            MORTAR,
            MOLTEN,
            VALUABLE,
            SOFT,
            ENDER_DRAGON_PROOF).aspects(TC.METALLUM, 2, TC.LUCRUM, 1);
    }

    static OreDictMaterial cadmium() {
        return transmetal(480, "Cadmium", "Cd", 48, 64, 594, 1040, 8.69, SET_SHINY, 50, 50, 60, 255, UUM, ZINC_GROUP)
            .aspects(TC.METALLUM, 1, TC.POTENTIA, 1, TC.VENEMUM, 1);
    }

    static OreDictMaterial indium() {
        return posttrans(490, "Indium", "In", 49, 65, 429, 2345, 7.31, SET_SHINY, 64, 0, 128, UUM, ICOSAGEN)
            .aspects_met_rad(3, 0);
    }

    static OreDictMaterial tin() {
        return posttrans(
            500,
            "Tin",
            "Sn",
            50,
            68,
            505,
            2875,
            7.287,
            SET_COPPER,
            220,
            220,
            220,
            UUM,
            CRYSTALLOGEN,
            G_INGOT_MACHINE_ORES,
            SOFT,
            SOLDERING_MATERIAL,
            MOLTEN).aspects(TC.METALLUM, 2, TC.VITREUS, 1);
    }

    static OreDictMaterial antimony() {
        return metalloid(
            510,
            "Antimony",
            "Sb",
            51,
            70,
            903,
            1860,
            6.685,
            SET_COPPER,
            220,
            220,
            240,
            255,
            UUM,
            PNICTOGEN,
            G_INGOT_MACHINE_ORES,
            SOFT).aspects(TC.METALLUM, 2, TC.AQUA, 1);
    }

    static OreDictMaterial tellurium() {
        return metalloid(520, "Tellurium", "Te", 52, 75, 722, 1261, 6.232, SET_SHINY, UUM, CHALCOGEN)
            .aspects(TC.METALLUM, 2, TC.ELECTRUM, 1);
    }

    static OreDictMaterial iodine() {
        return diatomic(
            530,
            "Iodine",
            "I",
            53,
            74,
            386,
            457,
            4.93,
            SET_DULL,
            255,
            240,
            240,
            255,
            UUM,
            HALOGEN,
            G_CRYSTAL_ORES).aspects(TC.VITREUS, 2, TC.TEMPESTAS, 1);
    }

    static OreDictMaterial xenon() {
        return noblegas(540, "Xenon", "Xe", 54, 77, 161, 165, 0.005887, SET_DULL, 0, 255, 255, UUM, CONTAINERS_GAS)
            .aspects(TC.AER, 3);
    }

    static OreDictMaterial caesium() {
        return alkali(550, "Caesium", "Cs", 55, 77, 301, 944, 1.873, SET_SHINY, 128, 98, 11, UUM).aspects_met_rad(3, 0);
    }

    static OreDictMaterial barium() {
        return alkaline(560, "Barium", "Ba", 56, 81, 1000, 2170, 3.594, SET_METALLIC, 131, 130, 76, UUM)
            .aspects(TC.VINCULUM, 3);
    }

    static OreDictMaterial lanthanium() {
        return lanthanide(
            570,
            "Lanthanium",
            "La",
            57,
            81,
            1193,
            3737,
            6.145,
            SET_METALLIC,
            93,
            117,
            117,
            UUM,
            "Lantanium",
            "Lantanum",
            "Lanthanum").aspects_met_rad(3, 0);
    }

    static OreDictMaterial cerium() {
        return lanthanide(580, "Cerium", "Ce", 58, 82, 1068, 3716, 6.77, SET_SHINY, 255, 255, 190, UUM)
            .aspects_met_rad(3, 0);
    }

    static OreDictMaterial praseodymium() {
        return lanthanide(590, "Praseodymium", "Pr", 59, 81, 1208, 3793, 6.773, SET_METALLIC, UUM)
            .aspects_met_rad(3, 0);
    }

    static OreDictMaterial neodymium() {
        return lanthanide(
            600,
            "Neodymium",
            "Nd",
            60,
            84,
            1297,
            3347,
            7.007,
            SET_SHINY,
            100,
            100,
            100,
            UUM,
            MAGNETIC_PASSIVE,
            MOLTEN).aspects(TC.METALLUM, 2, TC.MAGNETO, 2);
    }

    static OreDictMaterial promethium() {
        return lanthanide(610, "Promethium", "Pm", 61, 83, 1315, 3273, 7.26, SET_RAD).aspects_met_rad(1, 2);
    }

    static OreDictMaterial samarium() {
        return lanthanide(620, "Samarium", "Sm", 62, 88, 1345, 2067, 7.52, SET_METALLIC, UUM).aspects_met_rad(3, 0);
    }

    static OreDictMaterial europium() {
        return lanthanide(630, "Europium", "Eu", 63, 88, 1099, 1802, 5.243, SET_METALLIC, UUM).aspects_met_rad(3, 0);
    }

    static OreDictMaterial gadolinium() {
        return lanthanide(640, "Gadolinium", "Gd", 64, 93, 1585, 3546, 7.895, SET_METALLIC, UUM).aspects_met_rad(3, 0);
    }

    static OreDictMaterial terbium() {
        return lanthanide(650, "Terbium", "Tb", 65, 93, 1629, 3503, 8.229, SET_METALLIC, UUM).aspects_met_rad(3, 0);
    }

    static OreDictMaterial dysprosium() {
        return lanthanide(660, "Dysprosium", "Dy", 66, 96, 1680, 2840, 8.55, SET_METALLIC, UUM).aspects_met_rad(3, 0);
    }

    static OreDictMaterial holmium() {
        return lanthanide(
            670,
            "Holmium",
            "Ho",
            67,
            97,
            1734,
            2993,
            8.795,
            SET_METALLIC,
            196,
            150,
            159,
            UUM,
            MAGNETIC_ACTIVE).aspects(TC.METALLUM, 2, TC.MAGNETO, 4);
    }

    static OreDictMaterial erbium() {
        return lanthanide(680, "Erbium", "Er", 68, 99, 1802, 3141, 9.066, SET_METALLIC, UUM).aspects_met_rad(3, 0);
    }

    static OreDictMaterial thulium() {
        return lanthanide(690, "Thulium", "Tm", 69, 99, 1818, 2223, 9.321, SET_METALLIC, UUM).aspects_met_rad(3, 0);
    }

    static OreDictMaterial ytterbium() {
        return lanthanide(700, "Ytterbium", "Yb", 70, 103, 1097, 1469, 6.965, SET_METALLIC, 167, 167, 167, UUM)
            .aspects_met_rad(3, 0);
    }

    static OreDictMaterial lutetium() {
        return lanthanide(710, "Lutetium", "Lu", 71, 103, 1925, 3675, 9.84, SET_METALLIC, UUM, SCANDIUM_GROUP)
            .aspects_met_rad(3, 0);
    }

    static OreDictMaterial hafnium() {
        return refractmetal(
            720,
            "Hafnium",
            "Hf",
            72,
            106,
            2506,
            4876,
            13.31,
            SET_COPPER,
            140,
            140,
            150,
            255,
            UUM,
            TITANIUM_GROUP,
            FLAMMABLE,
            EXPLOSIVE).aspects_met_rad(3, 0);
    }

    static OreDictMaterial tantalum() {
        return refractmetal(
            730,
            "Tantalum",
            "Ta",
            73,
            107,
            3290,
            5731,
            16.654,
            SET_COPPER,
            120,
            120,
            140,
            255,
            UUM,
            VANADIUM_GROUP,
            "Tantalium").aspects(TC.METALLUM, 2, TC.VINCULUM, 1);
    }

    static OreDictMaterial tungsten() {
        return refractmetal(
            740,
            "Tungsten",
            "W",
            74,
            109,
            3695,
            5828,
            19.25,
            SET_METALLIC,
            50,
            50,
            50,
            255,
            UUM,
            CHROMIUM_GROUP,
            G_INGOT_MACHINE_ORES,
            MOLTEN,
            RAILS,
            UNBURNABLE,
            NEVER_FURNACE,
            "Wolframium",
            "Wolfram",
            "ElnTungsten").aspects(TC.METALLUM, 3, TC.TUTAMEN, 1);
    }

    static OreDictMaterial rhenium() {
        return precmetal(
            750,
            "Rhenium",
            "Re",
            75,
            111,
            3459,
            5869,
            21.02,
            SET_SHINY,
            255,
            255,
            200,
            UUM,
            MANGANESE_GROUP).aspects_met_rad(3, 0);
    }

    static OreDictMaterial osmium() {
        return platingroup(
            760,
            "OsmiumElemental",
            "Os",
            76,
            114,
            3306,
            5285,
            22.61,
            SET_METALLIC,
            50,
            50,
            255,
            UUM,
            IRON_GROUP,
            G_INGOT_MACHINE_ORES,
            MOLTEN,
            VALUABLE,
            RAILS).aspects(TC.METALLUM, 2, TC.NEBRISUM, 2, TC.MACHINA, 1);
    }

    static OreDictMaterial iridium() {
        return platingroup(
            770,
            "Iridium",
            "Ir",
            77,
            115,
            2719,
            4701,
            22.56,
            SET_DULL,
            240,
            240,
            245,
            UUM,
            COBALT_GROUP,
            G_INGOT_MACHINE_ORES,
            MOLTEN,
            VALUABLE).aspects(TC.METALLUM, 2, TC.NEBRISUM, 1, TC.MACHINA, 1);
    }

    static OreDictMaterial platinum() {
        return platingroup(
            780,
            "Platinum",
            "Pt",
            78,
            117,
            2041,
            4098,
            21.46,
            SET_SHINY,
            100,
            180,
            250,
            UUM,
            NICKEL_GROUP,
            G_INGOT_MACHINE_ORES,
            WASHING_MERCURY,
            MOLTEN,
            VALUABLE,
            RAILS,
            MORTAR).aspects(TC.METALLUM, 2, TC.NEBRISUM, 1);
    }

    static OreDictMaterial gold() {
        return noblemetal(
            790,
            "Gold",
            "Au",
            79,
            117,
            1337,
            3129,
            19.282,
            SET_SHINY,
            255,
            230,
            80,
            UUM,
            COPPER_GROUP,
            G_INGOT_MACHINE_ORES,
            WASHING_MERCURY,
            MOLTEN,
            VALUABLE,
            SOFT,
            RAILS,
            MORTAR,
            WITHER_PROOF).aspects(TC.METALLUM, 2, TC.LUCRUM, 2);
    }

    static OreDictMaterial gold198() {
        return noblemetal(
            791,
            "Gold-198",
            "Au-198",
            79,
            119,
            1337,
            3129,
            19.282,
            SET_SHINY,
            255,
            230,
            80,
            COPPER_GROUP,
            G_INGOT_ORES,
            WASHING_MERCURY,
            MOLTEN,
            VALUABLE,
            SOFT,
            WITHER_PROOF,
            "Gol198",
            "Au198").aspects_met_rad(2, 1);
    }

    static OreDictMaterial mercury() {
        return precmetal(
            800,
            "Mercury",
            "Hg",
            80,
            120,
            234,
            629,
            13.5336,
            SET_COPPER,
            230,
            220,
            220,
            UUM,
            ZINC_GROUP,
            "Quicksilver",
            "QuickSilver",
            PULVERIZING_CINNABAR).aspects(TC.METALLUM, 1, TC.AQUA, 1, TC.VENEMUM, 1);
    }

    static OreDictMaterial thallium() {
        return posttrans(810, "Thallium", "Tl", 81, 123, 577, 1746, 11.85, SET_METALLIC, UUM, ICOSAGEN)
            .aspects_met_rad(3, 0);
    }

    static OreDictMaterial lead() {
        return posttrans(
            820,
            "Lead",
            "Pb",
            82,
            125,
            600,
            2022,
            11.342,
            SET_DULL,
            60,
            40,
            110,
            UUM,
            CRYSTALLOGEN,
            G_INGOT_MACHINE_ORES,
            SOLDERING_MATERIAL,
            SOLDERING_MATERIAL_BAD,
            MOLTEN,
            SOFT).aspects(TC.METALLUM, 2, TC.ORDO, 1);
    }

    static OreDictMaterial bismuth() {
        return posttrans(
            830,
            "Bismuth",
            "Bi",
            83,
            125,
            544,
            1837,
            9.807,
            SET_COPPER,
            100,
            160,
            160,
            PNICTOGEN,
            G_INGOT_MACHINE_ORES,
            MAGNETIC_PASSIVE,
            MOLTEN).aspects(TC.METALLUM, 2, TC.MAGNETO, 1);
    }

    static OreDictMaterial polonium() {
        return posttrans(840, "Polonium", "Po", 84, 124, 527, 1235, 9.32, SET_RAD, CHALCOGEN).aspects_met_rad(2, 1);
    }

    static OreDictMaterial astatine() {
        return metalloid(
            850,
            "Astatine",
            "At",
            85,
            124,
            575,
            610,
            7.0,
            SET_RAD,
            33,
            33,
            33,
            255,
            HALOGEN,
            CONTAINERS_GAS,
            GASES,
            "Astatine209",
            "At209").aspects(TC.POTENTIA, 2, TC.RADIO, 1);
    }

    static OreDictMaterial radon() {
        return noblegas(860, "Radon", "Rn", 86, 134, 202, 211, 0.00973, SET_DULL, 255, 0, 255, CONTAINERS_GAS)
            .aspects(TC.AER, 2, TC.RADIO, 1);
    }

    static OreDictMaterial francium() {
        return alkali(870, "Francium", "Fr", 87, 134, 300, 950, 1.87, SET_RAD).aspects_met_rad(2, 1);
    }

    static OreDictMaterial radium() {
        return alkaline(880, "Radium", "Ra", 88, 138, 973, 2010, 5.5, SET_RAD, 255, 255, 205, "Radium226")
            .aspects_met_rad(2, 1);
    }

    static OreDictMaterial actinium() {
        return actinide(890, "Actinium", "Ac", 89, 136, 1323, 3471, 10.07, SET_RAD, 125, 113, 113)
            .aspects_met_rad(2, 1);
    }

    static OreDictMaterial thorium() {
        return actinide(900, "Thorium", "Th", 90, 142, 2115, 5061, 11.72, SET_RAD, 0, 30, 0, "Thorium232", "Th232")
            .aspects_met_rad(2, 1);
    }

    static OreDictMaterial protactinium() {
        return actinide(910, "Protactinium", "Pa", 91, 138, 1841, 4300, 15.37, SET_RAD).aspects_met_rad(2, 1);
    }

    static OreDictMaterial uranium() {
        return actinide(
            920,
            "Uranium",
            "U",
            92,
            146,
            1405,
            4404,
            18.95,
            SET_RAD,
            50,
            240,
            50,
            MELTING,
            MOLTEN,
            "Uranium238",
            "Uran",
            "U238").aspects_met_rad(2, 1);
    }

    static OreDictMaterial uranium235() {
        return actinide(
            921,
            "Uranium-235",
            "U-235",
            92,
            143,
            1405,
            4404,
            18.95,
            SET_RAD,
            70,
            250,
            70,
            MELTING,
            MOLTEN,
            "UraniumEnriched",
            "U235").aspects_met_rad(1, 2);
    }

    static OreDictMaterial uranium233() {
        return actinide(922, "Uranium-233", "U-233", 92, 141, 1405, 4404, 18.95, SET_RAD, 70, 250, 50, "U233")
            .aspects_met_rad(1, 3);
    }

    static OreDictMaterial neptunium() {
        return actinide(930, "Neptunium", "Np", 93, 144, 917, 4273, 20.45, SET_RAD, 78, 90, 78, "Neptunium237", "Np237")
            .aspects_met_rad(2, 1);
    }

    static OreDictMaterial plutonium() {
        return actinide(940, "Plutonium", "Pu", 94, 150, 912, 3501, 19.84, SET_RAD, 240, 50, 50, "Plutonium244")
            .aspects_met_rad(2, 1);
    }

    static OreDictMaterial plutonium240() {
        return actinide(942, "Plutonium-240", "Pu-240", 94, 146, 912, 3501, 19.84, SET_RAD, 235, 30, 30, "Pu240")
            .aspects_met_rad(1, 3);
    }

    static OreDictMaterial plutonium241() {
        return actinide(943, "Plutonium-241", "Pu-241", 94, 147, 912, 3501, 19.84, SET_RAD, 245, 70, 70, "Pu241")
            .aspects_met_rad(1, 3);
    }

    static OreDictMaterial plutonium243() {
        return actinide(945, "Plutonium-243", "Pu-243", 94, 149, 912, 3501, 19.84, SET_RAD, 250, 70, 70)
            .aspects_met_rad(1, 2);
    }

    static OreDictMaterial plutonium238() {
        return actinide(946, "Plutonium-238", "Pu-238", 94, 144, 912, 3501, 19.84, SET_RAD, 250, 30, 30, "Pu238")
            .aspects_met_rad(1, 3);
    }

    static OreDictMaterial plutonium239() {
        return actinide(947, "Plutonium-239", "Pu-239", 94, 145, 912, 3501, 19.84, SET_RAD, 235, 50, 50, "Pu239")
            .aspects_met_rad(1, 3);
    }

    static OreDictMaterial americium() {
        return actinide(950, "Americium", "Am", 95, 150, 1449, 2880, 13.69, SET_RAD, 200, 200, 200)
            .aspects_met_rad(2, 1);
    }

    static OreDictMaterial americium241() {
        return actinide(951, "Americium-241", "Am-241", 95, 146, 1449, 2880, 13.69, SET_RAD, 210, 210, 210, "Am241")
            .aspects_met_rad(1, 3);
    }

    static OreDictMaterial americium242() {
        return actinide(952, "Americium-242", "Am-242", 95, 147, 1449, 2880, 13.69, SET_RAD, 210, 210, 210, "Am242")
            .aspects_met_rad(1, 3);
    }

    static OreDictMaterial curium() {
        return actinide(960, "Curium", "Cm", 96, 153, 1613, 3383, 13.51, SET_RAD).aspects_met_rad(2, 1);
    }

    static OreDictMaterial berkelium() {
        return actinide(970, "Berkelium", "Bk", 97, 152, 1259, 2900, 14.79, SET_RAD).aspects_met_rad(2, 1);
    }

    static OreDictMaterial californium() {
        return actinide(980, "Californium", "Cf", 98, 153, 1173, 1743, 15.1, SET_RAD).aspects_met_rad(2, 1);
    }

    static OreDictMaterial einsteinium() {
        return actinide(990, "Einsteinium", "Es", 99, 153, 1133, 1269, 8.84, SET_RAD).aspects_met_rad(2, 1);
    }

    static OreDictMaterial fermium() {
        return actinide(1000, "Fermium", "Fm", 100, 157, 1125, 3000, 0, SET_RAD).aspects_met_rad(1, 2);
    }

    static OreDictMaterial mendelevium() {
        return actinide(1010, "Mendelevium", "Md", 101, 157, 1100, 3000, 0, SET_RAD).aspects_met_rad(1, 2);
    }

    static OreDictMaterial nobelium() {
        return actinide(1020, "Nobelium", "No", 102, 157, 1100, 3000, 0, SET_RAD).aspects_met_rad(1, 2);
    }

    static OreDictMaterial lawrencium() {
        return actinide(1030, "Lawrencium", "Lr", 103, 159, 1900, 3000, 0, SET_RAD, SCANDIUM_GROUP)
            .aspects_met_rad(1, 2);
    }

    static OreDictMaterial rutherfordium() {
        return transmetal(1040, "Rutherfordium", "Rf", 104, 161, 2400, 5800, 23.2, SET_RAD, TITANIUM_GROUP)
            .aspects_met_rad(1, 2);
    }

    static OreDictMaterial dubnium() {
        return transmetal(1050, "Dubnium", "Db", 105, 163, 1000, 3000, 29.3, SET_RAD, VANADIUM_GROUP)
            .aspects_met_rad(1, 2);
    }

    static OreDictMaterial seaborgium() {
        return transmetal(1060, "Seaborgium", "Sg", 106, 165, 1000, 3000, 35.0, SET_RAD, CHROMIUM_GROUP)
            .aspects_met_rad(1, 2);
    }

    static OreDictMaterial bohrium() {
        return transmetal(1070, "Bohrium", "Bh", 107, 163, 1000, 3000, 37.1, SET_RAD, MANGANESE_GROUP)
            .aspects_met_rad(1, 2);
    }

    static OreDictMaterial hassium() {
        return transmetal(1080, "Hassium", "Hs", 108, 169, 1000, 3000, 40.7, SET_RAD, IRON_GROUP).aspects_met_rad(1, 2);
    }

    static OreDictMaterial meitnerium() {
        return element(1090, "Meitnerium", "Mt", 109, 167, 1000, 3000, 37.4, SET_RAD, COBALT_GROUP, G_INGOT_ORES)
            .aspects_met_rad(1, 2);
    }

    static OreDictMaterial darmstadtium() {
        return element(1100, "Darmstadtium", "Ds", 110, 171, 1000, 3000, 34.8, SET_RAD, NICKEL_GROUP, G_INGOT_ORES)
            .aspects_met_rad(1, 2);
    }

    static OreDictMaterial roentgenium() {
        return element(1110, "Roentgenium", "Rg", 111, 169, 1000, 3000, 28.7, SET_RAD, COPPER_GROUP, G_INGOT_ORES)
            .aspects_met_rad(1, 2);
    }

    static OreDictMaterial copernicium() {
        return transmetal(1120, "Copernicium", "Cn", 112, 173, 150, 357, 23.7, SET_RAD, ZINC_GROUP)
            .aspects_met_rad(1, 2);
    }

    static OreDictMaterial nihonium() {
        return element(1130, "Nihonium", "Nh", 113, 171, 700, 1400, 16.0, SET_RAD, ICOSAGEN, G_INGOT_ORES)
            .aspects_met_rad(1, 2);
    }

    static OreDictMaterial flerovium() {
        return posttrans(1140, "Flerovium", "Fl", 114, 175, 340, 420, 14.0, SET_RAD, CRYSTALLOGEN)
            .aspects_met_rad(1, 3);
    }

    static OreDictMaterial flerovium298() {
        return posttrans(1148, "Flerovium-298", "Fl-298", 114, 184, 340, 420, 14.0, SET_RAD, CRYSTALLOGEN)
            .aspects_met_rad(1, 2);
    }

    static OreDictMaterial moscovium() {
        return element(1150, "Moscovium", "Mc", 115, 174, 700, 1400, 13.5, SET_RAD, PNICTOGEN, G_INGOT_ORES)
            .aspects_met_rad(1, 2);
    }

    static OreDictMaterial livermorium() {
        return element(1160, "Livermorium", "Lv", 116, 177, 708, 1085, 12.9, SET_RAD, CHALCOGEN, G_INGOT_ORES)
            .aspects_met_rad(1, 2);
    }

    static OreDictMaterial farnsium() {
        return element(
            1170,
            "Farnsium",
            "Fa",
            117,
            177,
            673,
            823,
            7.2,
            SET_RAD,
            60,
            70,
            80,
            255,
            HALOGEN,
            G_INGOT_ORES,
            "Tennessine").aspects_met_rad(1, 2);
    }

    static OreDictMaterial oganesson() {
        return element(1180, "Oganesson", "Og", 118, 176, 258, 263, 5.0, SET_RAD, G_INGOT_ORES).aspects_met_rad(1, 2);
    }

    static OreDictMaterial ununennium() {
        return element(1190, "Ununennium", "Uue", 119, 178, 290, 903, 0, SET_RAD, G_INGOT_ORES).aspects_met_rad(1, 2);
    }

    static OreDictMaterial unbinilium() {
        return element(1200, "Unbinilium", "Ubn", 120, 180, 953, 1973, 0, SET_RAD, G_INGOT_ORES).aspects_met_rad(1, 2);
    }

    static {
        MaterialsInit.load();
    }

    /**
     * Executes the Material Table and then loads the Material tables that live in their own classes. Safe
     * to call more than once.
     */
    public static void init() {
        MaterialsInit.load();
    }

    /** The placeholders and particles every other Material definition relies on. */
    public static OreDictMaterial NULL, Empty, y, Photon, v, Neutrino, n, Neutron, p, Proton, e, Electron, Ma, Magic;

    /** The chemical Elements, the first twenty or so with their naturally occurring Isotopes. */
    public static OreDictMaterial H, D, H_2, T, H_3, He, He_3, Li, Li_6, Be, Be_7, Be_8, B, B_11, C, C_13, C_14, N, O,
        F, Ne, Na, Mg, Al, Si, P, S, Cl, Ar, K, Ca, Sc, Ti, V, Cr, Mn, Fe, Co, Co_60, Ni, Cu, Zn, Ga, Ge, As, Se, Br,
        Kr, Rb, Sr, Y, Zr, Nb, Mo, Tc, Gregorium, Ru, Rh, Pd, Ag, Cd, In, Sn, Sb, Te, I, Xe, Cs, Ba, La, Ce, Pr, Nd, Pm,
        Sm, Eu, Gd, Tb, Dy, Ho, Er, Tm, Yb, Lu, Hf, Ta, W, Re, Os, Ir, Pt, Au, Au_198, Hg, Tl, Pb, Bi, Po, At, Rn, Fr,
        Ra, Ac, Th, Pa, U_238, U_235, U_233, Np, Pu, Pu_240, Pu_241, Pu_243, Pu_238, Pu_239, Am, Am_241, Am_242, Cm, Bk,
        Cf, Es, Fm, Md, No, Lr, Rf, Db, Sg, Bh, Hs, Mt, Ds, Rg, Cn, Nh, Fl, Fl_298, Mc, Lv, Fa, Ts, Og, Uue, Ubn;

    /** The artificially produced and hypothetical Elements beyond the ones that occur in nature. */
    public static OreDictMaterial Ubu, Ubb, Ubt, Ubq, Tn, Ubp, Ke, Ubh, Ubs, Ubo, Ube, Utn, Utu, Utb, Utt, Utq, Utp,
        Uth, Uts, Uto, Ute, Uqn, Uqu, Uqb, Uqt, Uqq, Dn, Uqp, Uqh, Uqs, Uqo, Uqe, Upn, Upu, Vb, Upb, Upt, Upq, Upp, Uph,
        Ups, Upo, Upe, Uhn, Uhu, Uhb, Uht, Uhq, Uhp, Uhh, Uhs, Uho, Uhe, Usn, Usu, Usb, Ust, Nq, Usq, Nq_528, Nq_522,
        Usp, Ush, Uss, Uso, Use, Uon, Uou, Uob, Uot, Uoq, An, Uop, Cor, Uoh, Dr, Uos, Etx, Uoo, Uoe, Uen, Ueu, Ueb, Uet,
        Ueq, Uep, Ueh, Ues, Ueo, Uee, Bnn, Bnu, Bnb, Bnt, Bnq, Bnp, Bnh, Bns, Bno, Bne, Bun, Buu, Bub, But, Buq, Bup,
        Buh, Bus, Buo, Bue, Bbn, Atl, Bbu, Atlarus, Ad, Bbb, Bbt, Bbq, Bbp, Bbh, Bbs, Bbo, Bbe, Btn, Btu, Btb, Btt, Btq,
        Btp, Bth, Bts, Bto, Mcg, Bte, Bqn, Bqu, Bqb, Bqt, Bqq, Bqp, Bqh, Bqs, Bqo, Bqe, Bpn, Bpu, Bpb, Bpt, Bpq, Bpp,
        Bph, Bps, Bpo, Bpe, Bhn, Bhu, Bhb, Bht, Bhq, Bhp, Bhh, Bhs, Bho, Bhe, Bsn, Bsu, Bsb, Bst, Bsq, Bsp, Bsh, Bss,
        Bso, Bse, Bon, Bou, Bob, Bot, Boq, Bop, Boh, Bos, Boo, Boe, Ben, Beu, Beb, Bet, Beq, Bep, Beh, Bes, Beo, Bee,
        Tnn, Tnu, Tnb, Tnt, Tnq, Tnp, Tnh, Tns, Tno, Tne, Tun, Tuu, Tub, Tut, Tuq, Tup, Tuh, Tus, Tuo, Tue, Tbn, Tbu,
        Tbb, Tbt, Tbq, Tbp, Tbh, Tbs, Tbo, Tbe, Ttn, Ttu, Ttb, Ttt, Ttq, Ttp, Tth, Tts, Tto, Tte, Tqn, Tqu, Tqb, Tqt,
        Tqq, Tqp, Tqh, Tqs, Tqo, Tqe, Tpn, Tpu, Tpb, Tpt, Tpq, Tpp, Tph, Tps, Tpo, Tpe, Thn, Thu, Thb, Tht, Thq, Thp,
        Thh, Ths, Tho, The, Tsn, Tsu, Gt, Tsb, Tst, Tsq, Tsp, Tsh, Tss, Tso, Tse, Ton, Tou, Tob, Tot, Toq, Top, Toh,
        Tos, Too, Toe, Ten, Teu, Teb, Tet, Teq, Tep, Teh, Tes, Teo, Tee, Neutronium;

    /** The pure Tiers that are used as generic stand ins for Machine and Tool progression. */
    public static OreDictMaterial Primitive, Basic, Good, Advanced, Data, Elite, Master, Ultimate, Quantum,
        Superconductor, Infinite;

    /** The sixteen Dye Materials. */
    public static OreDictMaterial Black, Red, Green, Brown, Blue, Purple, Cyan, LightGray, Gray, Pink, Lime, Yellow,
        LightBlue, Magenta, Orange, White;

    /** Water, Air, the Acids, the chemical Compounds and everything else that is processed in a Chemical Reactor. */
    public static OreDictMaterial H2O, Water, HDO, D2O, T2O, Steam, Snow, Ice, FreshWater, HolyWater, SeaWater,
        DirtyWater, DistWater, H2O2, HCl, HF, HeNe, HeliumNeon, Air, NO, NO2, NH3, HNO3, NitricAcid, CO, CO2, CO3, CH4,
        Sugar, Vanilla, Glycerol, Glyceryl, SO2, SO3, H2S, H2SO4, SulfuricAcid, H2S2O7, AgI, SilverIodide, H2SiF6,
        HexafluorosilicicAcid, SiC, SiO2, SiliconDioxide, Glass, Flint, H3BO3, HydrogenBorate, BoricAcid, Datolite,
        H2Ca2B2Si2O10, V2O5, VanadiumPentoxide, Nb2O5, Ta2O5, PO4, WO3, H2WO4, Al2O3, AlF3, AlO3H3, TiO2, TiCl4,
        TitaniumTetrachloride, MnO2, MnCl2, Fe2O3, FeCl2, FeCl3, FeO3H3, MgCl2, MgCO3, CaCl2, CaSO4, Gypsum, Quicklime,
        CaCO3, CaF2, FluoriteRed, FluoritePink, FluoriteBlue, FluoriteGreen, FluoriteBlack, FluoriteWhite,
        FluoriteYellow, FluoriteOrange, FluoriteMagenta, LiCl, LiClO3, LiClO4, Li2O, Li2Fe2O4, LiOH, NaCl, NaNO3, NaOH,
        NaHCO3, Soda, NaHSO4, NaSO4, Na2S, Na2SO3, Na2SO4, Na2S2O7, Na2CO3, NaAlO2, NaF, Na3AlF6, Cryolite, SaltWater,
        KIO3, IodineSalt, KCl, KNO3, KOH, KHSO4, KSO4, K2S, K2SO3, K2SO4, K2S2O7, K2CO3, KAlO2, KF, K2TaF7, SaltedWater,
        ChloroauricAcid, ChloroplatinicAcid, StannicChloride, BlackVitriol, BlueVitriol, GreenVitriol, RedVitriol,
        PinkVitriol, CyanVitriol, WhiteVitriol, GrayVitriol, MartianVitriol, VitriolOfClay, UF4, UF6, U238F4, U238F6,
        U235F4, U235F6, AquaRegia, CobaltHexahydrate, MethaneIce, NitroCarbon, Lava, Biomass, BioFuel, Ethanol, Oil,
        Oilsands, CrudeOil, Fuel, NitroFuel, Kerosine, Diesel, Petrol, Propane, Butane, Propylene, Ethylene, Creosote,
        FishOil, WhaleOil, SeedOil, HempOil, LinOil, SunflowerOil, NutOil, OliveOil, FryingOilHot, Glue, Lubricant,
        ConstructionFoam, UUAmplifier, UUMatter, Latex, Ash, DarkAsh, VolcanicAsh, Chalk, Dolomite, Asbestos, Talc,
        Pyrite, PotassiumFeldspar, Biotite, Emery;

    /** Woods, Waxes, biological Materials and Foods. */
    public static OreDictMaterial Bark, Wood, WoodTreated, WoodPolished, WoodRubber, Bamboo, Skyroot, Weedwood,
        Livingwood, Dreamwood, Shimmerwood, Greatwood, Silverwood, Peanutwood, Marshmallow, LiveRoot, PetrifiedWood,
        Wax, WaxBee, WaxRefractory, WaxParaffin, WaxPlant, WaxMagic, WaxAmnesic, WaxSoulful, Basalz, Blitz, Blizz,
        Blaze, Breeze, Ceramic, Brick, Clay, ClayBrown, ClayRed, Bentonite, Palygorskite, Kaolinite, Porcelain,
        Graphite, Niter, Phosphorus, PhosphorusBlue, PhosphorusRed, PhosphorusWhite, Apatite, Phosphorite, Paper,
        Rubber, Plastic, Teflon, PTFE, PVC, Bakelite, Polycarbonate, Bone, BoneWither, SlimyBone, Gunpowder, Dynamite,
        Asphalt, Tallow, Leather, Indigo, MeatCooked, MeatRaw, MeatRotten, FishCooked, FishRaw, FishRotten, Wheat,
        Barley, Rye, Rice, Oat, OatAbyssal, Corn, Potato, Tofu, SoylentGreen, Cheese, Chili, Cocoa, Chocolate, Coffee,
        Cinnamon, Nutmeg, Peanut, Hazelnut, Pistachio, Almond, PEZ, Licorice, Nougat, PepperBlack, Curry, Milk, Butter,
        ButterSalted, Honey, Honeydew, Tea, Mint;

    /** The precious and semi precious Gems. */
    public static OreDictMaterial Diamond, DiamondBlue, DiamondGreen, DiamondPurple, DiamondRed, DiamondYellow,
        DiamondPink, DiamondIndustrial, ManaDiamond, ElvenDragonstone, Gravitite, Emerald, Aquamarine, Morganite,
        Heliodor, Goshenite, Bixbite, Maxixe, Sapphire, Ruby, BlueSapphire, GreenSapphire, PurpleSapphire,
        YellowSapphire, OrangeSapphire, Spinel, BalasRuby, Almandine, Grossular, Pyrope, Spessartine, Andradite,
        Uvarovite, Jasper, JasperOcean, JasperRainforest, JasperBlue, JasperGreen, JasperYellow, TigerEyeYellow,
        TigerEyeGreen, TigerEyeRed, TigerEyeBlue, TigerEyeBlack, TigerIron, AventurineGreen, AventurineBrown,
        AventurineYellow, AventurineBlack, AventurineBlue, AventurineRed, Topaz, BlueTopaz, Tanzanite, Zanite,
        Amazonite, Alexandrite, Opal, OnyxRed, OnyxBlack, Sugilite, Peridot, Amethyst, Dioptase, Carminite, Amber,
        AmberGolden, AmberDominican, Craponite, Jade, Vinteum, VinteumPurified;

    /** Crystals, Coal, Glowstone, Quartz and the magical Materials. */
    public static OreDictMaterial ArcaneAsh, ArcaneCompound, Moonstone, Sunstone, Chimerite, CrimsonMiddle, GreenMiddle,
        AquaMiddle, Valonite, Scabyst, Ambrosium, Continuum, EnderAmethyst, EnderPearl, EnderEye, NetherStar, Frezarite,
        RedMeteor, Dilithium, Zircon, Azurite, Eudialyte, Lazurite, Sodalite, Lapis, Charcoal, Coal, CoalCoke,
        Anthracite, Prismane, Lonsdaleite, Lignite, LigniteCoke, PetCoke, Peat, PeatBituminous, HydratedCoal, Graphene,
        Ectoplasm, Firestone, Redstone, Nikolite, Glowstone, GlowstoneCeres, GlowstoneIo, GlowstoneEnceladus,
        GlowstoneProteus, GlowstonePluto, Gloomstone, MilkyQuartz, NetherQuartz, VoidQuartz, SunnyQuartz,
        LavenderQuartz, RedQuartz, BlazeQuartz, SmokeyQuartz, ManaQuartz, ElvenQuartz, BlackQuartz, CertusQuartz,
        ChargedCertusQuartz, Fluix, Redstonia, Palis, Diamantine, VoidCrystal, Emeradic, Enori, DarkMatter, RedMatter,
        EnergiumRed, EnergiumCyan, InfusedDull, InfusedVis, InfusedAir, InfusedFire, InfusedEarth, InfusedWater,
        InfusedEntropy, InfusedOrder, InfusedBalance, HexoriumBlack, HexoriumRed, HexoriumGreen, HexoriumBlue,
        HexoriumWhite, Sand, RedSand, EndSandWhite, EndSandBlack, SoulSand, SluiceSand, PlatinumGroupSludge, RareEarth,
        Monazite, Force, Forcicium, Forcillium;

    /** The vanilla and world generation Stone Materials. */
    public static OreDictMaterial Stone, Gravel, Concrete, Netherrack, NetherBrick, Endstone, Obsidian, Bedrock,
        PrismarineLight, PrismarineDark, Greenstone, Bluestone, Epidote;

    /** The thermal Dusts. */
    public static OreDictMaterial Oilshale, Petrotheum, Aerotheum, Pyrotheum, Cryotheum;

    /** The Alloys and every Metal that is produced by smelting something else. */
    public static OreDictMaterial WroughtIron, AnnealedCopper, Alduorite, Infuscolium, Rubracium, Meutoite, Lemurite,
        Aredrite, Ceruclase, Oureclase, Kalendrite, Carmot, Sanguinite, Vyroxeres, Eximite, Ignatius, DeepIron,
        ShadowIron, Adamantine, Prometheum, Vulcanite, Orichalcum, AstralSilver, Midasium, Mithril, Celenegil,
        ShadowSteel, Inolashite, Haderoth, Desichalkos, Tartarite, Amordrine, Electrum, SterlingSilver, RoseGold,
        Angmallen, InductiveAlloy, Cd_In_Ag_Alloy, GildedIron, Brass, CobaltBrass, AluminiumAlloy, Bronze, BlackBronze,
        BismuthBronze, Hepatizon, ArsenicCopper, ArsenicBronze, Steel, BlackSteel, BlueSteel, RedSteel, DamascusSteel,
        VanadiumSteel, TungstenSteel, TungstenCarbide, HSLA, SpringSteel, TungstenAlloy, PigIron, IronCompressed,
        IronCast, IronMagnetic, SteelMagnetic, NeodymiumMagnetic, DarkIron, SteelGalvanized, TungstenSintered,
        TitaniumGold, Ta4HfC5, MeteoricIron, MeteoricSteel, MeteoricBlackSteel, MeteoricBlueSteel, MeteoricRedSteel,
        RedAlloy, BlueAlloy, PurpleAlloy, Mingrade, RedstoneAlloy, NikolineAlloy, ElectrotineAlloy, ElectrumFlux,
        ConductiveIron, EnergeticSilver, Invar, Constantan, Cupronickel, Nichrome, Kanthal, Magnalium, StainlessSteel,
        Ultimet, TinAlloy, BatteryAlloy, SolderingAlloy, IronWood, Steeleaf, Knightmetal, FierySteel, Fireleaf,
        MeteoflameSteel, MeteoflameBlackSteel, MeteoflameBlueSteel, MeteoflameRedSteel, FlamascusSteel, Thaumium,
        DarkThaumium, VoidMetal, Osmiridium, Sunnarium, ChromiumDioxide, CrO2, VanadiumGallium, YttriumBariumCuprate,
        NiobiumNitride, NiobiumTitanium, AluminiumBrass, Ardite, Alumite, Manyullyn, VibraniumSteel, VibraniumSilver,
        Vibramantium, Signalum, Lumium, EnderiumBase, Enderium, RefinedGlowstone, RefinedObsidian, Yellorium, Blutonium,
        Cyanite, Ludicrite, Yellorite, Bedrock_HSLA_Alloy, ObsidianSteel, PulsatingIron, EnergeticAlloy, VibrantAlloy,
        ElectricalSteel, Soularium, CrudeSteel, EndSteel, MelodicAlloy, StellarAlloy, VividAlloy, CrystallineAlloy,
        CrystallinePinkSlime, SpectreIron, Manasteel, Terrasteel, ElvenElementium, GaiaSpirit, Endium, Mauftrium,
        Elvorium, NiflheimPower, MuspelheimPower, Iffesal, AncientDebris, Netherite, NetherizedDiamond, Efrine, Desh,
        DeshAlloy, DuraniumAlloy, TritaniumAlloy, Dolamide, Oriharukon, Adamantite, Duralumin, Meteorite, FrozenIron,
        Kreknorite, Syrmorite, Octine, HSSG, HSSE, HSSS, Bedrockium, Draconium, DraconiumAwakened, CrystalMatrix,
        CosmicNeutronium, Infinity, Unstable, Trinaquadalloy, Trinitanium, Iritanium, TitaniumAluminide;

    /**
     * Deprecated full length Aliases, kept so that Mods which used them keep working.
     */
    @Deprecated
    public static OreDictMaterial Trinium, Vibranium, Naquadah, NaquadahEnriched, Naquadria, FakeOsmium, Adamantium,
        Silver, Aluminium, Bismuth, Lead, Argon, Copper, Gold, Iron, Titanium, Calcite, Tungsten, Beryllium, Chromium,
        Manganese, Cobalt, Cobalt60, Nickel, Arsenic, Zirconium, Molybdenum, Technetium, Palladium, Neodymium, Osmium,
        Iridium, Platinum, Thorium, Uranium, Uranium235, Plutonium, Plutonium241, Plutonium243, Americium, Americium241,
        Alumina, AluminiumFluoride, AluminiumHydroxide, Gibbsite, Fluorite, Soapstone, WoodSealed, TeslatineAlloy,
        Teslatite, Electrotine, Olivine;

    /** Moved most Stones to their own Class. */
    @Deprecated
    public static OreDictMaterial SpaceRock, MoonRock, MoonTurf, MarsRock, MarsSand, Holystone, Livingrock, Deadrock,
        Betweenstone, Pitstone, Umber, Redrock, Komatiite, Pumice, Gabbro, Basalt, Marble, Limestone, Greenschist,
        Blueschist, Kimberlite, Quartzite, GraniteRed, GraniteBlack, Granite, Andesite, Diorite, Blackstone, Gneiss,
        Greywacke, Siltstone, Rhyolite, Migmatite, Chert, Dacite, Shale, Slate, Eclogite;

    /** Technical Materials, which are only there for Recipes and such. */
    public static class TECH {

        static {
            MaterialsInit.load();
        }

        @SuppressWarnings("hiding")
        @Deprecated
        public static OreDictMaterial Brick, AnyGlowstone, AnyWax, AnyWood, AnyStone, AnyClay, AnyIron, AnyIronSteel,
            AnyCopper, AnySilicon, AnyTungsten, AnyThaumicCrystal, AnySalt, AnySteel, AnyBronze, AnyMetal;
        public static OreDictMaterial Organic, Crystal, Unknown, Cobblestone, RefinedIron;

        static void init() {
            // These IDs were handed out by older Versions of the Mod, so they keep pointing at their Material.
            OreDictMaterial.addLegacyID(9151, OREMATS.Glauconite);
            OreDictMaterial.addLegacyID(9142, Asbestos);
            OreDictMaterial.addLegacyID(9121, MgCO3);
            OreDictMaterial.addLegacyID(9168, Talc);
            OreDictMaterial.addLegacyID(8719, Ge);
            OreDictMaterial.addLegacyID(8738, NikolineAlloy);
            OreDictMaterial.addLegacyID(8339, Nikolite);
            OreDictMaterial.addLegacyID(8359, Nikolite);
            OreDictMaterial.addLegacyID(8510, Stone);

            Ad.setOreMultiplier(2)
                .setCrushing(Adamantine, U);
            Fe.setOreMultiplier(3)
                .setCrushing(Fe2O3, U);
            Al.setOreMultiplier(2)
                .setCrushing(Al2O3, U);
            Ti.setOreMultiplier(2)
                .setCrushing(TiO2, U);
            W.setOreMultiplier(2)
                .setCrushing(OREMATS.Scheelite, U);
            U_238.setOreMultiplier(2)
                .setCrushing(OREMATS.Uraninite, U);
            F.setOreMultiplier(2)
                .setCrushing(CaF2, U);
            Ta.setOreMultiplier(2)
                .setCrushing(OREMATS.Tantalite, U);
            Nb.setOreMultiplier(2)
                .setCrushing(OREMATS.Columbite, U);
            Nq_528.setOreMultiplier(2)
                .setCrushing(Nq, U);
            Nq_522.setOreMultiplier(4)
                .setCrushing(Nq, U);
            Dilithium.setOreMultiplier(2)
                .setCrushing(Dolamide, U);
            Meteorite.setOreMultiplier(2);
            MeteoricIron.setOreMultiplier(2);
            MeteoricSteel.setOreMultiplier(2);
            Amber.setOreMultiplier(2);
            AmberGolden.setOreMultiplier(2);
            AmberDominican.setOreMultiplier(2);
            Zircon.setOreMultiplier(2);
            Draconium.setOreMultiplier(2);
            OREMATS.Borax.setOreMultiplier(2);
            OREMATS.Cassiterite.setOreMultiplier(2);
            OREMATS.Bastnasite.setOreMultiplier(3);
            Monazite.setOreMultiplier(2);
            Scabyst.setOreMultiplier(2);
            Phosphorus.setOreMultiplier(3);
            PhosphorusBlue.setOreMultiplier(3);
            PhosphorusRed.setOreMultiplier(3);
            PhosphorusWhite.setOreMultiplier(3);
            NaNO3.setOreMultiplier(3);
            KNO3.setOreMultiplier(3);
            Apatite.setOreMultiplier(4);
            Bone.setOreMultiplier(4);
            Lapis.setOreMultiplier(5);
            Sodalite.setOreMultiplier(5);
            Lazurite.setOreMultiplier(5);
            OREMATS.Malachite.setOreMultiplier(5);
            Azurite.setOreMultiplier(5);
            Eudialyte.setOreMultiplier(5);
            Moonstone.setOreMultiplier(2);
            Sunstone.setOreMultiplier(4);
            Chimerite.setOreMultiplier(3);
            OREMATS.Perlite.setOreMultiplier(8);

            Empty.put(MD.MC);
            Wood.put(MD.MC);
            Stone.put(MD.MC);
            Fe.put(MD.MC); // don't COMMON_ORE this!
            Au.put(MD.MC, COMMON_ORE);
            Diamond.put(MD.MC, COMMON_ORE);
            Emerald.put(MD.MC, COMMON_ORE);
            NetherQuartz.put(MD.MC, COMMON_ORE);
            Lapis.put(MD.MC, COMMON_ORE);
            Redstone.put(MD.MC, COMMON_ORE);
            Glowstone.put(MD.MC, COMMON_ORE);
            Coal.put(MD.MC, COMMON_ORE);
            Charcoal.put(MD.MC);
            EnderPearl.put(MD.MC);
            EnderEye.put(MD.MC);
            Blaze.put(MD.MC);
            Breeze.put(MD.MC);
            Gunpowder.put(MD.MC);
            Sugar.put(MD.MC);
            Cocoa.put(MD.MC);
            Milk.put(MD.MC);
            Paper.put(MD.MC);
            Clay.put(MD.MC);
            Netherrack.put(MD.MC);
            NetherBrick.put(MD.MC);
            SoulSand.put(MD.MC);
            NetherStar.put(MD.MC);
            Endstone.put(MD.MC);
            Bedrock.put(MD.MC);
            Sand.put(MD.MC);
            RedSand.put(MD.MC);
            Glass.put(MD.MC);
            H2O.put(MD.MC);
            Snow.put(MD.MC);
            Ice.put(MD.MC);
            Bone.put(MD.MC);
            Lava.put(MD.MC);
            Flint.put(MD.MC);
            Obsidian.put(MD.MC);
            Leather.put(MD.MC);
            MeatRotten.put(MD.MC);
            Wheat.put(MD.MC);
            Potato.put(MD.MC);

            Black.put(MD.MC);
            Red.put(MD.MC);
            Green.put(MD.MC);
            Brown.put(MD.MC);
            Blue.put(MD.MC);
            Purple.put(MD.MC);
            Cyan.put(MD.MC);
            LightGray.put(MD.MC);
            Gray.put(MD.MC);
            Pink.put(MD.MC);
            Lime.put(MD.MC);
            Yellow.put(MD.MC);
            LightBlue.put(MD.MC);
            Magenta.put(MD.MC);
            Orange.put(MD.MC);
            White.put(MD.MC);

            Cu.put(MD.EtFu, COMMON_ORE);
            STONES.Deepslate.put(MD.EtFu);
            STONES.Granite.put(MD.EtFu);
            STONES.Diorite.put(MD.EtFu);
            STONES.Andesite.put(MD.EtFu);
            PrismarineLight.put(MD.EtFu);
            PrismarineDark.put(MD.EtFu);

            NaCl.put(MD.HaC, COMMON_ORE);
            WaxPlant.put(MD.HaC);
            Barley.put(MD.HaC);
            Rye.put(MD.HaC);
            Rice.put(MD.HaC);
            Oat.put(MD.HaC);
            Corn.put(MD.HaC);
            Tofu.put(MD.HaC);
            Chocolate.put(MD.HaC);
            Cinnamon.put(MD.HaC);
            Nutmeg.put(MD.HaC);
            Peanut.put(MD.HaC);
            Pistachio.put(MD.HaC);
            Almond.put(MD.HaC);
            Vanilla.put(MD.HaC);
            PepperBlack.put(MD.HaC);
            Curry.put(MD.HaC);
            ButterSalted.put(MD.HaC);
            OliveOil.put(MD.HaC);

            NaHCO3.put(MD.Salt);

            Butter.put(MD.GrC);

            Netherite.put(MD.NePl, COMMON_ORE);
            NetherizedDiamond.put(MD.NePl);
            AncientDebris.put(MD.NePl, COMMON_ORE);

            Efrine.put(MD.NeLi, COMMON_ORE);
            VoidCrystal.put(MD.NeLi, COMMON_ORE);
            Gloomstone.put(MD.NeLi, COMMON_ORE);
            OatAbyssal.put(MD.NeLi);
            STONES.Basalt.put(MD.NeLi);
            STONES.Blackstone.put(MD.NeLi);

            Sugilite.put(MD.EnLi, COMMON_ORE);
            EndSandWhite.put(MD.EnLi);
            EndSandBlack.put(MD.EnLi);

            Zn.put(MD.GT, COMMON_ORE);
            Be.put(MD.GT, COMMON_ORE);
            Th.put(MD.GT, COMMON_ORE);
            Li.put(MD.GT, COMMON_ORE);
            Phosphorus.put(MD.GT, COMMON_ORE);
            Craponite.put(MD.GT);
            NitroCarbon.put(MD.GT);
            NitroFuel.put(MD.GT);
            SoylentGreen.put(MD.GT);
            ClayBrown.put(MD.GT);
            ClayRed.put(MD.GT);
            Ceramic.put(MD.GT);
            SluiceSand.put(MD.GT);
            SunflowerOil.put(MD.GT);
            NutOil.put(MD.GT);
            LinOil.put(MD.GT);
            HempOil.put(MD.GT);
            Glue.put(MD.GT);
            HolyWater.put(MD.GT);
            Nichrome.put(MD.GT);
            Kanthal.put(MD.GT);
            VanadiumGallium.put(MD.GT);
            YttriumBariumCuprate.put(MD.GT);
            Graphene.put(MD.GT);
            Magnalium.put(MD.GT);
            BatteryAlloy.put(MD.GT);
            SolderingAlloy.put(MD.GT);
            AnnealedCopper.put(MD.GT);
            IronMagnetic.put(MD.GT);
            SteelMagnetic.put(MD.GT);
            NeodymiumMagnetic.put(MD.GT);
            CobaltBrass.put(MD.GT);
            Ultimet.put(MD.GT);
            SteelGalvanized.put(MD.GT);
            StainlessSteel.put(MD.GT);
            TungstenSteel.put(MD.GT);
            NiobiumTitanium.put(MD.GT);
            Ta4HfC5.put(MD.GT);
            Al2O3.put(MD.GT);
            Osmiridium.put(MD.GT);
            UUAmplifier.put(MD.GT);
            Primitive.put(MD.GT);
            Good.put(MD.GT);
            Data.put(MD.GT);
            Master.put(MD.GT);

            Vb.put(MD.GT, BETWEENLANDS, MAZEBREAKER);
            VibraniumSilver.put(MD.GT, BETWEENLANDS, MAZEBREAKER);
            Ad.put(MD.GT, BETWEENLANDS, MAZEBREAKER); // don't COMMON_ORE this!
            Vibramantium.put(MD.GT, BETWEENLANDS, MAZEBREAKER);
            VibraniumSteel.put(MD.GT, BETWEENLANDS, MAZEBREAKER);
            Dn.put(MD.GT, COMMON_ORE);
            DuraniumAlloy.put(MD.GT);
            Ke.put(MD.GT, COMMON_ORE);
            Trinitanium.put(MD.GT);
            Nq.put(MD.GT, COMMON_ORE);
            Nq_522.put(MD.GT, COMMON_ORE);
            Nq_528.put(MD.GT, COMMON_ORE);

            HSSG.put(MD.GT5U);
            HSSE.put(MD.GT5U);
            HSSS.put(MD.GT5U);
            PlatinumGroupSludge.put(MD.GT5U);

            Superconductor.put(COMMON_ORE)
                .setOriginalMod("rocketscience", "Rocket Science (Old IC2 Addon)");

            Os.put(COMMON_ORE)
                .setOriginalMod("gravisuite", "Gravisuite (Old IC2 Addon)");

            Sn.put(MD.IC2, COMMON_ORE);
            Bronze.put(MD.IC2);
            RefinedIron.put(MD.IC2);
            Ir.put(MD.IC2, COMMON_ORE);
            U_238.put(MD.IC2); // don't COMMON_ORE this!
            U_235.put(MD.IC2); // don't COMMON_ORE this!
            Pu.put(MD.IC2); // don't COMMON_ORE this!
            DistWater.put(MD.IC2);
            SiO2.put(MD.IC2);
            EnergiumRed.put(MD.IC2);
            ConstructionFoam.put(MD.IC2);
            UUMatter.put(MD.IC2);
            HydratedCoal.put(MD.IC2);
            Coffee.put(MD.IC2);
            Rubber.put(MD.IC2);
            WoodRubber.put(MD.IC2);
            Advanced.put(MD.IC2);

            SiC.put(MD.IHL);
            H2Ca2B2Si2O10.put(MD.IHL);
            H3BO3.put(MD.IHL);
            Li2O.put(MD.IHL);
            NaOH.put(MD.IHL);
            NaHSO4.put(MD.IHL);
            H2O2.put(MD.IHL);
            Li2Fe2O4.put(MD.IHL);
            Porcelain.put(MD.IHL);

            Oil.put(MD.BC);
            Fuel.put(MD.BC);

            I.put(MD.FR);
            Ash.put(MD.FR);
            Peat.put(MD.FR);
            PeatBituminous.put(MD.FR);
            Apatite.put(MD.FR);
            PhosphorusBlue.put(MD.FR);
            Biomass.put(MD.FR);
            BioFuel.put(MD.FR);
            Ethanol.put(MD.FR);
            SeedOil.put(MD.FR);
            Honey.put(MD.FR);
            Honeydew.put(MD.FR);
            Wax.put(MD.FR);
            WaxBee.put(MD.FR);
            WaxRefractory.put(MD.FR);

            WaxMagic.put(MD.FRMB);
            WaxAmnesic.put(MD.FRMB);
            WaxSoulful.put(MD.FRMB);

            Bark.put(MD.BINNIE);
            Hazelnut.put(MD.BINNIE);

            Bi.put(MD.TFC, COMMON_ORE);
            Jasper.put(MD.TFC);
            WroughtIron.put(MD.TFC);
            RoseGold.put(MD.TFC);
            SterlingSilver.put(MD.TFC);
            BlackBronze.put(MD.TFC);
            BismuthBronze.put(MD.TFC);
            BlackSteel.put(MD.TFC);
            RedSteel.put(MD.TFC);
            BlueSteel.put(MD.TFC);
            MeteoricBlackSteel.put(MD.TFC);
            MeteoricBlueSteel.put(MD.TFC);
            MeteoricRedSteel.put(MD.TFC);

            STONES.Mazestone.put(MD.TF)
                .visDefault();
            STONES.Castlerock.put(MD.TF)
                .visDefault();
            STONES.Deadrock.put(MD.TF)
                .visDefault();
            LiveRoot.put(MD.TF);
            IronWood.put(MD.TF);
            Steeleaf.put(MD.TF);
            Knightmetal.put(MD.TF, MAZEBREAKER)
                .visDefault();
            FierySteel.put(MD.TF, MAZEBREAKER)
                .visDefault();
            Fireleaf.put(MD.TF, MAZEBREAKER)
                .visDefault(Steeleaf);
            MeteoflameSteel.put(MD.TF, MAZEBREAKER)
                .visDefault(FierySteel);
            MeteoflameBlackSteel.put(MD.TF, MAZEBREAKER)
                .visDefault(FierySteel);
            MeteoflameBlueSteel.put(MD.TF, MAZEBREAKER)
                .visDefault(FierySteel);
            MeteoflameRedSteel.put(MD.TF, MAZEBREAKER)
                .visDefault(FierySteel);
            FlamascusSteel.put(MD.TF, MAZEBREAKER)
                .visDefault(FierySteel);

            STONES.Umber.put(MD.ERE)
                .visDefault();
            STONES.Gneiss.put(MD.ERE);
            PetrifiedWood.put(MD.ERE);
            Jade.put(MD.ERE);

            K.put(MD.RC);
            S.put(MD.RC, COMMON_ORE);
            KNO3.put(MD.RC, COMMON_ORE);
            Firestone.put(MD.RC, COMMON_ORE)
                .visDefault();
            Creosote.put(MD.RC);
            TinAlloy.put(MD.RC);
            Steel.put(MD.RC);
            CoalCoke.put(MD.RC);

            Constantan.put(MD.IE);
            WoodTreated.put(MD.IE);

            Ni.put(MD.TE, COMMON_ORE);
            Pt.put(MD.TE, COMMON_ORE);
            Invar.put(MD.TE);
            Electrum.put(MD.TE);
            Enderium.put(MD.TE);
            Signalum.put(MD.TE);
            Lumium.put(MD.TE);
            RareEarth.put(MD.TE, COMMON_ORE);
            Niter.put(MD.TE, COMMON_ORE);
            Basalz.put(MD.TE);
            Blitz.put(MD.TE);
            Blizz.put(MD.TE);
            Petrotheum.put(MD.TE);
            Aerotheum.put(MD.TE);
            Pyrotheum.put(MD.TE);
            Cryotheum.put(MD.TE);

            STONES.SkyStone.put(MD.AE)
                .visDefault();
            Si.put(MD.AE); // don't COMMON_ORE this!
            CertusQuartz.put(MD.AE, COMMON_ORE);
            ChargedCertusQuartz.put(MD.AE, COMMON_ORE);
            Fluix.put(MD.AE, COMMON_ORE);

            IronCompressed.put(MD.PnC)
                .visDefault();

            IronCast.put(MD.SC2)
                .visDefault();
            WhaleOil.put(MD.SC2);

            Al.put(MD.TiC); // don't COMMON_ORE this!
            Co.put(MD.TiC, COMMON_ORE);
            Ardite.put(MD.TiC, COMMON_ORE)
                .visDefault();
            Alumite.put(MD.TiC);
            Manyullyn.put(MD.TiC, BETWEENLANDS)
                .visDefault(Ardite);
            AluminiumBrass.put(MD.TiC);

            BlackQuartz.put(MD.AA)
                .visDefault();

            RedstoneAlloy.put(MD.EIO);
            EnderiumBase.put(MD.EIO);
            PulsatingIron.put(MD.EIO);
            ConductiveIron.put(MD.EIO);
            EnergeticAlloy.put(MD.EIO);
            VibrantAlloy.put(MD.EIO);
            ElectricalSteel.put(MD.EIO);
            Soularium.put(MD.EIO);
            CrudeSteel.put(MD.EIO);
            CrystallineAlloy.put(MD.EIO);
            CrystallinePinkSlime.put(MD.EIO);
            EndSteel.put(MD.EIO);
            EnergeticSilver.put(MD.EIO);
            MelodicAlloy.put(MD.EIO);
            StellarAlloy.put(MD.EIO);
            VividAlloy.put(MD.EIO);

            MeatRaw.put(MD.MFR);
            MeatCooked.put(MD.MFR);
            Plastic.put(MD.MFR);

            Yellorium.put(MD.BR, COMMON_ORE)
                .visDefault();
            Blutonium.put(MD.BR, COMMON_ORE)
                .visDefault();
            Cyanite.put(MD.BR, COMMON_ORE)
                .visDefault();
            Ludicrite.put(MD.BR, COMMON_ORE)
                .visDefault();
            Yellorite.put(MD.BR, COMMON_ORE)
                .visDefault();

            Pu_238.put(MD.HBM)
                .visDefault();
            Pu_240.put(MD.HBM)
                .visDefault();
            Mingrade.put(MD.HBM);
            PhosphorusRed.put(MD.HBM);
            PhosphorusWhite.put(MD.HBM);
            Alexandrite.put(MD.HBM);
            Asbestos.put(MD.HBM, COMMON_ORE);
            OREMATS.Columbite.put(MD.HBM, COMMON_ORE);
            OREMATS.Tantalite.put(MD.HBM, COMMON_ORE);
            OREMATS.Coltan.put(MD.HBM, COMMON_ORE);
            Ta.put(MD.HBM); // don't COMMON_ORE this!
            Nb.put(MD.HBM); // don't COMMON_ORE this!
            Nd.put(MD.HBM);
            DeshAlloy.put(MD.HBM);
            PVC.put(MD.HBM)
                .visDefault();
            Teflon.put(MD.HBM)
                .visDefault();
            Bakelite.put(MD.HBM)
                .visDefault();
            Polycarbonate.put(MD.HBM)
                .visDefault();

            In.put(MD.ReC);
            TungstenCarbide.put(MD.ReC);

            Anthracite.put(MD.RoC, COMMON_ORE)
                .visDefault();
            Prismane.put(MD.RoC)
                .visDefault();
            Lonsdaleite.put(MD.RoC)
                .visDefault();
            Lubricant.put(MD.RoC);
            F.put(MD.RoC); // don't COMMON_ORE this!
            CaF2.put(MD.RoC);
            AgI.put(MD.RoC);
            InductiveAlloy.put(MD.RoC);
            Prismane.put(MD.RoC);
            Lonsdaleite.put(MD.RoC);
            Cd_In_Ag_Alloy.put(MD.RoC);
            HSLA.put(MD.RoC)
                .visDefault();
            SpringSteel.put(MD.RoC)
                .visDefault();
            AluminiumAlloy.put(MD.RoC)
                .visDefault();
            TungstenAlloy.put(MD.RoC)
                .visDefault();
            TungstenSintered.put(MD.RoC)
                .visDefault();
            Bedrock_HSLA_Alloy.put(MD.RoC, BETWEENLANDS, MAZEBREAKER)
                .visDefault(HSLA);

            RefinedGlowstone.put(MD.Mek)
                .visDefault();
            RefinedObsidian.put(MD.Mek)
                .visDefault();
            Ge.put(MD.Mek, COMMON_ORE);
            Basic.put(MD.Mek);
            Elite.put(MD.Mek);

            InfusedVis.put(MD.TC)
                .visDefault();
            Silverwood.put(MD.TC)
                .visDefault();
            Greatwood.put(MD.TC)
                .visDefault();
            Tallow.put(MD.TC)
                .visDefault();
            VoidMetal.put(MD.TC, BETWEENLANDS, MAZEBREAKER)
                .visDefault();
            Thaumium.put(MD.TC, COMMON_ORE)
                .visDefault();
            Amber.put(MD.TC, COMMON_ORE);
            Hg.put(MD.TC, COMMON_ORE);
            OREMATS.Cinnabar.put(MD.TC, COMMON_ORE);

            DarkThaumium.put(MD.TCTE)
                .visDefault();

            Livingwood.put(MD.BOTA)
                .visDefault();
            STONES.Livingrock.put(MD.BOTA)
                .visDefault();
            Dreamwood.put(MD.BOTA)
                .visDefault();
            Shimmerwood.put(MD.BOTA)
                .visDefault();
            SunnyQuartz.put(MD.BOTA)
                .visDefault();
            LavenderQuartz.put(MD.BOTA)
                .visDefault();
            RedQuartz.put(MD.BOTA)
                .visDefault();
            BlazeQuartz.put(MD.BOTA)
                .visDefault();
            SmokeyQuartz.put(MD.BOTA)
                .visDefault();
            ManaQuartz.put(MD.BOTA)
                .visDefault();
            ElvenQuartz.put(MD.BOTA)
                .visDefault();
            Manasteel.put(MD.BOTA)
                .visDefault();
            ManaDiamond.put(MD.BOTA)
                .visDefault();
            ElvenElementium.put(MD.BOTA)
                .visDefault();
            ElvenDragonstone.put(MD.BOTA)
                .visDefault();
            Terrasteel.put(MD.BOTA)
                .visDefault();
            GaiaSpirit.put(MD.BOTA, BETWEENLANDS, MAZEBREAKER)
                .visDefault();

            Mauftrium.put(MD.ALF)
                .visDefault();
            Elvorium.put(MD.ALF)
                .visDefault();
            MuspelheimPower.put(MD.ALF)
                .visDefault();
            NiflheimPower.put(MD.ALF)
                .visDefault();
            Iffesal.put(MD.ALF)
                .visDefault();

            PEZ.put(MD.CANDY);
            Licorice.put(MD.CANDY);
            Nougat.put(MD.CANDY);
            Marshmallow.put(MD.CANDY);

            Iritanium.put(MD.GC_ADV_ROCKETRY);
            TitaniumAluminide.put(MD.GC_ADV_ROCKETRY);

            Endium.put(MD.HEE, COMMON_ORE);
            OREMATS.Sphalerite.put(MD.HEE, COMMON_ORE);

            Ti.put(MD.MaCu); // don't COMMON_ORE this!
            TiO2.put(MD.MaCu, COMMON_ORE);
            FishCooked.put(MD.MaCu);
            FishRaw.put(MD.MaCu);
            FishRotten.put(MD.MaCu);
            FishOil.put(MD.MaCu);

            An.put(MD.ABYSSAL, COMMON_ORE)
                .visDefault();
            Cor.put(MD.ABYSSAL, COMMON_ORE)
                .visDefault();
            Dr.put(MD.ABYSSAL, COMMON_ORE)
                .visDefault();
            Etx.put(MD.ABYSSAL, COMMON_ORE)
                .visDefault();

            AmberDominican.put(MD.Fossil, COMMON_ORE);

            Draconium.put(MD.DE, COMMON_ORE);
            DraconiumAwakened.put(MD.DE, BETWEENLANDS, MAZEBREAKER)
                .visDefault();

            CrystalMatrix.put(MD.AV)
                .visDefault();
            CosmicNeutronium.put(MD.AV)
                .visDefault();
            Infinity.put(MD.AV, BETWEENLANDS, MAZEBREAKER)
                .visDefault();

            DarkMatter.put(MD.PE, BETWEENLANDS, MAZEBREAKER)
                .visDefault();
            RedMatter.put(MD.PE, BETWEENLANDS, MAZEBREAKER)
                .visDefault();

            Zr.put(MD.TROPIC);
            Zircon.put(MD.TROPIC);
            Azurite.put(MD.TROPIC);
            Eudialyte.put(MD.TROPIC);

            Topaz.put(MD.BoP, COMMON_ORE);
            Peridot.put(MD.BoP, COMMON_ORE);
            Amethyst.put(MD.BoP, COMMON_ORE);
            EnderAmethyst.put(MD.BoP, COMMON_ORE)
                .visDefault();

            Meteorite.put(MD.FM, COMMON_ORE)
                .visDefault();
            FrozenIron.put(MD.FM)
                .visDefault();
            Kreknorite.put(MD.FM)
                .visDefault();
            RedMeteor.put(MD.FM)
                .visDefault();
            Frezarite.put(MD.FM)
                .visDefault();

            Vinteum.put(MD.ARS, COMMON_ORE)
                .visDefault();
            VinteumPurified.put(MD.ARS)
                .visDefault();
            ArcaneAsh.put(MD.ARS)
                .visDefault();
            ArcaneCompound.put(MD.ARS)
                .visDefault();
            Moonstone.put(MD.ARS, COMMON_ORE)
                .visDefault();
            Sunstone.put(MD.ARS, COMMON_ORE)
                .visDefault();
            Chimerite.put(MD.ARS, COMMON_ORE)
                .visDefault();
            BlueTopaz.put(MD.ARS, COMMON_ORE);

            MeteoricIron.put(MD.GC);
            MeteoricSteel.put(MD.GC);
            Desh.put(MD.GC, COMMON_ORE);
            Cheese.put(MD.GC, COMMON_ORE);
            STONES.MoonTurf.put(MD.GC)
                .visDefault();
            STONES.MoonRock.put(MD.GC)
                .visDefault();
            STONES.MarsSand.put(MD.GC)
                .visDefault();
            STONES.MarsRock.put(MD.GC)
                .visDefault();
            STONES.SpaceRock.put(MD.GC)
                .visDefault();
            Ultimate.put(MD.GC);

            DiamondBlue.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            DiamondGreen.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            DiamondPurple.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            DiamondRed.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            DiamondYellow.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.PhobosRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.DeimosRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.MercuryRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.VenusRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.CeresRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.JupiterRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.IoRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.EuropaRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.GanymedeRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.CallistoRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.SaturnRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.RheaRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.TitanRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.OberonRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.IapetusRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.UranusRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.TitaniaRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.NeptuneRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.TritonRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.PlutoRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.ErisRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();
            STONES.Kepler22bRock.put(MD.GC_EXTRAPLANETS)
                .visDefault();

            Duralumin.put(MD.GC_GALAXYSPACE, COMMON_ORE);
            Oriharukon.put(MD.GC_GALAXYSPACE, COMMON_ORE)
                .visDefault();
            Adamantite.put(MD.GC_GALAXYSPACE, COMMON_ORE);
            GlowstoneCeres.put(MD.GC_GALAXYSPACE)
                .visDefault();
            GlowstoneIo.put(MD.GC_GALAXYSPACE)
                .visDefault();
            GlowstoneEnceladus.put(MD.GC_GALAXYSPACE)
                .visDefault();
            GlowstoneProteus.put(MD.GC_GALAXYSPACE)
                .visDefault();
            GlowstonePluto.put(MD.GC_GALAXYSPACE)
                .visDefault();

            Tn.put(MD.MO); // don't COMMON_ORE this!
            TritaniumAlloy.put(MD.MO, COMMON_ORE);
            Dilithium.put(MD.MO); // don't COMMON_ORE this!
            Dolamide.put(MD.MO);

            SpectreIron.put(MD.RT);
            Ectoplasm.put(MD.RT);

            Unstable.put(MD.ExU, BETWEENLANDS)
                .visDefault();
            Bedrockium.put(MD.ExU, BETWEENLANDS)
                .visDefault();

            CrimsonMiddle.put(MD.BTL, BETWEENLANDS)
                .visDefault();
            GreenMiddle.put(MD.BTL, BETWEENLANDS)
                .visDefault();
            AquaMiddle.put(MD.BTL, BETWEENLANDS)
                .visDefault();
            Valonite.put(MD.BTL, BETWEENLANDS)
                .visDefault();
            Scabyst.put(MD.BTL, BETWEENLANDS)
                .visDefault();
            SlimyBone.put(MD.BTL, BETWEENLANDS)
                .visDefault();
            STONES.Betweenstone.put(MD.BTL, BETWEENLANDS)
                .visDefault();
            STONES.Pitstone.put(MD.BTL, BETWEENLANDS)
                .visDefault();
            STONES.Cragrock.put(MD.BTL, BETWEENLANDS)
                .visDefault();
            STONES.Templerock.put(MD.BTL, BETWEENLANDS)
                .visDefault();
            Weedwood.put(MD.BTL, BETWEENLANDS)
                .visDefault();
            Syrmorite.put(MD.BTL, BETWEENLANDS, COMMON_ORE)
                .visDefault();
            Octine.put(MD.BTL, BETWEENLANDS, COMMON_ORE)
                .visDefault();

            Skyroot.put(MD.AETHER)
                .visDefault();
            STONES.Holystone.put(MD.AETHER)
                .visDefault();
            Zanite.put(MD.AETHER, COMMON_ORE)
                .visDefault();
            AmberGolden.put(MD.AETHER, COMMON_ORE)
                .visDefault();
            Ambrosium.put(MD.AETHER, COMMON_ORE)
                .visDefault();
            Gravitite.put(MD.AETHER, COMMON_ORE)
                .visDefault();
            Continuum.put(MD.AETHER, COMMON_ORE)
                .visDefault();

            W.put(MD.RP); // don't COMMON_ORE this!
            Ag.put(MD.RP, COMMON_ORE);
            Indigo.put(MD.RP);
            Sapphire.put(MD.RP);
            GreenSapphire.put(MD.RP);
            BlueSapphire.put(MD.RP);
            Ruby.put(MD.RP);
            BalasRuby.put(MD.RP);
            STONES.Marble.put(MD.RP);
            Brass.put(MD.RP);
            RedAlloy.put(MD.RP);
            Nikolite.put(MD.RP, COMMON_ORE)
                .visDefault();
            NikolineAlloy.put(MD.RP)
                .visDefault(Nikolite);
            BlueAlloy.put(MD.RP)
                .visDefault(Nikolite);
            EnergiumCyan.visDefault(Nikolite);

            ElectrotineAlloy.put(MD.PR)
                .visDefault(Nikolite);

            PurpleAlloy.put(MD.BP)
                .visDefault(Nikolite);

            Pb.put(MD.FZ, COMMON_ORE);
            OREMATS.Galena.put(MD.FZ, COMMON_ORE);
            H2SO4.put(MD.FZ);
            AquaRegia.put(MD.FZ);
            DarkIron.put(MD.FZ)
                .visDefault();

            Bentonite.put(MD.PFAA);
            Palygorskite.put(MD.PFAA);
            Kaolinite.put(MD.PFAA);
            OREMATS.BasalticMineralSand.put(MD.PFAA);
            OREMATS.GraniticMineralSand.put(MD.PFAA);

            Lignite.put(MD.UB, COMMON_ORE);

            Angmallen.put(MD.MET);
            Hepatizon.put(MD.MET);
            DamascusSteel.put(MD.MET);
            Aredrite.put(MD.MET); // Fantasy
            Atl.put(MD.MET); // Fantasy
            Tartarite.put(MD.MET); // Fantasy
            Adamantine.put(MD.MET); // Fantasy
            AstralSilver.put(MD.MET); // Fantasy
            Mithril.put(MD.MET); // Fantasy
            Infuscolium.put(MD.MET)
                .visDefault(); // Fantasy
            Rubracium.put(MD.MET)
                .visDefault(); // Fantasy
            Oureclase.put(MD.MET)
                .visDefault(); // Fantasy
            Orichalcum.put(MD.MET); // Fantasy
            Carmot.put(MD.MET)
                .visDefault(); // Fantasy
            Prometheum.put(MD.MET)
                .visDefault(); // Fantasy
            DeepIron.put(MD.MET)
                .visDefault(); // Fantasy
            Haderoth.put(MD.MET)
                .visDefault(); // Fantasy
            Celenegil.put(MD.MET)
                .visDefault(); // Fantasy
            Meutoite.put(MD.MET)
                .visDefault(); // Ender
            Eximite.put(MD.MET)
                .visDefault(); // Ender
            Desichalkos.put(MD.MET)
                .visDefault(); // Ender
            Midasium.put(MD.MET); // Nether
            Alduorite.put(MD.MET)
                .visDefault(); // Nether
            Lemurite.put(MD.MET)
                .visDefault(); // Nether
            Ceruclase.put(MD.MET)
                .visDefault(); // Nether
            Kalendrite.put(MD.MET)
                .visDefault(); // Nether
            Sanguinite.put(MD.MET)
                .visDefault(); // Nether
            Vyroxeres.put(MD.MET)
                .visDefault(); // Nether
            Ignatius.put(MD.MET)
                .visDefault(); // Nether
            Vulcanite.put(MD.MET); // Nether
            ShadowIron.put(MD.MET)
                .visDefault(); // Nether
            ShadowSteel.put(MD.MET)
                .visDefault(); // Nether
            Inolashite.put(MD.MET)
                .visDefault(); // Nether
            Amordrine.put(MD.MET)
                .visDefault(); // Nether

            Force.put(COMMON_ORE)
                .visDefault(); // Was this one DartCraft?
            Forcicium.put(COMMON_ORE)
                .visDefault(); // This was one of the Force Field Mods.
            Forcillium.put(COMMON_ORE)
                .visDefault(); // And this was ANOTHER Force Field Mod.

            Plastic.addEnchantmentForDamage(Enchantment.knockback, 1)
                .addEnchantmentForRanged(Enchantment.punch, 1);
            Bakelite.addEnchantmentForDamage(Enchantment.knockback, 1)
                .addEnchantmentForRanged(Enchantment.punch, 1);
            Teflon.addEnchantmentForDamage(Enchantment.knockback, 1)
                .addEnchantmentForRanged(Enchantment.punch, 1);
            PVC.addEnchantmentForDamage(Enchantment.knockback, 2)
                .addEnchantmentForRanged(Enchantment.punch, 2);
            Polycarbonate.addEnchantmentForDamage(Enchantment.knockback, 2)
                .addEnchantmentForRanged(Enchantment.punch, 2);
            Rubber.addEnchantmentForDamage(Enchantment.knockback, 2)
                .addEnchantmentForRanged(Enchantment.punch, 2);
            Kalendrite.addEnchantmentForDamage(Enchantment.knockback, 2)
                .addEnchantmentForRanged(Enchantment.punch, 2);
            InfusedAir.addEnchantmentForDamage(Enchantment.knockback, 2)
                .addEnchantmentForRanged(Enchantment.punch, 2);
            Blitz.addEnchantmentForDamage(Enchantment.knockback, 3)
                .addEnchantmentForRanged(Enchantment.punch, 3);
            Gravitite.addEnchantmentForDamage(Enchantment.knockback, 3)
                .addEnchantmentForRanged(Enchantment.punch, 3);
            DarkIron.addEnchantmentForDamage(Enchantment.knockback, 3)
                .addEnchantmentForRanged(Enchantment.punch, 3);
            Tartarite.addEnchantmentForDamage(Enchantment.knockback, 3)
                .addEnchantmentForRanged(Enchantment.punch, 3);
            DarkMatter.addEnchantmentForDamage(Enchantment.knockback, 3)
                .addEnchantmentForRanged(Enchantment.punch, 3);
            RedMeteor.addEnchantmentForDamage(Enchantment.knockback, 3)
                .addEnchantmentForRanged(Enchantment.punch, 3);
            Infinity.addEnchantmentForDamage(Enchantment.knockback, 10)
                .addEnchantmentForRanged(Enchantment.punch, 10);

            Skyroot.addEnchantmentForTools(Enchantment.fortune, 1)
                .addEnchantmentForWeapons(Enchantment.looting, 1)
                .addEnchantmentForAmmo(Enchantment.looting, 2)
                .addEnchantmentForRanged(Enchantment.infinity, 1)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 1);
            IronWood.addEnchantmentForTools(Enchantment.fortune, 1)
                .addEnchantmentForWeapons(Enchantment.looting, 1)
                .addEnchantmentForAmmo(Enchantment.looting, 2)
                .addEnchantmentForRanged(Enchantment.infinity, 1)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 1);
            Steeleaf.addEnchantmentForTools(Enchantment.fortune, 2)
                .addEnchantmentForWeapons(Enchantment.looting, 2)
                .addEnchantmentForAmmo(Enchantment.looting, 4)
                .addEnchantmentForRanged(Enchantment.infinity, 2)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 2);
            Fireleaf.addEnchantmentForTools(Enchantment.fortune, 3)
                .addEnchantmentForWeapons(Enchantment.looting, 3)
                .addEnchantmentForAmmo(Enchantment.looting, 6)
                .addEnchantmentForRanged(Enchantment.infinity, 3)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 3);
            Efrine.addEnchantmentForTools(Enchantment.fortune, 2)
                .addEnchantmentForWeapons(Enchantment.looting, 2)
                .addEnchantmentForAmmo(Enchantment.looting, 4)
                .addEnchantmentForRanged(Enchantment.infinity, 2)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 2);
            Soularium.addEnchantmentForTools(Enchantment.fortune, 2)
                .addEnchantmentForWeapons(Enchantment.looting, 2)
                .addEnchantmentForAmmo(Enchantment.looting, 4)
                .addEnchantmentForRanged(Enchantment.infinity, 2)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 2);
            Midasium.addEnchantmentForTools(Enchantment.fortune, 2)
                .addEnchantmentForWeapons(Enchantment.looting, 2)
                .addEnchantmentForAmmo(Enchantment.looting, 4)
                .addEnchantmentForRanged(Enchantment.infinity, 2)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 2);
            Mithril.addEnchantmentForTools(Enchantment.fortune, 3)
                .addEnchantmentForWeapons(Enchantment.looting, 3)
                .addEnchantmentForAmmo(Enchantment.looting, 6)
                .addEnchantmentForRanged(Enchantment.infinity, 3)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 3);
            ElvenQuartz.addEnchantmentForTools(Enchantment.fortune, 3)
                .addEnchantmentForWeapons(Enchantment.looting, 3)
                .addEnchantmentForAmmo(Enchantment.looting, 6)
                .addEnchantmentForRanged(Enchantment.infinity, 3)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 3);
            Vinteum.addEnchantmentForTools(Enchantment.fortune, 1)
                .addEnchantmentForWeapons(Enchantment.looting, 1)
                .addEnchantmentForAmmo(Enchantment.looting, 2)
                .addEnchantmentForRanged(Enchantment.infinity, 1)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 1);
            Manasteel.addEnchantmentForTools(Enchantment.fortune, 2)
                .addEnchantmentForWeapons(Enchantment.looting, 2)
                .addEnchantmentForAmmo(Enchantment.looting, 4)
                .addEnchantmentForRanged(Enchantment.infinity, 2)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 2);
            Thaumium.addEnchantmentForTools(Enchantment.fortune, 2)
                .addEnchantmentForWeapons(Enchantment.looting, 2)
                .addEnchantmentForAmmo(Enchantment.looting, 4)
                .addEnchantmentForRanged(Enchantment.infinity, 2)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 2);
            DarkThaumium.addEnchantmentForTools(Enchantment.fortune, 2)
                .addEnchantmentForWeapons(Enchantment.looting, 2)
                .addEnchantmentForAmmo(Enchantment.looting, 4)
                .addEnchantmentForRanged(Enchantment.infinity, 2)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 2);
            VoidMetal.addEnchantmentForTools(Enchantment.fortune, 3)
                .addEnchantmentForWeapons(Enchantment.looting, 3)
                .addEnchantmentForAmmo(Enchantment.looting, 6)
                .addEnchantmentForRanged(Enchantment.infinity, 3)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 3);
            InfusedWater.addEnchantmentForTools(Enchantment.fortune, 3)
                .addEnchantmentForWeapons(Enchantment.looting, 3)
                .addEnchantmentForAmmo(Enchantment.looting, 6)
                .addEnchantmentForRanged(Enchantment.infinity, 3)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 3);
            Eximite.addEnchantmentForTools(Enchantment.fortune, 3)
                .addEnchantmentForWeapons(Enchantment.looting, 3)
                .addEnchantmentForAmmo(Enchantment.looting, 6)
                .addEnchantmentForRanged(Enchantment.infinity, 3)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 3);
            DarkMatter.addEnchantmentForTools(Enchantment.fortune, 3)
                .addEnchantmentForWeapons(Enchantment.looting, 3)
                .addEnchantmentForAmmo(Enchantment.looting, 6)
                .addEnchantmentForRanged(Enchantment.infinity, 3)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 3);
            RedMatter.addEnchantmentForTools(Enchantment.fortune, 3)
                .addEnchantmentForWeapons(Enchantment.looting, 3)
                .addEnchantmentForAmmo(Enchantment.looting, 6)
                .addEnchantmentForRanged(Enchantment.infinity, 3)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 3);
            Chimerite.addEnchantmentForTools(Enchantment.fortune, 3)
                .addEnchantmentForWeapons(Enchantment.looting, 3)
                .addEnchantmentForAmmo(Enchantment.looting, 6)
                .addEnchantmentForRanged(Enchantment.infinity, 3)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 3);
            Jade.addEnchantmentForTools(Enchantment.fortune, 3)
                .addEnchantmentForWeapons(Enchantment.looting, 3)
                .addEnchantmentForAmmo(Enchantment.looting, 6)
                .addEnchantmentForRanged(Enchantment.infinity, 3)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 3);
            Sugilite.addEnchantmentForTools(Enchantment.fortune, 3)
                .addEnchantmentForWeapons(Enchantment.looting, 3)
                .addEnchantmentForAmmo(Enchantment.looting, 6)
                .addEnchantmentForRanged(Enchantment.infinity, 3)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 3);
            EnderAmethyst.addEnchantmentForTools(Enchantment.fortune, 3)
                .addEnchantmentForWeapons(Enchantment.looting, 3)
                .addEnchantmentForAmmo(Enchantment.looting, 6)
                .addEnchantmentForRanged(Enchantment.infinity, 3)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 3);
            Continuum.addEnchantmentForTools(Enchantment.fortune, 3)
                .addEnchantmentForWeapons(Enchantment.looting, 3)
                .addEnchantmentForAmmo(Enchantment.looting, 6)
                .addEnchantmentForRanged(Enchantment.infinity, 3)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 3);
            Basalz.addEnchantmentForTools(Enchantment.fortune, 4)
                .addEnchantmentForWeapons(Enchantment.looting, 4)
                .addEnchantmentForAmmo(Enchantment.looting, 8)
                .addEnchantmentForRanged(Enchantment.infinity, 4)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 4);
            Carminite.addEnchantmentForTools(Enchantment.fortune, 4)
                .addEnchantmentForWeapons(Enchantment.looting, 4)
                .addEnchantmentForAmmo(Enchantment.looting, 8)
                .addEnchantmentForRanged(Enchantment.infinity, 4)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 4);
            Ma.addEnchantmentForTools(Enchantment.fortune, 4)
                .addEnchantmentForWeapons(Enchantment.looting, 4)
                .addEnchantmentForAmmo(Enchantment.looting, 8)
                .addEnchantmentForRanged(Enchantment.infinity, 4)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 4);
            Haderoth.addEnchantmentForTools(Enchantment.fortune, 4)
                .addEnchantmentForWeapons(Enchantment.looting, 4)
                .addEnchantmentForAmmo(Enchantment.looting, 8)
                .addEnchantmentForRanged(Enchantment.infinity, 4)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 4);
            VibraniumSteel.addEnchantmentForTools(Enchantment.fortune, 5)
                .addEnchantmentForWeapons(Enchantment.looting, 5)
                .addEnchantmentForAmmo(Enchantment.looting, 10)
                .addEnchantmentForRanged(Enchantment.infinity, 5)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 5);
            Vibramantium.addEnchantmentForTools(Enchantment.fortune, 5)
                .addEnchantmentForWeapons(Enchantment.looting, 5)
                .addEnchantmentForAmmo(Enchantment.looting, 10)
                .addEnchantmentForRanged(Enchantment.infinity, 5)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 5);
            Vb.addEnchantmentForTools(Enchantment.fortune, 5)
                .addEnchantmentForWeapons(Enchantment.looting, 5)
                .addEnchantmentForAmmo(Enchantment.looting, 10)
                .addEnchantmentForRanged(Enchantment.infinity, 5)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 5);
            Infinity.addEnchantmentForTools(Enchantment.fortune, 10)
                .addEnchantmentForWeapons(Enchantment.looting, 10)
                .addEnchantmentForAmmo(Enchantment.looting, 20)
                .addEnchantmentForRanged(Enchantment.infinity, 10)
                .addEnchantmentForFishing(Enchantment.field_151370_z, 10);

            Ad.addEnchantmentForTools(Enchantment.silkTouch, 1);
            Adamantine.addEnchantmentForTools(Enchantment.silkTouch, 1);
            Force.addEnchantmentForTools(Enchantment.silkTouch, 1);
            Amber.addEnchantmentForTools(Enchantment.silkTouch, 1);
            AmberGolden.addEnchantmentForTools(Enchantment.silkTouch, 1);
            AmberDominican.addEnchantmentForTools(Enchantment.silkTouch, 1);
            Ambrosium.addEnchantmentForTools(Enchantment.silkTouch, 1);
            ManaQuartz.addEnchantmentForTools(Enchantment.silkTouch, 1);
            Blizz.addEnchantmentForTools(Enchantment.silkTouch, 1);
            Frezarite.addEnchantmentForTools(Enchantment.silkTouch, 1);
            Inolashite.addEnchantmentForTools(Enchantment.silkTouch, 1);
            Sanguinite.addEnchantmentForTools(Enchantment.silkTouch, 1);
            NetherStar.addEnchantmentForTools(Enchantment.silkTouch, 1);
            InfusedOrder.addEnchantmentForTools(Enchantment.silkTouch, 1);
            InfusedBalance.addEnchantmentForTools(Enchantment.silkTouch, 1);
            NiflheimPower.addEnchantmentForTools(Enchantment.silkTouch, 1);
            Vibramantium.addEnchantmentForTools(Enchantment.silkTouch, 1);
            Infinity.addEnchantmentForTools(Enchantment.silkTouch, 10);

            EnderPearl.addEnchantmentForTools(Enchantment.silkTouch, 1)
                .addEnchantmentForRanged(Enchantment.infinity, 1);;
            Enderium.addEnchantmentForTools(Enchantment.silkTouch, 1)
                .addEnchantmentForRanged(Enchantment.infinity, 2);;
            Endium.addEnchantmentForTools(Enchantment.silkTouch, 1)
                .addEnchantmentForRanged(Enchantment.infinity, 3);;
            SpectreIron.addEnchantmentForTools(Enchantment.silkTouch, 1)
                .addEnchantmentForRanged(Enchantment.infinity, 3);;

            Flint.addEnchantmentForDamage(Enchantment.fireAspect, 1)
                .addEnchantmentForRanged(Enchantment.flame, 1);
            Netherrack.addEnchantmentForDamage(Enchantment.fireAspect, 1)
                .addEnchantmentForRanged(Enchantment.flame, 1);
            Obsidian.addEnchantmentForDamage(Enchantment.fireAspect, 1)
                .addEnchantmentForRanged(Enchantment.flame, 1);
            STONES.Gneiss.addEnchantmentForDamage(Enchantment.fireAspect, 2)
                .addEnchantmentForRanged(Enchantment.flame, 2);
            NetherBrick.addEnchantmentForDamage(Enchantment.fireAspect, 2)
                .addEnchantmentForRanged(Enchantment.flame, 2);
            PO4.addEnchantmentForDamage(Enchantment.fireAspect, 2)
                .addEnchantmentForRanged(Enchantment.flame, 2);
            Phosphorite.addEnchantmentForDamage(Enchantment.fireAspect, 2)
                .addEnchantmentForRanged(Enchantment.flame, 2);
            Phosphorus.addEnchantmentForDamage(Enchantment.fireAspect, 2)
                .addEnchantmentForRanged(Enchantment.flame, 2);
            PhosphorusBlue.addEnchantmentForDamage(Enchantment.fireAspect, 2)
                .addEnchantmentForRanged(Enchantment.flame, 2);
            PhosphorusRed.addEnchantmentForDamage(Enchantment.fireAspect, 2)
                .addEnchantmentForRanged(Enchantment.flame, 2);
            PhosphorusWhite.addEnchantmentForDamage(Enchantment.fireAspect, 2)
                .addEnchantmentForRanged(Enchantment.flame, 2);
            ObsidianSteel.addEnchantmentForDamage(Enchantment.fireAspect, 2)
                .addEnchantmentForRanged(Enchantment.flame, 2);
            Ignatius.addEnchantmentForDamage(Enchantment.fireAspect, 2)
                .addEnchantmentForRanged(Enchantment.flame, 2);
            Sunstone.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            Prometheum.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            Octine.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            Kreknorite.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            Firestone.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            Fireleaf.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            FierySteel.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            MeteoflameSteel.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            MeteoflameBlackSteel.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            MeteoflameBlueSteel.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            MeteoflameRedSteel.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            FlamascusSteel.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            Pyrotheum.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            Blaze.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            InfusedFire.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            Vulcanite.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            Amordrine.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            MuspelheimPower.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            RedMatter.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            Netherite.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            NetherizedDiamond.addEnchantmentForDamage(Enchantment.fireAspect, 3)
                .addEnchantmentForRanged(Enchantment.flame, 3)
                .addEnchantmentForTools(Enchantment.fireAspect, 3);
            Infinity.addEnchantmentForDamage(Enchantment.fireAspect, 10)
                .addEnchantmentForRanged(Enchantment.flame, 10)
                .addEnchantmentForTools(Enchantment.fireAspect, 10);

            Skyroot.addEnchantmentForDamage(Enchantment.smite, 2);
            Hepatizon.addEnchantmentForDamage(Enchantment.smite, 2);
            BlackBronze.addEnchantmentForDamage(Enchantment.smite, 2);
            RedSteel.addEnchantmentForDamage(Enchantment.smite, 3);
            MeteoricRedSteel.addEnchantmentForDamage(Enchantment.smite, 3);
            MeteoflameRedSteel.addEnchantmentForDamage(Enchantment.smite, 3);
            Au.addEnchantmentForDamage(Enchantment.smite, 3);
            TitaniumGold.addEnchantmentForDamage(Enchantment.smite, 3);
            Electrum.addEnchantmentForDamage(Enchantment.smite, 3);
            GildedIron.addEnchantmentForDamage(Enchantment.smite, 3);
            STONES.Holystone.addEnchantmentForDamage(Enchantment.smite, 3);
            RoseGold.addEnchantmentForDamage(Enchantment.smite, 4);
            EnergeticAlloy.addEnchantmentForDamage(Enchantment.smite, 4);
            SpectreIron.addEnchantmentForDamage(Enchantment.smite, 5);
            VibrantAlloy.addEnchantmentForDamage(Enchantment.smite, 5);
            AmberGolden.addEnchantmentForDamage(Enchantment.smite, 5);
            Zanite.addEnchantmentForDamage(Enchantment.smite, 5);
            Mauftrium.addEnchantmentForDamage(Enchantment.smite, 5);
            Carmot.addEnchantmentForDamage(Enchantment.smite, 5);
            Pt.addEnchantmentForDamage(Enchantment.smite, 5);
            Mithril.addEnchantmentForDamage(Enchantment.smite, 5);
            InfusedVis.addEnchantmentForDamage(Enchantment.smite, 5);
            Infinity.addEnchantmentForDamage(Enchantment.smite, 10);

            Pb.addEnchantmentForDamage(Enchantment.baneOfArthropods, 2);
            Ni.addEnchantmentForDamage(Enchantment.baneOfArthropods, 2);
            Constantan.addEnchantmentForDamage(Enchantment.baneOfArthropods, 2);
            Nichrome.addEnchantmentForDamage(Enchantment.baneOfArthropods, 2);
            Invar.addEnchantmentForDamage(Enchantment.baneOfArthropods, 3);
            Sb.addEnchantmentForDamage(Enchantment.baneOfArthropods, 3);
            Aredrite.addEnchantmentForDamage(Enchantment.baneOfArthropods, 3);
            BatteryAlloy.addEnchantmentForDamage(Enchantment.baneOfArthropods, 4);
            Bi.addEnchantmentForDamage(Enchantment.baneOfArthropods, 4);
            Orichalcum.addEnchantmentForDamage(Enchantment.baneOfArthropods, 4);
            BismuthBronze.addEnchantmentForDamage(Enchantment.baneOfArthropods, 4);
            InfusedEarth.addEnchantmentForDamage(Enchantment.baneOfArthropods, 5);
            Celenegil.addEnchantmentForDamage(Enchantment.baneOfArthropods, 5);
            Infinity.addEnchantmentForDamage(Enchantment.baneOfArthropods, 10);

            Fe.addEnchantmentForDamage(Enchantment.sharpness, 1)
                .addEnchantmentForRanged(Enchantment.power, 1);
            IronMagnetic.addEnchantmentForDamage(Enchantment.sharpness, 1)
                .addEnchantmentForRanged(Enchantment.power, 1);
            IronWood.addEnchantmentForDamage(Enchantment.sharpness, 1)
                .addEnchantmentForRanged(Enchantment.power, 1);
            Ice.addEnchantmentForDamage(Enchantment.sharpness, 1)
                .addEnchantmentForRanged(Enchantment.power, 1);
            Glass.addEnchantmentForDamage(Enchantment.sharpness, 1)
                .addEnchantmentForRanged(Enchantment.power, 1);
            Bronze.addEnchantmentForDamage(Enchantment.sharpness, 1)
                .addEnchantmentForRanged(Enchantment.power, 1);
            ArsenicCopper.addEnchantmentForDamage(Enchantment.sharpness, 1)
                .addEnchantmentForRanged(Enchantment.power, 1);
            ArsenicBronze.addEnchantmentForDamage(Enchantment.sharpness, 1)
                .addEnchantmentForRanged(Enchantment.power, 1);
            GildedIron.addEnchantmentForDamage(Enchantment.sharpness, 1)
                .addEnchantmentForRanged(Enchantment.power, 1);
            PulsatingIron.addEnchantmentForDamage(Enchantment.sharpness, 1)
                .addEnchantmentForRanged(Enchantment.power, 1);
            ConductiveIron.addEnchantmentForDamage(Enchantment.sharpness, 1)
                .addEnchantmentForRanged(Enchantment.power, 1);
            RedstoneAlloy.addEnchantmentForDamage(Enchantment.sharpness, 1)
                .addEnchantmentForRanged(Enchantment.power, 1);
            ElectricalSteel.addEnchantmentForDamage(Enchantment.sharpness, 2)
                .addEnchantmentForRanged(Enchantment.power, 2);
            Brass.addEnchantmentForDamage(Enchantment.sharpness, 2)
                .addEnchantmentForRanged(Enchantment.power, 2);
            CobaltBrass.addEnchantmentForDamage(Enchantment.sharpness, 2)
                .addEnchantmentForRanged(Enchantment.power, 2);
            HSLA.addEnchantmentForDamage(Enchantment.sharpness, 2)
                .addEnchantmentForRanged(Enchantment.power, 2);
            Steel.addEnchantmentForDamage(Enchantment.sharpness, 2)
                .addEnchantmentForRanged(Enchantment.power, 2);
            SteelMagnetic.addEnchantmentForDamage(Enchantment.sharpness, 2)
                .addEnchantmentForRanged(Enchantment.power, 2);
            SteelGalvanized.addEnchantmentForDamage(Enchantment.sharpness, 2)
                .addEnchantmentForRanged(Enchantment.power, 2);
            Syrmorite.addEnchantmentForDamage(Enchantment.sharpness, 2)
                .addEnchantmentForRanged(Enchantment.power, 2);
            WroughtIron.addEnchantmentForDamage(Enchantment.sharpness, 2)
                .addEnchantmentForRanged(Enchantment.power, 2);
            PigIron.addEnchantmentForDamage(Enchantment.sharpness, 2)
                .addEnchantmentForRanged(Enchantment.power, 2);
            Meteorite.addEnchantmentForDamage(Enchantment.sharpness, 2)
                .addEnchantmentForRanged(Enchantment.power, 2);
            FierySteel.addEnchantmentForDamage(Enchantment.sharpness, 2)
                .addEnchantmentForRanged(Enchantment.power, 2);
            FrozenIron.addEnchantmentForDamage(Enchantment.sharpness, 2)
                .addEnchantmentForRanged(Enchantment.power, 2);
            MeteoricIron.addEnchantmentForDamage(Enchantment.sharpness, 2)
                .addEnchantmentForRanged(Enchantment.power, 2);
            MeteoricSteel.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            MeteoflameSteel.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            Steeleaf.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            Fireleaf.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            VanadiumSteel.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            StainlessSteel.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            Knightmetal.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            DeepIron.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            ShadowIron.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            BlackSteel.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            MeteoricBlackSteel.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            MeteoflameBlackSteel.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            RedSteel.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            MeteoricRedSteel.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            MeteoflameRedSteel.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            BlueSteel.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            MeteoricBlueSteel.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            MeteoflameBlueSteel.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            Ti.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            TitaniumGold.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            TungstenAlloy.addEnchantmentForDamage(Enchantment.sharpness, 3)
                .addEnchantmentForRanged(Enchantment.power, 3);
            TungstenSteel.addEnchantmentForDamage(Enchantment.sharpness, 4)
                .addEnchantmentForRanged(Enchantment.power, 4);
            NetherizedDiamond.addEnchantmentForDamage(Enchantment.sharpness, 4)
                .addEnchantmentForRanged(Enchantment.power, 4);
            HSSG.addEnchantmentForDamage(Enchantment.sharpness, 4)
                .addEnchantmentForRanged(Enchantment.power, 4);
            HSSE.addEnchantmentForDamage(Enchantment.sharpness, 4)
                .addEnchantmentForRanged(Enchantment.power, 4);
            HSSS.addEnchantmentForDamage(Enchantment.sharpness, 4)
                .addEnchantmentForRanged(Enchantment.power, 4);
            ShadowSteel.addEnchantmentForDamage(Enchantment.sharpness, 4)
                .addEnchantmentForRanged(Enchantment.power, 4);
            Zanite.addEnchantmentForDamage(Enchantment.sharpness, 4)
                .addEnchantmentForRanged(Enchantment.power, 4);
            DamascusSteel.addEnchantmentForDamage(Enchantment.sharpness, 5)
                .addEnchantmentForRanged(Enchantment.power, 5);
            FlamascusSteel.addEnchantmentForDamage(Enchantment.sharpness, 5)
                .addEnchantmentForRanged(Enchantment.power, 5);
            Elvorium.addEnchantmentForDamage(Enchantment.sharpness, 5)
                .addEnchantmentForRanged(Enchantment.power, 5);
            InfusedEntropy.addEnchantmentForDamage(Enchantment.sharpness, 5)
                .addEnchantmentForRanged(Enchantment.power, 5);
            Ke.addEnchantmentForDamage(Enchantment.sharpness, 6)
                .addEnchantmentForRanged(Enchantment.power, 6);
            Ad.addEnchantmentForDamage(Enchantment.sharpness, 7)
                .addEnchantmentForRanged(Enchantment.power, 7);
            Trinitanium.addEnchantmentForDamage(Enchantment.sharpness, 7)
                .addEnchantmentForRanged(Enchantment.power, 7);
            Trinaquadalloy.addEnchantmentForDamage(Enchantment.sharpness, 8)
                .addEnchantmentForRanged(Enchantment.power, 8);
            Infinity.addEnchantmentForDamage(Enchantment.sharpness, 10)
                .addEnchantmentForRanged(Enchantment.power, 10);

            Oureclase.addEnchantmentForArmors(Enchantment.respiration, 3);
            InfusedAir.addEnchantmentForArmors(Enchantment.respiration, 3);
            Infinity.addEnchantmentForArmors(Enchantment.respiration, 10);

            Atl.addEnchantmentForArmors(Enchantment.featherFalling, 4);
            InfusedFire.addEnchantmentForArmors(Enchantment.featherFalling, 4);
            Infinity.addEnchantmentForArmors(Enchantment.featherFalling, 10);

            Steeleaf.addEnchantmentForArmors(Enchantment.protection, 2);
            Fireleaf.addEnchantmentForArmors(Enchantment.protection, 2);
            Knightmetal.addEnchantmentForArmors(Enchantment.protection, 1);
            Celenegil.addEnchantmentForArmors(Enchantment.protection, 4);
            InfusedEarth.addEnchantmentForArmors(Enchantment.protection, 4);
            InfusedVis.addEnchantmentForArmors(Enchantment.protection, 4);
            InfusedBalance.addEnchantmentForArmors(Enchantment.protection, 4);
            Tartarite.addEnchantmentForArmors(Enchantment.protection, 5);
            Adamantine.addEnchantmentForArmors(Enchantment.protection, 5);
            DarkMatter.addEnchantmentForArmors(Enchantment.protection, 5);
            VibraniumSilver.addEnchantmentForArmors(Enchantment.protection, 6);
            VibraniumSteel.addEnchantmentForArmors(Enchantment.protection, 8);
            Vibramantium.addEnchantmentForArmors(Enchantment.protection, 10);
            Vb.addEnchantmentForArmors(Enchantment.protection, 10);
            Ad.addEnchantmentForArmors(Enchantment.protection, 10);
            Infinity.addEnchantmentForArmors(Enchantment.protection, 10);

            Aredrite.addEnchantmentForArmors(Enchantment.fireProtection, 3);
            Efrine.addEnchantmentForArmors(Enchantment.fireProtection, 3);
            Netherite.addEnchantmentForArmors(Enchantment.fireProtection, 3);
            NetherizedDiamond.addEnchantmentForArmors(Enchantment.fireProtection, 5);

            Vyroxeres.addEnchantmentForArmors(Enchantment.thorns, 3);
            InfusedEntropy.addEnchantmentForArmors(Enchantment.thorns, 3);
            Infinity.addEnchantmentForArmors(Enchantment.thorns, 10);

            InfusedWater.addEnchantmentForArmors(Enchantment.aquaAffinity, 1);
            IronWood.addEnchantmentForArmors(Enchantment.aquaAffinity, 1);
            Ceruclase.addEnchantmentForArmors(Enchantment.aquaAffinity, 1);
            Inolashite.addEnchantmentForArmors(Enchantment.aquaAffinity, 1);
            Infinity.addEnchantmentForArmors(Enchantment.aquaAffinity, 10);

            InfusedOrder.addEnchantmentForArmors(Enchantment.projectileProtection, 4);
            Infinity.addEnchantmentForArmors(Enchantment.projectileProtection, 10);

            Obsidian.addEnchantmentForArmors(Enchantment.blastProtection, 3);
            InfusedDull.addEnchantmentForArmors(Enchantment.blastProtection, 4);
            Amordrine.addEnchantmentForArmors(Enchantment.blastProtection, 5);
            RedMatter.addEnchantmentForArmors(Enchantment.blastProtection, 5);
            Infinity.addEnchantmentForArmors(Enchantment.blastProtection, 10);

            NaNO3.addSourceOf(Niter, KNO3, K);
            KNO3.addSourceOf(Niter, NaNO3, Na);
            Niter.addSourceOf(KNO3, NaNO3, K, Na);

            OREMATS.Pitchblende.ores(Pb, Ra, RareEarth, Th);
            OREMATS.Uraninite.ores(Pb, Ra, RareEarth, Th);
            Yellorite.ores(Pb, Ra, RareEarth, Th);

            Th.ores(Pb, Ra, RareEarth);
            Cyanite.ores(Pb, Ra, RareEarth);
            U_238.ores(Pb, Ra, RareEarth);
            Yellorium.ores(Pb, Ra, RareEarth);
            Pu.ores(Pb, Ra, RareEarth);
            Blutonium.ores(Pb, Ra, RareEarth);
            Am.ores(Pb, Ra, RareEarth);
            Ludicrite.ores(Pb, Ra, RareEarth);

            for (OreDictMaterial tMat : ANY.CaF2.mToThis) tMat.ores(OREMATS.Huebnerite, Y, Ce, Fe2O3, Na, Ba);

            CaF2.ores(FluoriteGreen, FluoriteOrange);
            FluoriteRed.ores(FluoritePink, FluoriteMagenta);
            FluoritePink.ores(FluoriteWhite, FluoriteRed);
            FluoriteBlue.ores(FluoriteMagenta, FluoriteBlack);
            FluoriteGreen.ores(FluoriteYellow, FluoriteBlue);
            FluoriteBlack.ores(FluoriteWhite, CaF2);
            FluoriteWhite.ores(FluoriteBlack, CaF2);
            FluoriteYellow.ores(FluoriteGreen, FluoriteOrange);
            FluoriteOrange.ores(FluoriteYellow, FluoriteRed);
            FluoriteMagenta.ores(FluoritePink, FluoriteBlue);

            S.ores(
                Pyrite,
                OREMATS.Sphalerite,
                OREMATS.Cinnabar,
                OREMATS.Chalcopyrite,
                OREMATS.Arsenopyrite,
                OREMATS.Galena,
                OREMATS.Stibnite,
                Gypsum);
            Se.ores(Pyrite, OREMATS.Galena, OREMATS.Sphalerite, In, Ga, Cd);
            OREMATS.Chalcopyrite.ores(Pyrite, OREMATS.Cobaltite, Cd, Au, OREMATS.Sperrylite, OREMATS.Stannite, In);
            OREMATS.Sperrylite.ores(Sb, Cu, Fe2O3, Rh, OREMATS.Cooperite);
            OREMATS.Pentlandite.ores(Fe2O3, S, OREMATS.Cobaltite, OREMATS.Sperrylite, Gypsum);
            OREMATS.Sphalerite.ores(Cd, Ga, Zn, OREMATS.Kesterite, Se, In);
            OREMATS.Tetrahedrite.ores(Cu, Sb, Zn, OREMATS.Kesterite, As);
            Pyrite.ores(S, Phosphorus, Fe2O3, OREMATS.Stannite, Se);
            Sn.ores(
                OREMATS.Molybdenite,
                OREMATS.Wolframite,
                FluoriteBlack,
                OREMATS.Arsenopyrite,
                OREMATS.Stannite,
                OREMATS.Sperrylite,
                OREMATS.Huebnerite,
                Apatite); // Tourmaline
            OREMATS.Cassiterite.ores(
                OREMATS.Molybdenite,
                OREMATS.Wolframite,
                FluoriteWhite,
                OREMATS.Arsenopyrite,
                OREMATS.Stannite,
                OREMATS.Sperrylite,
                OREMATS.Huebnerite,
                Apatite); // Tourmaline
            Sb.ores(
                Zn,
                OREMATS.Realgar,
                OREMATS.Cinnabar,
                OREMATS.Galena,
                OREMATS.Arsenopyrite,
                Pyrite,
                OREMATS.Barite,
                CaCO3);
            OREMATS.Stibnite.ores(
                Sb,
                OREMATS.Realgar,
                OREMATS.Cinnabar,
                OREMATS.Galena,
                OREMATS.Arsenopyrite,
                Pyrite,
                OREMATS.Barite,
                CaCO3);
            OREMATS.Bauxite.ores(Kaolinite, OREMATS.Ilmenite, Fe2O3, Al2O3, AlO3H3);
            AlO3H3.ores(OREMATS.Bauxite, OREMATS.Ilmenite, Fe2O3, Al2O3);
            OREMATS.Ilmenite.ores(TiO2, Fe2O3, MgCO3, MnO2);
            TiO2.ores(Fe2O3, Zircon);
            Fe2O3.ores(OREMATS.Ilmenite, OREMATS.GraniticMineralSand, MnO2, ClayRed);
            OREMATS.Galena.ores(OREMATS.Sphalerite, Ag, Pb, Se, FluoriteRed, CaCO3);
            OREMATS.Arsenopyrite.ores(Au, OREMATS.Realgar, FluoriteOrange, OREMATS.Cassiterite, OREMATS.Huebnerite);
            OREMATS.Cobaltite.ores(Co, OREMATS.Realgar, FluoriteOrange, OREMATS.Pentlandite, OREMATS.YellowLimonite);
            Co_60.ores(OREMATS.Cobaltite, OREMATS.Realgar, FluoriteOrange, OREMATS.Pentlandite, OREMATS.YellowLimonite);
            Co.ores(OREMATS.Cobaltite, OREMATS.Realgar, FluoriteOrange, OREMATS.Pentlandite, OREMATS.YellowLimonite);
            OREMATS.Realgar.ores(OREMATS.Cobaltite, OREMATS.Arsenopyrite);
            Cu.ores(OREMATS.Cobaltite, Au, Ni, OREMATS.Malachite, As);
            Ni.ores(OREMATS.Cobaltite, OREMATS.Cooperite, Fe2O3, OREMATS.Pentlandite);
            OREMATS.Stannite.ores(Ge, Pyrite, OREMATS.Kesterite);
            OREMATS.Kesterite.ores(Ge, Pyrite, OREMATS.Stannite);

            OREMATS.Glauconite.ores(Na, Al2O3, Fe2O3);
            OREMATS.Diatomite.ores(OREMATS.Mica, Opal, Biotite, OREMATS.Perlite, Sapphire);
            OREMATS.Mica.ores(OREMATS.Vermiculite, Asbestos, Biotite, OREMATS.Perlite);
            OREMATS.Vermiculite.ores(OREMATS.Mica, Asbestos, Biotite, OREMATS.Diatomite);
            Biotite.ores(OREMATS.Mica, OREMATS.Vermiculite, Asbestos, OREMATS.Perlite);
            Asbestos.ores(OREMATS.Mica, Biotite, Talc, Jade);
            Jade.ores(OREMATS.Mica, Biotite, Talc, Asbestos);
            Gypsum.ores(OREMATS.Trona, OREMATS.Mirabilite, Asbestos, Talc, S);
            OREMATS.Mirabilite.ores(OREMATS.Trona, Gypsum);
            OREMATS.Trona.ores(OREMATS.Mirabilite, Gypsum, NaHCO3);
            NaHCO3.ores(OREMATS.Mirabilite, Gypsum, OREMATS.Trona);

            Lapis.ores(Lazurite, Sodalite, Pyrite);
            OREMATS.Cooperite.ores(Pd, Ni, Ir);
            OREMATS.Cinnabar.ores(Redstone, S, Glowstone, Se);
            OREMATS.Chromite.ores(MnO2, Fe2O3, MgCO3, OREMATS.Bromargyrite);
            OREMATS.Bromargyrite.ores(MnO2, Ag, OREMATS.Chromite, OREMATS.Smithsonite);
            Mn.ores(MnO2, Fe2O3, OREMATS.Chromite);
            MnO2.ores(OREMATS.Bromargyrite, Fe2O3, OREMATS.Chromite);
            OREMATS.Columbite.ores(OREMATS.Tantalite, OREMATS.Coltan, MnO2, OREMATS.Ilmenite);
            OREMATS.Tantalite.ores(OREMATS.Columbite, OREMATS.Coltan, MnO2, OREMATS.Ilmenite);
            OREMATS.Coltan.ores(OREMATS.Columbite, OREMATS.Tantalite, MnO2, OREMATS.Ilmenite);

            Apatite.ores(Phosphorite, PhosphorusBlue, FluoriteBlue, PO4);
            Phosphorus.ores(Phosphorite, Apatite, FluoriteYellow, PO4, PhosphorusRed, PhosphorusWhite);
            PhosphorusBlue.ores(Phosphorite, Apatite, FluoriteBlue, PO4, PhosphorusRed, PhosphorusWhite);
            PhosphorusRed.ores(Phosphorite, Apatite, FluoriteRed, PO4, PhosphorusBlue, PhosphorusWhite);
            PhosphorusWhite.ores(Phosphorite, Apatite, FluoriteWhite, PO4, PhosphorusRed, PhosphorusBlue);
            Phosphorite.ores(Phosphorus, Apatite, FluoriteYellow, PO4, PhosphorusRed, PhosphorusWhite);
            P.ores(Phosphorus, Apatite, FluoriteYellow, PO4, PhosphorusRed, PhosphorusWhite);
            PO4.ores(Phosphorus, Apatite, FluoriteYellow, Phosphorite, PhosphorusRed, PhosphorusWhite);

            OREMATS.Zeolite.ores(OREMATS.Pollucite, NaCl);
            OREMATS.Pollucite.ores(OREMATS.Zeolite, Cs, Rb);

            Diamond.ores(Graphite, DiamondPink)
                .addSourceOf(Diamond, Graphite);
            DiamondBlue.ores(Graphite, Diamond)
                .addSourceOf(Diamond, Graphite);
            DiamondGreen.ores(Graphite, Diamond)
                .addSourceOf(Diamond, Graphite);
            DiamondPurple.ores(Graphite, Diamond)
                .addSourceOf(Diamond, Graphite);
            DiamondRed.ores(Graphite, Diamond)
                .addSourceOf(Diamond, Graphite);
            DiamondYellow.ores(Graphite, Diamond)
                .addSourceOf(Diamond, Graphite);
            DiamondPink.ores(Graphite, Diamond)
                .addSourceOf(Diamond, Graphite);
            ManaDiamond.ores(Graphite, Diamond)
                .addSourceOf(Diamond, Graphite);
            ElvenDragonstone.ores(Graphite);

            Be.ores(Al2O3, Emerald, Aquamarine, Morganite, Goshenite, Bixbite, Heliodor, Maxixe)
                .addSourceOf(Emerald, Be, Al);
            Emerald.ores(Al2O3, Be, Aquamarine, Morganite, Goshenite, Bixbite, Heliodor, Maxixe)
                .addSourceOf(Emerald, Be, Al);
            Aquamarine.ores(Al2O3, Be, Emerald, Morganite, Goshenite, Bixbite, Heliodor, Maxixe)
                .addSourceOf(Emerald, Be, Al);
            Morganite.ores(Al2O3, Be, Emerald, Aquamarine, Goshenite, Bixbite, Heliodor, Maxixe)
                .addSourceOf(Emerald, Be, Al);
            Goshenite.ores(Al2O3, Be, Emerald, Aquamarine, Morganite, Bixbite, Heliodor, Maxixe)
                .addSourceOf(Emerald, Be, Al);
            Bixbite.ores(Al2O3, Be, Emerald, Aquamarine, Morganite, Goshenite, Heliodor, Maxixe)
                .addSourceOf(Emerald, Be, Al);
            Heliodor.ores(Al2O3, Be, Emerald, Aquamarine, Morganite, Goshenite, Bixbite, Maxixe)
                .addSourceOf(Emerald, Be, Al);
            Maxixe.ores(Al2O3, Be, Emerald, Aquamarine, Morganite, Goshenite, Bixbite, Heliodor)
                .addSourceOf(Emerald, Be, Al);

            Sapphire.ores(Al2O3, Ruby, GreenSapphire, BlueSapphire)
                .addSourceOf(Sapphire, Al);
            Ruby.ores(Al2O3, OrangeSapphire, GreenSapphire, BlueSapphire)
                .addSourceOf(Sapphire, Al);
            GreenSapphire.ores(Al2O3, Ruby, YellowSapphire, BlueSapphire)
                .addSourceOf(Sapphire, Al);
            BlueSapphire.ores(Al2O3, Ruby, GreenSapphire, PurpleSapphire)
                .addSourceOf(Sapphire, Al);
            YellowSapphire.ores(Al2O3, Ruby, GreenSapphire, BlueSapphire)
                .addSourceOf(Sapphire, Al);
            OrangeSapphire.ores(Al2O3, Ruby, GreenSapphire, BlueSapphire)
                .addSourceOf(Sapphire, Al);
            PurpleSapphire.ores(Al2O3, Ruby, GreenSapphire, BlueSapphire)
                .addSourceOf(Sapphire, Al);

            Almandine.ores(Grossular, Pyrope, Spessartine, Andradite, Uvarovite);
            Grossular.ores(Almandine, Pyrope, Spessartine, Andradite, Uvarovite);
            Pyrope.ores(Almandine, Grossular, Spessartine, Andradite, Uvarovite);
            Spessartine.ores(Almandine, Grossular, Pyrope, Andradite, Uvarovite);
            Andradite.ores(Almandine, Grossular, Pyrope, Spessartine, Uvarovite);
            Uvarovite.ores(Almandine, Grossular, Pyrope, Spessartine, Andradite);

            Jasper.ores(JasperOcean, JasperRainforest, JasperBlue, JasperGreen, JasperYellow);
            JasperOcean.ores(Jasper, JasperRainforest, JasperBlue, JasperGreen, JasperYellow);
            JasperRainforest.ores(Jasper, JasperOcean, JasperBlue, JasperGreen, JasperYellow);
            JasperBlue.ores(Jasper, JasperOcean, JasperRainforest, JasperGreen, JasperYellow);
            JasperGreen.ores(Jasper, JasperOcean, JasperRainforest, JasperBlue, JasperYellow);
            JasperYellow.ores(Jasper, JasperOcean, JasperRainforest, JasperBlue, JasperGreen);

            TigerEyeYellow.ores(Fe2O3, TigerEyeGreen, TigerEyeRed, TigerEyeBlue, TigerEyeBlack, TigerIron);
            TigerEyeGreen.ores(Fe2O3, TigerEyeYellow, TigerEyeRed, TigerEyeBlue, TigerEyeBlack, TigerIron);
            TigerEyeRed.ores(Fe2O3, TigerEyeYellow, TigerEyeGreen, TigerEyeBlue, TigerEyeBlack, TigerIron);
            TigerEyeBlue.ores(Fe2O3, TigerEyeYellow, TigerEyeGreen, TigerEyeRed, TigerEyeBlack, TigerIron);
            TigerEyeBlack.ores(Fe2O3, TigerEyeYellow, TigerEyeGreen, TigerEyeRed, TigerEyeBlue, TigerIron);
            TigerIron.ores(Fe2O3, TigerEyeYellow, TigerEyeGreen, TigerEyeRed, TigerEyeBlue, TigerEyeBlack);

            AventurineGreen.ores(AventurineBrown, AventurineYellow, AventurineBlack, AventurineBlue, AventurineRed);
            AventurineBrown.ores(AventurineGreen, AventurineYellow, AventurineBlack, AventurineBlue, AventurineRed);
            AventurineYellow.ores(AventurineGreen, AventurineBrown, AventurineBlack, AventurineBlue, AventurineRed);
            AventurineBlack.ores(AventurineGreen, AventurineBrown, AventurineYellow, AventurineBlue, AventurineRed);
            AventurineBlue.ores(AventurineGreen, AventurineBrown, AventurineYellow, AventurineBlack, AventurineRed);
            AventurineRed.ores(AventurineGreen, AventurineBrown, AventurineYellow, AventurineBlack, AventurineBlue);

            Spinel.ores(Al2O3, BalasRuby);
            BalasRuby.ores(OREMATS.Chromite, Spinel);

            HexoriumRed.ores(HexoriumWhite, HexoriumBlack);
            HexoriumGreen.ores(HexoriumWhite, HexoriumBlack);
            HexoriumBlue.ores(HexoriumWhite, HexoriumBlack);
            HexoriumBlack.ores(HexoriumRed, HexoriumGreen, HexoriumBlue);
            HexoriumWhite.ores(HexoriumRed, HexoriumGreen, HexoriumBlue);

            Clay.ores(Kaolinite, Palygorskite);
            ClayBrown.ores(Clay, ClayRed);
            ClayRed.ores(Bentonite, ClayBrown);
            Bentonite.ores(ClayRed, Palygorskite);
            Palygorskite.ores(Kaolinite, Bentonite);
            Kaolinite.ores(ClayBrown, Clay);

            OREMATS.Barite.ores(CertusQuartz, STONES.Quartzite);
            OREMATS.QuartzSand.ores(CertusQuartz, STONES.Quartzite, OREMATS.Barite);
            OREMATS.Wollastonite.ores(Fe2O3, MgCO3, MnO2);

            Redstone.ores(OREMATS.Cinnabar, RareEarth, Glowstone);
            Nikolite.ores(Cu, RareEarth, Azurite, As);

            Re.ores(OREMATS.Chalcopyrite, OREMATS.Molybdenite);
            Os.ores(Ir, Pt, Ru);
            Ir.ores(Pt, Os, Rh);
            Pt.ores(Ni, Ir, Pd);
            MeteoricIron.ores(Ni, Ir, Pt);
            Au.ores(Cu, Ni, OREMATS.Cinnabar);
            Ag.ores(Pb, S, OREMATS.Bromargyrite);
            Nd.ores(Monazite, RareEarth);
            OREMATS.Bastnasite.ores(Monazite, RareEarth, Nd);
            Monazite.ores(Th, Nd, RareEarth);
            Forcicium.ores(Th, Nd, RareEarth);
            Forcillium.ores(Th, Nd, RareEarth);
            Ge.ores(Fe2O3, Sn, OREMATS.Chromite);
            Cd.ores(OREMATS.Chalcopyrite, OREMATS.Sphalerite, Se);
            OREMATS.Powellite.ores(OREMATS.Molybdenite, OREMATS.Scheelite);
            OREMATS.Wulfenite.ores(OREMATS.Powellite, OREMATS.Scheelite, OREMATS.Molybdenite, OREMATS.Galena);
            Mo.ores(OREMATS.Powellite, OREMATS.Scheelite, Re, OREMATS.Wulfenite, Os);
            OREMATS.Molybdenite.ores(OREMATS.Powellite, OREMATS.Scheelite, Re, OREMATS.Wulfenite, Os);
            OREMATS.Malachite.ores(Cu, OREMATS.BrownLimonite, CaCO3, Azurite, As);
            OREMATS.BrownLimonite.ores(OREMATS.Malachite, OREMATS.YellowLimonite);
            OREMATS.YellowLimonite.ores(Ni, OREMATS.BrownLimonite, OREMATS.Cobaltite);
            OREMATS.Garnierite.ores(Ni, OREMATS.Sperrylite);
            OREMATS.Tungstate.ores(MnO2, Ag, LiCl);
            OREMATS.Scheelite.ores(MnO2, OREMATS.Molybdenite, CaCO3);
            OREMATS.Huebnerite.ores(
                OREMATS.Wolframite,
                OREMATS.Molybdenite,
                FluoriteGreen,
                OREMATS.Arsenopyrite,
                OREMATS.Cassiterite,
                Topaz); // Tourmaline, Rhodochrosite
            OREMATS.Wolframite.ores(OREMATS.Tungstate, Fe2O3, OREMATS.Stannite, MgCO3);
            OREMATS.Ferberite.ores(OREMATS.Tungstate, Fe2O3);
            OREMATS.Russellite.ores(OREMATS.Tungstate, Bi);
            OREMATS.Stolzite.ores(OREMATS.Tungstate, Pb);
            OREMATS.Pinalite.ores(OREMATS.Tungstate, Pb);
            NaCl.ores(KCl, KIO3, OREMATS.Borax);
            KCl.ores(KIO3, NaCl);
            KIO3.ores(NaCl, KCl);
            Endstone.ores(He_3, Be);
            Endium.ores(OREMATS.Wolframite, OREMATS.Sperrylite, OREMATS.Coltan, Ke);

            Glowstone.ores(Redstone, Au, Gloomstone, FluoriteYellow);
            GlowstoneCeres.ores(Redstone, Au, Glowstone);
            GlowstoneIo.ores(Redstone, Au, Glowstone);
            GlowstoneEnceladus.ores(Redstone, Au, Glowstone);
            GlowstoneProteus.ores(Redstone, Au, Glowstone);
            GlowstonePluto.ores(Redstone, Au, Glowstone);
            Gloomstone.ores(Redstone, Au, Glowstone, FluoriteBlue);
            Efrine.ores(SoulSand, Be, OREMATS.Pentlandite, Zircon, FluoriteGreen);
            AncientDebris.ores(SoulSand, Efrine, OREMATS.Huebnerite, Firestone);
            Firestone.ores(NetherQuartz, VoidQuartz, PhosphorusRed, FluoriteRed);
            SoulSand.ores(Coal, NetherQuartz, Niter, Gloomstone);
            NetherQuartz.ores(OREMATS.Barite, Efrine, VoidQuartz, FluoriteWhite);
            VoidQuartz.ores(OREMATS.Barite, Efrine, NetherQuartz, FluoriteMagenta);
            STONES.Quartzite.ores(CertusQuartz, OREMATS.Barite, Fe2O3);
            MilkyQuartz.ores(CertusQuartz, OREMATS.Barite);
            CertusQuartz.ores(MilkyQuartz, OREMATS.Barite);
            ChargedCertusQuartz.ores(MilkyQuartz, OREMATS.Barite);
            BlackQuartz.ores(MilkyQuartz, OREMATS.Barite);

            Syrmorite.ores(OREMATS.Stannite, OREMATS.Tetrahedrite, Be);
            Octine.ores(OREMATS.Pentlandite, OREMATS.Huebnerite, Zircon);

            Ga.ores(Zn, Se);
            Zn.ores(Sn, Ga);
            OREMATS.Lepidolite.ores(LiCl, Cs, Rb);
            OREMATS.Spodumene.ores(Al2O3, LiCl);
            OREMATS.Kyanite.ores(STONES.Quartzite, OREMATS.Lepidolite, OREMATS.Spodumene);
            OREMATS.Alunite.ores(STONES.Quartzite);
            OREMATS.Smithsonite.ores(Zn, OREMATS.Bromargyrite);
            Pb.ores(Ag, S);
            Electrum.ores(Au, Ag);
            Bronze.ores(Cu, Sn, As);
            Brass.ores(Cu, Zn, As);
            Coal.ores(Lignite, S);
            Lignite.ores(Coal, S, Ge);

            Al2O3.ores(OREMATS.Bauxite, Al2O3, AlO3H3);
            Bi.ores(OREMATS.Russellite, OREMATS.Galena, OREMATS.Kesterite);
            Cr.ores(OREMATS.Chromite, Fe2O3, MgCO3);
            OREMATS.Ferrovanadium.ores(OREMATS.Magnetite, VanadiumPentoxide);
            OREMATS.Magnetite.ores(Fe2O3, Au, Stone);
            OREMATS.GraniticMineralSand.ores(Fe2O3, Au, STONES.GraniteBlack);
            OREMATS.BasalticMineralSand.ores(Fe2O3, Au, STONES.Basalt);
            OREMATS.Celestine.ores(Sr, S);
            Lazurite.ores(Sodalite, Lapis);
            Sodalite.ores(Lazurite, Lapis);
            Zr.ores(TiO2, Hf);
            Zircon.ores(TiO2, Hf, OREMATS.Uraninite);
            Eudialyte.ores(Zircon, RareEarth, Hf, Pb);
            Azurite.ores(Zircon, OREMATS.Malachite, Hf); // Niccolite byproduct?
            Adamantine.ores(OREMATS.GraniticMineralSand);
            Peridot.ores(Obsidian, MgCO3);
            PigIron.ores(Fe2O3);
            DarkIron.ores(Fe2O3);
            Steel.ores(Fe2O3);
            MeteoricSteel.ores(Fe2O3);
            Graphite.ores(C);
            MgCO3.ores(OREMATS.Cobaltite, MnO2);
            CaCO3.ores(OREMATS.Malachite);
            OREMATS.Borax.ores(B, NaCl);
            Netherrack.ores(S);
            Flint.ores(Obsidian);
            NaNO3.ores(KNO3, Niter);
            KNO3.ores(NaNO3, Niter);
            Niter.ores(KNO3, NaNO3);
            Hf.ores(Zircon);
            Mg.ores(Peridot, MgCO3);
            Obsidian.ores(Peridot, MgCO3);
            OREMATS.Perlite.ores(Peridot, MgCO3);
            STONES.Redrock.ores(ClayRed);
            STONES.Limestone.ores(CaCO3);
            STONES.Marble.ores(CaCO3);
            STONES.Eclogite.ores(TiO2);
            STONES.Limestone.ores(Phosphorite);
            STONES.Holystone.ores(Ambrosium);
            Ambrosium.ores(STONES.Holystone);
            Zanite.ores(Opal, Ambrosium);
            Tanzanite.ores(Opal);
            Opal.ores(Tanzanite);
            Topaz.ores(BlueTopaz);
            BlueTopaz.ores(Topaz);
            In.ores(Se);
            Li.ores(LiCl);
            LiCl.ores(Li);

            Nq_528.ores(Nq, OREMATS.DuraniumHexafluoride);
            Nq_522.ores(Nq, OREMATS.TritaniumHexafluoride);
            Nq.ores(OREMATS.DuraniumHexachloride, OREMATS.TritaniumHexafluoride);
            Ke.ores(Sn, TiO2, Fe2O3, OREMATS.DuraniumHexaiodide);
            Dn.ores(OREMATS.TritaniumDioxide, Ke);
            DuraniumAlloy.ores(OREMATS.TritaniumDioxide, Ke);
            OREMATS.DiduraniumTrioxide.ores(OREMATS.TritaniumDioxide, Ke);
            Tn.ores(OREMATS.DiduraniumTrioxide, Ke);
            TritaniumAlloy.ores(OREMATS.DiduraniumTrioxide, Ke);
            OREMATS.TritaniumDioxide.ores(OREMATS.DiduraniumTrioxide, Ke);
            Dolamide
                .ores(Dilithium, OREMATS.DiduraniumTrioxide, OREMATS.DuraniumHexafluoride, OREMATS.DuraniumHexabromide);
            Desh.ores(
                Dolamide,
                OREMATS.DuraniumHexaiodide,
                OREMATS.DuraniumHexachloride,
                OREMATS.DuraniumHexaastatide,
                OREMATS.Columbite,
                OREMATS.Cobaltite,
                Monazite,
                LiCl);
            OREMATS.DuraniumHexafluoride.ores(OREMATS.DiduraniumTrioxide, FluoritePink);
            OREMATS.DuraniumHexachloride.ores(OREMATS.DiduraniumTrioxide, NaCl, KCl);
            OREMATS.DuraniumHexabromide.ores(OREMATS.DiduraniumTrioxide, OREMATS.Bromargyrite);
            OREMATS.DuraniumHexaiodide.ores(OREMATS.DiduraniumTrioxide, KIO3);
            OREMATS.DuraniumHexaastatide.ores(OREMATS.DiduraniumTrioxide, At);
            OREMATS.TritaniumHexafluoride.ores(OREMATS.TritaniumDioxide, FluoriteMagenta);
            OREMATS.TritaniumHexachloride.ores(OREMATS.TritaniumDioxide, NaCl, KCl);
            OREMATS.TritaniumHexabromide.ores(OREMATS.TritaniumDioxide, OREMATS.Bromargyrite);
            OREMATS.TritaniumHexaiodide.ores(OREMATS.TritaniumDioxide, KIO3);
            OREMATS.TritaniumHexaastatide.ores(OREMATS.TritaniumDioxide, At);

            Ardite.ores(OREMATS.Galena, OREMATS.Stibnite);
            Aredrite.ores(OREMATS.Galena, OREMATS.Stibnite);
            Orichalcum.ores(OREMATS.Tetrahedrite, OREMATS.Kesterite);
            Alduorite.ores(Cd);
            Infuscolium.ores(OREMATS.Malachite);
            Rubracium.ores(OREMATS.Chromite);
            Meutoite.ores(VanadiumPentoxide);
            Lemurite.ores(MgCO3);
            Ceruclase.ores(OREMATS.Cobaltite);
            Atl.ores(TiO2);
            Oureclase.ores(OREMATS.Pentlandite);
            Kalendrite.ores(Os);
            Carmot.ores(Zn);
            Sanguinite.ores(Hg);
            Vyroxeres.ores(Ir);
            Eximite.ores(Pd);
            Prometheum.ores(OREMATS.Cobaltite);
            Ignatius.ores(Se, In);
            Vulcanite.ores(OREMATS.Wolframite);
            DeepIron.ores(Fe2O3);
            ShadowIron.ores(Fe2O3);
            AstralSilver.ores(Ag);
            Midasium.ores(Au);
            Mithril.ores(Pt);

            // Fe .addAlloyingRecipe(new OreDictConfigurationComponent( 2, OM.stack(OREMATS.Chalcopyrite , 8*U),
            // OM.stack(C , 1*U)));
            Fe.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    2,
                    OM.stack(Fe2O3, 5 * U),
                    OM.stack(C, 1 * U),
                    OM.stack(CaCO3, 1 * U)));
            Fe.addAlloyingRecipe(
                new OreDictConfigurationComponent(6, OM.stack(OREMATS.Magnetite, 14 * U), OM.stack(C, 3 * U)));
            Fe.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    6,
                    OM.stack(OREMATS.BasalticMineralSand, 14 * U),
                    OM.stack(C, 3 * U)));
            Fe.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    6,
                    OM.stack(OREMATS.GraniticMineralSand, 14 * U),
                    OM.stack(C, 3 * U)));
            Fe.addAlloyingRecipe(
                new OreDictConfigurationComponent(6, OM.stack(OREMATS.Ferrovanadium, 28 * U), OM.stack(C, 3 * U)));

            Si.addAlloyingRecipe(new OreDictConfigurationComponent(1, OM.stack(SiO2, 3 * U), OM.stack(C, 1 * U)));

            // Al .addAlloyingRecipe(new OreDictConfigurationComponent( 1, OM.stack(OREMATS.Bauxite , 2*U), OM.stack(Na
            // , 1*U)));
            // Al .addAlloyingRecipe(new OreDictConfigurationComponent( 1, OM.stack(OREMATS.Bauxite , 2*U), OM.stack(K ,
            // 1*U)));

            Fe.addAlloyingRecipe(
                new OreDictConfigurationComponent(2, OM.stack(ShadowIron, 1 * U), OM.stack(Ignatius, 1 * U)));
            Fe.addAlloyingRecipe(
                new OreDictConfigurationComponent(2, OM.stack(DeepIron, 1 * U), OM.stack(Prometheum, 1 * U)));
            BlackSteel.addAlloyingRecipe(
                new OreDictConfigurationComponent(2, OM.stack(DeepIron, 1 * U), OM.stack(Infuscolium, 1 * U)));

            Steel.addAlloyingRecipe(
                new OreDictConfigurationComponent(1, OM.stack(WroughtIron, 1 * U), OM.stack(Air, 1 * U)));
            MeteoricSteel.addAlloyingRecipe(
                new OreDictConfigurationComponent(1, OM.stack(MeteoricIron, 1 * U), OM.stack(Air, 1 * U)));

            for (OreDictMaterial tMat : ANY.Glowstone.mToThis) if (tMat != Glowstone) {
                EnergeticAlloy.addAlloyingRecipe(
                    new OreDictConfigurationComponent(1, OM.stack(InductiveAlloy, 2 * U), OM.stack(tMat, 1 * U)));
                Lumium.addAlloyingRecipe(
                    new OreDictConfigurationComponent(
                        4,
                        OM.stack(Sn, 3 * U),
                        OM.stack(Ag, 1 * U),
                        OM.stack(tMat, 4 * U)));
            }
            Ultimet.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    36,
                    OM.stack(Co, 20 * U),
                    OM.stack(Nichrome, 5 * U),
                    OM.stack(Cr, 7 * U),
                    OM.stack(Mo, 4 * U)));
            StainlessSteel.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    36,
                    OM.stack(WroughtIron, 24 * U),
                    OM.stack(Nichrome, 5 * U),
                    OM.stack(Cr, 3 * U),
                    OM.stack(Mn, 4 * U)));
            TungstenSteel.addAlloyingRecipe(
                new OreDictConfigurationComponent(2, OM.stack(MeteoricSteel, 1 * U), OM.stack(W, 1 * U)));
            TungstenSteel.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    2,
                    OM.stack(MeteoricSteel, 1 * U),
                    OM.stack(TungstenSintered, 1 * U)));
            TungstenSteel.addAlloyingRecipe(
                new OreDictConfigurationComponent(2, OM.stack(Steel, 1 * U), OM.stack(TungstenSintered, 1 * U)));
            VanadiumSteel.addAlloyingRecipe(
                new OreDictConfigurationComponent(5, OM.stack(MeteoricSteel, 4 * U), OM.stack(V, 1 * U)));
            ElectricalSteel.addAlloyingRecipe(
                new OreDictConfigurationComponent(1, OM.stack(MeteoricSteel, 1 * U), OM.stack(Si, 1 * U)));
            ObsidianSteel.addAlloyingRecipe(
                new OreDictConfigurationComponent(1, OM.stack(MeteoricSteel, 1 * U), OM.stack(Lava, 9 * U)));
            ObsidianSteel
                .addAlloyingRecipe(new OreDictConfigurationComponent(1, OM.stack(Steel, 1 * U), OM.stack(Lava, 9 * U)));
            EndSteel.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    1,
                    OM.stack(ObsidianSteel, 1 * U),
                    OM.stack(Endstone, 1 * U),
                    OM.stack(Lava, 9 * U)));
            Alumite.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    5,
                    OM.stack(Al, 5 * U),
                    OM.stack(WroughtIron, 2 * U),
                    OM.stack(Lava, 18 * U)));
            Hepatizon.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    24,
                    OM.stack(Bronze, 8 * U),
                    OM.stack(Sn, 1 * U),
                    OM.stack(RoseGold, 15 * U)));
            RedAlloy.addAlloyingRecipe(
                new OreDictConfigurationComponent(1, OM.stack(Mingrade, 2 * U), OM.stack(Redstone, 3 * U)));
            RedAlloy.addAlloyingRecipe(
                new OreDictConfigurationComponent(1, OM.stack(AnnealedCopper, 1 * U), OM.stack(Redstone, 4 * U)));
            RoseGold.addAlloyingRecipe(
                new OreDictConfigurationComponent(5, OM.stack(AnnealedCopper, 1 * U), OM.stack(Au, 4 * U)));
            SterlingSilver.addAlloyingRecipe(
                new OreDictConfigurationComponent(5, OM.stack(AnnealedCopper, 1 * U), OM.stack(Ag, 4 * U)));
            AluminiumBrass.addAlloyingRecipe(
                new OreDictConfigurationComponent(4, OM.stack(AnnealedCopper, 1 * U), OM.stack(Al, 3 * U)));
            Brass.addAlloyingRecipe(
                new OreDictConfigurationComponent(4, OM.stack(AnnealedCopper, 3 * U), OM.stack(Zn, 1 * U)));
            Bronze.addAlloyingRecipe(
                new OreDictConfigurationComponent(4, OM.stack(AnnealedCopper, 3 * U), OM.stack(Sn, 1 * U)));
            ArsenicCopper.addAlloyingRecipe(
                new OreDictConfigurationComponent(4, OM.stack(AnnealedCopper, 3 * U), OM.stack(As, 1 * U)));
            ArsenicBronze.addAlloyingRecipe(
                new OreDictConfigurationComponent(5, OM.stack(ArsenicCopper, 4 * U), OM.stack(Sn, 1 * U)));
            BlackBronze.addAlloyingRecipe(
                new OreDictConfigurationComponent(5, OM.stack(AnnealedCopper, 3 * U), OM.stack(Electrum, 2 * U)));
            BlackBronze.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    20,
                    OM.stack(Cu, 11 * U),
                    OM.stack(RoseGold, 5 * U),
                    OM.stack(Ag, 4 * U)));
            BlackBronze.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    20,
                    OM.stack(AnnealedCopper, 11 * U),
                    OM.stack(RoseGold, 5 * U),
                    OM.stack(Ag, 4 * U)));
            BlackBronze.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    20,
                    OM.stack(Cu, 11 * U),
                    OM.stack(SterlingSilver, 5 * U),
                    OM.stack(Au, 4 * U)));
            BlackBronze.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    20,
                    OM.stack(AnnealedCopper, 11 * U),
                    OM.stack(SterlingSilver, 5 * U),
                    OM.stack(Au, 4 * U)));
            Signalum.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    8,
                    OM.stack(AnnealedCopper, 1 * U),
                    OM.stack(Ag, 2 * U),
                    OM.stack(RedAlloy, 5 * U)));
            Signalum.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    16,
                    OM.stack(Cu, 1 * U),
                    OM.stack(SterlingSilver, 5 * U),
                    OM.stack(RedAlloy, 10 * U)));
            Signalum.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    16,
                    OM.stack(AnnealedCopper, 1 * U),
                    OM.stack(SterlingSilver, 5 * U),
                    OM.stack(RedAlloy, 10 * U)));
            Constantan.addAlloyingRecipe(
                new OreDictConfigurationComponent(2, OM.stack(AnnealedCopper, 1 * U), OM.stack(Ni, 1 * U)));
            YttriumBariumCuprate.addAlloyingRecipe(
                new OreDictConfigurationComponent(
                    6,
                    OM.stack(AnnealedCopper, 3 * U),
                    OM.stack(Ba, 2 * U),
                    OM.stack(Y, U)));
            YttriumBariumCuprate.addAlloyingRecipe(
                new OreDictConfigurationComponent(6, OM.stack(Cu, 3 * U), OM.stack(Ba, 2 * U), OM.stack(Y, U)));
            Li2Fe2O4
                .addAlloyingRecipe(new OreDictConfigurationComponent(8, OM.stack(Fe2O3, 5 * U), OM.stack(Li2O, 3 * U)));

            Aredrite.setGenerifying(Ardite);
            Orichalcum.setGenerifying(Brass);
            Oilshale.setGenerifying(MT.STONES.Shale);
            for (OreDictMaterial tMaterial : ANY.Ash.mToThis) tMaterial.setGenerifying(MT.Ash);
            for (OreDictMaterial tMaterial : ANY.Diamond.mToThis) tMaterial.setGenerifying(MT.Diamond);
            for (OreDictMaterial tMaterial : ANY.Sapphire.mToThis) tMaterial.setGenerifying(MT.Sapphire);
            for (OreDictMaterial tMaterial : ANY.Emerald.mToThis) tMaterial.setGenerifying(MT.Emerald);
            for (OreDictMaterial tMaterial : ANY.Jasper.mToThis) tMaterial.setGenerifying(MT.Jasper);
            for (OreDictMaterial tMaterial : ANY.TigerEye.mToThis) tMaterial.setGenerifying(MT.TigerEyeYellow);
            for (OreDictMaterial tMaterial : ANY.CaF2.mToThis) tMaterial.setGenerifying(MT.CaF2);
            for (OreDictMaterial tMaterial : ANY.Rubber.mToThis) tMaterial.setGenerifying(MT.Rubber);
            for (OreDictMaterial tMaterial : ANY.Plastic.mToThis) tMaterial.setGenerifying(MT.Plastic);
            for (OreDictMaterial tMaterial : ANY.Wood.mToThis) tMaterial.setGenerifying(MT.Wood);
            for (OreDictMaterial tMaterial : ANY.Wax.mToThis) tMaterial.setGenerifying(MT.Wax);
            for (OreDictMaterial tMaterial : ANY.Phosphorus.mToThis) tMaterial.setGenerifying(MT.Phosphorus);
            for (OreDictMaterial tMaterial : ANY.Clay.mToThis) tMaterial.setGenerifying(MT.Clay);
            for (OreDictMaterial tMaterial : ANY.Si.mToThis) tMaterial.setGenerifying(MT.Si);

            String tMakeSteel = "In order to make Steel you just need to melt Iron or Wrought Iron in a Smelting Crucible and apply Air to it using an Engine.";
            String tMakeWroughtIron = "Wrought Iron is created by heating up Iron until " + WroughtIron.mMeltingPoint
                + " Kelvin to dissolve most unwanted impurities.";
            String tMakeAnnealedCopper = "Annealed Copper is created by heating up Copper until "
                + AnnealedCopper.mMeltingPoint
                + " Kelvin to dissolve most unwanted impurities.";
            String tMakeAluminium = "Making Aluminium is a very complicated chemical Process. You will need an LV Electrolyzer, a Mixer, a Corrosion Resistant Crucible or a Smelter, Fluorite, Saltwater, Alumina and a bit more to do it.";
            String tKillWerewolf = "It is also very useful in order to kill Werewolves and alike, since everyone knows how Werewolves are allergic to Silver! It also works on Armor like a kind of Thorns (without the stupid extra armor damage)";
            String tKillSlime = "Somehow this Material dissolves Slimey substances and therefore causes severe damage to Slimes and similar Creatures!";

            Redstone.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Redstone consists out of many things and has a lot in common with Cinnabar, even though containing much more than just Mercury and Sulfur. Redstone is usually found at places with Rare Earths." };

            Ag.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Silver, the Material Endermen fear the most. Somehow this Material can interfere with the ability of Endermen to teleport, and even damages them dramatically, as if it were poisonous to them.",
                tKillWerewolf };

            Cu.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Copper is a Material, which is needed in almost every electrical Device. But not only that, it is also used to make Bronze, Brass, Cupronickel and some other Alloys.",
                tKillSlime, tMakeAnnealedCopper };

            AnnealedCopper.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Annealed Copper is just Copper cleaned from impurities. Therefore some of Coppers natural properties are better than in unpurified Copper.",
                tKillSlime, tMakeAnnealedCopper };

            Al.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Aluminium is a shiny rare Metal, that is extremely difficult to setup a production for. You will need to convert Alumina into Aluminium using Chemicals and an Electrolyzer.",
                tMakeAluminium };

            Al2O3.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Aluminas are the Materials used to create Aluminium out of. It is basically corroded Aluminium and removing said corrosion can be quite difficult and even requires electricity.",
                tMakeAluminium };

            OREMATS.Bauxite.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "", tMakeAluminium };

            Fe.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Iron, the most needed Material in Minecraft, unless you have an Iron Titan or something. Nearly every Mod needs it in order to proceed with its Machines. It exists in many Shapes and Forms, such as",
                "Compressed Iron, Wrought Iron, Steel, HSLA Steel, Dark Iron, Deep Iron, Meteoric Iron, Conductive Iron, Electrical Steel, Pulsating Iron, Mutated Iron, Shadow Iron, Ironwood and many many more things.",
                "It is a very useful Material as it is required to make Steel, the Stuff almost everything Technological is made of. You can also make Wrought Iron, to craft Tools slightly better than Iron Tools.",
                tMakeWroughtIron, tMakeSteel };

            WroughtIron.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Wrought Iron, a Material that is worth as much as Iron. It is just a step between Iron itself and Steel, and is just a cleaner Version of Iron. It is also a slightly better Tool Material than Iron.",
                tMakeWroughtIron, tMakeSteel };

            Steel.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Steel, the Material Standard Machinery is made of. Cheap, abundant and common, as it only requires Iron and some source of Carbon. There are many different Ways of making Steel supplied by many Mods.",
                tMakeSteel };

            C.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Carbon. Not much to say about it. It is used to make Steel. Uhhm, maybe it has some other uses explained in a later Edition of this Book.",
                tMakeSteel };

            Diamond.mDescription = DiamondPink.mDescription = DiamondIndustrial.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Diamonds, the shiny Stuff every Minecrafter looks for. Some people may even create living Horses made of Diamonds.",
                tMakeSteel };

            Graphite.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Graphite is a Source of Carbon. It can also be used to make Steel directly.", tMakeSteel };

            DamascusSteel.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Damascus Steel is a very rare kind of Steel. Rare meaning actually nobody knows how to produce it anymore as they are all dead. Maybe ask a Zombie or a Skeleton on how to make it?",
                "Because of that, it can only be found in old Structures such as Dungeons. Sometimes Villagers stumble upon this rare Steel or things made of it and take it home to give it to their Blacksmith.",
                "It is a very good Tool Material and even surpasses Blue Steel in its Quality. It has Vanadium and Tungsten impurities which improve the stability of the Carbides when Forging at higher Temperatures." };

            Craponite.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Craponite is a very exquisite Material used only in the fanciest Jewelry. It looks best in combination with Peridot. That is why Teleshopping Channels often sell Peridot Craponite Earrings and alike." };

            Ir.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Iridium, a very rare Metal used in only the most advanced Technology. Its properties are very versatile and used in many advanced Devices.",
                "Iridium is a Metal that can stabilise a Tesseract, so that it can transfer much larger Amounts of Matter and Energy.",
                "As Weapon it is very useful in order to kill Shapeshifters, since it is highly Toxic to them. Now, if there were Shapeshifters in our World this Information would be more useful." };

            Desh.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Desh is a Material that is very hard to alloy, which is typically only found naturally on Mars (the Planet, not the God, Pokemon Trainer or Candy Bar).",
                "In order to create this Alloy, it is advised to insert Materials with a low Boiling Point such as Lithium very last and all at once into the Crucible.",
                "It is also advised to use a Crucible with a high Heat Capacity as well as drip feeding low Amounts of Material, so the Temperature does not go down too much upon insertion.",
                "Desh is a completely fictional Material made up by Galacticraft, and is only used by Galacticraft itself, it's Addons and also HBM's Mods." };

            Tc.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Technetium, named after Gregorius Techneticies, is the first Element of the Periodic System, which has no stable Isotope. Its usage is mostly limited to Medical Applications.",
                "Fun Fact:\nEvery Element, which has no Elemental Stats assigned to, will automatically default to the Elemental Stats of Technetium." };

            Mcg.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Mac-Guffium, the most useful Material of them all. It can be used for everything, as long as its underlying Science is too obscure to be understood.",
                "Possible Applications are: Time Travel, Infinite Impossibility Drives, World Peace, World Domination, World War, World War II, World War IV, Curing all Diseases, Stopping Global Warming,",
                "Controlling the Weather, Turning everything into Gold, Turning you into a God, Killing a God, Making Dark Matter an Energy Source, Tesseracts, Wormholes, Black Holes, Bending Space and Time, Tardis,",
                "Ascension to a higher Level of existence, Invisibility, Killing Chuck Norris, Cloning, Making Profit of collecting Underpants, Making the Impossible possible, Love Rays, Hate Rays, Perpetuum Mobiles,",
                "Making you able to hold and use Thors Hammer, and ofcourse baking delicious Cookies." };

            Nq.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "This extremly rare Material is called Naquadah. Its properties make it very useful in highly advanced Technology.",
                "It is a Superconductor even at very high Temperatures, what makes it seeming Ideal for electric Wiring as long as the amount of transferred Electricity is not too large.",
                "Another property of it is that it emits Gamma Radiation when supplied with enough Electricity, due to creating Positrons out of said Energy, which then collide with Electrons very quickly.",
                "However that property makes it very unstable and can result in a Nuclear Explosion when not regulated properly, especially with molten Naquadah." };

            Nq_528.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "This is a heavy Isotope of Naquadah mainly used to generate Energy, or to create Bombs.",
                "Due to being less stable than regular Naquadah, supplying this Isotope with Electricity results in a very strong Nuclear Reaction, which when regulated properly can result in a constant Energy Source.",
                "The instability increases when this Isotope is molten, resulting in a larger Energy Output when used in Reactors.",
                "Its instability is also often used to make Naquadah Bombs, which are much more destructive than the regular Plutonium Nukes. It doesn't make any difference to use the molten or the solid Isotope",
                "for Bombs, since its explosion heats up the whole Bomb far above the melting Point anyways." };

            Nq_522.mDescription = new String[] {
                // ========================================================================================================================================================================================================
                "Naquadria, a light and extremely unstable Isotope of Naquadah. It can be used for Reactors as well as Bombs and is much stronger than heavy Naquadah.",
                "It is created when Naquadah is receiving too large amounts of Gamma Radiation. During its creation it emits more Gamma Radiation turning adjacent Naquadah into Naquadria too.",
                "The Natural origin of this Isotope is a Gamma Ray Burst, which hits a Naquadah Vein directly. Planets to which that happens are then turning into a Desert due to the enormous Heat created by the Ray.",
                "Gamma Bombs which are exploding far enough away from a Naquadah Vein, or just a strong enough Gamma Ray, can also trigger a Chain Reaction turing Naquadah into Naquadria.",
                "However most of the time a Gamma Ray hits a Naquadah Vein, it just explodes, what is the main Factor of Naquadria being very rare. Also Naquadria turns back into Naquadah after a few thousand years." };

            Mauftrium.mHandleMaterial = Elvorium.mHandleMaterial = MuspelheimPower.mHandleMaterial = NiflheimPower.mHandleMaterial = ElvenElementium.mHandleMaterial = ElvenDragonstone.mHandleMaterial = Manasteel.mHandleMaterial = Terrasteel.mHandleMaterial = ManaDiamond.mHandleMaterial = Thaumium.mHandleMaterial = ANY.WoodMagical;
            GaiaSpirit.mHandleMaterial = ElvenElementium;
            FierySteel.mHandleMaterial = Fireleaf.mHandleMaterial = MeteoflameSteel.mHandleMaterial = MeteoflameBlackSteel.mHandleMaterial = MeteoflameBlueSteel.mHandleMaterial = MeteoflameRedSteel.mHandleMaterial = FlamascusSteel.mHandleMaterial = Firestone.mHandleMaterial = ANY.Blaze;
            Endium.mHandleMaterial = Endstone;
            SpectreIron.mHandleMaterial = Obsidian;
            EnderAmethyst.mHandleMaterial = Meteorite.mHandleMaterial = Kreknorite.mHandleMaterial = Sugilite.mHandleMaterial = ANY.Iron;
            DarkMatter.mHandleMaterial = Diamond;
            RedMatter.mHandleMaterial = DarkMatter;
            Desh.mHandleMaterial = Desh;
            Etx.mHandleMaterial = Etx;
            Vb.mHandleMaterial = VibraniumSteel.mHandleMaterial = VibraniumSilver.mHandleMaterial = VibraniumSteel;
            Vibramantium.mHandleMaterial = Vibramantium;
            VoidMetal.mHandleMaterial = InfusedAir.mHandleMaterial = InfusedBalance.mHandleMaterial = InfusedDull.mHandleMaterial = InfusedEarth.mHandleMaterial = InfusedEntropy.mHandleMaterial = InfusedFire.mHandleMaterial = InfusedOrder.mHandleMaterial = InfusedWater.mHandleMaterial = InfusedVis.mHandleMaterial = DarkThaumium.mHandleMaterial = ANY.MagicIron;
        }
    }

    public static class DATA {

        static {
            MaterialsInit.load();
        }
        public static OreDictItemData[] WIRES_01, WIRES_04, CABLES_01, CABLES_04, CIRCUITS;
        public static OreDictMaterial[] Dye_Materials, Heat_T, Kinetic_T, Electric_T, Flux_T;
    }

    /** The Section where I place regular Ores that are only used in advanced processing anyways due to complexity. */
    public static class OREMATS {

        static {
            MaterialsInit.load();
        }

        @Deprecated
        @SuppressWarnings("hiding")
        public static OreDictMaterial Pyrolusite, Rutile, Hematite, Magnesite, Gypsum, Bentonite, FullersEarth,
            Kaolinite;
        public static OreDictMaterial Cassiterite, CassiteriteSand, Garnierite, Uraninite, Magnetite,
            BasalticMineralSand, GraniticMineralSand, Realgar, Cinnabar, Molybdenite, Sphalerite, Stibnite, Pentlandite,
            Chalcopyrite, Arsenopyrite, Cobaltite, Galena, Cooperite, Tetrahedrite, Kesterite, Stannite, Barite,
            Celestine, Scheelite, Wolframite, Ferberite, Huebnerite, Tungstate, Stolzite, Russellite, Pinalite,
            Wollastonite, Zeolite, Pollucite, BrownLimonite, YellowLimonite, Ferrovanadium, Tantalite, Columbite,
            Coltan, Ilmenite, Bauxite, Chromite, Powellite, Wulfenite, Bastnasite, Pitchblende, Malachite, Bromargyrite,
            Smithsonite, Sperrylite, Perlite, Trona, Mirabilite, Bischofite, Borax, Diatomite, Spodumene, Lepidolite,
            Glauconite, GlauconiteSand, Vermiculite, Mica, Kyanite, Alunite, GarnetSand, QuartzSand, DiduraniumTrioxide,
            DuraniumHexafluoride, DuraniumHexachloride, DuraniumHexabromide, DuraniumHexaiodide, DuraniumHexaastatide,
            TritaniumDioxide, TritaniumHexafluoride, TritaniumHexachloride, TritaniumHexabromide, TritaniumHexaiodide,
            TritaniumHexaastatide;
    }

    /** Had to move a chunk of Materials into its own Class due to space Issues... */
    public static class STONES {

        static {
            MaterialsInit.load();
        }

        @SuppressWarnings("hiding")
        public static OreDictMaterial SpaceRock, MoonRock, MoonTurf, MarsRock, MarsSand, SkyStone, Holystone,
            Livingrock, Deadrock, Betweenstone, Pitstone, Cragrock, Templerock, Mazestone, Castlerock, Umber, Shale,
            Redrock, Komatiite, Pumice, Gabbro, Basalt, Marble, Limestone, Greenschist, Blueschist, Grayschist,
            Pinkschist, Gneiss, Kimberlite, Quartzite, GraniteRed, GraniteBlack, Granite, Andesite, Diorite, Blackstone,
            Greywacke, Siltstone, Rhyolite, Migmatite, Chert, Dacite, Slate, Deepslate, Eclogite, PhobosRock,
            DeimosRock, VenusRock, MercuryRock, CeresRock, JupiterRock, IoRock, EuropaRock, GanymedeRock, CallistoRock,
            SaturnRock, RheaRock, TitanRock, OberonRock, IapetusRock, UranusRock, TitaniaRock, NeptuneRock, TritonRock,
            PlutoRock, ErisRock, Kepler22bRock;
    }

    /** Taking over Wood Materials from QwerTech, with major changes because damn that shit was broken. */
    public static class WOODS {

        static {
            MaterialsInit.load();
        }

        @SuppressWarnings("hiding")
        public static OreDictMaterial Oak, Birch, Spruce, Jungle, Acacia, DarkOak, Crimson, Warped, Foxfire, Compressed,
            Dead, Rotten, Mossy, Frozen, Scorched, Varnished, Bleached, Tainted, Maple, Willow, BlueMahoe, Hazel,
            Cinnamon, Coconut, Rainbowood, BlueSpruce, Towerwood, Witchwood, Ogre, Wyvern, Aspen, DouglasFir, Sycamore,
            WhiteCedar, WhiteElm, Thorntree, SilverPine, Alder, Hawthorn, Rowan, Mahogany, Palm, Autumn, Cypress, Fir,
            JapaneseMaple, RainbowEucalyptus, Redwood, Sakura, Balsa, Baobab, Cherry, Chestnut, Citrus, Cocobolo, Ebony,
            Giganteum, Greenheart, Ipe, Kapok, Larch, Lime, Mahoe, Padauk, Papaya, Plum, Poplar, Sequoia, Teak, Walnut,
            Wenge, Zebrawood, Pine, Darkwood, Ethereal, Gold, HellBark, Jacaranda, Mangrove, SacredOak, Magic, Apple,
            Ash, Beech, Box, Brazilwood, Butternut, Cedar, Elder, Elm, Eucalyptus, Fig, Gingko, Hemlock, Hickory, Holly,
            Hornbeam, Iroko, Locust, Logwood, Maclura, Olive, Pear, PinkIvory, Purpleheart, Rosewood, Sweetgum, Syzgium,
            Whitebeam, Yew;
    }

    /**
     * The "I don't care" Section, everything I don't want to do anything with right now. Just to make the Material
     * Finder shut up about them. But I do see potential uses in some of these Materials.
     */
    public static class UNUSED {

        static {
            MaterialsInit.load();
        }
        public static OreDictMaterial OsmiumTetroxide, SodiumPeroxide, IridiumSodiumOxide, Iridiron, IridironReinforced,
            LimePure, TNT, TerrasteelAlloyRaw, TerrasteelAlloyStrengthened, Vis, Voidstone, Mercassium, Osmonium,
            Phoenixite, Antimatter, Starconium, Thyrium, Zectium, Draconic, Teslatite, IrridantUranium,
            IrridantReinforced, IronSharp, ObsidianFlux, CrystalFlux, Mimichite, Infernal, Invisium, Lodestone,
            Luminite, Magma, Mawsitsit, Nether, Painite, Petroleum, Pewter, Potash, Randomite, RyuDragonRyder, Tar,
            TarPitch, Cavenium, CaveniumRefined, Infitite, Magnite, Hexcite, Tapazite, Tourmaline, Turquoise, Wimalite,
            Adamite, Adluorite, Agate, Ammonium, Bitumen, Bloodstone, Citrine, Coral, Chrysocolla, DarkStone, Demonite,
            InfusedGold, Daffergon, Reiium, Weidanium, Verticium, Australium, Schrabidium, Starmetal, Unobtainium,
            CMBSteel, DuraSteel, AdvancedAlloy, Saturnite, Dineutronium, MagnetizedTungsten, Euphemium, Rupee, Arlemite,
            Realmite, Bloodgem, Netheryte, Eden, Wildwood, Apalachia, Skythern, Mortum, Arcanium, Energized, Reinforced,
            Mud, Cream, Cluster, Sweet, Gelatine, Satinspar, Selenite, Jet, Microcline, Serpentine, Sylvite, Goshen,
            Joshen, Itarius, Legendary, MutatedIron, Witheria, RubberTreeSap, GraveyardDirt, Cocaine, Vile, Dull, Dark,
            Soulium, Tennantite, Alfium, Ryu, Mutation, HOPGraphite, EnrichedCopper, DiamondCopper, Fairy, Pokefennium;
    }
}
