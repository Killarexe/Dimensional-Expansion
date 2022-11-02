package net.killarexe.dimensional_expansion.client.gui.screen.config;

import com.mojang.blaze3d.vertex.PoseStack;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.gui.component.SwitchButton;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.utils.DEUtils;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DEClientConfigScreen extends Screen {

    private final Screen previousScreen;
    private Button cancelButton, applyButton;
    private SwitchButton moddedScreensCheckbox, showVersionCheckbox, coordLinkerOverlayCheckbox, debugModCheckBox;

    public DEClientConfigScreen(Screen previousScreen) {
        super(MutableComponent.create(new TranslatableContents("narrator.screen.title")));
        this.previousScreen = previousScreen;
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        DEUtils.setWindowTitle("Dimensional Expansion v" + DEMod.VERSION + " | Client Config screen");
        drawCenteredString(pPoseStack, font, MutableComponent.create(new TranslatableContents("config." + DEMod.MOD_ID + ".client")), width / 2, 10, 0xffffff);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    protected void init() {
        cancelButton = new Button(this.width / 2 -200, this.height / 4 + 48 + 80, 100, 20, MutableComponent.create(new TranslatableContents("button." + DEMod.MOD_ID + ".cancel_button")), (button -> {
            onClose();
        }));
        applyButton = new Button(this.width / 2 +100, this.height / 4 + 48 + 80, 100, 20, MutableComponent.create(new TranslatableContents("button." + DEMod.MOD_ID + ".apply_button")), (button -> {
            apply();
        }));
        addRenderableWidget(cancelButton);
        addRenderableWidget(applyButton);

        moddedScreensCheckbox = new SwitchButton(this.width / 2 - 200, this.height / 4 + 8, 20, 20, MutableComponent.create(new TranslatableContents("checkbox." + DEMod.MOD_ID + ".modded_screens")), DEConfig.moddedScreens.get());
        showVersionCheckbox = new SwitchButton(this.width / 2 - 200, this.height / 4 + 78, 20, 20, MutableComponent.create(new TranslatableContents("checkbox." + DEMod.MOD_ID + ".show_version")), DEConfig.showVersion.get());
        coordLinkerOverlayCheckbox = new SwitchButton(this.width / 2 -200, this.height / 4 + 48, 20, 20, MutableComponent.create(new TranslatableContents("checkbox." + DEMod.MOD_ID + ".coords_linker")), DEConfig.coordLinkerOverlay.get());
        debugModCheckBox = new SwitchButton(this.width / 2 - 200, this.height / 4 - 22, 20, 20, MutableComponent.create(new TranslatableContents("checkbox." + DEMod.MOD_ID + ".debug_mod")), DEConfig.debugMod.get());
        addRenderableWidget(showVersionCheckbox);
        addRenderableWidget(coordLinkerOverlayCheckbox);
        addRenderableWidget(moddedScreensCheckbox);
        if(DEUtils.isDev() || DEUtils.isDevAccount()) {
            addRenderableWidget(debugModCheckBox);
        }
        super.init();
    }

    private void apply(){
        DEConfig.showVersion.set(showVersionCheckbox.isEnabled());
        DEConfig.coordLinkerOverlay.set(coordLinkerOverlayCheckbox.isEnabled());
        DEConfig.moddedScreens.set(moddedScreensCheckbox.isEnabled());
        DEConfig.debugMod.set(debugModCheckBox.isEnabled());
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
