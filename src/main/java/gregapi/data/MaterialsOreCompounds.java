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

import gregapi.data.materials.IMaterialCategory;

/**
 * The regular Ores that are only used by the advanced Ore Processing.
 * <p>
 * Loaded as the "Ore Compounds" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsOreCompounds implements IMaterialCategory {

    @Override
    public String getName() {
        return "Ore Compounds";
    }

    @Override
    public void load() {
        MT.OREMATS.Pyrolusite = MT.MnO2;
        MT.OREMATS.Rutile = MT.TiO2;
        MT.OREMATS.Hematite = MT.Fe2O3;
        MT.OREMATS.Magnesite = MT.MgCO3;
        MT.OREMATS.Gypsum = MT.Gypsum;
        MT.OREMATS.Bentonite = MT.Bentonite;
        MT.OREMATS.FullersEarth = MT.Palygorskite;
        MT.OREMATS.Kaolinite = MT.Kaolinite;;
        MT.OREMATS.Cassiterite = MT.oredustelec(

            9108,

            "Cassiterite",

            SET_METALLIC,

            220,

            220,

            220,

            255,

            MORTAR,

            FURNACE,

            "CassiteriteSand")
            .setSmelting(MT.Sn, 3 * U4)

            .addSourceOf(MT.Sn)

            .setMcfg(1, MT.Sn, 1 * U, MT.O, 2 * U)

            .heat(3 * MT.Sn.mMeltingPoint / 2);
        MT.OREMATS.CassiteriteSand = MT.OREMATS.Cassiterite;
        MT.OREMATS.Garnierite = MT.oredustelec(

            9118,

            "Garnierite",

            SET_METALLIC,

            50,

            200,

            70,

            255,

            MORTAR,

            BLACKLISTED_SMELTER,

            MAGNETIC_PASSIVE,

            WASHING_PERSULFATE)
            .setSmelting(MT.Ni, 3 * U4)

            .addSourceOf(MT.Ni)

            .setMcfg(1, MT.Ni, 1 * U, MT.O, 1 * U)

            .qual(0);
        MT.OREMATS.Uraninite = MT.oredustdcmp(9134, "Uraninite", SET_RAD, 35, 35, 35, 255, BLACKLISTED_SMELTER)

            .setSmelting(MT.U_238, U3)

            .addSourceOf(MT.U_238)

            .setMcfg(1, MT.U_238, 1 * U, MT.O, 2 * U);
        MT.OREMATS.Magnetite = MT
            .oredustdcmp(9122, "Magnetite", SET_METALLIC, 30, 30, 30, 255, MORTAR, MELTING, MAGNETIC_PASSIVE)

            .addSourceOf(MT.Fe)

            .setMcfg(0, MT.Fe, 3 * U, MT.O, 4 * U)

            .qual(0)

            .heat(MT.Fe.mMeltingPoint)

            .aspects(TC.METALLUM, 2, TC.MAGNETO, 1);
        MT.OREMATS.BasalticMineralSand = MT.oredustdcmp(

            9003,

            "Basaltic Mineral Sand",

            SET_METALLIC,

            40,

            50,

            40,

            255,

            MORTAR,

            MELTING,

            MAGNETIC_PASSIVE)
            .addSourceOf(MT.Fe)

            .setMcfg(0, MT.Fe, 3 * U, MT.O, 4 * U)

            .qual(0)

            .heat(MT.Fe.mMeltingPoint)

            .aspects(TC.METALLUM, 2, TC.MAGNETO, 1);
        MT.OREMATS.GraniticMineralSand = MT.oredustdcmp(

            9004,

            "Granitic Mineral Sand",

            SET_METALLIC,

            40,

            60,

            60,

            255,

            MORTAR,

            MELTING,

            MAGNETIC_PASSIVE)
            .addSourceOf(MT.Fe)

            .setMcfg(0, MT.Fe, 3 * U, MT.O, 4 * U)

            .qual(0)

            .heat(MT.Fe.mMeltingPoint)

            .aspects(TC.METALLUM, 2, TC.MAGNETO, 1);
        MT.OREMATS.Realgar = MT.oredustdcmp(

            9109,

            "Realgar",

            SET_EMERALD,

            157,

            33,

            35,

            255,

            G_GEM_ORES_TRANSPARENT,

            MORTAR,

            BRITTLE,

            FURNACE,

            CRYSTAL)
            .setSmelting(MT.As, U3)

            .addSourceOf(MT.As)

            .uumMcfg(0, MT.As, 1 * U, MT.S, 1 * U)

            .qual(0)

            .lens(DYE_INDEX_Red);
        MT.OREMATS.Cinnabar = MT.oredustcent(

            9114,

            "Cinnabar",

            SET_REDSTONE,

            150,

            0,

            0,

            255,

            G_GEM_ORES_TRANSPARENT,

            MORTAR,

            BRITTLE,

            CRYSTAL,

            PULVERIZING_CINNABAR)
            .setSmelting(MT.Hg, U3)

            .addSourceOf(MT.Hg)

            .uumMcfg(0, MT.Hg, 1 * U, MT.S, 1 * U);
        MT.OREMATS.Molybdenite = MT.oredustdcmp(

            9123,

            "Molybdenite",

            SET_METALLIC,

            25,

            25,

            25,

            255,

            G_GEM_ORES,

            MORTAR,

            BLACKLISTED_SMELTER,

            WASHING_FIRESTONE)
            .setSmelting(MT.Mo, U4)

            .addSourceOf(MT.Mo)

            .uumMcfg(0, MT.Mo, 1 * U, MT.S, 2 * U);
        MT.OREMATS.Sphalerite = MT.oredustdcmp(

            9130,

            "Sphalerite",

            SET_DULL,

            222,

            222,

            0,

            255,

            G_GEM_ORES,

            MORTAR,

            FURNACE,

            WASHING_PERSULFATE)
            .setSmelting(MT.Zn, U3)

            .addSourceOf(MT.Zn)

            .uumMcfg(0, MT.Zn, 1 * U, MT.S, 1 * U);
        MT.OREMATS.Stibnite = MT.oredustdcmp(

            9131,

            "Stibnite",

            SET_METALLIC,

            70,

            70,

            70,

            255,

            G_GEM_ORES,

            MORTAR,

            BLACKLISTED_SMELTER)
            .setSmelting(MT.Sb, U4)

            .addSourceOf(MT.Sb)

            .uumMcfg(0, MT.Sb, 2 * U, MT.S, 3 * U)

            .heat(823);
        MT.OREMATS.Pentlandite = MT.oredustdcmp(

            9145,

            "Pentlandite",

            SET_DULL,

            165,

            150,

            5,

            255,

            G_GEM_ORES,

            MORTAR,

            BLACKLISTED_SMELTER,

            MAGNETIC_PASSIVE,

            WASHING_PERSULFATE)
            .setSmelting(MT.Ni, U3)

            .addSourceOf(MT.Ni)

            .uumMcfg(0, MT.Ni, 9 * U, MT.S, 8 * U)

            .qual(0);
        // (Fe,Ni)9S8
        MT.OREMATS.Chalcopyrite = MT
            .oredustdcmp(9111, "Chalcopyrite", SET_DULL, 160, 120, 40, 255, G_GEM_ORES, MORTAR, FURNACE)

            .setSmelting(MT.Cu, 2 * U9)

            .addSourceOf(MT.Cu, MT.Fe)

            .uumMcfg(0, MT.Cu, 1 * U, MT.Fe, 1 * U, MT.S, 2 * U)

            .qual(0);
        MT.OREMATS.Arsenopyrite = MT.oredustdcmp(

            9216,

            "Arsenopyrite",

            SET_CUBE_SHINY,

            250,

            240,

            30,

            255,

            G_GEM_ORES,

            MORTAR,

            BLACKLISTED_SMELTER)
            .setSmelting(MT.As, U4)

            .addSourceOf(MT.Fe, MT.As)

            .uumMcfg(0, MT.Fe, 1 * U, MT.As, 1 * U, MT.S, 1 * U)

            .qual(0);
        MT.OREMATS.Cobaltite = MT.oredustdcmp(

            9115,

            "Cobaltite",

            SET_METALLIC,

            80,

            80,

            250,

            255,

            G_GEM_ORES,

            MORTAR,

            BLACKLISTED_SMELTER,

            MAGNETIC_PASSIVE,

            WASHING_PERSULFATE)
            .setSmelting(MT.Co, U4)

            .addSourceOf(MT.Co, MT.As)

            .uumMcfg(0, MT.Co, 1 * U, MT.As, 1 * U, MT.S, 1 * U)

            .qual(0);
        MT.OREMATS.Galena = MT.oredustdcmp(9117, "Galena", SET_DULL, 100, 60, 100, 255, G_GEM_ORES, MORTAR, FURNACE)

            .setSmelting(MT.Pb, U3)

            .addSourceOf(MT.Pb, MT.Ag)

            .uumMcfg(0, MT.Pb, 3 * U, MT.Ag, 3 * U, MT.S, 2 * U);
        MT.OREMATS.Cooperite = MT.oredustdcmp(

            9116,

            "Cooperite",

            SET_METALLIC,

            130,

            160,

            230,

            255,

            G_GEM_ORES,

            MORTAR,

            BLACKLISTED_SMELTER,

            WASHING_MERCURY,

            "Sheldonite")
            .setSmelting(MT.Pt, U3)

            .addSourceOf(MT.Pt, MT.Ni, MT.Pd)

            .uumMcfg(0, MT.Pt, 3 * U, MT.Ni, 1 * U, MT.Pd, 1 * U, MT.S, 1 * U)

            .setLocal("Sheldonite");
        MT.OREMATS.Tetrahedrite = MT.oredustdcmp(

            9132,

            "Tetrahedrite",

            SET_DULL,

            200,

            32,

            0,

            255,

            G_GEM_ORES,

            MORTAR,

            FURNACE,

            WASHING_PERSULFATE)
            .setSmelting(MT.Cu, U4)

            .addSourceOf(MT.Cu, MT.Sb, MT.Fe)

            .uumMcfg(0, MT.Cu, 3 * U, MT.Sb, 1 * U, MT.Fe, 1 * U, MT.S, 3 * U);
        // Cu3SbS3 + x(Fe,Zn)6Sb2S9
        MT.OREMATS.Kesterite = MT.oredustdcmp(

            9213,

            "Kesterite",

            SET_DULL,

            105,

            155,

            105,

            255,

            G_GEM_ORES,

            MORTAR,

            BLACKLISTED_SMELTER)
            .setSmelting(MT.Cu, U9)

            .addSourceOf(MT.Cu, MT.Zn, MT.Sn)

            .uumMcfg(0, MT.Cu, 2 * U, MT.Zn, 1 * U, MT.Sn, 1 * U, MT.S, 4 * U);
        MT.OREMATS.Stannite = MT.oredustdcmp(

            9214,

            "Stannite",

            SET_METALLIC,

            155,

            145,

            55,

            255,

            G_GEM_ORES,

            MORTAR,

            BLACKLISTED_SMELTER)
            .setSmelting(MT.Cu, U9)

            .addSourceOf(MT.Cu, MT.Fe, MT.Sn)

            .uumMcfg(0, MT.Cu, 2 * U, MT.Fe, 1 * U, MT.Sn, 1 * U, MT.S, 4 * U);
        MT.OREMATS.Barite = MT
            .oredustelec(9160, "Barite", SET_DULL, 230, 235, 255, 255, G_GEM_ORES, MORTAR, BLACKLISTED_SMELTER)

            .setSmelting(MT.Ba, U9)

            .addSourceOf(MT.Ba)

            .uumMcfg(0, MT.Ba, 1 * U, MT.S, 1 * U, MT.O, 4 * U)

            .heat(1853);
        MT.OREMATS.Celestine = MT.oredustelec(

            9110,

            "Celestine",

            SET_DULL,

            200,

            205,

            240,

            255,

            G_GEM_ORES,

            MORTAR,

            BLACKLISTED_SMELTER)
            .setSmelting(MT.Sr, U9)

            .addSourceOf(MT.Sr)

            .uumMcfg(0, MT.Sr, 1 * U, MT.S, 1 * U, MT.O, 4 * U);
        MT.OREMATS.Scheelite = MT.oredustdcmp(

            9128,

            "Scheelite",

            SET_DULL,

            200,

            140,

            20,

            255,

            BLACKLISTED_SMELTER,

            WASHING_FIRESTONE,

            "CalciumTungstate")
            .addSourceOf(MT.W)

            .uumMcfg(0, MT.Ca, 1 * U, MT.WO3, 4 * U, MT.O, 1 * U)

            .qual(3);
        MT.OREMATS.Wolframite = MT.oredustdcmp(

            9217,

            "Wolframite",

            SET_DULL,

            55,

            50,

            35,

            255,

            BLACKLISTED_SMELTER,

            WASHING_FIRESTONE)
            .addSourceOf(MT.W)

            .uumMcfg(0, MT.Mg, 1 * U, MT.WO3, 4 * U, MT.O, 1 * U)

            .qual(3);
        MT.OREMATS.Ferberite = MT.oredustdcmp(

            9194,

            "Ferberite",

            SET_DULL,

            55,

            50,

            35,

            255,

            BLACKLISTED_SMELTER,

            WASHING_FIRESTONE)
            .addSourceOf(MT.W, MT.Fe)

            .uumMcfg(0, MT.Fe, 1 * U, MT.WO3, 4 * U, MT.O, 1 * U)

            .qual(3);
        MT.OREMATS.Huebnerite = MT.oredustdcmp(

            9195,

            "Huebnerite",

            SET_DULL,

            55,

            50,

            35,

            255,

            BLACKLISTED_SMELTER,

            WASHING_FIRESTONE,

            "Gyubnera")
            .addSourceOf(MT.W, MT.Mn)

            .uumMcfg(0, MT.Mn, 1 * U, MT.WO3, 4 * U, MT.O, 1 * U)

            .qual(3);
        MT.OREMATS.Tungstate = MT.oredustdcmp(

            9133,

            "Tungstate",

            SET_DULL,

            55,

            50,

            35,

            255,

            BLACKLISTED_SMELTER,

            WASHING_FIRESTONE)
            .addSourceOf(MT.W, MT.Li)

            .uumMcfg(0, MT.Li, 2 * U, MT.WO3, 4 * U, MT.O, 1 * U)

            .qual(3);
        // TODO Actual Processing, but I don't know what could do it
        MT.OREMATS.Stolzite = MT.oredustdcmp(

            9193,

            "Stolzite",

            SET_DULL,

            55,

            50,

            35,

            255,

            BLACKLISTED_SMELTER,

            WASHING_FIRESTONE,

            "Raspite")
            .setSmelting(MT.WO3, 4 * U6)

            .addSourceOf(MT.W, MT.Pb)

            .uumMcfg(0, MT.Pb, 1 * U, MT.WO3, 4 * U, MT.O, 1 * U)

            .qual(3);
        MT.OREMATS.Russellite = MT.oredustdcmp(

            9196,

            "Russellite",

            SET_DULL,

            55,

            50,

            35,

            255,

            BLACKLISTED_SMELTER,

            WASHING_FIRESTONE)
            .setSmelting(MT.WO3, 4 * U9)

            .addSourceOf(MT.W, MT.Bi)

            .setMcfg(0, MT.Bi, 2 * U, MT.WO3, 4 * U, MT.O, 3 * U)

            .qual(3);
        MT.OREMATS.Pinalite = MT
            .oredustdcmp(9197, "Pinalite", SET_DULL, 55, 50, 35, 255, BLACKLISTED_SMELTER, WASHING_FIRESTONE)

            .setSmelting(MT.WO3, 4 * U11)

            .addSourceOf(MT.W, MT.Pb)

            .uumMcfg(0, MT.Pb, 3 * U, MT.WO3, 4 * U, MT.Cl, 2 * U, MT.O, 2 * U)

            .qual(3);
        MT.OREMATS.Wollastonite = MT
            .oredustelec(9164, "Wollastonite", SET_DULL, 240, 240, 240, 255, BLACKLISTED_SMELTER)

            .setMcfg(0, MT.Ca, 1 * U, MT.SiO2, 3 * U, MT.O, 1 * U);
        // CaSiO3
        MT.OREMATS.Zeolite = MT.oredustelec(9165, "Zeolite", SET_DULL, 240, 230, 230, 255, MORTAR, BLACKLISTED_SMELTER)

            .addSourceOf(MT.Na, MT.Al)

            .setMcfg(0, MT.Al2O3, 5 * U, MT.Na, 2 * U, MT.SiO2, 12 * U, MT.H2O, 6 * U, MT.O, 1 * U);
        // Na2Al2Si4O12 2H2O
        MT.OREMATS.Pollucite = MT
            .oredustelec(9147, "Pollucite", SET_DULL, 240, 210, 210, 255, MORTAR, BLACKLISTED_SMELTER)

            .addSourceOf(MT.Cs, MT.Al)

            .setMcfg(0, MT.Al2O3, 5 * U, MT.Cs, 2 * U, MT.SiO2, 12 * U, MT.H2O, 6 * U, MT.O, 1 * U);
        // Cs2Al2Si4O12 2H2O (also a

        // source of Rb)
        MT.OREMATS.BrownLimonite = MT.oredustdcmp(

            9106,

            "Brown Limonite",

            SET_METALLIC,

            200,

            100,

            0,

            255,

            MORTAR,

            MELTING,

            MAGNETIC_PASSIVE)
            .setSmelting(MT.Fe2O3, U2)

            .addSourceOf(MT.Fe)

            .setMcfg(0, MT.Fe, 1 * U, MT.H, 1 * U, MT.O, 2 * U)

            .qual(0)

            .heat(1523);
        // FeO(OH)
        MT.OREMATS.YellowLimonite = MT.oredustdcmp(

            9137,

            "Yellow Limonite",

            SET_METALLIC,

            200,

            200,

            0,

            255,

            MORTAR,

            MELTING,

            MAGNETIC_PASSIVE,

            "BogIron")
            .setSmelting(MT.Fe2O3, U2)

            .addSourceOf(MT.Fe)

            .setMcfg(0, MT.Fe, 1 * U, MT.H, 1 * U, MT.O, 2 * U)

            .qual(0)

            .heat(1523);
        // FeO(OH) + a bit Ni and Co
        MT.OREMATS.Ferrovanadium = MT.oredustcent(

            9143,

            "Vanadium Magnetite",

            SET_METALLIC,

            35,

            35,

            60,

            255,

            MORTAR,

            MELTING,

            MOLTEN,

            MAGNETIC_PASSIVE,

            WASHING_FIRESTONE,

            "Ferrovanadium")
            .addSourceOf(MT.V, MT.Fe)

            .setMcfg(0, MT.OREMATS.Magnetite, 1 * U, MT.V2O5, 1 * U)

            .aspects(TC.METALLUM, 2, TC.MAGNETO, 1);
        // Mixture of Fe3O4 and V2O5. Technically Ferrovanadium is

        // an Alloy of Iron and Vanadium. I should not have blindly

        // copied PFAA and assumed it was an Ore.
        MT.OREMATS.Tantalite = MT.oredustelec(

            9148,

            "Tantalite",

            SET_METALLIC,

            145,

            80,

            40,

            255,

            MORTAR,

            BLACKLISTED_SMELTER,

            WASHING_FIRESTONE)
            .addSourceOf(MT.Ta, MT.Mn)

            .setMcfg(0, MT.Ta2O5, 7 * U, MT.MnO2, 1 * U);
        // (Fe, Mn)Ta2O6
        MT.OREMATS.Columbite = MT.oredustelec(

            9246,

            "Columbite",

            SET_METALLIC,

            65,

            77,

            14,

            255,

            MORTAR,

            BLACKLISTED_SMELTER,

            WASHING_FIRESTONE)
            .addSourceOf(MT.Nb, MT.Mn)

            .setMcfg(0, MT.Nb2O5, 7 * U, MT.MnO2, 1 * U);
        // (Fe, Mn)Nb2O6
        MT.OREMATS.Coltan = MT.oredustcent(

            9247,

            "Coltan",

            SET_METALLIC,

            105,

            83,

            66,

            255,

            MORTAR,

            BLACKLISTED_SMELTER,

            WASHING_FIRESTONE)
            .addSourceOf(MT.Ta, MT.Nb, MT.Mn)

            .setMcfg(0, MT.OREMATS.Tantalite, 1 * U, MT.OREMATS.Columbite, 1 * U);
        MT.OREMATS.Ilmenite = MT.oredustdcmp(

            9120,

            "Ilmenite",

            SET_METALLIC,

            70,

            55,

            50,

            255,

            MORTAR,

            MELTING,

            MOLTEN,

            MAGNETIC_PASSIVE,

            WASHING_FIRESTONE,

            "Illmenite",

            "TitaniumIron")
            .addSourceOf(MT.Ti, MT.Fe)

            .uumMcfg(0, MT.Fe, 1 * U, MT.Ti, 1 * U, MT.O, 3 * U)

            .qual(2);
        MT.OREMATS.Bauxite = MT
            .oredustdcmp(9105, "Bauxite", SET_DULL, 200, 100, 0, 255, MORTAR, BLACKLISTED_SMELTER, APPROXIMATE)

            .addSourceOf(MT.Al, MT.Ti)

            .setMcfg(0, MT.TiO2, 1 * U, MT.OREMATS.Ilmenite, 2 * U, MT.Al2O3, 2 * U)

            .qual(2)

            .heat(2800);
        MT.OREMATS.Chromite = MT.oredustelec(

            9113,

            "Chromite",

            SET_METALLIC,

            35,

            20,

            15,

            255,

            MORTAR,

            BLACKLISTED_SMELTER,

            WASHING_FIRESTONE)
            .setSmelting(MT.Cr, 2 * U9)

            .addSourceOf(MT.Cr, MT.Fe)

            .setMcfg(0, MT.Fe, 1 * U, MT.Cr, 2 * U, MT.O, 4 * U)

            .qual(0);
        MT.OREMATS.Powellite = MT
            .oredustcent(9124, "Powellite", SET_DULL, 255, 255, 0, 255, MORTAR, BLACKLISTED_SMELTER)

            .setSmelting(MT.Mo, U9)

            .addSourceOf(MT.Mo)

            .setMcfg(0, MT.Ca, 1 * U, MT.Mo, 1 * U, MT.O, 4 * U);
        MT.OREMATS.Wulfenite = MT
            .oredustcent(9136, "Wulfenite", SET_DULL, 255, 128, 0, 255, MORTAR, BLACKLISTED_SMELTER)

            .setSmelting(MT.Mo, U9)

            .addSourceOf(MT.Mo, MT.Pb)

            .setMcfg(0, MT.Pb, 1 * U, MT.Mo, 1 * U, MT.O, 4 * U);
        MT.OREMATS.Bastnasite = MT
            .oredustelec(9144, "Bastnasite", SET_FINE, 200, 110, 45, 255, MORTAR, BLACKLISTED_SMELTER)

            .setSmelting(MT.Ce, U9)

            .addSourceOf(MT.Ce, MT.F)

            .setMcfg(0, MT.Ce, 1 * U, MT.C, 1 * U, MT.F, 1 * U, MT.O, 3 * U);
        // (Ce, La, Y)CO3F
        MT.OREMATS.Pitchblende = MT
            .oredustcent(9155, "Pitchblende", SET_RAD, 100, 110, 0, 255, MORTAR, BLACKLISTED_SMELTER)

            .setSmelting(MT.U_238, U5)

            .addSourceOf(MT.U_238, MT.Th)

            .setMcfg(0, MT.OREMATS.Uraninite, 3 * U, MT.Th, 1 * U, MT.Pb, 1 * U);
        MT.OREMATS.Malachite = MT.oredustelec(

            9156,

            "Malachite",

            SET_LAPIS,

            5,

            95,

            5,

            255,

            MORTAR,

            G_GEM_ORES,

            FURNACE,

            WASHING_PERSULFATE)
            .setSmelting(MT.Cu, U6)

            .addSourceOf(MT.Cu)

            .setMcfg(0, MT.Cu, 2 * U, MT.CO3, 4 * U, MT.H, 2 * U, MT.O, 2 * U);
        // Cu2CO3(OH)2
        MT.OREMATS.Bromargyrite = MT.oredustelec(

            9210,

            "Bromargyrite",

            SET_DULL,

            90,

            45,

            10,

            255,

            MORTAR,

            BLACKLISTED_SMELTER,

            WASHING_MERCURY)
            .setSmelting(MT.Ag, U3)

            .addSourceOf(MT.Ag, MT.Br)

            .setMcfg(0, MT.Ag, 1 * U, MT.Br, 1 * U);
        MT.OREMATS.Smithsonite = MT.oredustelec(

            9211,

            "Smithsonite",

            SET_DULL,

            110,

            223,

            210,

            255,

            MORTAR,

            BLACKLISTED_SMELTER,

            WASHING_MERCURY,

            WASHING_PERSULFATE)
            .setSmelting(MT.Zn, U6)

            .addSourceOf(MT.Zn)

            .setMcfg(0, MT.Zn, 1 * U, MT.C, 1 * U, MT.O, 3 * U);
        MT.OREMATS.Sperrylite = MT.oredustelec(

            9212,

            "Sperrylite",

            SET_SHINY,

            105,

            105,

            105,

            255,

            MORTAR,

            BLACKLISTED_SMELTER,

            WASHING_MERCURY)
            .setSmelting(MT.Pt, U4)

            .addSourceOf(MT.Pt, MT.As)

            .setMcfg(0, MT.Pt, 1 * U, MT.As, 2 * U);
        MT.OREMATS.Perlite = MT.oredustdcmp(9138, "Perlite", SET_DULL, 30, 20, 30, 255, MORTAR, BLACKLISTED_SMELTER)

            .setMcfg(1, MT.Obsidian, 1 * U, MT.H2O, 1 * U);
        MT.OREMATS.Trona = MT.oredustelec(9159, "Trona", SET_METALLIC, 135, 135, 95, 255, MORTAR, BLACKLISTED_SMELTER)

            .setMcfg(6, MT.Na2CO3, 6 * U, MT.H2O, 6 * U);
        MT.OREMATS.Mirabilite = MT
            .oredustdcmp(9157, "Mirabilite", SET_DULL, 240, 250, 210, 255, MORTAR, BLACKLISTED_SMELTER)

            .setMcfg(7, MT.Na2SO4, 7 * U, MT.H2O, 30 * U);
        MT.OREMATS.Bischofite = MT
            .oredustdcmp(9221, "Bischofite", SET_ROUGH, 99, 104, 118, 255, MORTAR, BLACKLISTED_SMELTER)

            .setMcfg(3, MT.MgCl2, 3 * U, MT.H2O, 6 * U);
        MT.OREMATS.Borax = MT.oredustdcmp(9139, "Borax", SET_FINE, 250, 250, 250, 255, MORTAR, BLACKLISTED_SMELTER)

            .addSourceOf(MT.B, MT.Na)

            .setMcfg(0, MT.Na, 2 * U, MT.B, 4 * U, MT.H2O, 30 * U, MT.O, 7 * U);
        MT.OREMATS.Diatomite = MT
            .oredustcent(9001, "Diatomite", SET_DULL, 225, 225, 225, 255, MORTAR, BLACKLISTED_SMELTER)

            .setMcfg(0, MT.Flint, 8 * U, MT.Fe2O3, 1 * U, MT.Sapphire, 1 * U);
        MT.OREMATS.Spodumene = MT
            .oredustelec(9146, "Spodumene", SET_DULL, 190, 170, 170, 255, MORTAR, BLACKLISTED_SMELTER)

            .addSourceOf(MT.Al, MT.Li)

            .setMcfg(0, MT.Al2O3, 5 * U, MT.Li, 2 * U, MT.SiO2, 12 * U, MT.O, 1 * U);
        // LiAl(SiO3)2
        MT.OREMATS.Lepidolite = MT
            .oredustelec(9149, "Lepidolite", SET_FINE, 240, 50, 140, 255, MORTAR, BLACKLISTED_SMELTER)

            .addSourceOf(MT.Al, MT.K, MT.Li, MT.F)

            .setMcfg(0, MT.Al2O3, 10 * U, MT.K, 1 * U, MT.Li, 3 * U, MT.F, 2 * U, MT.O, 6 * U);
        // K(Li,Al,Rb)3(Al,Si)4O10(F,OH)2
        MT.OREMATS.Glauconite = MT.oredustelec(

            9150,

            "Glauconite",

            SET_DULL,

            130,

            180,

            60,

            255,

            MORTAR,

            BLACKLISTED_SMELTER,

            "GlauconiteSand")
            .addSourceOf(MT.Al, MT.K)

            .setMcfg(0, MT.Al2O3, 10 * U, MT.K, 1 * U, MT.Mg, 2 * U, MT.H2O, 3 * U, MT.O, 7 * U);
        MT.OREMATS.GlauconiteSand = MT.OREMATS.Glauconite;
        // (K,Na)(Fe3+,Al,Mg)2(Si,Al)4O10(OH)2

        // GlauconiteSand = oredustelec( 9151, "Glauconite Sand" , SET_DULL , 130, 180, 60, 255, MORTAR,

        // BLACKLISTED_SMELTER ) .addSourceOf(Al,K ).setMcfg( 0, Al2O3 ,10*U, K , 1*U, Mg , 2*U, H2O , 3*U, O , 7*U)

        // , // (K,Na)(Fe3+,Al,Mg)2(Si,Al)4O10(OH)2
        MT.OREMATS.Vermiculite = MT
            .oredustelec(9152, "Vermiculite", SET_METALLIC, 200, 180, 15, 255, MORTAR, BLACKLISTED_SMELTER)

            .addSourceOf(MT.Al)

            .setMcfg(0, MT.Al2O3, 10 * U, MT.Fe, 3 * U, MT.SiO2, 12 * U, MT.H2O, 12 * U, MT.H, 2 * U);
        // (Mg+2, Fe+2, Fe+3)3

        // [(AlSi)4O10] (OH)2 4H2O)
        MT.OREMATS.Mica = MT.oredustelec(9158, "Mica", SET_FINE, 195, 195, 205, 255, MORTAR, BLACKLISTED_SMELTER)

            .addSourceOf(MT.Al, MT.K, MT.F)

            .setMcfg(0, MT.Al2O3, 15 * U, MT.K, 2 * U, MT.SiO2, 18 * U, MT.F, 4 * U);
        // KAl2(AlSi3O10)(F,OH)2
        MT.OREMATS.Kyanite = MT.oredustelec(9166, "Kyanite", SET_FLINT, 110, 110, 250, 255, MORTAR, BLACKLISTED_SMELTER)

            .addSourceOf(MT.Al)

            .setMcfg(0, MT.Al2O3, 5 * U, MT.SiO2, 3 * U);
        // Al2SiO5
        MT.OREMATS.Alunite = MT
            .oredustelec(9162, "Alunite", SET_METALLIC, 225, 180, 65, 255, MORTAR, BLACKLISTED_SMELTER)

            .addSourceOf(MT.Al, MT.K)

            .setMcfg(0, MT.Al2O3, 15 * U, MT.KOH, 6 * U, MT.SO3, 16 * U, MT.H2O, 15 * U, MT.O, 9 * U);
        // KAl3(SO4)2(OH)6
        MT.OREMATS.GarnetSand = MT
            .oredustcent(9005, "Garnet Sand", SET_SAND, 200, 100, 0, 255, MORTAR, BLACKLISTED_SMELTER)

            .setMcfg(

                0,

                MT.Almandine,

                1 * U,

                MT.Andradite,

                1 * U,

                MT.Grossular,

                1 * U,

                MT.Pyrope,

                1 * U,

                MT.Spessartine,

                1 * U,

                MT.Uvarovite,

                1 * U);
        MT.OREMATS.QuartzSand = MT.oredustcent(

            9006,

            "Quartz Sand",

            SET_SAND,

            200,

            200,

            200,

            255,

            MORTAR,

            BLACKLISTED_SMELTER,

            QUARTZ)
            .setSmelting(MT.SiO2, U3)

            .setMcfg(0, MT.CertusQuartz, 1 * U, MT.MilkyQuartz, 1 * U);
        MT.OREMATS.DiduraniumTrioxide = MT.oredustelec(

            9198,

            "Diduranium Trioxide",

            SET_DULL,

            45,

            145,

            145,

            255,

            BLACKLISTED_SMELTER)
            .addSourceOf(MT.Dn)

            .setMcfg(0, MT.Dn, 2 * U, MT.O, 3 * U)

            .qual(4);
        MT.OREMATS.DuraniumHexafluoride = MT.oredustelec(

            9199,

            "Duranium Hexafluoride",

            SET_DULL,

            25,

            175,

            125,

            255,

            BLACKLISTED_SMELTER)
            .addSourceOf(MT.Dn, MT.F)

            .setMcfg(0, MT.Dn, 1 * U, MT.F, 6 * U)

            .qual(4);
        MT.OREMATS.DuraniumHexachloride = MT.oredustelec(

            9200,

            "Duranium Hexachloride",

            SET_DULL,

            75,

            175,

            145,

            255,

            BLACKLISTED_SMELTER)
            .addSourceOf(MT.Dn)

            .setMcfg(0, MT.Dn, 1 * U, MT.Cl, 6 * U)

            .qual(4);
        MT.OREMATS.DuraniumHexabromide = MT.oredustelec(

            9201,

            "Duranium Hexabromide",

            SET_DULL,

            45,

            125,

            175,

            255,

            BLACKLISTED_SMELTER)
            .addSourceOf(MT.Dn, MT.Br)

            .setMcfg(0, MT.Dn, 1 * U, MT.Br, 6 * U)

            .qual(4);
        MT.OREMATS.DuraniumHexaiodide = MT.oredustelec(

            9202,

            "Duranium Hexaiodide",

            SET_DULL,

            75,

            125,

            175,

            255,

            BLACKLISTED_SMELTER)
            .addSourceOf(MT.Dn, MT.I)

            .setMcfg(0, MT.Dn, 1 * U, MT.I, 6 * U)

            .qual(4);
        MT.OREMATS.DuraniumHexaastatide = MT.oredustelec(

            9203,

            "Duranium Hexaastatide",

            SET_DULL,

            25,

            145,

            175,

            255,

            BLACKLISTED_SMELTER)
            .addSourceOf(MT.Dn, MT.At)

            .setMcfg(0, MT.Dn, 1 * U, MT.At, 6 * U)

            .qual(4);
        MT.OREMATS.TritaniumDioxide = MT
            .oredustelec(9204, "Tritanium Dioxide", SET_DULL, 25, 185, 125, 255, BLACKLISTED_SMELTER)

            .addSourceOf(MT.Tn)

            .setMcfg(0, MT.Tn, 1 * U, MT.O, 2 * U)

            .qual(4);
        MT.OREMATS.TritaniumHexafluoride = MT.oredustelec(

            9205,

            "Tritanium Hexafluoride",

            SET_DULL,

            85,

            125,

            125,

            255,

            BLACKLISTED_SMELTER)
            .addSourceOf(MT.Tn, MT.F)

            .setMcfg(0, MT.Tn, 1 * U, MT.F, 6 * U)

            .qual(4);
        MT.OREMATS.TritaniumHexachloride = MT.oredustelec(

            9206,

            "Tritanium Hexachloride",

            SET_DULL,

            55,

            185,

            155,

            255,

            BLACKLISTED_SMELTER)
            .addSourceOf(MT.Tn)

            .setMcfg(0, MT.Tn, 1 * U, MT.Cl, 6 * U)

            .qual(4);
        MT.OREMATS.TritaniumHexabromide = MT.oredustelec(

            9207,

            "Tritanium Hexabromide",

            SET_DULL,

            55,

            125,

            155,

            255,

            BLACKLISTED_SMELTER)
            .addSourceOf(MT.Tn, MT.Br)

            .setMcfg(0, MT.Tn, 1 * U, MT.Br, 6 * U)

            .qual(4);
        MT.OREMATS.TritaniumHexaiodide = MT.oredustelec(

            9208,

            "Tritanium Hexaiodide",

            SET_DULL,

            85,

            185,

            185,

            255,

            BLACKLISTED_SMELTER)
            .addSourceOf(MT.Tn, MT.I)

            .setMcfg(0, MT.Tn, 1 * U, MT.I, 6 * U)

            .qual(4);
        MT.OREMATS.TritaniumHexaastatide = MT.oredustelec(

            9209,

            "Tritanium Hexaastatide",

            SET_DULL,

            25,

            125,

            185,

            255,

            BLACKLISTED_SMELTER)
            .addSourceOf(MT.Tn, MT.At)

            .setMcfg(0, MT.Tn, 1 * U, MT.At, 6 * U)

            .qual(4);;
    }
}
