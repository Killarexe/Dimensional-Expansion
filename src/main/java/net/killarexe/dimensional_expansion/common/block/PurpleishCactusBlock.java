package net.killarexe.dimensional_expansion.common.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class PurpleishCactusBlock extends CactusBlock{

	public PurpleishCactusBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.CACTUS));
	}
	
}
