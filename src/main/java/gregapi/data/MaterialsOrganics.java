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
 * Woods, Waxes, biological Materials and Foods.
 * <p>
 * Loaded as the "Organics" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsOrganics implements IMaterialCategory {

    @Override
    public String getName() {
        return "Organics";
    }

    @Override
    public void load() {
        MT.Bark = MT
            .dust(8275, "Bark", SET_ROUGH, 80, 40, 0, 255, TICKS_PER_SMELT / 2, WOOD, MORTAR, FLAMMABLE, APPROXIMATE)
            .uumMcfg(0, MT.C, 6 * U, MT.H2O, 15 * U)
            .aspects(TC.ARBOR, 1)
            .setBurning(MT.Ash, U9)
            .setSmelting(MT.Ash, U4)
            .heat(400, 500);
        MT.Wood = MT.wood(8221, "Wood", 100, 50, 0, 255, TICKS_PER_SMELT / 2, FLAMMABLE, APPROXIMATE)
            .uumMcfg(0, MT.C, 6 * U, MT.H2O, 15 * U)
            .aspects(TC.ARBOR, 1)
            .setBurning(MT.Ash, U9)
            .setSmelting(MT.Ash, U4)
            .qual(1, 2.0, 16, 0)
            .heat(400, 500);
        MT.WoodTreated = MT
            .wood(8222, "WoodTreated", 80, 40, 0, 255, TICKS_PER_SMELT / 2, FLAMMABLE, COATED, "WoodSealed")
            .uumMcfg(0, MT.C, 6 * U, MT.H2O, 15 * U)
            .aspects(TC.ARBOR, 1, TC.FABRICO, 1)
            .setAllToTheOutputOf(MT.Wood)
            .qual(1, 3.0, 24, 0)
            .heat(500, 600)
            .setLocal("Treated Wood");
        MT.WoodPolished = MT.wood(8267, "WoodPolished", 60, 30, 0, 255, TICKS_PER_SMELT / 2, FLAMMABLE, COATED)
            .uumMcfg(0, MT.C, 6 * U, MT.H2O, 15 * U)
            .aspects(TC.ARBOR, 1, TC.FABRICO, 1)
            .setAllToTheOutputOf(MT.Wood)
            .qual(1, 3.0, 24, 0)
            .heat(500, 600)
            .setLocal("Polished Wood");
        MT.WoodRubber = MT.wood(8224, "WoodRubber", 180, 150, 0, 255, TICKS_PER_SMELT / 4, FLAMMABLE, APPROXIMATE)
            .uumMcfg(0, MT.C, 6 * U, MT.H2O, 15 * U)
            .aspects(TC.ARBOR, 1)
            .setBurning(MT.Ash, U4)
            .setSmelting(MT.Ash, U2)
            .qual(1, 1.5, 12, 0)
            .heat(350, 450)
            .setLocal("Rubber Wood");
        MT.Bamboo = MT.wood(8418, "Bamboo", 100, 200, 100, 255, TICKS_PER_SMELT / 2, FLAMMABLE, APPROXIMATE)
            .uumMcfg(0, MT.C, 6 * U, MT.H2O, 15 * U)
            .aspects(TC.HERBA, 1)
            .setBurning(MT.Ash, U4)
            .setSmelting(MT.Ash, U2)
            .qual(1, 2.0, 32, 0)
            .heat(350, 450);
        MT.Skyroot = MT.wood(8291, "Skyroot", 50, 80, 80, 255, TICKS_PER_SMELT / 2, FLAMMABLE, APPROXIMATE)
            .uumMcfg(0, MT.C, 6 * U, MT.H2O, 15 * U)
            .aspects(TC.ARBOR, 1, TC.VOLATUS, 1)
            .setBurning(MT.Ash, U4)
            .setSmelting(MT.Ash, U2)
            .qual(1, 4.0, 64, 0)
            .heat(350, 450);
        MT.Weedwood = MT.wood(8286, "Weedwood", 80, 50, 0, 255, TICKS_PER_SMELT / 2, FLAMMABLE, APPROXIMATE)
            .uumMcfg(0, MT.C, 6 * U, MT.H2O, 15 * U)
            .aspects(TC.ARBOR, 1, TC.MORTUUS, 1)
            .setBurning(MT.Ash, U4)
            .setSmelting(MT.Ash, U2)
            .qual(1, 2.0, 32, 0)
            .heat(350, 450);
        MT.Livingwood = MT.wood(8289, "Livingwood", 60, 30, 0, 255, TICKS_PER_SMELT, FLAMMABLE, APPROXIMATE, MAGICAL)
            .setMcfg(0, MT.C, 6 * U, MT.H2O, 15 * U)
            .aspects(TC.ARBOR, 1, TC.VICTUS, 1)
            .setBurning(MT.Ash, U4)
            .setSmelting(MT.Ash, U2)
            .qual(1, 4.0, 64, 0)
            .heat(350, 500);
        MT.Dreamwood = MT
            .wood(8290, "Dreamwood", 200, 240, 240, 255, TICKS_PER_SMELT * 2, FLAMMABLE, APPROXIMATE, MAGICAL)
            .setMcfg(0, MT.C, 6 * U, MT.H2O, 15 * U)
            .aspects(TC.ARBOR, 1, TC.SPIRITUS, 1)
            .setBurning(MT.Ash, U4)
            .setSmelting(MT.Ash, U2)
            .qual(1, 4.0, 128, 1)
            .heat(350, 550);
        MT.Shimmerwood = MT
            .wood(8414, "Shimmerwood", 234, 234, 234, 255, TICKS_PER_SMELT * 2, FLAMMABLE, APPROXIMATE, MAGICAL)
            .setMcfg(0, MT.C, 6 * U, MT.H2O, 15 * U)
            .aspects(TC.ARBOR, 1, TC.LUX, 1)
            .setBurning(MT.Ash, U4)
            .setSmelting(MT.Ash, U2)
            .qual(1, 4.0, 128, 1)
            .heat(350, 550);
        MT.Greatwood = MT.wood(8296, "Greatwood", 60, 30, 25, 255, TICKS_PER_SMELT * 2, FLAMMABLE, APPROXIMATE, MAGICAL)
            .setMcfg(0, MT.C, 6 * U, MT.H2O, 15 * U)
            .aspects(TC.ARBOR, 1)
            .setBurning(MT.Ash, U4)
            .setSmelting(MT.Ash, U2)
            .qual(1, 6.0, 64, 1)
            .heat(400, 600);
        MT.Silverwood = MT
            .wood(8297, "Silverwood", 234, 222, 210, 255, TICKS_PER_SMELT * 4, FLAMMABLE, APPROXIMATE, MAGICAL)
            .setMcfg(0, MT.C, 6 * U, MT.H2O, 15 * U)
            .aspects(TC.ARBOR, 1, TC.PRAECANTIO, 1)
            .setBurning(MT.Ash, 0)
            .setSmelting(MT.Ash, 0)
            .qual(1, 8.0, 128, 1)
            .heat(450, 650);
        MT.Peanutwood = MT.wood(8227, "Peanut Wood", 120, 60, 0, 255, TICKS_PER_SMELT / 2, FLAMMABLE, "Peanutwood")
            .uumMcfg(0, MT.C, 6 * U, MT.H2O, 15 * U)
            .aspects(TC.ARBOR, 1)
            .steal(MT.Wood)
            .heat(350, 450);
        MT.Marshmallow = MT.wood(9715, "Marshmallow", SET_FINE, 255, 220, 220, 255, FOOD)
            .aspects(TC.FAMES, 1)
            .qual(1, 3.0, 24, 0);
        MT.LiveRoot = MT
            .dustcent(8223, "LiveRoot", SET_WOOD, 220, 200, 0, 255, TICKS_PER_SMELT, WOOD, MORTAR, MAGICAL, MORTAR)
            .setMcfg(3, MT.Wood, 3 * U, MT.Ma, 1 * U)
            .aspects(TC.ARBOR, 1, TC.VICTUS, 1)
            .setLocal("Liveroot")
            .setBurning(MT.Ash, U9)
            .heat(1178, 2465);
        MT.PetrifiedWood = MT
            .create(
                8277,
                "Petrified Wood",
                SET_WOOD,
                110,
                50,
                35,
                255,
                TICKS_PER_SMELT / 4,
                G_STONE,
                STONE,
                WOOD,
                MORTAR,
                FLAMMABLE)
            .setMcfg(0, MT.Wood, 1 * U)
            .aspects(TC.ARBOR, 1, TC.TERRA, 1)
            .qual(1, 2.0, 24, 1)
            .heat(350, 450);
        MT.Wax = MT.wax(8235, "Wax", 250, 250, 250, 255)
            .aspects(TC.PERDITIO, 1)
            .heat(350);
        MT.WaxBee = MT.wax(8236, "WaxBee", 250, 220, 110, 255, FOOD, "BeesWax", "Beeswax", "BeeWax", "Beewax")
            .aspects(TC.BESTIA, 1)
            .heat(350)
            .setLocal("Bees Wax");
        MT.WaxRefractory = MT.wax(8237, "WaxRefractory", 250, 50, 50, 255, UNBURNABLE, "RefractoryWax", "Refractorywax")
            .aspects(TC.GELUM, 1)
            .heat(2600)
            .setLocal("Refractory Wax");
        MT.WaxParaffin = MT.wax(8238, "WaxParaffin", 210, 210, 250, 255, "ParaffinWax", "Paraffinwax")
            .aspects(TC.FABRICO, 1)
            .heat(400)
            .setLocal("Paraffin Wax");
        MT.WaxPlant = MT.wax(8239, "WaxPlant", 210, 250, 210, 255, FOOD)
            .aspects(TC.HERBA, 1)
            .heat(350)
            .setLocal("Plant Wax");
        MT.WaxMagic = MT.wax(8240, "WaxMagic", 200, 80, 200, 255, MAGICAL)
            .aspects(TC.PRAECANTIO, 1)
            .heat(350)
            .setLocal("Magic Wax");
        MT.WaxAmnesic = MT.wax(8280, "WaxAmnesic", 180, 70, 250, 255, MAGICAL)
            .aspects(TC.STRONTIO, 1)
            .heat(350)
            .setLocal("Amnesic Wax");
        MT.WaxSoulful = MT.wax(8281, "WaxSoulful", 90, 40, 10, 255, MAGICAL)
            .aspects(TC.SPIRITUS, 1)
            .heat(350)
            .setLocal("Soulful Wax");
        MT.Basalz = MT.blaze(8247, "Basalz", 100, 81, 81, MAGNETIC_ACTIVE, AUTO_COLLECTING)
            .aspects(TC.TERRA, 4);
        MT.Blitz = MT.blaze(8248, "Blitz", 250, 219, 0)
            .aspects(TC.AER, 4);
        MT.Blizz = MT.blaze(8210, "Blizz", 33, 200, 234)
            .aspects(TC.GELUM, 4);
        MT.Blaze = MT.blaze(8211, "Blaze", 255, 200, 0, UNBURNABLE, BURNING, MELTING, TICKS_PER_SMELT * 24)
            .aspects(TC.IGNIS, 4)
            .heat(4000);
        MT.Breeze = MT.blaze(8471, "Breeze", 170, 155, 203)
            .aspects(TC.VOLATUS, 4);
        MT.Ceramic = MT.dustelec(8225, "Ceramic", SET_ROUGH, 220, 130, 70, 255, MORTAR, PLATES, BRITTLE)
            .uumMcfg(18, MT.Al2O3, 5 * U, MT.SiO2, 12 * U)
            .heat(2000)
            .setCompressing(null, 0)
            .setBending(null, 0)
            .setForging(null, 0)
            .setSmashing(null, 0);
        MT.Brick = MT.create(9243, "Clay Brick", SET_ROUGH, 183, 90, 64, 255, MORTAR, BRITTLE, "Brick")
            .uumMcfg(1, MT.Ceramic, 1 * U)
            .heat(2000)
            .steal(MT.Ceramic)
            .setAllToTheOutputOf(MT.Ceramic);
        MT.Clay = MT.oredustdcmp(8215, "Clay", SET_ROUGH, 200, 200, 220, 255, MORTAR, PLATES)
            .uumMcfg(2, MT.Ceramic, 2 * U, MT.H2O, 1 * U)
            .heat(2000)
            .setSmelting(MT.Ceramic, U);
        // please do note that I had to make it easier to generify Clays without causing
        // too much transmutation, so the Clays are no longer accurate.
        MT.ClayBrown = MT.clay(8276, "ClayBrown", 230, 140, 75, MT.LiOH)
            .setLocal("Brown Clay");
        MT.ClayRed = MT.clay(8455, "ClayRed", 230, 40, 25, MT.KOH)
            .setLocal("Red Clay");
        MT.Bentonite = MT.clay(9153, "Bentonite", 255, 192, 4, MT.NaOH)
            .setLocal("Bentonite Clay");
        // (Na,Ca)0.33(Al,Mg)2(Si4O10)(OH)2
        // + n(H2O)
        MT.Palygorskite = MT.clay(9154, "Palygorskite", 114, 157, 179, MT.Mg, "FullersEarth")
            .setLocal("Palygorskite Clay");
        // (Al,Mg)2(Si4O10)(OH)
        // +
        // 4(H2O)
        MT.Kaolinite = MT.clay(9167, "Kaolinite", 245, 235, 235, MT.Ca)
            .setLocal("Kaolinite Clay");
        // Al2Si2O5(OH)4
        MT.Porcelain = MT.mixdust(8273, "Porcelain", SET_FINE, 235, 235, 245, 255, PLATES, BRITTLE, MORTAR)
            .uumMcfg(0, MT.Ceramic, 2 * U, MT.SiO2, 1 * U, MT.PotassiumFeldspar, 1 * U)
            .heat(1800)
            .setCompressing(null, 0)
            .setBending(null, 0)
            .setForging(null, 0)
            .setSmashing(null, 0);
        MT.Graphite = MT
            .oredustdcmp(9174, "Graphite", SET_DULL, 128, 128, 128, 255, BLACKLISTED_SMELTER, BRITTLE, MORTAR, STICKS)
            .uumMcfg(0, MT.C, 1 * U)
            .qual(1, 5.0, 32, 2)
            .setSmelting(MT.C, U2)
            .setBurning(MT.Ash, U4)
            .heat(1700, MT.C.mBoilingPoint);
        MT.Niter = MT
            .oredustcent(
                8206,
                "Niter",
                SET_FLINT,
                255,
                200,
                200,
                255,
                G_GEM_ORES,
                FLAMMABLE,
                BRITTLE,
                MORTAR,
                CRYSTAL,
                "Nitre")
            .uumMcfg(0, MT.KNO3, 1 * U, MT.NaNO3, 1 * U)
            .addSourceOf(MT.Na, MT.K)
            .heat(607);
        MT.Phosphorus = MT
            .cent(
                8208,
                "Phosphorus",
                SET_FLINT,
                255,
                255,
                0,
                255,
                G_GEM_ORES,
                FLAMMABLE,
                BRITTLE,
                MORTAR,
                EXPLOSIVE,
                "Phosphorous")
            .uumMcfg(0, MT.Ca, 3 * U, MT.PO4, 2 * U)
            .addSourceOf(MT.P);
        MT.PhosphorusBlue = MT
            .cent(
                8458,
                "Blue Phosphorus",
                SET_FLINT,
                155,
                227,
                228,
                255,
                G_GEM_ORES,
                FLAMMABLE,
                BRITTLE,
                MORTAR,
                EXPLOSIVE)
            .uumMcfg(0, MT.Ca, 3 * U, MT.PO4, 2 * U)
            .addSourceOf(MT.P);
        MT.PhosphorusRed = MT
            .cent(8459, "Red Phosphorus", SET_FLINT, 119, 4, 14, 255, G_GEM_ORES, FLAMMABLE, BRITTLE, MORTAR, EXPLOSIVE)
            .uumMcfg(0, MT.Ca, 3 * U, MT.PO4, 2 * U)
            .addSourceOf(MT.P);
        MT.PhosphorusWhite = MT
            .cent(
                8460,
                "White Phosphorus",
                SET_FLINT,
                236,
                234,
                221,
                255,
                G_GEM_ORES,
                FLAMMABLE,
                BRITTLE,
                MORTAR,
                EXPLOSIVE)
            .uumMcfg(0, MT.Ca, 3 * U, MT.PO4, 2 * U)
            .addSourceOf(MT.P);
        MT.Apatite = MT
            .elec(
                8209,
                "Apatite",
                SET_DIAMOND,
                120,
                180,
                250,
                255,
                G_GEM_ORES,
                FLAMMABLE,
                BRITTLE,
                MORTAR,
                CRYSTAL,
                CRYSTALLISABLE)
            .uumMcfg(0, MT.Ca, 5 * U, MT.PO4, 3 * U, MT.Cl, 1 * U)
            .addSourceOf(MT.P)
            .aspects(TC.MESSIS, 2);
        MT.Phosphorite = MT
            .elec(
                8226,
                "Phosphorite",
                SET_DIAMOND,
                50,
                50,
                65,
                255,
                G_GEM_ORES,
                FLAMMABLE,
                BRITTLE,
                MORTAR,
                CRYSTAL,
                CRYSTALLISABLE)
            .uumMcfg(0, MT.Ca, 5 * U, MT.PO4, 3 * U, MT.F, 1 * U)
            .addSourceOf(MT.P, MT.F)
            .aspects(TC.MESSIS, 2);
        MT.Paper = MT.dust(8216, "Paper", SET_PAPER, 250, 250, 250, 255, TICKS_PER_SMELT / 8, MULTIPLATES, MORTAR)
            .aspects(TC.COGNITIO, 1)
            .setBurning(MT.Ash, U9);
        MT.Rubber = MT
            .create(
                8217,
                "Rubber",
                SET_RUBBER,
                20,
                20,
                20,
                255,
                G_INGOT_MACHINE,
                APPROXIMATE,
                FLAMMABLE,
                EXTRUDER,
                EXTRUDER_SIMPLE,
                WIRES,
                MORTAR,
                BOUNCY,
                STRETCHY,
                FURNACE)
            .uumMcfg(0, MT.C, 5 * U, MT.H, 8 * U)
            .aspects(TC.MOTUS, 2)
            .heat(410)
            .setBurning(MT.Ash, U9)
            .setSmelting(null, 2 * U3)
            .qual(1, 3.0, 256, 0);
        MT.Plastic = MT
            .create(
                8218,
                "Plastic",
                SET_DULL,
                200,
                200,
                200,
                255,
                G_INGOT_MACHINE,
                APPROXIMATE,
                FLAMMABLE,
                EXTRUDER,
                EXTRUDER_SIMPLE,
                WIRES,
                MORTAR,
                BOUNCY,
                BRITTLE,
                FURNACE)
            .uumMcfg(0, MT.C, 1 * U, MT.H, 2 * U)
            .aspects(TC.MOTUS, 2)
            .heat(423)
            .setBurning(MT.Ash, U9)
            .setSmelting(null, 2 * U3)
            .qual(1, 3.0, 256, 1);
        MT.Teflon = MT
            .create(
                8196,
                "Teflon",
                SET_DULL,
                80,
                80,
                80,
                255,
                G_INGOT_MACHINE,
                APPROXIMATE,
                FLAMMABLE,
                EXTRUDER,
                EXTRUDER_SIMPLE,
                WIRES,
                MORTAR,
                BOUNCY,
                BRITTLE,
                FURNACE,
                "Polymer",
                "PTFE")
            .uumMcfg(0, MT.C, 1 * U, MT.H, 2 * U)
            .aspects(TC.MOTUS, 2)
            .heat(423)
            .setBurning(MT.Ash, U9)
            .setSmelting(null, 2 * U3)
            .qual(1, 3.0, 256, 1);
        MT.PTFE = MT.Teflon;
        MT.PVC = MT
            .create(
                8197,
                "PVC",
                SET_DULL,
                250,
                250,
                50,
                255,
                G_INGOT_MACHINE,
                APPROXIMATE,
                FLAMMABLE,
                EXTRUDER,
                EXTRUDER_SIMPLE,
                WIRES,
                MORTAR,
                BOUNCY,
                BRITTLE,
                FURNACE)
            .uumMcfg(0, MT.C, 1 * U, MT.H, 2 * U)
            .aspects(TC.MOTUS, 2)
            .heat(423)
            .setBurning(MT.Ash, U9)
            .setSmelting(null, 2 * U3)
            .qual(1, 3.0, 256, 1);
        MT.Bakelite = MT
            .create(
                8198,
                "Bakelite",
                SET_DULL,
                201,
                57,
                64,
                255,
                G_INGOT_MACHINE,
                APPROXIMATE,
                FLAMMABLE,
                EXTRUDER,
                EXTRUDER_SIMPLE,
                WIRES,
                MORTAR,
                BOUNCY,
                BRITTLE,
                FURNACE)
            .uumMcfg(0, MT.C, 1 * U, MT.H, 2 * U)
            .aspects(TC.MOTUS, 2)
            .heat(423)
            .setBurning(MT.Ash, U9)
            .setSmelting(null, 2 * U3)
            .qual(1, 3.0, 256, 1);
        MT.Polycarbonate = MT
            .create(
                8199,
                "Hard Plastic",
                SET_DULL,
                180,
                180,
                180,
                255,
                G_INGOT_MACHINE,
                APPROXIMATE,
                FLAMMABLE,
                EXTRUDER,
                EXTRUDER_SIMPLE,
                WIRES,
                MORTAR,
                BOUNCY,
                BRITTLE,
                FURNACE,
                "Polycarbonate")
            .uumMcfg(0, MT.C, 1 * U, MT.H, 2 * U)
            .aspects(TC.MOTUS, 2)
            .heat(423)
            .setBurning(MT.Ash, U9)
            .setSmelting(null, 2 * U3)
            .qual(1, 3.0, 256, 1);
        MT.Bone = MT.oredustelec(8219, "Bone", SET_DULL, 250, 250, 250, 255, MORTAR, "Fossil")
            .uumMcfg(8, MT.Ca, 1 * U)
            .aspects(TC.MORTUUS, 2, TC.CORPUS, 1)
            .qual(1, 4.0, 64, 1);
        MT.BoneWither = MT.Bone;
        MT.SlimyBone = MT.gem(8287, "Slimy Bone", SET_DULL, 230, 250, 230, 255, MORTAR)
            .uumMcfg(8, MT.Ca, 1 * U)
            .aspects(TC.MORTUUS, 2, TC.LIMUS, 1)
            .qual(1, 5.0, 128, 1);
        MT.Gunpowder = MT.dust(8220, "Gunpowder", SET_DULL, 128, 128, 128, 255, EXPLOSIVE, FLAMMABLE)
            .uumMcfg(4, MT.C, 2 * U, MT.S, 1 * U, MT.NaNO3, 1 * U)
            .aspects(TC.PERDITIO, 3, TC.IGNIS, 4)
            .setBurning(MT.Ash, U9);
        MT.Dynamite = MT.dust(8249, "Dynamite", SET_ROUGH, 111, 131, 111, 255, EXPLOSIVE, FLAMMABLE)
            .uumMcfg(0, MT.Glyceryl, 1 * U, MT.Wood, 1 * U)
            .aspects(TC.PERDITIO, 4, TC.IGNIS, 3)
            .setBurning(MT.Ash, U9);
        MT.Asphalt = MT
            .dust(8266, "Asphalt", SET_ROUGH, 88, 88, 99, 255, FURNACE, MELTING, EXTRUDER, EXTRUDER_SIMPLE, MOLTEN)
            .aspects(TC.TERRA, 1, TC.ITER, 1);
        MT.Tallow = MT.dust(8244, "Tallow", SET_FOOD, 220, 200, 100, 255, MELTING, MOLTEN)
            .aspects(TC.CORPUS, 2, TC.HUMANUS, 1, TC.PRAECANTIO, 1)
            .heat(350)
            .setLocal("Magic Tallow");
        MT.Leather = MT.create(8241, "Leather", SET_ROUGH, 141, 65, 37, 255, FLAMMABLE)
            .aspects(TC.PANNUS, 1, TC.TUTAMEN, 1)
            .setBurning(MT.Ash, U9)
            .setSmelting(MT.Ash, U9);
        MT.Indigo = MT.dust(8228, "Indigo", SET_LEAF, 255, 128, 255, 255, FLAMMABLE)
            .aspects(TC.SENSUS, 1);
        MT.MeatCooked = MT.meat(9701, "MeatCooked", 150, 60, 20, 255, "Meat")
            .aspects(TC.CORPUS, 2)
            .heat(477, 550)
            .setLocal("Cooked Meat");
        MT.MeatRaw = MT.meat(9700, "MeatRaw", 255, 100, 100, 255, FURNACE)
            .aspects(TC.CORPUS, 1)
            .heat(477, 550)
            .setLocal("Raw Meat")
            .setSmelting(MT.MeatCooked, U)
            .setForging(MT.MeatCooked, U);
        MT.MeatRotten = MT.meat(9710, "MeatRotten", 255, 150, 100, 255, ROTTEN)
            .aspects(TC.CORPUS, 1, TC.MORTUUS, 1)
            .heat(477, 550)
            .setLocal("Rotten Meat");
        MT.FishCooked = MT.meat(9711, "FishCooked", 150, 120, 20, 255)
            .aspects(TC.CORPUS, 2)
            .heat(477, 550)
            .setLocal("Cooked Fishmeal");
        MT.FishRaw = MT.meat(9712, "FishRaw", 255, 150, 100, 255, FURNACE)
            .aspects(TC.CORPUS, 1)
            .heat(477, 550)
            .setLocal("Raw Fishmeal")
            .setSmelting(MT.FishCooked, U)
            .setForging(MT.FishCooked, U);
        MT.FishRotten = MT.meat(9713, "FishRotten", 220, 200, 100, 255, ROTTEN)
            .aspects(TC.CORPUS, 1, TC.MORTUUS, 1)
            .heat(477, 550)
            .setLocal("Rotten Fishmeal");
        MT.Wheat = MT.grain(9702, "Wheat", 255, 255, 196, 255, "Flour");
        MT.Barley = MT.grain(9704, "Barley", 196, 255, 196, 255);
        MT.Rye = MT.grain(9705, "Rye", 255, 230, 180, 255);
        MT.Rice = MT.grain(9706, "Rice", 252, 252, 240, 255);
        MT.Oat = MT.grain(9707, "Oat", 240, 240, 222, 255, "Oats");
        MT.OatAbyssal = MT.grain(9719, "Abyssal Oat", 133, 62, 25, 255, "AbyssalOats");
        MT.Corn = MT.grain(9708, "Corn", 250, 240, 111, 255);
        MT.Potato = MT.dustfood(9709, "Potato", SET_POWDER, 240, 240, 164, 255)
            .aspects(TC.MESSIS, 2)
            .setBurning(MT.Ash, U9);
        MT.Tofu = MT.dustfood(9778, "Tofu", SET_FOOD, 222, 222, 222, 255, INGOTS, MELTING, EXTRUDER, EXTRUDER_SIMPLE)
            .aspects(TC.FAMES, 1, TC.HERBA, 1)
            .heat(422, 500);
        MT.SoylentGreen = MT
            .dustfood(9779, "Soylent Green", SET_FOOD, 0, 222, 0, 255, INGOTS, MELTING, EXTRUDER, EXTRUDER_SIMPLE)
            .aspects(TC.FAMES, 1, TC.CORPUS, 1)
            .heat(422, 500)
            .setLocal("Emerald Green");
        MT.Cheese = MT.orefood(9780, "Cheese", 255, 234, 0, 255, INGOTS, MELTING, EXTRUDER, EXTRUDER_SIMPLE, FURNACE)
            .aspects(TC.FAMES, 1)
            .heat(320, 500);
        MT.Chili = MT.dustfood(9781, "Chili", 200, 0, 0, 255)
            .aspects(TC.IGNIS, 1);
        MT.Cocoa = MT.dustfood(9782, "Cocoa", 190, 95, 0, 255)
            .aspects(TC.SANO, 1);
        MT.Chocolate = MT
            .mixfood(9783, "Chocolate", 100, 50, 0, 255, FURNACE, INGOTS, MELTING, EXTRUDER, EXTRUDER_SIMPLE)
            .setMcfg(0, MT.Cocoa, 1 * U, MT.Sugar, 1 * U)
            .aspects(TC.SANO, 1, TC.FAMES, 1)
            .heat(CS.C + 40, 400);
        MT.Coffee = MT.dustfood(9784, "Coffee", 150, 75, 0, 255, "CoffeeDust")
            .aspects(TC.MOTUS, 1);
        MT.Cinnamon = MT.dustfood(9785, "Cinnamon", 122, 83, 53, 255, TICKS_PER_SMELT / 2)
            .aspects(TC.FAMES, 1);
        MT.Nutmeg = MT.dustfood(9786, "Nutmeg", 240, 220, 180, 255, TICKS_PER_SMELT / 2)
            .aspects(TC.FAMES, 1);
        MT.Peanut = MT.dustfood(9795, "Peanut", 240, 210, 160, 255, TICKS_PER_SMELT / 2)
            .aspects(TC.FAMES, 1);
        MT.Hazelnut = MT.dustfood(9796, "Hazelnut", 240, 200, 140, 255, TICKS_PER_SMELT / 2)
            .aspects(TC.FAMES, 1);
        MT.Pistachio = MT.dustfood(9797, "Pistachio", 200, 250, 140, 255, TICKS_PER_SMELT / 2)
            .aspects(TC.FAMES, 1);
        MT.Almond = MT.dustfood(9714, "Almond", 200, 160, 140, 255, TICKS_PER_SMELT / 2)
            .aspects(TC.FAMES, 1);
        MT.PEZ = MT.orefood(9716, "PEZ", 210, 210, 210, 255)
            .aspects(TC.FAMES, 1)
            .qual(2, 8.0, 512, 3);
        MT.Licorice = MT.orefood(9717, "Licorice", 30, 30, 30, 255)
            .aspects(TC.FAMES, 1)
            .qual(2, 6.0, 128, 2);
        MT.Nougat = MT.orefood(9718, "Nougat", 240, 200, 150, 255)
            .aspects(TC.FAMES, 1);
        MT.PepperBlack = MT.dustfood(9788, "PepperBlack", 40, 40, 40, 255, "Pepper")
            .aspects(TC.FAMES, 1)
            .setLocal("Black Pepper");
        MT.Curry = MT.dustfood(9789, "Curry", 240, 190, 100, 255)
            .aspects(TC.FAMES, 1);
        MT.Milk = MT.food(9790, "Milk", SET_FINE, 254, 254, 254, 255, G_CONTAINERS, DUSTS)
            .aspects(TC.SANO, 2)
            .heat(CS.C, CS.C + 100);
        MT.Butter = MT.food(9798, "Butter", 230, 230, 100, 255, INGOTS, MELTING)
            .setMcfg(1, MT.Milk, 1 * U)
            .aspects(TC.FAMES, 3)
            .heat(CS.C + 40, 500);
        MT.ButterSalted = MT.food(9799, "Salted Butter", 230, 230, 110, 255, INGOTS, MELTING)
            .setMcfg(1, MT.Milk, 1 * U, MT.NaCl, 1 * U)
            .aspects(TC.FAMES, 3)
            .heat(CS.C + 40, 500);
        MT.Honey = MT.orefood(9791, "Honey", 250, 200, 0, 255, (Object[]) G_CONTAINERS)
            .aspects(TC.SANO, 1)
            .heat(CS.C, CS.C + 100);
        MT.Honeydew = MT.orefood(9793, "Honeydew", 210, 100, 0, 255, (Object[]) G_CONTAINERS)
            .aspects(TC.SANO, 1)
            .heat(CS.C, CS.C + 100);
        MT.Tea = MT.dustfood(9792, "Tea", 100, 250, 100, 255)
            .aspects(TC.SANO, 1);
        MT.Mint = MT.dustfood(9794, "Mint", 150, 250, 150, 255)
            .aspects(TC.HERBA, 1);
    }
}
