package gregtech6.mixins.late;

import net.minecraft.item.Item;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import gregtech6.mixins.ThaumcraftFixHelper;
import thaumcraft.common.lib.research.ScanManager;

@Mixin(value = ScanManager.class, remap = false)
public class MixinScanManager {

    @Inject(method = "generateItemHash(Lnet/minecraft/item/Item;I)I", at = @At("HEAD"), cancellable = true)
    private static void onGenerateItemHashHead(Item item, int meta, CallbackInfoReturnable<Integer> cir) {
        int cached = ThaumcraftFixHelper.getCachedItemHash(item, meta);
        if (cached != 0) {
            cir.setReturnValue(cached);
        }
    }

    @Inject(method = "generateItemHash(Lnet/minecraft/item/Item;I)I", at = @At("RETURN"), cancellable = true)
    private static void onGenerateItemHashReturn(Item item, int meta, CallbackInfoReturnable<Integer> cir) {
        int result = cir.getReturnValue();
        ThaumcraftFixHelper.setCachedItemHash(result, item, meta);
    }
}
