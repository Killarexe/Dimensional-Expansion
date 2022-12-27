package net.killarexe.dimensional_expansion.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class EnchantTransferTable extends Block implements EntityBlock{

	public EnchantTransferTable() {
		super(BlockBehaviour.Properties
        		.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY)
        		.strength(6, 50)
        		.requiresCorrectToolForDrops()
        		.destroyTime(3)
        		.sound(SoundType.ANVIL)
        );
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return null;
	}

}
