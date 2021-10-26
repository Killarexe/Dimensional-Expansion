package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DimensionalExpansionMod;
import net.killarexe.dimensional_expansion.common.block.CustomSaplingBlock;
import net.killarexe.dimensional_expansion.world.TreeSpawner;
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
    public static final RegistryObject<Block> EMERTYST_ORE = createOreBlock("emertyst_ore", Material.STONE, 4, 10, 4, SoundType.STONE, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> EMERTYST_BLOCK = createBlock("emertyst_block", Material.METAL, 4, 10, 4, SoundType.AMETHYST, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> SIMIX_ORE = createOreBlock("simix_ore", Material.STONE, 4, 10, 4, SoundType.NETHERRACK, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> SIMIX_BLOCK = createBlock("simix_block", Material.METAL, 4, 10, 4, SoundType.NETHERITE_BLOCK, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BASSMITE_ORE = createOreBlock("bassmite_ore", Material.STONE, 4, 10, 4, SoundType.STONE, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BASSMITE_BLOCK = createBlock("bassmite_block", Material.METAL, 4, 10, 4, SoundType.AMETHYST, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_GRASS_BLOCK = createBlock("end_grass_block", Material.DIRT, 1, 10, 0, SoundType.GRASS, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_LOG = createPillarBlock("end_log", Material.WOOD, 5, 10, 0, SoundType.WOOD, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_STRIPPED_LOG = copy("end_stripped_log", END_LOG);
    public static final RegistryObject<Block> END_PLANKS = createBlock("end_planks", Material.WOOD, 5, 10, 0, SoundType.WOOD, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_LEAVES = createLeavesBlock("end_leaves", Material.LEAVES, 0, 50, 0, SoundType.GRASS, DimensionalExpansionItemGroups.BUILDING_BLOCKS);
    public static final RegistryObject<Block> END_SAPLING = createSaplingBlock("end_sapling", Material.LEAVES, 0, 50, 0, SoundType.GRASS, DimensionalExpansionItemGroups.BUILDING_BLOCKS, DimensionalExansionTrees.END);

    private static RegistryObject<Block> createBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new Block(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup)));
        return block;
    }

    private static RegistryObject<Block> createLeavesBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new LeavesBlock(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).randomTicks().noOcclusion()));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup)));
        return block;
    }

    private static RegistryObject<Block> createSaplingBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup, TreeSpawner spawner){
        RegistryObject<Block> block = BLOCK.register(id, () -> new CustomSaplingBlock(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound).randomTicks().noOcclusion(), spawner));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup)));
        return block;
    }

    private static RegistryObject<Block> createOreBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new OreBlock(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup)));
        return block;
    }

    private static RegistryObject<Block> createPillarBlock(String id, Material material, float hardness, float resistance, float harvestLevel, SoundType sound, CreativeModeTab itemGroup){
        RegistryObject<Block> block = BLOCK.register(id, () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(material).strength(hardness, resistance).requiresCorrectToolForDrops().destroyTime(harvestLevel).sound(sound)));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup)));
        return block;
    }

    private static RegistryObject<Block> copy(String id, RegistryObject<Block> target){
        RegistryObject<Block> block = BLOCK.register(id, () -> new Block(BlockBehaviour.Properties.copy(target.get())));
        RegistryObject<Item> itemBlock = DimensionalExpansionItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(target.get().asItem().getItemCategory())));
        return block;
    }
}
