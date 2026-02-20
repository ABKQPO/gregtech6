package gregtech6.mixins.early;

import net.minecraft.block.Block;
import net.minecraft.block.BlockIce;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockIce.class)
public abstract class MixinBlockIce extends Block {

    protected MixinBlockIce() {
        super(Material.ice);
    }

    @Redirect(
        method = "harvestBlock(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/EntityPlayer;IIII)V",
        at = @At(value = "INVOKE", target = "Ljava/lang/ThreadLocal;set(Ljava/lang/Object;)V"))
    private void silenceHarvesterSet(ThreadLocal<Object> threadLocal, Object value) {
        if (value == null) {
            return;
        }
        threadLocal.set(value);
    }

    @Inject(
        method = "harvestBlock(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/EntityPlayer;IIII)V",
        at = @At("RETURN"))
    private void afterHarvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta, CallbackInfo ci) {
        harvesters.set(null);
    }
}
