package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.VanillaBlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class DEBlockTagsProvider extends VanillaBlockTagsProvider {

    public DEBlockTagsProvider(PackOutput pOutput, CompletableFuture<Provider> pLookupProvider) {
		super(pOutput, pLookupProvider);
	}

	@Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(Tags.Blocks.ORES).add(
        		DEBlocks.PALON_ORE.get(),
        		DEBlocks.BASSMITE_ORE.get(),
                DEBlocks.SIMIX_ORE.get(),
                DEBlocks.EMERTYST_ORE.get()
        );
        
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(
        		DEBlocks.PALON_ORE.get(),
        		DEBlocks.PALON_BLOCK.get(),
        		DEBlocks.ORIGIN_FRAME.get(),
        		DEBlocks.DISPLAY_BLOCK.get()
        );

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
        		DEBlocks.BLUE_SANDSTONE.get(),
        		DEBlocks.MINERAL_STORAGE.get(),
        		DEBlocks.ORIGIN_FRAME.get(),
        		DEBlocks.FORGE.get(),
        		DEBlocks.DISPLAY_BLOCK.get()
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
        
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
        		DEBlocks.BLUE_SAND.get(),
        		DEBlocks.ORIGIN_GRASS_BLOCK.get(),
        		DEBlocks.ORIGIN_DIRT.get()
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
