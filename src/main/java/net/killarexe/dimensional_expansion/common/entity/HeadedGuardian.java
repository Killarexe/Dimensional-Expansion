package net.killarexe.dimensional_expansion.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.ai.goal.RestrictSunGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class HeadedGuardian extends AbstractGolem implements RangedAttackMob{

	public HeadedGuardian(EntityType<? extends HeadedGuardian> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(2, new RestrictSunGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));

		this.targetSelector.addGoal(1, new HurtByTargetGoal(this, AbstractGolem.class));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Monster.class, true));
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pSpawnType, @Nullable SpawnGroupData pSpawnGroupData) {
		setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
		this.goalSelector.addGoal(4, new RangedBowAttackGoal<>(this, 1.0D, 20, 15.0F));
		return pSpawnGroupData;
	}

	protected void playStepSound(BlockPos pPos, BlockState pBlock) {
		this.playSound(SoundEvents.SKELETON_STEP, 0.15F, 1.0F);
	}
	
	@Override
	public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
	    ItemStack itemstack = this.getProjectile(this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof BowItem)));
	    AbstractArrow abstractarrow = ProjectileUtil.getMobArrow(this, itemstack, pVelocity, null);
	    if (this.getMainHandItem().getItem() instanceof BowItem) {
	    	abstractarrow = ((BowItem)this.getMainHandItem().getItem()).customArrow(abstractarrow, null, null);
	    }
	    double d0 = pTarget.getX() - this.getX();
	    double d1 = pTarget.getY(0.33333333333D) - abstractarrow.getY() - 0.5F;
	    double d2 = pTarget.getZ() - this.getZ();
	    double d3 = Math.sqrt(d0 * d0 + d2 * d2);
	    lookAt(pTarget, 180, 180);
	    abstractarrow.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.level().getDifficulty().getId() * 4));
	    this.playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
	    this.level().addFreshEntity(abstractarrow);
	}
}