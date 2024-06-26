package dev.andrewd1.spitsmp.datagen;

import dev.andrewd1.spitsmp.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SALIVA_GLAND, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_SALIVA_GLAND, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLAME_SALIVA_GLAND, Models.GENERATED);
        itemModelGenerator.register(ModItems.EXPLODO_SALIVA_GLAND, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIGHTNING_SALIVA_GLAND, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_SALIVA_GLAND, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVERER_SALIVA_GLAND, Models.GENERATED);
    }
}
