package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class DEBlockTagsProvider extends BlockTagsProvider {
    public DEBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper helper) {
        super(generator, DEMod.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Blocks.ORES).add(DEBlocks.PALON_ORE.get(), DEBlocks.BASSMITE_ORE.get(),
                DEBlocks.SIMIX_ORE.get(), DEBlocks.EMERTYST_ORE.get());
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(DEBlocks.PALON_ORE.get(), DEBlocks.PALON_BLOCK.get());

        tag(BlockTags.DIRT).add(DEBlocks.END_GRASS_BLOCK.get());
        tag(BlockTags.LOGS).add(DEBlocks.END_LOG.get(), DEBlocks.STRIPPED_END_LOG.get());
        tag(BlockTags.PLANKS).add(DEBlocks.END_PLANKS.get());
        tag(BlockTags.LEAVES).add(DEBlocks.END_LEAVES.get());
        tag(BlockTags.SIGNS).add(DEBlocks.END_SIGN.get(), DEBlocks.END_WALL_SIGN.get());
        tag(BlockTags.STANDING_SIGNS).add(DEBlocks.END_SIGN.get());
        tag(BlockTags.WALL_SIGNS).add(DEBlocks.END_WALL_SIGN.get());
        tag(BlockTags.SMALL_FLOWERS).add(DEBlocks.END_ROSE.get());
        tag(BlockTags.SAPLINGS).add(DEBlocks.END_SAPLING.get());
        tag(BlockTags.FLOWER_POTS).add(DEBlocks.POTTED_END_ROSE.get(), DEBlocks.POTTED_END_SAPLING.get());
    }
}
