package net.killarexe.dimensional_expansion.common.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.level.Level;

public class Mouvet extends AgeableMob{

	public static final AttributeSupplier.Builder ATTRIBUTES = createMobAttributes()
			.add(Attributes.MOVEMENT_SPEED, 0.75f)
			.add(Attributes.JUMP_STRENGTH, 1.0f)
			.add(Attributes.MAX_HEALTH, 10.0f);
	
	public Mouvet(EntityType<? extends AgeableMob> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Mob.class, 10));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.15f));
		this.goalSelector.addGoal(0, new FloatGoal(this));
	}
	
	@Override
	public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
		return this;
	}

}
