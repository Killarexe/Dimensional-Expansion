package net.killarexe.dimensional_expansion.common.world.feature.tree;

import net.killarexe.dimensional_expansion.core.init.DEFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Random;

public class EndTreeGrower extends AbstractTreeGrower {
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random pRandom, boolean pLargeHive) {
        return DEFeatures.Raw.END_TREE;
    }
}
