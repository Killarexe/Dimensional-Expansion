package net.killarexe.dimensional_expansion;

import net.killarexe.dimensional_expansion.common.event.DEEvents;
import net.killarexe.dimensional_expansion.init.*;
import net.minecraft.resources.ResourceLocation;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DEMod.MOD_ID)
public class DEMod {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "dimensional_expansion";
	public static final String VERSION = "0.9.4a";

	public DEMod(IEventBus bus) {
		LOGGER.info("Starting Init Dimensional Expansion");
		DERegistries.registerAll(bus);
		DEEvents.addListeners(bus);
		LOGGER.info("Dimensional Expansion Init Complete!");
	}
	
	public static ResourceLocation res(String location) {
		return ResourceLocation.fromNamespaceAndPath(DEMod.MOD_ID, location);
	}
}
