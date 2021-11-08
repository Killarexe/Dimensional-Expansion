package net.killarexe.dimensional_expansion.uitls;

import net.killarexe.dimensional_expansion.DimensionalExpansionMod;
import net.killarexe.dimensional_expansion.core.init.DimensionalExpansionBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DimensionalExpansionMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        DimensionalExpansionMod.LOGGER.info("Set Blocks Settings");
        ItemBlockRenderTypes.setRenderLayer(DimensionalExpansionBlocks.END_LEAVES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DimensionalExpansionBlocks.END_SAPLING.get(), RenderType.translucent());
    }
}
