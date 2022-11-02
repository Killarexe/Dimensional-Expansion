package net.killarexe.dimensional_expansion.client.gui.component;

import java.util.function.Consumer;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SwitchButton extends AbstractButton{
	
	public static final ResourceLocation DE_WIDGETS_LOCATION = new ResourceLocation(DEMod.MOD_ID, "textures/gui/button_widgets.png");
	
	public static final SwitchButton.OnTooltip NO_TOOLTIP = new SwitchButton.OnTooltip() {
		@Override
		public void onTooltip(SwitchButton pButton, PoseStack pPoseStack, int pMouseX, int pMouseY, String tooltipMessage) {

		}
	};
	public static final int SMALL_WIDTH = 120;
	public static final int DEFAULT_WIDTH = 256;
	public static final int DEFAULT_HEIGHT = 20;
	protected boolean enabled;
	protected final SwitchButton.OnTooltip onTooltip;
	
	public SwitchButton(int x, int y, Component message, boolean defaultValue) {
		this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, message, defaultValue);
	}
	
	public SwitchButton(int pX, int pY, int pWidth, int pHeight, Component pMessage, boolean defaultValue) {
		this(pX, pY, pWidth, pHeight, pMessage, defaultValue, NO_TOOLTIP);
	}
	
	public SwitchButton(int pX, int pY, int pWidth, int pHeight, Component pMessage, boolean defaultValue, SwitchButton.OnTooltip pOnTooltip) {
	    super(pX, pY, pWidth, pHeight, pMessage);
	    this.onTooltip = pOnTooltip;
	    this.enabled = defaultValue;
	}

	@Override
	public void updateNarration(NarrationElementOutput pNarrationElementOutput) {
		this.defaultButtonNarrationText(pNarrationElementOutput);
	    this.onTooltip.narrateTooltip((p_168841_) -> {
	    	pNarrationElementOutput.add(NarratedElementType.HINT, p_168841_);
	    });
	}

	@Override
	public void onPress() {
		this.enabled = !this.enabled;
	}
	
	public void renderButton(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
		Minecraft minecraft = Minecraft.getInstance();
		Font font = minecraft.font;
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
	    RenderSystem.setShaderTexture(0, DE_WIDGETS_LOCATION);
	    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.alpha);
	    int i = this.getYImage(this.isHoveredOrFocused());
	    if(enabled) {
	    	i += 3;
	    }
	    RenderSystem.enableBlend();
	    RenderSystem.defaultBlendFunc();
	    RenderSystem.enableDepthTest();
	    blit(pPoseStack, this.x, this.y, 0, 46 + i * 20, this.width / 2, this.height);
	    blit(pPoseStack, this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
	    this.renderBg(pPoseStack, minecraft, pMouseX, pMouseY);
	    int j = getFGColor();
	    drawString(pPoseStack, font, this.getMessage(), this.x + this.width + 16, this.y + (this.height - 8) / 2, j | Mth.ceil(this.alpha * 255.0F) << 24);
		if (this.isHoveredOrFocused()) {
			this.renderToolTip(pPoseStack, pMouseX, pMouseY);
		}
	}

	public void renderToolTip(PoseStack pPoseStack, int pMouseX, int pMouseY) {
		String tooltipMessage = enabled ? "ON" : "OFF"; 
		this.onTooltip.onTooltip(this, pPoseStack, pMouseX, pMouseY, tooltipMessage);
	}

	@OnlyIn(Dist.CLIENT)
	public interface OnTooltip {
		void onTooltip(SwitchButton pButton, PoseStack pPoseStack, int pMouseX, int pMouseY, String tooltipMessage);
	    default void narrateTooltip(Consumer<Component> pContents) {}
	}
	
	public boolean isEnabled() {
		return enabled;
	}
}
