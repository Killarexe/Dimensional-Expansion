package net.killarexe.dimensional_expansion.client.event;

import net.killarexe.dimensional_expansion.client.gui.screen.config.DEConfigScreen;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.init.DEKeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;

@OnlyIn(Dist.CLIENT)
public class DEEventsClient {
	
	public static void onKeyInput(InputEvent.Key e) {
		if(DEKeyBindings.CONFIG_KEY.consumeClick() && (DEConfig.isDev() || DEConfig.isDevAccount()) && DEConfig.devMod.get()) {
			Minecraft.getInstance().setScreen(new DEConfigScreen(null));
		}
	}
}
