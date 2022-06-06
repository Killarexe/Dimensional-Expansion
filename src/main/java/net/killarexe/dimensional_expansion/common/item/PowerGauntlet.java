package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.client.gui.screen.PowerGauntletScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PowerGauntlet extends Item {

    public PowerGauntlet() {
        super(new Properties().stacksTo(1).fireResistant());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack item = pPlayer.getItemInHand(pUsedHand);
        if(pLevel.isClientSide){
            Minecraft.getInstance().setScreen(new PowerGauntletScreen());
            return InteractionResultHolder.success(item);
        }
        return InteractionResultHolder.fail(item);
    }
}
