package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.core.init.DEItemGroups;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class WeatherPowerStone extends Item {

    public WeatherPowerStone() {
        super(new Item.Properties().tab(DEItemGroups.MISC).stacksTo(1).durability(32));
    }

    @Override
    public int getUseDuration(ItemStack p_41454_) {
        return 72000;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TranslatableComponent("tooltip.dimensional_expansion.weather_power_stone"));
        }else{
            tooltip.add(new TranslatableComponent("tooltip.dimensional_expansion.shift"));
        }
    }

    @Override
    public Rarity getRarity(ItemStack p_41461_) {
        return Rarity.EPIC;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.SPYGLASS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack item = player.getItemInHand(hand);
        if(DEConfig.enableTimePowerStone.get() && !player.getCooldowns().isOnCooldown(this)){
            level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.END_PORTAL_FRAME_FILL, SoundSource.PLAYERS, 1f, new Random().nextFloat() * 0.1F + 0.9F);
            if(level instanceof ServerLevel serverLevel){
                player.getCooldowns().addCooldown(this, DEConfig.powerStoneDelay.get() * 20);
                if (serverLevel.isRaining()) {
                    serverLevel.setWeatherParameters(0, 0, false, false);
                    return InteractionResultHolder.success(item);
                } else {
                    serverLevel.setWeatherParameters(0, 6000, true, false);
                    return InteractionResultHolder.success(item);
                }
            }
            return InteractionResultHolder.pass(item);
        }
        return InteractionResultHolder.fail(item);
    }

}
