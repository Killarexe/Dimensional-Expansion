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
        super(generator, DEMod.MOD_ID, helper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Blocks.ORES).add(DEBlocks.PALON_ORE.get(), DEBlocks.BASSMITE_ORE.get(),
                DEBlocks.SIMIX_ORE.get(), DEBlocks.EMERTYST_ORE.get());
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(DEBlocks.PALON_ORE.get(), DEBlocks.PALON_BLOCK.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
        		DEBlocks.PALON_ORE.get(),
        		DEBlocks.PALON_BLOCK.get(),
        		DEBlocks.BASSMITE_ORE.get(),
        		DEBlocks.BASSMITE_BLOCK.get(),
        		DEBlocks.SIMIX_ORE.get(),
        		DEBlocks.SIMIX_BLOCK.get(),
        		DEBlocks.EMERTYST_ORE.get(),
        		DEBlocks.EMERTYST_BLOCK.get(),
        		DEBlocks.SULFUR_STONE.get(),
        		DEBlocks.SULFUR_COBBLESTONE.get(),
        		DEBlocks.SULFUR_COBBLESTONE_SLAB.get(),
        		DEBlocks.SULFUR_COBBLESTONE_STAIRS.get(),
        		DEBlocks.SULFUR_STONE_BUTTON.get(),
        		DEBlocks.SULFUR_STONE_PRESSURE_PLATE.get(),
        		DEBlocks.SULFUR_STONE_SLAB.get(),
        		DEBlocks.SULFUR_STONE_STAIRS.get(),
        		DEBlocks.MINERAL_STORAGE.get(),
        		DEBlocks.FORGE.get()
        );
        
        tag(BlockTags.MINEABLE_WITH_AXE).add(
        		DEBlocks.PURPLEHEART_BOOKSHELF.get(),
        		DEBlocks.PURPLEHEART_BUTTON.get(),
        		DEBlocks.PURPLEHEART_DOOR.get(),
        		DEBlocks.PURPLEHEART_FENCE.get(),
        		DEBlocks.PURPLEHEART_FENCE_GATE.get(),
        		DEBlocks.PURPLEHEART_LOG.get(),
        		DEBlocks.PURPLEHEART_PLANKS.get(),
        		DEBlocks.PURPLEHEART_PRESSURE_PLATE.get(),
        		DEBlocks.PURPLEHEART_SIGN.get(),
        		DEBlocks.PURPLEHEART_SLAB.get(),
        		DEBlocks.PURPLEHEART_STAIRS.get(),
        		DEBlocks.PURPLEHEART_TRAPDOOR.get(),
        		DEBlocks.PURPLEHEART_WALL_SIGN.get(),
        		DEBlocks.STRIPPED_PURPLEHEART_LOG.get()
        );
        
        tag(BlockTags.DIRT).add(DEBlocks.ORIGIN_GRASS_BLOCK.get());
        tag(BlockTags.LOGS).add(DEBlocks.PURPLEHEART_LOG.get(), DEBlocks.STRIPPED_PURPLEHEART_LOG.get());
        tag(BlockTags.PLANKS).add(DEBlocks.PURPLEHEART_PLANKS.get());
        tag(BlockTags.LEAVES).add(DEBlocks.PURPLEHEART_LEAVES.get());
        tag(BlockTags.SIGNS).add(DEBlocks.PURPLEHEART_SIGN.get(), DEBlocks.PURPLEHEART_WALL_SIGN.get());
        tag(BlockTags.STANDING_SIGNS).add(DEBlocks.PURPLEHEART_SIGN.get());
        tag(BlockTags.WALL_SIGNS).add(DEBlocks.PURPLEHEART_WALL_SIGN.get());
        tag(BlockTags.SMALL_FLOWERS).add(DEBlocks.PURPLE_ROSE.get());
        tag(BlockTags.SAPLINGS).add(DEBlocks.PURPLEHEART_SAPLING.get());
        tag(BlockTags.FLOWER_POTS).add(DEBlocks.POTTED_PURPLE_ROSE.get(), DEBlocks.POTTED_PURPLEHEART_SAPLING.get());
    }
}
