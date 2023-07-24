package net.killarexe.dimensional_expansion.common.item;

import java.util.List;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.client.gui.screens.Screen;
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
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class MoboxItem extends Item {
	public MoboxItem() {
		super(new Item.Properties().defaultDurability(5));
	}
	
	@Override
	public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
		if(Screen.hasShiftDown() && pStack.hasTag()){
			CompoundTag currentEntity = pStack.getOrCreateTagElement("current_entity");
        	String entityName = currentEntity.isEmpty() ? "none" : currentEntity.getString("id");
            pTooltipComponents.add(Component.translatable("tooltip." + DEMod.MOD_ID + ".mobox.current_entity", Component.translatable(entityName)));
        }else{
            pTooltipComponents.add(Component.translatable("tooltip." + DEMod.MOD_ID + ".shift"));
        }
	}
	
	@Override
	public InteractionResult useOn(UseOnContext pContext) {
		ItemStack item = pContext.getItemInHand();
		CompoundTag currentEntity = item.getOrCreateTagElement("current_entity");
		if(!currentEntity.isEmpty() && pContext.getLevel() instanceof ServerLevel level) {
			Entity loadedEntity = EntityType.loadEntityRecursive(currentEntity, level, (entity) -> {
				entity.moveTo(pContext.getClickedPos().above().getCenter());
				return entity;
			});
			if(loadedEntity instanceof LivingEntity livingEntity) {
				level.addFreshEntity(livingEntity);
				item.addTagElement("current_entity", new CompoundTag());
				item.hurtAndBreak(1, pContext.getPlayer(), (a) -> a.broadcastBreakEvent(pContext.getHand()));
				return InteractionResult.SUCCESS;
			}
			return InteractionResult.PASS;
		}
		return InteractionResult.sidedSuccess(true);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
		CompoundTag currentEntity = stack.getOrCreateTagElement("current_entity");
		if(entity instanceof LivingEntity livingEntity && currentEntity.isEmpty()) {
			stack.addTagElement("current_entity", livingEntity.serializeNBT());
			entity.remove(RemovalReason.DISCARDED);
			return false;
		}
		return super.onLeftClickEntity(stack, player, entity);
	}
}
