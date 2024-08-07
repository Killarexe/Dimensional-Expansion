package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.init.DEItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.MapColor;

public class SavorleafCropBlock extends DECropBlock {

	public static final int MAX_AGE = 4;
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, MAX_AGE);
	
	public SavorleafCropBlock() {
		super(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).mapColor(MapColor.COLOR_LIGHT_BLUE));
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
