package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.init.DEItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class VioletCarrotCropBlock extends DECropBlock {

	public static final int MAX_AGE = 3;
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, MAX_AGE);
	
	public VioletCarrotCropBlock() {
		super(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> pBuilder) {
		pBuilder.add(AGE);
	}

	@Override
	protected ItemLike getBaseSeedId() {
		return DEItems.VIOLET_CARROT.get();
	}
	
	@Override
	public IntegerProperty getAgeProperty() {
		return AGE;
	}
	
	@Override
	public int getMaxAge() {
		return MAX_AGE;
	}
}