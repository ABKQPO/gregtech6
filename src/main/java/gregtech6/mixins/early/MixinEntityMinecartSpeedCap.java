package gregtech6.mixins.early;

import net.minecraft.entity.item.EntityMinecart;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityMinecart.class)
public class MixinEntityMinecartSpeedCap {

    @Inject(method = "getMaxCartSpeedOnRail", at = @At("HEAD"), cancellable = true, remap = false)
    private void redirectMaxSpeed(CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(4.0F);
    }
}
