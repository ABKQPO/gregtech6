package gregtech6.mixins.late;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import cofh.core.util.FMLEventHandler;

@Pseudo
@Mixin(value = FMLEventHandler.class, remap = false)
public abstract class MixinCoFHCrashFix {

    @Redirect(
        method = "handleIdMappingEvent",
        at = @At(value = "INVOKE", target = "Lcofh/core/util/oredict/OreDictionaryArbiter;initialize()V"),
        require = 0)
    private void redirectOreDictInitialize() {}
}
