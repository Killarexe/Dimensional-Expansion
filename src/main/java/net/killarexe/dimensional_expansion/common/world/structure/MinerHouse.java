package net.killarexe.dimensional_expansion.common.world.structure;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.List;
import java.util.Set;

public class MinerHouse extends Feature<NoneFeatureConfiguration> {

    public static Feature FEATURE = new MinerHouse();
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CONFIGURED_FEATURE;
    public static Holder<PlacedFeature> PLACED_FEATURE;
    public static final Set<ResourceLocation> GENERATE_BIOMES = Set.of(Biomes.END_BARRENS.location());
    private final Set<ResourceKey<Level>> GENERATE_DIMENSIONS = Set.of(Level.END);
    private final List<Block> BASE_BLOCKS;
    private StructureTemplate structureTemplate;

    public MinerHouse() {
        super(NoneFeatureConfiguration.CODEC);
        CONFIGURED_FEATURE = FeatureUtils.register(DEMod.MODID + ":miner_house", FEATURE, FeatureConfiguration.NONE);
        PLACED_FEATURE = PlacementUtils.register(DEMod.MODID + ":miner_house_placed", CONFIGURED_FEATURE, List.of());
        BASE_BLOCKS = List.of(Blocks.END_STONE, DEBlocks.END_GRASS_BLOCK.get());
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        if (!GENERATE_DIMENSIONS.contains(context.level().getLevel().dimension()))
            return false;

        if(!GENERATE_BIOMES.contains(context.level().getLevel().getBiome(context.origin()))){
            return false;
        }

        if (structureTemplate == null)
            structureTemplate = context.level().getLevel().getStructureManager()
                    .getOrCreate(new ResourceLocation(DEMod.MODID, "miner_house"));

        if (structureTemplate == null)
            return false;

        boolean anyPlaced = false;
        if ((context.random().nextInt(1000000) + 1) <= 100000) {
            int i = context.origin().getX() + context.random().nextInt(16);
            int k = context.origin().getZ() + context.random().nextInt(16);
            int j = context.level().getHeight(Heightmap.Types.WORLD_SURFACE_WG, i, k);
            if (BASE_BLOCKS.contains(context.level().getBlockState(new BlockPos(i, j, k)).getBlock()))
                return false;
            BlockPos spawnTo = new BlockPos(i, j, k);
            StructurePlaceSettings settings = new StructurePlaceSettings()
                    .setMirror(Mirror.values()[context.random().nextInt(2)])
                    .setRotation(Rotation.values()[context.random().nextInt(3)])
                    .setRandom(context.random())
                    .addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR)
                    .setIgnoreEntities(false);
            if (structureTemplate.placeInWorld(context.level(), spawnTo, spawnTo, settings, context.random(), 2))
                anyPlaced = true;
        }

        return anyPlaced;
    }
}
