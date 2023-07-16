package net.killarexe.dimensional_expansion.common.block.maps;

import com.google.common.collect.ImmutableMap;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;

public class StrippingMap {
	
	public static void putStrippable(Block input, Block output) throws Exception{
        AxeItem.STRIPPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPABLES).put(input, output).build();
    }
	
    public static void putStrippables(){
    	try {
    		putStrippable(DEBlocks.PURPLEHEART_LOG.get(), DEBlocks.STRIPPED_PURPLEHEART_LOG.get());
    	}catch(Exception e) {
    		DEMod.LOGGER.error("Failed to put Strippables: " + e.getLocalizedMessage() + " (Don't worry if you see this message i don't know why it do this error but it's there wait for the MinecraftForge Team to fix it - Killar.exe)");
    	}
    }
}
