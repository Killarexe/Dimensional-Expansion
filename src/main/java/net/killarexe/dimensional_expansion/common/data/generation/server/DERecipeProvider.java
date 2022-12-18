package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

import static net.killarexe.dimensional_expansion.core.init.DEBlocks.*;
import static net.killarexe.dimensional_expansion.core.init.DEItems.*;
import static net.minecraft.world.item.Items.*;
import static net.minecraft.world.item.crafting.RecipeSerializer.BLASTING_RECIPE;

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
        createSmelting(r, EMERTYST_ORE.get(), EMERTYST_GEM.get(), 0.1f, 200, BLASTING_RECIPE);
        createMaterialRecipe(r, EMERTYST_GEM.get(), EMERTYST_BLOCK.get());
        createOreBlockRecipe(r, EMERTYST_BLOCK.get(), EMERTYST_GEM.get());
        createMixRecipe(r, PALON_MIXED_COAL.get(), PALON_INGOT.get(), COAL);
        createMixRecipe(r, BASSMITE_MIXED_COAL.get(), BASSMITE_GEM.get(), COAL);
        createMixRecipe(r, SIMIX_MIXED_COAL.get(), SIMIX_INGOT.get(), COAL);
        createMixRecipe(r, EMERTYST_MIXED_COAL.get(), EMERTYST_GEM.get(), COAL);

        createSlabRecipe(r, PURPLEHEART_SLAB.get(), PURPLEHEART_PLANKS.get());
        createStairsRecipe(r, PURPLEHEART_STAIRS.get(), PURPLEHEART_PLANKS.get());
        createFenceRecipe(r, PURPLEHEART_FENCE.get(), PURPLEHEART_PLANKS.get());
        createFenceGateRecipe(r, PURPLEHEART_FENCE_GATE.get(), PURPLEHEART_PLANKS.get());
        createPressurePlateRecipe(r, PURPLEHEART_PRESSURE_PLATE.get(), PURPLEHEART_PLANKS.get());
        createButtonRecipe(r, PURPLEHEART_BUTTON.get(), PURPLEHEART_PLANKS.get());
        createDoorRecipe(r, PURPLEHEART_DOOR.get(), PURPLEHEART_PLANKS.get());
        createTrapDoorRecipe(r, PURPLEHEART_TRAPDOOR.get(), PURPLEHEART_PLANKS.get());
        createSignRecipe(r, DEItems.PURPLEHEART_SIGN.get(), PURPLEHEART_PLANKS.get());
        
        createMixRecipe(r, PEARL_ESSENCE.get(), SIMIX_HAMMER.get(), ENDER_PEARL);
        
        createCrossRecipe(r, WARP_POWER_STONE.get(), PALON_INGOT.get(), PEARL_ESSENCE.get(), COORD_LINKER.get());
        createCrossRecipe(r, TIME_POWER_STONE.get(), EMERTYST_GEM.get(), Blocks.DAYLIGHT_DETECTOR, CLOCK);
        createCrossRecipe(r, COORD_LINKER.get(), SIMIX_INGOT.get(), PEARL_ESSENCE.get(), COMPASS);
        createCrossRecipe(r, ORIGIN_FRAME.get(), BASSMITE_GEM.get(), PALON_INGOT.get(), PEARL_ESSENCE.get(), SIMIX_INGOT.get());
        
        createCustomRecipe(r, DISPLAY_BLOCK.get(),
        		AIR, ITEM_FRAME, AIR,
        		PALON_INGOT.get(), PALON_INGOT.get(), PALON_INGOT.get(),
        		END_STONE, END_STONE, END_STONE
        );
        
        createCustomRecipe(r, FORGE.get(),
        		PALON_INGOT.get(), PALON_INGOT.get(), PALON_INGOT.get(),
        		PALON_INGOT.get(), PURPLEHEART_PLANKS.get(), PALON_INGOT.get(),
        		PALON_INGOT.get(), PURPLEHEART_PLANKS.get(), PALON_INGOT.get()
        );
        
        createCustomRecipe(r, MINERAL_STORAGE.get(),
        		PALON_INGOT.get(), PALON_INGOT.get(), AIR,
        		PURPLEHEART_PLANKS.get(), PURPLEHEART_PLANKS.get(), AIR,
        		PURPLEHEART_PLANKS.get(), PURPLEHEART_PLANKS.get(), AIR
        );
        
        createCustomRecipe(r, SIMIX_HAMMER.get(),
        		SIMIX_INGOT.get(), SIMIX_INGOT.get(), SIMIX_INGOT.get(),
        		SIMIX_INGOT.get(), STICK, SIMIX_INGOT.get(),
        		AIR, STICK, AIR
        );
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
        ShapedRecipeBuilder.shaped(resultItem, 3).define('#', requireItem).define('/', STICK)
                .pattern("#/#")
                .pattern("#/#")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createFenceGateRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(resultItem, 3).define('#', requireItem).define('/', STICK)
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
        ShapedRecipeBuilder.shaped(resultItem).define('#', nuggetItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_material", has(nuggetItem))
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
    
    private void createCrossRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem, ItemLike requireItem, ItemLike requireItem1, ItemLike requireItem2){
        ShapedRecipeBuilder.shaped(resultItem, 9).define('#', requireItem).define('@', requireItem1).define('&', requireItem2)
                .pattern("#@#")
                .pattern("@&@")
                .pattern("#@#")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }
    
    private void createCrossRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem, ItemLike requireItem, ItemLike requireItem1, ItemLike requireItem2, ItemLike requireItem3){
        ShapedRecipeBuilder.shaped(resultItem, 9).define('#', requireItem).define('@', requireItem1).define('&', requireItem2).define('%', requireItem3)
                .pattern("#%#")
                .pattern("@&@")
                .pattern("#%#")
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

    private void createCustomRecipe(Consumer<FinishedRecipe> r, ItemLike resultItem,
                                    ItemLike requireItem1, ItemLike requireItem2, ItemLike requireItem3,
                                    ItemLike requireItem4, ItemLike requireItem5, ItemLike requireItem6,
                                    ItemLike requireItem7, ItemLike requireItem8, ItemLike requireItem9){
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
