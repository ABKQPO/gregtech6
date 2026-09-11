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

/**
 * One loadable slice of the Material registration.
 * <p>
 * A Category owns a contiguous part of the registration sequence and assigns the Material fields it is responsible
 * for. Categories are loaded in registration order, so a Category may rely on everything the earlier Categories
 * assigned. Implementations must stay stateless: they may not declare static fields, because the Registry is
 * executed while the Material Table is still initialising and any static state would introduce a class initialisation
 * cycle.
 */
public interface IMaterialCategory {

    /** The Name of this Category, only used for diagnostics and log output. */
    String getName();

    /**
     * Assigns the Material fields of this Category. Called at most once per Game Session, from the Registry thread.
     */
    void load();
}
