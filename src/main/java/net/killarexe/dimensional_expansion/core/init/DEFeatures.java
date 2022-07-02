package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class DEFeatures {

    public static class Placed{

        public static final Holder<PlacedFeature> END_TREE = registerPlacedFeature(
                "end_tree_feature", Configured.END_TREE,
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 2))
        );

        public static final Holder<PlacedFeature> END_ROSE = registerPlacedFeature(
                "end_rose_feature", Configured.END_ROSE,
                RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()
        );

        public static final Holder<PlacedFeature> PALON_ORE_FEATURE = registerPlacedFeature(
                "palon_ore_feature", Configured.PALON_ORE,
                rareOrePlacement(4, HeightRangePlacement.uniform(
                                VerticalAnchor.aboveBottom(54),
                                VerticalAnchor.aboveBottom(75)
                        )
                )
        );

        public static final Holder<PlacedFeature> BASSMITE_ORE_FEATURE = registerPlacedFeature(
                "bassmite_ore_feature", Configured.BASSMITE_ORE,
                rareOrePlacement(4, HeightRangePlacement.uniform(
                                VerticalAnchor.aboveBottom(54),
                                VerticalAnchor.aboveBottom(75)
                        )
                )
        );

        public static final Holder<PlacedFeature> SIMIX_ORE_FEATURE = registerPlacedFeature(
                "simix_ore_feature", Configured.SIMIX_ORE, rareOrePlacement(4, HeightRangePlacement.uniform(
                                VerticalAnchor.aboveBottom(54),
                                VerticalAnchor.aboveBottom(75)
                        )
                )
        );

        public static final Holder<PlacedFeature> EMERTYST_ORE_FEATURE = registerPlacedFeature(
                "emertyst_ore_feature", Configured.EMERTYST_ORE, rareOrePlacement(4, HeightRangePlacement.uniform(
                                VerticalAnchor.aboveBottom(54),
                                VerticalAnchor.aboveBottom(75)
                        )
                )
        );

        public static <FC extends FeatureConfiguration> Holder<PlacedFeature> registerPlacedFeature(String id, Holder<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
            return registerPlacedFeature(id, feature, List.of(placementModifiers));
        }

        public static <FC extends FeatureConfiguration> Holder<PlacedFeature> registerPlacedFeature(String id, Holder<ConfiguredFeature<FC, ?>> feature, List<PlacementModifier> placementModifiers) {
            ResourceLocation resourceLocation = new ResourceLocation(DEMod.MOD_ID, id);
            if (BuiltinRegistries.PLACED_FEATURE.keySet().contains(resourceLocation)) {
                throw new IllegalStateException("Failed to register: '" + resourceLocation + "'\n Reason: This placed feature already exists!");
            }
            PlacedFeature placedFeature = new PlacedFeature(Holder.hackyErase(feature), List.copyOf(placementModifiers));
            return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, resourceLocation, placedFeature);
        }

        public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
            return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
        }

        /*public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
            return orePlacement(CountPlacement.of(p_195344_), p_195345_);
        }*/

        public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
            return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
        }
    }

    public static class Configured {

        //RULE TESTS
        private static final RuleTest NATURAL_STONE_BLOCKS = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        private static final RuleTest NATURAL_NETHERRACK = new BlockMatchTest(Blocks.NETHERRACK);
        private static final RuleTest NATURAL_END_STONE = new BlockMatchTest(Blocks.END_STONE);
        private static final RuleTest NATURAL_DEEPSLATE = new BlockMatchTest(Blocks.DEEPSLATE);

        public static final Holder<ConfiguredFeature<OreConfiguration, ?>> PALON_ORE = registerConfiguredFeature(
                "palon_ore",
                Feature.ORE,
                new OreConfiguration(
                        List.of(OreConfiguration.target(NATURAL_END_STONE, DEBlocks.PALON_ORE.get().defaultBlockState())),
                        4
                )
        );

        public static final Holder<ConfiguredFeature<OreConfiguration, ?>> BASSMITE_ORE = registerConfiguredFeature(
                "bassmite_ore",
                Feature.ORE,
                new OreConfiguration(
                        List.of(OreConfiguration.target(NATURAL_STONE_BLOCKS, DEBlocks.BASSMITE_ORE.get().defaultBlockState())),
                        4
                )
        );

        public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SIMIX_ORE = registerConfiguredFeature(
                "simix_ore",
                Feature.ORE,
                new OreConfiguration(
                        List.of(OreConfiguration.target(NATURAL_NETHERRACK, DEBlocks.SIMIX_ORE.get().defaultBlockState())),
                        4
                )
        );

        public static final Holder<ConfiguredFeature<OreConfiguration, ?>> EMERTYST_ORE = registerConfiguredFeature(
                "emertyst_ore",
                Feature.ORE,
                new OreConfiguration(
                        List.of(OreConfiguration.target(NATURAL_DEEPSLATE, DEBlocks.EMERTYST_ORE.get().defaultBlockState())),
                        8
                )
        );

        public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> END_TREE =
                FeatureUtils.register("end_tree", Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(
                                BlockStateProvider.simple(DEBlocks.END_LOG.get()),
                                new StraightTrunkPlacer(5, 6, 3),
                                BlockStateProvider.simple(DEBlocks.END_LEAVES.get()),
                                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                                new TwoLayersFeatureSize(1, 0, 2)).build());

        public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> END_ROSE =
                FeatureUtils.register("end_rose", Feature.FLOWER,
                        new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(BlockStateProvider.simple(DEBlocks.END_ROSE.get()))))
                );

        public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> registerConfiguredFeature(String id, F feature, FC featureConfiguration) {
            ResourceLocation resourceLocation = new ResourceLocation(DEMod.MOD_ID, id);

            if (BuiltinRegistries.CONFIGURED_FEATURE.keySet().contains(resourceLocation)) {
                throw new IllegalStateException("Failed to register: '" + resourceLocation + "'\n Reason: This configured feature already exists!");
            }

            return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_FEATURE, resourceLocation.toString(), new ConfiguredFeature<>(feature, featureConfiguration));
        }
    }
}
