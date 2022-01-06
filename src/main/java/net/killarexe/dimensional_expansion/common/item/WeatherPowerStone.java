package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.core.config.DEConfig;
import net.killarexe.dimensional_expansion.core.init.DEItemGroups;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WeatherPowerStone extends Item {

    public WeatherPowerStone() {
        super(new Properties().tab(DEItemGroups.MISC).stacksTo(1).durability(32));
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
        if(level instanceof ServerLevel serverLevel){
            if(DEConfig.enableWeatherPowerStone.get() && !player.getCooldowns().isOnCooldown(this)) {
                setDamage(item, 1);
                level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.END_PORTAL_FRAME_FILL, SoundSource.BLOCKS, 1f, 1f);
                player.getCooldowns().addCooldown(this, 2000);
                if (serverLevel.isRaining()) {
                    serverLevel.getServer().getCommands().performCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    player.position(),
                                    Vec2.ZERO,
                                    serverLevel,
                                    4,
                                    "",
                                    new TextComponent(""),
                                    serverLevel.getServer(),
                                    null
                            ).withSuppressedOutput(), "/weather clear");
                    return InteractionResultHolder.success(item);
                } else {
                    serverLevel.getServer().getCommands().performCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL,
                                    player.position(),
                                    Vec2.ZERO,
                                    serverLevel,
                                    4,
                                    "",
                                    new TextComponent(""),
                                    serverLevel.getServer(),
                                    null
                            ).withSuppressedOutput(), "/weather rain");
                    return InteractionResultHolder.success(item);
                }
            }
            return InteractionResultHolder.pass(item);
        }
        return InteractionResultHolder.fail(item);
    }

}
