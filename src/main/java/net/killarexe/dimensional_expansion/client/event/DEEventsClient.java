package net.killarexe.dimensional_expansion.client.event;

import net.killarexe.dimensional_expansion.client.gui.screen.DETitleScreen;
import net.killarexe.dimensional_expansion.client.gui.screen.config.DEConfigScreen;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.core.init.DEKeyBindings;
import net.killarexe.dimensional_expansion.utils.DEUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.ScreenEvent;

@OnlyIn(Dist.CLIENT)
public class DEEventsClient {

    public static void onScreenPost(final ScreenEvent.Init.Post event) {
        if(DEConfig.moddedScreens.get()){
            if(event.getScreen() instanceof TitleScreen screen){
                screen.getMinecraft().setScreen(new DETitleScreen(screen.fading));
            }
        }else {
        	if(event.getScreen() instanceof DETitleScreen screen) {
        		screen.getMinecraft().setScreen(new TitleScreen(screen.fading));
        	}
        }
    }
	
	public static void onKeyInput(InputEvent.Key e) {
		if(DEKeyBindings.RENDER_KEY.consumeClick() && (DEUtils.isDev() || DEUtils.isDevAccount()) && DEConfig.devMod.get()) {
			Minecraft.getInstance().setScreen(new DEConfigScreen(null));
		}
	}
}
