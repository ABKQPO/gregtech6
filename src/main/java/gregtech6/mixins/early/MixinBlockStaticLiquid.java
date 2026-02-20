package gregtech6.mixins.early;

import java.util.Random;

import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import gregtech6.mixins.Replacements;

@Mixin(BlockStaticLiquid.class)
public abstract class MixinBlockStaticLiquid {

    /**
     * Replace isFlammable
     */
    @Inject(method = "isFlammable", at = @At("HEAD"), cancellable = true)
    private void gt6_fixIsFlammable(World world, int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(Replacements.BlockStaticLiquid_isFlammable(world, x, y, z));
    }

    /**
     * Replace updateTick
     */
    @Inject(method = "updateTick", at = @At("HEAD"), cancellable = true)
    private void gt6_fixUpdateTick(World world, int x, int y, int z, Random rand, CallbackInfo ci) {

        Replacements.BlockStaticLiquid_updateTick((BlockStaticLiquid) (Object) this, world, x, y, z, rand);

        ci.cancel();
    }
}
