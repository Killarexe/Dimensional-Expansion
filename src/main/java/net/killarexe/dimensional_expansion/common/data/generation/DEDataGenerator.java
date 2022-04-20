package net.killarexe.dimensional_expansion.common.data.generation;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.data.generation.client.DEBlockStateProvider;
import net.killarexe.dimensional_expansion.common.data.generation.client.DEItemModelProvider;
import net.killarexe.dimensional_expansion.common.data.generation.client.lang.DEEnUsProvider;
import net.killarexe.dimensional_expansion.common.data.generation.server.DEBlockTagsProvider;
import net.killarexe.dimensional_expansion.common.data.generation.server.DEItemTagsProvider;
import net.killarexe.dimensional_expansion.common.data.generation.server.DELootTableProvider;
import net.killarexe.dimensional_expansion.common.data.generation.server.DERecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = DEMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DEDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent e){
        DataGenerator generator = e.getGenerator();
        ExistingFileHelper helper = e.getExistingFileHelper();

        if(e.includeClient()){
            generator.addProvider(new DEBlockStateProvider(generator, helper));
            generator.addProvider(new DEItemModelProvider(generator, helper));
            generator.addProvider(new DEEnUsProvider(generator));
        }

        if(e.includeServer()){
            //Data Pack Generation

            DEBlockTagsProvider blockTagsProvider = new DEBlockTagsProvider(generator, helper);
            generator.addProvider(blockTagsProvider);
            generator.addProvider(new DEItemTagsProvider(generator, blockTagsProvider, helper));
            generator.addProvider(new DERecipeProvider(generator));
            generator.addProvider(new DELootTableProvider(generator));
        }
    }
}
