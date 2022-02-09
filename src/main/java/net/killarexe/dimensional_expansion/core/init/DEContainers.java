package net.killarexe.dimensional_expansion.core.init;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.container.EssenceExtractorContainer;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class DEContainers {

    public static final ScreenHandlerType<EssenceExtractorContainer> ESSENCE_EXTRACTOR_CONTAINER = ScreenHandlerRegistry.registerSimple(new Identifier(DEMod.MODID, "essence_extractor"), EssenceExtractorContainer::new);

    public static void registerContainers(){
    }

}
