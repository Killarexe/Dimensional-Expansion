package net.killarexe.dimensional_expansion.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryUtil;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

public class WindowManager {
    public static void setWindowTitle(String title) {
        Minecraft.getInstance().getWindow().setTitle(title);
    }
    
    public static void setWindowIcon(ResourceLocation icon16, ResourceLocation icon32) {
    	try {
    		if(Minecraft.ON_OSX) {
    			DEMod.LOGGER.debug("Can't change window icon beacause is on Mac.");
    			return;
    		}
    		byte[] icon1 = Minecraft.getInstance().getResourceManager().getResourceOrThrow(icon16).open().readAllBytes();
    		byte[] icon2 = Minecraft.getInstance().getResourceManager().getResourceOrThrow(icon32).open().readAllBytes();
    		ByteBuffer icon16Buffer = MemoryUtil.memAlloc(icon1.length).put(icon1);
    		ByteBuffer icon32Buffer = MemoryUtil.memAlloc(icon2.length).put(icon2);
    		IntBuffer w = MemoryUtil.memAllocInt(1);
    		IntBuffer h = MemoryUtil.memAllocInt(1);
    		IntBuffer comp = MemoryUtil.memAllocInt(1);
    		try(GLFWImage.Buffer icons = GLFWImage.malloc(2)) {
                ByteBuffer pixels16 = STBImage.stbi_load_from_memory(icon16Buffer, w, h, comp, 4);
                icons.position(0).width(w.get(0)).height(h.get(0)).pixels(pixels16);
                ByteBuffer pixels32 = STBImage.stbi_load_from_memory(icon32Buffer, w, h, comp, 4);
                icons.position(1).width(w.get(0)).height(h.get(0)).pixels(pixels32);
                icons.position(0);
                GLFW.glfwSetWindowIcon(Minecraft.getInstance().getWindow().getWindow(), icons);

                STBImage.stbi_image_free(pixels32);
                STBImage.stbi_image_free(pixels16);
            }catch(Exception e) {
            	DEMod.LOGGER.error("Failed to set window icon: Failed to allocate image...");
            }
    		MemoryUtil.memFree(icon16Buffer);
    		MemoryUtil.memFree(icon32Buffer);
    		MemoryUtil.memFree(w);
    		MemoryUtil.memFree(h);
    		MemoryUtil.memFree(comp);
    		DEMod.LOGGER.debug("Set window icon to: '" + icon16.getPath() + "' and '" + icon32.getPath() + "'");
    	}catch(IOException e) {
    		DEMod.LOGGER.warn("Can't find file: '" + icon16.getPath() + "' and '" + icon32.getPath() + "'");
    		return;
    	}
    }
    
    @SuppressWarnings("resource")
	public static String getFPS() {
        return Minecraft.getInstance().fpsString.split("\\s+")[0];
    }
}
