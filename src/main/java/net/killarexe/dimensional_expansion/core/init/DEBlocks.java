package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.block.WeatherChangerBlock;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

public class DEBlocks {

    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, DEMod.MODID);

    public static final RegistryObject<Block> PALON_ORE = createOreBlock("palon_ore", Material.STONE, MaterialColor.COLOR_GRAY, 4, 10, 4, SoundType.STONE, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> PALON_BLOCK = createBlock("palon_block", Material.METAL, MaterialColor.COLOR_BLACK,4, 10, 4, SoundType.NETHERITE_BLOCK, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BASSMITE_ORE = createOreBlock("bassmite_ore", Material.STONE, MaterialColor.COLOR_BLACK,5, 20, 5, SoundType.STONE, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BASSMITE_BLOCK = createBlock("bassmite_block", Material.METAL, MaterialColor.COLOR_BLACK,5, 20, 5, SoundType.AMETHYST, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> SIMIX_ORE = createOreBlock("simix_ore", Material.STONE, MaterialColor.COLOR_BLACK,6, 30, 6, SoundType.NETHERRACK, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> SIMIX_BLOCK = createBlock("simix_block", Material.METAL, MaterialColor.COLOR_BLACK,6, 30, 6, SoundType.NETHERITE_BLOCK, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> EMERTYST_ORE = createOreBlock("emertyst_ore", Material.STONE, MaterialColor.COLOR_BLACK,7, 40, 7, SoundType.STONE, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> EMERTYST_BLOCK = createBlock("emertyst_block", Material.METAL, MaterialColor.COLOR_BLACK,7, 40, 7, SoundType.AMETHYST, DEItemGroups.BUILDING_BLOCKS);

    public static final RegistryObject<Block> END_GRASS_BLOCK = createBlock("end_grass_block", Material.DIRT, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.GRASS, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_LOG = createPillarBlock("end_log", Material.WOOD, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_STRIPPED_LOG = copy("end_stripped_log", END_LOG);
    public static final RegistryObject<Block> END_PLANKS = createBlock("end_planks", Material.WOOD, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_SLAB = createSlabBlock("end_slab", Material.WOOD, MaterialColor.COLOR_BLACK,1, 10, 1, SoundType.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_FENCE = createFenceBlock("end_fence", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_FENCE_GATE = createFenceGateBlock("end_fence_gate", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_BUTTON = createButtonBlock( "end_button", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, false, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_PRESSURE_PLATE = createPressurePlateBlock("end_pressure_plate", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, PressurePlateBlock.Sensitivity.EVERYTHING, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_DOOR = createDoorBlock("end_door", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_TRAPDOOR = createTrapDoorBlock("end_trapdoor", Material.WOOD, MaterialColor.COLOR_BLACK,5, 10, 1, SoundType.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_LEAVES = createLeavesBlock("end_leaves", Material.LEAVES, MaterialColor.COLOR_BLACK,0, 50, 1, SoundType.GRASS, DEItemGroups.DECORATION_BLOCKS);
    public static final RegistryObject<Block> END_STAIRS = createStairBlock("end_stairs", END_PLANKS, DEItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_FORGE = createBlock("end_forge", Material.METAL, MaterialColor.COLOR_BLACK, 3, 50, 2, SoundType.ANVIL, DEItemGroups.DECORATION_BLOCKS);

    public static final RegistryObject<Block> WEATHER_CHANGER = createCustomBlock("weather_changer", new WeatherChangerBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).strength(6, 50).requiresCorrectToolForDrops().destroyTime(3).sound(SoundType.ANVIL)), DEItemGroups.DECORATION_BLOCKS);

    @Nonnull
    private static RegistryObject<Block> createBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new Block(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createLeavesBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new LeavesBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).randomTicks().noOcclusion()));
        RegistryObject<Item> itemBlock = DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createOreBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new OreBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createPillarBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createFenceBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new FenceBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createFenceGateBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new FenceGateBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createSlabBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new SlabBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createFallingBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new FallingBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createStairBlock(@Nonnull String id, RegistryObject<Block> baseBlock, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new StairBlock(baseBlock.get().defaultBlockState(), BlockBehaviour.Properties.copy(baseBlock.get())));
        RegistryObject<Item> itemBlock = DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createButtonBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, boolean isSensitive, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new ButtonBlock(isSensitive, BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)) {
            @Override
            protected SoundEvent getSound(boolean p_51102_) {
                return sound.getPlaceSound();
            }
        });
        RegistryObject<Item> itemBlock = DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createPressurePlateBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, PressurePlateBlock.Sensitivity sensitivity, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new PressurePlateBlock(sensitivity, BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createDoorBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new DoorBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).noOcclusion()));
        RegistryObject<Item> itemBlock = DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createTrapDoorBlock(@Nonnull String id, Material material, MaterialColor color, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new TrapDoorBlock(BlockBehaviour.Properties.of(material, color).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).noOcclusion()));
        RegistryObject<Item> itemBlock = DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createCustomBlock(@Nonnull String id, Block block, CreativeModeTab itemGroup){
        RegistryObject<Block> cBlock = BLOCK.register(id, () -> block);
        RegistryObject<Item> itemBlock = DEItems.ITEMS.register(id, () -> new BlockItem(cBlock.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return cBlock;
    }

    private static RegistryObject<Block> copy(@Nonnull String id, @Nonnull RegistryObject<Block> target){
        RegistryObject<Block> block = BLOCK.register(id, () -> new Block(BlockBehaviour.Properties.copy(target.get())));
        RegistryObject<Item> itemBlock = DEItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(target.get().asItem().getItemCategory()).fireResistant()));
        return block;
    }
}
