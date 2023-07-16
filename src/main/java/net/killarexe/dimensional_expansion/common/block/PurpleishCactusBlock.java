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
import net.minecraft.world.level.material.Material;

public class PurpleishCactusBlock extends CactusBlock{

	public PurpleishCactusBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.CACTUS).noOcclusion());
	}
	
	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		for(Direction direction : Direction.Plane.HORIZONTAL) {
			BlockState blockstate = pLevel.getBlockState(pPos.relative(direction));
	        Material material = blockstate.getMaterial();
	        if (material.isSolid() || pLevel.getFluidState(pPos.relative(direction)).is(FluidTags.LAVA)) {
	        	return false;
	        }
	    }
	    BlockState blockstate1 = pLevel.getBlockState(pPos.below());
	    return canSustainPlant(blockstate1) && !pLevel.getBlockState(pPos.above()).getMaterial().isLiquid();
	}
	
	private boolean canSustainPlant(BlockState state) {
		return state.is(this) || state.is(Blocks.SAND) || state.is(DEBlocks.BLUE_SAND.get());
	}
}
