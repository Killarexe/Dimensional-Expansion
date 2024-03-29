package net.killarexe.dimensional_expansion.common.item;

import java.util.Random;

import net.killarexe.dimensional_expansion.init.DEEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class RemotePowerStone extends PowerStone{
	public RemotePowerStone() {
		super(new Item.Properties().stacksTo(1).durability(16), "remote_teleporter");
	}
	
	@Override
	public Rarity getRarity(ItemStack pStack) {
		return Rarity.UNCOMMON;
	}

	@Override
	public InteractionResultHolder<ItemStack> onPowerStoneUse(Level pLevel, Player pPlayer, InteractionHand pUsedHand, ItemStack item) {
		pLevel.playSound(pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.END_PORTAL_FRAME_FILL, SoundSource.PLAYERS, 1f, new Random().nextFloat() * 0.1F + 0.9F);
		pPlayer.addEffect(new MobEffectInstance(DEEffects.REMOTE_EFFECT.get(), 600));
		return InteractionResultHolder.success(item);
	}
}
