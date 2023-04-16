package net.killarexe.dimensional_expansion.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirtPathBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class OriginDirtPathBlock extends DirtPathBlock{
	
	public OriginDirtPathBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.DIRT_PATH).sound(SoundType.GRASS));
	}

	@Override
	public boolean canSurvive(BlockState p_153148_, LevelReader p_153149_, BlockPos p_153150_) {
		BlockState blockstate = p_153149_.getBlockState(p_153150_.above());
	    return !blockstate.getMaterial().isSolid() || blockstate.getBlock() instanceof FenceGateBlock;
	}
	
	@Override
	public void tick(BlockState p_221070_, ServerLevel p_221071_, BlockPos p_221072_, RandomSource p_221073_) {
		if(!canSurvive(p_221070_, p_221071_, p_221072_)) {
			OriginFarmlandBlock.turnToOriginDirt(p_221070_, p_221071_, p_221072_);
		}
	}
}
