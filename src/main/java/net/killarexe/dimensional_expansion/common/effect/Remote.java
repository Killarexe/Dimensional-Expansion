package net.killarexe.dimensional_expansion.common.effect;

import net.killarexe.dimensional_expansion.common.world.EntityManager;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Remote extends MobEffect{
	
	private BlockPos savedPos;
	private ResourceKey<Level> savedDimension;
	
	public Remote() {
		super(MobEffectCategory.NEUTRAL, 4299070);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		savedPos = entity.blockPosition();
		savedDimension = entity.level().dimension();
	}
	
	@Override
	public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if(pLivingEntity instanceof Player player) {
			EntityManager.teleportEntityTo(savedDimension, player, savedPos);
			pLivingEntity.playSound(SoundEvents.ZOMBIE_VILLAGER_CURE);
		}else {
			if(pLivingEntity.level().dimension() != savedDimension && pLivingEntity.canChangeDimensions()) {
				pLivingEntity.changeDimension(pLivingEntity.getServer().getLevel(savedDimension));
			}
			pLivingEntity.teleportTo(savedPos.getX(), savedPos.getY(), savedPos.getZ());
			pLivingEntity.playSound(SoundEvents.ZOMBIE_VILLAGER_CURE);;
		}
	}
	
	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return duration == 0;
	}
}
