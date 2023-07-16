package net.killarexe.dimensional_expansion.common.block.maps;

import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;

public class FlowerPotMap {
	public static void putFlowers() {
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DEBlocks.PURPLE_ROSE.getId(), DEBlocks.POTTED_PURPLE_ROSE);
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DEBlocks.PURPLEISH_CACTUS.getId(), DEBlocks.POTTED_PURPLEISH_CACTUS);
		((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DEBlocks.PURPLEHEART_SAPLING.getId(), DEBlocks.POTTED_PURPLEHEART_SAPLING);
	}
}
