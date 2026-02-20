package gregtech6.mixins.early;

import net.minecraft.entity.ai.EntityAICreeperSwell;
import net.minecraft.entity.monster.EntityCreeper;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import gregtech6.mixins.Replacements;

@Mixin(EntityAICreeperSwell.class)
public class MixinEntityAICreeperSwell {

    @Shadow
    EntityCreeper swellingCreeper;

    @Inject(method = "shouldExecute", at = @At("HEAD"), cancellable = true)
    private void redirectShouldExecute(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(Replacements.EntityAICreeperSwell_shouldExecute(this.swellingCreeper));
    }
}
