package net.killarexe.dimensional_expansion.common.block.entity;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.level.block.state.BlockState;

public class EnchantTransferTableEntity extends InventoryBlockEntity{

	public static final Component TITLE = MutableComponent.create(new TranslatableContents("block." + DEMod.MOD_ID + ".enchant_transfer_table"));
	
	public EnchantTransferTableEntity(BlockPos pos, BlockState state) {
		super(DEBlockEntityTypes.ENCHANT_TRANSFER_TABLE.get(), pos, state, 3);
	}

	@Override
	public void tick() {
		if(level.isClientSide()) {
			return;
		}
		setChanged();
	}
}
