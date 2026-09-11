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
 * The precious and semi precious Gems.
 * <p>
 * Loaded as the "Gems" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsGems implements IMaterialCategory {

    @Override
    public String getName() {
        return "Gems";
    }

    @Override
    public void load() {
        MT.Diamond = MT.diamond(8300, "Diamond", 200, 255, 255, DYE_INDEX_White)
            .uumMcfg(1, MT.C, 4 * U)
            .setDensity(3.53)
            .heat(4200, MT.C.mBoilingPoint);
        MT.DiamondBlue = MT.diamond(8464, "Blue Diamond", 30, 60, 240, DYE_INDEX_Blue)
            .uumMcfg(1, MT.C, 4 * U)
            .setDensity(3.53)
            .heat(4200, MT.C.mBoilingPoint);
        MT.DiamondGreen = MT.diamond(8465, "Green Diamond", 0, 240, 0, DYE_INDEX_Green)
            .uumMcfg(1, MT.C, 4 * U)
            .setDensity(3.53)
            .heat(4200, MT.C.mBoilingPoint);
        MT.DiamondPurple = MT.diamond(8466, "Purple Diamond", 120, 0, 240, DYE_INDEX_Purple)
            .uumMcfg(1, MT.C, 4 * U)
            .setDensity(3.53)
            .heat(4200, MT.C.mBoilingPoint);
        MT.DiamondRed = MT.diamond(8467, "Red Diamond", 240, 0, 0, DYE_INDEX_Red)
            .uumMcfg(1, MT.C, 4 * U)
            .setDensity(3.53)
            .heat(4200, MT.C.mBoilingPoint);
        MT.DiamondYellow = MT.diamond(8468, "Yellow Diamond", 240, 240, 0, DYE_INDEX_Yellow)
            .uumMcfg(1, MT.C, 4 * U)
            .setDensity(3.53)
            .heat(4200, MT.C.mBoilingPoint);
        MT.DiamondPink = MT.diamond(8424, "Pink Diamond", 240, 160, 160, DYE_INDEX_Pink)
            .uumMcfg(1, MT.C, 4 * U)
            .aspects(TC.AURAM, 4)
            .setDensity(3.53)
            .heat(4200, MT.C.mBoilingPoint)
            .qual(3, 12.0, 1600, 3);
        MT.DiamondIndustrial = MT.diamond(8423, "DiamondIndustrial", 255, 255, 210, DYE_INDEX_Yellow)
            .uumMcfg(1, MT.C, 4 * U)
            .aspects(TC.FABRICO, 2)
            .setDensity(3.53)
            .heat(4200, MT.C.mBoilingPoint)
            .qual(3, 9.0, 1440, 3)
            .setLocal("Industrial Diamond");
        MT.ManaDiamond = MT.diamond(8278, "Mana Diamond", 128, 255, 255, DYE_INDEX_Cyan, MAGICAL, UNBURNABLE)
            .setMcfg(1, MT.C, 4 * U, MT.Ma, 1 * U)
            .aspects(TC.PRAECANTIO, 2)
            .setDensity(3.53)
            .heat(4200, MT.C.mBoilingPoint)
            .qual(3, 10.0, 1280, 3);
        MT.ElvenDragonstone = MT
            .diamond(8279, "Elven Dragonstone", 240, 140, 240, DYE_INDEX_Magenta, MAGICAL, UNBURNABLE)
            .setMcfg(1, MT.C, 4 * U, MT.Ma, 2 * U)
            .aspects(TC.PRAECANTIO, 4)
            .setDensity(3.53)
            .heat(4200, MT.C.mBoilingPoint)
            .qual(3, 12.0, 1280, 3)
            .setLocal("Dragonstone");
        MT.Gravitite = MT.diamond(8294, "Gravitite", 182, 91, 159, DYE_INDEX_Magenta, MAGICAL, CRYSTALLISABLE)
            .setMcfg(1, MT.C, 4 * U, MT.Gt, 1 * U, MT.Ma, 1 * U)
            .aspects(TC.VOLATUS, 4)
            .setDensity(3.53)
            .heat(4200, MT.C.mBoilingPoint)
            .qual(3, 9.0, 1280, 3);
        MT.Emerald = MT.emerald(8301, "Emerald", 80, 255, 80, DYE_INDEX_Green)
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.Be, 3 * U, MT.SiO2, 18 * U, MT.O, 3 * U)
            .aspects(TC.LUCRUM, 2);
        MT.Aquamarine = MT.emerald(8323, "Aquamarine", 200, 220, 255, DYE_INDEX_Cyan)
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.Be, 3 * U, MT.SiO2, 18 * U, MT.O, 3 * U)
            .aspects(TC.AQUA, 2);
        MT.Morganite = MT.emerald(8324, "Morganite", 255, 200, 200, DYE_INDEX_Pink)
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.Be, 3 * U, MT.SiO2, 18 * U, MT.O, 3 * U)
            .aspects(TC.TEMPESTAS, 2);
        MT.Heliodor = MT.emerald(8384, "Heliodor", 255, 255, 150, DYE_INDEX_Yellow)
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.Be, 3 * U, MT.SiO2, 18 * U, MT.O, 3 * U)
            .aspects(TC.LUX, 2);
        MT.Goshenite = MT.emerald(8385, "Goshenite", 240, 240, 240, DYE_INDEX_White)
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.Be, 3 * U, MT.SiO2, 18 * U, MT.O, 3 * U)
            .aspects(TC.VACUOS, 2);
        MT.Bixbite = MT.emerald(8386, "Bixbite", 255, 80, 80, DYE_INDEX_Red, "ScarletEmerald")
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.Be, 3 * U, MT.SiO2, 18 * U, MT.O, 3 * U)
            .aspects(TC.SANO, 2);
        MT.Maxixe = MT.emerald(8387, "Maxixe", 80, 80, 255, DYE_INDEX_Blue)
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.Be, 3 * U, MT.SiO2, 18 * U, MT.O, 3 * U)
            .aspects(TC.RADIO, 2);
        MT.Sapphire = MT.sapphire(8304, "Sapphire", 120, 120, 160, DYE_INDEX_Blue, "Saphire")
            .uumMcfg(6, MT.Al2O3, 5 * U)
            .aspects(TC.LUCRUM, 1);
        MT.Ruby = MT.sapphire(8302, "Ruby", 255, 100, 100, DYE_INDEX_Red)
            .uumMcfg(6, MT.Al2O3, 5 * U, MT.Cr, 1 * U)
            .aspects(TC.MACHINA, 1);
        MT.BlueSapphire = MT.sapphire(8328, "Blue Sapphire", 100, 100, 200, DYE_INDEX_Blue)
            .uumMcfg(6, MT.Al2O3, 5 * U, MT.Fe, 1 * U)
            .aspects(TC.METALLUM, 1);
        MT.GreenSapphire = MT.sapphire(8305, "Green Sapphire", 100, 200, 130, DYE_INDEX_Green)
            .uumMcfg(6, MT.Al2O3, 5 * U, MT.Mg, 1 * U)
            .aspects(TC.SANO, 1);
        MT.PurpleSapphire = MT.sapphire(8383, "Purple Sapphire", 220, 50, 255, DYE_INDEX_Purple)
            .uumMcfg(6, MT.Al2O3, 5 * U, MT.V, 1 * U)
            .aspects(TC.ELECTRUM, 1);
        MT.YellowSapphire = MT.sapphire(8315, "Yellow Sapphire", 220, 220, 50, DYE_INDEX_Yellow)
            .uumMcfg(6, MT.Al2O3, 5 * U, MT.TiO2, 1 * U)
            .aspects(TC.TUTAMEN, 1);
        MT.OrangeSapphire = MT.sapphire(8314, "Orange Sapphire", 220, 150, 50, DYE_INDEX_Orange)
            .uumMcfg(6, MT.Al2O3, 5 * U, MT.Cu, 1 * U)
            .aspects(TC.PERMUTATIO, 1);
        MT.Spinel = MT.valgemelec(8326, "Spinel", SET_GEM_VERTICAL, 0, 100, 0, 127, RANDOM_SMALL_GEM_ORE)
            .lens(DYE_INDEX_Green)
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.Mg, 1 * U, MT.O, 1 * U)
            .aspects(TC.VITREUS, 2, TC.LUCRUM, 3)
            .qual(3, 7.0, 384, 2);
        MT.BalasRuby = MT
            .valgemelec(8303, "Balas Ruby", SET_GEM_VERTICAL, 255, 100, 100, 127, RANDOM_SMALL_GEM_ORE, "FoolsRuby")
            .setLocal("Ruby")
            .steal(MT.Ruby)
            .lens(DYE_INDEX_Red)
            .uumMcfg(0, MT.Cr, 2 * U, MT.Mg, 1 * U, MT.O, 4 * U)
            .aspects(TC.VITREUS, 2, TC.LUCRUM, 2, TC.STRONTIO, 2)
            .qual(3, 7.0, 384, 2);
        MT.Almandine = MT.garnet(9101, "Almandine", 255, 0, 0, DYE_INDEX_Red, "GarnetRed")
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.Fe, 3 * U, MT.SiO2, 9 * U, MT.O, 3 * U)
            .aspects(TC.METALLUM, 1);
        MT.Grossular = MT.garnet(9119, "Grossular", 200, 100, 0, DYE_INDEX_Orange, "GarnetOrange")
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.Ca, 3 * U, MT.SiO2, 9 * U, MT.O, 3 * U)
            .aspects(TC.VOLATUS, 1);
        MT.Pyrope = MT.garnet(9127, "Pyrope", 120, 50, 100, DYE_INDEX_Purple, "GarnetPurple")
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.Mg, 3 * U, MT.SiO2, 9 * U, MT.O, 3 * U)
            .aspects(TC.SANO, 1);
        MT.Spessartine = MT.garnet(9129, "Spessartine", 255, 100, 100, DYE_INDEX_Red, "Garnet")
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.Mn, 3 * U, MT.SiO2, 9 * U, MT.O, 3 * U)
            .aspects(TC.METALLUM, 1);
        MT.Andradite = MT.garnet(9102, "Andradite", 150, 120, 0, DYE_INDEX_Yellow, "GarnetYellow")
            .uumMcfg(0, MT.Ca, 3 * U, MT.Fe, 2 * U, MT.SiO2, 9 * U, MT.O, 6 * U)
            .aspects(TC.TUTAMEN, 1);
        MT.Uvarovite = MT.garnet(9135, "Uvarovite", 180, 255, 180, DYE_INDEX_Lime, "GarnetGreen")
            .uumMcfg(0, MT.Ca, 3 * U, MT.Cr, 2 * U, MT.SiO2, 9 * U, MT.O, 6 * U)
            .aspects(TC.MACHINA, 1);
        MT.Jasper = MT.jasper(8309, "Red Jasper", 200, 80, 80, DYE_INDEX_Red, "Jasper");
        MT.JasperOcean = MT.jasper(8425, "Ocean Jasper", 139, 115, 86, DYE_INDEX_Orange);
        MT.JasperRainforest = MT.jasper(8426, "Rainforest Jasper", 129, 123, 55, DYE_INDEX_Yellow);
        MT.JasperBlue = MT.jasper(8427, "Blue Jasper", 60, 124, 151, DYE_INDEX_Blue);
        MT.JasperGreen = MT.jasper(8428, "Green Jasper", 91, 131, 108, DYE_INDEX_Green);
        MT.JasperYellow = MT.jasper(8429, "Yellow Jasper", 156, 128, 39, DYE_INDEX_Yellow);
        MT.TigerEyeYellow = MT.tigereye(8430, "Tiger Eye", 142, 116, 61, DYE_INDEX_Yellow, "YellowTigerEye");
        MT.TigerEyeGreen = MT.tigereye(8431, "Cat's Eye", 77, 116, 81, DYE_INDEX_Green, "GreenTigerEye");
        MT.TigerEyeRed = MT.tigereye(8432, "Dragon Eye", 164, 95, 83, DYE_INDEX_Red, "RedTigerEye");
        MT.TigerEyeBlue = MT.tigereye(8433, "Hawk's Eye", 76, 94, 109, DYE_INDEX_Blue, "BlueTigerEye");
        MT.TigerEyeBlack = MT.tigereye(8434, "Black Eye", 66, 68, 66, DYE_INDEX_Black, "BlackTigerEye");
        MT.TigerIron = MT.tigereye(8435, "Tiger Iron", 106, 86, 66, DYE_INDEX_Yellow);
        MT.AventurineGreen = MT.aventurine(8448, "Green Aventurine", 66, 189, 133, DYE_INDEX_Green, "Aventurine");
        MT.AventurineBrown = MT.aventurine(8446, "Brown Aventurine", 185, 110, 35, DYE_INDEX_Brown);
        MT.AventurineYellow = MT.aventurine(8447, "Yellow Aventurine", 200, 179, 121, DYE_INDEX_Yellow);
        MT.AventurineBlack = MT.aventurine(8449, "Black Aventurine", 50, 50, 50, DYE_INDEX_Black);
        MT.AventurineBlue = MT.aventurine(8450, "Blue Aventurine", 67, 103, 138, DYE_INDEX_Blue);
        MT.AventurineRed = MT.aventurine(8451, "Red Aventurine", 116, 46, 33, DYE_INDEX_Red);
        MT.Topaz = MT.valgemelec(8306, "Topaz", SET_GEM_HORIZONTAL, 255, 128, 0, 127, RANDOM_SMALL_GEM_ORE)
            .lens(DYE_INDEX_Orange)
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.SiO2, 3 * U, MT.F, 2 * U, MT.H2O, 3 * U)
            .aspects(TC.VITREUS, 4, TC.LUCRUM, 4, TC.POTENTIA, 2)
            .qual(3, 7.0, 256, 3);
        MT.BlueTopaz = MT.valgemelec(8307, "Blue Topaz", SET_GEM_HORIZONTAL, 123, 150, 220, 127, RANDOM_SMALL_GEM_ORE)
            .lens(DYE_INDEX_Blue)
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.SiO2, 3 * U, MT.F, 2 * U, MT.H2O, 3 * U)
            .aspects(TC.VITREUS, 4, TC.LUCRUM, 4, TC.POTENTIA, 2)
            .qual(3, 7.0, 256, 3)
            .setGenerifying(MT.Topaz);
        MT.Tanzanite = MT.valgemelec(8308, "Tanzanite", SET_GEM_HORIZONTAL, 64, 0, 200, 127, RANDOM_SMALL_GEM_ORE)
            .lens(DYE_INDEX_Purple)
            .uumMcfg(0, MT.Al2O3, 15 * U, MT.SiO2, 18 * U, MT.Ca, 4 * U, MT.H2O, 3 * U, MT.O, 4 * U)
            .aspects(TC.VITREUS, 3, TC.LUCRUM, 5)
            .qual(3, 7.0, 256, 2);
        MT.Zanite = MT.valgemelec(8292, "Zanite", SET_REDSTONE, 146, 73, 255, 127, CRYSTALLISABLE)
            .lens(DYE_INDEX_Purple)
            .uumMcfg(0, MT.Al2O3, 15 * U, MT.SiO2, 18 * U, MT.Ca, 4 * U, MT.H2O, 3 * U, MT.O, 4 * U)
            .aspects(TC.VITREUS, 3, TC.PERFODIO, 4)
            .qual(3, 16.0, 512, 2)
            .setGenerifying(MT.Tanzanite);
        MT.Amazonite = MT.valgemelec(8417, "Amazonite", SET_LAPIS, 71, 241, 170, 255, RANDOM_SMALL_GEM_ORE, MD.VOLTZ)
            .lens(DYE_INDEX_Green)
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.SiO2, 18 * U, MT.K, 2 * U, MT.O, 1 * U)
            .aspects(TC.VITREUS, 3, TC.LUCRUM, 5)
            .qual(3, 7.0, 256, 2);
        MT.Alexandrite = MT.valgemelec(8388, "Alexandrite", SET_OPAL, 200, 255, 170, 127 /* no small ores for this */ )
            .lens(DYE_INDEX_Lime)
            .uumMcfg(0, MT.Al2O3, 1 * U, MT.Be, 1 * U, MT.O, 1 * U)
            .aspects(TC.VITREUS, 4, TC.LUCRUM, 2, TC.AURAM, 1)
            .qual(3, 7.0, 512, 3);
        MT.Opal = MT.valgemelec(8312, "Opal", SET_OPAL, 0, 0, 255, 127, RANDOM_SMALL_GEM_ORE)
            .lens(DYE_INDEX_Blue)
            .uumMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.VITREUS, 4, TC.LUCRUM, 2, TC.AURAM, 1)
            .qual(3, 7.0, 256, 2);
        MT.OnyxRed = MT.valgemelec(8415, "OnyxRed", SET_LAPIS, 255, 88, 77, 255, RANDOM_SMALL_GEM_ORE, MD.VOLTZ)
            .lens(DYE_INDEX_Red)
            .uumMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.VITREUS, 4, TC.LUCRUM, 2)
            .qual(3, 7.0, 256, 2)
            .setLocal("Red Onyx");
        MT.OnyxBlack = MT
            .valgemelec(8416, "OnyxBlack", SET_LAPIS, 50, 50, 50, 255, RANDOM_SMALL_GEM_ORE, MD.VOLTZ, "Onyx")
            .lens(DYE_INDEX_Black)
            .uumMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.VITREUS, 4, TC.LUCRUM, 2)
            .qual(3, 7.0, 256, 2)
            .setLocal("Black Onyx");
        MT.Sugilite = MT.valgemelec(8463, "Sugilite", SET_LAPIS, 153, 100, 196, 255)
            .lens(DYE_INDEX_Purple)
            .uumMcfg(0, MT.K, 1 * U, MT.Na, 2 * U, MT.MnO2, 2 * U, MT.Li, 3 * U, MT.SiO2, 36 * U, MT.O, 2 * U)
            .aspects(TC.VITREUS, 2, TC.LUCRUM, 2, TC.ALIENIS, 2)
            .qual(3, 9.0, 512, 3);
        // KNa2(Fe,Mn,Al)2Li3Si12O30
        MT.Peridot = MT.valgemelec(8311, "Peridot", SET_RUBY, 150, 255, 150, 127, RANDOM_SMALL_GEM_ORE, "Olivine")
            .lens(DYE_INDEX_Lime)
            .uumMcfg(0, MT.SiO2, 2 * U, MT.Fe, 1 * U, MT.Mg, 2 * U)
            .aspects(TC.VITREUS, 2, TC.LUCRUM, 4)
            .qual(3, 7.0, 256, 2);
        MT.Amethyst = MT.valgemelec(8313, "Amethyst", SET_RUBY, 166, 120, 241, 127, RANDOM_SMALL_GEM_ORE)
            .lens(DYE_INDEX_Pink)
            .uumMcfg(0, MT.SiO2, 4 * U, MT.Fe, 1 * U)
            .aspects(TC.VITREUS, 4, TC.LUCRUM, 6)
            .qual(3, 6.0, 128, 3);
        MT.Dioptase = MT.valgemelec(8325, "Dioptase", SET_EMERALD, 0, 180, 180, 127, RANDOM_SMALL_GEM_ORE)
            .lens(DYE_INDEX_Cyan)
            .uumMcfg(0, MT.SiO2, 3 * U, MT.Cu, 1 * U, MT.O, 1 * U, MT.H2O, 3 * U)
            .aspects(TC.VITREUS, 3, TC.LUCRUM, 3, TC.PERMUTATIO, 2)
            .qual(3, 7.0, 256, 2);
        MT.Carminite = MT.valgem(8470, "Carminite", SET_FINE, 150, 0, 0, 255, MORTAR, CRYSTALLISABLE)
            .aspects(TC.VITREUS, 1, TC.PERMUTATIO, 2)
            .qual(3, 7.0, 384, 3);
        MT.Amber = MT.valgem(8310, "Amber", SET_RUBY, 255, 180, 0, 127, MORTAR, CRYSTALLISABLE)
            .lens(DYE_INDEX_Orange)
            .aspects(TC.VITREUS, 1, TC.VINCULUM, 2)
            .qual(3, 4.0, 256, 3)
            .heat(473);
        MT.AmberGolden = MT.valgem(8469, "Golden Amber", SET_RUBY, 255, 230, 80, 127, MORTAR, CRYSTALLISABLE)
            .lens(DYE_INDEX_Yellow)
            .aspects(TC.VITREUS, 1, TC.VINCULUM, 2, TC.VOLATUS, 2)
            .qual(3, 5.0, 384, 3)
            .heat(473)
            .setGenerifying(MT.Amber);
        MT.AmberDominican = MT.valgem(8422, "Dominican Amber", SET_RUBY, 80, 80, 240, 127, MORTAR, CRYSTALLISABLE)
            .lens(DYE_INDEX_Blue)
            .aspects(TC.VITREUS, 1, TC.VINCULUM, 2, TC.SENSUS, 2)
            .qual(3, 5.0, 384, 3)
            .heat(473)
            .setGenerifying(MT.Amber)
            .setLocal("Blue Amber");
        MT.Craponite = MT.valgem(8322, "Craponite", SET_FLINT, 255, 170, 185, 127, MORTAR, CRYSTALLISABLE)
            .lens(DYE_INDEX_Magenta)
            .aspects(TC.VITREUS, 3, TC.LUCRUM, 3, TC.STRONTIO, 2)
            .qual(3, 7.0, 256, 2);
        MT.Jade = MT.valgem(8321, "Jade", SET_LAPIS, 100, 255, 125, 255, RANDOM_SMALL_GEM_ORE, MORTAR, CRYSTALLISABLE)
            .lens(DYE_INDEX_Green)
            .aspects(TC.VITREUS, 3, TC.LUCRUM, 6)
            .qual(3, 8.0, 512, 2);
        /*
         * Sunstone = valgem (00000, "Sunstone" , SET_RUBY , 194, 136, 108, 127),
         * Moonstone = valgem (00000, "Moonstone" , SET_RUBY , 166, 174, 171, 127),
         * Bloodstone = valgem (00000, "Bloodstone" , SET_RUBY , 71, 98, 70, 127),
         * Wonderstone = valgem (00000, "Wonderstone" , SET_RUBY , 166, 136, 115, 127),
         * Jet = valgem (00000, "Jet" , SET_RUBY , 39, 39, 39, 127),
         * LapisLazuli = valgem (00000, "Lapis Lazuli" , SET_RUBY , 44, 52, 101, 127),
         * SnowflakeObsidian = valgem (00000, "Snowflake Obsidian" , SET_RUBY , 70, 66, 63, 127),
         * BlackBeryl = valgem (00000, "Black Beryl" , SET_RUBY , 57, 57, 57, 127),
         * Rhodonite = valgem (00000, "Rhodonite" , SET_RUBY , 178, 121, 135, 127),
         * Labradorite = valgem (00000, "Labradorite" , SET_RUBY , 27, 133, 152, 127),
         * Dumortierite = valgem (00000, "Dumortierite" , SET_RUBY , 54, 57, 100, 127),
         * Moissanite = valgem (00000, "Moissanite" , SET_RUBY , 164, 165, 165, 127),
         * Mookaite = valgem (00000, "Mookaite" , SET_RUBY , 143, 80, 29, 127),
         * Larimar = valgem (00000, "Larimar" , SET_RUBY , 129, 196, 196, 127),
         * Charoite = valgem (00000, "Charoite" , SET_RUBY , 125, 95, 161, 127),
         * Carnelian = valgem (00000, "Carnelian" , SET_RUBY , 136, 40, 14, 127),
         * Unakite = valgem (00000, "Unakite" , SET_RUBY , 153, 140, 97, 127),
         * Selenite = valgem (00000, "Selenite" , SET_RUBY , 168, 168, 168, 127),
         * Pietersite = valgem (00000, "Pietersite" , SET_RUBY , 127, 97, 117, 127),
         * Chrysocolla = valgem (00000, "Chrysocolla" , SET_RUBY , 95, 179, 180, 127),
         * Coral = valgem (00000, "Coral" , SET_RUBY , 152, 40, 38, 127),
         * Basanite = valgem (00000, "Basanite" , SET_RUBY , 50, 48, 40, 127),
         * Kunzite = valgem (00000, "Kunzite" , SET_RUBY , 189, 166, 192, 127),
         * Angelite = valgem (00000, "Angelite" , SET_RUBY , 96, 119, 139, 127),
         * Scapolite = valgem (00000, "Scapolite" , SET_RUBY , 167, 168, 130, 127),
         * Chrysoprase = valgem (00000, "Chrysoprase" , SET_RUBY , 68, 93, 49, 127),
         * Ametrine = valgem (00000, "Ametrine" , SET_RUBY , 182, 141, 149, 127),
         */
        MT.Vinteum = MT
            .dcmp(
                8316,
                "Vinteum",
                SET_EMERALD,
                80,
                80,
                255,
                255,
                G_GEM_ORES,
                MAGICAL,
                CRYSTAL,
                MORTAR,
                BRITTLE,
                UNBURNABLE)
            .setMcfg(0, MT.Ma, 1 * U)
            .aspects(TC.VITREUS, 1, TC.PRAECANTIO, 2)
            .qual(3, 10.0, 128, 3);
        MT.VinteumPurified = MT
            .dcmp(
                8327,
                "VinteumPurified",
                SET_EMERALD,
                230,
                100,
                255,
                255,
                G_GEM_ORES,
                MAGICAL,
                CRYSTAL,
                MORTAR,
                BRITTLE,
                UNBURNABLE)
            .setMcfg(0, MT.Ma, 1 * U)
            .aspects(TC.ORDO, 2, TC.PRAECANTIO, 6)
            .qual(3, 12.0, 256, 3)
            .setLocal("Purified Vinteum");
    }
}
