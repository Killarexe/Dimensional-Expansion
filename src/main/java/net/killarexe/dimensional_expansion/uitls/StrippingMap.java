package net.killarexe.dimensional_expansion.uitls;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;

public class StrippingMap {
    public static void putStrippable(Block input, Block output){
        AxeItem.STRIPPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPABLES).put(input, output).build();
    }
}
