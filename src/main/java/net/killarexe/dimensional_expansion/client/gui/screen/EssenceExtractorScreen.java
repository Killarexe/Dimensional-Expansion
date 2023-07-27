package net.killarexe.dimensional_expansion.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.container.EssenceExtractorContainer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EssenceExtractorScreen extends AbstractContainerScreen<EssenceExtractorContainer>{

    private final ResourceLocation GUI = new ResourceLocation(DEMod.MOD_ID, "textures/gui/container/essence_extractor_gui.png");

    public EssenceExtractorScreen(EssenceExtractorContainer pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(guiGraphics, pMouseX, pMouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        RenderSystem.setShader(GameRenderer::getPositionShader);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, GUI);
        guiGraphics.blit(GUI, leftPos, topPos, 0, -2, getXSize(), getYSize());
        RenderSystem.disableBlend();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
