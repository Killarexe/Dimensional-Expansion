package net.killarexe.dimensional_expansion.common.block.maps;

import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.killarexe.dimensional_expansion.init.DEItems;
import net.minecraft.world.level.block.ComposterBlock;

public class CompostableMap {
	public static void putCompostables() {
		ComposterBlock.COMPOSTABLES.put(DEBlocks.PURPLEHEART_LEAVES.get(), 0.3f);
		ComposterBlock.COMPOSTABLES.put(DEBlocks.SAVORLEAF_BLOCK.get(), 0.85f);
		ComposterBlock.COMPOSTABLES.put(DEBlocks.PURPLE_ROSE.get(), 0.3f);
		ComposterBlock.COMPOSTABLES.put(DEBlocks.PURPLEHEART_SAPLING.get(), 0.5f);
		ComposterBlock.COMPOSTABLES.put(DEBlocks.PURPLEISH_CACTUS.get(), 0.65f);
		ComposterBlock.COMPOSTABLES.put(DEItems.SAVORLEAF.get(), 0.5f);
		ComposterBlock.COMPOSTABLES.put(DEItems.VIOLET_CARROT.get(), 0.5f);
	}
}
