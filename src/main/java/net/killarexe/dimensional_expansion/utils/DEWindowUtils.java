package net.killarexe.dimensional_expansion.utils;

import java.io.IOException;
import java.io.InputStream;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

public class DEWindowUtils {
    public static void setWindowTitle(String title) {
        Minecraft.getInstance().getWindow().setTitle(title);
    }
    
    public static void setWindowIcon(ResourceLocation icon16, ResourceLocation icon32) {
    	try {
    		if(Minecraft.ON_OSX) {
    			DEMod.LOGGER.debug("Can't change window icon beacause is on Mac.");
    			return;
    		}
    		InputStream icon1 = Minecraft.getInstance().getResourceManager().getResourceOrThrow(icon16).open();
    		InputStream icon2 = Minecraft.getInstance().getResourceManager().getResourceOrThrow(icon32).open();
    		Minecraft.getInstance().getWindow().setIcon(() -> icon1, () -> icon2);
    		DEMod.LOGGER.debug("Set window icon to: '" + icon16.getPath() + "' and '" + icon32.getPath() + "'");
    	}catch(IOException e) {
    		DEMod.LOGGER.warn("Can't find file: '" + icon16.getPath() + "' and '" + icon32.getPath() + "'");
    		return;
    	}
    }
}
