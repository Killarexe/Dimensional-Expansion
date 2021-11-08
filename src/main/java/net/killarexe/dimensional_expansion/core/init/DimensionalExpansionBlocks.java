package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DimensionalExpansionMod;
import net.killarexe.dimensional_expansion.common.block.CustomSaplingBlock;
import net.killarexe.dimensional_expansion.world.TreeSpawner;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionalExpansionBlocks {

    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, DimensionalExpansionMod.MODID);

    public static final RegistryObject<Block> PALON_ORE = createOreBlock("palon_ore", Material.STONE, 4, 10, 4, SoundType.STONE, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> PALON_BLOCK = createBlock("palon_block", Material.METAL, 4, 10, 4, SoundType.NETHERITE_BLOCK, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> EMERTYST_ORE = createOreBlock("emertyst_ore", Material.STONE, 4, 10, 7, SoundType.STONE, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> EMERTYST_BLOCK = createBlock("emertyst_block", Material.METAL, 4, 10, 7, SoundType.AMETHYST, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> SIMIX_ORE = createOreBlock("simix_ore", Material.STONE, 4, 10, 6, SoundType.NETHERRACK, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> SIMIX_BLOCK = createBlock("simix_block", Material.METAL, 4, 10, 6, SoundType.NETHERITE_BLOCK, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BASSMITE_ORE = createOreBlock("bassmite_ore", Material.STONE, 4, 10, 5, SoundType.STONE, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BASSMITE_BLOCK = createBlock("bassmite_block", Material.METAL, 4, 10, 5, SoundType.AMETHYST, DimensionalExpansionItemGroups.BUILDING_BLOCKS);

    public static final RegistryObject<Block> END_GRASS_BLOCK = createBlock("end_grass_block", Material.DIRT, 1, 10, 0, SoundType.GRASS, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_LOG = createPillarBlock("end_log", Material.WOOD, 5, 10, 0, SoundType.WOOD, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_STRIPPED_LOG = copy("end_stripped_log", END_LOG);
    public static final RegistryObject<Block> END_PLANKS = createBlock("end_planks", Material.WOOD, 5, 10, 1, SoundType.WOOD, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_SLAB = createSlabBlock("end_slab", Material.WOOD, 5, 10, 1, SoundType.WOOD, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_STAIRS = createStairBlock("end_stairs", Material.WOOD, END_PLANKS.get(), 5, 10, 1, SoundType.WOOD, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_FENCE = createFenceBlock("end_fence", Material.WOOD, 5, 10, 1, SoundType.WOOD, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_FENCE_GATE = createFenceGateBlock("end_fence_gate", Material.WOOD, 5, 10, 1, SoundType.WOOD, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_BUTTON = createButtonBlock( "end_button", Material.WOOD, 5, 10, 1, SoundType.WOOD, false, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_PRESSURE_PLATE = createPressurePlateBlock("end_pressure_plate", Material.WOOD, 5, 10, 1, SoundType.WOOD, PressurePlateBlock.Sensitivity.EVERYTHING, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_LEAVES = createLeavesBlock("end_leaves", Material.LEAVES, 0, 50, 1, SoundType.GRASS, DimensionalExpansionItemGroups.DECORATION_BLOCKS);
    public static final RegistryObject<Block> END_SAPLING = createSaplingBlock("end_sapling", Material.LEAVES, 0, 50, 1, SoundType.GRASS, DimensionalExpansionItemGroups.DECORATION_BLOCKS, DimensionalExansionTrees.END);

    private static RegistryObject<Block> createBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new Block(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createLeavesBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new LeavesBlock(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).randomTicks().noOcclusion()));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createSaplingBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup, TreeSpawner spawner){
        RegistryObject<Block> block = BLOCK.register(id, () -> new CustomSaplingBlock(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).randomTicks().noOcclusion(), spawner));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createOreBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new OreBlock(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createPillarBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createFenceBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new FenceBlock(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createFenceGateBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new FenceBlock(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createSlabBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new SlabBlock(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createFallingBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new FallingBlock(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createStairBlock(String id, Material material, Block baseBlock, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new StairBlock(baseBlock.defaultBlockState(), BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createButtonBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, boolean isSensitive, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new ButtonBlock(isSensitive, BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)) {
            @Override
            protected SoundEvent getSound(boolean p_51102_) {
                return sound.getPlaceSound();
            }
        });
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> createPressurePlateBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, PressurePlateBlock.Sensitivity sensitivity, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new PressurePlateBlock(sensitivity, BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).fireResistant()));
        return block;
    }

    private static RegistryObject<Block> copy(String id, RegistryObject<Block> target){
        RegistryObject<Block> block = BLOCK.register(id, () -> new Block(BlockBehaviour.Properties.copy(target.get())));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(target.get().asItem().getItemCategory()).fireResistant()));
        return block;
    }
}
