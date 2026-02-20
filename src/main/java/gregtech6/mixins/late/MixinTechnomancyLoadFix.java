package gregtech6.mixins.late;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "theflogat.technomancy.util.Ore", remap = false)
public class MixinTechnomancyLoadFix {

    @Inject(method = "init()V", at = @At("HEAD"), cancellable = true, remap = false)
    private static void cancelSlowInit(CallbackInfo ci) {
        ci.cancel();
    }
}
