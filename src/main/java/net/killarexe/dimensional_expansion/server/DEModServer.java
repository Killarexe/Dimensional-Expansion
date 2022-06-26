package net.killarexe.dimensional_expansion.server;

import net.minecraftforge.eventbus.api.IEventBus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DEModServer {

    public static final Logger LOGGER = LogManager.getLogger();

    public static void serverFeatures(IEventBus bus, IEventBus forgeEventBus){
        LOGGER.info("Running Dimensional Expansion Server.");
    }

    
}
