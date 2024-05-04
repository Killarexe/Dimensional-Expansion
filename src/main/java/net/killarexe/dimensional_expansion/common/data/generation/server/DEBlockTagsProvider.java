package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class DEBlockTagsProvider extends IntrinsicHolderTagsProvider<Block> {

    @SuppressWarnings("deprecation")
	public DEBlockTagsProvider(PackOutput pOutput, CompletableFuture<Provider> pLookupProvider, ExistingFileHelper helper) {
		super(pOutput, Registries.BLOCK, pLookupProvider, (block) -> block.builtInRegistryHolder().key(), DEMod.MOD_ID, helper);
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
        		DEBlocks.BASSMITE_ORE.get(),
        		DEBlocks.BASSMITE_BLOCK.get(),
                DEBlocks.SIMIX_ORE.get(),
                DEBlocks.SIMIX_BLOCK.get(),
                DEBlocks.EMERTYST_ORE.get(),
                DEBlocks.EMERTYST_BLOCK.get(),
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
				DEBlocks.SULFUR_STONE_BRICKS.get(),
				DEBlocks.SULFUR_STONE_BRICKS_SLAB.get(),
				DEBlocks.SULFUR_STONE_BRICKS_STAIRS.get(),
				DEBlocks.SULFUR_STONE_BRICKS_WALL.get(),
				DEBlocks.VIOLET_STONE.get(),
				DEBlocks.VIOLET_STONE_SLAB.get(),
				DEBlocks.VIOLET_STONE_STAIRS.get(),
				DEBlocks.VIOLET_STONE_WALL.get(),
        		DEBlocks.BLUE_SANDSTONE.get(),
        		DEBlocks.ORIGIN_FRAME.get(),
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
        	DEBlocks.ORIGIN_DIRT_PATH.get(),
        	DEBlocks.ORIGIN_DIRT.get()
        );
        
        tag(BlockTags.DIRT).add(
        	DEBlocks.ORIGIN_GRASS_BLOCK.get(), 
        	DEBlocks.ORIGIN_DIRT.get()
        );
        
        tag(BlockTags.LOGS).add(
        	DEBlocks.PURPLEHEART_LOG.get(),
        	DEBlocks.STRIPPED_PURPLEHEART_LOG.get()
        );
        
        tag(BlockTags.CROPS).add(
        	DEBlocks.SAVORLEAF_CROP.get(),
        	DEBlocks.VIOLET_CARROT_CROP.get()
        );
        
        tag(BlockTags.SIGNS).add(
        	DEBlocks.PURPLEHEART_SIGN.get(),
        	DEBlocks.PURPLEHEART_WALL_SIGN.get()
        );
        
        tag(BlockTags.BAMBOO_PLANTABLE_ON).add(
        	DEBlocks.ORIGIN_GRASS_BLOCK.get(),
        	DEBlocks.ORIGIN_DIRT.get()
        );
        
        tag(BlockTags.STAIRS).add(
        	DEBlocks.PURPLEHEART_STAIRS.get(),
        	DEBlocks.SULFUR_COBBLESTONE_STAIRS.get(),
        	DEBlocks.SULFUR_STONE_STAIRS.get(),
			DEBlocks.SULFUR_STONE_BRICKS_STAIRS.get(),
			DEBlocks.VIOLET_STONE_STAIRS.get()
        );
        
        tag(BlockTags.WOODEN_STAIRS).add(DEBlocks.PURPLEHEART_STAIRS.get());
        
        tag(BlockTags.SLABS).add(
        	DEBlocks.PURPLEHEART_SLAB.get(),
        	DEBlocks.SULFUR_STONE_SLAB.get(),
        	DEBlocks.SULFUR_COBBLESTONE_SLAB.get(),
			DEBlocks.SULFUR_STONE_BRICKS_SLAB.get(),
			DEBlocks.VIOLET_STONE_SLAB.get()
        );
        
        tag(BlockTags.WOODEN_SLABS).add(DEBlocks.PURPLEHEART_SLAB.get());
        
        tag(BlockTags.WALLS).add(
			DEBlocks.SULFUR_COBBLESTONE_WALL.get(),
			DEBlocks.SULFUR_STONE_BRICKS_WALL.get(),
			DEBlocks.VIOLET_STONE_WALL.get()
		);
        
        tag(BlockTags.DOORS).add(DEBlocks.PURPLEHEART_DOOR.get());
        tag(BlockTags.WOODEN_DOORS).add(DEBlocks.PURPLEHEART_DOOR.get());
        tag(BlockTags.TRAPDOORS).add(DEBlocks.PURPLEHEART_TRAPDOOR.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(DEBlocks.PURPLEHEART_TRAPDOOR.get());
        
        tag(BlockTags.PLANKS).add(DEBlocks.PURPLEHEART_PLANKS.get());
        tag(BlockTags.LEAVES).add(DEBlocks.PURPLEHEART_LEAVES.get());
        tag(BlockTags.STANDING_SIGNS).add(DEBlocks.PURPLEHEART_SIGN.get());
        tag(BlockTags.WALL_SIGNS).add(DEBlocks.PURPLEHEART_WALL_SIGN.get());
        tag(BlockTags.SMALL_FLOWERS).add(DEBlocks.PURPLE_ROSE.get());
        tag(BlockTags.SAPLINGS).add(DEBlocks.PURPLEHEART_SAPLING.get());
        tag(BlockTags.BUTTONS).add(
        	DEBlocks.PURPLEHEART_BUTTON.get(),
        	DEBlocks.SULFUR_STONE_BUTTON.get()
        );
        tag(BlockTags.PRESSURE_PLATES).add(
        	DEBlocks.PURPLEHEART_PRESSURE_PLATE.get(),
        	DEBlocks.SULFUR_STONE_PRESSURE_PLATE.get()
        );
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(DEBlocks.PURPLEHEART_PRESSURE_PLATE.get());
        tag(BlockTags.FLOWER_POTS).add(
        		DEBlocks.POTTED_PURPLE_ROSE.get(),
        		DEBlocks.POTTED_PURPLEHEART_SAPLING.get(),
        		DEBlocks.POTTED_PURPLEISH_CACTUS.get()
        );
        tag(BlockTags.DEAD_BUSH_MAY_PLACE_ON).add(DEBlocks.BLUE_SAND.get());
    }
}
