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
 * Water, Air, the Acids, the chemical Compounds and everything else that is processed in a Chemical Reactor.
 * <p>
 * Loaded as the "Chemicals" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsChemicals implements IMaterialCategory {

    @Override
    public String getName() {
        return "Chemicals";
    }

    @Override
    public void load() {
        MT.H2O = MT.lquddcmp(9800, "Water", 100, 100, 255, 255, UNRECYCLABLE, FOOD, MELTING)
            .uumMcfg(0, MT.H, 2 * U, MT.O, 1 * U)
            .aspects(TC.AQUA, 2)
            .heat(CS.C, CS.C + 100)
            .setDensity(1.0000)
            .liquid(FL.Water.make(1000));
        MT.Water = MT.H2O;
        MT.HDO = MT.lquddcmp(9811, "Semiheavy Water", 200, 200, 155, 255, UNRECYCLABLE, FOOD, MELTING, LIQUID)
            .setMcfg(0, MT.H, 1 * U, MT.D, 1 * U, MT.O, 1 * U)
            .aspects(TC.AQUA, 2, TC.TEMPESTAS, 1)
            .heat(CS.C + 2, CS.C + 101)
            .setDensity(1.0540);
        MT.D2O = MT.lquddcmp(9812, "Heavy Water", 255, 255, 100, 255, UNRECYCLABLE, FOOD, MELTING, LIQUID)
            .setMcfg(0, MT.D, 2 * U, MT.O, 1 * U)
            .aspects(TC.AQUA, 2, TC.TEMPESTAS, 2)
            .heat(CS.C + 4, CS.C + 102)
            .setDensity(1.1056);
        MT.T2O = MT.lquddcmp(9813, "Tritiated Water", 255, 100, 100, 255, UNRECYCLABLE, FOOD, MELTING, LIQUID)
            .setMcfg(0, MT.T, 2 * U, MT.O, 1 * U)
            .aspects(TC.AQUA, 2, TC.RADIO, 1)
            .heat(CS.C + 7, CS.C + 104)
            .setDensity(1.2112);
        MT.Steam = MT.gasdcmp(9814, "Steam", 200, 200, 200, 255, UNRECYCLABLE)
            .uumMcfg(0, MT.H, 2 * U, MT.O, 1 * U)
            .aspects(TC.AQUA, 2, TC.AER, 1)
            .heat(CS.C, CS.C + 100)
            .setDensity(0.0010);
        MT.Snow = MT.dust(9801, "Snow", SET_FINE, 250, 250, 250, 255, UNRECYCLABLE, FOOD, MORTAR)
            .uumMcfg(0, MT.H, 2 * U, MT.O, 1 * U)
            .aspects(TC.GELUM, 1)
            .setSmelting(MT.H2O, U)
            .heat(CS.C, CS.C + 100)
            .setDensity(1.0);
        MT.Ice = MT
            .create(
                9802,
                "Ice",
                SET_CUBE_SHINY,
                200,
                200,
                255,
                255,
                G_GEM_TRANSPARENT,
                CONTAINERS,
                UNRECYCLABLE,
                FOOD,
                BRITTLE,
                MORTAR,
                COOL2CRYSTAL)
            .uumMcfg(0, MT.H, 2 * U, MT.O, 1 * U)
            .aspects(TC.GELUM, 2)
            .setSmelting(MT.H2O, U)
            .heat(CS.C, CS.C + 100)
            .setDensity(1.0)
            .qual(1, 2.0, 4, 0);
        MT.FreshWater = MT.lqud(9803, "Fresh Water", 110, 110, 255, 255, UNRECYCLABLE, FOOD)
            .uumMcfg(0, MT.H, 2 * U, MT.O, 1 * U)
            .aspects(TC.AQUA, 2)
            .heat(CS.C, CS.C + 100)
            .setDensity(1.0);
        MT.HolyWater = MT.lqud(9805, "Holy Water", 120, 120, 255, 255, GLOWING)
            .setMcfg(0, MT.H, 2 * U, MT.O, 1 * U)
            .aspects(TC.AQUA, 2, TC.AURAM, 1)
            .heat(CS.C, CS.C + 100)
            .setDensity(1.0);
        MT.SeaWater = MT.lqud(9806, "Sea Water", 90, 90, 255, 255, UNRECYCLABLE, LIQUID)
            .setMcfg(0, MT.H, 2 * U, MT.O, 1 * U)
            .aspects(TC.TEMPESTAS, 2)
            .heat(CS.C, CS.C + 100)
            .setDensity(1.0);
        MT.DirtyWater = MT.lqud(9807, "WaterDirty", 70, 150, 200, 255, UNRECYCLABLE, LIQUID)
            .setMcfg(0, MT.H, 2 * U, MT.O, 1 * U)
            .aspects(TC.AQUA, 2)
            .heat(CS.C, CS.C + 100)
            .setDensity(1.0)
            .setLocal("Dirty Water");
        MT.DistWater = MT.lquddcmp(9808, "WaterDistilled", 110, 110, 255, 255, UNRECYCLABLE, FOOD, MELTING)
            .uumMcfg(0, MT.H, 2 * U, MT.O, 1 * U)
            .aspects(TC.AQUA, 2)
            .heat(CS.C, CS.C + 100)
            .setDensity(1.0)
            .setLocal("Distilled Water");
        MT.H2O2 = MT.lquddcmp(9809, "Hydrogen Peroxide GT6", 20, 20, 255, 255, LIQUID)
            .uumMcfg(0, MT.H, 2 * U, MT.O, 2 * U)
            .aspects(TC.AQUA, 3)
            .setDensity(1.0)
            .heat(CS.C, CS.C + 150);
        MT.HCl = MT.gasaciddcmp(9826, "Hydrochloric Acid", 0, 255, 128, 255, GASES)
            .uumMcfg(0, MT.H, 1 * U, MT.Cl, 1 * U)
            .heat(100, 200);
        MT.HF = MT.gasaciddcmp(9829, "Hydrogen Fluoride", 0, 240, 240, 255, GASES)
            .uumMcfg(0, MT.H, 1 * U, MT.F, 1 * U)
            .heat(189, 292);
        MT.HeNe = MT.gaschemcent(9839, "Helium-Neon", 255, 0, 128, 255, GASES)
            .uumMcfg(0, MT.He, 1 * U, MT.Ne, 1 * U);
        MT.HeliumNeon = MT.HeNe;
        MT.Air = MT.gas(9830, "Air", 169, 208, 245, 15, TRANSPARENT, GASES)
            .uumMcfg(0, MT.N, 40 * U, MT.O, 11 * U, MT.Ar, 1 * U)
            .heat(100, 200)
            .setDensity(WEIGHT_AIR_G_PER_CUBIC_CENTIMETER);
        MT.NO = MT.gaschemelec(9837, "Nitrogen Monoxide", 100, 175, 255, 15, GASES)
            .uumMcfg(0, MT.N, 1 * U, MT.O, 1 * U)
            .heat(100, 200);
        MT.NO2 = MT.gaschemelec(9831, "Nitrogen Dioxide", 120, 190, 255, 15, GASES)
            .uumMcfg(0, MT.N, 1 * U, MT.O, 2 * U)
            .heat(100, 200);
        MT.NH3 = MT.gasaciddcmp(8025, "Ammonia", 114, 223, 232, 255, GASES)
            .uumMcfg(0, MT.N, 1 * U, MT.H, 3 * U)
            .heat(195, 239);
        MT.HNO3 = MT.lqudaciddcmp(9825, "Nitric Acid", 128, 255, 0, 255, LIQUID)
            .uumMcfg(0, MT.H, 1 * U, MT.N, 1 * U, MT.O, 3 * U)
            .setDensity(1.5)
            .heat(231, 356);
        MT.NitricAcid = MT.HNO3;
        MT.CO = MT.gaschemelec(9838, "Carbon Monoxide", 10, 10, 10, 15, GASES)
            .uumMcfg(0, MT.C, 1 * U, MT.O, 1 * U)
            .heat(100, 200);
        MT.CO2 = MT.gaschemelec(9836, "Carbon Dioxide", 40, 40, 40, 15, GASES)
            .uumMcfg(0, MT.C, 1 * U, MT.O, 2 * U)
            .heat(100, 200);
        MT.CO3 = MT.gaschemelec(9843, "Carbon Trioxide", 45, 45, 45, 15, GASES, ACID)
            .uumMcfg(0, MT.C, 1 * U, MT.O, 3 * U)
            .heat(100, 200);
        MT.CH4 = MT.gaschemelec(9832, "Methane", 250, 200, 250, 15, GASES, FLAMMABLE)
            .uumMcfg(0, MT.C, 1 * U, MT.H, 4 * U)
            .heat(100, 200);
        MT.Sugar = MT
            .dustdcmp(9703, "Sugar", SET_CUBE, 250, 250, 250, 255, FURNACE, MELTING, FLAMMABLE, BRITTLE, MORTAR, FOOD)
            .uumMcfg(0, MT.C, 12 * U, MT.H, 22 * U, MT.O, 11 * U)
            .aspects(TC.HERBA, 1, TC.AQUA, 1, TC.AER, 1)
            .heat(459);
        MT.Vanilla = MT.dustfood(9787, "Vanilla", 110, 80, 40, 255, DECOMPOSABLE)
            .uumMcfg(0, MT.C, 8 * U, MT.H, 8 * U, MT.O, 3 * U)
            .aspects(TC.FAMES, 1);
        MT.Glycerol = MT.lqudchemelec(9828, "Glycerol", 0, 180, 180, 255, LIQUID, FLAMMABLE)
            .uumMcfg(0, MT.C, 3 * U, MT.H, 8 * U, MT.O, 3 * U)
            .setDensity(1.5)
            .heat(291, 563);
        MT.Glyceryl = MT.lqudchemelec(9821, "Glyceryl", 0, 150, 150, 255, LIQUID, FLAMMABLE, EXPLOSIVE)
            .uumMcfg(0, MT.C, 3 * U, MT.H, 5 * U, MT.N, 3 * U, MT.O, 9 * U)
            .setDensity(1.5)
            .heat(287, 323);
        MT.SO2 = MT.gaschemdcmp(9834, "Sulfur Dioxide", 255, 200, 0, 120, GASES, "SulphurDioxide")
            .uumMcfg(0, MT.S, 1 * U, MT.O, 2 * U)
            .heat(100, 200);
        MT.SO3 = MT.gaschemdcmp(9835, "Sulfur Trioxide", 255, 220, 0, 120, GASES, "SulphurTrioxide")
            .uumMcfg(0, MT.S, 1 * U, MT.O, 3 * U)
            .heat(100, 200);
        MT.H2S = MT.gasaciddcmp(8024, "Hydrosulfuric Acid", 241, 188, 133, 255, GASES, FLAMMABLE)
            .uumMcfg(0, MT.H, 2 * U, MT.S, 1 * U)
            .heat(191, 213);
        MT.H2SO4 = MT.lqudaciddcmp(9824, "Sulfuric Acid", 255, 128, 0, 255, LIQUID, "SulphuricAcid")
            .uumMcfg(0, MT.H, 2 * U, MT.S, 1 * U, MT.O, 4 * U)
            .setDensity(1.5)
            .heat(200, 400);
        MT.SulfuricAcid = MT.H2SO4;
        MT.H2S2O7 = MT.lqudaciddcmp(9844, "Disulfuric Acid", 255, 150, 0, 255, LIQUID)
            .uumMcfg(0, MT.H, 2 * U, MT.S, 2 * U, MT.O, 7 * U)
            .setDensity(1.5)
            .heat(200, 400);
        MT.AgI = MT.oredustelec(8243, "Silver Iodide", SET_CUBE, 240, 200, 100, 255, BRITTLE, MORTAR)
            .uumMcfg(0, MT.Ag, 1 * U, MT.I, 1 * U)
            .aspects(TC.TEMPESTAS, 2)
            .heat(831, 1779);
        MT.SilverIodide = MT.AgI;
        MT.H2SiF6 = MT.lqudacidelec(8011, "Hexafluorosilicic Acid", 190, 200, 190, 255, LIQUID)
            .uumMcfg(0, MT.H, 2 * U, MT.Si, 1 * U, MT.F, 6 * U)
            .setDensity(1.5)
            .heat(250, 381);
        MT.HexafluorosilicicAcid = MT.H2SiF6;
        MT.SiC = MT.metalore(8003, "Carborundum", SET_QUARTZ, 77, 77, 77, BRITTLE, QUARTZ, DECOMPOSABLE)
            .uumMcfg(0, MT.Si, 1 * U, MT.C, 1 * U)
            .aspects(TC.VITREUS, 1)
            .alloyElectrolyzer(3000, 3100)
            .qual(3, 8.0, 256, 3);
        MT.SiO2 = MT
            .oredustdcmp(
                8000,
                "Silicon Dioxide",
                SET_QUARTZ,
                200,
                200,
                200,
                255,
                BRITTLE,
                QUARTZ,
                CRYSTALLISABLE,
                FURNACE,
                UNRECYCLABLE)
            .uumMcfg(0, MT.Si, 1 * U, MT.O, 2 * U)
            .aspects(TC.VITREUS, 2)
            .heat(1986, 3220);
        MT.SiliconDioxide = MT.SiO2;
        MT.Glass = MT
            .gemcent(
                8001,
                "Glass",
                SET_GLASS,
                250,
                250,
                250,
                35,
                UNRECYCLABLE,
                BRITTLE,
                MORTAR,
                G_GLASS,
                FURNACE,
                CRYSTAL,
                COOL2CRYSTAL,
                MELTING,
                EXTRUDER,
                EXTRUDER_SIMPLE)
            .lens(DYE_INDEX_White)
            .uumMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.VITREUS, 2)
            .qual(1, 1.0, 1, 0)
            .heat(1200);
        MT.Flint = MT.cent(8002, "Flint", SET_FLINT, 0, 32, 64, 255, UNRECYCLABLE, BRITTLE, MORTAR, G_GEM, STONE)
            .uumMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.TERRA, 1, TC.INSTRUMENTUM, 1)
            .qual(1, 2.5, 48, 1)
            .setSmelting(MT.SiO2, U);
        MT.H3BO3 = MT.dustelec(8007, "Hydrogen Borate", SET_FINE, 234, 234, 255, 255, "BoricAcid")
            .uumMcfg(0, MT.H, 3 * U, MT.B, 1 * U, MT.O, 3 * U);
        MT.HydrogenBorate = MT.H3BO3;
        MT.BoricAcid = MT.H3BO3;
        MT.Datolite = MT.oredustelec(8006, "Datolite", SET_ROUGH, 222, 255, 222, 255)
            .uumMcfg(0, MT.H, 2 * U, MT.Ca, 2 * U, MT.B, 2 * U, MT.Si, 2 * U, MT.O, 10 * U);
        MT.H2Ca2B2Si2O10 = MT.Datolite;
        MT.V2O5 = MT
            .oredustelec(8234, "Vanadium Pentoxide", SET_FINE, 50, 50, 50, 255, WASHING_FIRESTONE, MAGNETIC_PASSIVE)
            .uumMcfg(0, MT.V, 2 * U, MT.O, 5 * U)
            .addSourceOf(MT.V)
            .setSmelting(MT.V, U7);
        MT.VanadiumPentoxide = MT.V2O5;
        MT.Nb2O5 = MT.oredustdcmp(8461, "Niobium Pentoxide", SET_FINE, 50, 64, 10, 255, WASHING_FIRESTONE)
            .uumMcfg(0, MT.Nb, 2 * U, MT.O, 5 * U)
            .addSourceOf(MT.Nb);
        MT.Ta2O5 = MT.oredustdcmp(8462, "Tantalum Pentoxide", SET_FINE, 64, 50, 10, 255, WASHING_FIRESTONE)
            .uumMcfg(0, MT.Ta, 2 * U, MT.O, 5 * U)
            .addSourceOf(MT.Ta);
        MT.PO4 = MT.oredustelec(8207, "Phosphate", SET_DULL, 255, 255, 0, 255, FLAMMABLE, EXPLOSIVE, BRITTLE, MORTAR)
            .uumMcfg(0, MT.P, 1 * U, MT.O, 4 * U)
            .heat(400, 800)
            .addSourceOf(MT.P);
        MT.WO3 = MT
            .oredustdcmp(
                8026,
                "Tungsten Trioxide",
                SET_DULL,
                199,
                211,
                0,
                255,
                MELTING,
                MOLTEN,
                INGOTS,
                MORTAR,
                WASHING_FIRESTONE,
                "TungstenOxide")
            .uumMcfg(0, MT.W, 1 * U, MT.O, 3 * U)
            .heat(1746, 1970)
            .addSourceOf(MT.W);
        MT.H2WO4 = MT.dustdcmp(8027, "Tungstic Acid", SET_SHINY, 188, 200, 0, 255, MELTING, ACID)
            .uumMcfg(0, MT.H, 2 * U, MT.W, 1 * U, MT.O, 4 * U)
            .heat(373, 1746)
            .addSourceOf(MT.W)
            .setSmelting(MT.WO3, 4 * U7);
        MT.Al2O3 = MT.oredustdcmp(8008, "Alumina", SET_METALLIC, 120, 195, 235, 255, MELTING, INGOTS, "NaturalAluminum")
            .uumMcfg(0, MT.Al, 2 * U, MT.O, 3 * U)
            .heat(2345, 3250)
            .addSourceOf(MT.Al);
        MT.AlF3 = MT.dustdcmp(8010, "Aluminium Fluoride", SET_DULL, 200, 190, 190, 255, MELTING, MOLTEN, INGOTS, ACID)
            .uumMcfg(0, MT.Al, 1 * U, MT.F, 3 * U)
            .heat(1560);
        MT.AlO3H3 = MT.oredustdcmp(8014, "Aluminium Hydroxide", SET_DULL, 190, 190, 200, 255, MELTING, "Gibbsite")
            .uumMcfg(0, MT.Al, 1 * U, MT.O, 3 * U, MT.H, 3 * U)
            .heat(573)
            .addSourceOf(MT.Al)
            .setSmelting(MT.Al2O3, 5 * U14);
        MT.TiO2 = MT.oredustdcmp(9192, "Rutile", SET_METALLIC, 110, 80, 120, 255, MELTING, MOLTEN, INGOTS)
            .uumMcfg(1, MT.Ti, 1 * U, MT.O, 2 * U)
            .heat(MT.Ti.mMeltingPoint + 100, MT.Ti.mBoilingPoint)
            .qual(2)
            .addSourceOf(MT.Ti);
        MT.TiCl4 = MT.lqudaciddcmp(8413, "Titanium Tetrachloride", 233, 244, 222, 255, LIQUID)
            .uumMcfg(0, MT.Ti, 1 * U, MT.Cl, 4 * U)
            .heat(249, 409);
        MT.TitaniumTetrachloride = MT.TiCl4;
        MT.MnO2 = MT
            .oredustdcmp(9126, "Pyrolusite", SET_DULL, 50, 50, 70, 255, MELTING, INGOTS, MORTAR, MAGNETIC_PASSIVE)
            .setSmelting(MT.Mn, 3 * U4)
            .uumMcfg(1, MT.Mn, 1 * U, MT.O, 2 * U)
            .heat(808, 2334)
            .addSourceOf(MT.Mn);
        MT.MnCl2 = MT.dustdcmp(8031, "Manganese Chloride", SET_CUBE, 255, 213, 213, 255, MELTING, MOLTEN, INGOTS)
            .uumMcfg(0, MT.Mn, 1 * U, MT.Cl, 2 * U)
            .heat(927, 1498);
        MT.Fe2O3 = MT
            .oredustdcmp(
                9104,
                "Hematite",
                SET_DULL,
                145,
                90,
                90,
                255,
                MELTING,
                MOLTEN,
                MORTAR,
                MAGNETIC_PASSIVE,
                "BandedIron",
                "IronOxide")
            .uumMcfg(0, MT.Fe, 2 * U, MT.O, 3 * U)
            .heat(2 * MT.Fe.mMeltingPoint / 3)
            .addSourceOf(MT.Fe)
            .qual(0);
        MT.FeCl2 = MT
            .dustelec(8030, "Ferrous Chloride", SET_CUBE, 199, 233, 199, 255, MELTING, MOLTEN, INGOTS, MAGNETIC_PASSIVE)
            .uumMcfg(0, MT.Fe, 1 * U, MT.Cl, 2 * U)
            .heat(950, 1296);
        MT.FeCl3 = MT.dustdcmp(8017, "Ferric Chloride", SET_METALLIC, 180, 180, 120, 255, MELTING)
            .uumMcfg(0, MT.Fe, 1 * U, MT.Cl, 3 * U)
            .heat(580, 589);
        MT.FeO3H3 = MT.dustdcmp(8035, "Ferric Oxyhydroxide", SET_FINE, 137, 62, 40, 255, MELTING)
            .uumMcfg(0, MT.Fe, 1 * U, MT.O, 3 * U, MT.H, 3 * U)
            .heat(MT.Fe2O3.mMeltingPoint)
            .addSourceOf(MT.Fe)
            .setSmelting(MT.Fe2O3, 5 * U14);
        MT.MgCl2 = MT.oredustdcmp(8018, "Magnesium Chloride", SET_CUBE, 235, 235, 250, 255, MELTING, MOLTEN, INGOTS)
            .uumMcfg(0, MT.Mg, 1 * U, MT.Cl, 2 * U)
            .aspects(TC.FAMES, 1)
            .heat(987, 1685);
        // Can be electrolyzed for real
        MT.MgCO3 = MT
            .oredustdcmp(
                8016,
                "Magnesium Carbonate",
                SET_DULL,
                240,
                230,
                230,
                255,
                MELTING,
                MOLTEN,
                INGOTS,
                "Magnesite")
            .uumMcfg(0, MT.Mg, 1 * U, MT.CO3, 4 * U)
            .heat(623, 3000);
        MT.CaCl2 = MT.oredustdcmp(8028, "Calcium Chloride", SET_CUBE, 235, 235, 250, 255, MELTING, MOLTEN, INGOTS)
            .uumMcfg(0, MT.Ca, 1 * U, MT.Cl, 2 * U)
            .aspects(TC.FAMES, 1)
            .heat(1048, 2208);
        // Can be electrolyzed for real
        MT.CaSO4 = MT.dustdcmp(8274, "Calcium Sulfate", SET_CUBE, 240, 220, 210, 255, MORTAR, "CalciumSulphate")
            .uumMcfg(0, MT.Ca, 1 * U, MT.S, 1 * U, MT.O, 4 * U)
            .heat(1730, 3000);
        MT.Gypsum = MT.oredustdcmp(9161, "Gypsum", SET_POWDER, 240, 240, 240, 255, MORTAR)
            .uumMcfg(6, MT.CaSO4, 6 * U, MT.H2O, 6 * U)
            .heat(1730, 3000);
        MT.Quicklime = MT.oredustdcmp(9271, "Quicklime", SET_POWDER, 240, 230, 210, 255, MORTAR)
            .uumMcfg(0, MT.Ca, 1 * U, MT.O, 1 * U)
            .heat(2886, 3120);
        MT.CaCO3 = MT
            .oredustdcmp(
                9107,
                "Calcite",
                SET_DULL,
                250,
                230,
                220,
                255,
                MELTING,
                MOLTEN,
                INGOTS,
                MORTAR,
                "Valerite",
                "Aragonite",
                "Flux")
            .uumMcfg(0, MT.Ca, 1 * U, MT.CO3, 4 * U)
            .heat(1612, 3000);
        MT.CaF2 = MT.fluorite(9215, "Fluorite", 225, 185, 140, MOLTEN, INGOTS);
        MT.FluoriteRed = MT.fluorite(8436, "Red Fluorite", 226, 56, 65);
        MT.FluoritePink = MT.fluorite(8437, "Pink Fluorite", 226, 117, 148);
        MT.FluoriteBlue = MT.fluorite(8438, "Blue Fluorite", 88, 172, 180);
        MT.FluoriteGreen = MT.fluorite(8439, "Green Fluorite", 37, 168, 35);
        MT.FluoriteBlack = MT.fluorite(8440, "Black Fluorite", 48, 48, 48, MD.RH);
        MT.FluoriteWhite = MT.fluorite(8441, "White Fluorite", 180, 180, 180);
        MT.FluoriteYellow = MT.fluorite(8442, "Yellow Fluorite", 206, 182, 80);
        MT.FluoriteOrange = MT.fluorite(8443, "Orange Fluorite", 255, 189, 88);
        MT.FluoriteMagenta = MT.fluorite(8444, "Magenta Fluorite", 204, 88, 255);
        MT.LiCl = MT
            .oredustdcmp(
                8029,
                "Lithium Chloride",
                SET_CUBE,
                222,
                222,
                250,
                255,
                MELTING,
                MOLTEN,
                INGOTS,
                WASHING_MERCURY)
            .uumMcfg(0, MT.Li, 1 * U, MT.Cl, 1 * U)
            .addSourceOf(MT.Li)
            .aspects(TC.FAMES, 1)
            .setPriorityPrefix(2)
            .heat(880, 1655);
        // Can be electrolyzed for real
        MT.LiClO3 = MT.dustdcmp(8033, "Lithium Chlorate", SET_ROUGH, 222, 233, 250, 255, MELTING, MOLTEN, INGOTS)
            .uumMcfg(0, MT.Li, 1 * U, MT.Cl, 1 * U, MT.O, 3 * U)
            .addSourceOf(MT.Li)
            .heat(400);
        MT.LiClO4 = MT.dustdcmp(8034, "Lithium Perchlorate", SET_ROUGH, 222, 244, 250, 255, MELTING, MOLTEN, INGOTS)
            .uumMcfg(0, MT.Li, 1 * U, MT.Cl, 1 * U, MT.O, 4 * U)
            .addSourceOf(MT.Li)
            .heat(509, 703);
        MT.Li2O = MT.dustelec(8004, "Lithium Oxide", SET_ROUGH, 222, 222, 234, 255)
            .uumMcfg(0, MT.Li, 2 * U, MT.O, 1 * U)
            .addSourceOf(MT.Li);
        MT.Li2Fe2O4 = MT
            .metalore(8005, "Ferrite", SET_METALLIC, 120, 120, 130, DECOMPOSABLE, ELECTROLYSER, MAGNETIC_PASSIVE)
            .uumMcfg(0, MT.Li, 2 * U, MT.Fe, 2 * U, MT.O, 4 * U)
            .addSourceOf(MT.Li, MT.Fe);
        MT.LiOH = MT.dustelec(8032, "Lithium Hydroxide", SET_CUBE, 222, 202, 250, 255)
            .uumMcfg(0, MT.Li, 1 * U, MT.O, 1 * U, MT.H, 1 * U)
            .addSourceOf(MT.Li)
            .heat(735, 1197);
        MT.NaCl = MT.oredustdcmp(8204, "Salt", SET_CUBE, 250, 250, 250, 255, BRITTLE, MORTAR, FOOD)
            .uumMcfg(0, MT.Na, 1 * U, MT.Cl, 1 * U)
            .aspects(TC.FAMES, 1)
            .addSourceOf(MT.Na)
            .setPriorityPrefix(2)
            .heat(1074, 1686);
        MT.NaNO3 = MT.oredustelec(8019, "Sodium Nitrate", SET_FINE, 230, 230, 230, 255, FLAMMABLE, BRITTLE, MORTAR)
            .uumMcfg(0, MT.Na, 1 * U, MT.N, 1 * U, MT.O, 3 * U)
            .aspects(TC.IGNIS, 2)
            .setPriorityPrefix(2)
            .heat(607);
        MT.NaOH = MT.dustelec(8268, "Sodium Hydroxide", SET_CUBE, 220, 250, 220, 255)
            .uumMcfg(0, MT.Na, 1 * U, MT.O, 1 * U, MT.H, 1 * U)
            .heat(596, 1661);
        MT.NaHCO3 = MT.oredustdcmp(8039, "Sodium Hydrogencarbonate", SET_FINE, 230, 235, 240, 255, "Soda")
            .setLocal("Soda")
            .uumMcfg(0, MT.Na, 1 * U, MT.H, 1 * U, MT.C, 1 * U, MT.O, 3 * U);
        MT.Soda = MT.NaHCO3;
        MT.NaHSO4 = MT
            .dustdcmp(
                8230,
                "Sodium Bisulfate",
                SET_FINE,
                240,
                240,
                255,
                255,
                "SodiumBisulphate",
                "SodiumHydrogenSulfate",
                "SodiumHydrogenSulphate")
            .uumMcfg(0, MT.Na, 1 * U, MT.H, 1 * U, MT.S, 1 * U, MT.O, 4 * U);
        MT.NaSO4 = MT.dustdcmp(9822, "Sodium Persulfate", SET_CUBE, 130, 180, 250, 255, "SodiumPersulphate")
            .uumMcfg(0, MT.Na, 1 * U, MT.S, 1 * U, MT.O, 4 * U);
        MT.Na2S = MT.dustdcmp(9823, "Sodium Sulfide", SET_CUBE, 220, 220, 100, 255, "SodiumSulphide")
            .uumMcfg(0, MT.Na, 2 * U, MT.S, 1 * U);
        MT.Na2SO3 = MT.dustdcmp(8269, "Sodium Sulfite", SET_CUBE, 190, 190, 140, 255, "SodiumSulphite")
            .uumMcfg(0, MT.Na, 2 * U, MT.S, 1 * U, MT.O, 3 * U)
            .heat(306);
        MT.Na2SO4 = MT.dustdcmp(8270, "Sodium Sulfate", SET_CUBE, 190, 190, 140, 255, "SodiumSulphate")
            .uumMcfg(0, MT.Na, 2 * U, MT.S, 1 * U, MT.O, 4 * U)
            .heat(1157, 1702);
        // Can be used to store Heat very well.
        MT.Na2S2O7 = MT.dustdcmp(8231, "Sodium Pyrosulfate", SET_FINE, 240, 240, 255, 255, "SodiumPyrosulphate")
            .uumMcfg(0, MT.Na, 2 * U, MT.S, 2 * U, MT.O, 7 * U)
            .heat(674);
        MT.Na2CO3 = MT.dustdcmp(8013, "Sodium Carbonate", SET_FINE, 230, 230, 230, 255, MELTING, MOLTEN, INGOTS)
            .uumMcfg(0, MT.Na, 2 * U, MT.CO3, 4 * U)
            .heat(1124);
        MT.NaAlO2 = MT.dustdcmp(8012, "Sodium Aluminate", SET_CUBE, 230, 230, 250, 255)
            .uumMcfg(0, MT.Na, 1 * U, MT.Al, 1 * U, MT.O, 2 * U)
            .heat(1920);
        MT.NaF = MT.dustelec(8037, "Sodium Fluoride", SET_CUBE, 64, 200, 225, 255)
            .uumMcfg(0, MT.Na, 1 * U, MT.F, 1 * U)
            .heat(1266);
        MT.Na3AlF6 = MT.oredustdcmp(8009, "Cryolite", SET_DULL, 200, 190, 190, 255, MELTING, MOLTEN, INGOTS, ACID)
            .uumMcfg(0, MT.Na, 3 * U, MT.Al, 1 * U, MT.F, 6 * U)
            .heat(1285)
            .addSourceOf(MT.Na, MT.F);
        MT.Cryolite = MT.Na3AlF6;
        MT.SaltWater = MT.lqudelec(9804, "Saltwater", 255, 0, 255, 255, LIQUID, UNRECYCLABLE, "SaltWater", "Brine")
            .uumMcfg(0, MT.H2O, 3 * U, MT.NaCl, 1 * U)
            .aspects(TC.AQUA, 2)
            .heat(CS.C, CS.C + 90)
            .setDensity(1.0);
        MT.KIO3 = MT.oredustelec(8242, "Iodine Salt", SET_CUBE, 240, 200, 240, 255, BRITTLE, MORTAR)
            .uumMcfg(0, MT.K, 1 * U, MT.I, 1 * U, MT.O, 3 * U)
            .aspects(TC.TEMPESTAS, 1)
            .addSourceOf(MT.K)
            .heat(300, 370);
        MT.IodineSalt = MT.KIO3;
        MT.KCl = MT.oredustdcmp(8203, "Sylvite", SET_CUBE, 240, 200, 200, 255, BRITTLE, MORTAR, "RockSalt", "Sylvine")
            .uumMcfg(0, MT.K, 1 * U, MT.Cl, 1 * U)
            .aspects(TC.FAMES, 1)
            .addSourceOf(MT.K)
            .setPriorityPrefix(2)
            .heat(1040, 1690);
        MT.KNO3 = MT
            .oredustelec(
                8205,
                "Potassium Nitrate",
                SET_FINE,
                230,
                230,
                230,
                255,
                FLAMMABLE,
                BRITTLE,
                MORTAR,
                "Saltpeter",
                "Nitrate",
                "Salpeter")
            .uumMcfg(0, MT.K, 1 * U, MT.N, 1 * U, MT.O, 3 * U)
            .aspects(TC.IGNIS, 2)
            .setPriorityPrefix(2)
            .heat(607);
        MT.KOH = MT.dustelec(8015, "Potassium Hydroxide", SET_CUBE, 250, 220, 220, 255)
            .uumMcfg(0, MT.K, 1 * U, MT.O, 1 * U, MT.H, 1 * U)
            .heat(633, 1600);
        MT.KHSO4 = MT.dustdcmp(8232, "Potassium Bisulfate", SET_FINE, 255, 240, 240, 255, "PotassiumBisulphate")
            .uumMcfg(0, MT.K, 1 * U, MT.H, 1 * U, MT.S, 1 * U, MT.O, 4 * U);
        MT.KSO4 = MT.dustdcmp(8022, "Potassium Persulfate", SET_CUBE, 250, 180, 130, 255, "PotassiumPersulphate")
            .uumMcfg(0, MT.K, 1 * U, MT.S, 1 * U, MT.O, 4 * U);
        MT.K2S = MT.dustdcmp(8272, "Potassium Sulfide", SET_CUBE, 100, 220, 220, 255, "PotassiumSulphide")
            .uumMcfg(0, MT.K, 2 * U, MT.S, 1 * U);
        MT.K2SO3 = MT.dustdcmp(8021, "Potassium Sulfite", SET_CUBE, 140, 190, 190, 255, "PotassiumSulphite")
            .uumMcfg(0, MT.K, 2 * U, MT.S, 1 * U, MT.O, 3 * U)
            .heat(306);
        MT.K2SO4 = MT.dustdcmp(8271, "Potassium Sulfate", SET_CUBE, 140, 190, 190, 255, "PotassiumSulphate")
            .uumMcfg(0, MT.K, 2 * U, MT.S, 1 * U, MT.O, 4 * U)
            .heat(1342, 1962);
        MT.K2S2O7 = MT.dustdcmp(8233, "Potassium Pyrosulfate", SET_FINE, 255, 240, 240, 255, "PotassiumPyrosulphate")
            .uumMcfg(0, MT.K, 2 * U, MT.S, 2 * U, MT.O, 7 * U)
            .heat(598);
        MT.K2CO3 = MT.dustdcmp(8020, "Potassium Carbonate", SET_FINE, 230, 225, 225, 255, MELTING, MOLTEN, INGOTS)
            .uumMcfg(0, MT.K, 2 * U, MT.CO3, 4 * U)
            .heat(1164);
        MT.KAlO2 = MT.dustdcmp(8023, "Potassium Aluminate", SET_CUBE, 250, 230, 230, 255)
            .uumMcfg(0, MT.K, 1 * U, MT.Al, 1 * U, MT.O, 2 * U)
            .heat(1920);
        MT.KF = MT.dustelec(8036, "Potassium Fluoride", SET_CUBE, 200, 64, 225, 255)
            .uumMcfg(0, MT.K, 1 * U, MT.F, 1 * U)
            .heat(1131);
        MT.K2TaF7 = MT.dustdcmp(8038, "Potassium Heptafluorotantalate", SET_FINE, 164, 200, 225, 255)
            .uumMcfg(0, MT.K, 2 * U, MT.Ta, 1 * U, MT.F, 7 * U);
        MT.SaltedWater = MT.lqudelec(9815, "Salted Water", 255, 0, 200, 255, LIQUID, UNRECYCLABLE, "Saltedwater")
            .uumMcfg(0, MT.H2O, 3 * U, MT.KCl, 1 * U)
            .aspects(TC.AQUA, 2)
            .heat(CS.C, CS.C + 90)
            .setDensity(1.0);
        MT.ChloroauricAcid = MT.lqudaciddcmp(8400, "Chloroauric Acid", 255, 200, 70, 255, LIQUID)
            .uumMcfg(0, MT.Au, 1 * U, MT.Cl, 4 * U, MT.H, 1 * U)
            .heat(200, 400);
        MT.ChloroplatinicAcid = MT.lqudaciddcmp(8401, "Chloroplatinic Acid", 255, 70, 70, 255, LIQUID)
            .uumMcfg(0, MT.Pt, 1 * U, MT.Cl, 6 * U, MT.H, 2 * U)
            .heat(200, 400);
        MT.StannicChloride = MT.lqudaciddcmp(8402, "Stannic Chloride", 210, 250, 250, 255, LIQUID)
            .uumMcfg(0, MT.Sn, 1 * U, MT.Cl, 4 * U)
            .heat(200, 400);
        MT.BlackVitriol = MT.lqudacidelec(8403, "Black Vitriol", 66, 66, 66, 255, LIQUID)
            .uumMcfg(0, MT.Fe, 1 * U, MT.S, 1 * U)
            .heat(200, 400);
        MT.BlueVitriol = MT
            .lqudaciddcmp(
                8404,
                "Blue Vitriol",
                66,
                66,
                222,
                255,
                LIQUID,
                "RomanVitriol",
                "CyprusVitriol",
                "SolutionBlueVitriol")
            .uumMcfg(0, MT.Cu, 1 * U, MT.S, 1 * U, MT.O, 4 * U)
            .heat(200, 400);
        MT.GreenVitriol = MT.lqudaciddcmp(8405, "Green Vitriol", 66, 222, 66, 255, LIQUID)
            .uumMcfg(0, MT.Fe, 1 * U, MT.S, 1 * U, MT.O, 4 * U)
            .heat(200, 400);
        MT.RedVitriol = MT.lqudaciddcmp(8406, "Red Vitriol", 222, 66, 66, 255, LIQUID)
            .uumMcfg(0, MT.Co, 1 * U, MT.S, 1 * U, MT.O, 4 * U)
            .heat(200, 400);
        MT.PinkVitriol = MT.lqudaciddcmp(8407, "Pink Vitriol", 222, 111, 111, 255, LIQUID)
            .uumMcfg(0, MT.Mg, 1 * U, MT.S, 1 * U, MT.O, 4 * U)
            .heat(200, 400);
        MT.CyanVitriol = MT
            .lqudaciddcmp(
                8408,
                "Cyan Vitriol",
                111,
                222,
                222,
                255,
                LIQUID,
                "SolutionNickelSulfate",
                "SolutionNickelSulphate")
            .uumMcfg(0, MT.Ni, 1 * U, MT.S, 1 * U, MT.O, 4 * U)
            .heat(200, 400);
        MT.WhiteVitriol = MT.lqudaciddcmp(8409, "White Vitriol", 222, 222, 222, 255, LIQUID)
            .uumMcfg(0, MT.Zn, 1 * U, MT.S, 1 * U, MT.O, 4 * U)
            .heat(200, 400);
        MT.GrayVitriol = MT.lqudaciddcmp(8410, "Gray Vitriol", 111, 111, 111, 255, LIQUID)
            .uumMcfg(0, MT.Mn, 1 * U, MT.S, 1 * U, MT.O, 4 * U)
            .heat(200, 400);
        MT.MartianVitriol = MT.lqudaciddcmp(8411, "Martian Vitriol", 222, 66, 222, 255, LIQUID)
            .uumMcfg(18, MT.Fe, 2 * U, MT.S, 3 * U, MT.O, 12 * U)
            .heat(200, 400);
        MT.VitriolOfClay = MT.lqudaciddcmp(8412, "Vitriol Of Clay", 66, 222, 222, 255, LIQUID)
            .uumMcfg(0, MT.Al2O3, 5 * U, MT.S, 3 * U, MT.O, 9 * U)
            .heat(200, 400);
        MT.UF4 = MT.dustdcmp(9007, "Uranium Tetrafluoride", SET_SHARDS, 86, 118, 105, 255, MELTING, MOLTEN)
            .setMcfg(0, MT.U_238, 1 * U, MT.F, 4 * U)
            .tooltip("UF\u2084")
            .aspects(TC.RADIO, 1, TC.PERDITIO, 2)
            .heat(1309, 1690);
        MT.UF6 = MT.gaschemdcmp(9008, "Uranium Hexafluoride", 66, 98, 85, 255, GASES)
            .setMcfg(0, MT.U_238, 1 * U, MT.F, 6 * U)
            .tooltip("UF\u2086")
            .aspects(TC.RADIO, 1, TC.PERDITIO, 3)
            .heat(100, 329);
        MT.U238F4 = MT.dustdcmp(9009, "Uranium-238 Tetrafluoride", SET_SHARDS, 86, 118, 105, 255, MELTING, MOLTEN)
            .setMcfg(0, MT.U_238, 1 * U, MT.F, 4 * U)
            .tooltip("U-238F\u2084")
            .aspects(TC.RADIO, 1, TC.PERDITIO, 2)
            .heat(1309, 1690);
        MT.U238F6 = MT.gaschemdcmp(9010, "Uranium-238 Hexafluoride", 66, 98, 85, 255, GASES)
            .setMcfg(0, MT.U_238, 1 * U, MT.F, 6 * U)
            .tooltip("U-238F\u2086")
            .aspects(TC.RADIO, 1, TC.PERDITIO, 3)
            .heat(100, 329);
        MT.U235F4 = MT.dustdcmp(9011, "Uranium-235 Tetrafluoride", SET_SHARDS, 86, 118, 105, 255, MELTING, MOLTEN)
            .setMcfg(0, MT.U_235, 1 * U, MT.F, 4 * U)
            .tooltip("U-235F\u2084")
            .aspects(TC.RADIO, 1, TC.PERDITIO, 2)
            .heat(1309, 1690);
        MT.U235F6 = MT.gaschemdcmp(9012, "Uranium-235 Hexafluoride", 66, 98, 85, 255, GASES)
            .setMcfg(0, MT.U_235, 1 * U, MT.F, 6 * U)
            .tooltip("U-235F\u2086")
            .aspects(TC.RADIO, 1, TC.PERDITIO, 3)
            .heat(100, 329);
        MT.AquaRegia = MT.lqudacidcent(9827, "Aqua Regia", 64, 255, 64, 255, LIQUID)
            .uumMcfg(0, MT.HNO3, 5 * U, MT.HCl, 8 * U)
            .heat(200, 400);
        MT.CobaltHexahydrate = MT.dustcent(8229, "Cobalt Hexahydrate", SET_ROUGH, 80, 80, 250, 255)
            .uumMcfg(0, MT.Co, 1 * U, MT.H2O, 6 * U);
        MT.MethaneIce = MT.dustcent(9833, "Methane Ice", SET_SHINY, 225, 200, 250, 255, G_CONTAINERS, FLAMMABLE)
            .setMcfg(2, MT.CH4, 1 * U, MT.Ice, 2 * U);
        MT.NitroCarbon = MT.elec(9820, "Nitro Carbon", SET_FLUID, 0, 75, 100, 255, G_CONTAINERS, EXPLOSIVE, FLAMMABLE)
            .uumMcfg(0, MT.N, 1 * U, MT.C, 1 * U);
        MT.Lava = MT.lqud(9810, "Lava", SET_STONE, 255, 64, 0, 255, MELTING, GLOWING, LIGHTING)
            .heat(1300, 4000)
            .liquid(FL.Lava.make(1000), U * 9);
        MT.Biomass = MT.lqudflam(9840, "Biomass", 0, 255, 0, 255, TICKS_PER_SMELT * 30, "BioMass")
            .heat(200, 400)
            .aspects(TC.HERBA, 2);
        MT.BioFuel = MT.lqudflam(9841, "Bio Fuel", 200, 128, 0, 255, TICKS_PER_SMELT * 360)
            .heat(100, 400)
            .aspects(TC.HERBA, 1, TC.POTENTIA, 1)
            .setLocal("Bio Diesel");
        MT.Ethanol = MT.lqudflam(9842, "Ethanol", 255, 128, 0, 255, TICKS_PER_SMELT * 360)
            .heat(100, 400)
            .aspects(TC.HERBA, 1, TC.POTENTIA, 1);
        MT.Oil = MT.lqudflam(9850, "Oil", 10, 10, 10, 255, TICKS_PER_SMELT * 60)
            .heat(100, 400)
            .aspects(TC.MORTUUS, 2, TC.LUX, 1);
        MT.Oilsands = MT.oredust(9851, "Oil Sand", SET_SAND, 10, 10, 10, 255, TICKS_PER_SMELT * 30, "Oilsands")
            .heat(100, 400)
            .aspects(TC.MORTUUS, 2, TC.LUX, 1);
        MT.CrudeOil = MT.oredust(9852, "Crude Oil", SET_DULL, 10, 10, 10, 255, TICKS_PER_SMELT * 60)
            .heat(100, 400)
            .aspects(TC.MORTUUS, 2, TC.LUX, 1);
        MT.Fuel = MT.lqudexpl(9860, "Fuel", 255, 255, 0, 255, TICKS_PER_SMELT * 360, "FuelOil")
            .heat(100, 400)
            .aspects(TC.MORTUUS, 1, TC.POTENTIA, 1)
            .setLocal("Fuel Oil");
        MT.NitroFuel = MT.lqudexpl(9861, "Nitro-Fuel", 200, 255, 0, 255, TICKS_PER_SMELT * 360)
            .setMcfg(0, MT.Glyceryl, 1 * U, MT.Fuel, 4 * U)
            .heat(100, 400)
            .aspects(TC.MORTUUS, 1, TC.POTENTIA, 2);
        MT.Kerosine = MT.lqudexpl(9862, "Kerosine", 0, 0, 255, 255, TICKS_PER_SMELT * 360)
            .heat(100, 400)
            .aspects(TC.VOLATUS, 1, TC.POTENTIA, 1);
        MT.Diesel = MT.lqudexpl(9863, "Diesel", 255, 255, 0, 255, TICKS_PER_SMELT * 360)
            .heat(100, 400)
            .aspects(TC.MORTUUS, 1, TC.POTENTIA, 1);
        MT.Petrol = MT.lqudexpl(9864, "Petrol", 255, 0, 0, 255, TICKS_PER_SMELT * 360, "Gasoline")
            .heat(100, 400)
            .aspects(TC.MORTUUS, 1, TC.POTENTIA, 1);
        MT.Propane = MT.gasexpl(9865, "Propane", 255, 20, 20, 255, TICKS_PER_SMELT * 180)
            .heat(100, 200)
            .aspects(TC.MORTUUS, 1, TC.POTENTIA, 1);
        MT.Butane = MT.gasexpl(9866, "Butane", 255, 40, 40, 255, TICKS_PER_SMELT * 180)
            .heat(100, 200)
            .aspects(TC.MORTUUS, 1, TC.POTENTIA, 1);
        MT.Propylene = MT.gasexpl(9867, "Propylene", 90, 60, 140, 255)
            .heat(100, 200)
            .aspects(TC.MORTUUS, 1, TC.POTENTIA, 1);
        MT.Ethylene = MT.gasexpl(9868, "Ethylene", 64, 40, 100, 255)
            .heat(100, 200)
            .aspects(TC.MORTUUS, 1, TC.POTENTIA, 1);
        MT.Creosote = MT.lqudflam(9870, "Creosote", 128, 64, 0, 255, LIQUID, "Creosote Oil")
            .heat(100, 400)
            .aspects(TC.ARBOR, 2, TC.LUX, 1);
        MT.FishOil = MT.lqudflam(9871, "Fish Oil", 255, 196, 0, 255, FOOD)
            .heat(100, 400)
            .aspects(TC.CORPUS, 2, TC.LUX, 1);
        MT.WhaleOil = MT.lqudflam(9887, "Whale Oil", 51, 40, 23, 255, FOOD)
            .heat(100, 400)
            .aspects(TC.CORPUS, 2, TC.LUX, 1);
        MT.SeedOil = MT.lqudflam(9872, "Seed Oil", 196, 255, 0, 255, FOOD)
            .heat(100, 400)
            .aspects(TC.GRANUM, 2, TC.LUX, 1);
        MT.HempOil = MT.lqudflam(9873, "Hemp Oil", 196, 255, 0, 255, FOOD)
            .heat(100, 400)
            .aspects(TC.GRANUM, 2, TC.LUX, 1);
        MT.LinOil = MT.lqudflam(9874, "Lin Oil", 196, 255, 0, 255, FOOD)
            .heat(100, 400)
            .aspects(TC.GRANUM, 2, TC.LUX, 1);
        MT.SunflowerOil = MT.lqudflam(9875, "Sunflower Oil", 216, 189, 17, 255, FOOD)
            .heat(100, 400)
            .aspects(TC.GRANUM, 2, TC.LUX, 1);
        MT.NutOil = MT.lqudflam(9876, "Nut Oil", 235, 173, 70, 255, FOOD)
            .heat(100, 400)
            .aspects(TC.GRANUM, 2, TC.LUX, 1);
        MT.OliveOil = MT.lqudflam(9877, "Olive Oil", 63, 146, 0, 255, FOOD)
            .heat(100, 400)
            .aspects(TC.HERBA, 2, TC.LUX, 1);
        MT.FryingOilHot = MT.lqudflam(9880, "FryingOilHot", 200, 196, 0, 255, FOOD)
            .heat(100, 400)
            .aspects(TC.AQUA, 1, TC.IGNIS, 1)
            .setLocal("Hot Frying Oil");
        MT.Glue = MT.lqudflam(9881, "Glue", 200, 196, 0, 255)
            .heat(150, 500)
            .aspects(TC.LIMUS, 2);
        MT.Lubricant = MT.lqud(9882, "Lubricant", 255, 196, 0, 255)
            .heat(150, 500)
            .aspects(TC.AQUA, 1, TC.MACHINA, 1);
        MT.ConstructionFoam = MT
            .lqud(9883, "Construction Foam", SET_DULL, 128, 128, 128, 255, DUSTS, STONE, BRITTLE, MELTING)
            .heat(500, 2000)
            .setLocal("C-Foam");
        MT.UUAmplifier = MT.lqud(9884, "UU-Amplifier", 196, 0, 255, 255)
            .heat(50, 500);
        MT.UUMatter = MT.lqud(9885, "UU-Matter", 96, 0, 128, 255, GLOWING)
            .heat(50, 500);
        MT.Latex = MT.lqud(9886, "Latex", 250, 250, 250, 255)
            .heat(150, 500)
            .aspects(TC.AQUA, 1, TC.LIMUS, 1);
        MT.Ash = MT.dust(8200, "Ashes", SET_DULL, 120, 120, 120, 255, MORTAR, BRITTLE, "Ash")
            .aspects(TC.PERDITIO, 1);
        MT.DarkAsh = MT
            .dust(8201, "Dark Ashes", SET_DULL, 50, 50, 50, 255, MORTAR, BRITTLE, "DarkAsh", "AshDark", "AshesDark")
            .aspects(TC.IGNIS, 1, TC.PERDITIO, 1);
        MT.VolcanicAsh = MT
            .dustcent(
                8202,
                "Volcanic Ashes",
                SET_FLINT,
                60,
                50,
                50,
                255,
                MORTAR,
                BRITTLE,
                "VolcanicAsh",
                "AshVolcanic",
                "AshesVolcanic")
            .setMcfg(0, MT.Flint, 6 * U, MT.Fe2O3, 1 * U, MT.Mg, 1 * U)
            .aspects(TC.IGNIS, 2, TC.PERDITIO, 1);
        MT.Chalk = MT.oredustelec(9112, "Chalk", SET_FINE, 250, 250, 250, 255, FURNACE, MORTAR)
            .setSmelting(MT.CaCO3, 2 * U3)
            .setMcfg(0, MT.CaCO3, 1 * U);
        MT.Dolomite = MT.oredustcent(9163, "Dolomite", SET_FLINT, 225, 205, 205, 255, FURNACE, MORTAR)
            .setSmelting(MT.CaCO3, U2)
            .setMcfg(0, MT.CaCO3, 1 * U, MT.MgCO3, 1 * U);
        // CaMg(CO3)2
        MT.Asbestos = MT
            .oredustelec(
                9103,
                "Asbestos",
                SET_LAPIS,
                230,
                230,
                230,
                255,
                FURNACE,
                MORTAR,
                PLATES,
                INGOTS,
                MELTING,
                EXTRUDER,
                EXTRUDER_SIMPLE,
                "Chrysotile")
            .uumMcfg(0, MT.Mg, 3 * U, MT.SiO2, 6 * U, MT.H2O, 6 * U, MT.O, 3 * U);
        // Mg3Si2O5(OH)4
        MT.Talc = MT.oredustelec(9169, "Talc", SET_DULL, 95, 145, 95, 255, "Soapstone")
            .uumMcfg(0, MT.Mg, 3 * U, MT.SiO2, 12 * U, MT.H2O, 3 * U, MT.O, 3 * U);
        // H2Mg3(SiO3)4
        MT.Pyrite = MT
            .oredustdcmp(
                9125,
                "Pyrite",
                SET_SHINY,
                255,
                230,
                80,
                255,
                G_GEM_ORES,
                BLACKLISTED_SMELTER,
                MORTAR,
                MAGNETIC_PASSIVE)
            .uumMcfg(0, MT.Fe, 1 * U, MT.S, 2 * U)
            .aspects(TC.IGNIS, 1, TC.METALLUM, 1, TC.STRONTIO, 1)
            .qual(0)
            .addSourceOf(MT.Fe);
        MT.PotassiumFeldspar = MT.oredustelec(9140, "Potassium Feldspar", SET_FINE, 120, 40, 40, 255)
            .uumMcfg(0, MT.K, 2 * U, MT.Al2O3, 5 * U, MT.SiO2, 18 * U, MT.O, 1 * U);
        MT.Biotite = MT.oredustelec(9141, "Biotite", SET_METALLIC, 20, 30, 20, 255)
            .setMcfg(0, MT.K, 2 * U, MT.Mg, 6 * U, MT.Al2O3, 15 * U, MT.F, 4 * U, MT.SiO2, 18 * U)
            .addSourceOf(MT.Ar, MT.K, MT.F, MT.Al);
        // releases Argon when heated.
        MT.Emery = MT.oredust(9183, "Emery", SET_STONE, 128, 128, 128, 255)
            .aspects(TC.TERRA, 1);
    }
}
