/**
 * Copyright (c) 2022 GregTech-6 Team
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

package gregtech6.asm;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.relauncher.IFMLCallHook;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.Name;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.SortingIndex;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;
import gregtech6.mixins.EarlyMixinLoader;
import io.github.tox1cozz.mixinbooterlegacy.IEarlyMixinLoader;

@Name("Greg-ASM®")
@MCVersion("1.7.10")
@SortingIndex(1000) // Sorting index with other coremods, for example DragonAPI is 1001
@TransformerExclusions({ "gregtech6.asm" }) // Array of strings of package or class names to ignore for this coremod
public class GT_ASM implements IFMLLoadingPlugin, IEarlyMixinLoader, IFMLCallHook {

    public static final Logger logger = LogManager.getLogger(GT_ASM.class.getSimpleName());

    public GT_ASM() {}

    @Override
    public void injectData(Map<String, Object> data) {}

    @Override
    public String[] getASMTransformerClass() {
        return null;
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return "gregtech6.asm.GT_ASM";
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    @Override
    public Void call() throws Exception {
        return null;
    }

    @Override
    public List<String> getMixinConfigs() {
        return EarlyMixinLoader.getMixinConfigs();
    }

    @Override
    public boolean shouldMixinConfigQueue(final String mixinConfig) {
        return EarlyMixinLoader.shouldMixinConfigQueue(mixinConfig);
    }
}
