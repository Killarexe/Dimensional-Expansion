package net.killarexe.dimensional_expansion.client;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.event.DEEventsClient;
import net.killarexe.dimensional_expansion.client.gui.screen.DEInfoOverlay;
import net.killarexe.dimensional_expansion.client.gui.screen.EssenceExtractorScreen;
import net.killarexe.dimensional_expansion.client.gui.screen.config.DEConfigScreen;
import net.killarexe.dimensional_expansion.client.integration.discord.DiscordRPCManager;
import net.killarexe.dimensional_expansion.client.render.blockentity.DisplayBlockRenderer;
import net.killarexe.dimensional_expansion.client.render.entity.EndBoatRenderer;
import net.killarexe.dimensional_expansion.core.init.*;
import net.killarexe.dimensional_expansion.uitls.DEUtils;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
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
        forgeEventBus.addListener(DEInfoOverlay::render);
        bus.addListener(DEModClient::clientSetup);
    }

    private static void clientSetup(final FMLClientSetupEvent event){
        LOGGER.info("Dimensional Expansion Client Setup");
        Minecraft.getInstance().getWindow().setTitle("Dimensional Expansion " + DEMod.VERSION + " Client Setup...");
        ModLoadingContext.get().registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory((mc, screen) -> new DEConfigScreen(screen))
        );
        LOGGER.info("Add Dimensional Expansion WoodTypes");
        DEUtils.setWindowTitle("Dimensional Expansion " + DEMod.VERSION + " WoodTypes");
        DEWoodTypes.setWoodTypes();
        LOGGER.info("Set Dimensional Expansion Block Entity Renders");
        DEUtils.setWindowTitle("Dimensional Expansion " + DEMod.VERSION + "Block Entity Renders");
        BlockEntityRenderers.register(DEBlockEntityTypes.END_SIGN.get(), SignRenderer::new);
        BlockEntityRenderers.register(DEBlockEntityTypes.DISPLAY_BLOCK.get(), DisplayBlockRenderer::new);
        LOGGER.info("Set Dimensional Expansion Entity Renders");
        DEUtils.setWindowTitle("Dimensional Expansion " + DEMod.VERSION + " Entity Renders");
        EntityRenderers.register(DEEntityTypes.END_BOAT.get(), EndBoatRenderer::new);
        LOGGER.info("Set Dimensional Expansion Blocks Settings");
        DEUtils.setWindowTitle("Dimensional Expansion " + DEMod.VERSION + " Settings");
        //TODO: Remove this and remake the models to set transparency.
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_LEAVES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.XP_CROPS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.HEALTH_CROPS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.ESSENCE_EXTRACTOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.POTTED_END_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.POTTED_END_SAPLING.get(), RenderType.cutout());
        LOGGER.info("Register Dimensional Expansion Container");
        MenuScreens.register(DEMenuTypes.ESSENCE_EXTRACTOR_MENU_TYPE.get(), EssenceExtractorScreen::new);
        LOGGER.info("Add Dimensional Expansion Items Properties");
        DEItems.addItemsProperites();
        DiscordRPCManager.start(
                "945425580210389012",
                "Playing Dimensional Expansion v" + DEMod.VERSION,
                "Minecraft: " + SharedConstants.getCurrentVersion().getName(),
                "logo",
                "",
                "",
                ""
        );
    }
}
