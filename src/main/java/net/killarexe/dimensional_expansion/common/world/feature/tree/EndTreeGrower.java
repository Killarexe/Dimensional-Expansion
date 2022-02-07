package net.killarexe.dimensional_expansion.common.world.feature.tree;

import net.killarexe.dimensional_expansion.core.init.DEFeatures;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class EndTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ConfiguredFeature<?, ?> getConfiguredFeature(Random pRandom, boolean pLargeHive) {
        return DEFeatures.END_TREE;
    }
}
