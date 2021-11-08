package net.killarexe.dimensional_expansion;

import com.mojang.blaze3d.platform.Window;
import net.killarexe.dimensional_expansion.core.config.*;
import net.killarexe.dimensional_expansion.core.init.*;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.*;

import java.io.IOException;
import java.nio.file.*;


@Mod("dimensional_expansion")
public class DimensionalExpansionMod
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "dimensional_expansion";
    public static final String VERSION = "0.2a";

    public DimensionalExpansionMod() {
        LOGGER.info("Starting Init Dimensional Expension");
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        LOGGER.info("Init Dimensional Expension Blocks");
        DimensionalExpansionBlocks.BLOCK.register(bus);
        LOGGER.info("Init Dimensional Expension Items");
        DimensionalExpansionItems.ITEMS.register(bus);
        LOGGER.info("Init Dimensional Expension Biomes");
        //DimensionExpansionBiomes.BIOMES.register(bus);
        DimensionExpansionBiomes.registerBiomes();
        LOGGER.info("Init Dimensional Expension Features");
        DimensionalExpansionFeatures.FEATURES.register(bus);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, DimensionalExpansionFeatures::addOres);
        LOGGER.info("Init Dimensional Expension Config");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, DimensionalExpansionConfig.SPEC, "dimensional_expansion-client.toml");
        bus.addListener(this::loadComplete);
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Init Dimensional Expension Complete!");
    }

    private void loadComplete(FMLClientSetupEvent e) {
        final Window window = Minecraft.getInstance().getWindow();
        window.setTitle("Dimensional Expansion " + VERSION);
        try {
            if(DimensionalExpansionConfig.showIcon.get()) {
                window.setIcon(Files.newInputStream(Paths.get(FMLPaths.CONFIGDIR.get().toString(), "icon16x16.png"), StandardOpenOption.READ),
                                Files.newInputStream(Paths.get(FMLPaths.CONFIGDIR.get().toString(), "icon32x32.png"), StandardOpenOption.READ));
            }
        }catch (IOException io){
            LOGGER.error(io);
        }
    }
}
