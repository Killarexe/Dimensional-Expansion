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
		super(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH).sound(SoundType.GRASS));
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		BlockState blockstate = level.getBlockState(pos.above());
	    return blockstate.isAir() || blockstate.getBlock() instanceof FenceGateBlock;
	}
	
	@Override
	public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if(!canSurvive(state, level, pos)) {
			OriginFarmlandBlock.turnToOriginDirt(state, level, pos);
		}
	}
}
