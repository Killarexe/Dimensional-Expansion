package net.killarexe.dimensional_expansion.common.data.generation;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.data.generation.client.DEBlockStateProvider;
import net.killarexe.dimensional_expansion.common.data.generation.client.DEItemModelProvider;
import net.killarexe.dimensional_expansion.common.data.generation.client.lang.DEEnUsProvider;
import net.killarexe.dimensional_expansion.common.data.generation.server.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DEMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DEDataGenerator {

    /*@SubscribeEvent
    public static void gatherData(GatherDataEvent e){
        DataGenerator generator = e.getGenerator();
        ExistingFileHelper helper = e.getExistingFileHelper();

        if(e.includeClient()){
            generator.addProvider(true, new DEBlockStateProvider(generator, helper));
            generator.addProvider(true, new DEItemModelProvider(generator, helper));
            generator.addProvider(true, new DEEnUsProvider(generator));
        }

        if(e.includeServer()){
            DEBlockTagsProvider blockTagsProvider = new DEBlockTagsProvider(generator, helper);
            generator.addProvider(true, blockTagsProvider);
            generator.addProvider(true, new DEItemTagsProvider(generator, blockTagsProvider, helper));
            generator.addProvider(true, new DERecipeProvider(generator));
            generator.addProvider(true, new DELootTableProvider(generator));
            generator.addProvider(true, new DEBiomeTagsProvider(generator, helper));
        }
    }*/
}
