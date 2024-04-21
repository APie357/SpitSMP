package dev.andrewd1.spitsmp.datagen;

import dev.andrewd1.spitsmp.item.ModItems;
import dev.andrewd1.spitsmp.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.SALIVA_GLANDS)
                .add(ModItems.SALIVA_GLAND)
                .add(ModItems.FIRE_SALIVA_GLAND)
                ;
    }
}
