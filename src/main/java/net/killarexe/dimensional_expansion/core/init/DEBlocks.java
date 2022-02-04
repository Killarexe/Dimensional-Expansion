package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.block.*;
import net.killarexe.dimensional_expansion.core.world.feature.tree.EndTreeGrower;
import net.minecraft.sounds.SoundEvent;
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

public class DEBlocks {

    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, DEMod.MODID);

    public static final RegistryObject<Block> PALON_ORE = createOreBlock("palon_ore", Material.STONE, MaterialColor.COLOR_YELLOW, 4, 10, 4, SoundType.STONE, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> PALON_BLOCK = createBlock("palon_block", Material.METAL, MaterialColor.COLOR_BLACK,4, 10, 4, SoundType.NETHERITE_BLOCK, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BASSMITE_ORE = createOreBlock("bassmite_ore", Material.STONE, MaterialColor.COLOR_LIGHT_GRAY,5, 20, 5, SoundType.STONE, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BASSMITE_BLOCK = createBlock("bassmite_block", Material.METAL, MaterialColor.COLOR_BLUE,5, 20, 5, SoundType.AMETHYST, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> SIMIX_ORE = createOreBlock("simix_ore", Material.STONE, MaterialColor.COLOR_RED,6, 30, 6, SoundType.NETHERRACK, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> SIMIX_BLOCK = createBlock("simix_block", Material.METAL, MaterialColor.COLOR_RED,6, 30, 6, SoundType.NETHERITE_BLOCK, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> EMERTYST_ORE = createOreBlock("emertyst_ore", Material.STONE, MaterialColor.COLOR_GRAY,7, 40, 7, SoundType.STONE, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> EMERTYST_BLOCK = createBlock("emertyst_block", Material.METAL, MaterialColor.COLOR_MAGENTA,7, 40, 7, SoundType.AMETHYST, DEItemGroups.BUILDING_BLOCKS);

    public static final RegistryObject<Block> END_GRASS_BLOCK = createBlock("end_grass_block", Material.DIRT, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.GRASS, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_LOG = createPillarBlock("end_log", Material.WOOD, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_STRIPPED_LOG = createPillarBlock("end_stripped_log", Material.WOOD, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_PLANKS = createBlock("end_planks", Material.WOOD, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_SLAB = createSlabBlock("end_slab", Material.WOOD, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_FENCE = createFenceBlock("end_fence", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, DEItemGroups.DECORATION_BLOCKS);
    public static final RegistryObject<Block> END_FENCE_GATE = createFenceGateBlock("end_fence_gate", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, DEItemGroups.DECORATION_BLOCKS);
    public static final RegistryObject<Block> END_BUTTON = createButtonBlock( "end_button", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, false, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_PRESSURE_PLATE = createPressurePlateBlock("end_pressure_plate", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, PressurePlateBlock.Sensitivity.EVERYTHING, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_DOOR = createDoorBlock("end_door", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_TRAPDOOR = createTrapDoorBlock("end_trapdoor", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_LEAVES = createLeavesBlock("end_leaves", Material.LEAVES, MaterialColor.COLOR_BLACK,0, 50, 1, SoundType.GRASS, DEItemGroups.DECORATION_BLOCKS);
    public static final RegistryObject<Block> END_STAIRS = createStairBlock("end_stairs", END_PLANKS, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_BOOKSHELF = createCustomBlock("end_bookshelf", new EndBookself(), DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_SIGN = createCustomBlock("end_sign", new EndStandingSignBlock());
    public static final RegistryObject<Block> END_WALL_SIGN = createCustomBlock("end_wall_sign", new EndWallSignBlock());
    public static final RegistryObject<Block> END_ROSE = createFlowerBlock("end_rose", MobEffects.LEVITATION, 10, Material.PLANT, MaterialColor.COLOR_MAGENTA, 0, 10, 0, SoundType.FLOWERING_AZALEA, DEItemGroups.DECORATION_BLOCKS);
    public static final RegistryObject<Block> END_SAPLING = createSaplingBlock("end_sapling", new EndTreeGrower(), Material.LEAVES, MaterialColor.COLOR_BLACK,0, 50, 1, SoundType.GRASS, DEItemGroups.DECORATION_BLOCKS);

    public static final RegistryObject<Block> FORGE = createBlock("forge", Material.METAL, MaterialColor.COLOR_BLACK, 3, 50, 2, SoundType.ANVIL, DEItemGroups.DECORATION_BLOCKS);
    public static final RegistryObject<Block> ESSENCE_EXTRACTOR = createCustomBlock("essence_extractor", new EssenceExtractor(), DEItemGroups.DECORATION_BLOCKS);
    public static final RegistryObject<Block> MINERAL_STORAGE = createBlock("mineral_storage", Material.METAL, MaterialColor.COLOR_BLACK, 3, 50, 2, SoundType.ANVIL, DEItemGroups.DECORATION_BLOCKS);

    public static final RegistryObject<Block> XP_CROPS = createCustomBlock("xp_crops", new XPCrops());
    public static final RegistryObject<Block> HEALTH_CROPS = createCustomBlock("health_crops", new HealthCrops());

    private static RegistryObject<Block> createBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new Block(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createLeavesBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new LeavesBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).randomTicks().noOcclusion()));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createOreBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new OreBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
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
        RegistryObject<Block> block = BLOCK.register(id, () -> new StairBlock(baseBlock.get().defaultBlockState(), BlockBehaviour.Properties.copy(baseBlock.get())));
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
        RegistryObject<Block> block = BLOCK.register(id, () -> new SaplingBlock(grower, BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).noOcclusion()));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createFlowerBlock(@Nonnull String id, MobEffect effect, int duration, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new FlowerBlock(effect, duration, BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).noOcclusion().instabreak().dynamicShape()));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createCustomBlock(@Nonnull String id, Block block, CreativeModeTab itemGroup){
        RegistryObject<Block> cBlock = BLOCK.register(id, () -> block);
        DEItems.ITEMS.register(id, () -> new BlockItem(cBlock.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return cBlock;
    }

    private static RegistryObject<Block> createCustomBlock(@Nonnull String id, Block block){
        RegistryObject<Block> cBlock = BLOCK.register(id, () -> block);
        return cBlock;
    }

    private static RegistryObject<Block> copy(@Nonnull String id, @Nonnull RegistryObject<Block> target){
        RegistryObject<Block> block = BLOCK.register(id, () -> new Block(BlockBehaviour.Properties.copy(target.get())));
        DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(target.get().asItem().getItemCategory()).fireResistant()));
        return block;
    }
}
