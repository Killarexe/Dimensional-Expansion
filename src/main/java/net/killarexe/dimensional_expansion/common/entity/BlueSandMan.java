package net.killarexe.dimensional_expansion.common.entity;

import net.killarexe.dimensional_expansion.init.DESoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.level.Level;

public class BlueSandMan extends AbstractGolem implements RangedAttackMob{

	public static final AttributeSupplier.Builder ATTRIBUTES = createMobAttributes()
			.add(Attributes.MOVEMENT_SPEED, 0.25f)
			.add(Attributes.JUMP_STRENGTH, 1.5f)
			.add(Attributes.ATTACK_DAMAGE, 0.5f)
			.add(Attributes.MAX_HEALTH, 15.0f);
	
	public BlueSandMan(EntityType<? extends BlueSandMan> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Mob.class, 10));
		this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.targetSelector.addGoal(0, new HurtByTargetGoal(this, AbstractGolem.class));
		this.targetSelector.addGoal(4, new RangedAttackGoal(this, 1.0D, 20, 15.0F));
	}

	@Override
	public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
		Snowball snowball = new Snowball(this.level(), this);
		double d0 = pTarget.getEyeY() - (double)1.1F;
		double d1 = pTarget.getX() - this.getX();
		double d2 = d0 - snowball.getY();
		double d3 = pTarget.getZ() - this.getZ();
		double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
		snowball.shoot(d1, d2 + d4, d3, 1.6F, 12.0F);
		this.playSound(SoundEvents.SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
		this.level().addFreshEntity(snowball);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return DESoundEvents.BLUE_SAND_MAN_AMBIENT.get();
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return DESoundEvents.BLUE_SAND_MAN_DEATH.get();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource pDamageSource) {
		return DESoundEvents.BLUE_SAND_MAN_HURT.get();
	}
	
	@Override
	public boolean shouldDropExperience() {
		return true;
	}
}
