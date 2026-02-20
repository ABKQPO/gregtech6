package gregtech6.mixins.late;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "com.rwtema.extrautils.helper.ThaumcraftHelper", remap = false)
public abstract class MixinThaumcraftHelper {

    @Inject(method = "registerItems", at = @At("HEAD"), cancellable = true)
    private static void onRegisterItems(CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "handleQEDRecipes", at = @At("HEAD"), cancellable = true)
    private static void onHandleQEDRecipes(CallbackInfo ci) {
        ci.cancel();
    }
}
