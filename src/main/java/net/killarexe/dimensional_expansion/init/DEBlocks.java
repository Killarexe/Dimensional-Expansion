package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.block.*;
import net.killarexe.dimensional_expansion.common.world.feature.tree.PurpleheartTreeGrower;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.OffsetType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class DEBlocks {

	public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, DEMod.MOD_ID);

	public static final RegistryObject<DropExperienceBlock> PALON_ORE = createOreBlock("palon_ore",
			MapColor.COLOR_YELLOW, 4, 10, 4, UniformInt.of(0, 0), SoundType.STONE, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> PALON_BLOCK = createBlock("palon_block", MapColor.COLOR_BLACK, 4, 10, 4,
			SoundType.NETHERITE_BLOCK, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<DropExperienceBlock> BASSMITE_ORE = createOreBlock("bassmite_ore",
			MapColor.COLOR_LIGHT_GRAY, 4, 20, 4, UniformInt.of(2, 6), SoundType.STONE, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> BASSMITE_BLOCK = createBlock("bassmite_block", MapColor.COLOR_BLUE, 4, 20,
			4, SoundType.AMETHYST, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<DropExperienceBlock> SIMIX_ORE = createOreBlock("simix_ore", MapColor.COLOR_RED,
			5, 30, 5, UniformInt.of(0, 0), SoundType.NETHERRACK, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> SIMIX_BLOCK = createBlock("simix_block", MapColor.COLOR_RED, 5, 30, 5,
			SoundType.NETHERITE_BLOCK, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<DropExperienceBlock> EMERTYST_ORE = createOreBlock("emertyst_ore",
			MapColor.COLOR_GRAY, 5, 40, 5, UniformInt.of(4, 10), SoundType.STONE, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> EMERTYST_BLOCK = createBlock("emertyst_block", MapColor.COLOR_MAGENTA, 5,
			40, 5, SoundType.AMETHYST, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> ORIGIN_GRASS_BLOCK = createCustomBlock("origin_grass_block",
			() -> new OriginGrassBlock(), DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> ORIGIN_DIRT_PATH = createCustomBlock("origin_dirt_path",
			() -> new OriginDirtPathBlock(), DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> ORIGIN_DIRT = createCustomBlock("origin_dirt",
			() -> new OriginDirtBlock(), DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<FarmBlock> ORIGIN_FARMLAND = createCustomBlock("origin_farmland",
			() -> new OriginFarmlandBlock(), DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<TallGrassBlock> ORIGIN_GRASS = createGrassBlock("origin_grass",
			MapColor.COLOR_BLACK, SoundType.GRASS, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<DoublePlantBlock> ORIGIN_TALL_GRASS = createDoublePlantBlock("origin_tall_grass",
			MapColor.COLOR_MAGENTA, SoundType.GRASS, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<RotatedPillarBlock> PURPLEHEART_LOG = createPillarBlock("purpleheart_log",
			MapColor.COLOR_BLACK, 1, 10, 1, SoundType.WOOD, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<RotatedPillarBlock> STRIPPED_PURPLEHEART_LOG = createPillarBlock(
			"stripped_purpleheart_log", MapColor.COLOR_BLACK, 1, 10, 1, SoundType.WOOD, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> PURPLEHEART_PLANKS = createBlock("purpleheart_planks",
			MapColor.COLOR_BLACK, 1, 10, 1, SoundType.WOOD, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<SlabBlock> PURPLEHEART_SLAB = createSlabBlock("purpleheart_slab",
			MapColor.COLOR_BLACK, 1, 10, 1, SoundType.WOOD, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<FenceBlock> PURPLEHEART_FENCE = createFenceBlock("purpleheart_fence",
			MapColor.COLOR_BLACK, 5, 10, 1, SoundType.WOOD, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<FenceGateBlock> PURPLEHEART_FENCE_GATE = createFenceGateBlock(
			"purpleheart_fence_gate", MapColor.COLOR_BLACK, 5, 10, 1, SoundType.WOOD, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<ButtonBlock> PURPLEHEART_BUTTON = createButtonBlock("purpleheart_button",
			MapColor.COLOR_BLACK, 5, 10, 1, SoundType.WOOD, false, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<PressurePlateBlock> PURPLEHEART_PRESSURE_PLATE = createPressurePlateBlock(
			"purpleheart_pressure_plate", MapColor.COLOR_BLACK, 5, 10, 1, SoundType.WOOD,
			PressurePlateBlock.Sensitivity.EVERYTHING, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<DoorBlock> PURPLEHEART_DOOR = createDoorBlock("purpleheart_door",
			MapColor.COLOR_BLACK, 5, 10, 1, SoundType.WOOD, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<TrapDoorBlock> PURPLEHEART_TRAPDOOR = createTrapDoorBlock("purpleheart_trapdoor",
			MapColor.COLOR_BLACK, 5, 10, 1, SoundType.WOOD, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<LeavesBlock> PURPLEHEART_LEAVES = createLeavesBlock("purpleheart_leaves",
			MapColor.COLOR_BLACK, 0, 50, 1, SoundType.GRASS, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<StairBlock> PURPLEHEART_STAIRS = createStairBlock("purpleheart_stairs",
			PURPLEHEART_PLANKS, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> PURPLEHEART_BOOKSHELF = createCustomBlock("purpleheart_bookshelf",
			() -> new PurpleheartBookself(), DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> PURPLEHEART_SIGN = createCustomBlock("purpleheart_sign",
			() -> new PurpleheartStandingSignBlock());

	public static final RegistryObject<Block> PURPLEHEART_WALL_SIGN = createCustomBlock("purpleheart_wall_sign",
			() -> new PurpleheartWallSignBlock());

	public static final RegistryObject<FlowerBlock> PURPLE_ROSE = createFlowerBlock("purple_rose",
			MobEffects.LEVITATION, 10, MapColor.COLOR_MAGENTA, 0, 10, 0, SoundType.FLOWERING_AZALEA,
			DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<FlowerPotBlock> POTTED_PURPLE_ROSE = createFlowerPotBlock("potted_purple_rose",
			() -> PURPLE_ROSE.get());

	public static final RegistryObject<SaplingBlock> PURPLEHEART_SAPLING = createSaplingBlock("purpleheart_sapling",
			new PurpleheartTreeGrower(), MapColor.COLOR_BLACK, 0, 50, 1, SoundType.GRASS, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<FlowerPotBlock> POTTED_PURPLEHEART_SAPLING = createFlowerPotBlock(
			"potted_purpleheart_sapling", () -> PURPLEHEART_SAPLING.get());

	public static final RegistryObject<Block> SULFUR_STONE = createBlock("sulfur_stone", MapColor.COLOR_YELLOW, 4, 10,
			4, SoundType.STONE, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<ButtonBlock> SULFUR_STONE_BUTTON = createButtonBlock("sulfur_stone_button",
			MapColor.COLOR_BLACK, 4, 10, 4, SoundType.STONE, false, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<PressurePlateBlock> SULFUR_STONE_PRESSURE_PLATE = createPressurePlateBlock(
			"sulfur_stone_pressure_plate", MapColor.COLOR_BLACK, 4, 10, 4, SoundType.STONE,
			PressurePlateBlock.Sensitivity.MOBS, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<SlabBlock> SULFUR_STONE_SLAB = createSlabBlock("sulfur_stone_slab",
			MapColor.COLOR_BLACK, 1, 10, 1, SoundType.STONE, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<StairBlock> SULFUR_STONE_STAIRS = createStairBlock("sulfur_stone_stairs",
			SULFUR_STONE, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> SULFUR_COBBLESTONE = createBlock("sulfur_cobblestone",
			MapColor.COLOR_YELLOW, 4, 10, 4, SoundType.STONE, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<SlabBlock> SULFUR_COBBLESTONE_SLAB = createSlabBlock("sulfur_cobblestone_slab",
			MapColor.COLOR_BLACK, 1, 10, 1, SoundType.STONE, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<StairBlock> SULFUR_COBBLESTONE_STAIRS = createStairBlock(
			"sulfur_cobblestone_stairs", SULFUR_COBBLESTONE, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<WallBlock> SULFUR_COBBLESTONE_WALL = createWallBlock("sulfur_cobblestone_wall",
			MapColor.COLOR_YELLOW, 4, 10, 4, SoundType.STONE, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<FallingBlock> BLUE_SAND = createFallingBlock("blue_sand", MapColor.COLOR_BLACK,
			1, 10, 1, SoundType.SAND, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> BLUE_SANDSTONE = createBlock("blue_sandstone", MapColor.COLOR_BLACK, 1,
			10, 1, SoundType.STONE, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> PURPLEISH_CACTUS = createCustomBlock("purpleish_cactus",
			() -> new PurpleishCactusBlock(), DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<FlowerPotBlock> POTTED_PURPLEISH_CACTUS = createFlowerPotBlock(
			"potted_purpleish_cactus", () -> PURPLEISH_CACTUS.get());

	public static final RegistryObject<Block> ORIGIN_PORTAL = createCustomBlock("origin_portal",
			() -> new OriginPortalBlock());
	public static final RegistryObject<Block> ORIGIN_FRAME = createBlock("origin_frame", MapColor.CLAY, 4, 10, 4,
			SoundType.METAL, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> FORGE = createBlock("forge", MapColor.COLOR_BLACK, 3, 50, 2,
			SoundType.ANVIL, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> ESSENCE_EXTRACTOR = createCustomBlock("essence_extractor",
			() -> new EssenceExtractor(), DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> MINERAL_STORAGE = createBlock("mineral_storage", MapColor.COLOR_BLACK, 3,
			50, 2, SoundType.ANVIL, DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> DISPLAY_BLOCK = createCustomBlock("display_block",
			() -> new DisplayBlock(), DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> ENCHANT_TRANSFER_TABLE = createCustomBlock("enchant_transfer_table",
			() -> new EnchantTransferTable(), DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<SavorleafBlock> SAVORLEAF_BLOCK = createCustomBlock("savorleaf_block",
			() -> new SavorleafBlock(), DECreativeTabs.Tabs.BLOCKS);

	public static final RegistryObject<Block> PURPLE_BERRY_BUSH = createCustomBlock("purple_berry_bush",
			() -> new PurpleBerryBush());

	public static final RegistryObject<SavorleafCropBlock> SAVORLEAF_CROP = createCustomBlock("savorleaf_crop",
			() -> new SavorleafCropBlock());

	public static final RegistryObject<VioletCarrotCropBlock> VIOLET_CARROT_CROP = createCustomBlock(
			"violet_carrot_crop", () -> new VioletCarrotCropBlock());

	public static final RegistryObject<DeadBushBlock> PURPLE_BERRY_DEAD_BUSH = createCustomBlock(
			"purple_berry_dead_bush",
			() -> new DeadBushBlock(BlockBehaviour.Properties.copy(DEBlocks.PURPLE_BERRY_BUSH.get())),
			DECreativeTabs.Tabs.BLOCKS);

	private static RegistryObject<Block> createBlock(@Nonnull String id, MapColor color, float hardness,
			float resistance, float harvestLevel, SoundType sound, DECreativeTabs.Tabs itemGroup) {
		RegistryObject<Block> block = BLOCK.register(id, () -> new Block(BlockBehaviour.Properties.of().mapColor(color)
				.strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<LeavesBlock> createLeavesBlock(@Nonnull String id, MapColor color, float hardness,
			float resistance, float harvestLevel, SoundType sound, DECreativeTabs.Tabs itemGroup) {
		RegistryObject<LeavesBlock> block = BLOCK.register(id,
				() -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(color).strength(hardness, resistance)
						.lightLevel(s -> 1).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)
						.randomTicks().noOcclusion()));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<DropExperienceBlock> createOreBlock(@Nonnull String id, MapColor color,
			float hardness, float resistance, float harvestLevel, UniformInt xpDrop, SoundType sound,
			DECreativeTabs.Tabs itemGroup) {
		RegistryObject<DropExperienceBlock> block = BLOCK.register(id,
				() -> new DropExperienceBlock(
						BlockBehaviour.Properties.of().mapColor(color).strength(hardness, resistance)
								.requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound),
						xpDrop));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<RotatedPillarBlock> createPillarBlock(@Nonnull String id, MapColor color,
			float hardness, float resistance, float harvestLevel, SoundType sound, DECreativeTabs.Tabs itemGroup) {
		RegistryObject<RotatedPillarBlock> block = BLOCK.register(id,
				() -> new RotatedPillarBlock(
						BlockBehaviour.Properties.of().mapColor(color).strength(hardness, resistance)
								.requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<FenceBlock> createFenceBlock(@Nonnull String id, MapColor color, float hardness,
			float resistance, float harvestLevel, SoundType sound, DECreativeTabs.Tabs itemGroup) {
		RegistryObject<FenceBlock> block = BLOCK.register(id,
				() -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(color).strength(hardness, resistance)
						.requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<WallBlock> createWallBlock(@Nonnull String id, MapColor color, float hardness,
			float resistance, float harvestLevel, SoundType sound, DECreativeTabs.Tabs itemGroup) {
		RegistryObject<WallBlock> block = BLOCK.register(id,
				() -> new WallBlock(BlockBehaviour.Properties.of().mapColor(color).strength(hardness, resistance)
						.requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<FenceGateBlock> createFenceGateBlock(@Nonnull String id, MapColor color,
			float hardness, float resistance, float harvestLevel, SoundType sound, DECreativeTabs.Tabs itemGroup) {
		RegistryObject<FenceGateBlock> block = BLOCK.register(id,
				() -> new FenceGateBlock(
						BlockBehaviour.Properties.of().mapColor(color).strength(hardness, resistance)
								.requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound),
						SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<SlabBlock> createSlabBlock(@Nonnull String id, MapColor color, float hardness,
			float resistance, float harvestLevel, SoundType sound, DECreativeTabs.Tabs itemGroup) {
		RegistryObject<SlabBlock> block = BLOCK.register(id,
				() -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(color).strength(hardness, resistance)
						.requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<FallingBlock> createFallingBlock(@Nonnull String id, MapColor color, float hardness,
			float resistance, float harvestLevel, SoundType sound, DECreativeTabs.Tabs itemGroup) {
		RegistryObject<FallingBlock> block = BLOCK.register(id,
				() -> new FallingBlock(BlockBehaviour.Properties.of().mapColor(color).strength(hardness, resistance)
						.requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<StairBlock> createStairBlock(@Nonnull String id, RegistryObject<Block> baseBlock,
			DECreativeTabs.Tabs itemGroup) {
		RegistryObject<StairBlock> block = BLOCK.register(id,
				() -> new StairBlock(() -> baseBlock.get().defaultBlockState(),
						BlockBehaviour.Properties.copy(baseBlock.get())));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<ButtonBlock> createButtonBlock(@Nonnull String id, MapColor color, float hardness,
			float resistance, float harvestLevel, SoundType sound, boolean isSensitive, DECreativeTabs.Tabs itemGroup) {
		RegistryObject<ButtonBlock> block = BLOCK.register(id,
				() -> new ButtonBlock(
						BlockBehaviour.Properties.of().mapColor(color).strength(hardness, resistance)
								.requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound),
						BlockSetType.OAK, 20, isSensitive));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<PressurePlateBlock> createPressurePlateBlock(@Nonnull String id, MapColor color,
			float hardness, float resistance, float harvestLevel, SoundType sound,
			PressurePlateBlock.Sensitivity sensitivity, DECreativeTabs.Tabs itemGroup) {
		RegistryObject<PressurePlateBlock> block = BLOCK.register(id,
				() -> new PressurePlateBlock(sensitivity,
						BlockBehaviour.Properties.of().mapColor(color).strength(hardness, resistance)
								.requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound),
						BlockSetType.OAK));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<DoorBlock> createDoorBlock(@Nonnull String id, MapColor color, float hardness,
			float resistance, float harvestLevel, SoundType sound, DECreativeTabs.Tabs itemGroup) {
		RegistryObject<DoorBlock> block = BLOCK.register(id,
				() -> new DoorBlock(
						BlockBehaviour.Properties.of().mapColor(color).strength(hardness, resistance)
								.requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).noOcclusion(),
						BlockSetType.OAK));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<TrapDoorBlock> createTrapDoorBlock(@Nonnull String id, MapColor color, float hardness,
			float resistance, float harvestLevel, SoundType sound, DECreativeTabs.Tabs itemGroup) {
		RegistryObject<TrapDoorBlock> block = BLOCK.register(id,
				() -> new TrapDoorBlock(
						BlockBehaviour.Properties.of().mapColor(color).strength(hardness, resistance)
								.requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).noOcclusion(),
						BlockSetType.OAK));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<SaplingBlock> createSaplingBlock(@Nonnull String id, AbstractTreeGrower grower,
			MapColor color, float hardness, float resistance, float harvestLevel, SoundType sound,
			DECreativeTabs.Tabs itemGroup) {
		RegistryObject<SaplingBlock> block = BLOCK.register(id,
				() -> new SaplingBlock(grower,
						BlockBehaviour.Properties.of().mapColor(color).strength(hardness, resistance)
								.destroyTime(harvestLevel).sound(sound).noOcclusion().noCollission()));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<FlowerBlock> createFlowerBlock(@Nonnull String id, MobEffect effect, int duration,
			MapColor color, float hardness, float resistance, float harvestLevel, SoundType sound,
			DECreativeTabs.Tabs itemGroup) {
		RegistryObject<FlowerBlock> block = BLOCK.register(id,
				() -> new FlowerBlock(() -> effect, duration,
						BlockBehaviour.Properties.of().mapColor(color).strength(hardness, resistance)
								.requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).noOcclusion()
								.instabreak().dynamicShape().noCollission()));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<FlowerPotBlock> createFlowerPotBlock(String id, Supplier<Block> flowerBlock) {
		RegistryObject<FlowerPotBlock> block = BLOCK.register(id,
				() -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, flowerBlock,
						BlockBehaviour.Properties.copy(Blocks.POTTED_ACACIA_SAPLING)));
		return block;
	}

	private static RegistryObject<TallGrassBlock> createGrassBlock(String id, MapColor color, SoundType sound,
			DECreativeTabs.Tabs itemGroup) {
		RegistryObject<TallGrassBlock> block = BLOCK.register(id,
				() -> new TallGrassBlock(BlockBehaviour.Properties.of().mapColor(color).sound(sound).lightLevel(s -> 5)
						.instabreak().noCollission().offsetType(OffsetType.XYZ).noOcclusion()));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
		return block;
	}

	private static RegistryObject<DoublePlantBlock> createDoublePlantBlock(String id, MapColor color, SoundType sound,
			DECreativeTabs.Tabs tab) {
		RegistryObject<DoublePlantBlock> block = BLOCK.register(id,
				() -> new DoublePlantBlock(BlockBehaviour.Properties.of().mapColor(color).sound(sound)
						.lightLevel(s -> 5).instabreak().noCollission().offsetType(OffsetType.XYZ).noOcclusion()));
		DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), tab);
		return block;
	}

	private static <T extends Block> RegistryObject<T> createCustomBlock(@Nonnull String id, Supplier<T> block,
			DECreativeTabs.Tabs itemGroup) {
		RegistryObject<T> cBlock = BLOCK.register(id, block);
		DEItems.createItem(id, () -> new BlockItem(cBlock.get(), new Item.Properties().fireResistant()), itemGroup);
		return cBlock;
	}

	private static <T extends Block> RegistryObject<T> createCustomBlock(@Nonnull String id, Supplier<T> block) {
		RegistryObject<T> cBlock = BLOCK.register(id, block);
		return cBlock;
	}
}
