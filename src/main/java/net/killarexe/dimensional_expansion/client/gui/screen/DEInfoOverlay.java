package net.killarexe.dimensional_expansion.client.gui.screen;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.io.WindowManager;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.versions.forge.ForgeVersion;

@OnlyIn(Dist.CLIENT)
public class DEInfoOverlay {

	public static void render(RenderGuiOverlayEvent.Pre event){
    	int posX = 10;
    	int posY = 10;
    	Minecraft mc = Minecraft.getInstance();
    	if(!mc.options.reducedDebugInfo().get()) {
	        if(DEConfig.showVersion.get()){
	        	event.getGuiGraphics().drawString(mc.font, "Dimensional Expansion " + DEMod.VERSION, posX, posY, 255);
	        }
	        if(DEConfig.devMod.get()) {
	        	event.getGuiGraphics().drawString(mc.font, "Minecraft " + SharedConstants.getCurrentVersion().getName(), posX, posY + 10, 255);
	        	event.getGuiGraphics().drawString(mc.font, "Forge " + ForgeVersion.getVersion(), posX, posY + 20, 255);
	        	event.getGuiGraphics().drawString(mc.font, "FPS " + WindowManager.getFPS(), posX, posY + 30, getFPSColor());
	        }
    	}
    }
    
    private static int getFPSColor() {
    	int fps = Integer.parseInt(WindowManager.getFPS());
    	fps = Mth.clamp(fps, 1, 60);
    	
    	int green = (256 / 60) * fps;
    	int red = 256 - green;
    	return (red << 16) | (green << 8);
    }
}
