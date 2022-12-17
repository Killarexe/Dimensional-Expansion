package net.killarexe.dimensional_expansion.client.gui.screen.config;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.utils.DEWindowUtils;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;

@OnlyIn(Dist.CLIENT)
public class DEConfigScreen extends Screen {
    private final Screen previousScreen;
    private Button clientButton, commonButton, cancelButton, applyButton;

    public DEConfigScreen(Screen previousScreen) {
        super(MutableComponent.create(new TranslatableContents("narrator.screen.title")));
        this.previousScreen = previousScreen;
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
    	DEWindowUtils.setWindowTitle("Dimensional Expansion v" + DEMod.VERSION + " | Config screen");
        this.renderBackground(pPoseStack);
        drawCenteredString(pPoseStack, font, MutableComponent.create(new TranslatableContents("config." + DEMod.MOD_ID + ".title")), width/2, 10, 0xffffff);
        if(clientButton.isHoveredOrFocused()) {
        	this.renderTooltip(pPoseStack, Component.translatable("button." + DEMod.MOD_ID + ".client_button_desc"), pMouseX, pMouseY);
        }
        if(commonButton.isHoveredOrFocused()) {
        	this.renderTooltip(pPoseStack, Component.translatable("button." + DEMod.MOD_ID + ".common_button_desc"), pMouseX, pMouseY);
        }
        
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    public void renderDirtBackground(int pVOffset) {
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderTexture(0, BACKGROUND_LOCATION);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
        bufferbuilder.vertex(0.0D, this.height, 0.0D).uv(0.0F, (float)this.height / 32.0F + (float)pVOffset).color(64, 64, 64, 255).endVertex();
        bufferbuilder.vertex(this.width, this.height, 0.0D).uv((float)this.width / 32.0F, (float)this.height / 32.0F + (float)pVOffset).color(64, 64, 64, 255).endVertex();
        bufferbuilder.vertex(this.width, 0.0D, 0.0D).uv((float)this.width / 32.0F, (float)pVOffset).color(64, 64, 64, 255).endVertex();
        bufferbuilder.vertex(0.0D, 0.0D, 0.0D).uv(0.0F, (float)pVOffset).color(64, 64, 64, 255).endVertex();
        tesselator.end();
        MinecraftForge.EVENT_BUS.post(new ScreenEvent.BackgroundRendered(this, new PoseStack()));
    }

    @Override
    protected void init() {
        cancelButton = new Button(this.width / 2 -200, this.height / 4 + 48 + 80, 100, 20, MutableComponent.create(new TranslatableContents("button." + DEMod.MOD_ID + ".cancel_button")), (button -> {
            onClose();
        }));
        applyButton = new Button(this.width / 2 +100, this.height / 4 + 48 + 80, 100, 20, MutableComponent.create(new TranslatableContents("button." + DEMod.MOD_ID + ".apply_button")), (button -> {
            onClose();
        }));

        clientButton = new Button(this.width / 2 - 75, this.height / 4 + 60, 150, 20, MutableComponent.create(new TranslatableContents("button." + DEMod.MOD_ID + ".client_button")), (button -> {
            minecraft.setScreen(new DEClientConfigScreen(this));
        }));
        commonButton = new Button(this.width / 2 - 75, this.height / 4 + 0, 150, 20, MutableComponent.create(new TranslatableContents("button." + DEMod.MOD_ID + ".common_button")), (button -> {
            minecraft.setScreen(new DECommonConfigScreen(this));
        }));

        addRenderableWidget(clientButton);
        addRenderableWidget(commonButton);
        addRenderableWidget(cancelButton);
        addRenderableWidget(applyButton);

        super.init();
    }

    @Override
    public void onClose() {
        super.onClose();
        if(previousScreen != null){
            minecraft.setScreen(previousScreen);
        }
    }

}
