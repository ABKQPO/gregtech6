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
 * The Material tables that live in their own classes instead of in a nested one.
 * <p>
 * They read MT fields while they initialise, so they have to be loaded after the rest of the Material Table, which is
 * why this is the last Category. The checks turn a table that silently stayed empty into a readable error, which is
 * what the old "call getClass() and hope for the best" trick used to hide.
 * <p>
 * Loaded as the "Foreign Tables" Category of the Material Table, which the Material Registry executes in registration
 * order.
 */
public class MaterialsForeignTables implements IMaterialCategory {

    @Override
    public String getName() {
        return "Foreign Tables";
    }

    @Override
    public void load() {
        if (AM.Hydrogen == null)
            throw new IllegalStateException("The Material table 'AM' did not initialise properly.");
        ANY.init();
    }
}
