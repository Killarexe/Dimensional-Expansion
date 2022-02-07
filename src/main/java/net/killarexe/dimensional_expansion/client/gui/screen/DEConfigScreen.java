package net.killarexe.dimensional_expansion.client.gui.screen;

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
import net.minecraftforge.common.MinecraftForge;

@OnlyIn(Dist.CLIENT)
public class DEConfigScreen extends Screen {

    private Screen previousScreen;
    private Checkbox showVersionCheckbox, moddedTitleScreenCheckbox;

    public DEConfigScreen(Screen previousScreen) {
        super(new TranslatableComponent("narrator.screen.title"));
        this.previousScreen = previousScreen;
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        this.drawCenteredString(pPoseStack, font, new TranslatableComponent("config." + DEMod.MODID + ".title"), width/2, 10, 0xffffff);
        //this.drawCenteredString(pPoseStack, font, new TranslatableComponent("config." + DEMod.MODID + ".client"), width/2, height/2 - 20, 0xffffff);
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
        bufferbuilder.vertex(0.0D, (double)this.height, 0.0D).uv(0.0F, (float)this.height / 32.0F + (float)pVOffset).color(64, 64, 64, 255).endVertex();
        bufferbuilder.vertex((double)this.width, (double)this.height, 0.0D).uv((float)this.width / 32.0F, (float)this.height / 32.0F + (float)pVOffset).color(64, 64, 64, 255).endVertex();
        bufferbuilder.vertex((double)this.width, 0.0D, 0.0D).uv((float)this.width / 32.0F, (float)pVOffset).color(64, 64, 64, 255).endVertex();
        bufferbuilder.vertex(0.0D, 0.0D, 0.0D).uv(0.0F, (float)pVOffset).color(64, 64, 64, 255).endVertex();
        tesselator.end();
        MinecraftForge.EVENT_BUS.post(new ScreenEvent.BackgroundDrawnEvent(this, new PoseStack()));
    }

    @Override
    protected void init() {
        Button cancelButton = new Button(this.width / 2 -200, this.height / 4 + 48 + 80, 100, 20, new TranslatableComponent("button." + DEMod.MODID + ".cancel_button"), (button -> {
            onClose();
        }));
        Button applyButton = new Button(this.width / 2 +100, this.height / 4 + 48 + 80, 100, 20, new TranslatableComponent("button." + DEMod.MODID + ".apply_button"), (button -> {
            apply();
        }));
        addRenderableWidget(cancelButton);
        addRenderableWidget(applyButton);

        showVersionCheckbox = new Checkbox(this.width / 2 -200, this.height / 4 + 48 + 20, 20, 20, new TranslatableComponent("checkbox." + DEMod.MODID + ".show_version"), DEConfig.showVersion.get());
        moddedTitleScreenCheckbox = new Checkbox(this.width / 2 -200, this.height / 4 + 48, 20, 20, new TranslatableComponent("checkbox." + DEMod.MODID + ".modded_title_screen"), DEConfig.moddedTitleScreen.get());
        addRenderableWidget(showVersionCheckbox);
        addRenderableWidget(moddedTitleScreenCheckbox);

        super.init();
    }

    private void apply(){
        DEConfig.showVersion.set(showVersionCheckbox.selected());
        DEConfig.moddedTitleScreen.set(moddedTitleScreenCheckbox.selected());
        onClose();
    }

    @Override
    public void onClose() {
        if(previousScreen != null){
            minecraft.setScreen(previousScreen);
        }
        super.onClose();
    }
}
