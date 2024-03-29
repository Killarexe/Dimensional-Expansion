package net.killarexe.dimensional_expansion.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;

public class DERegistries {

	private static final Logger LOGGER = LogManager.getLogger();
	
	public static void registerAll(IEventBus bus){
		LOGGER.debug("Init Dimensional Expansion Sound Events");
		DESoundEvents.SOUND_EVENTS.register(bus);
        LOGGER.info("Init Dimensional Expansion Creative Tabs");
        DECreativeTabs.CREATIVE_MOD_TABS.register(bus);
        LOGGER.debug("Init Dimensional Expansion Blocks");
        DEBlocks.BLOCK.register(bus);
        LOGGER.info("Init Dimensional Expansion Items");
        DEItems.ITEMS.register(bus);
        LOGGER.debug("Init Dimensional Expansion Effects");
        DEEffects.EFFECTS.register(bus);
        LOGGER.debug("Init Dimensional Expansion Potions");
        DEPoitions.POTION.register(bus);
        LOGGER.debug("Init Dimensional Expansion Block Entities");
        DEBlockEntityTypes.BLOCK_ENTITY_TYPES.register(bus);
        LOGGER.debug("Init Dimensional Expansion Entities");
        DEEntityTypes.ENTITY_TYPES.register(bus);
        LOGGER.debug("Init Dimensional Expansion POIs");
        DEPois.POI_TYPE.register(bus);
        LOGGER.debug("Init Dimensional Expansion Villager Professions");
        DEVillagerTypes.VILLAGER_PROFESSION.register(bus);
        DEVillagerTypes.setTypeByBiome();
        LOGGER.debug("Init Dimensional Expansion Villager Types");
        DEVillagerTypes.VILLAGER_TYPE.register(bus);
        LOGGER.debug("Init Dimensional Expansion Biomes");
        DEBiomes.BIOMES.register(bus);
        DEDimensions.register();
        DEStructures.register();
        DEGameRules.register();
	}
}
