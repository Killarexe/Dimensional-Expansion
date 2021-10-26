package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.world.TreeSpawner;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class CustomSaplingBlock extends SaplingBlock {

    private final TreeSpawner tree;

    public CustomSaplingBlock(Properties properties, TreeSpawner spawner) {
        super(null, properties);
        this.tree = spawner;
    }

    @Override
    public void advanceTree(ServerLevel p_55981_, BlockPos p_55982_, BlockState p_55983_, Random p_55984_) {
        if (p_55983_.getValue(STAGE) == 0) {
            p_55981_.setBlock(p_55982_, p_55983_.cycle(STAGE), 4);
        } else {
            tree.spawn(p_55981_, p_55981_.getChunkSource().getGenerator(), p_55982_, p_55983_, p_55984_);
        }
    }
}
