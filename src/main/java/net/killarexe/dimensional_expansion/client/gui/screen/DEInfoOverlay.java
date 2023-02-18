package net.killarexe.dimensional_expansion.client.gui.screen;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.utils.DEMath;
import net.killarexe.dimensional_expansion.utils.DEWindowUtils;
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
	        	mc.font.draw(event.getPoseStack(), "Dimensional Expansion " + DEMod.VERSION, posX, posY, 255);
	        }
	        if(DEConfig.debugMod.get()) {
	        	mc.font.draw(event.getPoseStack(), "Minecraft " + SharedConstants.getCurrentVersion().getName(), posX, posY + 10, 255);
	        	mc.font.draw(event.getPoseStack(), "Forge " + ForgeVersion.getVersion(), posX, posY + 20, 255);
	        	mc.font.draw(event.getPoseStack(), "FPS " + DEWindowUtils.getFPS(), posX, posY + 30, getFPSColor());
	        }
    	}
    }
    
    private static int getFPSColor() {
    	int fps = Integer.parseInt(DEWindowUtils.getFPS());
    	if(fps > 60) {
    		fps = 60;
    	}else if(fps <= 0) {
    		fps = 1;
    	}
    	return DEMath.rgbToHex(256 - ((256/60) * fps), (256/60) * fps, 0);
    }
}
