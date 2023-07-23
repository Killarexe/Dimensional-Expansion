package net.killarexe.dimensional_expansion.common.entity;

import net.killarexe.dimensional_expansion.client.animations.JugerAnimations;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Juger extends Monster{

	private static final EntityDataAccessor<Boolean> IS_ATTACKING = SynchedEntityData.defineId(Juger.class, EntityDataSerializers.BOOLEAN);
	private final AnimationState ATTACK_STATE = new AnimationState();
	private final AnimationState STAND_STATE = new AnimationState();
	private int attackAnimationCooldown = 0;
	
	public static final AttributeSupplier.Builder ATTRIBUTES = createMonsterAttributes()
			.add(Attributes.MOVEMENT_SPEED, 0.25f)
			.add(Attributes.JUMP_STRENGTH, 0.5f)
			.add(Attributes.ATTACK_DAMAGE, 7.0f)
			.add(Attributes.MAX_HEALTH, 40.0f);
	
	public Juger(EntityType<? extends Monster> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.25F, true));
		this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));

		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AgeableMob.class, false, true));
	}
	
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		entityData.define(IS_ATTACKING, false);
	}
	
	@Override
	public MobType getMobType() {
		return MobType.ARTHROPOD;
	}
	
	@Override
	public void tick() {
		handleAnimationStates();
		super.tick();
	}
	
	private void handleAnimationStates() {
		if(isAttacking()) {
			ATTACK_STATE.startIfStopped(tickCount);
			if(attackAnimationCooldown + JugerAnimations.JUGER_ATTACK.lengthInSeconds() * 20 < tickCount) {
				setAttacking(false);
				ATTACK_STATE.stop();
			}
		}else {
			attackAnimationCooldown = tickCount;
		}
	}
	
	@Override
	public double getMeleeAttackRangeSqr(LivingEntity pEntity) {
		return (double)(this.getBbWidth() * 1.0F * this.getBbWidth() * 1.0F + pEntity.getBbWidth());
	}
	
	@Override
	public boolean doHurtTarget(Entity pEntity) {
		setAttacking(true);
		return super.doHurtTarget(pEntity);
	}
	
	@Override
	protected void updateWalkAnimation(float unknown) {
		this.walkAnimation.update(0.0F, 0.2F);
		super.updateWalkAnimation(unknown);
	}
	
	public void setAttacking(boolean value) {
		entityData.set(IS_ATTACKING, value);
	}
	
	public boolean isAttacking() {
		return entityData.get(IS_ATTACKING);
	}
	
	public AnimationState getAttackState() {
		return ATTACK_STATE;
	}
	
	public AnimationState getStandState() {
		return STAND_STATE;
	}
}
