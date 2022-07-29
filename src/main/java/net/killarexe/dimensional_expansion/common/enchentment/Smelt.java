package net.killarexe.dimensional_expansion.common.enchentment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.DiggingEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class Smelt extends DiggingEnchantment{
	
	public Smelt() {
		super(Rarity.VERY_RARE, EquipmentSlot.values());
	}
	
	@Override
	protected boolean checkCompatibility(Enchantment enchantment) {
		return enchantment != Enchantments.BLOCK_FORTUNE || enchantment != Enchantments.SILK_TOUCH;
	}
	
	@Override
	public int getMaxLevel() {
		return 2;
	}
	
	@Override
	public int getMinLevel() {
		return 1;
	}
}
