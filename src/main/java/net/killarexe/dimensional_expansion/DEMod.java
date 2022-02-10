package net.killarexe.dimensional_expansion;

import net.fabricmc.api.ModInitializer;
import net.killarexe.dimensional_expansion.core.config.DEConfigs;
import net.killarexe.dimensional_expansion.core.init.*;
import org.apache.logging.log4j.*;

public class DEMod implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "dimensional_expansion";
    public static final String VERSION = "0.1a";

    @Override
    public void onInitialize() {
        DEConfigs.registerConfigs();
        DEItems.registerItems();
        DEBlocks.registerBlocks();
        DEContainers.registerContainers();
        DERecipeTypes.registerRecipeTypes();
        DEBlockEntities.registerBlockEntities();
        DEFeatures.registerFeatures();
        //DEVillagerTypes.registerVillagerTypes();
    }
}
