package net.killarexe.dimensional_expansion.common.data.generation;

import java.util.concurrent.CompletableFuture;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.data.generation.client.DEBlockStateProvider;
import net.killarexe.dimensional_expansion.common.data.generation.client.DEItemModelProvider;
import net.killarexe.dimensional_expansion.common.data.generation.client.advancement.DEAdvancementProvider;
import net.killarexe.dimensional_expansion.common.data.generation.client.lang.DEEnUsProvider;
import net.killarexe.dimensional_expansion.common.data.generation.server.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = DEMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DEDataGenerator {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent e) {
		DataGenerator generator = e.getGenerator();
		PackOutput output = generator.getPackOutput();
		ExistingFileHelper helper = e.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookupProvider = e.getLookupProvider();
		
		DEMod.LOGGER.info("Generating Dimensional Expansion BlockStates / Block Models...");
		generator.addProvider(e.includeClient(), new DEBlockStateProvider(output, helper));
		DEMod.LOGGER.info("Generating Dimensional Expansion Item Models...");
		generator.addProvider(e.includeClient(), new DEItemModelProvider(output, helper));
		DEMod.LOGGER.info("Generating Dimensional Expansion Advencement Files...");
		generator.addProvider(e.includeClient(), new DEAdvancementProvider(output, lookupProvider, helper));
		DEMod.LOGGER.info("Generating Dimensional Expansion Lang Files...");
		generator.addProvider(e.includeClient(), new DEEnUsProvider(output));
		DEMod.LOGGER.info("Generating Dimensional Expansion LootTables...");
		generator.addProvider(e.includeServer(), new DELootTableProvider(output, lookupProvider));
		DEMod.LOGGER.info("Generating Dimensional Expansion Biome Tags...");
		generator.addProvider(e.includeServer(), new DEBiomeTagsProvider(output, lookupProvider, helper));
		DEMod.LOGGER.info("Generating Dimensional Expansion Block Tags...");
		DEBlockTagsProvider blockTagsProvider = new DEBlockTagsProvider(output, lookupProvider, helper);
		generator.addProvider(e.includeServer(), blockTagsProvider);
		DEMod.LOGGER.info("Generating Dimensional Expansion Item Tags...");
		generator.addProvider(e.includeServer(), new DEItemTagsProvider(output, lookupProvider, blockTagsProvider.contentsGetter(), helper));
		DEMod.LOGGER.info("Generating Dimensional Expansion Recipes...");
		generator.addProvider(e.includeServer(), new DERecipeProvider(output, lookupProvider));
		DEMod.LOGGER.info("Generating Dimensional Expansion Sound Definitions...");
		generator.addProvider(e.includeServer(), new DESoundDefinitions(output, helper));
	}
}
