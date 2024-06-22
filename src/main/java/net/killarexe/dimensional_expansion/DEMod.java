package net.killarexe.dimensional_expansion;

import net.killarexe.dimensional_expansion.client.DEModClient;
import net.killarexe.dimensional_expansion.common.block.StrippingMap;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.common.event.DEEvents;
import net.killarexe.dimensional_expansion.core.init.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
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
    public static final String VERSION = "0.5.2a";

    public DEMod() {
        LOGGER.info("Starting Init Dimensional Expansion");
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        LOGGER.info("Init Dimensional Expansion Biomes");
        DEBiomes.registerBiomes(bus);
        LOGGER.info("Init Dimensional Expansion Blocks");
        DEBlocks.BLOCK.register(bus);
        LOGGER.info("Init Dimensional Expansion Structures");
        DEFeatures.STRUCTURE_FEATURES.register(bus);
        LOGGER.info("Init Dimensional Expansion Items");
        DEItems.ITEMS.register(bus);
        LOGGER.info("Init Dimensional Expansion Block Entities");
        DEBlockEntities.BLOCK_ENTITIES.register(bus);
        LOGGER.info("Init Dimensional Expansion Villager Professions");
        DEVillagerTypes.VILLAGER_PROFESSION.register(bus);
        DEVillagerTypes.POI_TYPE.register(bus);
        LOGGER.info("Init Dimensional Expansion Config");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DEConfig.COMMON_SPEC, "dimensional_expansion-common.toml");
        LOGGER.info("Set Dimensional Expansion Event Listener");
        MinecraftForge.EVENT_BUS.addListener(DEEvents::addFeatures);
        MinecraftForge.EVENT_BUS.addListener(DEEvents::addVillagerFeatures);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> DEModClient.clientFeatures(bus));
        bus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Init Dimensional Expansion Complete!");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() ->{
            LOGGER.info("Dimensional Expansion Common Setup");
            LOGGER.info("Register Dimensional Expansion WoodTypes");
            DEWoodTypes.register();
            LOGGER.info("Put Dimensional Expansion Strippables");
            StrippingMap.putStrippables();
            LOGGER.info("Put Dimensional Expansion Compostables");
            ComposterBlock.COMPOSTABLES.put(DEItems.HEART_SEEDS.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(DEItems.XP_SEEDS.get(), 0.3f);
            LOGGER.info("Put Dimensional Expansion Flower Pots");
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DEBlocks.END_ROSE.getId(), DEBlocks.POTTED_END_ROSE::get);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DEBlocks.END_SAPLING.getId(), DEBlocks.POTTED_END_SAPLING::get);
        });
    }
}
