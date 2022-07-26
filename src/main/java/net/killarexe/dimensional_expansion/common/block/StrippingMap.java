package net.killarexe.dimensional_expansion.common.block;

import com.google.common.collect.ImmutableMap;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class StrippingMap {
    public static void putStrippable(Block input, Block output){
        AxeItem.STRIPPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPABLES).put(input, output).build();
    }

    public static void putStrippables(){
        StrippingMap.putStrippable(DEBlocks.END_LOG.get(), DEBlocks.STRIPPED_END_LOG.get());
    }
}
