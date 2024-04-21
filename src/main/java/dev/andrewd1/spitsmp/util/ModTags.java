package dev.andrewd1.spitsmp.util;

import dev.andrewd1.spitsmp.SpitSMP;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> SALIVA_GLANDS = createTag("saliva_glands");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(SpitSMP.MOD_ID, name));
        }
    }
}
