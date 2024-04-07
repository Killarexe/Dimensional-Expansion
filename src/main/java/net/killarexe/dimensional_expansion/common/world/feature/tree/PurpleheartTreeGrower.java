package net.killarexe.dimensional_expansion.common.world.feature.tree;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class PurpleheartTreeGrower extends AbstractTreeGrower {

    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean vlaue) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DEMod.MOD_ID, "purpleheart_tree_spawn"));
    }
}
