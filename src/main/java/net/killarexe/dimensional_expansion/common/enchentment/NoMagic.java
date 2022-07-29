package net.killarexe.dimensional_expansion.common.enchentment;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class NoMagic extends Enchantment{

	public NoMagic() {
		super(Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlot.values());
	}
	
	@Override
	public void doPostHurt(LivingEntity livingEntity, Entity entity, int level) {
		livingEntity.removeAllEffects();
	}
	
	@Override
	public void doPostAttack(LivingEntity livingEntity, Entity p_44687_, int p_44688_) {
		livingEntity.removeAllEffects();
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public int getMinLevel() {
		return 1;
	}
	
	@Override
	public boolean isCurse() {
		return true;
	}
}
