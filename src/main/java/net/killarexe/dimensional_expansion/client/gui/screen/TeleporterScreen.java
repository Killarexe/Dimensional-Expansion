package net.killarexe.dimensional_expansion.client.gui.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TeleporterScreen extends Screen{

	public TeleporterScreen() {
		super(Component.literal("Teleporter"));
	}
	
	@Override
	public void render(GuiGraphics graphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(graphics, pMouseX, pMouseY, pPartialTick);
		super.render(graphics, pMouseX, pMouseY, pPartialTick);
		graphics.renderTooltip(font, title, pMouseX, pMouseY);
	}
	
	@Override
	public boolean isPauseScreen() {
		return true;
	}
}
