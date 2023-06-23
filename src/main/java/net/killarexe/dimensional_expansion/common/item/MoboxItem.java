package net.killarexe.dimensional_expansion.common.item;

import org.jetbrains.annotations.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

public class MoboxItem extends Item {
	private CompoundTag currentEntity;
	
	public MoboxItem() {
		super(new Item.Properties());
		this.currentEntity = new CompoundTag();
	}
	
	@Override
	public InteractionResult useOn(UseOnContext pContext) {
		if(!currentEntity.isEmpty() && pContext.getLevel() instanceof ServerLevel level) {
			Entity loadedEntity = EntityType.loadEntityRecursive(currentEntity, level, (entity) -> {
				entity.moveTo(pContext.getClickedPos().above().getCenter());
				return entity;
			});
			if(loadedEntity instanceof LivingEntity livingEntity) {
				level.addFreshEntity(livingEntity);
				currentEntity = new CompoundTag();
				return InteractionResult.SUCCESS;
			}
			return InteractionResult.PASS;
		}
		return InteractionResult.sidedSuccess(true);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
		if(entity instanceof LivingEntity livingEntity) {
			currentEntity = livingEntity.serializeNBT();
			entity.kill();
			return false;
		}
		return true;
	}
	
	@Override
	public @Nullable CompoundTag getShareTag(ItemStack stack) {
		CompoundTag nbt = new CompoundTag();
		if(currentEntity != null) {
			nbt.put("current_entity", currentEntity);
		}
		return nbt;
	}
	
	@Override
	public void readShareTag(ItemStack stack, @Nullable CompoundTag nbt) {
		Tag entityTag = nbt.get("current_entity");
		if(entityTag instanceof CompoundTag tag) {
			if(EntityType.by(tag).isPresent()) {
				currentEntity = tag;
			}
		}
	}
}
