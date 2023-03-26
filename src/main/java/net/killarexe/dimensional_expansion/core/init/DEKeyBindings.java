package net.killarexe.dimensional_expansion.core.init;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;

public class DEKeyBindings {
	
	public static final List<KeyMapping> KEYS = new ArrayList<>();
	
	public static final String KEY_CATEGORY = "key.category." + DEMod.MOD_ID + ".dev_keys";
	
	public static final KeyMapping CONFIG_KEY = createKey("config", GLFW.GLFW_KEY_R);
	
	private static KeyMapping createKey(String name, int key) {
		KeyMapping keyMapping = new KeyMapping(String.format("key.%s.%s", DEMod.MOD_ID, name), KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, key, KEY_CATEGORY);
		KEYS.add(keyMapping);
		return keyMapping;
	}
	
	public static void onKeyRegister(RegisterKeyMappingsEvent e) {
		for(KeyMapping key: DEKeyBindings.KEYS) {
			e.register(key);
		}
	}
}
