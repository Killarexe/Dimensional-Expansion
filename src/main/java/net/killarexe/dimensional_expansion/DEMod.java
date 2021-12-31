package net.killarexe.dimensional_expansion;

import net.fabricmc.api.ModInitializer;
import net.killarexe.dimensional_expansion.core.config.DEConfigs;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.killarexe.dimensional_expansion.core.init.DEFeatures;
import net.killarexe.dimensional_expansion.core.init.DEItems;
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
        DEFeatures.registerFeatures();
    }
}
