package net.killarexe.dimensional_expansion.core.init;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;

public class DEFeatures {

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> END_TREE =
            FeatureUtils.register("end_tree", Feature.TREE, (
                    new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(DEBlocks.END_LOG.get()),
                            new StraightTrunkPlacer(5, 6, 3),
                            BlockStateProvider.simple(DEBlocks.END_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));

    private static final Holder<PlacedFeature> END_TREE_CHECKED =
            PlacementUtils.register("end_tree_checked", END_TREE, new PlacementModifier[]{PlacementUtils.filteredByBlockSurvival(DEBlocks.END_SAPLING.get())});

    private static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> END_ROSE =
            FeatureUtils.register("end_rose",
                    Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, null));

    public static final Holder<PlacedFeature> END_ROSE_PLACED = PlacementUtils.register("end_rose_placed",
            END_ROSE, RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static final Holder<PlacedFeature> END_TREE_PLACED =
            PlacementUtils.register("end_tree_placed", END_TREE,
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 2)));
}
