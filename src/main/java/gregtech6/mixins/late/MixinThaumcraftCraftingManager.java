package gregtech6.mixins.late;

import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import gregtech6.mixins.ThaumcraftFixHelper;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.lib.crafting.ThaumcraftCraftingManager;

@Mixin(value = ThaumcraftCraftingManager.class, remap = false)
public class MixinThaumcraftCraftingManager {

    @Inject(
        method = "getObjectTags(Lnet/minecraft/item/ItemStack;)Lthaumcraft/api/aspects/AspectList;",
        at = @At("HEAD"),
        cancellable = true)
    private static void onGetObjectTagsHead(ItemStack is, CallbackInfoReturnable<AspectList> cir) {
        AspectList cached = ThaumcraftFixHelper.getCachedAspectTags(is);
        if (cached != null) {
            cir.setReturnValue(cached);
        }
    }

    @Inject(
        method = "getObjectTags(Lnet/minecraft/item/ItemStack;)Lthaumcraft/api/aspects/AspectList;",
        at = @At("RETURN"))
    private static void onGetObjectTagsReturn(ItemStack is, CallbackInfoReturnable<AspectList> cir) {
        AspectList result = cir.getReturnValue();
        ThaumcraftFixHelper.setCachedAspectTags(result, is);
    }
}
