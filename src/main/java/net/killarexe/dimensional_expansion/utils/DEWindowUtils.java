package net.killarexe.dimensional_expansion.utils;

import java.io.IOException;
import java.io.InputStream;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;

public class DEWindowUtils {
    public static void setWindowTitle(String title) {
        Minecraft.getInstance().getWindow().setTitle(title);
    }
    
    public static void setWindowIcon(ResourceLocation icon16, ResourceLocation icon32) {
    	try {
    		if(Minecraft.ON_OSX) {
    			return;
    		}
    		InputStream icon1 = Minecraft.getInstance().getClientPackSource().getVanillaPack().getResource(PackType.CLIENT_RESOURCES, icon16);
    		InputStream icon2 = Minecraft.getInstance().getClientPackSource().getVanillaPack().getResource(PackType.CLIENT_RESOURCES, icon32);
    		Minecraft.getInstance().getWindow().setIcon(icon1, icon2);
    	}catch(IOException e) {
    		return;
    	}
    }
}
