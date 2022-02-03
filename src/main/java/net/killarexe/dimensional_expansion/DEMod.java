package net.killarexe.dimensional_expansion;

import net.killarexe.dimensional_expansion.common.gui.screen.DEConfigScreen;
import net.killarexe.dimensional_expansion.common.gui.screen.DimensionalExpansionVersionOverlay;
import net.killarexe.dimensional_expansion.common.gui.screen.EssenceExtractorScreen;
import net.killarexe.dimensional_expansion.core.config.DEConfig;
import net.killarexe.dimensional_expansion.core.init.*;
import net.killarexe.dimensional_expansion.client.event.DEEvents;
import net.killarexe.dimensional_expansion.core.uitls.StrippingMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.client.ConfigGuiHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.*;


@Mod("dimensional_expansion")
public class DEMod
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "dimensional_expansion";
    public static final String VERSION = "0.4a";

    public DEMod() {
        LOGGER.info("Starting Init Dimensional Expansion");
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        LOGGER.info("Init Dimensional Expansion Sounds");
        DESounds.SOUNDS.register(bus);
        LOGGER.info("Init Dimensional Expansion Biomes");
        DEBiomes.registerBiomes(bus);
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
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, DEConfig.CLIENT_SPEC, "dimensional_expansion-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, DEConfig.SERVER_SPEC, "dimensional_expansion-server.toml");
        ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () -> new ConfigGuiHandler.ConfigGuiFactory((mc, screen) -> new DEConfigScreen(screen)));
        LOGGER.info("Init Dimensional Expansion Recipe Types");
        DERecipeTypes.register(bus);
        LOGGER.info("Set Dimensional Expansion Event Listener");
        MinecraftForge.EVENT_BUS.addListener(DEEvents::addFeatures);
        MinecraftForge.EVENT_BUS.addListener(DEEvents::addNewTrade);
        MinecraftForge.EVENT_BUS.addListener(DEEvents::onScreenPost);
        MinecraftForge.EVENT_BUS.addListener(DimensionalExpansionVersionOverlay::render);
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Init Dimensional Expansion Complete!");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Dimensional Expansion Common Setup");
        Minecraft.getInstance().getWindow().setTitle("Dimensional Expansion " + DEMod.VERSION);
        DEVillagerTypes.registerPOI(DEVillagerTypes.FORGER_POI.get());
        DEVillagerTypes.registerPOI(DEVillagerTypes.FARMER_POI.get());
        DEVillagerTypes.registerPOI(DEVillagerTypes.MINER_POI.get());
        LOGGER.info("Register Dimensional Expansion WoodTypes");
        WoodType.register(DEWoodTypes.END);
        LOGGER.info("Put Dimensional Expansion Strippables");
        StrippingMap.putStrippables(event);
    }

    private void clientSetup(final FMLClientSetupEvent event){
        LOGGER.info("Dimensional Expansion Client Setup");
        Minecraft.getInstance().getWindow().setTitle("Dimensional Expansion " + DEMod.VERSION);
        LOGGER.info("Add Dimensional Expansion WoodTypes");
        DEWoodTypes.setWoodTypes();
        LOGGER.info("Set Dimensional Expansion Block Entity Renders");
        BlockEntityRenderers.register(DEBlockEntities.END_SIGN.get(), SignRenderer::new);
        LOGGER.info("Set Dimensional Expansion Blocks Settings");
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_LEAVES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.XP_CROPS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.HEALTH_CROPS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.ESSENCE_EXTRACTOR.get(), RenderType.cutout());
        LOGGER.info("Register Dimensional Expansion Container");
        MenuScreens.register(DEContainers.ESSENCE_EXTRACTOR_CONTAINER.get(), EssenceExtractorScreen::new);
    }
}
