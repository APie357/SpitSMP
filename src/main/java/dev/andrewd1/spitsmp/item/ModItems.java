package dev.andrewd1.spitsmp.item;

import dev.andrewd1.spitsmp.SpitSMP;
import dev.andrewd1.spitsmp.item.items.FireSalivaGland;
import dev.andrewd1.spitsmp.item.items.SalivaGland;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SALIVA_GLAND = registerItem("saliva_gland", new SalivaGland(new FabricItemSettings()));
    public static final Item FIRE_SALIVA_GLAND = registerItem("fire_saliva_gland", new FireSalivaGland(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SpitSMP.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SpitSMP.LOGGER.info("Registering items...");
    }
}
