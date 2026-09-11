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
 * Crystals, Coal, Glowstone, Quartz and the magical Materials.
 * <p>
 * Loaded as the "Crystals" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsCrystals implements IMaterialCategory {

    @Override
    public String getName() {
        return "Crystals";
    }

    @Override
    public void load() {
        MT.ArcaneAsh = MT.dust(8367, "Arcane Ashes", SET_FINE, 150, 50, 180, 255, MAGICAL, "ArcaneAsh")
            .aspects(TC.PRAECANTIO, 1, TC.IGNIS, 1);
        MT.ArcaneCompound = MT.dust(8366, "Arcane Compound", SET_ROUGH, 180, 140, 50, 255, MAGICAL, FURNACE)
            .aspects(TC.PRAECANTIO, 3)
            .setSmelting(MT.ArcaneAsh, U * 2);
        MT.Moonstone = MT.gem(8452, "Moonstone", SET_RUBY, 210, 210, 255, 255)
            .aspects(TC.ALIENIS, 1, TC.PRAECANTIO, 1, TC.VACUOS, 1)
            .qual(3, 14.0, 512, 4);
        MT.Sunstone = MT.gem(8453, "Sunstone", SET_RUBY, 255, 150, 0, 255)
            .aspects(TC.VITREUS, 1, TC.IGNIS, 3)
            .qual(3, 14.0, 512, 4);
        MT.Chimerite = MT.gem(8454, "Chimerite", SET_RUBY, 255, 255, 255, 255)
            .aspects(TC.SENSUS, 3, TC.PERMUTATIO, 1)
            .qual(3, 10.0, 256, 3)
            .setGenerifying(MT.Vinteum);
        MT.CrimsonMiddle = MT
            .gem(8282, "Crimson Middle", SET_DIAMOND, 240, 50, 50, 127, GLOWING, LIGHTING, MORTAR, BRITTLE)
            .lens(DYE_INDEX_Red)
            .aspects(TC.VITREUS, 2, TC.LUX, 2, TC.IGNIS, 2);
        MT.GreenMiddle = MT.gem(8283, "Green Middle", SET_DIAMOND, 50, 240, 50, 127, GLOWING, LIGHTING, MORTAR, BRITTLE)
            .lens(DYE_INDEX_Green)
            .aspects(TC.VITREUS, 2, TC.LUX, 2, TC.HERBA, 2);
        MT.AquaMiddle = MT.gem(8284, "Aqua Middle", SET_DIAMOND, 50, 50, 240, 127, GLOWING, LIGHTING, MORTAR, BRITTLE)
            .lens(DYE_INDEX_Blue)
            .aspects(TC.VITREUS, 2, TC.LUX, 2, TC.AQUA, 2);
        MT.Valonite = MT.gem(8285, "Valonite", SET_SHARDS, 255, 205, 240, 127)
            .lens(DYE_INDEX_Pink)
            .aspects(TC.VITREUS, 3, TC.LUCRUM, 4)
            .qual(3, 9.0, 2560, 3);
        MT.Scabyst = MT.gem(8288, "Scabyst", SET_SHARDS, 110, 165, 165, 127)
            .lens(DYE_INDEX_Cyan)
            .aspects(TC.VITREUS, 2, TC.SANO, 2);
        MT.Ambrosium = MT.gem(8293, "Ambrosium", SET_DIAMOND, 244, 242, 96, 127, CRYSTALLISABLE, GLOWING, LIGHTING)
            .lens(DYE_INDEX_Yellow)
            .aspects(TC.VITREUS, 2, TC.LUX, 2, TC.PRAECANTIO, 2)
            .qual(3, 4.0, 16, 2);
        MT.Continuum = MT.gem(8295, "Continuum", SET_RUBY, 222, 129, 40, 127, CRYSTALLISABLE)
            .lens(DYE_INDEX_Orange)
            .aspects(TC.VITREUS, 4, TC.NEBRISUM, 4)
            .qual(3, 4.0, 64, 3);
        MT.EnderAmethyst = MT.valgemelec(8329, "AmethystEnder", SET_FLINT, 210, 50, 210, 127)
            .lens(DYE_INDEX_Pink)
            .setMcfg(5, MT.SiO2, 4 * U, MT.Fe, 1 * U, MT.Ma, 1 * U)
            .aspects(TC.VITREUS, 4, TC.LUCRUM, 4, TC.ALIENIS, 2)
            .qual(3, 10.0, 2560, 3)
            .setGenerifying(MT.Amethyst)
            .setLocal("Ender Amethyst");
        MT.EnderPearl = MT
            .elec(
                8318,
                "EnderPearl",
                SET_SHINY,
                108,
                220,
                200,
                255,
                G_PEARL_TRANSPARENT,
                CRYSTAL,
                BRITTLE,
                MAGICAL,
                PEARL,
                MELTING,
                "Ender")
            .setMcfg(10, MT.Be, 1 * U, MT.K, 4 * U, MT.N, 5 * U, MT.Ma, 6 * U)
            .aspects(TC.ALIENIS, 4, TC.ITER, 4, TC.PRAECANTIO, 2)
            .qual(3, 1.0, 16, 1)
            .setLocal("Enderpearl")
            .heat(2723, 3785);
        MT.EnderEye = MT
            .cent(
                8319,
                "EnderEye",
                SET_SHINY,
                160,
                250,
                230,
                255,
                G_PEARL_TRANSPARENT,
                CRYSTAL,
                BRITTLE,
                MAGICAL,
                PEARL,
                MELTING)
            .setMcfg(9, MT.EnderPearl, 9 * U, MT.Blaze, 1 * U)
            .aspects(TC.SENSUS, 4, TC.ALIENIS, 4, TC.ITER, 4, TC.PRAECANTIO, 3, TC.IGNIS, 2)
            .qual(3, 1.0, 16, 1)
            .setLocal("Endereye")
            .heat(3447, 4978);
        MT.NetherStar = MT
            .crystal(
                8320,
                "Nether Star",
                SET_NETHERSTAR,
                255,
                255,
                255,
                255,
                BRITTLE,
                UNBURNABLE,
                MAGICAL,
                GLOWING,
                MELTING)
            .qual(3, 8.0, 5120, 4)
            .heat(3896, 5127);
        MT.Frezarite = MT
            .create(8391, "Frezarite", SET_NETHERSTAR, 255, 255, 255, 255, G_GEM, CRYSTAL, BRITTLE, MAGICAL)
            .aspects(TC.VITREUS, 3, TC.GELUM, 3)
            .qual(3, 4.0, 128, 2);
        MT.RedMeteor = MT.create(8392, "Red Meteor", SET_RUBY, 255, 60, 60, 255, G_GEM, MAGICAL, GLOWING, UNBURNABLE)
            .aspects(TC.VITREUS, 3, TC.ALIENIS, 3)
            .qual(3, 8.0, 512, 3);
        MT.Dilithium = MT.crystal(8317, "Dilithium", SET_DIAMOND, 153, 255, 255, 127, CRYSTALLISABLE, QUARTZ)
            .lens(DYE_INDEX_White)
            .setSmelting(null, 0);
        MT.Zircon = MT.valgemelec(8419, "Zircon", SET_EMERALD, 99, 24, 29, 255, WASHING_FIRESTONE)
            .lens(DYE_INDEX_Red)
            .uumMcfg(0, MT.Zr, 1 * U, MT.SiO2, 3 * U, MT.O, 2 * U)
            .aspects(TC.VITREUS, 4)
            .setSmelting(MT.Zr, U9)
            .qual(3, 8.0, 384, 2);
        MT.Azurite = MT
            .elec(8420, "Azurite", SET_QUARTZ, 109, 164, 247, 255, G_GEM_ORES, CRYSTAL, MORTAR, BRITTLE, FURNACE)
            .uumMcfg(0, MT.Cu, 3 * U, MT.CO3, 8 * U, MT.O, 1 * U, MT.H2O, 3 * U)
            .aspects(TC.SENSUS, 1)
            .setSmelting(MT.Cu, U9);
        MT.Eudialyte = MT.dcmp(8421, "Eudialyte", SET_LAPIS, 155, 96, 114, 255, G_GEM_ORES, CRYSTAL, MORTAR, BRITTLE)
            .setMcfg(
                0,
                MT.Zircon,
                18 * U,
                MT.MnO2,
                3 * U,
                MT.Na,
                15 * U,
                MT.Ca,
                6 * U,
                MT.Cl,
                U * 2,
                MT.SiO2,
                75 * U,
                MT.O,
                12 * U)
            .aspects(TC.VITREUS, 2);
        // Na15Ca6(Fe,Mn)3Zr3SiO(O,OH,H2O)3 (Si3O9)2(Si9O27)2(OH,Cl)2
        MT.Lazurite = MT
            .elec(
                8330,
                "Lazurite",
                SET_LAPIS,
                100,
                120,
                255,
                255,
                G_GEM_ORES,
                DENSEPLATES,
                CRYSTAL,
                CRYSTALLISABLE,
                MORTAR,
                BRITTLE)
            .uumMcfg(0, MT.Al2O3, 6 * U, MT.SiO2, 6 * U, MT.Ca, 8 * U, MT.Na, 8 * U)
            .aspects(TC.SENSUS, 1);
        MT.Sodalite = MT
            .elec(
                8331,
                "Sodalite",
                SET_LAPIS,
                20,
                20,
                255,
                255,
                G_GEM_ORES,
                DENSEPLATES,
                CRYSTAL,
                CRYSTALLISABLE,
                MORTAR,
                BRITTLE)
            .uumMcfg(0, MT.Al2O3, 3 * U, MT.SiO2, 3 * U, MT.Na, 4 * U, MT.Cl, 1 * U)
            .aspects(TC.SENSUS, 1);
        MT.Lapis = MT
            .cent(
                8332,
                "Lapis",
                SET_LAPIS,
                70,
                70,
                220,
                255,
                G_GEM_ORES,
                DENSEPLATES,
                CRYSTAL,
                CRYSTALLISABLE,
                MORTAR,
                BRITTLE)
            .uumMcfg(0, MT.Lazurite, 12 * U, MT.Sodalite, 2 * U, MT.Pyrite, 1 * U, MT.CaCO3, 1 * U)
            .aspects(TC.SENSUS, 1);
        MT.Charcoal = MT.coal(8336, "Charcoal", SET_LIGNITE, 100, 70, 70, 255, TICKS_PER_SMELT * 8)
            .setBurning(MT.Ash, U4)
            .uumMcfg(0, MT.C, 1 * U)
            .setSmelting(MT.C, U2)
            .heat(1700, MT.C.mBoilingPoint)
            .setDensity(0.929)
            .aspects(TC.POTENTIA, 2, TC.IGNIS, 2);
        MT.Coal = MT.coal(8334, "Coal", SET_LIGNITE, 70, 70, 70, 255, TICKS_PER_SMELT * 8)
            .setBurning(MT.DarkAsh, U4)
            .uumMcfg(0, MT.C, 1 * U)
            .setSmelting(MT.C, U2)
            .heat(1700, MT.C.mBoilingPoint)
            .setDensity(0.929)
            .aspects(TC.POTENTIA, 2, TC.IGNIS, 2);
        MT.CoalCoke = MT.coal(8349, "Coal Coke", SET_LIGNITE, 140, 140, 170, 255, TICKS_PER_SMELT * 16, "Coke")
            .setBurning(MT.DarkAsh, U9)
            .uumMcfg(0, MT.C, 1 * U)
            .setSmelting(MT.C, U)
            .heat(1700, MT.C.mBoilingPoint)
            .setDensity(0.929)
            .aspects(TC.POTENTIA, 3, TC.IGNIS, 1)
            .steal(MT.Coal);
        MT.Anthracite = MT.coal(8362, "Anthracite", SET_LIGNITE, 90, 90, 90, 255, TICKS_PER_SMELT * 24)
            .setBurning(MT.DarkAsh, U2)
            .uumMcfg(1, MT.C, 2 * U)
            .setSmelting(MT.C, U2)
            .heat(1700, MT.C.mBoilingPoint)
            .aspects(TC.POTENTIA, 3, TC.IGNIS, 3);
        MT.Prismane = MT.coal(8363, "Prismane", SET_LIGNITE, 115, 110, 110, 255, TICKS_PER_SMELT * 48)
            .setBurning(MT.DarkAsh, U)
            .uumMcfg(1, MT.C, 4 * U)
            .aspects(TC.POTENTIA, 4, TC.IGNIS, 4);
        MT.Lonsdaleite = MT.coal(8364, "Lonsdaleite", SET_DIAMOND, 140, 130, 130, 255, TICKS_PER_SMELT * 96)
            .setBurning(MT.DarkAsh, U * 2)
            .uumMcfg(1, MT.C, 8 * U)
            .aspects(TC.POTENTIA, 6, TC.IGNIS, 6);
        MT.Lignite = MT.coal(8337, "Lignite", SET_LIGNITE, 100, 70, 70, 255, TICKS_PER_SMELT * 4)
            .setBurning(MT.DarkAsh, U4)
            .setMcfg(7, MT.C, 2 * U, MT.H2O, 4 * U, MT.DarkAsh, 1 * U)
            .setDensity(0.865)
            .setLocal("Lignite Coal");
        MT.LigniteCoke = MT.coal(8365, "Lignite Coke", SET_LIGNITE, 140, 100, 100, 255, TICKS_PER_SMELT * 8)
            .setBurning(MT.DarkAsh, U9)
            .setMcfg(7, MT.C, 2 * U, MT.DarkAsh, 1 * U)
            .setDensity(0.865);
        MT.PetCoke = MT.coal(8390, "Petroleum Coke", SET_LIGNITE, 150, 150, 180, 255, TICKS_PER_SMELT * 32, "PetCoke")
            .setBurning(MT.DarkAsh, U9)
            .uumMcfg(1, MT.C, 2 * U, MT.S, 1 * U)
            .setDensity(0.929)
            .aspects(TC.POTENTIA, 3, TC.IGNIS, 1)
            .steal(MT.Coal);
        MT.Peat = MT
            .dust(
                8360,
                "Peat",
                SET_LIGNITE,
                64,
                40,
                14,
                255,
                TICKS_PER_SMELT * 10,
                INGOTS,
                MULTIINGOTS,
                BRITTLE,
                FLAMMABLE,
                MORTAR)
            .setBurning(MT.Ash, U2)
            .aspects(TC.POTENTIA, 2, TC.IGNIS, 2);
        MT.PeatBituminous = MT
            .dust(
                8361,
                "PeatBituminous",
                SET_LIGNITE,
                80,
                40,
                10,
                255,
                TICKS_PER_SMELT * 12,
                INGOTS,
                MULTIINGOTS,
                BRITTLE,
                FLAMMABLE,
                MORTAR)
            .aspects(TC.POTENTIA, 3, TC.IGNIS, 3, TC.PERDITIO, 3)
            .setLocal("Bituminous Peat");
        MT.HydratedCoal = MT
            .mixdust(8335, "Hydrated Coal", SET_LIGNITE, 70, 70, 100, 255, BRITTLE, FURNACE, MORTAR, COAL)
            .uumMcfg(8, MT.Coal, 8 * U, MT.H2O, 1 * U);
        MT.Graphene = MT
            .dcmp(9175, "Graphene", SET_DULL, 128, 128, 128, 255, G_MACHINE, BLACKLISTED_SMELTER, MORTAR, STICKS)
            .setBurning(MT.Ash, U4)
            .uumMcfg(0, MT.C, 1 * U)
            .setSmelting(MT.C, U2)
            .heat(4300, 4400)
            .setPulver(MT.C, U);
        MT.Ectoplasm = MT.dust(8373, "Ectoplasm", SET_FOOD, 220, 255, 255, 200, MAGICAL, LIQUID, GLOWING)
            .aspects(TC.SPIRITUS, 4)
            .heat(400, 3000);
        MT.Firestone = MT
            .create(
                8342,
                "Firestone",
                SET_QUARTZ,
                200,
                20,
                0,
                255,
                G_QUARTZ_ORES,
                CRYSTAL,
                BRITTLE,
                CRYSTALLISABLE,
                MAGICAL,
                QUARTZ,
                UNBURNABLE,
                BURNING)
            .qual(3, 6.0, 1280, 3)
            .aspects(TC.IGNIS, 8)
            .heat(3000, 3700);
        MT.Redstone = MT.redstone(8333, "Redstone", SET_REDSTONE, 200, 0, 0, 255, PULVERIZING_CINNABAR)
            .lens(DYE_INDEX_Red)
            .uumMcfg(0, MT.Pyrite, 5 * U, MT.Hg, 3 * U, MT.SiO2, 1 * U, MT.Ruby, 1 * U)
            .aspects(TC.MACHINA, 1, TC.POTENTIA, 2)
            .heat(500, 1500)
            .qual(0);
        MT.Nikolite = MT.redstone(8340, "Nikolite", SET_REDSTONE, 60, 180, 200, 255, MOLTEN, "Electrotine", "Teslatite")
            .lens(DYE_INDEX_Cyan)
            .uumMcfg(0, MT.Sodalite, 5 * U, MT.Cu, 3 * U, MT.SiO2, 1 * U, MT.Ar, 1 * U)
            .aspects(TC.ELECTRUM, 2)
            .heat(1500, 3000)
            .qual(0);
        MT.Glowstone = MT.glowstone(8341, "Glowstone", SET_REDSTONE, 255, 255, 0, 255)
            .uumMcfg(0, MT.Phosphorite, 5 * U, MT.Au, 3 * U, MT.SiO2, 1 * U, MT.He, 1 * U)
            .aspects(TC.LUX, 2, TC.SENSUS, 1)
            .heat(500, 600);
        MT.GlowstoneCeres = MT.glowstone(8368, "GlowstoneCeres", SET_REDSTONE, 70, 90, 70, 255)
            .uumMcfg(0, MT.Phosphorite, 5 * U, MT.Au, 3 * U, MT.SiO2, 1 * U, MT.He, 1 * U)
            .aspects(TC.LUX, 2, TC.SENSUS, 1, TC.HERBA, 1)
            .heat(500, 600)
            .setGenerifying(MT.Glowstone)
            .setLocal("Ceres Glowstone");
        MT.GlowstoneIo = MT.glowstone(8369, "GlowstoneIo", SET_REDSTONE, 180, 20, 0, 255)
            .uumMcfg(0, MT.Phosphorite, 5 * U, MT.Au, 3 * U, MT.SiO2, 1 * U, MT.He, 1 * U)
            .aspects(TC.LUX, 2, TC.SENSUS, 1, TC.IGNIS, 1)
            .heat(500, 600)
            .setGenerifying(MT.Glowstone)
            .setLocal("Io Glowstone");
        MT.GlowstoneEnceladus = MT.glowstone(8370, "GlowstoneEnceladus", SET_REDSTONE, 0, 250, 250, 255)
            .uumMcfg(0, MT.Phosphorite, 5 * U, MT.Au, 3 * U, MT.SiO2, 1 * U, MT.He, 1 * U)
            .aspects(TC.LUX, 2, TC.SENSUS, 1, TC.AQUA, 1)
            .heat(500, 600)
            .setGenerifying(MT.Glowstone)
            .setLocal("Enceladus Glowstone");
        MT.GlowstoneProteus = MT.glowstone(8371, "GlowstoneProteus", SET_REDSTONE, 62, 62, 62, 255)
            .uumMcfg(0, MT.Phosphorite, 5 * U, MT.Au, 3 * U, MT.SiO2, 1 * U, MT.He, 1 * U)
            .aspects(TC.LUX, 2, TC.SENSUS, 1, TC.TENEBRAE, 1)
            .heat(500, 600)
            .setGenerifying(MT.Glowstone)
            .setLocal("Proteus Glowstone");
        MT.GlowstonePluto = MT.glowstone(8372, "GlowstonePluto", SET_REDSTONE, 123, 150, 220, 255)
            .uumMcfg(0, MT.Phosphorite, 5 * U, MT.Au, 3 * U, MT.SiO2, 1 * U, MT.He, 1 * U)
            .aspects(TC.LUX, 2, TC.SENSUS, 1, TC.GELUM, 1)
            .heat(500, 600)
            .setGenerifying(MT.Glowstone)
            .setLocal("Pluto Glowstone");
        MT.Gloomstone = MT.glowstone(8456, "Gloomstone", SET_REDSTONE, 19, 250, 255, 255)
            .uumMcfg(0, MT.Phosphorite, 5 * U, MT.Au, 3 * U, MT.SiO2, 1 * U, MT.He, 1 * U)
            .aspects(TC.LUX, 2, TC.SENSUS, 1, TC.SPIRITUS, 1)
            .heat(500, 600)
            .setGenerifying(MT.Glowstone);
        MT.MilkyQuartz = MT.quartz(8445, "Milky Quartz", 210, 210, 210, 255, CRYSTALLISABLE)
            .uumMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.POTENTIA, 1, TC.VITREUS, 1)
            .qual(1, 2.5, 32, 3);
        MT.NetherQuartz = MT.quartz(8346, "Nether Quartz", 230, 210, 210, 255, CRYSTALLISABLE)
            .uumMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.POTENTIA, 1, TC.VITREUS, 1)
            .qual(1, 2.5, 32, 3)
            .setGenerifying(MT.MilkyQuartz);
        MT.VoidQuartz = MT.quartz(8457, "Void Quartz", 183, 120, 212, 255, CRYSTALLISABLE)
            .uumMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.POTENTIA, 1, TC.VITREUS, 1, TC.VACUOS, 1)
            .qual(1, 2.5, 48, 3)
            .setGenerifying(MT.NetherQuartz);
        MT.SunnyQuartz = MT.quartz(8393, "Sunny Quartz", 255, 255, 200, 255, CRYSTALLISABLE)
            .uumMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.POTENTIA, 1, TC.VITREUS, 1, TC.LUX, 1)
            .qual(1, 2.5, 32, 3)
            .setGenerifying(MT.MilkyQuartz);
        MT.LavenderQuartz = MT.quartz(8394, "Lavender Quartz", 255, 200, 255, 255, CRYSTALLISABLE)
            .uumMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.POTENTIA, 1, TC.VITREUS, 1, TC.SENSUS, 1)
            .qual(1, 2.5, 32, 3)
            .setGenerifying(MT.MilkyQuartz);
        MT.RedQuartz = MT.quartz(8395, "Red Quartz", 255, 210, 210, 255, CRYSTALLISABLE)
            .uumMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.POTENTIA, 1, TC.VITREUS, 1, TC.MACHINA, 1)
            .qual(1, 2.5, 32, 3)
            .setGenerifying(MT.MilkyQuartz);
        MT.BlazeQuartz = MT.quartz(8396, "Blaze Quartz", 255, 230, 200, 255, CRYSTALLISABLE)
            .uumMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.POTENTIA, 1, TC.VITREUS, 1, TC.IGNIS, 1)
            .qual(1, 2.5, 32, 3)
            .setGenerifying(MT.MilkyQuartz);
        MT.SmokeyQuartz = MT
            .quartz(8397, "Smokey Quartz", 20, 20, 20, 255, CRYSTALLISABLE, "QuartzSmoky", "SmokyQuartz")
            .uumMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.POTENTIA, 1, TC.VITREUS, 1, TC.TENEBRAE, 1)
            .qual(1, 2.5, 32, 3)
            .setGenerifying(MT.MilkyQuartz);
        MT.ManaQuartz = MT.quartz(8398, "Mana Quartz", 210, 210, 255, 255, CRYSTALLISABLE)
            .setMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.POTENTIA, 1, TC.VITREUS, 1, TC.PRAECANTIO, 1)
            .qual(1, 2.5, 64, 3)
            .setGenerifying(MT.MilkyQuartz);
        MT.ElvenQuartz = MT.quartz(8399, "Elven Quartz", 210, 255, 210, 255, CRYSTALLISABLE)
            .setMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.POTENTIA, 1, TC.VITREUS, 1, TC.ALIENIS, 1)
            .qual(1, 2.5, 64, 3)
            .setGenerifying(MT.MilkyQuartz);
        MT.BlackQuartz = MT.quartz(8374, "QuartzBlack", 20, 20, 20, 255, CRYSTALLISABLE, DECOMPOSABLE, CENTRIFUGE)
            .uumMcfg(1, MT.SiO2, 1 * U, MT.C, 1 * U)
            .aspects(TC.POTENTIA, 1, TC.VITREUS, 1, TC.TENEBRAE, 1)
            .qual(1, 2.5, 32, 3)
            .setGenerifying(MT.MilkyQuartz)
            .setLocal("Black Quartz");
        MT.CertusQuartz = MT.quartz(8347, "Certus Quartz", 210, 210, 230, 255, CRYSTALLISABLE)
            .uumMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.POTENTIA, 1, TC.VITREUS, 1)
            .qual(1, 5.0, 32, 3)
            .setGenerifying(MT.MilkyQuartz);
        MT.ChargedCertusQuartz = MT.quartz(8348, "Charged Certus Quartz", 210, 210, 230, 255, GLOWING)
            .uumMcfg(0, MT.SiO2, 1 * U)
            .aspects(TC.POTENTIA, 2, TC.VITREUS, 1)
            .steal(MT.CertusQuartz)
            .setPulver(MT.CertusQuartz, U)
            .setGenerifying(MT.CertusQuartz);
        MT.Fluix = MT.quartz(8389, "Fluix", 120, 70, 140, 255, CRYSTALLISABLE)
            .uumMcfg(2, MT.SiO2, 2 * U, MT.Redstone, 1 * U)
            .aspects(TC.POTENTIA, 2, TC.VITREUS, 1, TC.LUX, 1);
        MT.Redstonia = MT.gem_aa(8375, "Redstonia", SET_EMERALD, 255, 0, 0, 127, MT.Redstone)
            .aspects(TC.VITREUS, 2, TC.MACHINA, 2)
            .qual(3, 6.0, 300, 2)
            .setGenerifying(MT.Redstone);
        MT.Palis = MT.gem_aa(8376, "Palis", SET_EMERALD, 0, 0, 255, 127, MT.Lapis)
            .aspects(TC.VITREUS, 2, TC.SENSUS, 2)
            .qual(3, 6.0, 300, 2)
            .setGenerifying(MT.Lapis);
        MT.Diamantine = MT.gem_aa(8377, "Diamantine", SET_DIAMOND, 128, 128, 255, 127, MT.Diamond, VALUABLE)
            .aspects(TC.VITREUS, 2, TC.LUCRUM, 2)
            .qual(3, 10.0, 1600, 4)
            .setGenerifying(MT.Diamond);
        MT.VoidCrystal = MT.gem_aa(8378, "VoidCrystal", SET_RUBY, 10, 10, 10, 127, MT.Coal, TICKS_PER_SMELT * 16)
            .aspects(TC.VITREUS, 2, TC.POTENTIA, 2)
            .qual(3, 6.0, 280, 2)
            .setGenerifying(MT.Coal)
            .setDensity(0.929)
            .setLocal("Void");
        MT.Emeradic = MT.gem_aa(8379, "Emeradic", SET_EMERALD, 0, 255, 0, 127, MT.Emerald, VALUABLE)
            .aspects(TC.VITREUS, 2, TC.LUCRUM, 2)
            .qual(3, 8.0, 2200, 3)
            .setGenerifying(MT.Emerald);
        MT.Enori = MT.gem_aa(8380, "Enori", SET_NETHERSTAR, 255, 255, 255, 127, MT.Fe)
            .aspects(TC.VITREUS, 2, TC.METALLUM, 2)
            .qual(3, 6.0, 280, 3)
            .setGenerifying(MT.Fe);
        MT.DarkMatter = MT.create(8381, "Dark Matter", SET_RUBY, 40, 20, 40, 255, G_GEM, MAGICAL, UNBURNABLE, VALUABLE)
            .aspects(TC.POTENTIA, 10, TC.TENEBRAE, 10)
            .qual(3, 20.0, 12800, 5);
        MT.RedMatter = MT.create(8382, "Red Matter", SET_RUBY, 255, 0, 0, 255, G_GEM, MAGICAL, UNBURNABLE, VALUABLE)
            .aspects(TC.POTENTIA, 10, TC.LUX, 10)
            .qual(3, 30.0, 25600, 6);
        MT.EnergiumRed = MT.crystalcent(8298, "EnergiumRed", SET_DIAMOND, 255, 0, 0, 255, CRYSTALLISABLE)
            .uumMcfg(0, MT.Sapphire, 4 * U, MT.Redstone, 5 * U)
            .aspects(TC.LUX, 2, TC.POTENTIA, 2)
            .setLocal("Red Energium");
        MT.EnergiumCyan = MT.crystalcent(8299, "EnergiumCyan", SET_DIAMOND, 0, 255, 255, 255, CRYSTALLISABLE)
            .uumMcfg(0, MT.Sapphire, 4 * U, MT.Nikolite, 5 * U)
            .aspects(TC.LUX, 2, TC.POTENTIA, 4)
            .setLocal("Cyan Energium");
        MT.InfusedDull = MT.crystal_tc(8350, "Infused Dull", 100, 100, 100, DYE_INDEX_Gray)
            .aspects(TC.PRAECANTIO, 1, TC.VACUOS, 2)
            .qual(3, 32.0, 64, 3);
        MT.InfusedVis = MT.crystal_tc(8351, "Infused Vis", 255, 0, 255, DYE_INDEX_Magenta, GLOWING)
            .aspects(TC.PRAECANTIO, 1, TC.AURAM, 2)
            .qual(3, 8.0, 64, 3);
        MT.InfusedAir = MT.crystal_tc(8352, "Infused Air", 255, 255, 0, DYE_INDEX_Yellow, GLOWING)
            .aspects(TC.PRAECANTIO, 1, TC.AER, 2)
            .qual(3, 8.0, 64, 3);
        MT.InfusedFire = MT.crystal_tc(8353, "Infused Fire", 255, 0, 0, DYE_INDEX_Red, GLOWING)
            .aspects(TC.PRAECANTIO, 1, TC.IGNIS, 2)
            .qual(3, 8.0, 64, 3);
        MT.InfusedEarth = MT.crystal_tc(8354, "Infused Earth", 0, 255, 0, DYE_INDEX_Green, GLOWING)
            .aspects(TC.PRAECANTIO, 1, TC.TERRA, 2)
            .qual(3, 8.0, 256, 3);
        MT.InfusedWater = MT.crystal_tc(8355, "Infused Water", 0, 0, 255, DYE_INDEX_Blue, GLOWING)
            .aspects(TC.PRAECANTIO, 1, TC.AQUA, 2)
            .qual(3, 8.0, 64, 3);
        MT.InfusedEntropy = MT.crystal_tc(8356, "Infused Entropy", 62, 62, 62, DYE_INDEX_Black, GLOWING)
            .aspects(TC.PRAECANTIO, 1, TC.PERDITIO, 2)
            .qual(3, 32.0, 64, 4);
        MT.InfusedOrder = MT.crystal_tc(8357, "Infused Order", 252, 252, 252, DYE_INDEX_White, GLOWING)
            .aspects(TC.PRAECANTIO, 1, TC.ORDO, 2)
            .qual(3, 8.0, 64, 3);
        MT.InfusedBalance = MT.crystal_tc(8358, "Infused Balance", 252, 252, 252, DYE_INDEX_LightGray, GLOWING)
            .aspects(TC.PRAECANTIO, 1, TC.ORDO, 1, TC.PERDITIO, 1, TC.IGNIS, 1, TC.AER, 1, TC.AQUA, 1, TC.TERRA, 1)
            .qual(3, 32.0, 256, 4);
        MT.HexoriumBlack = MT.hexorium(9224, 32, 32, 32, DYE_INDEX_Black);
        MT.HexoriumRed = MT.hexorium(9225, 128, 0, 0, DYE_INDEX_Red);
        MT.HexoriumGreen = MT.hexorium(9226, 0, 128, 0, DYE_INDEX_Green);
        // HexoriumBrown = hexorium ( 9227, 48, 32, 0, DYE_INDEX_Brown ),
        MT.HexoriumBlue = MT.hexorium(9228, 0, 0, 128, DYE_INDEX_Blue);
        // HexoriumPurple = hexorium ( 9229, 64, 0, 64, DYE_INDEX_Purple ),
        // HexoriumCyan = hexorium ( 9230, 0, 128, 128, DYE_INDEX_Cyan ),
        // HexoriumLightGray = hexorium ( 9231, 96, 96, 96, DYE_INDEX_LightGray),
        // HexoriumGray = hexorium ( 9232, 64, 64, 64, DYE_INDEX_Gray ),
        // HexoriumPink = hexorium ( 9233, 128, 96, 96, DYE_INDEX_Pink ),
        // HexoriumLime = hexorium ( 9234, 64, 128, 64, DYE_INDEX_Lime ),
        // HexoriumYellow = hexorium ( 9235, 128, 128, 0, DYE_INDEX_Yellow ),
        // HexoriumLightBlue = hexorium ( 9236, 64, 64, 128, DYE_INDEX_LightBlue),
        // HexoriumMagenta = hexorium ( 9237, 128, 0, 128, DYE_INDEX_Magenta ),
        // HexoriumOrange = hexorium ( 9238, 128, 64, 0, DYE_INDEX_Orange ),
        MT.HexoriumWhite = MT.hexorium(9239, 224, 224, 224, DYE_INDEX_White);
        // HexoriumDarkGray = hexorium ( 9240, 48, 48, 48, DYE_INDEX_Gray ),
        // HexoriumTurquoise = hexorium ( 9241, 0, 128, 64, DYE_INDEX_Cyan ),
        // HexoriumRainbow = hexorium ( 9242, 224, 224, 224, DYE_INDEX_White ),
        MT.Sand = MT.dust(8100, "Sand", SET_SAND, 250, 250, 200, 255, FURNACE, UNRECYCLABLE)
            .aspects(TC.TERRA, 1)
            .stealStatsElement(MT.SiO2)
            .setSmelting(MT.Glass, U)
            .setForging(MT.Glass, U);
        MT.RedSand = MT.dust(8104, "Red Sand", SET_SAND, 170, 86, 35, 255, FURNACE)
            .aspects(TC.METALLUM, 1)
            .stealStatsElement(MT.SiO2)
            .setSmelting(MT.Glass, U)
            .setForging(MT.Glass, U);
        MT.EndSandWhite = MT.dust(8105, "White End Sand", SET_SAND, 230, 250, 250, 255, FURNACE)
            .aspects(TC.ALIENIS, 1)
            .stealStatsElement(MT.SiO2)
            .setSmelting(MT.Glass, U)
            .setForging(MT.Glass, U);
        MT.EndSandBlack = MT.dust(8106, "Black End Sand", SET_SAND, 40, 60, 60, 255, FURNACE)
            .aspects(TC.ALIENIS, 1)
            .stealStatsElement(MT.SiO2)
            .setSmelting(MT.Glass, U)
            .setForging(MT.Glass, U);
        MT.SoulSand = MT.oredust(8101, "Soulsand", SET_SAND, 100, 100, 80, 255)
            .aspects(TC.SPIRITUS, 1, TC.VINCULUM, 1)
            .stealStatsElement(MT.SiO2);
        MT.SluiceSand = MT.dust(8102, "Sluice Sand", SET_SAND, 165, 165, 120, 255)
            .aspects(TC.TERRA, 1, TC.LUCRUM, 1)
            .stealStatsElement(MT.SiO2);
        MT.PlatinumGroupSludge = MT.oredust(8103, "Platinum Group Sludge", SET_SAND, 50, 50, 80, 255)
            .aspects(TC.LIMUS, 2, TC.NEBRISUM, 2)
            .stealStatsElement(MT.Pt)
            .addSourceOf(MT.Ru, MT.Rh, MT.Pd, MT.Os, MT.Ir, MT.Pt);
        MT.RareEarth = MT.oredust(9100, "Rare Earth", SET_FINE, 128, 128, 100, 255)
            .aspects(TC.VITREUS, 2, TC.NEBRISUM, 1)
            .stealStatsElement(MT.Nd)
            .addSourceOf(MT.Nd, MT.Y, MT.La, MT.Ce, MT.Cd, MT.Cs);
        MT.Monazite = MT
            .elec(
                8338,
                "Monazite",
                SET_REDSTONE,
                50,
                70,
                50,
                255,
                G_GEM_ORES,
                CRYSTAL,
                BRITTLE,
                CRYSTALLISABLE,
                BLACKLISTED_SMELTER)
            .setMcfg(0, MT.RareEarth, 1 * U, MT.PO4, 1 * U)
            .aspects(TC.POTENTIA, 1, TC.NEBRISUM, 1)
            .addSourceOf(MT.He);
        // Wikipedia: (Ce, La, Nd, Th, Sm, Gd)PO4 Monazite also smelt-extract to Helium, it is
        // brown like the rare earth Item Monazite sand deposits are inevitably of the
        // monazite-(Ce) composition. Typically, the lanthanides in such monazites contain
        // about 45�48% cerium, about 24% lanthanum, about 17% neodymium, about 5%
        // praseodymium, and minor quantities of samarium, gadolinium, and yttrium. Europium
        // concentrations tend to be low, about 0.05% Thorium content of monazite is variable
        // and sometimes can be up to 20�30%
        MT.Force = MT
            .create(
                8343,
                "Force",
                SET_REDSTONE,
                255,
                255,
                0,
                255,
                G_GEM_ORES,
                G_INGOT_MACHINE_ORES,
                CRYSTAL,
                MAGICAL,
                UNBURNABLE,
                GLOWING)
            .qual(3, 10.0, 128, 3)
            .aspects(TC.POTENTIA, 4);
        MT.Forcicium = MT
            .create(
                8344,
                "Forcicium",
                SET_REDSTONE,
                50,
                50,
                70,
                255,
                G_QUARTZ_ORES,
                CRYSTAL,
                BRITTLE,
                CRYSTALLISABLE,
                MAGICAL)
            .aspects(TC.POTENTIA, 2);
        MT.Forcillium = MT
            .create(
                8345,
                "Forcillium",
                SET_REDSTONE,
                50,
                50,
                70,
                255,
                G_QUARTZ_ORES,
                CRYSTAL,
                BRITTLE,
                CRYSTALLISABLE,
                MAGICAL)
            .aspects(TC.POTENTIA, 2);
    }
}
