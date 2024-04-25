package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.common.block.entity.PurpleheartSignBlockEntity;
import net.killarexe.dimensional_expansion.init.DEWoodTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class PurpleheartStandingSignBlock extends StandingSignBlock {

    public PurpleheartStandingSignBlock() {
        super(
                DEWoodTypes.PURPLEHEART,
                Properties.of().strength(1, 10).requiresCorrectToolForDrops().destroyTime(1).sound(SoundType.WOOD)
        );
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
        return new PurpleheartSignBlockEntity(p_154556_, p_154557_);
    }
}
