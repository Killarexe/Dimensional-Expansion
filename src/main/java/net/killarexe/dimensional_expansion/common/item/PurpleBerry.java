package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PurpleBerry extends ItemNameBlockItem{

	public PurpleBerry() {
		super(
			DEBlocks.PURPLE_BERRY_BUSH.get(),
			new Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(1).build())
		);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
		pLivingEntity.addEffect(new MobEffectInstance(MobEffects.HEAL, 2, 0, true, false, false));
		return super.finishUsingItem(pStack, pLevel, pLivingEntity);
	}

}
