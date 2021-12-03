package net.killarexe.dimensional_expansion;

import com.mojang.blaze3d.platform.Window;
import net.killarexe.dimensional_expansion.common.gui.overlay.DimensionalExpensionVersionOverlay;
import net.killarexe.dimensional_expansion.common.gui.screen.WeatherChangerScreen;
import net.killarexe.dimensional_expansion.core.config.DEConfig;
import net.killarexe.dimensional_expansion.core.init.*;
import net.killarexe.dimensional_expansion.uitls.CustomVillagerTrades;
import net.killarexe.dimensional_expansion.world.biome.EndForest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


@Mod("dimensional_expansion")
public class DEMod
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "dimensional_expansion";
    public static final String VERSION = "0.2a";

    public DEMod() {
        LOGGER.info("Starting Init Dimensional Expension");
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        LOGGER.info("Init Dimensional Expension Sounds");
        DESounds.SOUNDS.register(bus);
        LOGGER.info("Init Dimensional Expension Biomes");
        DEBiomes.BIOMES.register(bus);
        DEBiomes.registerBiomes();
        LOGGER.info("Init Dimensional Expension Blocks");
        DEBlocks.BLOCK.register(bus);
        LOGGER.info("Init Dimensional Expension Items");
        DEItems.ITEMS.register(bus);
        LOGGER.info("Init Dimensional Potions Items");
        DEPoitions.EFFECT.register(bus);
        DEPoitions.POTION.register(bus);
        LOGGER.info("Init Dimensional Enchantments");
        DEEnchantments.ENCHANTMENT.register(bus);
        LOGGER.info("Init Dimensional Expension Block Entities");
        DEBlockEntities.BLOCK_ENTITIES.register(bus);
        LOGGER.info("Init Dimensional Expension Villager Proffessions");
        DEVillagerTypes.VILLAGER_PROFESSION.register(bus);
        DEVillagerTypes.POI_TYPE.register(bus);
        LOGGER.info("Init Dimensional Expension Features");
        DEFeatures.FEATURES.register(bus);
        MinecraftForge.EVENT_BUS.addListener(DEFeatures::addFeatures);
        MinecraftForge.EVENT_BUS.addListener(CustomVillagerTrades::addNewTrade);
        MinecraftForge.EVENT_BUS.addListener(DimensionalExpensionVersionOverlay::render);
        MinecraftForge.EVENT_BUS.addListener(DEMod::clientSetup);
        MinecraftForge.EVENT_BUS.addListener(DEMod::commonSetup);
        //MinecraftForge.EVENT_BUS.addListener(DEEnchantments::applyEnchanements);
        LOGGER.info("Init Dimensional Expension Config");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, DEConfig.SPEC, "dimensional_expansion-client.toml");
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Init Dimensional Expension Complete!");
    }

    public static void commonSetup(FMLCommonSetupEvent e){
        EndForest.init();
        DEVillagerTypes.registerPOI(DEVillagerTypes.END_FORGER_POI.get());
    }

    public static void clientSetup(FMLClientSetupEvent e){
        final Window window = Minecraft.getInstance().getWindow();
        window.setTitle("Dimensional Expansion " + DEMod.VERSION);
        if(DEConfig.showIcon.get()) {
            try {
                window.setIcon(Files.newInputStream(Paths.get(FMLPaths.CONFIGDIR.get().toString(), "icon16x16.png"), StandardOpenOption.READ),
                        Files.newInputStream(Paths.get(FMLPaths.CONFIGDIR.get().toString(), "icon32x32.png"), StandardOpenOption.READ));
            } catch (IOException io) {
                DEMod.LOGGER.error(io);
            }
        }

        MenuScreens.register(DEContainers.WEATHER_CHANGER_CONTAINER.get(), WeatherChangerScreen::new);

        DEMod.LOGGER.info("Set Dimensional Expansion Blocks Settings");
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_LEAVES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_TRAPDOOR.get(), RenderType.cutout());
    }
}
