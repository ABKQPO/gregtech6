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
 * The vanilla and world generation Stone Materials.
 * <p>
 * Loaded as the "Stones" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsStones implements IMaterialCategory {

    @Override
    public String getName() {
        return "Stones";
    }

    @Override
    public void load() {
        MT.Stone = MT.stone(8500, "Stone", 205, 205, 205, 255, MELTING, MOLTEN, UNRECYCLABLE)
            .aspects(TC.TERRA, 1)
            .stealStatsElement(MT.SiO2)
            .qual(1, 2.0, 16, 1)
            .heat(1100)
            .setRGBaLiquid(192, 96, 64, 255);
        MT.Gravel = MT.Stone;
        MT.Concrete = MT.stone(8501, "Concrete", SET_BRICK, 100, 100, 100, 255, MELTING)
            .setMcfg(0, MT.Stone, 1 * U)
            .aspects(TC.TERRA, 1)
            .stealStatsElement(MT.SiO2)
            .qual(1, 2.5, 32, 0)
            .heat(500)
            .setSmelting(MT.Stone, U)
            .setGenerifying(MT.Stone);
        MT.Netherrack = MT.stone(8502, "Netherrack", 200, 0, 0, 255, UNBURNABLE, FLAMMABLE, BLACKLISTED_SMELTER)
            .aspects(TC.IGNIS, 1)
            .stealStatsElement(MT.SiO2)
            .qual(1, 2.0, 8, 0)
            .heat(1500, 3000);
        MT.NetherBrick = MT.stone(8503, "Nether Brick", SET_BRICK, 100, 0, 0, 255, UNBURNABLE, "BrickNether")
            .aspects(TC.IGNIS, 1)
            .stealStatsElement(MT.SiO2)
            .qual(1, 2.0, 24, 1)
            .heat(1800, 3000)
            .setPulver(MT.Netherrack, U)
            .setGenerifying(MT.Netherrack);
        MT.Endstone = MT.stone(8504, "Endstone", 217, 222, 158, 255, ENDER_DRAGON_PROOF)
            .aspects(TC.TENEBRAE, 1)
            .stealStatsElement(MT.SiO2)
            .qual(1, 3.0, 16, 1)
            .heat(1200)
            .setGenerifying(MT.EndSandWhite)
            .addSourceOf(MT.He, MT.He_3);
        MT.Obsidian = MT
            .elec(8214, "Obsidian", SET_STONE, 80, 50, 100, 255, G_STONE, STONE, BRITTLE, MORTAR, UNBURNABLE)
            .setMcfg(64, MT.Mg, 1 * U, MT.Fe, 1 * U, MT.SiO2, 6 * U, MT.O, 4 * U)
            .aspects(TC.TENEBRAE, 1, TC.IGNIS, 2, TC.TERRA, 2)
            .setSmelting(MT.Lava, U)
            .heat(1300, 4000)
            .qual(1, 3.0, 32, 3);
        MT.Bedrock = MT
            .create(8599, "Bedrock", SET_STONE, 64, 64, 64, 255, G_STONE, STONE, BRITTLE, MELTING, UNBURNABLE)
            .aspects(TC.TERRA, 5)
            .stealStatsElement(MT.Ad)
            .qual(1, 8.0, 2048, 5)
            .heat(4000)
            .setRGBaLiquid(128, 96, 64, 255)
            .addSourceOf(MT.Ad, MT.Atl, MT.RareEarth)
            .setGenerifying(MT.Stone);
        MT.PrismarineLight = MT
            .stone(9219, "Prismarine", SET_PRISMARINE, 110, 178, 165, 255, G_GEM_ORES, CRYSTAL, CRYSTALLISABLE)
            .aspects(TC.TEMPESTAS, 1)
            .qual(1, 4.0, 48, 1)
            .setLocal("Light Prismarine");
        MT.PrismarineDark = MT
            .stone(9220, "PrismarineDark", SET_PRISMARINE, 88, 125, 108, 255, G_GEM_ORES, CRYSTAL, CRYSTALLISABLE)
            .aspects(TC.TEMPESTAS, 1)
            .qual(1, 4.0, 48, 1)
            .setLocal("Dark Prismarine");
        MT.Greenstone = MT.stone(9172, "Greenstone", 52, 252, 52, 255)
            .aspects(TC.TERRA, 1)
            .setGenerifying(MT.Stone);
        MT.Bluestone = MT.stone(9185, "Bluestone", 52, 52, 252, 255)
            .aspects(TC.TERRA, 1)
            .setGenerifying(MT.Stone);
        MT.Epidote = MT.stone(9182, "Epidote", 128, 128, 128, 255)
            .aspects(TC.TERRA, 1)
            .setGenerifying(MT.Stone);
    }
}
