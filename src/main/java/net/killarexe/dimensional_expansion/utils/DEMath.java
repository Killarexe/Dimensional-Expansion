package net.killarexe.dimensional_expansion.utils;

import net.minecraft.core.Vec3i;

public class DEMath {
	public static int secondsToTicks(int seconds) {
		return seconds * 20;
	}
	
	public static int rgbToHex(int r, int g, int b) {
        return (r << 16) | (g << 8) | b;
    }
	
	public static Vec3i overworldPosToNetherPos(Vec3i position) {
		return new Vec3i(position.getX() / 8, position.getY(), position.getZ() / 8);
	}
	
	public static Vec3i netherPosToOverworldPos(Vec3i position) {
		return new Vec3i(position.getX() * 8, position.getY(), position.getZ() * 8);
	}
	
	public static float clamp(float val, float min, float max) {
        return Math.max(min, Math.min(max, val));
    }
    
    public static int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }
}
