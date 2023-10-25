package net.killarexe.dimensional_expansion.common.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.level.Level;

public class Remote extends MobEffect{
	
	//TODO: Reimplement Remote Effect features.
	
	private BlockPos savedPos;
	private ResourceKey<Level> savedDimension;
	
	public Remote() {
		super(MobEffectCategory.NEUTRAL, 4299070);
	}

	@Override
	public void addAttributeModifiers(AttributeMap pAttributeMap, int pAmplifier) {
		super.addAttributeModifiers(pAttributeMap, pAmplifier);
	}
	
	@Override
	public void removeAttributeModifiers(AttributeMap pAttributeMap) {
		super.removeAttributeModifiers(pAttributeMap);
	}
}
