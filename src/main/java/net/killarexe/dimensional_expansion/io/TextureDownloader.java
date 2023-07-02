package net.killarexe.dimensional_expansion.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.mojang.blaze3d.platform.NativeImage;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;

public class TextureDownloader {
	
	private static final Map<String, ResourceLocation> DOWNLOADED_TEXTURES = new HashMap<>();
	
    public static boolean isResponsive(String URL) {
        try {
            URL url = new URL(URL);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            bufferedReader.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean hasInternet() {
    	return isResponsive("https://google.com");
    }
    
    public static ResourceLocation getImageFromURL(String url, String name) {
    	if(DOWNLOADED_TEXTURES.containsKey(url)) {
    		return DOWNLOADED_TEXTURES.get(url);
    	}
    	ResourceLocation loc = new ResourceLocation("grass");
    	if(!isResponsive(url)) {
    		return loc;
    	}
    	try {
    		InputStream inputStream = new URL(url).openStream();
            NativeImage image = NativeImage.read(inputStream);
            DynamicTexture texture = new DynamicTexture(image);
            inputStream.close();
            loc = new ResourceLocation(DEMod.MOD_ID, name);
            Minecraft.getInstance().getTextureManager().register(loc, texture);
    	}catch(MalformedURLException e) {
    		return loc;
    	}catch(IOException e) {
    		return loc;
    	}
    	return loc;
    }
}
