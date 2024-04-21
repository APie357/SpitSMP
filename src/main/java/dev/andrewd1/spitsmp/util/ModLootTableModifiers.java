package dev.andrewd1.spitsmp.util;

import dev.andrewd1.spitsmp.SpitSMP;
import dev.andrewd1.spitsmp.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    public static final Identifier ENTITY_LLAMA_ID = new Identifier("minecraft", "entities/llama");
    public static final Identifier ENTITY_TRADER_LLAMA_ID = new Identifier("minecraft", "entities/trader_llama");

    public static void modifyLootTables() {
        SpitSMP.LOGGER.info("Modifying loot tables...");

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (ENTITY_LLAMA_ID.equals(id) || ENTITY_TRADER_LLAMA_ID.equals(id)) {
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.SALIVA_GLAND))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build())
                        .build()
                        ;

                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
