package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class SavorleafCropBlock extends DMCropBlock{

	public static final int MAX_AGE = 7;
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, MAX_AGE);
	
	public SavorleafCropBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.WHEAT));
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> pBuilder) {
		pBuilder.add(AGE);
	}

	@Override
	protected ItemLike getBaseSeedId() {
		return DEItems.SAVORLEAF.get();
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
