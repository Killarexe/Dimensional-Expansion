package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.block.*;
import net.killarexe.dimensional_expansion.common.world.feature.tree.PurpleheartTreeGrower;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
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

    public static final RegistryObject<Block> PALON_ORE = createOreBlock("palon_ore", Material.STONE, MaterialColor.COLOR_YELLOW, 4, 10, 4, UniformInt.of(0, 0), SoundType.STONE, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> PALON_BLOCK = createBlock("palon_block", Material.METAL, MaterialColor.COLOR_BLACK, 4, 10, 4, SoundType.NETHERITE_BLOCK, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> BASSMITE_ORE = createOreBlock("bassmite_ore", Material.STONE, MaterialColor.COLOR_LIGHT_GRAY, 5, 20, 5, UniformInt.of(2, 6), SoundType.STONE, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> BASSMITE_BLOCK = createBlock("bassmite_block", Material.METAL, MaterialColor.COLOR_BLUE,5, 20, 5, SoundType.AMETHYST, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> SIMIX_ORE = createOreBlock("simix_ore", Material.STONE, MaterialColor.COLOR_RED, 6, 30, 6, UniformInt.of(0, 0), SoundType.NETHERRACK, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> SIMIX_BLOCK = createBlock("simix_block", Material.METAL, MaterialColor.COLOR_RED, 6, 30, 6, SoundType.NETHERITE_BLOCK, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> EMERTYST_ORE = createOreBlock("emertyst_ore", Material.STONE, MaterialColor.COLOR_GRAY, 7, 40, 7, UniformInt.of(4, 10), SoundType.STONE, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> EMERTYST_BLOCK = createBlock("emertyst_block", Material.METAL, MaterialColor.COLOR_MAGENTA, 7, 40, 7, SoundType.AMETHYST, DEItemGroups.BLOCKS);

    public static final RegistryObject<Block> ORIGIN_GRASS_BLOCK = createBlock("origin_grass_block", Material.DIRT, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.GRASS, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> ORIGIN_DIRT = createBlock("origin_dirt", Material.DIRT, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.GRASS, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> ORIGIN_GRASS = createGrassBlock("origin_grass", Material.GRASS, MaterialColor.COLOR_BLACK, SoundType.GRASS, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_LOG = createPillarBlock("purpleheart_log", Material.WOOD, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.WOOD, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> STRIPPED_PURPLEHEART_LOG = createPillarBlock("stripped_purpleheart_log", Material.WOOD, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.WOOD, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_PLANKS = createBlock("purpleheart_planks", Material.WOOD, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.WOOD, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_SLAB = createSlabBlock("purpleheart_slab", Material.WOOD, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.WOOD, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_FENCE = createFenceBlock("purpleheart_fence", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_FENCE_GATE = createFenceGateBlock("purpleheart_fence_gate", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_BUTTON = createButtonBlock( "purpleheart_button", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, false, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_PRESSURE_PLATE = createPressurePlateBlock("purpleheart_pressure_plate", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, PressurePlateBlock.Sensitivity.EVERYTHING, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_DOOR = createDoorBlock("purpleheart_door", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_TRAPDOOR = createTrapDoorBlock("purpleheart_trapdoor", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_LEAVES = createLeavesBlock("purpleheart_leaves", Material.LEAVES, MaterialColor.COLOR_BLACK,0, 50, 1, SoundType.GRASS, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_STAIRS = createStairBlock("purpleheart_stairs", PURPLEHEART_PLANKS, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_BOOKSHELF = createCustomBlock("purpleheart_bookshelf", () -> new PurpleheartBookself(), DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> PURPLEHEART_SIGN = createCustomBlock("purpleheart_sign", () -> new PurpleheartStandingSignBlock());
    public static final RegistryObject<Block> PURPLEHEART_WALL_SIGN = createCustomBlock("purpleheart_wall_sign", () -> new PurpleheartWallSignBlock());
    public static final RegistryObject<Block> PURPLE_ROSE = createFlowerBlock("purple_rose", MobEffects.LEVITATION, 10, Material.PLANT, MaterialColor.COLOR_MAGENTA, 0, 10, 0, SoundType.FLOWERING_AZALEA, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> POTTED_PURPLE_ROSE = createFlowerPotBlock("potted_purple_rose", () -> PURPLE_ROSE.get());
    public static final RegistryObject<Block> PURPLEHEART_SAPLING = createSaplingBlock("purpleheart_sapling", new PurpleheartTreeGrower(), Material.LEAVES, MaterialColor.COLOR_BLACK,0, 50, 1, SoundType.GRASS, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> POTTED_PURPLEHEART_SAPLING = createFlowerPotBlock("potted_purpleheart_sapling", () -> PURPLEHEART_SAPLING.get());
    public static final RegistryObject<Block> SULFUR_STONE = createBlock("sulfur_stone", Material.STONE, MaterialColor.COLOR_YELLOW, 4, 10, 4, SoundType.STONE, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> SULFUR_STONE_BUTTON = createButtonBlock( "sulfur_stone_button", Material.STONE, MaterialColor.COLOR_BLACK, 4, 10, 4, SoundType.STONE, false, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> SULFUR_STONE_PRESSURE_PLATE = createPressurePlateBlock("sulfur_stone_pressure_plate", Material.STONE, MaterialColor.COLOR_BLACK, 4, 10, 4, SoundType.STONE, PressurePlateBlock.Sensitivity.MOBS, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> SULFUR_STONE_SLAB = createSlabBlock("sulfur_stone_slab", Material.STONE, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.WOOD, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> SULFUR_STONE_STAIRS = createStairBlock("sulfur_stone_stairs", SULFUR_STONE, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> SULFUR_COBBLESTONE = createBlock("sulfur_cobblestone", Material.STONE, MaterialColor.COLOR_YELLOW, 4, 10, 4, SoundType.STONE, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> SULFUR_COBBLESTONE_SLAB = createSlabBlock("sulfur_cobblestone_slab", Material.STONE, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.WOOD, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> SULFUR_COBBLESTONE_STAIRS = createStairBlock("sulfur_cobblestone_stairs", SULFUR_COBBLESTONE, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> BLUE_SAND = createFallingBlock("blue_sand", Material.SAND, MaterialColor.COLOR_BLACK, 1, 10, 1, SoundType.SAND, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> BLUE_SANDSTONE = createBlock("blue_sandstone", Material.STONE, MaterialColor.COLOR_BLACK, 1, 10, 1, SoundType.STONE, DEItemGroups.BLOCKS);

    public static final RegistryObject<Block> ORIGIN_PORTAL = createCustomBlock("origin_portal", () -> new OriginPortalBlock());
    public static final RegistryObject<Block> ORIGIN_FRAME = createBlock("origin_frame", Material.METAL, MaterialColor.CLAY, 0, 0, 0, SoundType.METAL, DEItemGroups.BLOCKS);
    
    public static final RegistryObject<Block> FORGE = createBlock("forge", Material.METAL, MaterialColor.COLOR_BLACK, 3, 50, 2, SoundType.ANVIL, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> ESSENCE_EXTRACTOR = createCustomBlock("essence_extractor", () -> new EssenceExtractor(), DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> MINERAL_STORAGE = createBlock("mineral_storage", Material.METAL, MaterialColor.COLOR_BLACK, 3, 50, 2, SoundType.ANVIL, DEItemGroups.BLOCKS);
    public static final RegistryObject<Block> DISPLAY_BLOCK = createCustomBlock("display_block", () -> new DisplayBlock(), DEItemGroups.BLOCKS);

    private static RegistryObject<Block> createBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new Block(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createLeavesBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new LeavesBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).lightLevel(s -> 1).randomTicks().noOcclusion()));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createOreBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, UniformInt xpDrop, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new DropExperienceBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound), xpDrop));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createPillarBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createFenceBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new FenceBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createFenceGateBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new FenceGateBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createSlabBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new SlabBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createFallingBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new FallingBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createStairBlock(@Nonnull String id, RegistryObject<Block> baseBlock, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new StairBlock(() -> baseBlock.get().defaultBlockState(), BlockBehaviour.Properties.copy(baseBlock.get())));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createButtonBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, boolean isSensitive, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new ButtonBlock(isSensitive, BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)) {
            @Override
            protected SoundEvent getSound(boolean p_51102_) {
                return sound.getPlaceSound();
            }
        });
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createPressurePlateBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, PressurePlateBlock.Sensitivity sensitivity, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new PressurePlateBlock(sensitivity, BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createDoorBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new DoorBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).noOcclusion()));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createTrapDoorBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new TrapDoorBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).noOcclusion()));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createSaplingBlock(@Nonnull String id, AbstractTreeGrower grower, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new SaplingBlock(grower, BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).destroyTime(harvestLevel).sound(sound).noOcclusion().noCollission()));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createFlowerBlock(@Nonnull String id, MobEffect effect, int duration, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new FlowerBlock(effect, duration, BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).noOcclusion().instabreak().dynamicShape().noCollission()));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createFlowerPotBlock(String id, Supplier<Block> flowerBlock){
        RegistryObject<Block> block = BLOCK.register(id, () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, flowerBlock, BlockBehaviour.Properties.copy(Blocks.POTTED_ACACIA_SAPLING)));
        return block;
    }
    
    private static RegistryObject<Block> createGrassBlock(String id, Material material, MaterialColor color, SoundType sound, CreativeModeTab itemGroup){
    	RegistryObject<Block> block = BLOCK.register(id, () -> new TallGrassBlock(BlockBehaviour.Properties.of(material, color).sound(sound).instabreak().lightLevel(s -> 5).noCollission().offsetType(BlockBehaviour.OffsetType.XYZ).noOcclusion()));
    	DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup)));
    	return block;
    }

    private static <T extends Block> RegistryObject<Block> createCustomBlock(@Nonnull String id, Supplier<T> block, CreativeModeTab itemGroup){
        RegistryObject<Block> cBlock = BLOCK.register(id, block);
        DEItems.ITEMS.register(id, () -> new BlockItem(cBlock.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return cBlock;
    }

    private static <T extends Block> RegistryObject<Block> createCustomBlock(@Nonnull String id, Supplier<T> block){
        RegistryObject<Block> cBlock = BLOCK.register(id, block);
        return cBlock;
    }

    @SuppressWarnings("unused")
	private static RegistryObject<Block> copy(@Nonnull String id, @Nonnull RegistryObject<Block> target){
        RegistryObject<Block> block = BLOCK.register(id, () -> new Block(BlockBehaviour.Properties.copy(target.get())));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(target.get().asItem().getItemCategory()).fireResistant()));
        return block;
    }
}
