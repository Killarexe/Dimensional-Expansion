package net.killarexe.dimensional_expansion.common.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class EndBookshelf extends Block {
    public EndBookshelf() {
        super(FabricBlockSettings.copyOf(Blocks.BOOKSHELF));
    }
}
