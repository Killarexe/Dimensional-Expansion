package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

import static net.minecraft.world.item.Items.*;
import static net.killarexe.dimensional_expansion.core.init.DEItems.*;
import static net.killarexe.dimensional_expansion.core.init.DEBlocks.*;

public class DERecipeProvider extends RecipeProvider implements IConditionBuilder {

    public DERecipeProvider(PackOutput pOutput) {
		super(pOutput);
	}

	@Override
    protected void buildRecipes(Consumer<FinishedRecipe> r) {
		createBlasting(r, RecipeCategory.MISC, PALON_ORE.get(), PALON_INGOT.get(), 0.1f, 200);
        createSmelting(r, RecipeCategory.MISC, RAW_PALON.get(), PALON_INGOT.get(), 0.5f, 201);
        createMaterialIngotRecipe(r, RecipeCategory.MISC, PALON_NUGGET.get(), PALON_INGOT.get());
        createMaterialRecipe(r, RecipeCategory.MISC, PALON_NUGGET.get(), PALON_INGOT.get());
        createOreBlockRecipe(r, RecipeCategory.MISC, PALON_BLOCK.get(), PALON_INGOT.get());
        createBlasting(r, RecipeCategory.MISC, BASSMITE_ORE.get(), BASSMITE_GEM.get(), 0.1f, 200);
        createMaterialRecipe(r, RecipeCategory.MISC, BASSMITE_GEM.get(), BASSMITE_BLOCK.get());
        createOreBlockRecipe(r, RecipeCategory.MISC, BASSMITE_BLOCK.get(), BASSMITE_GEM.get());
        createBlasting(r, RecipeCategory.MISC, SIMIX_ORE.get(), SIMIX_INGOT.get(), 0.1f, 200);
        createSmelting(r, RecipeCategory.MISC, RAW_SIMIX.get(), SIMIX_INGOT.get(), 0.1f, 200);
        createMaterialRecipe(r, RecipeCategory.MISC, SIMIX_INGOT.get(), SIMIX_BLOCK.get());
        createMaterialRecipe(r, RecipeCategory.MISC, SIMIX_NUGGET.get(), SIMIX_INGOT.get());
        createOreBlockRecipe(r, RecipeCategory.MISC, SIMIX_BLOCK.get(), SIMIX_INGOT.get());
        createBlasting(r, RecipeCategory.MISC, EMERTYST_ORE.get(), EMERTYST_GEM.get(), 0.1f, 200);
        createMaterialRecipe(r, RecipeCategory.MISC, EMERTYST_GEM.get(), EMERTYST_BLOCK.get());
        createOreBlockRecipe(r, RecipeCategory.MISC, EMERTYST_BLOCK.get(), EMERTYST_GEM.get());
        createMixRecipe(r, RecipeCategory.MISC, PALON_MIXED_COAL.get(), PALON_INGOT.get(), COAL);
        createMixRecipe(r, RecipeCategory.MISC, BASSMITE_MIXED_COAL.get(), BASSMITE_GEM.get(), COAL);
        createMixRecipe(r, RecipeCategory.MISC, SIMIX_MIXED_COAL.get(), SIMIX_INGOT.get(), COAL);
        createMixRecipe(r, RecipeCategory.MISC, EMERTYST_MIXED_COAL.get(), EMERTYST_GEM.get(), COAL);
        
        createSlabRecipe(r, RecipeCategory.MISC, PURPLEHEART_SLAB.get(), PURPLEHEART_PLANKS.get());
        createStairsRecipe(r, RecipeCategory.MISC, PURPLEHEART_STAIRS.get(), PURPLEHEART_PLANKS.get());
        createFenceRecipe(r, RecipeCategory.MISC, PURPLEHEART_FENCE.get(), PURPLEHEART_PLANKS.get());
        createFenceGateRecipe(r, RecipeCategory.MISC, PURPLEHEART_FENCE_GATE.get(), PURPLEHEART_PLANKS.get());
        createPressurePlateRecipe(r, RecipeCategory.MISC, PURPLEHEART_PRESSURE_PLATE.get(), PURPLEHEART_PLANKS.get());
        createButtonRecipe(r, RecipeCategory.MISC, PURPLEHEART_BUTTON.get(), PURPLEHEART_PLANKS.get());
        createDoorRecipe(r, RecipeCategory.MISC, PURPLEHEART_DOOR.get(), PURPLEHEART_PLANKS.get());
        createTrapDoorRecipe(r, RecipeCategory.MISC, PURPLEHEART_TRAPDOOR.get(), PURPLEHEART_PLANKS.get());
        createSignRecipe(r, RecipeCategory.MISC, DEItems.PURPLEHEART_SIGN.get(), PURPLEHEART_PLANKS.get());
        
        createMixRecipe(r, RecipeCategory.MISC, PEARL_ESSENCE.get(), SIMIX_HAMMER.get(), ENDER_PEARL);
        
        createSmelting(r, RecipeCategory.MISC, SULFUR_COBBLESTONE.get(), SULFUR_STONE.get(), 0.1f, 150);
        
        createCrossRecipe(r, RecipeCategory.MISC, WARP_POWER_STONE.get(), 1, ALLOY_CRYSTAL.get(), PEARL_ESSENCE.get(), COORD_LINKER.get());
        createCrossRecipe(r, RecipeCategory.MISC, TIME_POWER_STONE.get(), 1, ALLOY_CRYSTAL.get(), Blocks.DAYLIGHT_DETECTOR, CLOCK);
        createCrossRecipe(r, RecipeCategory.MISC, COORD_LINKER.get(), 1, SIMIX_INGOT.get(), PEARL_ESSENCE.get(), COMPASS);
        createCrossRecipe(r, RecipeCategory.MISC, ORIGIN_FRAME.get(), 4, BASSMITE_GEM.get(), PALON_INGOT.get(), PEARL_ESSENCE.get(), SIMIX_INGOT.get());
        
        createSmithingTable(r, RecipeCategory.MISC, NETHERITE_BOOTS, PALON_INGOT.get(), PALON_BOOTS.get());
        createSmithingTable(r, RecipeCategory.MISC, NETHERITE_LEGGINGS, PALON_INGOT.get(), PALON_LEGGINGS.get());
        createSmithingTable(r, RecipeCategory.MISC, NETHERITE_CHESTPLATE, PALON_INGOT.get(), PALON_CHESTPLATE.get());
        createSmithingTable(r, RecipeCategory.MISC, NETHERITE_HELMET, PALON_INGOT.get(), PALON_HELMET.get());
        createSmithingTable(r, RecipeCategory.MISC, NETHERITE_SWORD, PALON_INGOT.get(), PALON_SWORD.get());
        createSmithingTable(r, RecipeCategory.MISC, NETHERITE_PICKAXE, PALON_INGOT.get(), PALON_PICKAXE.get());
        createSmithingTable(r, RecipeCategory.MISC, NETHERITE_AXE, PALON_INGOT.get(), PALON_AXE.get());
        createSmithingTable(r, RecipeCategory.MISC, NETHERITE_SHOVEL, PALON_INGOT.get(), PALON_SHOVEL.get());
        createSmithingTable(r, RecipeCategory.MISC, NETHERITE_HOE, PALON_INGOT.get(), PALON_HOE.get());
        
        createSmithingTable(r, RecipeCategory.MISC, PALON_BOOTS.get(), BASSMITE_GEM.get(), BASSMITE_BOOTS.get());
        createSmithingTable(r, RecipeCategory.MISC, PALON_LEGGINGS.get(), BASSMITE_GEM.get(), BASSMITE_LEGGINGS.get());
        createSmithingTable(r, RecipeCategory.MISC, PALON_CHESTPLATE.get(), BASSMITE_GEM.get(), BASSMITE_CHESTPLATE.get());
        createSmithingTable(r, RecipeCategory.MISC, PALON_HELMET.get(), BASSMITE_GEM.get(), BASSMITE_HELMET.get());
        createSmithingTable(r, RecipeCategory.MISC, PALON_SWORD.get(), BASSMITE_GEM.get(), BASSMITE_SWORD.get());
        createSmithingTable(r, RecipeCategory.MISC, PALON_PICKAXE.get(), BASSMITE_GEM.get(), BASSMITE_PICKAXE.get());
        createSmithingTable(r, RecipeCategory.MISC, PALON_AXE.get(), BASSMITE_GEM.get(), BASSMITE_AXE.get());
        createSmithingTable(r, RecipeCategory.MISC, PALON_SHOVEL.get(), BASSMITE_GEM.get(), BASSMITE_SHOVEL.get());
        createSmithingTable(r, RecipeCategory.MISC, PALON_HOE.get(), BASSMITE_GEM.get(), BASSMITE_HOE.get());
        
        createSmithingTable(r, RecipeCategory.MISC, BASSMITE_LEGGINGS.get(), SIMIX_INGOT.get(), SIMIX_LEGGINGS.get());
        createSmithingTable(r, RecipeCategory.MISC, BASSMITE_BOOTS.get(), SIMIX_INGOT.get(), SIMIX_BOOTS.get());
        createSmithingTable(r, RecipeCategory.MISC, BASSMITE_CHESTPLATE.get(), SIMIX_INGOT.get(), SIMIX_CHESTPLATE.get());
        createSmithingTable(r, RecipeCategory.MISC, BASSMITE_HELMET.get(), SIMIX_INGOT.get(), SIMIX_HELMET.get());
        createSmithingTable(r, RecipeCategory.MISC, BASSMITE_SWORD.get(), SIMIX_INGOT.get(), SIMIX_SWORD.get());
        createSmithingTable(r, RecipeCategory.MISC, BASSMITE_PICKAXE.get(), SIMIX_INGOT.get(), SIMIX_PICKAXE.get());
        createSmithingTable(r, RecipeCategory.MISC, BASSMITE_AXE.get(), SIMIX_INGOT.get(), SIMIX_AXE.get());
        createSmithingTable(r, RecipeCategory.MISC, BASSMITE_SHOVEL.get(), SIMIX_INGOT.get(), SIMIX_SHOVEL.get());
        createSmithingTable(r, RecipeCategory.MISC, BASSMITE_HOE.get(), SIMIX_INGOT.get(), SIMIX_HOE.get());

        createSmithingTable(r, RecipeCategory.MISC, SIMIX_BOOTS.get(), EMERTYST_GEM.get(), EMERTYST_BOOTS.get());
        createSmithingTable(r, RecipeCategory.MISC, SIMIX_LEGGINGS.get(), EMERTYST_GEM.get(), EMERTYST_LEGGINGS.get());
        createSmithingTable(r, RecipeCategory.MISC, SIMIX_CHESTPLATE.get(), EMERTYST_GEM.get(), EMERTYST_CHESTPLATE.get());
        createSmithingTable(r, RecipeCategory.MISC, SIMIX_HELMET.get(), EMERTYST_GEM.get(), EMERTYST_HELMET.get());
        createSmithingTable(r, RecipeCategory.MISC, SIMIX_SWORD.get(), EMERTYST_GEM.get(), EMERTYST_SWORD.get());
        createSmithingTable(r, RecipeCategory.MISC, SIMIX_PICKAXE.get(), EMERTYST_GEM.get(), EMERTYST_PICKAXE.get());
        createSmithingTable(r, RecipeCategory.MISC, SIMIX_AXE.get(), EMERTYST_GEM.get(), EMERTYST_AXE.get());
        createSmithingTable(r, RecipeCategory.MISC, SIMIX_SHOVEL.get(), EMERTYST_GEM.get(), EMERTYST_SHOVEL.get());
        createSmithingTable(r, RecipeCategory.MISC, SIMIX_HOE.get(), EMERTYST_GEM.get(), EMERTYST_HOE.get());
        
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ORIGIN_PORTAL_KEY.get(), 1).requires(FLINT_AND_STEEL).requires(SIMIX_HAMMER.get()).requires(PALON_INGOT.get())
	        .unlockedBy("has_material", has(SIMIX_HAMMER.get()))
	        .save(r);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DISPLAY_BLOCK.get(), 1).define('O', ITEM_FRAME).define('I', PALON_INGOT.get()).define('#', END_STONE)
	        .pattern(" O ")
	        .pattern("III")
	        .pattern("###")
	        .unlockedBy("has_material", has(PALON_INGOT.get()))
	        .save(r);
        
        createCustomRecipe(r, RecipeCategory.MISC, FORGE.get(), 1,
        		PALON_INGOT.get(), PALON_INGOT.get(), PALON_INGOT.get(),
        		PALON_INGOT.get(), PURPLEHEART_PLANKS.get(), PALON_INGOT.get(),
        		PALON_INGOT.get(), PURPLEHEART_PLANKS.get(), PALON_INGOT.get()
        );
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, PURPLEHEART_BOAT.get(), 1).define('#', PURPLEHEART_PLANKS.get())
	        .pattern("   ")
	        .pattern("# #")
	        .pattern("###")
	        .unlockedBy("has_material", has(PURPLEHEART_PLANKS.get()))
	        .save(r);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MINERAL_STORAGE.get(), 1).define('I', PALON_INGOT.get()).define('#', PURPLEHEART_PLANKS.get())
	        .pattern("II ")
	        .pattern("## ")
	        .pattern("## ")
	        .unlockedBy("has_material", has(PURPLEHEART_PLANKS.get()))
	        .save(r);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, PURPLEHEART_BOOKSHELF.get(), 1).define('I', BOOK).define('#', PURPLEHEART_PLANKS.get())
        .pattern("###")
        .pattern("III")
        .pattern("###")
        .unlockedBy("has_material", has(PURPLEHEART_PLANKS.get()))
        .save(r);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SIMIX_HAMMER.get(), 1).define('I', SIMIX_INGOT.get()).define('/', STICK).define('O', ENDER_EYE)
	        .pattern("III")
	        .pattern("IOI")
	        .pattern(" / ")
	        .unlockedBy("has_material", has(PURPLEHEART_PLANKS.get()))
	        .save(r);
        
        createCustomRecipe(r, RecipeCategory.MISC, ALLOY_CRYSTAL.get(), 1,
        		DIAMOND, BASSMITE_GEM.get(), DIAMOND,
        		EMERALD, EMERTYST_GEM.get(), LAPIS_LAZULI,
        		DIAMOND, SIMIX_HAMMER.get(), DIAMOND
        );
    }

    private void createDoorRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(category, resultItem, 3).define('#', requireItem)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createTrapDoorRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(category, resultItem, 6).define('#', requireItem)
                .pattern("###")
                .pattern("###")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createSignRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(category, resultItem, 6).define('#', requireItem).define('/', STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" / ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createPressurePlateRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(category, resultItem, 2).define('#', requireItem)
                .pattern("   ")
                .pattern("## ")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createSlabRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(category, resultItem, 6).define('#', requireItem)
                .pattern("   ")
                .pattern("###")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createButtonRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem){
    	ShapelessRecipeBuilder.shapeless(category, resultItem).requires(requireItem)
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createStairsRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(category, resultItem, 6).define('#', requireItem)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createFenceRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(category, resultItem, 3).define('#', requireItem).define('/', STICK)
                .pattern("#/#")
                .pattern("#/#")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createFenceGateRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(category, resultItem, 3).define('#', requireItem).define('/', STICK)
                .pattern("/#/")
                .pattern("/#/")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createOreBlockRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createMaterialIngotRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike nuggetItem, ItemLike resultItem){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', nuggetItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_material", has(nuggetItem))
                .save(r);
    }

    private void createMaterialRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem){
    	ShapelessRecipeBuilder.shapeless(category, resultItem, 9).requires(requireItem)
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }
    
    private void createCrossRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, int count, ItemLike requireItem, ItemLike requireItem1, ItemLike requireItem2){
        ShapedRecipeBuilder.shaped(category, resultItem, count).define('#', requireItem).define('@', requireItem1).define('&', requireItem2)
                .pattern("#@#")
                .pattern("@&@")
                .pattern("#@#")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }
    
    private void createCrossRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, int count, ItemLike requireItem, ItemLike requireItem1, ItemLike requireItem2, ItemLike requireItem3){
        ShapedRecipeBuilder.shaped(category, resultItem, count).define('#', requireItem).define('@', requireItem1).define('&', requireItem2).define('%', requireItem3)
                .pattern("#%#")
                .pattern("@&@")
                .pattern("#%#")
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }

    private void createMixRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, ItemLike requireItem1){
    	ShapelessRecipeBuilder.shapeless(category, resultItem, 9).requires(requireItem).requires(requireItem1)
                .unlockedBy("has_material", has(requireItem))
                .save(r);
    }
    
    

    private void createCustomRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, int count,
                                    ItemLike requireItem1, ItemLike requireItem2, ItemLike requireItem3,
                                    ItemLike requireItem4, ItemLike requireItem5, ItemLike requireItem6,
                                    ItemLike requireItem7, ItemLike requireItem8, ItemLike requireItem9){
        ShapedRecipeBuilder.shaped(category, resultItem, count)
                .define('1', requireItem1).define('2', requireItem2).define('3', requireItem3)
                .define('4', requireItem4).define('5', requireItem5).define('6', requireItem6)
                .define('7', requireItem7).define('8', requireItem8).define('9', requireItem9)
                .pattern("123")
                .pattern("456")
                .pattern("789")
                .unlockedBy("has_material", has(requireItem1))
                .save(r);
    }

    private void createSmelting(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike smeltItem, ItemLike resultItem, float time, int xp){
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(new ItemStack(smeltItem)), category, resultItem, time, xp);
    }
    
    private void createBlasting(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike smeltItem, ItemLike resultItem, float time, int xp){
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(new ItemStack(smeltItem)), category, resultItem, time, xp);
    }
    
    private void createSmithingTable(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike inputItem, ItemLike material, ItemLike result) {
    	UpgradeRecipeBuilder.smithing(Ingredient.of(new ItemStack(inputItem)), Ingredient.of(new ItemStack(material)), category, result.asItem());
    }
}
