package net.killarexe.dimensional_expansion.client;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.event.DEEventsClient;
import net.killarexe.dimensional_expansion.client.gui.screen.DEInfoOverlay;
import net.killarexe.dimensional_expansion.client.gui.screen.EnchantTransferTableScreen;
import net.killarexe.dimensional_expansion.client.gui.screen.EssenceExtractorScreen;
import net.killarexe.dimensional_expansion.client.gui.screen.config.DEConfigScreen;
import net.killarexe.dimensional_expansion.client.integration.discord.DiscordUtils;
import net.killarexe.dimensional_expansion.client.render.blockentity.DisplayBlockRenderer;
import net.killarexe.dimensional_expansion.client.render.entity.PurpleheartBoatRenderer;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.core.init.*;
import net.killarexe.dimensional_expansion.utils.DEWindowUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class DEModClient {

    public static final Logger LOGGER = LogManager.getLogger();

    public static void clientFeatures(IEventBus bus, IEventBus forgeEventBus){
        forgeEventBus.addListener(DEEventsClient::onScreenPost);
        forgeEventBus.addListener(DEEventsClient::onKeyInput);
        forgeEventBus.addListener(DEInfoOverlay::render);
        bus.addListener(DEModClient::clientSetup);
    }

    private static void clientSetup(final FMLClientSetupEvent event){
    	event.enqueueWork(() ->{
	        LOGGER.info("Dimensional Expansion Client Setup...");
	        DEWindowUtils.setWindowTitle("Dimensional Expansion " + DEMod.VERSION + " Client Setup...");
	        ModLoadingContext.get().registerExtensionPoint(
	                ConfigScreenHandler.ConfigScreenFactory.class,
	                () -> new ConfigScreenHandler.ConfigScreenFactory((mc, screen) -> new DEConfigScreen(screen))
	        );
	        LOGGER.info("Add Dimensional Expansion WoodTypes");
	        DEWindowUtils.setWindowTitle("Dimensional Expansion " + DEMod.VERSION + " WoodTypes");
	        DEWoodTypes.setWoodTypes();
	        LOGGER.info("Set Dimensional Expansion Block Entity Renders");
	        DEWindowUtils.setWindowTitle("Dimensional Expansion " + DEMod.VERSION + "Block Entity Renders");
	        BlockEntityRenderers.register(DEBlockEntityTypes.PURPLEHEART_SIGN.get(), SignRenderer::new);
	        BlockEntityRenderers.register(DEBlockEntityTypes.DISPLAY_BLOCK.get(), DisplayBlockRenderer::new);
	        LOGGER.info("Set Dimensional Expansion Entity Renders");
	        DEWindowUtils.setWindowTitle("Dimensional Expansion " + DEMod.VERSION + " Entity Renders");
	        EntityRenderers.register(DEEntityTypes.END_BOAT.get(), PurpleheartBoatRenderer::new);
	        LOGGER.info("Register Dimensional Expansion Container");
	        DEWindowUtils.setWindowTitle("Dimensional Expansion " + DEMod.VERSION + " Containers");
	        MenuScreens.register(DEMenuTypes.ESSENCE_EXTRACTOR_MENU_TYPE.get(), EssenceExtractorScreen::new);
	        MenuScreens.register(DEMenuTypes.ENCHANT_TRANSFER_TABLE_MENU_TYPE.get(), EnchantTransferTableScreen::new);
	        LOGGER.info("Add Dimensional Expansion Items Properties");
	        DEWindowUtils.setWindowTitle("Dimensional Expansion " + DEMod.VERSION + " Items Properties");
	        DEItems.addItemsProperites();
	        LOGGER.info("Set Dimensional Expansion Window Icon...");
	        DEWindowUtils.setWindowIcon(
	        		new ResourceLocation(DEMod.MOD_ID, "textures/icons/icon16x16.png"),
	        		new ResourceLocation(DEMod.MOD_ID, "textures/icons/icon32x32.png")
	        );
	        if(DEConfig.discordRPC.get()) {
	        	DEWindowUtils.setWindowTitle("Dimensional Expansion " + DEMod.VERSION + " Discord RPC");
	        	LOGGER.info("Init Dimensional Expansion Discord RPC");
	        	DiscordUtils.start();
	        }
	        DEWindowUtils.setWindowTitle("Dimensional Expansion " + DEMod.VERSION + " Client Setup Complete!");
    	});
    }
}
