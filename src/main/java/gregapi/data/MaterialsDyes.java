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
 * The sixteen Dye Materials.
 * <p>
 * Loaded as the "Dyes" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsDyes implements IMaterialCategory {

    @Override
    public String getName() {
        return "Dyes";
    }

    @Override
    public void load() {
        MT.Black = MT.dye(8250, "Black", 32, 32, 32);
        MT.Red = MT.dye(8251, "Red", 255, 0, 0);
        MT.Green = MT.dye(8252, "Green", 0, 255, 0);
        MT.Brown = MT.dye(8253, "Brown", 96, 64, 0);
        MT.Blue = MT.dye(8254, "Blue", 0, 0, 255);
        MT.Purple = MT.dye(8255, "Purple", 128, 0, 128);
        MT.Cyan = MT.dye(8256, "Cyan", 0, 255, 255);
        MT.LightGray = MT.dye(8257, "Light Gray", 192, 192, 192);
        MT.Gray = MT.dye(8258, "Gray", 128, 128, 128);
        MT.Pink = MT.dye(8259, "Pink", 255, 192, 192);
        MT.Lime = MT.dye(8260, "Lime", 128, 255, 128);
        MT.Yellow = MT.dye(8261, "Yellow", 255, 255, 0);
        MT.LightBlue = MT.dye(8262, "Light Blue", 128, 128, 255);
        MT.Magenta = MT.dye(8263, "Magenta", 255, 0, 255);
        MT.Orange = MT.dye(8264, "Orange", 255, 128, 0);
        MT.White = MT.dye(8265, "White", 255, 255, 255);
    }
}
