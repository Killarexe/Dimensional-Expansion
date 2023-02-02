package net.killarexe.dimensional_expansion.common.data.generation;

import java.util.concurrent.CompletableFuture;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.data.generation.client.DEBlockStateProvider;
import net.killarexe.dimensional_expansion.common.data.generation.client.DEItemModelProvider;
import net.killarexe.dimensional_expansion.common.data.generation.client.lang.DEEnUsProvider;
import net.killarexe.dimensional_expansion.common.data.generation.server.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DEMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DEDataGenerator {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent e) {
		DataGenerator generator = e.getGenerator();
		PackOutput output = generator.getPackOutput();
		ExistingFileHelper helper = e.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookupProvider = e.getLookupProvider();
		
		generator.addProvider(e.includeClient(), new DEBlockStateProvider(output, helper));
		generator.addProvider(e.includeClient(), new DEItemModelProvider(output, helper));
		generator.addProvider(e.includeClient(), new DEEnUsProvider(output));
		
		DEBlockTagsProvider blockTagsProvider = new DEBlockTagsProvider(output, lookupProvider);
		generator.addProvider(e.includeServer(), blockTagsProvider);
		generator.addProvider(e.includeServer(), new DEItemTagsProvider(output, lookupProvider, blockTagsProvider, helper));
		generator.addProvider(e.includeServer(), new DELootTableProvider(output));
		generator.addProvider(e.includeServer(), new DEBiomeTagsProvider(output, lookupProvider, helper));
	}
}
