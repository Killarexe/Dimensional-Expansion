package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.utils.DEMath;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CoordLinker extends Item {

    private Vec3i overworldPos, netherPos;
    private boolean isLost;

    public CoordLinker() {
        super(new Item.Properties().stacksTo(1));
        overworldPos = new Vec3i(0,0, 0);
        netherPos = new Vec3i(0, 0, 0);
        isLost = false;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if(Screen.hasShiftDown()){
            if(isLost) {
            	tooltip.add(MutableComponent.create(new TranslatableContents("tooltip." + DEMod.MOD_ID + ".is_lost")));
            }else {
            	tooltip.add(MutableComponent.create(new TranslatableContents("Overworld: " + overworldPos.toShortString() + " Nether: " + netherPos.toShortString())));
            }
        }else{
            tooltip.add(MutableComponent.create(new TranslatableContents("tooltip." + DEMod.MOD_ID + ".shift")));
        }
    }

	@Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        
        ResourceKey<Level> dimension = pEntity.level.dimension();
        if(Level.END.equals(dimension)){
            return;
        }else if (Level.OVERWORLD.equals(dimension)) {
            overworldPos = pEntity.getOnPos();
            netherPos = DEMath.overworldPosToNetherPos(overworldPos);
        } else if (Level.NETHER.equals(dimension)) {
            netherPos = pEntity.getOnPos();
            overworldPos = DEMath.netherPosToOverworldPos(netherPos);
        }else {
        	overworldPos = new Vec3i(0, 0, 0);
            netherPos = new Vec3i(0, 0, 0);
            isLost = true;
        }
    }

    public Vec3i getOverworldPos() {
        return overworldPos;
    }

    public Vec3i getNetherPos() {
        return netherPos;
    }
}
