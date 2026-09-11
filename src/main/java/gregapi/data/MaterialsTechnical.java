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
 * Technical Materials that only exist for Recipes and for naming, plus the deprecated Alias block.
 * <p>
 * Loaded as the "Technical Materials" Category of the Material Table, which the Material
 * Registry executes in registration order.
 */
public class MaterialsTechnical implements IMaterialCategory {

    @Override
    public String getName() {
        return "Technical Materials";
    }

    @Override
    public void load() {
        MT.TECH.Brick = MT.Brick;
        MT.TECH.AnyGlowstone = ANY.Glowstone;
        MT.TECH.AnyWax = ANY.Wax;
        MT.TECH.AnyWood = ANY.Wood;
        MT.TECH.AnyStone = ANY.Stone;
        MT.TECH.AnyClay = ANY.Clay;
        MT.TECH.AnyIron = ANY.Fe;
        MT.TECH.AnyIronSteel = ANY.Steel;
        MT.TECH.AnyCopper = ANY.Cu;
        MT.TECH.AnySilicon = ANY.Si;
        MT.TECH.AnyTungsten = ANY.W;
        MT.TECH.AnyThaumicCrystal = ANY.ThaumCrystal;
        MT.TECH.AnySalt = ANY.Salt;
        MT.TECH.AnySteel = ANY._Steel;
        MT.TECH.AnyBronze = ANY._Bronze;
        MT.TECH.AnyMetal = ANY._Metal;;
        MT.TECH.Organic = MT.invalid("Organic")

            .put(IGNORE_IN_COLOR_LOG, DONT_SHOW_THIS_COMPONENT);
        MT.TECH.Crystal = MT.invalid("Crystal")
            .put(IGNORE_IN_COLOR_LOG, DONT_SHOW_THIS_COMPONENT, BRITTLE, CRYSTAL);
        MT.TECH.Unknown = MT.invalid("Unknown")
            .put(IGNORE_IN_COLOR_LOG, DONT_SHOW_THIS_COMPONENT);
        MT.TECH.Cobblestone = MT.invalid("Cobblestone")
            .put(IGNORE_IN_COLOR_LOG, DONT_SHOW_THIS_COMPONENT, UNRECYCLABLE);
        MT.TECH.RefinedIron = MT.invalid("RefinedIron")
            .stealLooks(MT.HSLA)

            .steal(MT.WroughtIron)

            .setLocal("Refined Iron")

            .setAllToTheOutputOf(MT.Fe)

            .put(IGNORE_IN_COLOR_LOG, SMITHABLE, MELTING)

            .addReRegistrationToThis(MT.WroughtIron);;
    }
}
