package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.world.item.AxeItem;

public class StrippingMap {
    public static void putStrippables(){
    	try {
    		AxeItem.STRIPPABLES.put(DEBlocks.PURPLEHEART_LOG.get(), DEBlocks.STRIPPED_PURPLEHEART_LOG.get());
    	}catch(Exception e) {
    		DEMod.LOGGER.error("Failed to put Strippables: " + e.getLocalizedMessage() + " (Don't worry if you see this message i don't know why it do this error but it's there wait for the MinecraftForge Team to fix it - Killar.exe)");
    	}
    }
}
