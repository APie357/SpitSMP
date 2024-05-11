package dev.andrewd1.spitsmp.item;

import dev.andrewd1.spitsmp.SpitSMP;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SPIT_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(SpitSMP.MOD_ID, "spit"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.spit"))
                    .icon(() -> new ItemStack(ModItems.SALIVA_GLAND))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SALIVA_GLAND);
                        entries.add(ModItems.FIRE_SALIVA_GLAND);
                        entries.add(ModItems.FLAME_SALIVA_GLAND);
                        entries.add(ModItems.EXPLODO_SALIVA_GLAND);
                        entries.add(ModItems.LIGHTNING_SALIVA_GLAND);
                        entries.add(ModItems.SILVER_SALIVA_GLAND);
                        entries.add(ModItems.SILVERER_SALIVA_GLAND);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        SpitSMP.LOGGER.info("Registering item groups...");
    }
}
