package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.core.init.DEItemGroups;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import java.util.Random;

public class WarpPowerStone extends PowerStone{

    public WarpPowerStone() {
        super(new Item.Properties().tab(DEItemGroups.MISC).stacksTo(1).durability(32), "warp_power_stone");
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
    public InteractionResultHolder<ItemStack> onUse(Level level, Player player, InteractionHand usedHand, ItemStack item) {
        level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.END_PORTAL_FRAME_FILL, SoundSource.PLAYERS, 1f, new Random().nextFloat() * 0.1F + 0.9F);
        if(player instanceof ServerPlayer serverPlayer) {
            setDamage(item, 1);
            player.getCooldowns().addCooldown(this, DEConfig.powerStoneDelay.get() * 20);
            BlockPos respawnPos = serverPlayer.getRespawnPosition();
            if(respawnPos == null && level instanceof ServerLevel serverLevel) {
                respawnPos = serverLevel.getSharedSpawnPos();
            }
            serverPlayer.changeDimension(serverPlayer.getServer().getLevel(serverPlayer.getRespawnDimension()));
            serverPlayer.teleportTo(respawnPos.getX(), respawnPos.getY(), respawnPos.getZ());
            return InteractionResultHolder.success(item);
        }
        level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.END_PORTAL_FRAME_FILL, SoundSource.PLAYERS, 1f, new Random().nextFloat() * 0.1F + 0.9F);
        return InteractionResultHolder.sidedSuccess(item, false);
    }
}
