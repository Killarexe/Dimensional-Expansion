package net.killarexe.dimensional_expansion.common.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.Random;

public class WeatherPowerStone extends PowerStone{

    public WeatherPowerStone() {
        super(new Item.Properties().stacksTo(1).durability(32), "weather_power_stone");
    }

    @Override
    public Rarity getRarity(ItemStack p_41461_) {
        return Rarity.EPIC;
    }

    @Override
    public InteractionResultHolder<ItemStack> onPowerStoneUse(Level level, Player player, InteractionHand pUsedHand, ItemStack item) {
        level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.END_PORTAL_FRAME_FILL, SoundSource.PLAYERS, 1f, new Random().nextFloat() * 0.1F + 0.9F);
        if(level instanceof ServerLevel serverLevel){
            if (serverLevel.isRaining()) {
                serverLevel.setWeatherParameters(0, 0, false, false);
                return InteractionResultHolder.success(item);
            } else {
                serverLevel.setWeatherParameters(0, 6000, true, false);
                return InteractionResultHolder.success(item);
            }
        }
        return InteractionResultHolder.sidedSuccess(item, false);
    }
}
