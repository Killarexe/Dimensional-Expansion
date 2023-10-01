package net.killarexe.dimensional_expansion;

import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.common.event.DEEvents;
import net.killarexe.dimensional_expansion.init.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DEMod.MOD_ID)
public class DEMod {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "dimensional_expansion";
	public static final String VERSION = "0.9.2a";

	public DEMod() {
		LOGGER.info("Starting Init Dimensional Expansion");
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		DERegistries.registerAll(bus);
		DEConfig.registerAll();
		DEEvents.addListeners(MinecraftForge.EVENT_BUS, bus);
		MinecraftForge.EVENT_BUS.register(this);
		LOGGER.info("Dimensional Expansion Init Complete!");
	}
}
