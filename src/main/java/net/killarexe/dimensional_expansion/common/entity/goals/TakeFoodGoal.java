package net.killarexe.dimensional_expansion.common.entity.goals;

import net.killarexe.dimensional_expansion.common.entity.Mouvet;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.Optional;

public class TakeFoodGoal extends Goal {

    private final Mouvet mouvet;
    private final float catchRange;
    private final float moveSpeed;
    private final int randomInterval;

    private Optional<ItemEntity> targetItem;

    public TakeFoodGoal(Mouvet mouvet, float catchRange, float moveSpeed, int randomInterval) {
        this.mouvet = mouvet;
        this.catchRange = catchRange;
        this.randomInterval = randomInterval;
        this.moveSpeed = moveSpeed;
        this.targetItem = Optional.empty();
    }

    @Override
    public boolean canUse() {
        if (this.randomInterval > 0 && mouvet.getRandom().nextInt(this.randomInterval) != 0) {
            return false;
        }
        findTarget();
        return targetItem.filter(itemEntity -> itemEntity.getItem().isEdible()).isPresent() && !mouvet.getCurrentItem().isEmpty();
    }

    protected AABB getTargetSearchArea(double pTargetDistance) {
        return mouvet.getBoundingBox().inflate(pTargetDistance, 4.0, pTargetDistance);
    }

    protected double getFollowDistance() {
        return mouvet.getAttributeValue(Attributes.FOLLOW_RANGE);
    }

    protected void findTarget() {
        List<ItemEntity> itemEntities = mouvet.level().getEntitiesOfClass(ItemEntity.class, this.getTargetSearchArea(getFollowDistance()), filter -> true);
        if (itemEntities.isEmpty()){
            targetItem = Optional.empty();
            return;
        }
        targetItem = Optional.of(itemEntities.get(0));
    }

    @Override
    public void tick() {
        if (mouvet.level().isClientSide) {
            return;
        }
        if (targetItem.isPresent()) {
            ItemEntity itemEntity = targetItem.get();
            if(!(mouvet.position().distanceTo(itemEntity.position()) < catchRange)) {
                mouvet.getNavigation().moveTo(itemEntity, moveSpeed);
                return;
            }
            mouvet.setCurrentItem(itemEntity.getItem());
            itemEntity.kill();
        }
    }

    public void setTargetItem(ItemEntity entity) {
        targetItem = Optional.ofNullable(entity);
    }

    @Override
    public boolean canContinueToUse() {
        return canUse();
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }
}