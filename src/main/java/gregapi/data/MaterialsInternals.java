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
 * The placeholders and particles every other Material definition relies on.
 * <p>
 * Loaded as the "Internals" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsInternals implements IMaterialCategory {

    @Override
    public String getName() {
        return "Internals";
    }

    @Override
    public void load() {
        // Technical Material describing a Nullpointer
        MT.NULL = MT.create(-1, "NULL")
            .setStatsElement(0, 0, 0, 0, 0)
            .put(INVALID_MATERIAL, DONT_SHOW_THIS_COMPONENT);
        // Material for empty Containers.
        MT.Empty = MT.create(0, "Empty")
            .setStatsElement(0, 0, 0, 0, 0)
            .put(EMPTY, AUTO_BLACKLIST, DONT_SHOW_THIS_COMPONENT);
        MT.Photon = MT.y = MT.create(1, "Photon")
            .setStatsElement(0, 0, 0, 0, 0)
            .heat(0, 0, 0)
            .setRGBa(255, 255, 255, 255)
            .put(PARTICLE)
            .tooltip("y")
            .hide();
        MT.Neutrino = MT.v = MT.create(2, "Neutrino")
            .setStatsElement(0, 0, 0, 0, 0)
            .heat(0, 0, 0)
            .setRGBa(180, 180, 180, 0)
            .put(PARTICLE)
            .tooltip("v")
            .hide();
        MT.Neutron = MT.n = MT.create(3, "Neutron")
            .setStatsElement(0, 0, 1, 0, 0)
            .heat(0, 0, 0)
            .setRGBa(128, 128, 128, 0)
            .put(PARTICLE)
            .tooltip("n")
            .hide();
        MT.Proton = MT.p = MT.create(4, "Proton")
            .setStatsElement(1, 0, 0, 0, 0)
            .heat(0, 0, 0)
            .setRGBa(255, 0, 0, 0)
            .put(PARTICLE)
            .tooltip("p")
            .hide();
        MT.Electron = MT.e = MT.create(5, "Electron")
            .setStatsElement(0, 1, 0, 0, 0)
            .heat(0, 0, 0)
            .setRGBa(0, 0, 255, 0)
            .put(PARTICLE)
            .tooltip("e")
            .hide();
        MT.Magic = MT.Ma = MT.create(4000, "Magic")
            .setStatsElement(0, 0, 0, -1, 0)
            .heat(0, 0, 0)
            .setRGBa(255, 0, 255, 0)
            .setTextures(SET_SHINY)
            .put(ELEMENT, MAGICAL, UNBURNABLE)
            .tooltip("Ma")
            .hide()
            .qual(3, 10.0, 5120, 5);
    }
}
