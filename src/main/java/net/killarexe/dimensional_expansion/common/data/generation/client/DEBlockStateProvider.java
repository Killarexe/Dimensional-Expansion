package net.killarexe.dimensional_expansion.common.data.generation.client;

import static net.killarexe.dimensional_expansion.init.DEBlocks.*;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class DEBlockStateProvider extends BlockStateProvider {

	public DEBlockStateProvider(PackOutput generator, ExistingFileHelper helper) {
		super(generator, DEMod.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(PALON_ORE.get());
		simpleBlock(PALON_BLOCK.get());
		simpleBlock(BASSMITE_ORE.get());
		simpleBlock(BASSMITE_BLOCK.get());
		simpleBlock(SIMIX_ORE.get());
		simpleBlock(SIMIX_BLOCK.get());
		simpleBlock(EMERTYST_ORE.get());
		simpleBlock(EMERTYST_BLOCK.get());
		simpleBlock(ORIGIN_DIRT.get());
		simpleBlock(SULFUR_STONE.get());
		simpleBlock(PURPLEHEART_PLANKS.get());
		simpleBlock(SULFUR_STONE_BRICKS.get());
		simpleBlock(VIOLET_STONE.get());
		simpleBlock(PURPLEHEART_LEAVES.get());
		simpleBlock(BLUE_SAND.get());

		logBlock(PURPLEHEART_LOG.get());
		logBlock(STRIPPED_PURPLEHEART_LOG.get());

		slabBlock(PURPLEHEART_SLAB.get(), PURPLEHEART_PLANKS.getId(), blockTexture(PURPLEHEART_PLANKS.get()));
		slabBlock(SULFUR_STONE_SLAB.get(), SULFUR_STONE.getId(), blockTexture(SULFUR_STONE.get()));
		slabBlock(SULFUR_COBBLESTONE_SLAB.get(), SULFUR_COBBLESTONE.getId(), blockTexture(SULFUR_COBBLESTONE.get()));
		slabBlock(SULFUR_STONE_BRICKS_SLAB.get(), SULFUR_STONE_BRICKS.getId(), blockTexture(SULFUR_STONE_BRICKS.get()));
		slabBlock(VIOLET_STONE_SLAB.get(), VIOLET_STONE.getId(), blockTexture(VIOLET_STONE.get()));

		fenceBlock(PURPLEHEART_FENCE.get(), blockTexture(PURPLEHEART_PLANKS.get()));

		fenceGateBlock(PURPLEHEART_FENCE_GATE.get(), blockTexture(PURPLEHEART_PLANKS.get()));

		buttonBlock(PURPLEHEART_BUTTON.get(), blockTexture(PURPLEHEART_PLANKS.get()));
		buttonBlock(SULFUR_STONE_BUTTON.get(), blockTexture(SULFUR_STONE.get()));

		pressurePlateBlock(PURPLEHEART_PRESSURE_PLATE.get(), blockTexture(PURPLEHEART_PLANKS.get()));
		pressurePlateBlock(SULFUR_STONE_PRESSURE_PLATE.get(), blockTexture(SULFUR_STONE.get()));

		doorBlockWithRenderType(PURPLEHEART_DOOR.get(),
				ResourceLocation.parse(blockTexture(PURPLEHEART_DOOR.get()) + "_bottom"),
				ResourceLocation.parse(blockTexture(PURPLEHEART_DOOR.get()) + "_top"), "cutout");

		trapdoorBlockWithRenderType(PURPLEHEART_TRAPDOOR.get(), blockTexture(PURPLEHEART_TRAPDOOR.get()), true, "cutout");

		stairsBlock(PURPLEHEART_STAIRS.get(), blockTexture(PURPLEHEART_PLANKS.get()));
		stairsBlock(SULFUR_STONE_STAIRS.get(), blockTexture(SULFUR_STONE.get()));
		stairsBlock(SULFUR_COBBLESTONE_STAIRS.get(), blockTexture(SULFUR_COBBLESTONE.get()));
		stairsBlock(SULFUR_STONE_BRICKS_STAIRS.get(), blockTexture(SULFUR_STONE_BRICKS.get()));
		stairsBlock(VIOLET_STONE_STAIRS.get(), blockTexture(VIOLET_STONE.get()));

		wallInventoryBlock(SULFUR_COBBLESTONE_WALL, blockTexture(SULFUR_COBBLESTONE.get()));
		wallInventoryBlock(SULFUR_STONE_BRICKS_WALL, blockTexture(SULFUR_STONE_BRICKS.get()));
		wallInventoryBlock(VIOLET_STONE_WALL, blockTexture(VIOLET_STONE.get()));

		simpleBlock(SAVORLEAF_BLOCK.get());
		simpleBlock(ORIGIN_FRAME.get());

		crossBlock(PURPLE_BERRY_DEAD_BUSH, blockTexture(PURPLE_BERRY_DEAD_BUSH.get()));

		doublePlantBlock(ORIGIN_TALL_GRASS, ResourceLocation.parse(blockTexture(ORIGIN_TALL_GRASS.get()) + "_top"),
				ResourceLocation.parse(blockTexture(ORIGIN_TALL_GRASS.get()) + "_bottom"));

		getVariantBuilder(BLUE_SANDSTONE.get()).partialState()
				.setModels(new ConfiguredModel(
						models().cubeBottomTop(BLUE_SANDSTONE.getId().getPath(), blockTexture(BLUE_SANDSTONE.get()),
								ResourceLocation.parse(blockTexture(BLUE_SANDSTONE.get()) + "_bottom"),
								ResourceLocation.parse(blockTexture(BLUE_SANDSTONE.get()) + "_top"))));

		getVariantBuilder(ORIGIN_FARMLAND.get()).partialState()
				.setModels(new ConfiguredModel(
						models().cubeBottomTop(ORIGIN_FARMLAND.getId().getPath(), blockTexture(ORIGIN_DIRT.get()),
								blockTexture(ORIGIN_DIRT.get()), blockTexture(ORIGIN_FARMLAND.get()))));

		getVariantBuilder(ORIGIN_GRASS_BLOCK.get()).partialState()
				.setModels(new ConfiguredModel(models().cubeBottomTop(ORIGIN_GRASS_BLOCK.getId().getPath(),
						ResourceLocation.parse(blockTexture(ORIGIN_GRASS_BLOCK.get()) + "_side"),
						blockTexture(ORIGIN_DIRT.get()),
						ResourceLocation.parse(blockTexture(ORIGIN_GRASS_BLOCK.get()) + "_top"))));
		
		getVariantBuilder(PURPLEHEART_BOOKSHELF.get()).partialState()
				.setModels(new ConfiguredModel(models().cubeBottomTop(PURPLEHEART_BOOKSHELF.getId().getPath(),
						blockTexture(PURPLEHEART_BOOKSHELF.get()), blockTexture(PURPLEHEART_PLANKS.get()),
						blockTexture(PURPLEHEART_PLANKS.get()))));

		getVariantBuilder(DISPLAY_BLOCK.get()).partialState()
				.setModels(new ConfiguredModel(models().cubeBottomTop(DISPLAY_BLOCK.getId().getPath(),
						ResourceLocation.parse(blockTexture(DISPLAY_BLOCK.get()) + "_side"),
						blockTexture(Blocks.END_STONE),
						ResourceLocation.parse(blockTexture(DISPLAY_BLOCK.get()) + "_top"))));
	}

	private void wallInventoryBlock(DeferredHolder<Block, ? extends WallBlock> block, ResourceLocation texture) {
		WallBlock wallBlock = block.get();
		wallBlock(wallBlock, texture);
		getMultipartBuilder(wallBlock).part()
				.modelFile(models().wallInventory(block.getId().getPath() + "_inventory", texture)).addModel();
	}

	private void crossBlock(DeferredHolder<Block, ? extends Block> block, ResourceLocation texture) {
		getVariantBuilder(block.get()).partialState()
				.setModels(new ConfiguredModel(models().cross(block.getId().getPath(), texture).renderType("cutout")));
	}

	private void doublePlantBlock(DeferredHolder<Block, ? extends DoublePlantBlock> block, ResourceLocation top,
			ResourceLocation bottom) {
		getVariantBuilder(block.get()).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)
				.addModels(new ConfiguredModel(models().cross(block.getId().getPath() + "_bottom", bottom).renderType("cutout")))
				.partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER)
				.addModels(new ConfiguredModel(models().cross(block.getId().getPath() + "_top", top).renderType("cutout")));
	}
}
