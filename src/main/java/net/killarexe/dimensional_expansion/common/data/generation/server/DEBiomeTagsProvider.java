package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.init.DEBiomes;
import net.killarexe.dimensional_expansion.init.DETags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;

import java.util.concurrent.CompletableFuture;

import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class DEBiomeTagsProvider extends BiomeTagsProvider {

	public DEBiomeTagsProvider(PackOutput pOutput, CompletableFuture<Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(pOutput, pProvider, DEMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(Provider pProvider) {
		tag(DETags.IS_ORIGIN).add(DEBiomes.BLUE_SAND_DESERT, DEBiomes.ORIGIN_DEADLAND, DEBiomes.ORIGIN_PLAINS, DEBiomes.PURPLEHEART_FOREST);
	}
}
