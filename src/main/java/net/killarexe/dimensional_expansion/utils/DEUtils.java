package net.killarexe.dimensional_expansion.utils;

import net.minecraft.client.Minecraft;

public class DEUtils {
    public static boolean isDev(){
        return Minecraft.getInstance().getLaunchedVersion().equalsIgnoreCase("MOD_DEV");
    }

    public static boolean isDevAccount(){
        return Minecraft.getInstance().getUser().getName().equalsIgnoreCase("Killarexe") || Minecraft.getInstance().getUser().getName().equalsIgnoreCase("9e_Docteur");
    }
}
