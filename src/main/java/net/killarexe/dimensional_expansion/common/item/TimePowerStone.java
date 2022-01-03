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
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TimePowerStone extends Item {

    public TimePowerStone() {
        super(new Properties().tab(DEItemGroups.MISC));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TranslatableComponent("tooltip.dimensional_expansion.time_power_stone"));
        }else{
            tooltip.add(new TranslatableComponent("tooltip.dimensional_expansion.shift"));
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.SPYGLASS;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        if(level instanceof ServerLevel serverLevel){
            if(DEConfig.enableTimePowerStone.get()) {
                if (serverLevel.isDay()) {
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
                            ).withSuppressedOutput(), "/time set night");
                    return InteractionResult.SUCCESS;
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
                            ).withSuppressedOutput(), "/time set day");
                    return InteractionResult.SUCCESS;
                }
            }
            return InteractionResult.PASS;
        }
        return InteractionResult.FAIL;
    }

}
