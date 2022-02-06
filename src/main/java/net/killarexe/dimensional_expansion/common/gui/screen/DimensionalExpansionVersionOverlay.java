package net.killarexe.dimensional_expansion.common.gui.screen;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.config.DEConfig;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class DimensionalExpansionVersionOverlay {

    public static void render(RenderGameOverlayEvent.Pre event){
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL && DEConfig.showVersion.get()) {
            int posX = 10;
            int posY = 10;
            if(DEConfig.showVersion.get()){
                Minecraft.getInstance().font.draw(event.getMatrixStack(), "Dimensional Expansion " + DEMod.VERSION, posX, posY, 255);
            }
        }
    }
}
