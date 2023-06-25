package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.utils.DEMath;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.ByteTag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CoordLinker extends Item {

    public CoordLinker() {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if(Screen.hasShiftDown() && stack.hasTag()){
        	boolean isLost = stack.getTag().getBoolean("is_lost");
        	int[] overworldPosArray = stack.getTag().getIntArray("overworld_pos");
        	int[] netherPosArray = stack.getTag().getIntArray("nether_pos");
        	Vec3i overworldPos = new Vec3i(overworldPosArray[0], overworldPosArray[1], overworldPosArray[2]);
        	Vec3i netherPos = new Vec3i(netherPosArray[0], netherPosArray[1], netherPosArray[2]);
            if(isLost) {
            	tooltip.add(Component.translatable("tooltip." + DEMod.MOD_ID + ".is_lost"));
            }else {
            	tooltip.add(Component.translatable("Overworld: " + overworldPos.toShortString() + " Nether: " + netherPos.toShortString()));
            }
        }else{
            tooltip.add(Component.translatable("tooltip." + DEMod.MOD_ID + ".shift"));
        }
    }

	@Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        ResourceKey<Level> dimension = pEntity.level.dimension();
        if(Level.END.equals(dimension)){
            return;
        }else if (Level.OVERWORLD.equals(dimension)) {
        	BlockPos overworldPos = pEntity.getOnPos();
        	setPoses(pStack, overworldPos, DEMath.overworldPosToNetherPos(overworldPos), false);
        } else if (Level.NETHER.equals(dimension)) {
            BlockPos netherPos = pEntity.getOnPos();
            setPoses(pStack, netherPos, DEMath.netherPosToOverworldPos(netherPos), false);
        }else {
        	setPoses(pStack, Vec3i.ZERO, Vec3i.ZERO, true);
        }
    }
	
	private void setPoses(ItemStack stack, Vec3i overworld, Vec3i nether, boolean isLost) {
		stack.addTagElement("overworld_pos", new IntArrayTag(new int[] {overworld.getX(), overworld.getY(), overworld.getZ()}));
		stack.addTagElement("nether_pos", new IntArrayTag(new int[] {nether.getX(), nether.getY(), nether.getZ()}));
		stack.addTagElement("is_lost", ByteTag.valueOf(isLost));
	}
}
