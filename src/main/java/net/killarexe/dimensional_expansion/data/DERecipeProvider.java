package net.killarexe.dimensional_expansion.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

import static net.killarexe.dimensional_expansion.core.init.DEBlocks.*;
import static net.killarexe.dimensional_expansion.core.init.DEItems.*;
import static net.minecraft.world.item.crafting.RecipeSerializer.BLASTING_RECIPE;

public class DERecipeProvider extends RecipeProvider implements IConditionBuilder {

    public DERecipeProvider(DataGenerator p_125973_) {
        super(p_125973_);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> r) {
        createOreSmelting(r, PALON_ORE.get(), PALON_INGOT.get(), 0.1f, 200, BLASTING_RECIPE);
        createOreSmelting(r, RAW_PALON.get(), PALON_INGOT.get(), 0.1f, 200, BLASTING_RECIPE);
        createMaterialRecipe(r, PALON_INGOT.get(), PALON_BLOCK.get());
        createMaterialRecipe(r, PALON_INGOT.get(), PALON_NUGGET.get());
        createOreBlockRecipe(r, PALON_BLOCK.get(), PALON_INGOT.get());
        createOreSmelting(r, BASSMITE_ORE.get(), BASSMITE_GEM.get(), 0.1f, 200, BLASTING_RECIPE);
        createMaterialRecipe(r, BASSMITE_GEM.get(), BASSMITE_BLOCK.get());
        createOreBlockRecipe(r, BASSMITE_BLOCK.get(), BASSMITE_GEM.get());
        createOreSmelting(r, SIMIX_ORE.get(), SIMIX_INGOT.get(), 0.1f, 200, BLASTING_RECIPE);
        createOreSmelting(r, RAW_SIMIX.get(), SIMIX_INGOT.get(), 0.1f, 200, BLASTING_RECIPE);
        createMaterialRecipe(r, SIMIX_INGOT.get(), SIMIX_BLOCK.get());
        createMaterialRecipe(r, SIMIX_INGOT.get(), SIMIX_NUGGET.get());
        createOreBlockRecipe(r, SIMIX_BLOCK.get(), SIMIX_INGOT.get());
        createOreSmelting(r, PALON_ORE.get(), PALON_INGOT.get(), 0.1f, 200, BLASTING_RECIPE);;
        createMaterialRecipe(r, EMERTYST_GEM.get(), EMERTYST_BLOCK.get());
        createOreBlockRecipe(r, EMERTYST_BLOCK.get(), EMERTYST_GEM.get());

        createDoorRecipe(r, END_DOOR.get(), END_PLANKS.get().asItem());
        createTrapDoorRecipe(r, END_TRAPDOOR.get(), END_PLANKS.get().asItem());
    }

    private void createDoorRecipe(Consumer<FinishedRecipe> r, Block resultBlock, Item requireItem){
        ShapedRecipeBuilder.shaped(resultBlock).define('#', requireItem)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createTrapDoorRecipe(Consumer<FinishedRecipe> r, Block resultBlock, Item requireItem){
        ShapedRecipeBuilder.shaped(resultBlock).define('#', requireItem)
                .pattern("###")
                .pattern("###")
                .pattern("  ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createOreBlockRecipe(Consumer<FinishedRecipe> r, Block resultBlock, Item requireItem){
        ShapedRecipeBuilder.shaped(resultBlock).define('#', requireItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createMaterialRecipe(Consumer<FinishedRecipe> r, Item nuggetItem, Item resultItem){
        ShapedRecipeBuilder.shaped(nuggetItem).define('#', resultItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_material", has(resultItem))
                .save(r);
    }

    private void createMaterialRecipe(Consumer<FinishedRecipe> r, Item resultItem, Block requireBlock){
        ShapedRecipeBuilder.shaped(resultItem).define('#', requireBlock.asItem())
                .pattern("   ")
                .pattern(" # ")
                .pattern("   ")
                .unlockedBy("has_material", has(requireBlock.asItem()))
                .save(r);
    }

    private void createOreSmelting(Consumer<FinishedRecipe> r, Block smeltBlock, Item resultItem, float time, int xp, SimpleCookingSerializer<?> type){
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(new ItemStack(smeltBlock)), resultItem, time, xp, type);
    }

    private void createOreSmelting(Consumer<FinishedRecipe> r, Item smeltItem, Item resultItem, float time, int xp, SimpleCookingSerializer<?> type){
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(new ItemStack(smeltItem)), resultItem, time, xp, type);
    }
}
