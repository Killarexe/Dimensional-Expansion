package net.killarexe.dimensional_expansion.common.event;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.DEModClient;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.killarexe.dimensional_expansion.common.block.maps.CompostableMap;
import net.killarexe.dimensional_expansion.common.block.maps.FlowerPotMap;
import net.killarexe.dimensional_expansion.common.block.maps.StrippingMap;
import net.killarexe.dimensional_expansion.common.event.villager.DEVillagerTrades;
import net.killarexe.dimensional_expansion.init.*;

public class DEEvents {
	
	public static void addListeners(IEventBus forgeBus, IEventBus modBus) {
        DEMod.LOGGER.info("Set Dimensional Expansion Event Listeners");
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> DEModClient.clientFeatures(modBus, forgeBus));
        forgeBus.addListener(DEVillagerTrades::addTrades);
        modBus.addListener(DEEvents::commonSetup);
        modBus.addListener(DEEntityTypes::registerAttributes);
        modBus.addListener(DECreativeTabs::addItemsToCreativeTabs);
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
