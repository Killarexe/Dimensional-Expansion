package net.killarexe.dimensional_expansion.common.event;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.killarexe.dimensional_expansion.common.block.maps.CompostableMap;
import net.killarexe.dimensional_expansion.common.block.maps.FlowerPotMap;
import net.killarexe.dimensional_expansion.common.block.maps.StrippingMap;
import net.killarexe.dimensional_expansion.init.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

public class DEEvents {
	
	public static void addListeners(IEventBus bus) {
        DEMod.LOGGER.info("Set Dimensional Expansion Event Listeners");
        bus.addListener(DEEvents::commonSetup);
        bus.addListener(DEEntityTypes::registerAttributes);
        bus.addListener(DECreativeTabs::addItemsToCreativeTabs);
	}
	
	private static void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() ->{
        	DEMod.LOGGER.info("Dimensional Expansion Common Setup");
        	DEMod.LOGGER.info("Register Dimensional Expansion WoodTypes");
        	WoodType.register(DEWoodTypes.PURPLEHEART);
        	DEMod.LOGGER.info("Put Dimensional Expansion Strippables");
        	StrippingMap.putStrippables();
        	DEMod.LOGGER.info("Put Dimensional Expansion Compostables");
        	CompostableMap.putCompostables();
        	DEMod.LOGGER.info("Put Dimensional Expansion Flower Pots");
        	FlowerPotMap.putFlowers();
        	DEMod.LOGGER.info("Dimensional Expansion Common Setup Complete");
        });
    }
    
}
