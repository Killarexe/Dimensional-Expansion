package net.killarexe.dimensional_expansion.common.data.generation.client;

import static net.killarexe.dimensional_expansion.init.DEBlocks.*;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.block.*;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.neoforge.client.model.generators.*;
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
		simpleBlock(SULFUR_COBBLESTONE.get());

		pathBlock(ORIGIN_DIRT_PATH,
				ResourceLocation.parse(blockTexture(ORIGIN_DIRT_PATH.get()) + "_top"),
				ResourceLocation.parse(blockTexture(ORIGIN_DIRT_PATH.get()) + "_side"),
				blockTexture(ORIGIN_DIRT.get())
		);

		logBlock(PURPLEHEART_LOG.get());
		logBlock(STRIPPED_PURPLEHEART_LOG.get());

		slabBlock(PURPLEHEART_SLAB.get(), PURPLEHEART_PLANKS.getId(), blockTexture(PURPLEHEART_PLANKS.get()));
		slabBlock(SULFUR_STONE_SLAB.get(), SULFUR_STONE.getId(), blockTexture(SULFUR_STONE.get()));
		slabBlock(SULFUR_COBBLESTONE_SLAB.get(), SULFUR_COBBLESTONE.getId(), blockTexture(SULFUR_COBBLESTONE.get()));
		slabBlock(SULFUR_STONE_BRICKS_SLAB.get(), SULFUR_STONE_BRICKS.getId(), blockTexture(SULFUR_STONE_BRICKS.get()));
		slabBlock(VIOLET_STONE_SLAB.get(), VIOLET_STONE.getId(), blockTexture(VIOLET_STONE.get()));

		fenceBlockWithInventory(PURPLEHEART_FENCE, blockTexture(PURPLEHEART_PLANKS.get()));
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
		crossBlock(ORIGIN_GRASS, blockTexture(ORIGIN_GRASS.get()));
		crossBlock(PURPLE_ROSE, blockTexture(PURPLE_ROSE.get()));
		crossBlock(PURPLEHEART_SAPLING, blockTexture(PURPLEHEART_SAPLING.get()));

		enchantTransferTable(ENCHANT_TRANSFER_TABLE);
		cactus(PURPLEISH_CACTUS);

		farmland(ORIGIN_FARMLAND, OriginFarmlandBlock.MOISTURE, blockTexture(ORIGIN_DIRT.get()));

		crop(SAVORLEAF_CROP, SavorleafCropBlock.AGE);
		crop(VIOLET_CARROT_CROP, VioletCarrotCropBlock.AGE);
		growableBush(PURPLE_BERRY_BUSH, PurpleBerryBush.AGE);

		doublePlantBlock(ORIGIN_TALL_GRASS, ResourceLocation.parse(blockTexture(ORIGIN_TALL_GRASS.get()) + "_top"),
				ResourceLocation.parse(blockTexture(ORIGIN_TALL_GRASS.get()) + "_bottom"));

		getVariantBuilder(BLUE_SANDSTONE.get()).partialState()
				.setModels(new ConfiguredModel(
						models().cubeBottomTop(BLUE_SANDSTONE.getId().getPath(), blockTexture(BLUE_SANDSTONE.get()),
								ResourceLocation.parse(blockTexture(BLUE_SANDSTONE.get()) + "_bottom"),
								ResourceLocation.parse(blockTexture(BLUE_SANDSTONE.get()) + "_top"))));

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

	private void farmland(DeferredHolder<Block, ? extends FarmBlock> block, IntegerProperty moist, ResourceLocation otherSides) {
		FarmBlock farmBlock = block.get();
		VariantBlockStateBuilder blockStateBuilder = getVariantBuilder(farmBlock);
		String path = block.getId().getPath();
		ResourceLocation topLocation = blockTexture(farmBlock);
		ModelFile unmoistModel = createPathModel(path, topLocation, otherSides, otherSides);
		ModelFile moistModel = createPathModel(path + "_moist", ResourceLocation.parse(topLocation + "_moist"), otherSides, otherSides);
		blockStateBuilder.forAllStates(blockState -> {
			boolean isMoist = blockState.getValue(moist) > 6;
			return ConfiguredModel.builder().modelFile(isMoist ? moistModel : unmoistModel).build();
		});
	}

	private void growableBush(DeferredHolder<Block, ? extends SweetBerryBushBlock> block, IntegerProperty ageProperty) {
		SweetBerryBushBlock sweetBerryBushBlock = block.get();
		VariantBlockStateBuilder blockStateBuilder = getVariantBuilder(sweetBerryBushBlock);
		blockStateBuilder.forAllStates(blockState -> {
			int age = blockState.getValue(ageProperty);
			return ConfiguredModel.builder().modelFile(createBushModel(block.getId().getPath(), age)).build();
		});
	}

	private ModelFile createBushModel(String blockPath, int age) {
		String path = blockPath + "_stage" + age;
		return models().cross(path, DEMod.res("block/" + path)).renderType("cutout");
	}

	private void crop(DeferredHolder<Block, ? extends CropBlock> block, IntegerProperty ageProperty) {
		CropBlock cropBlock = block.get();
		VariantBlockStateBuilder blockStateBuilder = getVariantBuilder(cropBlock);
		blockStateBuilder.forAllStates(blockState -> {
			int age = blockState.getValue(ageProperty);
			return ConfiguredModel.builder().modelFile(createCropModel(block.getId().getPath(), age)).build();
		});
	}

	private ModelFile createCropModel(String blockPath, int age) {
		String path = blockPath + "_stage" + age;
		return models().crop(path, DEMod.res("block/" + path)).renderType("cutout");
	}

	private void cactus(DeferredHolder<Block, ? extends Block> block) {
		Block cactusBlock = block.get();
		ResourceLocation location = blockTexture(cactusBlock);
		BlockModelBuilder model = models().cubeBottomTop(
				block.getId().getPath(),
				ResourceLocation.parse(location + "_side"),
				ResourceLocation.parse(location + "_bottom"),
				ResourceLocation.parse(location + "_top")
		);
		ModelBuilder<BlockModelBuilder>.ElementBuilder builder = model.element();
		builder.from(0, 0, 0).to(16, 16, 16);
		builder.face(Direction.DOWN).uvs(0, 0 ,16, 16).texture("#bottom").cullface(Direction.DOWN).end()
				.face(Direction.UP).uvs(0, 0, 16, 16).texture("#top").cullface(Direction.UP).end();
		builder.end();
		ModelBuilder<BlockModelBuilder>.ElementBuilder builder1 = model.element();
		builder1.from(0, 0, 1).to(16, 16, 15);
		builder1.face(Direction.NORTH).uvs(0, 0 ,16, 16).texture("#side").cullface(Direction.NORTH).end()
				.face(Direction.SOUTH).uvs(0, 0, 16, 16).texture("#side").cullface(Direction.SOUTH).end();
		builder1.end();
		ModelBuilder<BlockModelBuilder>.ElementBuilder builder2 = model.element();
		builder2.from(1, 0, 0).to(15, 16, 16);
		builder2.face(Direction.WEST).uvs(0, 0 ,16, 16).texture("#side").cullface(Direction.WEST).end()
				.face(Direction.EAST).uvs(0, 0, 16, 16).texture("#side").cullface(Direction.EAST).end();
		builder2.end();
		model.renderType("cutout");
		getVariantBuilder(cactusBlock).partialState().setModels(new ConfiguredModel(model));
	}

	private void enchantTransferTable(DeferredHolder<Block, EnchantTransferTable> block) {
		EnchantTransferTable enchantTransferTable = block.get();
		ResourceLocation location = blockTexture(enchantTransferTable);
		BlockModelBuilder model = models().cubeBottomTop(
				block.getId().getPath(),
				ResourceLocation.parse(location + "_side"),
				blockTexture(ORIGIN_FRAME.get()),
				ResourceLocation.parse(location + "_top")
		);
		ModelBuilder<BlockModelBuilder>.ElementBuilder builder = model.element();
		builder.from(0, 0, 0);
		builder.to(16, 12, 16);
		builder.allFaces(this::createEnchantTransferTableFaces);
		builder.end();
		model.renderType("cutout");
		getVariantBuilder(enchantTransferTable).partialState().setModels(new ConfiguredModel(model));
	}

	private void createEnchantTransferTableFaces(Direction direction, ModelBuilder.ElementBuilder.FaceBuilder builder) {
		switch (direction) {
			case DOWN:
				builder.uvs(0, 0, 16, 16);
				builder.texture("#bottom");
				builder.cullface(direction);
				break;
			case UP:
				builder.uvs(0, 0, 16, 16);
				builder.texture("#top");
				builder.cullface(direction);
				break;
			case NORTH, SOUTH, WEST, EAST:
				builder.uvs(0, 4, 16, 16);
				builder.texture("#side");
				builder.cullface(direction);
				break;
		}
		builder.end();
	}

	private void pathBlock(DeferredHolder<Block, ? extends Block> block, ResourceLocation top, ResourceLocation side, ResourceLocation down) {
		getVariantBuilder(block.get()).partialState().setModels(new ConfiguredModel(createPathModel(block.getId().getPath(), top, side, down)));
	}

	private ModelFile createPathModel(String blockPath, ResourceLocation top, ResourceLocation side, ResourceLocation down) {
		BlockModelBuilder model = models()
				.withExistingParent(blockPath, "block")
				.texture("side", side).
				texture("bottom", down)
				.texture("top", top)
				.texture("particle", down);
		ModelBuilder<BlockModelBuilder>.ElementBuilder builder = model.element();
		builder.from(0, 0, 0);
		builder.to(16, 15, 16);
		builder.allFaces(this::createPathBlockFaces);
		builder.end();
		model.renderType("cutout");
		return model;
	}

	private void createPathBlockFaces(Direction direction, ModelBuilder.ElementBuilder.FaceBuilder builder) {
		switch (direction) {
			case DOWN:
				builder.uvs(0, 0, 16, 16);
				builder.texture("#bottom");
				builder.cullface(direction);
				break;
			case UP:
				builder.uvs(0, 0, 16, 16);
				builder.texture("#top");
				break;
			case NORTH, SOUTH, WEST, EAST:
				builder.uvs(0, 1, 16, 16);
				builder.texture("#side");
				builder.cullface(direction);
				break;
        }
		builder.end();
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

	private void fenceBlockWithInventory(DeferredHolder<Block, ? extends FenceBlock> block, ResourceLocation texture) {
		FenceBlock fenceBlock = block.get();
		fenceBlock(fenceBlock, texture);
		getMultipartBuilder(fenceBlock).part()
				.modelFile(models().fenceInventory(block.getId().getPath() + "_inventory", texture)).addModel();
	}

	private void wallInventoryBlock(DeferredHolder<Block, ? extends WallBlock> block, ResourceLocation texture) {
		WallBlock wallBlock = block.get();
		wallBlock(wallBlock, texture);
		getMultipartBuilder(wallBlock).part()
				.modelFile(models().wallInventory(block.getId().getPath() + "_inventory", texture)).addModel();
	}
}
