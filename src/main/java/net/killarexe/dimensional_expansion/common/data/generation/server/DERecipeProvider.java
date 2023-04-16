package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
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
		createBlasting(r, RecipeCategory.MISC, PALON_ORE.get(), PALON_INGOT.get(), 0.1f, 200, "palon_ingot_blast");
        createSmelting(r, RecipeCategory.MISC, RAW_PALON.get(), PALON_INGOT.get(), 0.5f, 201, "palon_ingot_smelt");
        createMaterialRecipe(r, RecipeCategory.MISC, PALON_NUGGET.get(), PALON_INGOT.get(), "palon_nugget");
        createMaterialRecipe(r, RecipeCategory.MISC, PALON_INGOT.get(), PALON_BLOCK.get(), "palon_ingot_block");
        createOreBlockRecipe(r, RecipeCategory.MISC, PALON_BLOCK.get(), PALON_INGOT.get(), "palon_block");
        createOreBlockRecipe(r, RecipeCategory.MISC, PALON_INGOT.get(), PALON_NUGGET.get(), "palon_ingot_nugget");
        
        createBlasting(r, RecipeCategory.MISC, BASSMITE_ORE.get(), BASSMITE_GEM.get(), 0.1f, 200, "bassmite_gem");
        createMaterialRecipe(r, RecipeCategory.MISC, BASSMITE_GEM.get(), BASSMITE_BLOCK.get(), "bassmite_gem_block");
        createOreBlockRecipe(r, RecipeCategory.MISC, BASSMITE_BLOCK.get(), BASSMITE_GEM.get(), "bassmite_block");
        
        createBlasting(r, RecipeCategory.MISC, SIMIX_ORE.get(), SIMIX_INGOT.get(), 0.1f, 200, "simix_ingot_blast");
        createSmelting(r, RecipeCategory.MISC, RAW_SIMIX.get(), SIMIX_INGOT.get(), 0.1f, 200, "simix_ingot_smelt");
        createMaterialRecipe(r, RecipeCategory.MISC, SIMIX_NUGGET.get(), SIMIX_INGOT.get(), "simix_nugget");
        createMaterialRecipe(r, RecipeCategory.MISC, SIMIX_INGOT.get(), SIMIX_BLOCK.get(), "simix_ingot_block");
        createOreBlockRecipe(r, RecipeCategory.MISC, SIMIX_BLOCK.get(), SIMIX_INGOT.get(), "simix_block");
        createOreBlockRecipe(r, RecipeCategory.MISC, SIMIX_INGOT.get(), SIMIX_NUGGET.get(), "simix_ingot_nugget");
        
        createBlasting(r, RecipeCategory.MISC, EMERTYST_ORE.get(), EMERTYST_GEM.get(), 0.1f, 200, "emertyst_gem");
        createMaterialRecipe(r, RecipeCategory.MISC, EMERTYST_GEM.get(), EMERTYST_BLOCK.get(), "emertyst_gem_block");
        createOreBlockRecipe(r, RecipeCategory.MISC, EMERTYST_BLOCK.get(), EMERTYST_GEM.get(), "emertyst_block");
        
        createMixRecipe(r, RecipeCategory.MISC, PALON_MIXED_COAL.get(), PALON_INGOT.get(), COAL, "palon_mixed_coal");
        createMixRecipe(r, RecipeCategory.MISC, BASSMITE_MIXED_COAL.get(), BASSMITE_GEM.get(), COAL, "bassmite_mixed_coal");
        createMixRecipe(r, RecipeCategory.MISC, SIMIX_MIXED_COAL.get(), SIMIX_INGOT.get(), COAL, "simix_mixed_coal");
        createMixRecipe(r, RecipeCategory.MISC, EMERTYST_MIXED_COAL.get(), EMERTYST_GEM.get(), COAL, "emertyst_mixed_coal");
        
        createSlabRecipe(r, RecipeCategory.MISC, PURPLEHEART_SLAB.get(), PURPLEHEART_PLANKS.get(), "purpleheart_slab");
        createStairsRecipe(r, RecipeCategory.MISC, PURPLEHEART_STAIRS.get(), PURPLEHEART_PLANKS.get(), "purpleheart_stairs");
        createFenceRecipe(r, RecipeCategory.MISC, PURPLEHEART_FENCE.get(), PURPLEHEART_PLANKS.get(), "purpleheart_fence");
        createFenceGateRecipe(r, RecipeCategory.MISC, PURPLEHEART_FENCE_GATE.get(), PURPLEHEART_PLANKS.get(), "purpleheart_fence_gate");
        createPressurePlateRecipe(r, RecipeCategory.MISC, PURPLEHEART_PRESSURE_PLATE.get(), PURPLEHEART_PLANKS.get(), "purpleheart_pressure_plate");
        createButtonRecipe(r, RecipeCategory.MISC, PURPLEHEART_BUTTON.get(), PURPLEHEART_PLANKS.get(), "purpleheart_button");
        createDoorRecipe(r, RecipeCategory.MISC, PURPLEHEART_DOOR.get(), PURPLEHEART_PLANKS.get(), "purpleheart_door");
        createTrapDoorRecipe(r, RecipeCategory.MISC, PURPLEHEART_TRAPDOOR.get(), PURPLEHEART_PLANKS.get(), "purpleheart_trapdoor");
        createSignRecipe(r, RecipeCategory.MISC, DEItems.PURPLEHEART_SIGN.get(), PURPLEHEART_PLANKS.get(), "purpleheart_sign");
        
        createMixRecipe(r, RecipeCategory.MISC, PEARL_ESSENCE.get(), SIMIX_HAMMER.get(), ENDER_PEARL, "pearl_essence");
        
        createSmelting(r, RecipeCategory.BUILDING_BLOCKS, SULFUR_COBBLESTONE.get(), SULFUR_STONE.get(), 0.1f, 150, "sulfur_cobblestone");
        createStairsRecipe(r, RecipeCategory.BUILDING_BLOCKS, SULFUR_COBBLESTONE_STAIRS.get(), SULFUR_COBBLESTONE.get(), "sulfur_cobblestone_stairs");
        createStairsRecipe(r, RecipeCategory.BUILDING_BLOCKS, SULFUR_STONE_STAIRS.get(), SULFUR_STONE.get(), "sulfur_stone_stairs");
        createSlabRecipe(r, RecipeCategory.BUILDING_BLOCKS, SULFUR_COBBLESTONE_SLAB.get(), SULFUR_COBBLESTONE.get(), "sulfur_cobblestone_slab");
        createSlabRecipe(r, RecipeCategory.BUILDING_BLOCKS, SULFUR_STONE_SLAB.get(), SULFUR_STONE.get(), "sulfur_stone_slab");
        createTrapDoorRecipe(r, RecipeCategory.BUILDING_BLOCKS, SULFUR_COBBLESTONE_WALL.get(), SULFUR_COBBLESTONE.get(), "sulfur_cobblestone_wall");
        
        createCrossRecipe(r, RecipeCategory.MISC, COORD_LINKER.get(), 1, SIMIX_INGOT.get(), PEARL_ESSENCE.get(), COMPASS, "coord_linker");
        createCrossRecipe(r, RecipeCategory.MISC, ORIGIN_FRAME.get(), 4, BASSMITE_GEM.get(), PALON_INGOT.get(), PEARL_ESSENCE.get(), SIMIX_INGOT.get(), "origin_frame");
        
        createHelmetRecipe(r, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_HELMET.get(), "bassmite_helmet");
        createChestplateRecipe(r, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_CHESTPLATE.get(), "bassmite_chestplate");
        createLeggingsRecipe(r, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_LEGGINGS.get(), "bassmite_leggings");
        createBootsRecipe(r, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_BOOTS.get(), "bassmite_boots");
        createSwordRecipe(r, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_SWORD.get(), "bassmite_sword");
        createPickaxeRecipe(r, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_PICKAXE.get(), "bassmite_pickaxe");
        createAxeRecipe(r, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_AXE.get(), "bassmite_axe");
        createShovelRecipe(r, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_SHOVEL.get(), "bassmite_shovel");
        createHoeRecipe(r, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_HOE.get(), "bassmite_hoe");
        
        createHelmetRecipe(r, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_HELMET.get(), "emertyst_helmet");
        createChestplateRecipe(r, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_CHESTPLATE.get(), "emertyst_chestplate");
        createLeggingsRecipe(r, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_LEGGINGS.get(), "emertyst_leggings");
        createBootsRecipe(r, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_BOOTS.get(), "emertyst_boots");
        createSwordRecipe(r, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_SWORD.get(), "emertyst_sword");
        createPickaxeRecipe(r, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_PICKAXE.get(), "emertyst_pickaxe");
        createAxeRecipe(r, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_AXE.get(), "emertyst_axe");
        createShovelRecipe(r, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_SHOVEL.get(), "emertyst_shovel");
        createHoeRecipe(r, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_HOE.get(), "emertyst_hoe");
        
        createOreBlockRecipe(r, RecipeCategory.BUILDING_BLOCKS, SAVORLEAF_BLOCK.get(), SAVORLEAF.get(), "savorleaf_block");
        createMaterialRecipe(r, RecipeCategory.FOOD, SAVORLEAF.get(), SAVORLEAF_BLOCK.get(), "savorleaf");
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, PURPLEHEART_PLANKS.get(), 4).requires(PURPLEHEART_LOG.get())
                .unlockedBy("has_material", has(PURPLEHEART_LOG.get()))
                .save(r, new ResourceLocation(DEMod.MOD_ID, "purpleheart_planks_log"));
 
    	ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, PURPLEHEART_PLANKS.get(), 4).requires(STRIPPED_PURPLEHEART_LOG.get())
    			.unlockedBy("has_material", has(STRIPPED_PURPLEHEART_LOG.get()))
                .save(r, new ResourceLocation(DEMod.MOD_ID, "purpleheart_planks_stripped_log"));
        
    	ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ORIGIN_PORTAL_KEY.get(), 1).requires(FLINT_AND_STEEL).requires(SIMIX_HAMMER.get()).requires(PALON_INGOT.get())
	        .unlockedBy("has_material", has(SIMIX_HAMMER.get()))
	        .save(r);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DISPLAY_BLOCK.get(), 1).define('O', ITEM_FRAME).define('I', PALON_INGOT.get()).define('#', END_STONE)
	        .pattern(" O ")
	        .pattern("III")
	        .pattern("###")
	        .unlockedBy("has_material", has(PALON_INGOT.get()))
	        .save(r);
        
        createCustomRecipe(r, RecipeCategory.BUILDING_BLOCKS, FORGE.get(), 1,
        		PALON_INGOT.get(), PALON_INGOT.get(), PALON_INGOT.get(),
        		PALON_INGOT.get(), PURPLEHEART_PLANKS.get(), PALON_INGOT.get(),
        		PALON_INGOT.get(), PURPLEHEART_PLANKS.get(), PALON_INGOT.get(), "forge"
        );
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, PURPLEHEART_BOAT.get(), 1).define('#', PURPLEHEART_PLANKS.get())
	        .pattern("   ")
	        .pattern("# #")
	        .pattern("###")
	        .unlockedBy("has_material", has(PURPLEHEART_PLANKS.get()))
	        .save(r);
        
        createMixRecipe(r, RecipeCategory.TRANSPORTATION, PURPLEHEART_CHEST_BOAT.get(), PURPLEHEART_BOAT.get(), CHEST, "purpleheart_chest_boat");
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MINERAL_STORAGE.get(), 1).define('I', PALON_INGOT.get()).define('#', PURPLEHEART_PLANKS.get())
	        .pattern("II ")
	        .pattern("## ")
	        .pattern("## ")
	        .unlockedBy("has_material", has(PURPLEHEART_PLANKS.get()))
	        .save(r);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, PURPLEHEART_BOOKSHELF.get(), 1).define('I', BOOK).define('#', PURPLEHEART_PLANKS.get())
        .pattern("###")
        .pattern("III")
        .pattern("###")
        .unlockedBy("has_material", has(PURPLEHEART_PLANKS.get()))
        .save(r);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SIMIX_HAMMER.get(), 1).define('I', SIMIX_INGOT.get()).define('/', STICK).define('O', ENDER_EYE)
	        .pattern("III")
	        .pattern("IOI")
	        .pattern(" / ")
	        .unlockedBy("has_material", has(PURPLEHEART_PLANKS.get()))
	        .save(r);
        
        createCustomRecipe(r, RecipeCategory.MISC, ALLOY_CRYSTAL.get(), 1,
        		DIAMOND, BASSMITE_GEM.get(), DIAMOND,
        		EMERALD, EMERTYST_GEM.get(), LAPIS_LAZULI,
        		DIAMOND, SIMIX_HAMMER.get(), DIAMOND, "alloy_crystal"
        );
    }

    private void createDoorRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 3).define('#', requireItem)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createTrapDoorRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 6).define('#', requireItem)
                .pattern("###")
                .pattern("###")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createHelmetRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem)
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createChestplateRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createLeggingsRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createBootsRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem)
                .pattern("# #")
                .pattern("# #")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createSwordRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem).define('/', STICK)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" / ")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createPickaxeRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem).define('/', STICK)
                .pattern("###")
                .pattern(" / ")
                .pattern(" / ")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createAxeRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem).define('/', STICK)
                .pattern(" ##")
                .pattern(" /#")
                .pattern(" / ")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createShovelRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem).define('/', STICK)
                .pattern(" # ")
                .pattern(" / ")
                .pattern(" / ")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createHoeRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem).define('/', STICK)
                .pattern(" ##")
                .pattern(" / ")
                .pattern(" / ")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createSignRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 6).define('#', requireItem).define('/', STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" / ")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createPressurePlateRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 2).define('#', requireItem)
                .pattern("   ")
                .pattern("## ")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createSlabRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 6).define('#', requireItem)
                .pattern("   ")
                .pattern("###")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createButtonRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
    	ShapelessRecipeBuilder.shapeless(category, resultItem).requires(requireItem)
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createStairsRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 6).define('#', requireItem)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createFenceRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 3).define('#', requireItem).define('/', STICK)
                .pattern("#/#")
                .pattern("#/#")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createFenceGateRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 3).define('#', requireItem).define('/', STICK)
                .pattern("/#/")
                .pattern("/#/")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createOreBlockRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createMaterialRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
    	ShapelessRecipeBuilder.shapeless(category, resultItem, 9).requires(requireItem)
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createCrossRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, int count, ItemLike requireItem, ItemLike requireItem1, ItemLike requireItem2, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, count).define('#', requireItem).define('@', requireItem1).define('&', requireItem2)
                .pattern("#@#")
                .pattern("@&@")
                .pattern("#@#")
                .unlockedBy("has_material", has(requireItem2))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createCrossRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, int count, ItemLike requireItem, ItemLike requireItem1, ItemLike requireItem2, ItemLike requireItem3, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, count).define('#', requireItem).define('@', requireItem1).define('&', requireItem2).define('%', requireItem3)
                .pattern("#%#")
                .pattern("@&@")
                .pattern("#%#")
                .unlockedBy("has_material", has(requireItem2))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createMixRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, ItemLike requireItem1, String name){
    	ShapelessRecipeBuilder.shapeless(category, resultItem, 9).requires(requireItem).requires(requireItem1)
                .unlockedBy("has_material", has(requireItem))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createCustomRecipe(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike resultItem, int count,
                                    ItemLike requireItem1, ItemLike requireItem2, ItemLike requireItem3,
                                    ItemLike requireItem4, ItemLike requireItem5, ItemLike requireItem6,
                                    ItemLike requireItem7, ItemLike requireItem8, ItemLike requireItem9, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, count)
                .define('1', requireItem1).define('2', requireItem2).define('3', requireItem3)
                .define('4', requireItem4).define('5', requireItem5).define('6', requireItem6)
                .define('7', requireItem7).define('8', requireItem8).define('9', requireItem9)
                .pattern("123")
                .pattern("456")
                .pattern("789")
                .unlockedBy("has_material_1", has(requireItem1))
                .unlockedBy("has_material_2", has(requireItem2))
                .unlockedBy("has_material_3", has(requireItem3))
                .unlockedBy("has_material_4", has(requireItem4))
                .unlockedBy("has_material_5", has(requireItem5))
                .unlockedBy("has_material_6", has(requireItem6))
                .unlockedBy("has_material_7", has(requireItem7))
                .unlockedBy("has_material_8", has(requireItem8))
                .unlockedBy("has_material_9", has(requireItem9))
                .save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createSmelting(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike smeltItem, ItemLike resultItem, float time, int xp, String name){
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(new ItemStack(smeltItem)), category, resultItem, time, xp).unlockedBy("has_material", has(smeltItem)).save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createBlasting(Consumer<FinishedRecipe> r, RecipeCategory category, ItemLike smeltItem, ItemLike resultItem, float time, int xp, String name){
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(new ItemStack(smeltItem)), category, resultItem, time, xp).unlockedBy("has_material", has(smeltItem)).save(r, new ResourceLocation(DEMod.MOD_ID, name));
    }
}
