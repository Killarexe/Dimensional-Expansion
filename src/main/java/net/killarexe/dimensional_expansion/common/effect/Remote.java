package net.killarexe.dimensional_expansion.common.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.level.Level;

public class Remote extends MobEffect{
	
	private BlockPos savedPos;
	private ResourceKey<Level> savedDimension;
	
	public Remote() {
		super(MobEffectCategory.NEUTRAL, 4299070);
	}
	
	@Override
	public void addAttributeModifiers(LivingEntity pLivingEntity, AttributeMap pAttributeMap, int pAmplifier) {
		super.addAttributeModifiers(pLivingEntity, pAttributeMap, pAmplifier);
		savedPos = pLivingEntity.blockPosition();
		savedDimension = pLivingEntity.getLevel().dimension();
	}
	
	@Override
	public void removeAttributeModifiers(LivingEntity pLivingEntity, AttributeMap pAttributeMap, int pAmplifier) {
		super.removeAttributeModifiers(pLivingEntity, pAttributeMap, pAmplifier);
		pLivingEntity.changeDimension(pLivingEntity.getServer().getLevel(savedDimension));
		pLivingEntity.teleportTo(savedPos.getX(), savedPos.getY(), savedPos.getZ());
	}
}
