package net.killarexe.dimensional_expansion.client;

import net.killarexe.dimensional_expansion.client.models.BlueSandManModel;
import net.killarexe.dimensional_expansion.client.models.HeadedSkeletonModel;
import net.killarexe.dimensional_expansion.client.models.JugerModel;
import net.killarexe.dimensional_expansion.client.models.MouvetModel;
import net.killarexe.dimensional_expansion.client.render.blockentity.*;
import net.killarexe.dimensional_expansion.client.render.entity.*;
import net.killarexe.dimensional_expansion.init.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class DEModClient {

    public static final Logger LOGGER = LogManager.getLogger();

    public static void clientFeatures(IEventBus bus, IEventBus forgeEventBus){
        bus.addListener(DEModClient::clientSetup);
    }
    
    private static void clientSetup(final FMLClientSetupEvent event){
    	event.enqueueWork(() ->{
	        setWindowTitle("Wood Types");
	        DEWoodTypes.setWoodTypes();
	        setWindowTitle("Layer Definitions");
	        ForgeHooksClient.registerLayerDefinition(HeadedSkeletonModel.LAYER_LOCATION, HeadedSkeletonModel::createBodyLayer);
	        ForgeHooksClient.registerLayerDefinition(BlueSandManModel.LAYER_LOCATION, BlueSandManModel::createBodyLayer);
	        ForgeHooksClient.registerLayerDefinition(MouvetModel.LAYER_LOCATION, MouvetModel::createBodyLayer);
	        ForgeHooksClient.registerLayerDefinition(JugerModel.LAYER_LOCATION, JugerModel::createBodyLayer);
	        setWindowTitle("Block Entity Renders");
	        BlockEntityRenderers.register(DEBlockEntityTypes.PURPLEHEART_SIGN.get(), SignRenderer::new);
	        BlockEntityRenderers.register(DEBlockEntityTypes.DISPLAY_BLOCK.get(), DisplayBlockRenderer::new);
	        BlockEntityRenderers.register(DEBlockEntityTypes.ENCHANT_TRANSFER_TABLE.get(), EnchantTransferTableRenderer::new);
	        setWindowTitle("Entity Renders");
	        EntityRenderers.register(DEEntityTypes.DE_BOAT.get(), PurpleheartBoatRenderer::new);
	        EntityRenderers.register(DEEntityTypes.DE_CHEST_BOAT.get(), PurpleheartChestBoatRenderer::new);
	        EntityRenderers.register(DEEntityTypes.HEADED_SKELETON.get(), HeadedSkeletonRenderer::new);
	        EntityRenderers.register(DEEntityTypes.HEADED_GUARDIAN.get(), HeadedGuardianRenderer::new);
	        EntityRenderers.register(DEEntityTypes.BLUE_SAND_MAN.get(), BlueSandManRenderer::new);
	        EntityRenderers.register(DEEntityTypes.MOUVET.get(), MouvetRenderer::new);
	        EntityRenderers.register(DEEntityTypes.JUGER.get(), JugerRenderer::new);
	        setWindowTitle("Items Properties");
	        DEItems.addItemsProperties();
	        setWindowTitle("Window Icon");
	        setWindowTitle("Client Setup Complete!");
    	});
    }
    
    private static void setWindowTitle(String title) {
    	String message = String.format("Dimensional Expansion Client Setup: %s...", title);
    	LOGGER.debug(message);
		Minecraft.getInstance().getWindow().setTitle(message);
    }
}
