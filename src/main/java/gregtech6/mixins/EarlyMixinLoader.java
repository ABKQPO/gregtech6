package gregtech6.mixins;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;

import gregtech6.asm.GT_ASM;

public class EarlyMixinLoader {

    private static final Map<String, BooleanSupplier> MIXIN_CONFIGS = new LinkedHashMap<>();

    static {
        addMixinCFG("mixins.gregtech6.early.json");
    }

    public static List<String> getMixinConfigs() {
        return new ArrayList<>(MIXIN_CONFIGS.keySet());
    }

    public static boolean shouldMixinConfigQueue(final String mixinConfig) {
        var supplier = MIXIN_CONFIGS.get(mixinConfig);
        if (supplier == null) {
            GT_ASM.logger.warn(
                "Gregtech 6: " + "Mixin config {} is not found in config map! It will never be loaded.",
                mixinConfig);
            return false;
        }
        return supplier.getAsBoolean();
    }

    private static void addMixinCFG(final String mixinConfig) {
        MIXIN_CONFIGS.put(mixinConfig, () -> true);
    }

    private static void addMixinCFG(final String mixinConfig, final BooleanSupplier conditions) {
        MIXIN_CONFIGS.put(mixinConfig, conditions);
    }

}
