package gregtech6.mixins.late;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.dreammaster.thaumcraft.TCHelper;

import thaumcraft.api.research.ResearchCategories;

@Mixin(value = TCHelper.class, remap = false)
public class MixinTCHelper {

    @Inject(method = "removeResearch", at = @At("HEAD"), cancellable = true)
    private static void removeResearch(String research, CallbackInfo ci) {
        if (ResearchCategories.getResearch(research) == null) ci.cancel();
    }
}
