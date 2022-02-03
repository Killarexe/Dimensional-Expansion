package net.killarexe.dimensional_expansion.common.data;

import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

import static net.killarexe.dimensional_expansion.core.init.DEBlocks.*;
import static net.killarexe.dimensional_expansion.core.init.DEItems.*;
import static net.minecraft.world.item.Items.*;
import static net.minecraft.world.item.crafting.RecipeSerializer.*;

public class DERecipeProvider extends RecipeProvider implements IConditionBuilder {

    public DERecipeProvider(DataGenerator p_125973_) {
        super(p_125973_);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> r) {
        createSmelting(r, PALON_ORE.get(), PALON_INGOT.get(), 0.1f, 200, BLASTING_RECIPE);
        createSmelting(r, RAW_PALON.get(), PALON_INGOT.get(), 0.5f, 201, BLASTING_RECIPE);
        createMaterialIngotRecipe(r, PALON_NUGGET.get(), PALON_INGOT.get());
        createMaterialRecipe(r, PALON_NUGGET.get(), PALON_INGOT.get());
        createOreBlockRecipe(r, PALON_BLOCK.get(), PALON_INGOT.get());
        createSmelting(r, BASSMITE_ORE.get(), BASSMITE_GEM.get(), 0.1f, 200, BLASTING_RECIPE);
        createMaterialRecipe(r, BASSMITE_GEM.get(), BASSMITE_BLOCK.get());
        createOreBlockRecipe(r, BASSMITE_BLOCK.get(), BASSMITE_GEM.get());
        createSmelting(r, SIMIX_ORE.get(), SIMIX_INGOT.get(), 0.1f, 200, BLASTING_RECIPE);
        createSmelting(r, RAW_SIMIX.get(), SIMIX_INGOT.get(), 0.1f, 200, BLASTING_RECIPE);
        createMaterialRecipe(r, SIMIX_INGOT.get(), SIMIX_BLOCK.get());
        createMaterialRecipe(r, SIMIX_NUGGET.get(), SIMIX_INGOT.get());
        createOreBlockRecipe(r, SIMIX_BLOCK.get(), SIMIX_INGOT.get());
        createSmelting(r, EMERTYST_ORE.get(), EMERTYST_GEM.get(), 0.1f, 200, BLASTING_RECIPE);;
        createMaterialRecipe(r, EMERTYST_GEM.get(), EMERTYST_BLOCK.get());
        createOreBlockRecipe(r, EMERTYST_BLOCK.get(), EMERTYST_GEM.get());
        createMixRecipe(r, PALON_MIXED_COAL.get(), PALON_INGOT.get(), COAL);
        createMixRecipe(r, BASSMITE_MIXED_COAL.get(), BASSMITE_GEM.get(), COAL);
        createMixRecipe(r, SIMIX_MIXED_COAL.get(), SIMIX_INGOT.get(), COAL);
        createMixRecipe(r, EMERTYST_MIXED_COAL.get(), EMERTYST_GEM.get(), COAL);

        createSlabRecipe(r, END_SLAB.get(), END_PLANKS.get());
        createStairsRecipe(r, END_STAIRS.get(), END_PLANKS.get());
        createFenceRecipe(r, END_FENCE.get(), END_PLANKS.get());
        createFenceGateRecipe(r, END_FENCE_GATE.get(), END_PLANKS.get());
        createPressurePlateRecipe(r, END_PRESSURE_PLATE.get(), END_PLANKS.get());
        createButtonRecipe(r, END_BUTTON.get(), END_PLANKS.get());
        createDoorRecipe(r, END_DOOR.get(), END_PLANKS.get());
        createTrapDoorRecipe(r, END_TRAPDOOR.get(), END_PLANKS.get());
        createSignRecipe(r, DEItems.END_SIGN.get(), END_PLANKS.get());
    }

    private void createDoorRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(resultItem, 3).define('#', requireItem)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createTrapDoorRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(resultItem, 6).define('#', requireItem)
                .pattern("###")
                .pattern("###")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createSignRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(resultItem, 6).define('#', requireItem).define('/', STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" / ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createPressurePlateRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(resultItem, 2).define('#', requireItem)
                .pattern("   ")
                .pattern("## ")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createSlabRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(resultItem, 6).define('#', requireItem)
                .pattern("   ")
                .pattern("###")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createButtonRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(resultItem).define('#', requireItem)
                .pattern("   ")
                .pattern(" # ")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createStairsRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(resultItem, 6).define('#', requireItem)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createFenceRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(resultItem, 3).define('#', requireItem).define('/', Items.STICK)
                .pattern("#/#")
                .pattern("#/#")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createFenceGateRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(resultItem, 3).define('#', requireItem).define('/', Items.STICK)
                .pattern("/#/")
                .pattern("/#/")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createOreBlockRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(resultItem).define('#', requireItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createMaterialIngotRecipe(Consumer<FinishedRecipe> r, ItemLike nuggetItem, ItemLike resultItem){
        ShapedRecipeBuilder.shaped(nuggetItem).define('#', resultItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_material", has(resultItem))
                .save(r);
    }

    private void createMaterialRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(resultItem, 9).define('#', requireItem)
                .pattern("   ")
                .pattern(" # ")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createMixRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem, ItemLike requireItem, ItemLike requireItem1){
        ShapedRecipeBuilder.shaped(resultItem, 9).define('1', requireItem).define('2', requireItem1)
                .pattern("   ")
                .pattern(" 12")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createCustomRecipe(Consumer<FinishedRecipe> r,
                                    ItemLike requireItem1, ItemLike requireItem2, ItemLike requireItem3,
                                    ItemLike requireItem4, ItemLike requireItem5, ItemLike requireItem6,
                                    ItemLike requireItem7, ItemLike requireItem8, ItemLike requireItem9,
                                    ItemLike resultItem){
        ShapedRecipeBuilder.shaped(resultItem)
                .define('1', requireItem1).define('2', requireItem2).define('3', requireItem3)
                .define('4', requireItem4).define('5', requireItem5).define('6', requireItem6)
                .define('7', requireItem7).define('8', requireItem8).define('9', requireItem9)
                .pattern("123")
                .pattern("456")
                .pattern("789")
                .unlockedBy("has_material", has(resultItem))
                .save(r);
    }

    private void createSmelting(Consumer<FinishedRecipe> r, ItemLike smeltItem, ItemLike resultItem, float time, int xp, SimpleCookingSerializer<?> type){
        SimpleCookingRecipeBuilder.cooking(Ingredient.of(new ItemStack(smeltItem)), resultItem, time, xp, type);
    }
}
