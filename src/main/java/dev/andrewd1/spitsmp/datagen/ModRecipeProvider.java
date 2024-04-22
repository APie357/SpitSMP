package dev.andrewd1.spitsmp.datagen;

import dev.andrewd1.spitsmp.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FIRE_SALIVA_GLAND, 1)
                .pattern("MGM")
                .pattern("DSD")
                .pattern("FBF")
                .input('M', Items.MAGMA_CREAM)
                .input('G', Items.RAW_GOLD_BLOCK)
                .input('D', Items.DIAMOND)
                .input('S', ModItems.SALIVA_GLAND)
                .input('F', Items.FIRE_CHARGE)
                .input('B', Items.BLAZE_ROD)
                .criterion(RecipeProvider.hasItem(ModItems.SALIVA_GLAND), RecipeProvider.conditionsFromItem(ModItems.SALIVA_GLAND))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FIRE_SALIVA_GLAND)))
                ;
    }
}
