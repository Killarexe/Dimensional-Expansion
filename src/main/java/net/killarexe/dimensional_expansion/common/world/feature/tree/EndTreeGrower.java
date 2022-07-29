package net.killarexe.dimensional_expansion.common.world.feature.tree;

import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class EndTreeGrower extends AbstractTreeGrower {

    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_, boolean p_222911_) {
        return FeatureUtils.register("end_tree", Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(DEBlocks.END_LOG.get()),
                        new StraightTrunkPlacer(5, 6, 3),
                        BlockStateProvider.simple(DEBlocks.END_LEAVES.get()),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                        new TwoLayersFeatureSize(1, 0, 2)).build());
    }
}
