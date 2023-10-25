package net.killarexe.dimensional_expansion.client.gui.screen.config;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.gui.component.SwitchButton;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.io.WindowManager;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DEClientConfigScreen extends Screen {

    private final Screen previousScreen;
    private Button cancelButton, applyButton;
    private SwitchButton showVersionCheckbox, debugModCheckBox;

    public DEClientConfigScreen(Screen previousScreen) {
        super(Component.empty());
        this.previousScreen = previousScreen;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(guiGraphics, pMouseX, pMouseY, pPartialTick);
        WindowManager.setWindowTitle("Dimensional Expansion v" + DEMod.VERSION + " | Client Config screen");
        
        if(showVersionCheckbox.isHovered()) {
        	guiGraphics.renderTooltip(font, Component.translatable("config." + DEMod.MOD_ID + ".show_version_desc"), pMouseX, pMouseY);
        }
        if(debugModCheckBox.isHovered()) {
        	guiGraphics.renderTooltip(font, Component.translatable("config." + DEMod.MOD_ID + ".dev_mod_desc"), pMouseX, pMouseY);
        }
        
        guiGraphics.drawCenteredString(font, Component.translatable("config." + DEMod.MOD_ID + ".client"), width / 2, 10, 0xffffff);
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    protected void init() {
    	cancelButton = Button.builder(Component.translatable("button." + DEMod.MOD_ID + ".cancel_button"), (button -> {onClose();}))
        		.bounds(this.width / 2 -200, this.height / 4 + 48 + 80, 100, 20)
        		.build();
        applyButton = Button.builder(Component.translatable("button." + DEMod.MOD_ID + ".apply_button"), (button -> {apply();}))
        		.bounds(this.width / 2 +100, this.height / 4 + 48 + 80, 100, 20)
        		.build();
        addRenderableWidget(cancelButton);
        addRenderableWidget(applyButton);

        showVersionCheckbox = new SwitchButton(this.width / 2 - 200, this.height / 4 + 78, 20, 20, Component.translatable("config." + DEMod.MOD_ID + ".show_version"), DEConfig.showVersion.get());
        debugModCheckBox = new SwitchButton(this.width / 2 - 200, this.height / 4 - 22, 20, 20, Component.translatable("config." + DEMod.MOD_ID + ".dev_mod"), DEConfig.devMod.get());
        addRenderableWidget(showVersionCheckbox);
        if(DEConfig.isDev() || DEConfig.isDevAccount()) {
            addRenderableWidget(debugModCheckBox);
        }
        super.init();
    }

    private void apply(){
        DEConfig.showVersion.set(showVersionCheckbox.isEnabled());
        DEConfig.devMod.set(debugModCheckBox.isEnabled());
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
