package gregtech6.mixins;

import java.util.Arrays;
import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IntHashMap;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.AspectList;

public class ThaumcraftFixHelper {

    private static final HashMap<Item, IntHashMap> cacheItemHash = new HashMap<>();
    private static final HashMap<Item, IntHashMap> cacheAspectTags = new HashMap<>();

    public static int getCachedItemHash(Item item, int meta) {
        if (item == null) return -1;
        synchronized (cacheItemHash) {
            IntHashMap metaMap = cacheItemHash.get(item);
            if (metaMap != null) {
                Integer hash = (Integer) metaMap.lookup(meta);
                if (hash != null) return hash;
                hash = (Integer) metaMap.lookup(-1);
                if (hash != null) return hash;
                int[] grouped = ThaumcraftApi.groupedObjectTags.get(Arrays.asList(item, meta));
                if (grouped != null) {
                    hash = (Integer) metaMap.lookup(grouped[0]);
                    if (hash != null) return hash;
                }
            }
        }
        return 0;
    }

    public static int setCachedItemHash(int hash, Item item, int meta) {
        synchronized (cacheItemHash) {
            IntHashMap metaMap = cacheItemHash.get(item);
            if (metaMap == null) cacheItemHash.put(item, metaMap = new IntHashMap());
            metaMap.addKey(meta, hash);
            return hash;
        }
    }

    public static AspectList getCachedAspectTags(ItemStack is) {
        if (is == null || is.getItem() == null) return null;
        synchronized (cacheAspectTags) {
            IntHashMap metaMap = cacheAspectTags.get(is.getItem());
            if (metaMap != null) {
                AspectList aspects = (AspectList) metaMap.lookup(is.getItemDamage());
                if (aspects != null) return aspects.copy();
            }
        }
        return null;
    }

    public static AspectList setCachedAspectTags(AspectList aspects, ItemStack is) {
        synchronized (cacheAspectTags) {
            if (aspects == null || is == null || is.getItem() == null) return null;
            IntHashMap metaMap = cacheAspectTags.get(is.getItem());
            if (metaMap == null) cacheAspectTags.put(is.getItem(), metaMap = new IntHashMap());
            metaMap.addKey(is.getItemDamage(), aspects.copy());
            return aspects;
        }
    }
}
