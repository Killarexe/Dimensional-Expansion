package net.killarexe.dimensional_expansion.core.init;

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
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class DEBlocks {

    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, DEMod.MOD_ID);

    public static final RegistryObject<DropExperienceBlock> PALON_ORE = createOreBlock("palon_ore", Material.STONE, MaterialColor.COLOR_YELLOW, 4, 10, 4, UniformInt.of(0, 0), SoundType.STONE, DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> PALON_BLOCK = createBlock("palon_block", Material.METAL, MaterialColor.COLOR_BLACK, 4, 10, 4, SoundType.NETHERITE_BLOCK, DECreativeTabs.BLOCKS);
    public static final RegistryObject<DropExperienceBlock> BASSMITE_ORE = createOreBlock("bassmite_ore", Material.STONE, MaterialColor.COLOR_LIGHT_GRAY, 5, 20, 5, UniformInt.of(2, 6), SoundType.STONE, DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> BASSMITE_BLOCK = createBlock("bassmite_block", Material.METAL, MaterialColor.COLOR_BLUE,5, 20, 5, SoundType.AMETHYST, DECreativeTabs.BLOCKS);
    public static final RegistryObject<DropExperienceBlock> SIMIX_ORE = createOreBlock("simix_ore", Material.STONE, MaterialColor.COLOR_RED, 6, 30, 6, UniformInt.of(0, 0), SoundType.NETHERRACK, DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> SIMIX_BLOCK = createBlock("simix_block", Material.METAL, MaterialColor.COLOR_RED, 6, 30, 6, SoundType.NETHERITE_BLOCK, DECreativeTabs.BLOCKS);
    public static final RegistryObject<DropExperienceBlock> EMERTYST_ORE = createOreBlock("emertyst_ore", Material.STONE, MaterialColor.COLOR_GRAY, 7, 40, 7, UniformInt.of(4, 10), SoundType.STONE, DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> EMERTYST_BLOCK = createBlock("emertyst_block", Material.METAL, MaterialColor.COLOR_MAGENTA, 7, 40, 7, SoundType.AMETHYST, DECreativeTabs.BLOCKS);

    public static final RegistryObject<Block> ORIGIN_GRASS_BLOCK = createCustomBlock("origin_grass_block", () -> new OriginGrassBlock(), DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> ORIGIN_DIRT_PATH = createCustomBlock("origin_dirt_path", () -> new OriginDirtPathBlock(), DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> ORIGIN_DIRT = createBlock("origin_dirt", Material.DIRT, MaterialColor.COLOR_BLACK, 1, 10, 1, SoundType.GRAVEL, DECreativeTabs.BLOCKS);
    public static final RegistryObject<FarmBlock> ORIGIN_FARMLAND = createCustomBlock("origin_farmland", () -> new OriginFarmlandBlock(), DECreativeTabs.BLOCKS);
    public static final RegistryObject<TallGrassBlock> ORIGIN_GRASS = createGrassBlock("origin_grass", Material.GRASS, MaterialColor.COLOR_BLACK, SoundType.GRASS, DECreativeTabs.BLOCKS);
    public static final RegistryObject<RotatedPillarBlock> PURPLEHEART_LOG = createPillarBlock("purpleheart_log", Material.WOOD, MaterialColor.COLOR_BLACK, 1, 10, 1, SoundType.WOOD, DECreativeTabs.BLOCKS);
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_PURPLEHEART_LOG = createPillarBlock("stripped_purpleheart_log", Material.WOOD, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.WOOD, DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_PLANKS = createBlock("purpleheart_planks", Material.WOOD, MaterialColor.COLOR_BLACK, 1, 10, 1, SoundType.WOOD, DECreativeTabs.BLOCKS);
    public static final RegistryObject<SlabBlock> PURPLEHEART_SLAB = createSlabBlock("purpleheart_slab", Material.WOOD, MaterialColor.COLOR_BLACK, 1, 10, 1, SoundType.WOOD, DECreativeTabs.BLOCKS);
    public static final RegistryObject<FenceBlock> PURPLEHEART_FENCE = createFenceBlock("purpleheart_fence", Material.WOOD, MaterialColor.COLOR_BLACK, 5, 10, 1, SoundType.WOOD, DECreativeTabs.BLOCKS);
    public static final RegistryObject<FenceGateBlock> PURPLEHEART_FENCE_GATE = createFenceGateBlock("purpleheart_fence_gate", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, DECreativeTabs.BLOCKS);
    public static final RegistryObject<ButtonBlock> PURPLEHEART_BUTTON = createButtonBlock( "purpleheart_button", Material.WOOD, MaterialColor.COLOR_BLACK, 5, 10, 1, SoundType.WOOD, false, DECreativeTabs.BLOCKS);
    public static final RegistryObject<PressurePlateBlock> PURPLEHEART_PRESSURE_PLATE = createPressurePlateBlock("purpleheart_pressure_plate", Material.WOOD, MaterialColor.COLOR_BLACK, 5, 10, 1, SoundType.WOOD, PressurePlateBlock.Sensitivity.EVERYTHING, DECreativeTabs.BLOCKS);
    public static final RegistryObject<DoorBlock> PURPLEHEART_DOOR = createDoorBlock("purpleheart_door", Material.WOOD, MaterialColor.COLOR_BLACK, 5, 10, 1, SoundType.WOOD, DECreativeTabs.BLOCKS);
    public static final RegistryObject<TrapDoorBlock> PURPLEHEART_TRAPDOOR = createTrapDoorBlock("purpleheart_trapdoor", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, DECreativeTabs.BLOCKS);
    public static final RegistryObject<LeavesBlock> PURPLEHEART_LEAVES = createLeavesBlock("purpleheart_leaves", Material.LEAVES, MaterialColor.COLOR_BLACK, 0, 50, 1, SoundType.GRASS, DECreativeTabs.BLOCKS);
    public static final RegistryObject<StairBlock> PURPLEHEART_STAIRS = createStairBlock("purpleheart_stairs", PURPLEHEART_PLANKS, DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_BOOKSHELF = createCustomBlock("purpleheart_bookshelf", () -> new PurpleheartBookself(), DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_SIGN = createCustomBlock("purpleheart_sign", () -> new PurpleheartStandingSignBlock());
    public static final RegistryObject<Block> PURPLEHEART_WALL_SIGN = createCustomBlock("purpleheart_wall_sign", () -> new PurpleheartWallSignBlock());
    public static final RegistryObject<FlowerBlock> PURPLE_ROSE = createFlowerBlock("purple_rose", MobEffects.LEVITATION, 10, Material.PLANT, MaterialColor.COLOR_MAGENTA, 0, 10, 0, SoundType.FLOWERING_AZALEA, DECreativeTabs.BLOCKS);
    public static final RegistryObject<FlowerPotBlock> POTTED_PURPLE_ROSE = createFlowerPotBlock("potted_purple_rose", () -> PURPLE_ROSE.get());
    public static final RegistryObject<SaplingBlock> PURPLEHEART_SAPLING = createSaplingBlock("purpleheart_sapling", new PurpleheartTreeGrower(), Material.LEAVES, MaterialColor.COLOR_BLACK,0, 50, 1, SoundType.GRASS, DECreativeTabs.BLOCKS);
    public static final RegistryObject<FlowerPotBlock> POTTED_PURPLEHEART_SAPLING = createFlowerPotBlock("potted_purpleheart_sapling", () -> PURPLEHEART_SAPLING.get());
    public static final RegistryObject<Block> SULFUR_STONE = createBlock("sulfur_stone", Material.STONE, MaterialColor.COLOR_YELLOW, 4, 10, 4, SoundType.STONE, DECreativeTabs.BLOCKS);
    public static final RegistryObject<ButtonBlock> SULFUR_STONE_BUTTON = createButtonBlock( "sulfur_stone_button", Material.STONE, MaterialColor.COLOR_BLACK, 4, 10, 4, SoundType.STONE, false, DECreativeTabs.BLOCKS);
    public static final RegistryObject<PressurePlateBlock> SULFUR_STONE_PRESSURE_PLATE = createPressurePlateBlock("sulfur_stone_pressure_plate", Material.STONE, MaterialColor.COLOR_BLACK, 4, 10, 4, SoundType.STONE, PressurePlateBlock.Sensitivity.MOBS, DECreativeTabs.BLOCKS);
    public static final RegistryObject<SlabBlock> SULFUR_STONE_SLAB = createSlabBlock("sulfur_stone_slab", Material.STONE, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.WOOD, DECreativeTabs.BLOCKS);
    public static final RegistryObject<StairBlock> SULFUR_STONE_STAIRS = createStairBlock("sulfur_stone_stairs", SULFUR_STONE, DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> SULFUR_COBBLESTONE = createBlock("sulfur_cobblestone", Material.STONE, MaterialColor.COLOR_YELLOW, 4, 10, 4, SoundType.STONE, DECreativeTabs.BLOCKS);
    public static final RegistryObject<SlabBlock> SULFUR_COBBLESTONE_SLAB = createSlabBlock("sulfur_cobblestone_slab", Material.STONE, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.STONE, DECreativeTabs.BLOCKS);
    public static final RegistryObject<StairBlock> SULFUR_COBBLESTONE_STAIRS = createStairBlock("sulfur_cobblestone_stairs", SULFUR_COBBLESTONE, DECreativeTabs.BLOCKS);
    public static final RegistryObject<WallBlock> SULFUR_COBBLESTONE_WALL = createWallBlock("sulfur_cobblestone_wall", Material.STONE, MaterialColor.COLOR_YELLOW, 4, 10, 4, SoundType.STONE, DECreativeTabs.BLOCKS);
    public static final RegistryObject<FallingBlock> BLUE_SAND = createFallingBlock("blue_sand", Material.SAND, MaterialColor.COLOR_BLACK, 1, 10, 1, SoundType.SAND, DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> BLUE_SANDSTONE = createBlock("blue_sandstone", Material.STONE, MaterialColor.COLOR_BLACK, 1, 10, 1, SoundType.STONE, DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> PURPLEISH_CACTUS = createCustomBlock("purpleish_cactus", () -> new PurpleishCactusBlock(), DECreativeTabs.BLOCKS);
    public static final RegistryObject<FlowerPotBlock> POTTED_PURPLEISH_CACTUS = createFlowerPotBlock("potted_purpleish_cactus", () -> PURPLEISH_CACTUS.get());
    
    public static final RegistryObject<Block> ORIGIN_PORTAL = createCustomBlock("origin_portal", () -> new OriginPortalBlock());
    public static final RegistryObject<Block> ORIGIN_FRAME = createBlock("origin_frame", Material.METAL, MaterialColor.CLAY, 0, 0, 0, SoundType.METAL, DECreativeTabs.BLOCKS);
    
    public static final RegistryObject<Block> FORGE = createBlock("forge", Material.METAL, MaterialColor.COLOR_BLACK, 3, 50, 2, SoundType.ANVIL, DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> ESSENCE_EXTRACTOR = createCustomBlock("essence_extractor", () -> new EssenceExtractor(), DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> MINERAL_STORAGE = createBlock("mineral_storage", Material.METAL, MaterialColor.COLOR_BLACK, 3, 50, 2, SoundType.ANVIL, DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> DISPLAY_BLOCK = createCustomBlock("display_block", () -> new DisplayBlock(), DECreativeTabs.BLOCKS);
    public static final RegistryObject<Block> ENCHANT_TRANSFER_TABLE = createCustomBlock("enchant_transfer_table", () -> new EnchantTransferTable(), DECreativeTabs.BLOCKS);
    
    public static final RegistryObject<Block> PURPLE_BERRY_BUSH = createCustomBlock("purple_berry_bush", () -> new PurpleBerryBush());
    
    private static RegistryObject<Block> createBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, DECreativeTabs itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new Block(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
        return block;
    }

    private static RegistryObject<LeavesBlock> createLeavesBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, DECreativeTabs itemGroup){
        RegistryObject<LeavesBlock> block = BLOCK.register(id, () -> new LeavesBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).lightLevel(s -> 1).randomTicks().noOcclusion()));
        DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
        return block;
    }

    private static RegistryObject<DropExperienceBlock> createOreBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, UniformInt xpDrop, SoundType sound, DECreativeTabs itemGroup){
        RegistryObject<DropExperienceBlock> block = BLOCK.register(id, () -> new DropExperienceBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound), xpDrop));
        DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
        return block;
    }

    private static RegistryObject<RotatedPillarBlock> createPillarBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, DECreativeTabs itemGroup){
        RegistryObject<RotatedPillarBlock> block = BLOCK.register(id, () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
        return block;
    }

    private static RegistryObject<FenceBlock> createFenceBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, DECreativeTabs itemGroup){
        RegistryObject<FenceBlock> block = BLOCK.register(id, () -> new FenceBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
        return block;
    }
    
    private static RegistryObject<WallBlock> createWallBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, DECreativeTabs itemGroup){
    	RegistryObject<WallBlock> block = BLOCK.register(id, () -> new WallBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
    	DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
    	return block;
    }

    private static RegistryObject<FenceGateBlock> createFenceGateBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, DECreativeTabs itemGroup){
        RegistryObject<FenceGateBlock> block = BLOCK.register(id, () -> new FenceGateBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN));
        DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
        return block;
    }

    private static RegistryObject<SlabBlock> createSlabBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, DECreativeTabs itemGroup){
        RegistryObject<SlabBlock> block = BLOCK.register(id, () -> new SlabBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
        return block;
    }

    private static RegistryObject<FallingBlock> createFallingBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, DECreativeTabs itemGroup){
        RegistryObject<FallingBlock> block = BLOCK.register(id, () -> new FallingBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
        return block;
    }

    private static RegistryObject<StairBlock> createStairBlock(@Nonnull String id, RegistryObject<Block> baseBlock, DECreativeTabs itemGroup){
        RegistryObject<StairBlock> block = BLOCK.register(id, () -> new StairBlock(() -> baseBlock.get().defaultBlockState(), BlockBehaviour.Properties.copy(baseBlock.get())));
        DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
        return block;
    }

    private static RegistryObject<ButtonBlock> createButtonBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, boolean isSensitive, DECreativeTabs itemGroup){
        RegistryObject<ButtonBlock> block = BLOCK.register(id, () -> new ButtonBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound), 20, isSensitive, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON));
        DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
        return block;
    }
    
    private static RegistryObject<PressurePlateBlock> createPressurePlateBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, PressurePlateBlock.Sensitivity sensitivity, DECreativeTabs itemGroup){
        RegistryObject<PressurePlateBlock> block = BLOCK.register(id, () -> new PressurePlateBlock(sensitivity, BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
        DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
        return block;
    }

    private static RegistryObject<DoorBlock> createDoorBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, DECreativeTabs itemGroup){
        RegistryObject<DoorBlock> block = BLOCK.register(id, () -> new DoorBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
        DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
        return block;
    }

    private static RegistryObject<TrapDoorBlock> createTrapDoorBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, DECreativeTabs itemGroup){
        RegistryObject<TrapDoorBlock> block = BLOCK.register(id, () -> new TrapDoorBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).noOcclusion(), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
        DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
        return block;
    }

    private static RegistryObject<SaplingBlock> createSaplingBlock(@Nonnull String id, AbstractTreeGrower grower, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, DECreativeTabs itemGroup){
        RegistryObject<SaplingBlock> block = BLOCK.register(id, () -> new SaplingBlock(grower, BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).destroyTime(harvestLevel).sound(sound).noOcclusion().noCollission()));
        DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
        return block;
    }

    private static RegistryObject<FlowerBlock> createFlowerBlock(@Nonnull String id, MobEffect effect, int duration, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, DECreativeTabs itemGroup){
        RegistryObject<FlowerBlock> block = BLOCK.register(id, () -> new FlowerBlock(() -> effect, duration, BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).noOcclusion().instabreak().dynamicShape().noCollission()));
        DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
        return block;
    }

    private static RegistryObject<FlowerPotBlock> createFlowerPotBlock(String id, Supplier<Block> flowerBlock){
        RegistryObject<FlowerPotBlock> block = BLOCK.register(id, () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, flowerBlock, BlockBehaviour.Properties.copy(Blocks.POTTED_ACACIA_SAPLING)));
        return block;
    }
    
    private static RegistryObject<TallGrassBlock> createGrassBlock(String id, Material material, MaterialColor color, SoundType sound, DECreativeTabs itemGroup){
    	RegistryObject<TallGrassBlock> block = BLOCK.register(id, () -> new TallGrassBlock(BlockBehaviour.Properties.of(material, color).sound(sound).instabreak().lightLevel(s -> 5).noCollission().offsetType(BlockBehaviour.OffsetType.XYZ).noOcclusion()));
    	DEItems.createItem(id, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()), itemGroup);
    	return block;
    }

    private static <T extends Block> RegistryObject<T> createCustomBlock(@Nonnull String id, Supplier<T> block, DECreativeTabs itemGroup){
        RegistryObject<T> cBlock = BLOCK.register(id, block);
        DEItems.createItem(id, () -> new BlockItem(cBlock.get(), new Item.Properties().fireResistant()), itemGroup);
        return cBlock;
    }

    private static <T extends Block> RegistryObject<Block> createCustomBlock(@Nonnull String id, Supplier<T> block){
        RegistryObject<Block> cBlock = BLOCK.register(id, block);
        return cBlock;
    }
}
