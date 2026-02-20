package gregtech6.mixins.late;

import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import codechicken.microblock.handler.MicroblockProxy_serverImpl;
import gregapi.log.LoggerFML;

@Mixin(value = MicroblockProxy_serverImpl.class, remap = false)
public class MixinMicroblockProxyFix {

    @Unique
    private static final Logger FAKE_LOGGER = new LoggerFML("FMB");

    @Inject(method = "logger", at = @At("HEAD"), cancellable = true)
    private void proxyLogger(CallbackInfoReturnable<Logger> cir) {
        cir.setReturnValue(FAKE_LOGGER);
    }
}
