package net.killarexe.dimensional_expansion.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SimixHammerItem extends Item{

	public SimixHammerItem() {
		super(new Item.Properties().durability(16).fireResistant());
	}
	
	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
		if(itemStack.getDamageValue() + 1 >= itemStack.getMaxDamage()) {
			return ItemStack.EMPTY;
		}
		itemStack.setDamageValue(itemStack.getDamageValue() + 1);
		return itemStack;
	}
	
	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}
	
	//TODO: Version 0.8a add Simix Hammer Repearation material
	/*@Override
	public boolean isRepairable(ItemStack stack) {
		return true;
	}*/
}
