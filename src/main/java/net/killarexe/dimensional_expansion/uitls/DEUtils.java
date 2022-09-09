package net.killarexe.dimensional_expansion.uitls;

import net.minecraft.client.Minecraft;

public class DEUtils {
    public static void setWindowTitle(String title) {
        Minecraft.getInstance().getWindow().setTitle(title);
    }

    public static boolean isDev(){
        return Minecraft.getInstance().getLaunchedVersion().equalsIgnoreCase("MOD_DEV");
    }

    public static boolean isDevAccount(){
        return Minecraft.getInstance().getUser().getName().equalsIgnoreCase("Killarexe") || Minecraft.getInstance().getUser().getName().equalsIgnoreCase("9e_Docteur");
    }
}
