package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.neoforged.bus.api.IEventBus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DERegistries {

	private static final Logger LOGGER = LogManager.getLogger();
	
	public static void registerAll(IEventBus bus){
		LOGGER.debug("Init Dimensional Expansion Sound Events");
		DESoundEvents.SOUND_EVENTS.register(bus);
        LOGGER.debug("Init Dimensional Expansion Jukebox Sounds");
        DEJukeboxSongs.register();
        LOGGER.debug("Init Dimensional Expansion Blocks");
        DEBlocks.BLOCK.register(bus);
        LOGGER.info("Init Dimensional Expansion Items");
        DEItems.ITEMS.register(bus);
        LOGGER.debug("Init Dimensional Expansion Villager Types");
        DEVillagerTypes.setTypeByBiome();
        DEVillagerTypes.VILLAGER_TYPE.register(bus);
        LOGGER.debug("Init Dimensional Expansion Armor Matrerials");
        DEArmorMaterials.ARMOR_MATERIAL.register(bus);
        LOGGER.info("Init Dimensional Expansion Creative Tabs");
        DECreativeTabs.CREATIVE_MOD_TABS.register(bus);
        LOGGER.debug("Init Dimensional Expansion Block Entities");
        DEBlockEntityTypes.BLOCK_ENTITY_TYPES.register(bus);
        LOGGER.debug("Init Dimensional Expansion Entities");
        DEEntityTypes.ENTITY_TYPES.register(bus);
        LOGGER.debug("Init Dimensional Expansion Biomes");
        DEBiomes.register();
        DEMod.LOGGER.info("Init Dimensional Expansion Dimensions");
        DEDimensions.register();
        DEMod.LOGGER.info("Init Dimensional Expansion Structures");
        DEStructures.register();
	}
}
