package net.killarexe.dimensional_expansion.client.gui.screen;

import com.mojang.blaze3d.vertex.PoseStack;

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
	public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
		this.renderBackground(pPoseStack);
		super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
		this.renderTooltip(pPoseStack, title, pMouseX, pMouseY);
	}
	
	@Override
	public boolean isPauseScreen() {
		return true;
	}
}
