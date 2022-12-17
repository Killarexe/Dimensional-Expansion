package net.killarexe.dimensional_expansion.client.gui.screen;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.utils.DEMath;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.versions.forge.ForgeVersion;

@OnlyIn(Dist.CLIENT)
public class DEInfoOverlay {

    @SuppressWarnings("resource")
	public static void render(RenderGuiOverlayEvent.Pre event){
        if(DEConfig.showVersion.get()){
            int posX = 10;
            int posY = 10;
            if(DEConfig.showVersion.get()){
                Minecraft.getInstance().font.draw(event.getPoseStack(), "Dimensional Expansion " + DEMod.VERSION, posX, posY, 255);
                if(DEConfig.debugMod.get()) {
                    Minecraft.getInstance().font.draw(event.getPoseStack(), "Minecraft " + SharedConstants.getCurrentVersion().getName(), posX, posY + 10, 255);
                    Minecraft.getInstance().font.draw(event.getPoseStack(), "Forge " + ForgeVersion.getVersion(), posX, posY + 20, 255);
                    Minecraft.getInstance().font.draw(event.getPoseStack(), "FPS " + getFPS(Minecraft.getInstance()), posX, posY + 30, getFPSColor(Minecraft.getInstance()));
                }
            }
        }
    }
    
    private static int getFPSColor(Minecraft mc) {
    	int fps = Integer.parseInt(getFPS(mc));
    	if(fps > 60) {
    		fps = 60;
    	}else if(fps <= 0) {
    		fps = 1;
    	}
    	return DEMath.rgbToHex(256 - ((256/60) * fps), (256/60) * fps, 0);
    }

    private static String getFPS(Minecraft mc) {
        return formatText(mc.fpsString.split("\\s+")[0]);
    }

    private static String formatText(String text) {
        Component fpsString = Component.literal(text);
        return fpsString.getString();

    }
}
