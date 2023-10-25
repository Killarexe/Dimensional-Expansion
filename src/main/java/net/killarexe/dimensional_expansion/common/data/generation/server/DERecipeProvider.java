package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.init.DEItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import static net.killarexe.dimensional_expansion.init.DEBlocks.*;
import static net.killarexe.dimensional_expansion.init.DEItems.*;
import static net.minecraft.world.item.Items.*;

public class DERecipeProvider extends RecipeProvider implements IConditionBuilder {

    public DERecipeProvider(PackOutput pOutput) {
		super(pOutput);
	}

	@Override
    protected void buildRecipes(RecipeOutput output) {
		createBlasting(output, RecipeCategory.MISC, PALON_ORE.get(), PALON_INGOT.get(), 0.1f, 200, "palon_ingot_blast");
        createSmelting(output, RecipeCategory.MISC, RAW_PALON.get(), PALON_INGOT.get(), 0.5f, 201, "palon_ingot_smelt");
        createMaterialRecipe(output, RecipeCategory.MISC, PALON_NUGGET.get(), PALON_INGOT.get(), "palon_nugget");
        createMaterialRecipe(output, RecipeCategory.MISC, PALON_INGOT.get(), PALON_BLOCK.get(), "palon_ingot_block");
        createOreBlockRecipe(output, RecipeCategory.MISC, PALON_BLOCK.get(), PALON_INGOT.get(), "palon_block");
        createOreBlockRecipe(output, RecipeCategory.MISC, PALON_INGOT.get(), PALON_NUGGET.get(), "palon_ingot_nugget");
        
        createBlasting(output, RecipeCategory.MISC, BASSMITE_ORE.get(), BASSMITE_GEM.get(), 0.1f, 200, "bassmite_gem");
        createMaterialRecipe(output, RecipeCategory.MISC, BASSMITE_GEM.get(), BASSMITE_BLOCK.get(), "bassmite_gem_block");
        createOreBlockRecipe(output, RecipeCategory.MISC, BASSMITE_BLOCK.get(), BASSMITE_GEM.get(), "bassmite_block");
        
        createBlasting(output, RecipeCategory.MISC, SIMIX_ORE.get(), SIMIX_INGOT.get(), 0.1f, 200, "simix_ingot_blast");
        createSmelting(output, RecipeCategory.MISC, RAW_SIMIX.get(), SIMIX_INGOT.get(), 0.1f, 200, "simix_ingot_smelt");
        createMaterialRecipe(output, RecipeCategory.MISC, SIMIX_NUGGET.get(), SIMIX_INGOT.get(), "simix_nugget");
        createMaterialRecipe(output, RecipeCategory.MISC, SIMIX_INGOT.get(), SIMIX_BLOCK.get(), "simix_ingot_block");
        createOreBlockRecipe(output, RecipeCategory.MISC, SIMIX_BLOCK.get(), SIMIX_INGOT.get(), "simix_block");
        createOreBlockRecipe(output, RecipeCategory.MISC, SIMIX_INGOT.get(), SIMIX_NUGGET.get(), "simix_ingot_nugget");
        
        createBlasting(output, RecipeCategory.MISC, EMERTYST_ORE.get(), EMERTYST_GEM.get(), 0.1f, 200, "emertyst_gem");
        createMaterialRecipe(output, RecipeCategory.MISC, EMERTYST_GEM.get(), EMERTYST_BLOCK.get(), "emertyst_gem_block");
        createOreBlockRecipe(output, RecipeCategory.MISC, EMERTYST_BLOCK.get(), EMERTYST_GEM.get(), "emertyst_block");
        
        createMixRecipe(output, RecipeCategory.MISC, PALON_MIXED_COAL.get(), PALON_INGOT.get(), COAL, "palon_mixed_coal");
        createMixRecipe(output, RecipeCategory.MISC, BASSMITE_MIXED_COAL.get(), BASSMITE_GEM.get(), COAL, "bassmite_mixed_coal");
        createMixRecipe(output, RecipeCategory.MISC, SIMIX_MIXED_COAL.get(), SIMIX_INGOT.get(), COAL, "simix_mixed_coal");
        createMixRecipe(output, RecipeCategory.MISC, EMERTYST_MIXED_COAL.get(), EMERTYST_GEM.get(), COAL, "emertyst_mixed_coal");
        
        createSlabRecipe(output, RecipeCategory.MISC, PURPLEHEART_SLAB.get(), PURPLEHEART_PLANKS.get(), "purpleheart_slab");
        createStairsRecipe(output, RecipeCategory.MISC, PURPLEHEART_STAIRS.get(), PURPLEHEART_PLANKS.get(), "purpleheart_stairs");
        createFenceRecipe(output, RecipeCategory.MISC, PURPLEHEART_FENCE.get(), PURPLEHEART_PLANKS.get(), "purpleheart_fence");
        createFenceGateRecipe(output, RecipeCategory.MISC, PURPLEHEART_FENCE_GATE.get(), PURPLEHEART_PLANKS.get(), "purpleheart_fence_gate");
        createPressurePlateRecipe(output, RecipeCategory.MISC, PURPLEHEART_PRESSURE_PLATE.get(), PURPLEHEART_PLANKS.get(), "purpleheart_pressure_plate");
        createButtonRecipe(output, RecipeCategory.MISC, PURPLEHEART_BUTTON.get(), PURPLEHEART_PLANKS.get(), "purpleheart_button");
        createDoorRecipe(output, RecipeCategory.MISC, PURPLEHEART_DOOR.get(), PURPLEHEART_PLANKS.get(), "purpleheart_door");
        createTrapDoorRecipe(output, RecipeCategory.MISC, PURPLEHEART_TRAPDOOR.get(), PURPLEHEART_PLANKS.get(), "purpleheart_trapdoor");
        createSignRecipe(output, RecipeCategory.MISC, DEItems.PURPLEHEART_SIGN.get(), PURPLEHEART_PLANKS.get(), "purpleheart_sign");
        
        createMixRecipe(output, RecipeCategory.MISC, PEARL_ESSENCE.get(), SIMIX_HAMMER.get(), ENDER_PEARL, "pearl_essence");
        
        createSmelting(output, RecipeCategory.BUILDING_BLOCKS, SULFUR_COBBLESTONE.get(), SULFUR_STONE.get(), 0.1f, 150, "sulfur_cobblestone");
        createStairsRecipe(output, RecipeCategory.BUILDING_BLOCKS, SULFUR_COBBLESTONE_STAIRS.get(), SULFUR_COBBLESTONE.get(), "sulfur_cobblestone_stairs");
        createStairsRecipe(output, RecipeCategory.BUILDING_BLOCKS, SULFUR_STONE_STAIRS.get(), SULFUR_STONE.get(), "sulfur_stone_stairs");
        createSlabRecipe(output, RecipeCategory.BUILDING_BLOCKS, SULFUR_COBBLESTONE_SLAB.get(), SULFUR_COBBLESTONE.get(), "sulfur_cobblestone_slab");
        createSlabRecipe(output, RecipeCategory.BUILDING_BLOCKS, SULFUR_STONE_SLAB.get(), SULFUR_STONE.get(), "sulfur_stone_slab");
        createTrapDoorRecipe(output, RecipeCategory.BUILDING_BLOCKS, SULFUR_COBBLESTONE_WALL.get(), SULFUR_COBBLESTONE.get(), "sulfur_cobblestone_wall");
        
        createCrossRecipe(output, RecipeCategory.MISC, COORD_LINKER.get(), 1, SIMIX_INGOT.get(), PEARL_ESSENCE.get(), COMPASS, "coord_linker");
        createCrossRecipe(output, RecipeCategory.MISC, ORIGIN_FRAME.get(), 4, BASSMITE_GEM.get(), PALON_INGOT.get(), PEARL_ESSENCE.get(), SIMIX_INGOT.get(), "origin_frame");
        
        createHelmetRecipe(output, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_HELMET.get(), "bassmite_helmet");
        createChestplateRecipe(output, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_CHESTPLATE.get(), "bassmite_chestplate");
        createLeggingsRecipe(output, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_LEGGINGS.get(), "bassmite_leggings");
        createBootsRecipe(output, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_BOOTS.get(), "bassmite_boots");
        createSwordRecipe(output, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_SWORD.get(), "bassmite_sword");
        createPickaxeRecipe(output, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_PICKAXE.get(), "bassmite_pickaxe");
        createAxeRecipe(output, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_AXE.get(), "bassmite_axe");
        createShovelRecipe(output, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_SHOVEL.get(), "bassmite_shovel");
        createHoeRecipe(output, RecipeCategory.COMBAT, BASSMITE_GEM.get(), BASSMITE_HOE.get(), "bassmite_hoe");
        
        createHelmetRecipe(output, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_HELMET.get(), "emertyst_helmet");
        createChestplateRecipe(output, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_CHESTPLATE.get(), "emertyst_chestplate");
        createLeggingsRecipe(output, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_LEGGINGS.get(), "emertyst_leggings");
        createBootsRecipe(output, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_BOOTS.get(), "emertyst_boots");
        createSwordRecipe(output, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_SWORD.get(), "emertyst_sword");
        createPickaxeRecipe(output, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_PICKAXE.get(), "emertyst_pickaxe");
        createAxeRecipe(output, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_AXE.get(), "emertyst_axe");
        createShovelRecipe(output, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_SHOVEL.get(), "emertyst_shovel");
        createHoeRecipe(output, RecipeCategory.COMBAT, EMERTYST_GEM.get(), EMERTYST_HOE.get(), "emertyst_hoe");
        
        createOreBlockRecipe(output, RecipeCategory.BUILDING_BLOCKS, SAVORLEAF_BLOCK.get(), SAVORLEAF.get(), "savorleaf_block");
        createMaterialRecipe(output, RecipeCategory.FOOD, SAVORLEAF.get(), SAVORLEAF_BLOCK.get(), "savorleaf");
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, PURPLEHEART_PLANKS.get(), 4).requires(PURPLEHEART_LOG.get())
                .unlockedBy("has_material", has(PURPLEHEART_LOG.get()))
                .save(output, new ResourceLocation(DEMod.MOD_ID, "purpleheart_planks_log"));
 
    	ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, PURPLEHEART_PLANKS.get(), 4).requires(STRIPPED_PURPLEHEART_LOG.get())
    			.unlockedBy("has_material", has(STRIPPED_PURPLEHEART_LOG.get()))
                .save(output, new ResourceLocation(DEMod.MOD_ID, "purpleheart_planks_stripped_log"));
        
    	ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ORIGIN_PORTAL_KEY.get(), 1).requires(FLINT_AND_STEEL).requires(SIMIX_HAMMER.get()).requires(PALON_INGOT.get())
	        .unlockedBy("has_material", has(SIMIX_HAMMER.get()))
	        .save(output);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, DISPLAY_BLOCK.get(), 1).define('O', ITEM_FRAME).define('I', PALON_INGOT.get()).define('#', END_STONE)
	        .pattern(" O ")
	        .pattern("III")
	        .pattern("###")
	        .unlockedBy("has_material", has(PALON_INGOT.get()))
	        .save(output);
        
        createCustomRecipe(output, RecipeCategory.BUILDING_BLOCKS, FORGE.get(), 1,
        		PALON_INGOT.get(), PALON_INGOT.get(), PALON_INGOT.get(),
        		PALON_INGOT.get(), PURPLEHEART_PLANKS.get(), PALON_INGOT.get(),
        		PALON_INGOT.get(), PURPLEHEART_PLANKS.get(), PALON_INGOT.get(), "forge"
        );
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, PURPLEHEART_BOAT.get(), 1).define('#', PURPLEHEART_PLANKS.get())
	        .pattern("   ")
	        .pattern("# #")
	        .pattern("###")
	        .unlockedBy("has_material", has(PURPLEHEART_PLANKS.get()))
	        .save(output);
        
        createMixRecipe(output, RecipeCategory.TRANSPORTATION, PURPLEHEART_CHEST_BOAT.get(), PURPLEHEART_BOAT.get(), CHEST, "purpleheart_chest_boat");
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MINERAL_STORAGE.get(), 1).define('I', PALON_INGOT.get()).define('#', PURPLEHEART_PLANKS.get())
	        .pattern("II ")
	        .pattern("## ")
	        .pattern("## ")
	        .unlockedBy("has_material", has(PURPLEHEART_PLANKS.get()))
	        .save(output);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, PURPLEHEART_BOOKSHELF.get(), 1).define('I', BOOK).define('#', PURPLEHEART_PLANKS.get())
        .pattern("###")
        .pattern("III")
        .pattern("###")
        .unlockedBy("has_material", has(PURPLEHEART_PLANKS.get()))
        .save(output);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SIMIX_HAMMER.get(), 1).define('I', SIMIX_INGOT.get()).define('/', STICK).define('O', ENDER_EYE)
	        .pattern("III")
	        .pattern("IOI")
	        .pattern(" / ")
	        .unlockedBy("has_material", has(PURPLEHEART_PLANKS.get()))
	        .save(output);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ENCHANT_TRANSFER_TABLE.get(), 1).define('#', ORIGIN_FRAME.get()).define('/', SIMIX_INGOT.get())
        	.pattern("   ")
        	.pattern("/#/")
        	.pattern("###")
        	.unlockedBy("has_material", has(ORIGIN_FRAME.get()))
        	.save(output);
        
        createCustomRecipe(output, RecipeCategory.MISC, ALLOY_CRYSTAL.get(), 1,
        		DIAMOND, BASSMITE_GEM.get(), DIAMOND,
        		EMERALD, EMERTYST_GEM.get(), LAPIS_LAZULI,
        		DIAMOND, SIMIX_HAMMER.get(), DIAMOND, "alloy_crystal"
        );
        
        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, MOBOX.get(), 1)
			.define('/', BASSMITE_GEM.get()).define('-', SIMIX_INGOT.get()).define('_', PALON_INGOT.get()).define('O', LEAD).define('0', ENDER_EYE)
			.pattern(" 0 ")
			.pattern("-O_")
			.pattern(" / ")
			.unlockedBy("has_material", has(LEAD))
			.save(output);
    }

    private void createDoorRecipe(RecipeOutput output, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 3).define('#', requireItem)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createTrapDoorRecipe(RecipeOutput output, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 6).define('#', requireItem)
                .pattern("###")
                .pattern("###")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createHelmetRecipe(RecipeOutput output, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem)
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createChestplateRecipe(RecipeOutput output, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createLeggingsRecipe(RecipeOutput output, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createBootsRecipe(RecipeOutput output, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem)
                .pattern("# #")
                .pattern("# #")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createSwordRecipe(RecipeOutput output, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem).define('/', STICK)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" / ")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createPickaxeRecipe(RecipeOutput output, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem).define('/', STICK)
                .pattern("###")
                .pattern(" / ")
                .pattern(" / ")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createAxeRecipe(RecipeOutput output, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem).define('/', STICK)
                .pattern(" ##")
                .pattern(" /#")
                .pattern(" / ")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createShovelRecipe(RecipeOutput output, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem).define('/', STICK)
                .pattern(" # ")
                .pattern(" / ")
                .pattern(" / ")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createHoeRecipe(RecipeOutput output, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem).define('/', STICK)
                .pattern(" ##")
                .pattern(" / ")
                .pattern(" / ")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createSignRecipe(RecipeOutput output, RecipeCategory category, ItemLike requireItem, ItemLike resultItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 6).define('#', requireItem).define('/', STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" / ")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createPressurePlateRecipe(RecipeOutput output, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 2).define('#', requireItem)
                .pattern("   ")
                .pattern("## ")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createSlabRecipe(RecipeOutput output, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 6).define('#', requireItem)
                .pattern("   ")
                .pattern("###")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createButtonRecipe(RecipeOutput output, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
    	ShapelessRecipeBuilder.shapeless(category, resultItem).requires(requireItem)
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createStairsRecipe(RecipeOutput output, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 6).define('#', requireItem)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createFenceRecipe(RecipeOutput output, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 3).define('#', requireItem).define('/', STICK)
                .pattern("#/#")
                .pattern("#/#")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createFenceGateRecipe(RecipeOutput output, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, 3).define('#', requireItem).define('/', STICK)
                .pattern("/#/")
                .pattern("/#/")
                .pattern("   ")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createOreBlockRecipe(RecipeOutput output, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
        ShapedRecipeBuilder.shaped(category, resultItem).define('#', requireItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createMaterialRecipe(RecipeOutput output, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, String name){
    	ShapelessRecipeBuilder.shapeless(category, resultItem, 9).requires(requireItem)
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createCrossRecipe(RecipeOutput output, RecipeCategory category, ItemLike resultItem, int count, ItemLike requireItem, ItemLike requireItem1, ItemLike requireItem2, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, count).define('#', requireItem).define('@', requireItem1).define('&', requireItem2)
                .pattern("#@#")
                .pattern("@&@")
                .pattern("#@#")
                .unlockedBy("has_material", has(requireItem2))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createCrossRecipe(RecipeOutput output, RecipeCategory category, ItemLike resultItem, int count, ItemLike requireItem, ItemLike requireItem1, ItemLike requireItem2, ItemLike requireItem3, String name){
        ShapedRecipeBuilder.shaped(category, resultItem, count).define('#', requireItem).define('@', requireItem1).define('&', requireItem2).define('%', requireItem3)
                .pattern("#%#")
                .pattern("@&@")
                .pattern("#%#")
                .unlockedBy("has_material", has(requireItem2))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createMixRecipe(RecipeOutput output, RecipeCategory category, ItemLike resultItem, ItemLike requireItem, ItemLike requireItem1, String name){
    	ShapelessRecipeBuilder.shapeless(category, resultItem, 9).requires(requireItem).requires(requireItem1)
                .unlockedBy("has_material", has(requireItem))
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createCustomRecipe(RecipeOutput output, RecipeCategory category, ItemLike resultItem, int count,
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
                .save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }

    private void createSmelting(RecipeOutput output, RecipeCategory category, ItemLike smeltItem, ItemLike resultItem, float time, int xp, String name){
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(new ItemStack(smeltItem)), category, resultItem, time, xp).unlockedBy("has_material", has(smeltItem)).save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }
    
    private void createBlasting(RecipeOutput output, RecipeCategory category, ItemLike smeltItem, ItemLike resultItem, float time, int xp, String name){
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(new ItemStack(smeltItem)), category, resultItem, time, xp).unlockedBy("has_material", has(smeltItem)).save(output, new ResourceLocation(DEMod.MOD_ID, name));
    }
}
