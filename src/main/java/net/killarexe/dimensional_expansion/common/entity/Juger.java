package net.killarexe.dimensional_expansion.common.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Juger extends Monster{
	
	public static final AttributeSupplier.Builder ATTRIBUTES = createMonsterAttributes()
			.add(Attributes.MOVEMENT_SPEED, 0.25f)
			.add(Attributes.JUMP_STRENGTH, 0.5f)
			.add(Attributes.MAX_HEALTH, 40.0f);

	public Juger(EntityType<? extends Monster> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
		//this.goalSelector.addGoal(2, new RestrictSunGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));

		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Monster.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
	}
}
