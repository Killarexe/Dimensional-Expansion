package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.core.init.DEItemGroups;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CoordLinker extends Item {

    private Vec3i overworldPos, netherPos;

    public CoordLinker() {
        super(new Item.Properties().stacksTo(1).tab(DEItemGroups.MISC));
        overworldPos = new Vec3i(0,0, 0);
        netherPos = new Vec3i(0, 0, 0);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TextComponent("Overworld: " + overworldPos.toShortString() + " Nether: " + netherPos.toShortString()));
        }else{
            tooltip.add(new TranslatableComponent("tooltip.dimensional_expansion.shift"));
        }
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

        if(overworldPos == null || netherPos == null){
            overworldPos = new Vec3i(0,0, 0);
            netherPos = new Vec3i(0, 0, 0);
        }

        ResourceKey<Level> dimension = pEntity.level.dimension();
        if(Level.END.equals(dimension)){
            return;
        }else if (Level.OVERWORLD.equals(dimension)) {
            overworldPos = pEntity.getOnPos();
            int x = overworldPos.getX() / 8;
            int z = overworldPos.getZ() / 8;
            netherPos = new BlockPos(x, pLevel.getHeight(Heightmap.Types.WORLD_SURFACE_WG, x, z), z);
        } else if (Level.NETHER.equals(dimension)) {
            netherPos = pEntity.getOnPos();
            int x = netherPos.getX() * 8;
            int z = netherPos.getZ() * 8;
            overworldPos = new BlockPos(x, pLevel.getHeight(Heightmap.Types.WORLD_SURFACE_WG, x, z), z);
        }
    }

    public Vec3i getOverworldPos() {
        return overworldPos;
    }

    public Vec3i getNetherPos() {
        return netherPos;
    }
}
