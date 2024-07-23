package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DECropBlock extends CropBlock{

	public DECropBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return pState.is(DEBlocks.ORIGIN_FARMLAND.get());
	}
}
