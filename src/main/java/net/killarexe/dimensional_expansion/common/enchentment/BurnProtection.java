package net.killarexe.dimensional_expansion.common.enchentment;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;

public class BurnProtection extends ProtectionEnchantment{

	public BurnProtection() {
		super(Rarity.VERY_RARE, Type.FIRE, EquipmentSlot.CHEST);
	}
	
	@Override
	public void doPostHurt(LivingEntity livingEntity, Entity entity, int level) {
		if(livingEntity.isOnFire()) {
			livingEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 1));
		}
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
	public boolean isAllowedOnBooks() {
		return true;
	}

}
