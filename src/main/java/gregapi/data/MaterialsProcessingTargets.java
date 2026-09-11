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
 * The processing targets that are set once every Material exists.
 * <p>
 * This is the pass that assigns Ore multipliers, crushing and smelting targets and the Tooltips of the Materials,
 * which is why it has to run after all of them were created. It used to be reached through a forced class load from
 * the old initialiser, which made that dependency implicit.
 * <p>
 * Loaded as the "Processing Targets" Category of the Material Table, which the Material Registry executes in
 * registration order.
 */
public class MaterialsProcessingTargets implements IMaterialCategory {

    @Override
    public String getName() {
        return "Processing Targets";
    }

    @Override
    public void load() {
        MT.TECH.init();
    }
}
