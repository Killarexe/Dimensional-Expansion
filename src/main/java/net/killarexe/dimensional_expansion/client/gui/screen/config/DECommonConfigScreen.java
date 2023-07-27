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
import net.minecraftforge.client.gui.widget.ForgeSlider;

@OnlyIn(Dist.CLIENT)
public class DECommonConfigScreen extends Screen {

    private final Screen previousScreen;
    private Button cancelButton, applyButton;
    private SwitchButton enablePowerStones;
    private ForgeSlider powerStonesDelay;

    protected DECommonConfigScreen(Screen previousScreen) {
        super(Component.empty());
        this.previousScreen = previousScreen;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(guiGraphics);
        WindowManager.setWindowTitle("Dimensional Expansion v" + DEMod.VERSION + " | Common Config screen");
        
        if(enablePowerStones.isHovered()) {
        	guiGraphics.renderTooltip(font, Component.translatable("config." + DEMod.MOD_ID + ".enable_power_stones_desc"), pMouseX, pMouseY);
        }
        
        powerStonesDelay.active = enablePowerStones.isEnabled();
        guiGraphics.drawCenteredString(font, Component.translatable("config." + DEMod.MOD_ID + ".common"), width/2, 10, 0xffffff);
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);

        if(powerStonesDelay.isHovered()) {
        	guiGraphics.renderTooltip(font, Component.translatable("config." + DEMod.MOD_ID + ".power_stones_delay_desc"), pMouseX, pMouseY);
        }
    }

    @Override
    protected void init() {
        cancelButton = Button.builder(Component.translatable("button." + DEMod.MOD_ID + ".cancel_button"), (button -> {onClose();}))
        		.bounds(this.width / 2 -200, this.height / 4 + 48 + 80, 100, 20)
        		.build();
        
        applyButton = Button.builder(Component.translatable("button." + DEMod.MOD_ID + ".apply_button"), (button -> {apply();}))
        		.bounds(this.width / 2 +100, this.height / 4 + 48 + 80, 100, 20)
        		.build();
        
        enablePowerStones = new SwitchButton(
        		this.width / 2 - 200,
        		this.height / 4 + 8,
        		20,
        		20,
        		Component.translatable("config." + DEMod.MOD_ID + ".enable_power_stones"),
        		DEConfig.moddedScreens.get()
        );
        
        powerStonesDelay = new ForgeSlider(
        		this.width / 2 - 200,
        		this.height / 4 + 78,
        		256,
        		20,
        		Component.translatable("config." + DEMod.MOD_ID + ".power_stones_delay").append(": "),
        		Component.translatable(DEMod.MOD_ID + ".seconds"),
        		50,
        		200,
        		DEConfig.powerStoneDelay.get(),
        		true
        );
        		
        
        addRenderableWidget(cancelButton);
        addRenderableWidget(applyButton);
        addRenderableWidget(enablePowerStones);
        addRenderableWidget(powerStonesDelay);

        super.init();
    }

    private void apply(){
    	DEConfig.enablePowerStones.set(enablePowerStones.isEnabled());
    	DEConfig.powerStoneDelay.set(powerStonesDelay.getValueInt());
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
