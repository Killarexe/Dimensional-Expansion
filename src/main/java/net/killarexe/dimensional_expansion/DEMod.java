package net.killarexe.dimensional_expansion;

import net.killarexe.dimensional_expansion.common.gui.overlay.DimensionalExpensionVersionOverlay;
import net.killarexe.dimensional_expansion.core.config.*;
import net.killarexe.dimensional_expansion.core.init.*;
import net.killarexe.dimensional_expansion.uitls.ClientEventBusSubscriber;
import net.killarexe.dimensional_expansion.uitls.CustomVillagerTrades;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.*;


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
        LOGGER.info("Init Dimensional Expension Blocks");
        DEBlocks.BLOCK.register(bus);
        LOGGER.info("Init Dimensional Expension Items");
        DEItems.ITEMS.register(bus);
        LOGGER.info("Init Dimensional Potions Items");
        DEPoitions.EFFECT.register(bus);
        DEPoitions.POTION.register(bus);
        LOGGER.info("Init Dimensional Enchantments");
        DEEnchantments.ENCHANTMENT.register(bus);
        LOGGER.info("Init Dimensional Expension Biomes");
        LOGGER.info("Init Dimensional Expension Block Entities");
        DEBlockEntities.BLOCK_ENTITIES.register(bus);
        LOGGER.info("Init Dimensional Expension Villager Proffessions");
        DEVillagerTypes.POI_TYPE.register(bus);
        DEVillagerTypes.VILLAGER_PROFESSION.register(bus);
        LOGGER.info("Init Dimensional Expension Features");
        DEFeatures.FEATURES.register(bus);
        MinecraftForge.EVENT_BUS.addListener(DEFeatures::addOres);
        MinecraftForge.EVENT_BUS.addListener(CustomVillagerTrades::addNewTrade);
        MinecraftForge.EVENT_BUS.addListener(DimensionalExpensionVersionOverlay::render);
        MinecraftForge.EVENT_BUS.addListener(ClientEventBusSubscriber::clientSetup);
        MinecraftForge.EVENT_BUS.addListener(DEMod::commonSetup);
        //MinecraftForge.EVENT_BUS.addListener(DEEnchantments::applyEnchanements);
        LOGGER.info("Init Dimensional Expension Config");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, DEConfig.SPEC, "dimensional_expansion-client.toml");
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Init Dimensional Expension Complete!");
    }

    @SubscribeEvent
    private static void commonSetup(FMLCommonSetupEvent e){
    }
}
