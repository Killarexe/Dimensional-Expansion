package net.killarexe.dimensional_expansion.core.init;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class DEFeatures {

    //RULE TESTS
    private static final RuleTest NATURAL_NETHERRACK = new BlockMatchTest(Blocks.NETHERRACK);
    private static final RuleTest NATURAL_STONE = new BlockMatchTest(Blocks.STONE);
    private static final RuleTest NATURAL_END_STONE = new BlockMatchTest(Blocks.END_STONE);
    private static final RuleTest NATURAL_DEEPSLATE = new BlockMatchTest(Blocks.DEEPSLATE);

    //END TREE

    public static final Holder<? extends ConfiguredFeature<TreeConfiguration, ?>> END_TREE =
            FeatureUtils.register("end_tree", Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(DEBlocks.END_LOG.get()),
                            new StraightTrunkPlacer(5, 6, 3),
                            BlockStateProvider.simple(DEBlocks.END_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).build());

    private static final Holder<PlacedFeature> END_TREE_CHECKED = PlacementUtils.register("end_tree_checked",
            END_TREE, PlacementUtils.filteredByBlockSurvival(DEBlocks.END_SAPLING.get()));

    private static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> END_TREE_SPAWN =
            FeatureUtils.register("end_tree_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(END_TREE_CHECKED,
                            0.5F)), END_TREE_CHECKED));

    public static final Holder<PlacedFeature> END_TREE_PLACED =
            PlacementUtils.register("end_tree_placed",
                    END_TREE_SPAWN, VegetationPlacements.treePlacement(
                            PlacementUtils.countExtra(1, 0.1f, 2)));

    //END ROSE

    private static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> END_ROSE =
            FeatureUtils.register("end_rose", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(DEBlocks.END_ROSE.get())))));

    public static final Holder<PlacedFeature> END_ROSE_PLACED = PlacementUtils.register("end_rose_placed",
            END_ROSE, RarityFilter.onAverageOnceEvery(16),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    // ORES

    public static final List<OreConfiguration.TargetBlockState> PALON_ORES = List.of(
            OreConfiguration.target(NATURAL_END_STONE, DEBlocks.PALON_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> PALON_ORE = FeatureUtils.register("palon_ore",
            Feature.ORE, new OreConfiguration(PALON_ORES, 1, 8));

    public static final Holder<PlacedFeature> PALON_ORE_PLACED = PlacementUtils.register("palon_ore_placed",
            PALON_ORE, rareOrePlacement(8, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(54), VerticalAnchor.aboveBottom(75))));

    public static final List<OreConfiguration.TargetBlockState> BASSMITE_ORES = List.of(
            OreConfiguration.target(NATURAL_STONE, DEBlocks.BASSMITE_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> BASSMITE_ORE = FeatureUtils.register("bassmite_ore",
            Feature.ORE, new OreConfiguration(BASSMITE_ORES, 1, 8));

    public static final Holder<PlacedFeature> BASSMITE_ORE_PLACED = PlacementUtils.register("bassmite_ore_placed",
            BASSMITE_ORE, rareOrePlacement(8, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(12))));

    public static final List<OreConfiguration.TargetBlockState> SIMIX_ORES = List.of(
            OreConfiguration.target(NATURAL_NETHERRACK, DEBlocks.SIMIX_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SIMIX_ORE = FeatureUtils.register("simix_ore",
            Feature.ORE, new OreConfiguration(SIMIX_ORES, 1, 8));

    public static final Holder<PlacedFeature> SIMIX_ORE_PLACED = PlacementUtils.register("simix_ore_placed",
            SIMIX_ORE, rareOrePlacement(8, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(14), VerticalAnchor.aboveBottom(1))));

    public static final List<OreConfiguration.TargetBlockState> EMERTYST_ORES = List.of(
            OreConfiguration.target(NATURAL_DEEPSLATE, DEBlocks.PALON_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> EMERTYST_ORE = FeatureUtils.register("emertyst_ore",
            Feature.ORE, new OreConfiguration(EMERTYST_ORES, 1, 8));

    public static final Holder<PlacedFeature> EMERTYST_ORE_PLACED = PlacementUtils.register("emertyst_ore_placed",
            EMERTYST_ORE, rareOrePlacement(8, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-16), VerticalAnchor.aboveBottom(0))));

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
}
