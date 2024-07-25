package net.killarexe.dimensional_expansion.common.entity.goals;

import net.killarexe.dimensional_expansion.common.entity.Mouvet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class StealFoodGoal extends TargetGoal{

	private final float range;
	
	public StealFoodGoal(Mouvet pMob, float range) {
		super(pMob, true);
		this.range = range;
	}

	@Override
	public boolean canUse() {
		if(mob instanceof Mouvet mouvet) {
			if (mouvet.getCurrentItem().isEmpty() && mob.getTarget() != null) {
				return entityHaveEdibleItems(mob.getTarget());
			}
		}
		return false;
	}
	
	@Override
	public boolean requiresUpdateEveryTick() {
		return true;
	}
	
	@Override
	public boolean canContinueToUse() {
		return canUse();
	}
	
	@Override
	public void tick() {
		targetMob = mob.getTarget();
		if(targetMob instanceof Player player) {
			if(mob.canAttack(targetMob, TargetingConditions.forCombat().range(range))) {
				ItemStack stack = player.getItemInHand(player.getUsedItemHand());
				if(stack.isEdible()) {
					if(mob instanceof Mouvet mouvet) {
						mouvet.setCurrentItem(stack.copy());
						stack.shrink(stack.getCount());
						player.hurt(player.damageSources().mobAttack(mouvet), 1.0F);
						mouvet.setTarget(null);
						Vec3 randomPos = DefaultRandomPos.getPos(mouvet, 5, 4);
						if(randomPos != null) {
							mouvet.getNavigation().moveTo(randomPos.x, randomPos.y, randomPos.z, 0.75F);
						}
					}
				}
			}else {
				mob.getNavigation().moveTo(targetMob, 0.75F);
			}
		}
	}

	private boolean entityHaveEdibleItems(LivingEntity entity) {
		return entity.getItemInHand(entity.getUsedItemHand()).isEdible();
	}
}
