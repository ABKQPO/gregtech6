package gregtech6.mixins.late;

import net.minecraftforge.oredict.OreDictionary;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import mods.railcraft.common.modules.orehandlers.BoreOreHandler;

@Mixin(value = BoreOreHandler.class, remap = false)
public class MixinRailcraftBoreSpamFix {

    @Inject(method = "onOreEvent", at = @At("HEAD"), cancellable = true, remap = false)
    private void stopBoreSpam(OreDictionary.OreRegisterEvent event, CallbackInfo ci) {
        ci.cancel();
    }
}
