package net.killarexe.dimensional_expansion.client.event;

import net.killarexe.dimensional_expansion.client.gui.screen.DETitleScreen;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DEEventsClient {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
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

}
