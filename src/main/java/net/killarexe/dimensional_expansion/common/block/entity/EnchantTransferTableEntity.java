package net.killarexe.dimensional_expansion.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class EnchantTransferTableEntity extends InventoryBlockEntity{

	public EnchantTransferTableEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int size) {
		super(type, pos, state, 3);
	}

	@Override
	public void tick() {
		if(level.isClientSide()) {
			return;
		}
		super.tick();
	}
}
