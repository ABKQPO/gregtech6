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
 * The Materials that are currently unused, but kept around so old World Saves keep working.
 * <p>
 * Loaded as the "Unused" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsUnused implements IMaterialCategory {

    @Override
    public String getName() {
        return "Unused";
    }

    @Override
    public void load() {
        MT.UNUSED.OsmiumTetroxide = MT.unused("Osmium Tetroxide")

            .setMcfg(0, MT.Os, 1 * U, MT.O, 4 * U);
        MT.UNUSED.SodiumPeroxide = MT.unused("Sodium Peroxide")
            .setMcfg(0, MT.Na, 2 * U, MT.O, 2 * U);
        // Yellowish
        MT.UNUSED.IridiumSodiumOxide = MT.unused("Iridium Sodium Oxide");
        MT.UNUSED.Iridiron = MT.unused("IridiumIron")
            .setPriorityPrefix(3)

            .put(G_INGOT)

            .setMcfg(0, MT.Ir, 1 * U, MT.Fe, 1 * U)

            .setLocal("Iridiron");
        MT.UNUSED.IridironReinforced = MT.unused("IridiumIronReinforced")
            .setPriorityPrefix(3)

            .put(G_INGOT)

            .setMcfg(0, MT.Ir, 1 * U, MT.Fe, 1 * U)

            .setLocal("Reinforced Iridiron");
        MT.UNUSED.LimePure = MT.unused("LimePure")
            .setLocal("Pure Lime");
        MT.UNUSED.TNT = MT.unused("TNT")
            .put(EXPLOSIVE, FLAMMABLE, MD.MC)

            .aspects(TC.PERDITIO, 3, TC.IGNIS, 1);
        MT.UNUSED.TerrasteelAlloyRaw = MT.unused("TerrasteelAlloyRaw")
            .setPriorityPrefix(3)

            .put(G_INGOT, MAGICAL, "RawTerrasteelAlloy")

            .setLocal("Raw Terrasteel Alloy");
        MT.UNUSED.TerrasteelAlloyStrengthened = MT.unused("TerrasteelAlloyStrengthened")
            .setPriorityPrefix(3)

            .put(G_INGOT, MAGICAL, "StrengthenedTerrasteelAlloy")

            .setLocal("Strengthened Terrasteel Alloy");
        MT.UNUSED.Vis = MT.unused("Vis")
            .put(DECOMPOSABLE)

            .setMcfg(0, MT.Ma, 1 * U)

            .aspects(TC.AURAM, 2, TC.PRAECANTIO, 1);
        MT.UNUSED.Voidstone = MT.unused("Voidstone")
            .aspects(TC.VITREUS, 1, TC.VACUOS, 1);
        MT.UNUSED.Mercassium = MT.unused("Mercassium")
            .setPriorityPrefix(3)

            .qual(3, 6.0, 64, 1)

            .put(G_INGOT_ORES);
        MT.UNUSED.Osmonium = MT.unused("Osmonium")
            .setPriorityPrefix(3)

            .qual(3, 6.0, 64, 1)

            .put(G_INGOT_ORES);
        MT.UNUSED.Phoenixite = MT.unused("Phoenixite")
            .setPriorityPrefix(3)

            .qual(3, 6.0, 64, 1)

            .put(G_INGOT_ORES);
        MT.UNUSED.Antimatter = MT.unused("Antimatter")
            .put(ANTIMATTER);
        MT.UNUSED.Starconium = MT.unused("Starconium")
            .setPriorityPrefix(3)

            .put(G_INGOT_ORES);
        MT.UNUSED.Thyrium = MT.unused("Thyrium")
            .setPriorityPrefix(3)

            .put(G_INGOT_ORES);
        MT.UNUSED.Zectium = MT.unused("Zectium")
            .setPriorityPrefix(3)

            .put(G_INGOT_ORES);
        MT.UNUSED.Draconic = MT.deprecated("Draconic")
            .setPriorityPrefix(2)

            .put(G_DUST);
        MT.UNUSED.Teslatite = MT.unused("InfusedTeslatite")
            .setPriorityPrefix(2)

            .put(G_DUST)

            .setLocal("Teslatite");
        // 1 Redstone + 1 Nikolite = 1 Teslatite; and 8 Teslatite + 1 Gold = 1 Purple

        // Alloy;
        MT.UNUSED.IrridantUranium = MT.unused("Irridant Uranium")
            .setPriorityPrefix(3)

            .put(G_INGOT);
        MT.UNUSED.IrridantReinforced = MT.unused("IrridantReinforced")
            .setPriorityPrefix(3)

            .put(G_INGOT);
        MT.UNUSED.IronSharp = MT.unused("IronSharp")
            .setPriorityPrefix(3)

            .put(G_INGOT)

            .setLocal("Sharp Iron");
        MT.UNUSED.ObsidianFlux = MT.unused("Obsidian Flux")
            .setPriorityPrefix(3)

            .put(G_INGOT);
        MT.UNUSED.CrystalFlux = MT.unused("Crystal Flux")
            .setPriorityPrefix(1)

            .put(G_GEM, CRYSTAL, BRITTLE);
        MT.UNUSED.Mimichite = MT.unused("Mimichite")
            .setPriorityPrefix(1)

            .put(G_GEM_ORES, CRYSTAL, BRITTLE);
        MT.UNUSED.Infernal = MT.unused("Infernal");
        MT.UNUSED.Invisium = MT.unused("Invisium")
            .setPriorityPrefix(2)

            .put(G_DUST);
        MT.UNUSED.Lodestone = MT.unused("Lodestone")
            .setPriorityPrefix(2)

            .put(G_DUST_ORES);
        MT.UNUSED.Luminite = MT.unused("Luminite")
            .setPriorityPrefix(2)

            .put(G_DUST_ORES);
        MT.UNUSED.Magma = MT.unused("Magma");
        MT.UNUSED.Mawsitsit = MT.unused("Mawsitsit")
            .setPriorityPrefix(2)

            .put(G_DUST);
        MT.UNUSED.Nether = MT.unused("Nether");
        MT.UNUSED.Painite = MT.unused("Painite");
        MT.UNUSED.Petroleum = MT.unused("Petroleum")
            .setPriorityPrefix(2)

            .put(G_DUST_ORES);
        MT.UNUSED.Pewter = MT.unused("Pewter");
        MT.UNUSED.Potash = MT.unused("Potash");
        MT.UNUSED.Randomite = MT.unused("Randomite")
            .setPriorityPrefix(2)

            .put(G_DUST_ORES);
        MT.UNUSED.RyuDragonRyder = MT.unused("RyuDragonRyder");
        MT.UNUSED.Tar = MT.unused("Tar");
        MT.UNUSED.TarPitch = MT.unused("Tar Pitch");
        MT.UNUSED.Cavenium = MT.unused("Cavenium");
        MT.UNUSED.CaveniumRefined = MT.unused("CaveniumRefined")
            .put("RefinedCavenium")

            .setLocal("Refined Cavenium");
        MT.UNUSED.Infitite = MT.unused("Infitite");
        MT.UNUSED.Magnite = MT.unused("Magnite");
        MT.UNUSED.Hexcite = MT.unused("Hexcite");
        MT.UNUSED.Tapazite = MT.unused("Tapazite")
            .setPriorityPrefix(2)

            .put(G_DUST);
        MT.UNUSED.Tourmaline = MT.unused("Tourmaline")
            .setPriorityPrefix(2)

            .put(G_DUST);
        MT.UNUSED.Turquoise = MT.unused("Turquoise")
            .setPriorityPrefix(2)

            .put(G_DUST);
        MT.UNUSED.Wimalite = MT.unused("Wimalite")
            .setPriorityPrefix(2)

            .put(G_DUST_ORES);
        MT.UNUSED.Adamite = MT.unused("Adamite")
            .setPriorityPrefix(2)

            .put(G_DUST_ORES);
        MT.UNUSED.Adluorite = MT.unused("Adluorite")
            .setPriorityPrefix(2)

            .put(G_DUST_ORES);
        MT.UNUSED.Agate = MT.unused("Agate")
            .setPriorityPrefix(2)

            .put(G_DUST);
        MT.UNUSED.Ammonium = MT.unused("Ammonium")
            .setPriorityPrefix(2)

            .put(G_DUST);
        MT.UNUSED.Bitumen = MT.unused("Bitumen")
            .setPriorityPrefix(2)

            .put(G_DUST_ORES);
        MT.UNUSED.Bloodstone = MT.unused("Bloodstone")
            .setPriorityPrefix(2)

            .put(G_DUST);
        MT.UNUSED.Citrine = MT.unused("Citrine")
            .setPriorityPrefix(2)

            .put(G_DUST);
        MT.UNUSED.Coral = MT.unused("Coral")
            .setPriorityPrefix(2)

            .put(G_DUST);
        MT.UNUSED.Chrysocolla = MT.unused("Chrysocolla")
            .setPriorityPrefix(2)

            .put(G_DUST);
        MT.UNUSED.DarkStone = MT.unused("Dark Stone")
            .setPriorityPrefix(2)

            .put(G_DUST);
        MT.UNUSED.Demonite = MT.unused("Demonite")
            .setPriorityPrefix(2)

            .put(G_DUST);
        MT.UNUSED.InfusedGold = MT.unused("Infused Gold")
            .setPriorityPrefix(3)

            .put(G_INGOT);
        MT.UNUSED.Daffergon = MT.unused("Daffergon")
            .setPriorityPrefix(3)

            .put(G_INGOT_ORES, MD.HBM);
        // Dellite Ore
        MT.UNUSED.Reiium = MT.unused("Reiium")
            .setPriorityPrefix(3)

            .put(G_INGOT_ORES, MD.HBM);
        // Reiite Ore
        MT.UNUSED.Weidanium = MT.unused("Weidanium")
            .setPriorityPrefix(3)

            .put(G_INGOT_ORES, MD.HBM);
        // Weidite Ore
        MT.UNUSED.Verticium = MT.unused("Verticium")
            .setPriorityPrefix(3)

            .put(G_INGOT_ORES, MD.HBM);
        MT.UNUSED.Australium = MT.unused("Australium")
            .setPriorityPrefix(3)

            .put(G_INGOT_ORES, MD.HBM);
        MT.UNUSED.Schrabidium = MT.unused("Schrabidium")
            .setPriorityPrefix(3)

            .put(G_INGOT_ORES, MD.HBM, MAGNETIC_ACTIVE, AUTO_COLLECTING, MELTING, MOLTEN)

            .setRGBa(50, 255, 255, 255);
        MT.UNUSED.Starmetal = MT.unused("Starmetal")
            .setPriorityPrefix(3)

            .put(G_INGOT_MACHINE_ORES, MD.HBM);
        MT.UNUSED.Unobtainium = MT.unused("Unobtainium")
            .setPriorityPrefix(3)

            .put(G_INGOT_MACHINE_ORES, MD.HBM);
        MT.UNUSED.CMBSteel = MT.unused("CMB Steel")
            .setPriorityPrefix(3)

            .put(G_INGOT_MACHINE, MD.HBM);
        MT.UNUSED.DuraSteel = MT.unused("DuraSteel")
            .setPriorityPrefix(3)

            .put(G_INGOT_MACHINE, MD.HBM)

            .setLocal("High-Speed Steel");
        MT.UNUSED.AdvancedAlloy = MT.unused("Advanced Alloy")
            .setPriorityPrefix(3)

            .put(G_INGOT_MACHINE, MD.HBM);
        MT.UNUSED.Saturnite = MT.unused("Saturnite")
            .setPriorityPrefix(3)

            .put(G_INGOT_MACHINE, MD.HBM);
        MT.UNUSED.Dineutronium = MT.unused("Dineutronium")
            .setPriorityPrefix(3)

            .put(G_INGOT_MACHINE, MD.HBM);
        MT.UNUSED.MagnetizedTungsten = MT.unused("Magnetized Tungsten")
            .setPriorityPrefix(3)

            .put(G_INGOT, MD.HBM, MAGNETIC_ACTIVE, AUTO_COLLECTING);
        MT.UNUSED.Euphemium = MT.unused("Euphemium")
            .setPriorityPrefix(3)

            .put(G_INGOT, MD.HBM, MELTING, MOLTEN)

            .setRGBa(255, 150, 255, 255);
        MT.UNUSED.Rupee = MT.unused("Rupee")
            .put(MD.DRPG);
        MT.UNUSED.Arlemite = MT.unused("Arlemite")
            .put(MD.DRPG);
        MT.UNUSED.Realmite = MT.unused("Realmite")
            .put(MD.DRPG);
        MT.UNUSED.Bloodgem = MT.unused("Bloodgem")
            .put(MD.DRPG);
        MT.UNUSED.Netheryte = MT.unused("Netheryte")
            .put(MD.DRPG);
        MT.UNUSED.Eden = MT.unused("Eden")
            .put(MD.DRPG);
        MT.UNUSED.Wildwood = MT.unused("Wildwood")
            .put(MD.DRPG);
        MT.UNUSED.Apalachia = MT.unused("Apalachia")
            .put(MD.DRPG);
        MT.UNUSED.Skythern = MT.unused("Skythern")
            .put(MD.DRPG);
        MT.UNUSED.Mortum = MT.unused("Mortum")
            .put(MD.DRPG);
        MT.UNUSED.Arcanium = MT.unused("Arcanium")
            .put(MD.DRPG);
        MT.UNUSED.Energized = MT.unused("Energized");
        MT.UNUSED.Reinforced = MT.unused("Reinforced");
        MT.UNUSED.Mud = MT.unused("Mud")
            .put(IGNORE_IN_COLOR_LOG);
        MT.UNUSED.Cream = MT.unused("Cream")
            .put(IGNORE_IN_COLOR_LOG);
        MT.UNUSED.Cluster = MT.unused("Cluster");
        MT.UNUSED.Sweet = MT.unused("Sweet");
        MT.UNUSED.Gelatine = MT.unused("Gelatine");
        MT.UNUSED.Satinspar = MT.unused("Satinspar");
        MT.UNUSED.Selenite = MT.unused("Selenite");
        MT.UNUSED.Jet = MT.unused("Jet");
        MT.UNUSED.Microcline = MT.unused("Microcline");
        MT.UNUSED.Serpentine = MT.unused("Serpentine");
        // byproduct

        // pietersite,

        // which is a

        // fake? Tiger

        // eye
        MT.UNUSED.Sylvite = MT.unused("Sylvite");
        MT.UNUSED.Goshen = MT.unused("Goshen");
        MT.UNUSED.Joshen = MT.unused("Joshen");
        MT.UNUSED.Itarius = MT.unused("Itarius");
        MT.UNUSED.Legendary = MT.unused("Legendary");
        MT.UNUSED.MutatedIron = MT.unused("Mutated Iron");
        MT.UNUSED.Witheria = MT.unused("Witheria");
        MT.UNUSED.RubberTreeSap = MT.unused("Rubber Tree Sap");
        MT.UNUSED.GraveyardDirt = MT.unused("Graveyard Dirt");
        MT.UNUSED.Cocaine = MT.unused("Cocaine");
        MT.UNUSED.Vile = MT.unused("Vile");
        MT.UNUSED.Dull = MT.unused("Dull");
        MT.UNUSED.Dark = MT.unused("Dark");
        MT.UNUSED.Soulium = MT.unused("Soulium");
        MT.UNUSED.Tennantite = MT.unused("Tennantite");
        MT.UNUSED.Alfium = MT.unused("Alfium");
        MT.UNUSED.Ryu = MT.unused("Ryu");
        MT.UNUSED.Mutation = MT.unused("Mutation");
        MT.UNUSED.HOPGraphite = MT.unused("HOPGraphite");
        MT.UNUSED.EnrichedCopper = MT.unused("Enriched Copper");
        MT.UNUSED.DiamondCopper = MT.unused("Diamond Copper");
        MT.UNUSED.Fairy = MT.unused("Fairy");
        MT.UNUSED.Pokefennium = MT.unused("Pokefennium");;
    }
}
