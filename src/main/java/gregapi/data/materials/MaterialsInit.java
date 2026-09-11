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

package gregapi.data.materials;

import gregapi.data.MaterialsAliases;
import gregapi.data.MaterialsAlloys;
import gregapi.data.MaterialsChemicals;
import gregapi.data.MaterialsCrystals;
import gregapi.data.MaterialsDyes;
import gregapi.data.MaterialsElements;
import gregapi.data.MaterialsExtendedElements;
import gregapi.data.MaterialsForeignTables;
import gregapi.data.MaterialsGems;
import gregapi.data.MaterialsInternals;
import gregapi.data.MaterialsItemData;
import gregapi.data.MaterialsLateBindings;
import gregapi.data.MaterialsOreCompounds;
import gregapi.data.MaterialsOrganics;
import gregapi.data.MaterialsProcessingTargets;
import gregapi.data.MaterialsRockMaterials;
import gregapi.data.MaterialsStones;
import gregapi.data.MaterialsTechnical;
import gregapi.data.MaterialsThermalDusts;
import gregapi.data.MaterialsTiers;
import gregapi.data.MaterialsUnused;
import gregapi.data.MaterialsWoodTypes;

/**
 * The composition root of the Material Table.
 * <p>
 * This is the one place that knows in which order the Categories have to run. The order is the order the Materials
 * used to be declared in, because a Category may reference anything the earlier Categories already created. Adding a
 * Material therefore means picking the Category it belongs to instead of appending it to the end of a single huge
 * declaration.
 */
public class MaterialsInit {

    private static boolean INITIALIZED = false;

    /**
     * Registers the built in Categories and executes the Registry. Repeated calls are no-ops. The registered order is
     * the declaration order of the Materials, so it is not safe to shuffle the calls around.
     */
    public static void load() {
        if (INITIALIZED) return;
        INITIALIZED = true;

        MaterialRegistry.register(new MaterialsInternals());
        MaterialRegistry.register(new MaterialsElements());
        MaterialRegistry.register(new MaterialsExtendedElements());
        MaterialRegistry.register(new MaterialsTiers());
        MaterialRegistry.register(new MaterialsDyes());
        MaterialRegistry.register(new MaterialsChemicals());
        MaterialRegistry.register(new MaterialsOrganics());
        MaterialRegistry.register(new MaterialsGems());
        MaterialRegistry.register(new MaterialsCrystals());
        MaterialRegistry.register(new MaterialsStones());
        MaterialRegistry.register(new MaterialsThermalDusts());
        MaterialRegistry.register(new MaterialsAlloys());
        MaterialRegistry.register(new MaterialsLateBindings());
        MaterialRegistry.register(new MaterialsAliases());

        MaterialRegistry.register(new MaterialsItemData());
        MaterialRegistry.register(new MaterialsTechnical());
        MaterialRegistry.register(new MaterialsOreCompounds());
        MaterialRegistry.register(new MaterialsRockMaterials());
        MaterialRegistry.register(new MaterialsWoodTypes());
        MaterialRegistry.register(new MaterialsUnused());
        MaterialRegistry.register(new MaterialsProcessingTargets());
        MaterialRegistry.register(new MaterialsForeignTables());

        MaterialRegistry.load();
    }

    /** True once the built in Categories have been registered. */
    public static boolean isInitialized() {
        return INITIALIZED;
    }
}
