package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.world.TreeSpawner;
import net.minecraft.world.level.levelgen.feature.Feature;

import javax.annotation.Nullable;
import java.util.Random;

@SuppressWarnings("rawtypes")
public class DimensionalExansionTrees {

    public static final TreeSpawner END = new TreeSpawner() {
        @Nullable
        @Override
        protected Feature getFeature(Random r) {
            return DimensionalExpansionFeatures.END_TREE.get();
        }
    };
}
