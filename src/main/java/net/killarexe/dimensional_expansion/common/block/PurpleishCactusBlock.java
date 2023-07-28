package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class PurpleishCactusBlock extends CactusBlock{

	public PurpleishCactusBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.CACTUS).noOcclusion());
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		for(Direction direction : Direction.Plane.HORIZONTAL) {
			BlockState blockstate = pLevel.getBlockState(pPos.relative(direction));
	        if (!blockstate.isAir() || pLevel.getFluidState(pPos.relative(direction)).is(FluidTags.LAVA)) {
	        	return false;
	        }
	    }
	    BlockState blockstate1 = pLevel.getBlockState(pPos.below());
	    return canSustainPlant(blockstate1) && !pLevel.getBlockState(pPos.above()).liquid();
	}
	
	private boolean canSustainPlant(BlockState state) {
		return state.is(this) || state.is(Blocks.SAND) || state.is(DEBlocks.BLUE_SAND.get());
	}
}
