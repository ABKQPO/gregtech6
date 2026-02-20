package gregtech6.mixins.late;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.glodblock.github.util.ModAndClassUtil;

@Mixin(value = ModAndClassUtil.class, remap = false)
public class MixinModAndClassUtil {

    @Inject(method = "init", at = @At("TAIL"))
    private static void onGenerateItemHashHead(CallbackInfo ci) {
        try {
            Class.forName("gregtech.api.recipe.RecipeMap");
            ModAndClassUtil.GT5NH = true;
        } catch (ClassNotFoundException e) {
            ModAndClassUtil.GT5 = true;
        }
    }
}
