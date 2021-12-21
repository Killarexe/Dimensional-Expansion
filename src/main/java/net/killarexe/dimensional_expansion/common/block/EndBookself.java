package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class EndBookself extends Block {
    public EndBookself() {
        super(Properties.copy(DEBlocks.END_PLANKS.get()));
    }

    @Override
    public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos) {
        return 1.5f;
    }
}
