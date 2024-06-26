package dev.andrewd1.spitsmp.item;

import dev.andrewd1.spitsmp.SpitSMP;
import dev.andrewd1.spitsmp.item.items.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final SalivaGlandItem SALIVA_GLAND = (SalivaGlandItem) registerItem("saliva_gland", new SalivaGland(new FabricItemSettings()));
    public static final SalivaGlandItem FIRE_SALIVA_GLAND = (SalivaGlandItem) registerItem("fire_saliva_gland", new FireSalivaGland(new FabricItemSettings()));
    public static final SalivaGlandItem FLAME_SALIVA_GLAND = (SalivaGlandItem) registerItem("flame_saliva_gland", new FlameSalivaGland(new FabricItemSettings()));
    public static final SalivaGlandItem EXPLODO_SALIVA_GLAND = (SalivaGlandItem) registerItem("explodo_saliva_gland", new ExplodoSalivaGland(new FabricItemSettings()));
    public static final SalivaGlandItem LIGHTNING_SALIVA_GLAND = (SalivaGlandItem) registerItem("lightning_saliva_gland", new LightningSalivaGland(new FabricItemSettings()));
    public static final SalivaGlandItem SILVER_SALIVA_GLAND = (SalivaGlandItem) registerItem("silver_saliva_gland", new SilverSalivaGland(new FabricItemSettings()));
    public static final SalivaGlandItem SILVERER_SALIVA_GLAND = (SalivaGlandItem) registerItem("silverer_saliva_gland", new SilvererSalivaGland(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SpitSMP.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SpitSMP.LOGGER.info("Registering items...");
    }
}
