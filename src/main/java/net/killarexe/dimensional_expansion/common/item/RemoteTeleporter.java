package net.killarexe.dimensional_expansion.common.item;

import java.util.List;
import java.util.Random;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.core.init.DEItemGroups;
import net.killarexe.dimensional_expansion.core.init.DEPoitions;
import net.killarexe.dimensional_expansion.uitls.DEMath;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class RemoteTeleporter extends Item{

	public RemoteTeleporter() {
		super(new Item.Properties().stacksTo(1).durability(16).tab(DEItemGroups.TOOLS));
	}
	
	@Override
	public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
		if(Screen.hasShiftDown()){
			pTooltipComponents.add(new TranslatableComponent("tooltip." + DEMod.MODID + ".remote_teleporter"));
        }else{
        	pTooltipComponents.add(new TranslatableComponent("tooltip." + DEMod.MODID + ".shift"));
        }
	}
	
	@Override
	public Rarity getRarity(ItemStack pStack) {
		return Rarity.UNCOMMON;
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
		ItemStack item = pPlayer.getItemInHand(pUsedHand);
		if(!pPlayer.getCooldowns().isOnCooldown(this)) {
			setDamage(item, 1);
			pPlayer.getCooldowns().addCooldown(this, DEConfig.powerStoneDelay.get() * 20);
			pLevel.playSound(pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.END_PORTAL_FRAME_FILL, SoundSource.PLAYERS, 1f, new Random().nextFloat() * 0.1F + 0.9F);
			pPlayer.addEffect(new MobEffectInstance(DEPoitions.REMOTE_EFFECT.get(), DEMath.secondsToTicks(30)));
		}
		return InteractionResultHolder.success(item);
	}
}
