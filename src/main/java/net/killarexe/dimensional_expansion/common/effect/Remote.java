package net.killarexe.dimensional_expansion.common.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class Remote extends MobEffect{
	
	private BlockPos savedPos;
	
	public Remote() {
		super(MobEffectCategory.NEUTRAL, 4299070);
	}
	
	@Override
	public void addAttributeModifiers(LivingEntity pLivingEntity, AttributeMap pAttributeMap, int pAmplifier) {
		super.addAttributeModifiers(pLivingEntity, pAttributeMap, pAmplifier);
		savedPos = pLivingEntity.blockPosition();
	}
	
	@Override
	public void removeAttributeModifiers(LivingEntity pLivingEntity, AttributeMap pAttributeMap, int pAmplifier) {
		super.removeAttributeModifiers(pLivingEntity, pAttributeMap, pAmplifier);
		pLivingEntity.teleportTo(savedPos.getX(), savedPos.getY(), savedPos.getZ());
	}
}
