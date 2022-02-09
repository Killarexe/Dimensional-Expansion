package net.killarexe.dimensional_expansion.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.killarexe.dimensional_expansion.client.gui.screens.EssenceExtractorScreen;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.killarexe.dimensional_expansion.core.init.DEContainers;
import net.minecraft.client.render.RenderLayer;

public class DEModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        setBlockProperties();
    }

    private void setBlockProperties(){
        BlockRenderLayerMap.INSTANCE.putBlock(DEBlocks.END_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DEBlocks.END_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DEBlocks.END_ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DEBlocks.ESSENCE_EXTRACTOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DEBlocks.XP_CROPS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DEBlocks.HEALTH_CROPS, RenderLayer.getCutout());
    }

    private void registerScreens(){
        ScreenRegistry.register(DEContainers.ESSENCE_EXTRACTOR_CONTAINER, EssenceExtractorScreen::new);
    }
}
