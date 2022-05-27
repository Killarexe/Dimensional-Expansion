package net.killarexe.dimensional_expansion.client.gui.screen.config;

import com.mojang.blaze3d.vertex.PoseStack;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DEClientConfigScreen extends Screen {

    private final Screen previousScreen;
    private Button cancelButton, applyButton;
    private Checkbox showVersionCheckbox, coordLinkerOverlayCheckbox, moddedTitleScreenCheckbox, debugModCheckBox;

    public DEClientConfigScreen(Screen previousScreen) {
        super(new TranslatableComponent("narrator.screen.title"));
        this.previousScreen = previousScreen;
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        drawCenteredString(pPoseStack, font, new TranslatableComponent("config." + DEMod.MODID + ".client"), width/2, 10, 0xffffff);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    protected void init() {
        cancelButton = new Button(this.width / 2 -200, this.height / 4 + 48 + 80, 100, 20, new TranslatableComponent("button." + DEMod.MODID + ".cancel_button"), (button -> {
            onClose();
        }));
        applyButton = new Button(this.width / 2 +100, this.height / 4 + 48 + 80, 100, 20, new TranslatableComponent("button." + DEMod.MODID + ".apply_button"), (button -> {
            apply();
        }));
        addRenderableWidget(cancelButton);
        addRenderableWidget(applyButton);

        showVersionCheckbox = new Checkbox(this.width / 2 -200, this.height / 4 + 48, 20, 20, new TranslatableComponent("checkbox." + DEMod.MODID + ".show_version"), DEConfig.showVersion.get());
        coordLinkerOverlayCheckbox = new Checkbox(this.width / 2 -200, this.height / 4 + 28, 20, 20, new TranslatableComponent("checkbox." + DEMod.MODID + ".coords_linker"), DEConfig.coordLinkerOverlay.get());
        moddedTitleScreenCheckbox = new Checkbox(this.width / 2 -200, this.height / 4 + 8, 20, 20, new TranslatableComponent("checkbox." + DEMod.MODID + ".modded_title_screen"), DEConfig.moddedTitleScreen.get());
        debugModCheckBox = new Checkbox(this.width / 2 -200, this.height / 4 - 12, 20, 20, new TranslatableComponent("checkbox." + DEMod.MODID + ".debug_mod"), DEConfig.debugMod.get());
        addRenderableWidget(showVersionCheckbox);
        addRenderableWidget(coordLinkerOverlayCheckbox);
        addRenderableWidget(moddedTitleScreenCheckbox);
        addRenderableWidget(debugModCheckBox);
        super.init();
    }

    private void apply(){
        DEConfig.showVersion.set(showVersionCheckbox.selected());
        DEConfig.coordLinkerOverlay.set(coordLinkerOverlayCheckbox.selected());
        DEConfig.moddedTitleScreen.set(moddedTitleScreenCheckbox.selected());
        DEConfig.debugMod.set(debugModCheckBox.selected());
        onClose();
    }

    @Override
    public void onClose() {
        super.onClose();
        if(previousScreen != null){
            minecraft.setScreen(previousScreen);
        }
    }
}
