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

package gregapi;

import static gregapi.data.CS.*;

import net.minecraftforge.common.MinecraftForge;

import codechicken.nei.event.NEIRegisterHandlerInfosEvent;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import gregapi.recipes.Recipe.RecipeMap;

/**
 * Tells NEI how much Room a GT6 Recipe Page needs, because a GT6 Recipe Widget paints a whole Machine Page as its
 * Background, which is a lot bigger than the Page Size that NEI assumes for a Handler without Handler Info.
 * <p>
 * The newer NEI that GT5U uses only accepts Handler Info through this Event, which it sends right before it loads the
 * Mod Plugins, so this has to be subscribed while GT6 is still in its PreInit Phase. Recipe Maps that GT5U or another
 * Mod already has Handler Info for are left alone, so that their Recipe Pages stay exactly the way they were.
 */
public class NEI_GT_HandlerInfos {

    /** Set as soon as this got registered on the Event Bus, so that the Registration only happens once. */
    public static boolean sSubscribed = F;

    /** The GregTech New Horizons Fork of NEI is the only one that has the Event this needs. */
    public static boolean isGregTechHorizonsNEI() {
        return Loader.instance()
            .getIndexedModList()
            .get("NotEnoughItems")
            .getVersion()
            .contains("GTNH");
    }

    public static void subscribe() {
        if (!sSubscribed && CODE_CLIENT && isGregTechHorizonsNEI()) {
            sSubscribed = T;
            MinecraftForge.EVENT_BUS.register(new NEI_GT_HandlerInfos());
        }
    }

    @SubscribeEvent
    public void onRegisterHandlerInfos(NEIRegisterHandlerInfosEvent aEvent) {
        for (RecipeMap tMap : RecipeMap.RECIPE_MAP_LIST)
            if (tMap.mNEIAllowed) NEI_RecipeMap.registerHandlerInfo(aEvent, tMap);
    }
}
