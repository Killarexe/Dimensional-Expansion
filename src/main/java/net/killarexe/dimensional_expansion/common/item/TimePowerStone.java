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

public class TimePowerStone extends PowerStone {

    public TimePowerStone() {
        super(new Properties().stacksTo(1).durability(32), "time_power_stone");
    }

    @Override
    public Rarity getRarity(ItemStack p_41461_) {
        return Rarity.EPIC;
    }

    @Override
    public InteractionResultHolder<ItemStack> onPowerStoneUse(Level level, Player player, InteractionHand usedHand, ItemStack item) {
        level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.END_PORTAL_FRAME_FILL, SoundSource.PLAYERS, 1f, new Random().nextFloat() * 0.1F + 0.9F);
        if(level instanceof ServerLevel serverLevel){
        	serverLevel.setDayTime(serverLevel.getDayTime() + 12000);
            return InteractionResultHolder.success(item);
        }
        return InteractionResultHolder.fail(item);
    }

}
