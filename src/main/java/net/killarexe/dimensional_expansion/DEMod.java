package net.killarexe.dimensional_expansion;

import com.mojang.blaze3d.platform.Window;
import net.killarexe.dimensional_expansion.common.gui.overlay.DimensionalExpensionVersionOverlay;
import net.killarexe.dimensional_expansion.common.gui.screen.WeatherChangerScreen;
import net.killarexe.dimensional_expansion.core.config.DEConfig;
import net.killarexe.dimensional_expansion.core.init.*;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("dimensional_expansion")
public class DEMod
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "dimensional_expansion";
    public static final String VERSION = "0.2.5a";

    public DEMod() {
        LOGGER.info("Starting Init Dimensional Expansion");
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        LOGGER.info("Init Dimensional Expansion Sounds");
        DESounds.SOUNDS.register(bus);
        LOGGER.info("Init Dimensional Expansion Biomes");
        DEBiomes.BIOMES.register(bus);
        DEBiomes.registerBiomes();
        LOGGER.info("Init Dimensional Expansion Blocks");
        DEBlocks.BLOCK.register(bus);
        LOGGER.info("Init Dimensional Expansion Items");
        DEItems.ITEMS.register(bus);
        LOGGER.info("Init Dimensional Potions Items");
        DEPoitions.EFFECT.register(bus);
        DEPoitions.POTION.register(bus);
        LOGGER.info("Init Dimensional Enchantments");
        DEEnchantments.ENCHANTMENT.register(bus);
        LOGGER.info("Init Dimensional Expansion Block Entities");
        DEBlockEntities.BLOCK_ENTITIES.register(bus);
        LOGGER.info("Init Dimensional Expansion Containers");
        DEContainers.CONTAINERS.register(bus);
        LOGGER.info("Init Dimensional Expansion Villager Professions");
        DEVillagerTypes.VILLAGER_PROFESSION.register(bus);
        DEVillagerTypes.POI_TYPE.register(bus);
        LOGGER.info("Init Dimensional Expansion Features");
        DEFeatures.FEATURES.register(bus);
        LOGGER.info("Init Dimensional Expansion Config");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, DEConfig.SPEC, "dimensional_expansion-client.toml");

        MinecraftForge.EVENT_BUS.addListener(DEEvents::addFeatures);
        MinecraftForge.EVENT_BUS.addListener(DEEvents::addNewTrade);
        MinecraftForge.EVENT_BUS.addListener(DimensionalExpensionVersionOverlay::render);
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Init Dimensional Expension Complete!");
    }

    private void commonSetup(final FMLCommonSetupEvent event){
        LOGGER.info("Dimensional Expansion Common Setup");
        DEVillagerTypes.registerPOI(DEVillagerTypes.END_FORGER_POI.get());
    }

    private void clientSetup(final FMLClientSetupEvent event){
        LOGGER.info("Dimensional Expansion Client Setup");
        final Window window = Minecraft.getInstance().getWindow();
        window.setTitle("Dimensional Expansion " + DEMod.VERSION);

        MenuScreens.register(DEContainers.WEATHER_CHANGER_CONTAINER.get(), WeatherChangerScreen::new);

        LOGGER.info("Set Dimensional Expansion Blocks Settings");
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_LEAVES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_TRAPDOOR.get(), RenderType.cutout());
    }
}
