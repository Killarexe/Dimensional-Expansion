package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.core.init.DEItemGroups;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
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

public class TimePowerStone extends PowerStone {

    public TimePowerStone() {
        super(new Properties().tab(DEItemGroups.MISC).stacksTo(1).durability(32), "time_power_stone");
    }

    @Override
    public Rarity getRarity(ItemStack p_41461_) {
        return Rarity.EPIC;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.CROSSBOW;
    }


    @Override
    public InteractionResultHolder<ItemStack> onUse(Level level, Player player, InteractionHand usedHand, ItemStack item) {
        level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.END_PORTAL_FRAME_FILL, SoundSource.PLAYERS, 1f, new Random().nextFloat() * 0.1F + 0.9F);
        if(level instanceof ServerLevel serverLevel){
            if (serverLevel.isDay()) {
                serverLevel.setDayTime(1000);
            } else {
                serverLevel.setDayTime(13000);
            }
            return InteractionResultHolder.success(item);
        }
        return InteractionResultHolder.fail(item);
    }

}
