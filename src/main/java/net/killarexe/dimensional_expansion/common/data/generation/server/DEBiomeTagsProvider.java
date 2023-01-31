package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

public class DEBiomeTagsProvider extends BiomeTagsProvider {

	public DEBiomeTagsProvider(PackOutput pOutput, CompletableFuture<Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(pOutput, pProvider, DEMod.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(Provider pProvider) {
		super.addTags(pProvider);
	}
}
