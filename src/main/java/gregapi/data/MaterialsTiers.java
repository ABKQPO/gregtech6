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
 * The pure Tiers that are used as generic stand ins for Machine and Tool progression.
 * <p>
 * Loaded as the "Tiers" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsTiers implements IMaterialCategory {

    @Override
    public String getName() {
        return "Tiers";
    }

    @Override
    public void load() {
        MT.Primitive = MT.tier("Primitive")
            .aspects(TC.MACHINA, 1);
        MT.Basic = MT.tier("Basic")
            .aspects(TC.MACHINA, 2);
        MT.Good = MT.tier("Good")
            .aspects(TC.MACHINA, 3);
        MT.Advanced = MT.tier("Advanced")
            .aspects(TC.MACHINA, 4);
        MT.Data = MT.tier("Data")
            .aspects(TC.MACHINA, 4);
        MT.Elite = MT.tier("Elite")
            .aspects(TC.MACHINA, 5);
        MT.Master = MT.tier("Master")
            .aspects(TC.MACHINA, 6);
        MT.Ultimate = MT.tier("Ultimate")
            .aspects(TC.MACHINA, 7);
        MT.Quantum = MT.tier("Quantum")
            .aspects(TC.ORDO, 8);
        MT.Superconductor = MT.tier("Superconductor")
            .aspects(TC.ELECTRUM, 8);
        MT.Infinite = MT.tier("Infinite");
    }
}
