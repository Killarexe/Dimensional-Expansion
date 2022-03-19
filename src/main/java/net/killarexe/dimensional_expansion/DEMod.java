package net.killarexe.dimensional_expansion;

import net.killarexe.dimensional_expansion.client.DEModClient;
import net.killarexe.dimensional_expansion.client.gui.screen.DEConfigScreen;
import net.killarexe.dimensional_expansion.common.block.StrippingMap;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.common.event.DEEvents;
import net.killarexe.dimensional_expansion.core.init.*;
import net.killarexe.dimensional_expansion.server.DEModServer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigGuiHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(DEMod.MODID)
public class DEMod
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "dimensional_expansion";
    public static final String VERSION = "0.6a";

    public DEMod() {
        LOGGER.info("Starting Init Dimensional Expansion");
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        LOGGER.info("Init Dimensional Expansion Sounds");
        DESounds.SOUNDS.register(bus);
        LOGGER.info("Init Dimensional Expansion Biomes");
        DEBiomes.registerBiomes(bus);
        LOGGER.info("Init Dimensional Expansion Blocks");
        DEBlocks.BLOCK.register(bus);
        LOGGER.info("Init Dimensional Expansion Structures");
        DEFeatures.STRUCTURE_FEATURES.register(bus);
        LOGGER.info("Init Dimensional Expansion Items");
        DEItems.ITEMS.register(bus);
        LOGGER.info("Init Dimensional Expansion Recipe Types");
        DERecipeTypes.RECIPE_SERIALIZERS.register(bus);
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
        LOGGER.info("Init Dimensional Expansion Config");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, DEConfig.CLIENT_SPEC, "dimensional_expansion-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, DEConfig.SERVER_SPEC, "dimensional_expansion-server.toml");
        ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () -> new ConfigGuiHandler.ConfigGuiFactory((mc, screen) -> new DEConfigScreen(screen)));
        LOGGER.info("Set Dimensional Expansion Event Listener");
        MinecraftForge.EVENT_BUS.addListener(DEEvents::addFeatures);
        MinecraftForge.EVENT_BUS.addListener(DEEvents::addVillagerFeatures);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> DEModClient.clientFeatures(bus, MinecraftForge.EVENT_BUS));
        DistExecutor.unsafeRunWhenOn(Dist.DEDICATED_SERVER, () -> () -> DEModServer.serverFeatures(bus, MinecraftForge.EVENT_BUS));
        bus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Init Dimensional Expansion Complete!");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Dimensional Expansion Common Setup");
        DEVillagerTypes.registerPOI(DEVillagerTypes.FORGER_POI.get());
        DEVillagerTypes.registerPOI(DEVillagerTypes.FARMER_POI.get());
        DEVillagerTypes.registerPOI(DEVillagerTypes.MINER_POI.get());
        LOGGER.info("Register Dimensional Expansion WoodTypes");
        WoodType.register(DEWoodTypes.END);
        LOGGER.info("Put Dimensional Expansion Strippables");
        StrippingMap.putStrippables(event);
        event.enqueueWork(() ->{
            ComposterBlock.COMPOSTABLES.put(DEItems.HEART_SEEDS.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(DEItems.XP_SEEDS.get(), 0.3f);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DEBlocks.END_ROSE.getId(), () -> DEBlocks.POTTED_END_ROSE.get());
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DEBlocks.END_SAPLING.getId(), () -> DEBlocks.POTTED_END_SAPLING.get());
        });
    }
}
