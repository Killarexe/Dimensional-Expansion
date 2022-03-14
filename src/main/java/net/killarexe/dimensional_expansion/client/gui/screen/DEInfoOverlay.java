package net.killarexe.dimensional_expansion.client.gui.screen;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.integration.discord.DiscordRPCManager;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.versions.forge.ForgeVersion;

public class DEInfoOverlay {

    public static void render(RenderGameOverlayEvent.Pre event){
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL && DEConfig.showVersion.get()) {
            int posX = 10;
            int posY = 10;
            if(DEConfig.showVersion.get()){
                Minecraft.getInstance().font.draw(event.getMatrixStack(), "Dimensional Expansion " + DEMod.VERSION, posX, posY, 255);
                if(DEConfig.debugMod.get()) {
                    Minecraft.getInstance().font.draw(event.getMatrixStack(), "Minecraft " + SharedConstants.getCurrentVersion().getName(), posX, posY + 10, 255);
                    Minecraft.getInstance().font.draw(event.getMatrixStack(), "Forge " + ForgeVersion.getVersion(), posX, posY + 20, 255);
                    Minecraft.getInstance().font.draw(event.getMatrixStack(), "FPS " + Minecraft.getInstance().fpsString, posX, posY + 10, 255);
                    DiscordRPCManager.setLogoText("FPS: " + Minecraft.getInstance().fpsString);
                }
            }
        }
    }
}
