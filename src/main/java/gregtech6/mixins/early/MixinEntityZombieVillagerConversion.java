package gregtech6.mixins.early;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import gregtech6.mixins.Replacements;

@Mixin(EntityZombie.class)
public class MixinEntityZombieVillagerConversion {

    @Inject(
        method = "onKillEntity(Lnet/minecraft/entity/EntityLivingBase;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/monster/EntityMob;onKillEntity(Lnet/minecraft/entity/EntityLivingBase;)V",
            shift = At.Shift.AFTER),
        cancellable = true)
    private void redirectOnKillEntity(EntityLivingBase victim, CallbackInfo ci) {
        Replacements.EntityZombie_onKillEntity(this, victim);
        ci.cancel();
    }
}
