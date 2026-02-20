package gregtech6.mixins.early;

import net.minecraft.server.MinecraftServer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MinecraftServer.class)
public class MixinMinecraftServerFix {

    @ModifyConstant(method = "run", constant = @Constant(longValue = 0L, ordinal = 0))
    private long redirectInitialTickTime(long original) {
        return 2001L;
    }
}
