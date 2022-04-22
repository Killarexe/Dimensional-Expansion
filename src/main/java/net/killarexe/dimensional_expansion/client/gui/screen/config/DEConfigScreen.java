package net.killarexe.dimensional_expansion.client.gui.screen.config;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.client.gui.widget.ForgeSlider;
import net.minecraftforge.common.MinecraftForge;

@OnlyIn(Dist.CLIENT)
public class DEConfigScreen extends Screen {
    private final Screen previousScreen;
    private Button clientButton, commonButton, cancelButton, applyButton;

    public DEConfigScreen(Screen previousScreen) {
        super(new TranslatableComponent("narrator.screen.title"));
        this.previousScreen = previousScreen;
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        drawCenteredString(pPoseStack, font, new TranslatableComponent("config." + DEMod.MODID + ".title"), width/2, 10, 0xffffff);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    public void renderDirtBackground(int pVOffset) {
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderTexture(0, BACKGROUND_LOCATION);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32.0F;
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
        bufferbuilder.vertex(0.0D, this.height, 0.0D).uv(0.0F, (float)this.height / 32.0F + (float)pVOffset).color(64, 64, 64, 255).endVertex();
        bufferbuilder.vertex(this.width, this.height, 0.0D).uv((float)this.width / 32.0F, (float)this.height / 32.0F + (float)pVOffset).color(64, 64, 64, 255).endVertex();
        bufferbuilder.vertex(this.width, 0.0D, 0.0D).uv((float)this.width / 32.0F, (float)pVOffset).color(64, 64, 64, 255).endVertex();
        bufferbuilder.vertex(0.0D, 0.0D, 0.0D).uv(0.0F, (float)pVOffset).color(64, 64, 64, 255).endVertex();
        tesselator.end();
        MinecraftForge.EVENT_BUS.post(new ScreenEvent.BackgroundDrawnEvent(this, new PoseStack()));
    }

    @Override
    protected void init() {
        cancelButton = new Button(this.width / 2 -200, this.height / 4 + 48 + 80, 100, 20, new TranslatableComponent("button." + DEMod.MODID + ".cancel_button"), (button -> {
            onClose();
        }));
        applyButton = new Button(this.width / 2 +100, this.height / 4 + 48 + 80, 100, 20, new TranslatableComponent("button." + DEMod.MODID + ".apply_button"), (button -> {
            onClose();
        }));

        clientButton = new Button(this.width / 2 - 75, this.height / 4 + 60, 150, 20, new TranslatableComponent("button." + DEMod.MODID + ".client_button"), (button -> {
            minecraft.setScreen(new DEClientConfigScreen(this));
        }));
        commonButton = new Button(this.width / 2 - 75, this.height / 4 + 0, 150, 20, new TranslatableComponent("button." + DEMod.MODID + ".common_button"), (button -> {
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
