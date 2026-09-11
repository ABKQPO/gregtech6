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
 * The thermal Dusts.
 * <p>
 * Loaded as the "Thermal Dusts" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsThermalDusts implements IMaterialCategory {

    @Override
    public String getName() {
        return "Thermal Dusts";
    }

    @Override
    public void load() {
        MT.Oilshale = MT
            .oredustcent(9853, "Oil Shale", SET_STONE, 50, 50, 60, 255, FLAMMABLE, TICKS_PER_SMELT * 2, "Oilshale")
            .setBurning(MT.Stone, U2)
            .setMcfg(0, MT.CaCO3, 2 * U, MT.MilkyQuartz, 1 * U, MT.Clay, 1 * U)
            .heat(500, 1000)
            .aspects(TC.MORTUUS, 2, TC.LUX, 1)
            .setGenerifying(MT.Stone);
        MT.Petrotheum = MT.mixdust(8245, "Petrotheum", SET_DULL, 86, 76, 82, 255, CONTAINERS, MELTING, MORTAR)
            .setMcfg(18, MT.Clay, 9 * U, MT.Obsidian, 9 * U, MT.Redstone, 9 * U, MT.Basalz, 1 * U)
            .aspects(TC.PRAECANTIO, 2, TC.POTENTIA, 1)
            .heat(400, 2000);
        MT.Aerotheum = MT.dust(8246, "Aerotheum", SET_SHINY, 250, 226, 83, 255, CONTAINERS, MELTING, MORTAR)
            .setMcfg(18, MT.Sand, 9 * U, MT.KNO3, 9 * U, MT.Redstone, 9 * U, MT.Blitz, 1 * U)
            .aspects(TC.PRAECANTIO, 2, TC.AER, 1)
            .heat(299, 300);
        MT.Pyrotheum = MT
            .mixdust(
                8212,
                "Pyrotheum",
                SET_FIERY,
                255,
                200,
                60,
                255,
                CONTAINERS,
                MELTING,
                MORTAR,
                TICKS_PER_SMELT * 120)
            .setMcfg(18, MT.Coal, 9 * U, MT.S, 9 * U, MT.Redstone, 9 * U, MT.Blaze, 1 * U)
            .aspects(TC.PRAECANTIO, 2, TC.IGNIS, 1)
            .heat(3800, 6400);
        MT.Cryotheum = MT.dust(8213, "Cryotheum", SET_SHINY, 100, 220, 255, 255, CONTAINERS, MELTING, MORTAR)
            .setMcfg(18, MT.Snow, 2 * U, MT.KNO3, 9 * U, MT.Redstone, 9 * U, MT.Blizz, 1 * U)
            .aspects(TC.PRAECANTIO, 2, TC.GELUM, 1)
            .heat(40, 1000);
    }
}
