package net.killarexe.dimensional_expansion.common.block.entity;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.init.DEBlockEntityTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.state.BlockState;

public class EnchantTransferTableEntity extends InventoryBlockEntity {
	
	public EnchantTransferTableEntity(BlockPos pos, BlockState state) {
		super(DEBlockEntityTypes.ENCHANT_TRANSFER_TABLE.get(), pos, state, 2);
	}
	
	public void appendItem(Player player, ItemStack stack) {
		if(stack.isEmpty() || stack.is(Items.AIR) || stack.getCount() < 0 || stack.getCount() > stack.getMaxStackSize()) {
			return;
		}
		ItemStack copy = stack.copyWithCount(1);
		if(getItemInSlot(0).isEmpty()) {
			if(!copy.isEnchanted() || copy.is(Items.ENCHANTED_BOOK)) {
				if(player instanceof ServerPlayer serverPlayer) {
					serverPlayer.displayClientMessage(
							Component.translatable("message." + DEMod.MOD_ID + ".need_enchanted_item")
							.withStyle(ChatFormatting.BOLD)
							.withStyle(ChatFormatting.RED), true
					);
				}
				return;
			}
			insertItem(0, copy);
		}else {
			insertItem(1, copy);
		}
		if(!player.isCreative()) {
			stack.setCount(stack.getCount() - 1);
		}
	}
	
	public void prependItem(Player player) {
		ItemEntity item = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), extractItem(1));
		if(getItemInSlot(1).isEmpty()) {
			item = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), extractItem(0));
		}
		level.addFreshEntity(item);
	}
	
	public void transferEnchant(Player player) {
		ItemStack enchantedItem = getItemInSlot(0);
		ItemStack targetItem = getItemInSlot(1);
		int costValue = Mth.clamp(
				enchantedItem.getOrDefault(DataComponents.REPAIR_COST, 0) + targetItem.getOrDefault(DataComponents.REPAIR_COST, 0),
				1, 5
		);
		if(!enchantedItem.isEnchanted() || targetItem.isEmpty() || targetItem.is(Items.AIR)) {
			return;
		}
		if(costValue > player.experienceLevel && !player.isCreative()) {
			player.displayClientMessage(
					Component.translatable("message." + DEMod.MOD_ID + ".cost_too_high")
					.withStyle(ChatFormatting.BOLD)
					.withStyle(ChatFormatting.RED), true
			);
			return;
		}
		boolean transferedEnchant = false;
		ItemStack copy = new ItemStack(enchantedItem.getItem());
		for (Object2IntMap.Entry<Holder<Enchantment>> entry : enchantedItem.getTagEnchantments().entrySet()) {
			if (entry.getKey().value().canEnchant(targetItem) && targetItem.getTagEnchantments().getLevel(entry.getKey()) == 0) {
				targetItem.enchant(entry.getKey(), entry.getIntValue());
				transferedEnchant = true;
			} else {
				copy.enchant(entry.getKey(), entry.getIntValue());
			}
		}
		if(!transferedEnchant) {
			player.displayClientMessage(
					Component.translatable("message." + DEMod.MOD_ID + ".incompatible_enchants")
					.withStyle(ChatFormatting.BOLD)
					.withStyle(ChatFormatting.RED), true
			);
			return;
		}
		copy.setDamageValue(enchantedItem.getDamageValue());
		copy.setCount(enchantedItem.getCount());
		if(enchantedItem.get(DataComponents.CUSTOM_NAME) != null) {
			copy.set(DataComponents.CUSTOM_NAME, enchantedItem.getHoverName());
		}
		extractItem(0);
		insertItem(0, copy);
		if(!player.isCreative()) {
			player.experienceLevel -= costValue;
		}
		player.level().playSound(null, getBlockPos(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1.0F, new Random().nextFloat() * 0.1F + 0.9F);

		//Maybe this is illegal but it works!
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.schedule(this::dropAll, 1, TimeUnit.SECONDS);
		executor.shutdown();
	}
		
	private void dropAll() {
        level.addFreshEntity(
			new ItemEntity(level, getBlockPos().getX() + 0.314, getBlockPos().getY() + 1, getBlockPos().getZ() + 0.25, extractItem(0))
		);
		level.addFreshEntity(
			new ItemEntity(level, getBlockPos().getX() + 0.60, getBlockPos().getY() + 1, getBlockPos().getZ() + 0.75, extractItem(1))
		);
	}

	@Override
	public void tick() {
		if(level.isClientSide()) {
			return;
		}
		setChanged();
	}
}
