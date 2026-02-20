package gregtech6.mixins.late;

import net.minecraft.item.Item;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import cofh.lib.util.ComparableItem;

@Pseudo
@Mixin(value = ComparableItem.class, remap = false)
public abstract class MixinComparableItem {

    @Shadow
    public Item item;

    @Inject(method = "hashCode", at = @At("HEAD"), cancellable = true)
    private void hashCode(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(System.identityHashCode(this.item));
    }
}
