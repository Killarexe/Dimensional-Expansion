package net.killarexe.dimensional_expansion.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class AlloyCrystal extends Item{

	public AlloyCrystal() {
		super(new Item.Properties().fireResistant().rarity(Rarity.RARE));
	}
	
	@Override
	public boolean isFoil(ItemStack pStack) {
		return true;
	}
}
