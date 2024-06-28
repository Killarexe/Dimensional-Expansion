package net.killarexe.dimensional_expansion.common.data.generation.client.advancement;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DEAdvancementProvider extends AdvancementProvider {
	public DEAdvancementProvider(PackOutput output, CompletableFuture<Provider> registries, ExistingFileHelper existingFileHelper) {
		super(output, registries, existingFileHelper, List.of(new DEAdvancementGenerator()));
	}
}
