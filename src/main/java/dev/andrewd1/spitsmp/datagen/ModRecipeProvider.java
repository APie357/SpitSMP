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

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLAME_SALIVA_GLAND, 1)
                .pattern("TGT")
                .pattern("DFD")
                .pattern("BAB")
                .input('T', Items.GHAST_TEAR)
                .input('G', Items.RAW_GOLD_BLOCK)
                .input('D', Items.DIAMOND_BLOCK)
                .input('F', ModItems.FIRE_SALIVA_GLAND)
                .input('B', Items.BLAZE_ROD)
                .input('A', Items.DIAMOND)
                .criterion(RecipeProvider.hasItem(ModItems.SALIVA_GLAND), RecipeProvider.conditionsFromItem(ModItems.SALIVA_GLAND))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FLAME_SALIVA_GLAND)))
                ;

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EXPLODO_SALIVA_GLAND, 1)
                .pattern("TDT")
                .pattern("AGA")
                .pattern("IAI")
                .input('T', Items.TNT)
                .input('D', Items.DIAMOND_BLOCK)
                .input('A', Items.DIAMOND)
                .input('G', ModItems.SALIVA_GLAND)
                .input('I', Items.RAW_IRON_BLOCK)
                .criterion(RecipeProvider.hasItem(ModItems.SALIVA_GLAND), RecipeProvider.conditionsFromItem(ModItems.SALIVA_GLAND))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EXPLODO_SALIVA_GLAND)))
                ;

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LIGHTNING_SALIVA_GLAND, 1)
                .pattern("CNC")
                .pattern("DGD")
                .pattern("ARA")
                .input('C', Items.FIRE_CHARGE)
                .input('N', Items.NETHERITE_INGOT)
                .input('D', Items.DIAMOND_BLOCK)
                .input('G', ModItems.SALIVA_GLAND)
                .input('A', Items.DIAMOND)
                .input('R', Items.LIGHTNING_ROD)
                .criterion(RecipeProvider.hasItem(ModItems.SALIVA_GLAND), RecipeProvider.conditionsFromItem(ModItems.SALIVA_GLAND))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LIGHTNING_SALIVA_GLAND)))
                ;
    }
}
