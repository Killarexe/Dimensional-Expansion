package net.killarexe.dimensional_expansion.common.entity;

import net.killarexe.dimensional_expansion.common.entity.goals.StealFoodGoal;
import net.killarexe.dimensional_expansion.common.entity.goals.TakeFoodGoal;
import net.killarexe.dimensional_expansion.init.DESoundEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Mouvet extends Animal{
	
	private static final EntityDataAccessor<ItemStack> CURRENT_ITEM = SynchedEntityData.defineId(Mouvet.class, EntityDataSerializers.ITEM_STACK);
	
	public static final AttributeSupplier.Builder ATTRIBUTES = createMobAttributes()
			.add(Attributes.MOVEMENT_SPEED, 0.75f)
			.add(Attributes.JUMP_STRENGTH, 0.5f)
			.add(Attributes.MAX_HEALTH, 5.0f);
	
	public Mouvet(EntityType<? extends Animal> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Mob.class, 10));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new TakeFoodGoal(this, 1.0F, 0.75F, 10));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.075f));
		this.goalSelector.addGoal(0, new FloatGoal(this));
		
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(2, new StealFoodGoal(this, 1.0F));
	}
	
	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		builder.define(CURRENT_ITEM, ItemStack.EMPTY);
		super.defineSynchedData(builder);
	}
	
	@Override
	public void addAdditionalSaveData(CompoundTag pCompound) {
		ItemStack currentItem = getCurrentItem();
		if (!currentItem.isEmpty()) {
			pCompound.put("current_item", currentItem.save(registryAccess()));
		}
		super.addAdditionalSaveData(pCompound);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag pCompound) {
		setCurrentItem(ItemStack.parseOptional(registryAccess(), pCompound.getCompound("current_item")));
		super.readAdditionalSaveData(pCompound);
	}

	@Override
	public boolean isFood(ItemStack pStack) {
		return false;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
		return this;
	}
	
	public void setCurrentItem(ItemStack stack) {
		entityData.set(CURRENT_ITEM, stack);
	}
	
	@Override
	protected void dropEquipment() {
		if(!getCurrentItem().isEmpty()) {
			level().addFreshEntity(new ItemEntity(level(), position().x, position().y + 1 , position().z, getCurrentItem(), 0, 0.5D, 0.0));
		}
		super.dropEquipment();
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pSpawnType, @Nullable SpawnGroupData pSpawnGroupData) {
		if (pLevel.getRandom().nextInt(500) <= 10) {
			List<Item> foodItems = BuiltInRegistries.ITEM.stream().filter(item -> new ItemStack(item).get(DataComponents.FOOD) != null).toList();
			if (!foodItems.isEmpty()) {
				setCurrentItem(new ItemStack(foodItems.get(random.nextInt(foodItems.size() - 1))));
			}
		}
		return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);
	}

	public ItemStack getCurrentItem() {
		return entityData.get(CURRENT_ITEM);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return DESoundEvents.MOUVET_AMBIENT.get();
	}	
	
	@Override
	protected SoundEvent getDeathSound() {
		return DESoundEvents.MOUVET_DEATH.get();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource pDamageSource) {
		return DESoundEvents.MOUVET_HURT.get();
	}
	
	@Override
	public boolean shouldDropExperience() {
		return true;
	}
}
