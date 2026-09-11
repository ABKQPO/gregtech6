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

import gregapi.data.materials.IMaterialCategory;

/**
 * The adjustments between Materials that can only be made once every Material exists.
 * <p>
 * These used to sit in a static initialiser of MT, which meant they were silently ordered behind the whole Material
 * Table. Being a Category makes that dependency explicit instead of accidental.
 */
public class MaterialsLateBindings implements IMaterialCategory {

    @Override
    public String getName() {
        return "Late Bindings";
    }

    @Override
    public void load() {
        MT.H2O.setSolidifying(MT.Ice, U);
        MT.Lava.setSolidifying(MT.Obsidian, U)
            .setDensity(MT.Obsidian.mGramPerCubicCentimeter);
        MT.Netherrack.setSmelting(MT.NetherBrick, U);
    }
}
