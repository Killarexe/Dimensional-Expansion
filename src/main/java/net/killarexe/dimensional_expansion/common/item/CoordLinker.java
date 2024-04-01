package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CoordLinker extends Item {

    public CoordLinker() {
        super(new Item.Properties().stacksTo(1));
    }

	@Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(pEntity instanceof Player player) {
            if(player.getMainHandItem().is(this)) {
                ResourceKey<Level> dimension = player.level().dimension();
                if (Level.OVERWORLD.equals(dimension)) {
                    BlockPos overworldPos = player.getOnPos();
                    setPoses(player, overworldPos, overworldPosToNetherPos(overworldPos), false);
                } else if (Level.NETHER.equals(dimension)) {
                    BlockPos netherPos = player.getOnPos();
                    setPoses(player, netherPos, netherPosToOverworldPos(netherPos), false);
                } else {
                    setPoses(player, Vec3i.ZERO, Vec3i.ZERO, true);
                }
            }
        }
    }
	
	private void setPoses(Player player, Vec3i overworld, Vec3i nether, boolean isLost) {
        if(isLost) {
            player.displayClientMessage(
                    Component.translatable("tooltip." + DEMod.MOD_ID + ".is_lost")
                            .withStyle(ChatFormatting.BOLD)
                            .withStyle(ChatFormatting.RED), true
            );
        } else {
           player.displayClientMessage(
                   Component.translatable("Overworld: " + overworld.toShortString() + " Nether: " + nether.toShortString()),
                   true
           );
        }
	}
	
	private Vec3i overworldPosToNetherPos(Vec3i position) {
		return new Vec3i(position.getX() / 8, position.getY(), position.getZ() / 8);
	}
	
	private Vec3i netherPosToOverworldPos(Vec3i position) {
		return new Vec3i(position.getX() * 8, position.getY(), position.getZ() * 8);
	}
	
}
