package net.killarexe.dimensional_expansion.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class PurpleheartBookself extends Block {
    public PurpleheartBookself() {
        super(BlockBehaviour.Properties.of().strength(1, 10).requiresCorrectToolForDrops().destroyTime(1).sound(SoundType.WOOD));
    }

    @Override
    public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos) {
        return 1.5f;
    }
}
