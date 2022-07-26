package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

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
            pTooltipComponents.add(MutableComponent.create(new TranslatableContents("tooltip." + DEMod.MOD_ID + "." + name)));
        }else{
            pTooltipComponents.add(MutableComponent.create(new TranslatableContents("tooltip." + DEMod.MOD_ID + ".shift")));
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack item = pPlayer.getItemInHand(pUsedHand);
        if(!pPlayer.getCooldowns().isOnCooldown(this) && DEConfig.enablePowerStones.get()) {
            setDamage(item, 1);
            pPlayer.getCooldowns().addCooldown(this, DEConfig.powerStoneDelay.get() * 20);
            return onUse(pLevel, pPlayer, pUsedHand, item);
        }else{
            pPlayer.displayClientMessage(Component.translatable("text." + DEMod.MOD_ID + ".power_stones_disable"), false);
        }
        return InteractionResultHolder.pass(item);
    }

    public abstract InteractionResultHolder<ItemStack> onUse(Level pLevel, Player pPlayer, InteractionHand pUsedHand, ItemStack item);
}