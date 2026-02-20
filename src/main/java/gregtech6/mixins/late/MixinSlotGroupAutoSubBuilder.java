package gregtech6.mixins.late;

import java.util.Arrays;
import java.util.Iterator;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.github.dcysteine.neicustomdiagram.api.diagram.Diagram;
import com.github.dcysteine.neicustomdiagram.api.diagram.component.DisplayComponent;
import com.github.dcysteine.neicustomdiagram.api.diagram.layout.Slot;

@Pseudo
@Mixin(
    targets = "com.github.dcysteine.neicustomdiagram.api.diagram.Diagram$Builder$SlotGroupAutoSubBuilder",
    remap = false)
public abstract class MixinSlotGroupAutoSubBuilder {

    @Shadow
    @Final
    private Iterator<Slot> slotIterator;

    @Shadow
    public abstract Diagram.Builder.SlotGroupAutoSubBuilder insertEachSafe(Iterable<DisplayComponent> components);

    @Inject(
        method = "insertIntoNextSlot([Lcom/github/dcysteine/neicustomdiagram/api/diagram/component/DisplayComponent;)Lcom/github/dcysteine/neicustomdiagram/api/diagram/Diagram$Builder$SlotGroupAutoSubBuilder;",
        at = @At("HEAD"),
        cancellable = true)
    private void redirectArrayInsertToSafe(DisplayComponent[] components, CallbackInfoReturnable<Object> cir) {
        if (components == null || components.length == 0) {
            cir.setReturnValue(this);
            return;
        }

        if (!this.slotIterator.hasNext()) {
            cir.setReturnValue(this.insertEachSafe(Arrays.asList(components)));
        }
    }
}
