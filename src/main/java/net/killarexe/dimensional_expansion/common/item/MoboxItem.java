package net.killarexe.dimensional_expansion.common.item;

import java.util.List;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;

public class MoboxItem extends Item {
	public MoboxItem() {
		super(new Item.Properties().durability(5));
	}
	
	@Override
	public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
		if(Screen.hasShiftDown() && pStack.has(DataComponents.CUSTOM_DATA)) {
			CompoundTag entityData = pStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();
			if (!entityData.isEmpty()) {
				pTooltipComponents.add(Component.translatable("tooltip." + DEMod.MOD_ID + ".mobox.current_entity", Component.translatable(entityData.getString("id"))));
			} else {
				pTooltipComponents.add(Component.translatable("tooltip." + DEMod.MOD_ID + ".mobox"));
			}
		} else {
			pTooltipComponents.add(Component.translatable("tooltip." + DEMod.MOD_ID + ".shift"));
		}
	}

	@Override
	public InteractionResult useOn(UseOnContext pContext) {
		ItemStack item = pContext.getItemInHand();
		CompoundTag entityData = item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();
		if(!entityData.isEmpty() && pContext.getLevel() instanceof ServerLevel level) {
			Entity loadedEntity = EntityType.loadEntityRecursive(entityData, level, (entity) -> {
				entity.moveTo(pContext.getClickedPos().above().getCenter());
				return entity;
			});
			if(loadedEntity instanceof LivingEntity livingEntity) {
				level.addFreshEntity(livingEntity);
				item.set(DataComponents.CUSTOM_DATA, CustomData.of(new CompoundTag()));
				item.hurtAndBreak(1, pContext.getPlayer(), item.getEquipmentSlot());
				return InteractionResult.SUCCESS;
			}
			return InteractionResult.PASS;
		}
		return InteractionResult.sidedSuccess(true);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
		CompoundTag currentEntity = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();
		if(entity instanceof LivingEntity livingEntity && currentEntity.isEmpty()) {
			stack.set(DataComponents.CUSTOM_DATA, CustomData.of(livingEntity.serializeNBT(player.registryAccess())));
			entity.remove(RemovalReason.DISCARDED);
			return false;
		}
		return super.onLeftClickEntity(stack, player, entity);
	}
}
