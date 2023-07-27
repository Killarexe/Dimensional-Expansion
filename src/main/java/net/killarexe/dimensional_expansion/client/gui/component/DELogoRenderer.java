package net.killarexe.dimensional_expansion.client.gui.component;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

public class DELogoRenderer {
   public static final ResourceLocation LOGO = new ResourceLocation(DEMod.MOD_ID, "textures/gui/title/minecraft.png");
   public static final ResourceLocation MINECRAFT_EDITION = new ResourceLocation("textures/gui/title/edition.png");
   public static final int LOGO_WIDTH = 256;
   public static final int LOGO_HEIGHT = 44;
   public static final int DEFAULT_HEIGHT_OFFSET = 30;
   private final boolean keepLogoThroughFade;

   public DELogoRenderer(boolean pKeepLogoThroughFade) {
	  this.keepLogoThroughFade = pKeepLogoThroughFade;
   }

   public void renderLogo(GuiGraphics pGuiGraphics, int pScreenWidth, float pTransparency) {
	  this.renderLogo(pGuiGraphics, pScreenWidth, pTransparency, 30);
   }

   public void renderLogo(GuiGraphics pGuiGraphics, int pScreenWidth, float pTransparency, int pHeight) {
	  pGuiGraphics.setColor(1.0F, 1.0F, 1.0F, this.keepLogoThroughFade ? 1.0F : pTransparency);
	  int i = pScreenWidth / 2 - 128;
	  pGuiGraphics.blit(LOGO, i, pHeight, 0.0F, 0.0F, 256, 44, 256, 64);
	  int j = pScreenWidth / 2 - 64;
	  int k = pHeight + 44 - 7;
	  pGuiGraphics.blit(MINECRAFT_EDITION, j, k, 0.0F, 0.0F, 128, 14, 128, 16);
	  pGuiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
   }
}
