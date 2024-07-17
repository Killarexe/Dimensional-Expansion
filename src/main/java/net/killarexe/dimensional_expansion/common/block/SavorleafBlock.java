package net.killarexe.dimensional_expansion.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class SavorleafBlock extends Block{
	public SavorleafBlock() {
		super(
			BlockBehaviour.Properties.of()
			.destroyTime(1)
			.strength(2, 2)
			.friction(0.8f)
			.sound(SoundType.GRASS)
			.mapColor(MapColor.COLOR_MAGENTA)
		);
	}
	
	public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
	      double d0 = Math.abs(pEntity.getDeltaMovement().y);
	      if (d0 < 0.1D && !pEntity.isSteppingCarefully()) {
	         double d1 = 0.4D + d0 * 0.2D;
	         pEntity.setDeltaMovement(pEntity.getDeltaMovement().multiply(d1, 1.0D, d1));
	      }

	      super.stepOn(pLevel, pPos, pState, pEntity);
	}
}
