package net.killarexe.dimensional_expansion.world;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.*;

import javax.annotation.Nullable;
import java.util.Random;

@SuppressWarnings("rawtypes")
public abstract class TreeSpawner {
    @Nullable
    protected abstract Feature getFeature(Random r);

    public boolean spawn(WorldGenLevel writer, ChunkGenerator gen, BlockPos pos, BlockState underBlock, Random r){
        Feature tree = getFeature(r);
        if(tree == null){
            return false;
        }

        writer.setBlock(pos, Blocks.AIR.defaultBlockState(), 4);
        if(tree.place(new FeaturePlaceContext<FeatureConfiguration>(writer, gen, r, pos, new NoneFeatureConfiguration()))){
            return true;
        }

        writer.setBlock(pos, underBlock, 4);
        return false;
    }
}
