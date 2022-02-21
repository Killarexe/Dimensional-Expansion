package net.killarexe.dimensional_expansion.core.init;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class DEFeatures {

    public static final ConfiguredFeature<TreeConfiguration, ?> END_TREE =
            FeatureUtils.register("end_blossom", Feature.TREE.configured(
                    new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(DEBlocks.END_LOG.get()),
                            new StraightTrunkPlacer(5, 6, 3),
                            BlockStateProvider.simple(DEBlocks.END_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));

    private static final ConfiguredFeature<RandomFeatureConfiguration, ?> END_TREE_CHECKED =
            FeatureUtils.register("end_blossom_feature",
                    Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            END_TREE.filteredByBlockSurvival(DEBlocks.END_SAPLING.get()), 0.1f)),
                            END_TREE.filteredByBlockSurvival(DEBlocks.END_SAPLING.get()))));

    private static final ConfiguredFeature<RandomPatchConfiguration, ?> END_ROSE =
            FeatureUtils.register("end_rose",
                    Feature.FLOWER.configured(new RandomPatchConfiguration(32, 6, 2, () -> {
                        return Feature.SIMPLE_BLOCK.configured(
                                        new SimpleBlockConfiguration(BlockStateProvider.simple(DEBlocks.END_ROSE.get())))
                                .onlyWhenEmpty();})));

    public static final PlacedFeature END_ROSE_PLACED = PlacementUtils.register("end_rose_placed",
            END_ROSE.placed(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    public static final PlacedFeature END_TREE_PLACED =
            PlacementUtils.register("end_blossom_placed",
                    END_TREE_CHECKED.placed(VegetationPlacements.treePlacement(
                            PlacementUtils.countExtra(1, 0.1f, 2))));
}
