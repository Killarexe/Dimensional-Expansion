package net.killarexe.dimensional_expansion.core.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.block.*;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;
import net.minecraft.util.registry.Registry;

public class DEBlocks {

    public static final Block PALON_ORE = createOreBlock("palon_ore", Material.STONE, MapColor.GRAY, 4, 10, BlockSoundGroup.STONE, DEItemGroups.BUILDING_BLOCKS);
    public static final Block PALON_BLOCK = createBlock("palon_block", Material.METAL, MapColor.BLACK,4, 10, BlockSoundGroup.NETHERITE, DEItemGroups.BUILDING_BLOCKS);
    public static final Block BASSMITE_ORE = createOreBlock("bassmite_ore", Material.STONE, MapColor.BLACK,5, 20, BlockSoundGroup.STONE, DEItemGroups.BUILDING_BLOCKS);
    public static final Block BASSMITE_BLOCK = createBlock("bassmite_block", Material.METAL, MapColor.BLACK,5, 20, BlockSoundGroup.AMETHYST_BLOCK, DEItemGroups.BUILDING_BLOCKS);
    public static final Block SIMIX_ORE = createOreBlock("simix_ore", Material.STONE, MapColor.BLACK,6, 30, BlockSoundGroup.NETHERRACK, DEItemGroups.BUILDING_BLOCKS);
    public static final Block SIMIX_BLOCK = createBlock("simix_block", Material.METAL, MapColor.BLACK,6, 30, BlockSoundGroup.NETHERITE, DEItemGroups.BUILDING_BLOCKS);
    public static final Block EMERTYST_ORE = createOreBlock("emertyst_ore", Material.STONE, MapColor.BLACK,7, 40, BlockSoundGroup.STONE, DEItemGroups.BUILDING_BLOCKS);
    public static final Block EMERTYST_BLOCK = createBlock("emertyst_block", Material.METAL, MapColor.BLACK,7, 40, BlockSoundGroup.AMETHYST_BLOCK, DEItemGroups.BUILDING_BLOCKS);

