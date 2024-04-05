package net.killarexe.dimensional_expansion.common.data.generation.client.advancement;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

public class DEAdvancementProvider extends ForgeAdvancementProvider{
	public DEAdvancementProvider(PackOutput output, CompletableFuture<Provider> registries, ExistingFileHelper existingFileHelper) {
		super(output, registries, existingFileHelper, List.of(new DEAdvancementGenerator()));
	}
}
