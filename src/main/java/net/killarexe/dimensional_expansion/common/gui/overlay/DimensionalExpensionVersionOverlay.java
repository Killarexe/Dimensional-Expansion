package net.killarexe.dimensional_expansion.common.gui.overlay;

import net.killarexe.dimensional_expansion.DimensionalExpansionMod;
import net.killarexe.dimensional_expansion.core.config.DimensionalExpansionConfig;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DimensionalExpansionMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DimensionalExpensionVersionOverlay {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void render(RenderGameOverlayEvent.Pre event){
        if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            DimensionalExpansionMod.LOGGER.info("Render Overlay...");
            int w = event.getWindow().getGuiScaledWidth();
            int h = event.getWindow().getGuiScaledHeight();
            int posX = w / 2;
            int posY = h / 2;
            if(DimensionalExpansionConfig.showVersion.get()){
                Minecraft.getInstance().font.draw(event.getMatrixStack(), "Dimensional Expansion " + DimensionalExpansionMod.VERSION, posX, posY, 255);
            }
        }
    }
}
