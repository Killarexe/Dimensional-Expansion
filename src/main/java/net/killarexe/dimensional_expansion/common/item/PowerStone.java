package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.init.DEGameRules;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public abstract class PowerStone extends Item {

    private String name;

    public PowerStone(Properties p_41383_, String name) {
        super(p_41383_);
        this.name = name;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("tooltip." + DEMod.MOD_ID + "." + name));
        }else{
            pTooltipComponents.add(Component.translatable("tooltip." + DEMod.MOD_ID + ".shift"));
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack item = pPlayer.getItemInHand(pUsedHand);
        if(!pPlayer.getCooldowns().isOnCooldown(this) && pLevel.getGameRules().getBoolean(DEGameRules.ENABLE_POWER_STONES)) {
            item.hurtAndBreak(1, pPlayer, (a) -> a.broadcastBreakEvent(pUsedHand));
            pPlayer.getCooldowns().addCooldown(this, pLevel.getGameRules().getInt(DEGameRules.POWER_STONES_DELAY) * 20);
            return onPowerStoneUse(pLevel, pPlayer, pUsedHand, item);
        }else{
            pPlayer.displayClientMessage(Component.translatable("text." + DEMod.MOD_ID + ".power_stones_disable").withStyle(ChatFormatting.BOLD, ChatFormatting.RED), false);
        }
        return InteractionResultHolder.pass(item);
    }

    public abstract InteractionResultHolder<ItemStack> onPowerStoneUse(Level pLevel, Player pPlayer, InteractionHand pUsedHand, ItemStack item);
}
