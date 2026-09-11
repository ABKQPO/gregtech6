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

package gregapi.compat.gt5u;

import static gregapi.data.CS.*;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import gregapi.api.Abstract_Mod;
import gregapi.code.ModData;
import gregapi.compat.CompatMods;
import gregapi.data.CS.ConfigsGT;

/**
 * Runs {@link GT5UMaterialBridge} when GregTech 5 Unofficial is installed.
 * <p>
 * It cannot simply use the Init phase the way the other Compat classes do, because a Material Variant can only be
 * handed over to GregTech 5 before the PrefixItems and PrefixBlocks register their OreDictionary entries, and that
 * happens while GAPI.mBeforeInit runs. Being the first entry of that list is what makes this run in time, and it still
 * runs after every other Mod finished its PreInit phase, which is when the GregTech 5 Material Table exists.
 * <p>
 * Reacting to the ModData means that the whole thing costs nothing when GregTech 5 is not installed, and the config
 * Key turns it off for anyone who wants the two Material Tables kept apart.
 */
public class Compat_Materials_GT5U extends CompatMods implements Runnable {

    public Compat_Materials_GT5U(ModData aMod, Abstract_Mod aGTMod) {
        super(aMod, aGTMod);
    }

    @Override
    public void onPreLoad(FMLPreInitializationEvent aEvent) {
        if (!ConfigsGT.GREGTECH.get("general", "GT5UMaterialCompat", T)) return;
        (GAPI.mBeforeInit == null ? GAPI.mBeforePostInit : GAPI.mBeforeInit).add(0, this);
    }

    @Override
    public void run() {
        GT5UMaterialBridge.apply();

        if (!GT5UMaterialSource.isAvailable()) {
            OUT.println(
                "GregTech 5 Material Compat: could not read the GregTech 5 Material Table ("
                    + GT5UMaterialSource.getUnavailableReason()
                    + "), keeping the GregTech 6 Materials as they are.");
            return;
        }

        OUT.println(
            "GregTech 5 Material Compat: " + GT5UMaterialBridge.getAdopted()
                .size()
                + " shared Materials took over GregTech 5 identity data, "
                + GT5UMaterialBridge.getCreated()
                    .size()
                + " GregTech 5 only Materials got one created, "
                + GT5UMaterialBridge.getGregTech6OnlyNames()
                    .size()
                + " GregTech 6 only Materials kept unchanged.");
        if (!GT5UMaterialBridge.getNotCreatedNames()
            .isEmpty())
            OUT.println(
                "GregTech 5 Material Compat: " + GT5UMaterialBridge.getNotCreatedNames()
                    .size()
                    + " GregTech 5 only Materials could not be created, their Variants stay GregTech 5's alone.");
        OUT.println(
            "GregTech 5 Material Compat: handed " + GT5UMaterialVariants.getHandedOverPairs()
                + " Material Variants over to GregTech 5, kept generating "
                + GT5UMaterialVariants.getAddedPairs()
                + " of the shared ones and "
                + GT5UMaterialVariants.getCreatedMaterialPairs()
                + " of the GregTech 5 only ones, spread over "
                + GT5UMaterialVariants.getPrefixesWithOwnVariants()
                    .size()
                + " Prefixes.");
        if (GT5UMaterialVariants.getMissingPairs() > 0) OUT.println(
            "GregTech 5 Material Compat: kept generating " + GT5UMaterialVariants.getMissingPairs()
                + " Material Variants that GregTech 5 reports but never registered.");
    }
}
