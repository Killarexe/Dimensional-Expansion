package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.killarexe.dimensional_expansion.init.DEItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

public class DEItemTagsProvider extends ItemTagsProvider {
	
	public DEItemTagsProvider(PackOutput pOutput, CompletableFuture<Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> p_256467_, @Nullable ExistingFileHelper existingFileHelper) {
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
        tag(ItemTags.FOX_FOOD).add(DEItems.VIOLET_CARROT.get(), DEItems.SAVORLEAF.get());
        tag(ItemTags.COALS).add(
        		DEItems.PALON_MIXED_COAL.get(), DEItems.BASSMITE_MIXED_COAL.get(),
        		DEItems.SIMIX_MIXED_COAL.get(), DEItems.EMERTYST_MIXED_COAL.get()
        );
        tag(ItemTags.CREEPER_DROP_MUSIC_DISCS).add(
        		DEItems.SWEDEN_DISC.get()
        );
        tag(ItemTags.SAND).add(DEBlocks.BLUE_SAND.get().asItem());
        tag(ItemTags.FENCE_GATES).add(DEBlocks.PURPLEHEART_FENCE_GATE.get().asItem());
        tag(ItemTags.WOODEN_FENCES).add(DEBlocks.PURPLEHEART_FENCE.get().asItem());
        tag(ItemTags.COMPASSES).add(DEItems.COORD_LINKER.get());
        tag(ItemTags.BOATS).add(DEItems.PURPLEHEART_BOAT.get());
        tag(ItemTags.CHEST_BOATS).add(DEItems.PURPLEHEART_CHEST_BOAT.get());
        tag(ItemTags.BEACON_PAYMENT_ITEMS).add(
        		DEItems.PALON_INGOT.get(), DEItems.BASSMITE_GEM.get(), DEItems.SIMIX_INGOT.get(), DEItems.EMERTYST_GEM.get()
        );
    }
}
