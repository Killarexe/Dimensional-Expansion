package net.killarexe.dimensional_expansion.client.gui.screen;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.io.WindowManager;
import net.killarexe.dimensional_expansion.utils.DEMath;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
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
    	if(!mc.options.renderDebug) {
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
    	fps = DEMath.clamp(fps, 1, 60);
    	return DEMath.rgbToHex(256 - ((256/60) * fps), (256/60) * fps, 0);
    }
}
