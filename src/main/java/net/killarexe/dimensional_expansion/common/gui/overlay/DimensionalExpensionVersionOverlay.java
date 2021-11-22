package net.killarexe.dimensional_expansion.common.gui.overlay;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.config.DEConfig;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DimensionalExpensionVersionOverlay {

    @SubscribeEvent
    public static void render(RenderGameOverlayEvent.Pre event){
        if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.ALL && DEConfig.showVersion.get()) {
            DEMod.LOGGER.info("Render Overlay...");
            int w = event.getWindow().getGuiScaledWidth();
            int h = event.getWindow().getGuiScaledHeight();
            int posX = w / 2;
            int posY = h / 2;
            if(DEConfig.showVersion.get()){
                Minecraft.getInstance().font.draw(event.getMatrixStack(), "Dimensional Expansion " + DEMod.VERSION, posX, posY, 255);
            }
        }
    }
}
