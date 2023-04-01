package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

public class DEItemTagsProvider extends ItemTagsProvider {
	
	public DEItemTagsProvider(PackOutput pOutput, CompletableFuture<Provider> pLookupProvider, TagsProvider<Block> p_256467_, @Nullable ExistingFileHelper existingFileHelper) {
		super(pOutput, pLookupProvider, p_256467_, DEMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(Provider pProvider) {
        tag(Tags.Items.ORES).add(DEBlocks.PALON_ORE.get().asItem(), DEBlocks.BASSMITE_ORE.get().asItem(),
                DEBlocks.SIMIX_ORE.get().asItem(), DEBlocks.EMERTYST_ORE.get().asItem());
        tag(Tags.Items.INGOTS).add(DEItems.PALON_INGOT.get(), DEItems.SIMIX_INGOT.get());
        tag(Tags.Items.GEMS).add(DEItems.BASSMITE_GEM.get(), DEItems.EMERTYST_GEM.get());

        tag(ItemTags.DIRT).add(DEBlocks.ORIGIN_GRASS_BLOCK.get().asItem());
        tag(ItemTags.LOGS).add(DEBlocks.PURPLEHEART_LOG.get().asItem(), DEBlocks.STRIPPED_PURPLEHEART_LOG.get().asItem());
        tag(ItemTags.PLANKS).add(DEBlocks.PURPLEHEART_PLANKS.get().asItem());
        tag(ItemTags.LEAVES).add(DEBlocks.PURPLEHEART_LEAVES.get().asItem());
        tag(ItemTags.SIGNS).add(DEItems.PURPLEHEART_SIGN.get());
        tag(ItemTags.SMALL_FLOWERS).add(DEBlocks.PURPLE_ROSE.get().asItem());
        tag(ItemTags.SAPLINGS).add(DEBlocks.PURPLEHEART_SAPLING.get().asItem());
    }
}
