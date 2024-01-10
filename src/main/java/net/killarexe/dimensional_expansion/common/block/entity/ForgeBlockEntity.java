package net.killarexe.dimensional_expansion.common.block.entity;

import net.killarexe.dimensional_expansion.init.DEBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class ForgeBlockEntity extends InventoryBlockEntity{
	
	public ForgeBlockEntity(BlockPos pos, BlockState state) {
		super(DEBlockEntityTypes.FORGE.get(), pos, state, 2);
	}
	
	public void appendItem(Player player, ItemStack stack) {
		if(stack.isEmpty() || stack.getCount() > stack.getMaxStackSize()) {
			return;
		}
		ItemStack copy = stack.copyWithCount(1);
		if(getItemInSlot(0).isEmpty()) {
			insertItem(0, copy);
		}
	}
}
