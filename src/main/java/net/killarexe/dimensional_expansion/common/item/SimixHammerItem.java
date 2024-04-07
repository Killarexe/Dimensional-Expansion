package net.killarexe.dimensional_expansion.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SimixHammerItem extends Item{

	public SimixHammerItem() {
		super(new Item.Properties().durability(16).fireResistant());
	}
	
	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
		itemStack.shrink(1);
		ItemStack retval = new ItemStack(this);
		retval.setDamageValue(itemStack.getDamageValue() + 1);
		if(retval.getDamageValue() >= retval.getMaxDamage()) {
			return ItemStack.EMPTY;
		}
		return retval;
	}
	
	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}
	
	@Override
	public boolean isRepairable(ItemStack stack) {
		return false;
	}
}