    public static final Block END_GRASS_BLOCK = createBlock("end_grass_block", Material.AGGREGATE, MapColor.BLACK,1, 10,  BlockSoundGroup.GRASS, DEItemGroups.BUILDING_BLOCKS);
    public static final Block END_LOG = createPillarBlock("end_log", Material.WOOD, MapColor.BLACK,1, 10, BlockSoundGroup.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final Block END_STRIPPED_LOG = copy("end_stripped_log", END_LOG);
    public static final Block END_PLANKS = createBlock("end_planks", Material.WOOD, MapColor.BLACK,1, 10, BlockSoundGroup.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final Block END_SLAB = createSlabBlock("end_slab", Material.WOOD, MapColor.BLACK,1, 10, BlockSoundGroup.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final Block END_FENCE = createFenceBlock("end_fence", Material.WOOD, MapColor.BLACK,5, 10, BlockSoundGroup.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final Block END_FENCE_GATE = createFenceGateBlock("end_fence_gate", Material.WOOD, MapColor.BLACK,5, 10, BlockSoundGroup.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final Block END_BUTTON = createButtonBlock( "end_button", Material.WOOD, MapColor.BLACK,5, 10,  BlockSoundGroup.WOOD, false, DEItemGroups.BUILDING_BLOCKS);
    public static final Block END_PRESSURE_PLATE = createPressurePlateBlock("end_pressure_plate", Material.WOOD, MapColor.BLACK,5, 10, BlockSoundGroup.WOOD, PressurePlateBlock.ActivationRule.EVERYTHING, DEItemGroups.BUILDING_BLOCKS);
    public static final Block END_DOOR = createDoorBlock("end_door", Material.WOOD, MapColor.BLACK,5, 10, BlockSoundGroup.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final Block END_TRAPDOOR = createTrapDoorBlock("end_trapdoor", Material.WOOD, MapColor.BLACK,5, 10, BlockSoundGroup.WOOD, DEItemGroups.BUILDING_BLOCKS);
    public static final Block END_LEAVES = createLeavesBlock("end_leaves", Material.LEAVES, MapColor.BLACK,0, 50, BlockSoundGroup.GRASS, DEItemGroups.DECORATION_BLOCKS);
    public static final Block END_STAIRS = createStairBlock("end_stairs", END_PLANKS, DEItemGroups.BUILDING_BLOCKS);
    public static final Block END_BOOKSHELF = createCustomBlock("end_bookshelf", new EndBookshelf(), DEItemGroups.BUILDING_BLOCKS);
    public static final Block END_SIGN = createCustomBlock("end_sign", new EndStandingSignBlock());
    public static final Block END_WALL_SIGN = createCustomBlock("end_wall_sign", new EndWallSignBlock());
    public static final Block END_ROSE = createFlowerBlock("end_rose", StatusEffects.LEVITATION, 10, Material.PLANT, MapColor.MAGENTA, 0, 10,  BlockSoundGroup.FLOWERING_AZALEA, DEItemGroups.DECORATION_BLOCKS);

    public static final Block XP_CROPS = createCustomBlock("xp_crops", new XPCrops());
    public static final Block HEALTH_CROPS = createCustomBlock("health_crops", new HealthCrops());

    public static final Block FORGE = createBlock("forge", Material.METAL, MapColor.BLACK, 3, 50,  BlockSoundGroup.ANVIL, DEItemGroups.DECORATION_BLOCKS);
    public static final Block MINERAL_STORAGE = createBlock("mineral_storage", Material.METAL, MapColor.BLACK, 3, 50,  BlockSoundGroup.ANVIL, DEItemGroups.DECORATION_BLOCKS);
    public static final Block ESSENCE_EXTRACTOR = createCustomBlock("essence_extractor", new EssenceExtractor());

    //TODO: Find a way to create a SignType
    //public static final SignType END = null;

    public static void registerBlocks(){
        DEMod.LOGGER.info("Register Dimensional Expansion Blocks!");
    }
    
    private static Block createBlock(String id, Material material, MapColor color, float hardness, float resistance, BlockSoundGroup sound, ItemGroup itemGroup){
        Block block = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), new Block(FabricBlockSettings.of(material, color).strength(hardness, resistance).requiresTool().sounds(sound)));
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(itemGroup).fireproof()));
        return block;
    }

    private static Block createLeavesBlock(String id, Material material, MapColor color, float hardness, float resistance, BlockSoundGroup sound, ItemGroup itemGroup){
        Block block = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), new LeavesBlock(FabricBlockSettings.of(material, color).strength(hardness, resistance).requiresTool().sounds(sound).ticksRandomly().nonOpaque()));
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(itemGroup).fireproof()));
        return block;
    }

    private static Block createOreBlock(String id, Material material, MapColor color, float hardness, float resistance, BlockSoundGroup sound, ItemGroup itemGroup){
        Block block = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), new OreBlock(FabricBlockSettings.of(material, color).strength(hardness, resistance).requiresTool().sounds(sound)));
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(itemGroup).fireproof()));
        return block;
    }

    private static Block createPillarBlock( String id, Material material, MapColor color, float hardness, float resistance, BlockSoundGroup sound, ItemGroup itemGroup){
        Block block = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), new PillarBlock(FabricBlockSettings.of(material, color).strength(hardness, resistance).requiresTool().sounds(sound)));
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(itemGroup).fireproof()));
        return block;
    }

    private static Block createFenceBlock(String id, Material material, MapColor color, float hardness, float resistance, BlockSoundGroup sound, ItemGroup itemGroup){
        Block block = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), new FenceBlock(FabricBlockSettings.of(material, color).strength(hardness, resistance).requiresTool().sounds(sound)));
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(itemGroup).fireproof()));
        return block;
    }

    private static Block createFenceGateBlock(String id, Material material, MapColor color, float hardness, float resistance, BlockSoundGroup sound, ItemGroup itemGroup){
        Block block = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), new FenceGateBlock(FabricBlockSettings.of(material, color).strength(hardness, resistance).requiresTool().sounds(sound)));
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(itemGroup).fireproof()));
        return block;
    }

    private static Block createSlabBlock(String id, Material material, MapColor color, float hardness, float resistance, BlockSoundGroup sound, ItemGroup itemGroup){
        Block block = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), new SlabBlock(FabricBlockSettings.of(material, color).strength(hardness, resistance).requiresTool().sounds(sound)));
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(itemGroup).fireproof()));
        return block;
    }

    private static Block createFallingBlock(String id, Material material, MapColor color, float hardness, float resistance, BlockSoundGroup sound, ItemGroup itemGroup){
        Block block = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), new FallingBlock(FabricBlockSettings.of(material, color).strength(hardness, resistance).requiresTool().sounds(sound)));
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(itemGroup).fireproof()));
        return block;
    }

    private static Block createStairBlock(String id, Block baseBlock, ItemGroup itemGroup){
        Block block = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), new DEStairsBlock(baseBlock.getDefaultState(), FabricBlockSettings.copy(baseBlock)));
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(itemGroup).fireproof()));
        return block;
    }

    private static Block createButtonBlock(String id, Material material, MapColor color, float hardness, float resistance, BlockSoundGroup sound, boolean isSensitive, ItemGroup itemGroup){
        Block block = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), new AbstractButtonBlock(isSensitive, FabricBlockSettings.of(material, color).strength(hardness, resistance).requiresTool().sounds(sound)) {
            @Override
            protected SoundEvent getClickSound(boolean powered) {
                return sound.getPlaceSound();
            }
        });
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(itemGroup).fireproof()));
        return block;
    }

    private static Block createPressurePlateBlock(String id, Material material, MapColor color, float hardness, float resistance, BlockSoundGroup sound, PressurePlateBlock.ActivationRule sensitivity, ItemGroup itemGroup){
        Block block = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), new DEPressurePlateBlock(sensitivity, FabricBlockSettings.of(material, color).strength(hardness, resistance).requiresTool().sounds(sound)));
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(itemGroup).fireproof()));
        return block;
    }

    private static Block createDoorBlock(String id, Material material, MapColor color, float hardness, float resistance, BlockSoundGroup sound, ItemGroup itemGroup){
        Block block = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), new DEDoorBlock(FabricBlockSettings.of(material, color).strength(hardness, resistance).requiresTool().sounds(sound).nonOpaque()));
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(itemGroup).fireproof()));
        return block;
    }

    private static Block createTrapDoorBlock(String id, Material material, MapColor color, float hardness, float resistance, BlockSoundGroup sound, ItemGroup itemGroup){
        Block block = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), new DETrapdoorBlock(FabricBlockSettings.of(material, color).strength(hardness, resistance).requiresTool().sounds(sound).nonOpaque()));
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(itemGroup).fireproof()));
        return block;
    }

    private static Block createFlowerBlock(String id, StatusEffect effect, int duration, Material material, MapColor color, float hardness, float resistance, BlockSoundGroup sound, ItemGroup itemGroup){
        Block block = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), new FlowerBlock(effect, duration, FabricBlockSettings.of(material, color).strength(hardness, resistance).requiresTool().sounds(sound).nonOpaque().breakInstantly().dynamicBounds()));
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(itemGroup).fireproof()));
        return block;
    }

    private static Block createCustomBlock(String id, Block block, ItemGroup itemGroup){
        Block cBlock = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), block);
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(cBlock, new FabricItemSettings().group(itemGroup).fireproof()));
        return cBlock;
    }

    private static Block createCustomBlock(String id, Block block){
        Block cBlock = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), block);
        return cBlock;
    }

    private static Block copy(String id,  Block target){
        Block block = Registry.register(Registry.BLOCK, new Identifier(DEMod.MODID, id), new Block(FabricBlockSettings.copy(target)));
        Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(target.asItem().getGroup()).fireproof()));
        return block;
    }
}
