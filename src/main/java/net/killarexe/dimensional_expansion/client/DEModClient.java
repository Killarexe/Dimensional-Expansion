package net.killarexe.dimensional_expansion.client;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.event.DEEventsClient;
import net.killarexe.dimensional_expansion.client.gui.screen.DEInfoOverlay;
import net.killarexe.dimensional_expansion.client.gui.screen.EssenceExtractorScreen;
import net.killarexe.dimensional_expansion.client.gui.screen.config.DEConfigScreen;
import net.killarexe.dimensional_expansion.client.integration.discord.DiscordRPC;
import net.killarexe.dimensional_expansion.client.models.BlueSandManModel;
import net.killarexe.dimensional_expansion.client.models.HeadedSkeletonModel;
import net.killarexe.dimensional_expansion.client.models.JugerModel;
import net.killarexe.dimensional_expansion.client.models.MouvetModel;
import net.killarexe.dimensional_expansion.client.render.blockentity.*;
import net.killarexe.dimensional_expansion.client.render.entity.*;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.init.*;
import net.killarexe.dimensional_expansion.io.WindowManager;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.client.ForgeHooksClient;
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
        bus.addListener(DEKeyBindings::onKeyRegister);
        bus.addListener(DEModClient::clientSetup);
    }
    
    private static void clientSetup(final FMLClientSetupEvent event){
    	event.enqueueWork(() ->{
	        setWindowTitle("Dimensional Expansion Client Setup...", "Client Setup...");
	        ModLoadingContext.get().registerExtensionPoint(
	                ConfigScreenHandler.ConfigScreenFactory.class,
	                () -> new ConfigScreenHandler.ConfigScreenFactory((mc, screen) -> new DEConfigScreen(screen))
	        );
	        setWindowTitle("Add Dimensional Expansion WoodTypes", "WoodTypes...");
	        DEWoodTypes.setWoodTypes();
	        setWindowTitle("Set Dimensional Expansion Layer Definitions", "Layer Definitions...");
	        ForgeHooksClient.registerLayerDefinition(HeadedSkeletonModel.LAYER_LOCATION, HeadedSkeletonModel::createBodyLayer);
	        ForgeHooksClient.registerLayerDefinition(BlueSandManModel.LAYER_LOCATION, BlueSandManModel::createBodyLayer);
	        ForgeHooksClient.registerLayerDefinition(MouvetModel.LAYER_LOCATION, MouvetModel::createBodyLayer);
	        ForgeHooksClient.registerLayerDefinition(JugerModel.LAYER_LOCATION, JugerModel::createBodyLayer);
	        setWindowTitle("Set Dimensional Expansion Block Entity Renders", "Block Entity Renders...");
	        BlockEntityRenderers.register(DEBlockEntityTypes.PURPLEHEART_SIGN.get(), SignRenderer::new);
	        BlockEntityRenderers.register(DEBlockEntityTypes.DISPLAY_BLOCK.get(), DisplayBlockRenderer::new);
	        BlockEntityRenderers.register(DEBlockEntityTypes.ENCHANT_TRANSFER_TABLE.get(), EnchantTransferTableRenderer::new);
	        setWindowTitle("Set Dimensional Expansion Entity Renders", "Entity Renders...");
	        EntityRenderers.register(DEEntityTypes.DE_BOAT.get(), PurpleheartBoatRenderer::new);
	        EntityRenderers.register(DEEntityTypes.DE_CHEST_BOAT.get(), PurpleheartChestBoatRenderer::new);
	        EntityRenderers.register(DEEntityTypes.HEADED_SKELETON.get(), HeadedSkeletonRenderer::new);
	        EntityRenderers.register(DEEntityTypes.HEADED_GUARDIAN.get(), HeadedGuardianRenderer::new);
	        EntityRenderers.register(DEEntityTypes.BLUE_SAND_MAN.get(), BlueSandManRenderer::new);
	        EntityRenderers.register(DEEntityTypes.MOUVET.get(), MouvetRenderer::new);
	        EntityRenderers.register(DEEntityTypes.JUGER.get(), JugerRenderer::new);
	        setWindowTitle("Register Dimensional Expansion Container", "Containers...");
	        MenuScreens.register(DEMenuTypes.ESSENCE_EXTRACTOR_MENU_TYPE.get(), EssenceExtractorScreen::new);
	        setWindowTitle("Add Dimensional Expansion Items Properties", "Items Properties...");
	        DEItems.addItemsProperites();
	        setWindowTitle("Set Dimensional Expansion Window Icon...", "Window Icon...");
	        WindowManager.setWindowIcon(
	        		new ResourceLocation(DEMod.MOD_ID, "textures/icons/icon16x16.png"),
	        		new ResourceLocation(DEMod.MOD_ID, "textures/icons/icon32x32.png")
	        );
	        if(DEConfig.discordRPC.get()) {
	        	setWindowTitle("Init Dimensional Expansion Discord RPC", "Discord RPC...");
	        	DiscordRPC.start();
	        }
	        setWindowTitle("Dimensional Expansion Client Setup Complete!", "Client Setup Complete!");
    	});
    }
    
    private static void setWindowTitle(String loggerMessage, String title) {
    	LOGGER.debug(loggerMessage);
    	WindowManager.setWindowTitle("Dimensional Expansion " + DEMod.VERSION + " " + title);
    }
}
