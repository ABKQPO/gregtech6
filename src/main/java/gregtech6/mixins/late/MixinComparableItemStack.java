package gregtech6.mixins.late;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import cofh.lib.inventory.ComparableItemStack;

@Pseudo
@Mixin(value = ComparableItemStack.class, remap = false)
public abstract class MixinComparableItemStack {

    @Shadow
    public int oreID;

    @Inject(method = { "hashCode", "equals" }, at = @At("HEAD"))
    private void onHashOrEquals(CallbackInfoReturnable<Integer> cir) {
        this.oreID = -1;
    }

    @Inject(method = "equals(Ljava/lang/Object;)Z", at = @At("HEAD"))
    private void onEquals(Object obj, CallbackInfoReturnable<Boolean> cir) {
        this.oreID = -1;
    }
}
