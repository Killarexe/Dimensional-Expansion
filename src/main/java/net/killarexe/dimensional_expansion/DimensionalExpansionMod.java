package net.killarexe.dimensional_expansion;

import net.killarexe.dimensional_expansion.core.config.DimensionalExpansionConfig;
import net.killarexe.dimensional_expansion.core.init.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.*;

@Mod("dimensional_expansion")
public class DimensionalExpansionMod
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "dimensional_expansion";

    public DimensionalExpansionMod() {
        LOGGER.info("Starting Init Dimensional Expension");
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        LOGGER.info("Init Dimensional Expension Blocks");
        DimensionalExpansionBlocks.BLOCK.register(bus);
        LOGGER.info("Init Dimensional Expension Items");
        DimensionalExpansionItems.ITEMS.register(bus);
        LOGGER.info("Init Dimensional Expension Biomes");
        //DimensionExpansionBiomes.BIOMES.register(bus);
        //DimensionExpansionBiomes.registerBiomes();
        LOGGER.info("Init Dimensional Expension Features");
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, DimensionalExpansionFeatures::addOres);
        LOGGER.info("Init Dimensional Expension Config");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, DimensionalExpansionConfig.SPEC, "dimensional_expansion-client.toml");
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Init Dimensional Expension Complete!");
    }

}
