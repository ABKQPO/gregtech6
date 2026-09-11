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
 * The Materials of the Rocks the world generation places.
 * <p>
 * Loaded as the "Rock Materials" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsRockMaterials implements IMaterialCategory {

    @Override
    public String getName() {
        return "Rock Materials";
    }

    @Override
    public void load() {
        MT.STONES.SpaceRock = MT.stone(

            8512,

            "Space Stone",

            SET_SPACE,

            99,

            99,

            99,

            255,

            MELTING,

            MOLTEN)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 32, 1)

            .setGenerifying(MT.Stone)

            .addSourceOf(MT.He, MT.He_3)

            .setLocal("Space");
        MT.STONES.MoonRock = MT.stone(8513, "Moon Stone", 189, 189, 189, 255, MELTING, MOLTEN)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 32, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Moon");
        MT.STONES.MoonTurf = MT.stone(8514, "Moon Turf", 207, 207, 207, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 3.0, 16, 1)

            .setGenerifying(MT.Stone)

            .addSourceOf(MT.He, MT.He_3);
        MT.STONES.MarsRock = MT.stone(8515, "Mars Stone", 189, 77, 77, 255, MELTING, MOLTEN)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 32, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Mars");
        MT.STONES.MarsSand = MT.stone(8516, "Mars Sand", 207, 66, 66, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 3.0, 16, 1)

            .setGenerifying(MT.Stone);
        MT.STONES.SkyStone = MT.stonecent(8528, "Sky Stone", 81, 92, 96, 255)

            .setMcfg(0, MT.Peridot, 2 * U, MT.RareEarth, 1 * U, MT.MeteoricIron, 1 * U, MT.Obsidian, 5 * U)

            .aspects(TC.VOLATUS, 1)

            .qual(1, 5.0, 64, 2)

            .setGenerifying(MT.Stone)

            .heat(2200);
        MT.STONES.Holystone = MT.stone(8522, "Holystone", 172, 172, 172, 255)
            .aspects(TC.LUX, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .heat(2000);
        MT.STONES.Livingrock = MT.stone(8521, "Livingrock", 195, 205, 195, 255)
            .aspects(TC.VICTUS, 1)

            .qual(1, 5.0, 128, 2)

            .setGenerifying(MT.Stone)

            .heat(1800);
        MT.STONES.Deadrock = MT.stone(8523, "Deadrock", 153, 153, 168, 255, UNBURNABLE)
            .aspects(TC.MORTUUS, 1)

            .qual(1, 5.0, 128, 2)

            .setGenerifying(MT.Stone)

            .heat(1800);
        MT.STONES.Betweenstone = MT.stone(8519, "Betweenstone", 100, 160, 110, 255)
            .aspects(TC.MORTUUS, 1)

            .qual(1, 4.0, 32, 1)

            .setGenerifying(MT.Stone)

            .heat(1000);
        MT.STONES.Pitstone = MT.stone(8520, "Pitstone", 40, 50, 30, 255)
            .aspects(TC.TENEBRAE, 1)

            .qual(1, 4.0, 32, 1)

            .setGenerifying(MT.Stone)

            .heat(1200);
        MT.STONES.Cragrock = MT.stone(8524, "Cragrock", 93, 96, 107, 255)
            .aspects(TC.VENEMUM, 1)

            .qual(1, 4.0, 32, 1)

            .setGenerifying(MT.Stone)

            .heat(1400);
        MT.STONES.Templerock = MT.brick(8525, "Templerock", 171, 158, 106, 255, WITHER_PROOF)
            .aspects(TC.VINCULUM, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .heat(1600);
        MT.STONES.Mazestone = MT.brick(8526, "Mazestone", 110, 120, 110, 255, WITHER_PROOF)
            .aspects(TC.ITER, 1)

            .qual(1, 5.0, 128, 3)

            .setGenerifying(MT.Stone)

            .heat(2000);
        MT.STONES.Castlerock = MT.brick(8527, "Castlerock", 198, 185, 186, 255, WITHER_PROOF)
            .aspects(TC.TUTAMEN, 1)

            .qual(1, 5.0, 128, 3)

            .setGenerifying(MT.Stone)

            .heat(2000);
        MT.STONES.Umber = MT.stone(8517, "Umber", 111, 77, 11, 255)
            .aspects(TC.BESTIA, 1)

            .qual(1, 3.0, 32, 1)

            .setGenerifying(MT.Stone)

            .heat(987)

            .setLocal("Umberstone");
        MT.STONES.Shale = MT.stonecent(9190, "Shale", 142, 142, 168, 255)

            .setMcfg(0, MT.CaCO3, 2 * U, MT.MilkyQuartz, 1 * U, MT.Clay, 1 * U)

            .aspects(TC.TERRA, 1)

            .qual(1, 2.0, 16, 0)

            .setGenerifying(MT.Stone);
        MT.STONES.Redrock = MT.stonecent(8509, "Redrock", 255, 80, 50, 255, "RedRock")

            .setMcfg(0, MT.CaCO3, 2 * U, MT.Flint, 1 * U, MT.ClayRed, 1 * U)

            .aspects(TC.TERRA, 1)

            .qual(1, 2.5, 16, 1)

            .setGenerifying(MT.Stone);
        MT.STONES.Komatiite = MT.stonecent(9177, "Komatiite", 190, 190, 105, 255, UNBURNABLE)

            .setMcfg(0, MT.Peridot, 1 * U, MT.MgCO3, 2 * U, MT.Flint, 6 * U, MT.DarkAsh, 3 * U)

            .aspects(TC.SANO, 1)

            .qual(1, 3.0, 32, 2)

            .setGenerifying(MT.Stone)

            .heat(1673);
        MT.STONES.Pumice = MT.stonecent(9000, "Pumice", SET_DULL, 220, 216, 127, 255, UNBURNABLE)

            .setMcfg(0, MT.Peridot, 3 * U, MT.MgCO3, 2 * U, MT.Flint, 4 * U, MT.DarkAsh, 2 * U)

            .aspects(TC.VITREUS, 1)

            .qual(1, 3.0, 32, 2)

            .setGenerifying(MT.Stone)

            .heat(1673);
        MT.STONES.Gabbro = MT.stonecent(9176, "Gabbro", 65, 60, 60, 255, UNBURNABLE)

            .setMcfg(0, MT.Peridot, 1 * U, MT.CaCO3, 3 * U, MT.Flint, 8 * U, MT.DarkAsh, 4 * U)

            .aspects(TC.TENEBRAE, 1)

            .qual(1, 3.0, 32, 2)

            .setGenerifying(MT.Stone)

            .heat(1673);
        MT.STONES.Basalt = MT.stonecent(8505, "Basalt", 60, 50, 50, 255, UNBURNABLE, UNRECYCLABLE)

            .setMcfg(0, MT.Peridot, 1 * U, MT.CaCO3, 3 * U, MT.Flint, 8 * U, MT.DarkAsh, 4 * U)

            .aspects(TC.TENEBRAE, 1)

            .qual(1, 3.0, 32, 2)

            .setGenerifying(MT.Stone)

            .heat(1673);
        MT.STONES.Marble = MT.stonecent(8506, "Marble", 200, 200, 200, 255)
            .setMcfg(0, MT.Mg, 1 * U, MT.CaCO3, 7 * U)

            .aspects(TC.PERFODIO, 1)

            .qual(1, 2.5, 16, 1)

            .setGenerifying(MT.Stone)

            .setSmelting(MT.CaCO3, 2 * U3);
        MT.STONES.Limestone = MT.stonecent(9189, "Limestone", 230, 200, 130, 255, BETWEENLANDS)
            .setMcfg(0, MT.CaCO3, 1 * U)

            .aspects(TC.TERRA, 1)

            .qual(1, 2.5, 16, 1)

            .setGenerifying(MT.Stone)

            .setSmelting(MT.CaCO3, U2);
        MT.STONES.Greenschist = MT.stone(9171, "Greenschist", 105, 190, 105, 255, MD.UB)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.0, 24, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Green Schist");
        MT.STONES.Blueschist = MT.stone(9184, "Blueschist", 105, 105, 190, 255, MD.UB)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.0, 24, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Blue Schist");
        MT.STONES.Grayschist = MT.stone(9244, "Grayschist", 145, 140, 145, 255, MD.EB)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.0, 24, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Gray Schist");
        MT.STONES.Pinkschist = MT.stone(9245, "Pinkschist", 220, 195, 195, 255, MD.PFAA)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.0, 24, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Pink Schist");
        MT.STONES.Gneiss = MT.stone(9170, "Gneiss", 255, 201, 134, 255)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.0, 24, 1)

            .setGenerifying(MT.Stone);
        MT.STONES.Kimberlite = MT.stone(9218, "Kimberlite", 100, 70, 10, 255)
            .aspects(TC.VITREUS, 1)

            .qual(1, 2.0, 24, 2)

            .setGenerifying(MT.Stone);
        MT.STONES.Quartzite = MT.stone(

            9180,

            "Quartzite",

            SET_QUARTZ,

            230,

            205,

            205,

            255,

            G_QUARTZ_ORES,

            CRYSTALLISABLE,

            QUARTZ,

            BLACKLISTED_SMELTER)
            .aspects(TC.POTENTIA, 1)

            .qual(1, 1.7, 32, 1)

            .setGenerifying(MT.Stone)

            .setSmelting(MT.SiO2, U);
        MT.STONES.GraniteRed = MT.stoneelec(8507, "GraniteRed", 160, 60, 70, 255)

            .setMcfg(0, MT.Biotite, 1 * U, MT.PotassiumFeldspar, 1 * U, MT.Flint, 1 * U)

            .aspects(TC.TUTAMEN, 1)

            .qual(1, 3.0, 64, 3)

            .setGenerifying(MT.Stone)

            .heat(1500)

            .setLocal("Red Granite");
        MT.STONES.GraniteBlack = MT.stoneelec(8508, "GraniteBlack", 20, 20, 20, 255)

            .setMcfg(0, MT.Biotite, 1 * U, MT.PotassiumFeldspar, 1 * U, MT.Flint, 1 * U)

            .aspects(TC.TUTAMEN, 1)

            .qual(1, 3.0, 64, 3)

            .setGenerifying(MT.Stone)

            .heat(1500)

            .setLocal("Black Granite");
        MT.STONES.Granite = MT.stoneelec(8518, "Granite", 160, 120, 130, 255)

            .setMcfg(0, MT.Biotite, 1 * U, MT.PotassiumFeldspar, 1 * U, MT.Flint, 1 * U)

            .aspects(TC.TERRA, 1)

            .qual(1, 3.0, 64, 1)

            .setGenerifying(MT.Stone)

            .heat(1500);
        MT.STONES.Andesite = MT.stone(9188, "Andesite", 191, 191, 191, 255)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.5, 16, 1)

            .setGenerifying(MT.Stone);
        MT.STONES.Diorite = MT.stone(8511, "Diorite", 240, 240, 240, 255, UNBURNABLE)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.5, 16, 1)

            .setGenerifying(MT.Stone);
        MT.STONES.Blackstone = MT.brick(9223, "Blackstone", 30, 20, 20, 255, UNRECYCLABLE)
            .aspects(TC.TENEBRAE, 1)

            .qual(1, 5.0, 64, 1)

            .setGenerifying(MT.Stone);
        MT.STONES.Greywacke = MT.stone(9173, "Greywacke", 176, 176, 176, 255)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.0, 16, 1)

            .setGenerifying(MT.Stone);
        MT.STONES.Siltstone = MT.stone(9178, "Siltstone", 250, 205, 205, 255)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.0, 16, 0)

            .setGenerifying(MT.Stone);
        MT.STONES.Rhyolite = MT.stone(9179, "Rhyolite", 121, 121, 121, 255)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.0, 16, 1)

            .setGenerifying(MT.Stone);
        MT.STONES.Migmatite = MT.stone(9181, "Migmatite", 70, 40, 40, 255)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.0, 16, 1)

            .setGenerifying(MT.Stone);
        MT.STONES.Chert = MT.stone(9186, "Chert", 105, 10, 10, 255)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.0, 16, 0)

            .setGenerifying(MT.Stone);
        MT.STONES.Dacite = MT.stone(9187, "Dacite", 131, 131, 131, 255)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.0, 16, 1)

            .setGenerifying(MT.Stone);
        MT.STONES.Slate = MT.stone(9222, "Slate", 148, 151, 156, 255)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.0, 16, 0)

            .setGenerifying(MT.Stone);
        MT.STONES.Deepslate = MT.stone(9248, "Deepslate", 57, 59, 61, 255)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.0, 32, 1)

            .setGenerifying(MT.Stone);
        MT.STONES.Eclogite = MT.stone(9191, "Eclogite", 90, 40, 40, 255)
            .aspects(TC.TERRA, 1)

            .qual(1, 2.0, 16, 1)

            .setGenerifying(MT.Stone);
        MT.STONES.PhobosRock = MT.stone(9249, "PhobosRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Phobos");
        MT.STONES.DeimosRock = MT.stone(9250, "DeimosRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Deimos");
        MT.STONES.VenusRock = MT.stone(9251, "VenusRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Venus");
        MT.STONES.MercuryRock = MT.stone(9252, "MercuryRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Mercury");
        MT.STONES.CeresRock = MT.stone(9253, "CeresRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Ceres");
        MT.STONES.JupiterRock = MT.stone(9254, "JupiterRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Jupiter");
        MT.STONES.IoRock = MT.stone(9255, "IoRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Io");
        MT.STONES.EuropaRock = MT.stone(9256, "EuropaRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Europa");
        MT.STONES.GanymedeRock = MT.stone(9257, "GanymedeRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Ganymede");
        MT.STONES.CallistoRock = MT.stone(9258, "CallistoRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Callisto");
        MT.STONES.SaturnRock = MT.stone(9259, "SaturnRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Saturn");
        MT.STONES.RheaRock = MT.stone(9260, "RheaRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Rhea");
        MT.STONES.TitanRock = MT.stone(9261, "TitanRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Titan");
        MT.STONES.OberonRock = MT.stone(9262, "OberonRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Oberon");
        MT.STONES.IapetusRock = MT.stone(9263, "IapetusRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Iapetus");
        MT.STONES.UranusRock = MT.stone(9264, "UranusRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Uranus");
        MT.STONES.TitaniaRock = MT.stone(9265, "TitaniaRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Titania");
        MT.STONES.NeptuneRock = MT.stone(9266, "NeptuneRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Neptune");
        MT.STONES.TritonRock = MT.stone(9267, "TritonRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Triton");
        MT.STONES.PlutoRock = MT.stone(9268, "PlutoRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Pluto");
        MT.STONES.ErisRock = MT.stone(9269, "ErisRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Eris");
        MT.STONES.Kepler22bRock = MT.stone(9270, "Kepler22bRock", 189, 189, 189, 255)
            .aspects(TC.ALIENIS, 1)

            .qual(1, 5.0, 128, 1)

            .setGenerifying(MT.Stone)

            .setLocal("Kepler22b");;
    }
}
