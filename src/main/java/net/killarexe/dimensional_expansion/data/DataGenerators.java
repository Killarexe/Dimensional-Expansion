package net.killarexe.dimensional_expansion.data;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = DEMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent e){
        DataGenerator generator = e.getGenerator();

        generator.addProvider(new DERecipeProvider(generator));
        generator.addProvider(new DELootTableProvider(generator));
    }
}
