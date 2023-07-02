package net.killarexe.dimensional_expansion.client.gui.screen.config;

import java.util.concurrent.Callable;

import com.mojang.blaze3d.vertex.*;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.io.WindowManager;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Button.OnPress;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DEConfigScreen extends Screen {
    private final Screen previousScreen;
    private Button clientButton, commonButton, applyButton;

    public DEConfigScreen(Screen previousScreen) {
        super(Component.empty());
        this.previousScreen = previousScreen;
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
    	WindowManager.setWindowTitle("Dimensional Expansion v" + DEMod.VERSION + " | Config screen");
        this.renderBackground(pPoseStack);
        drawCenteredString(pPoseStack, font, Component.translatable("config." + DEMod.MOD_ID + ".title"), width/2, 10, 0xffffff);
        if(clientButton.isHoveredOrFocused()) {
        	this.renderTooltip(pPoseStack, Component.translatable("button." + DEMod.MOD_ID + ".client_button_desc"), pMouseX, pMouseY);
        }
        if(commonButton.isHoveredOrFocused()) {
        	this.renderTooltip(pPoseStack, Component.translatable("button." + DEMod.MOD_ID + ".common_button_desc"), pMouseX, pMouseY);
        }
        
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    public static OnPress funcOnPress(Callable<Void> func) {
    	return new OnPress() {
			@Override
			public void onPress(Button pButton) {
				try {
					func.call();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
    }
    
    @Override
    protected void init() {  
        applyButton = Button.builder(Component.translatable("button." + DEMod.MOD_ID + ".quit"),(button -> {onClose();}))
        		.bounds(this.width / 2 + 100, this.height / 4 + 48 + 80, 100, 20)
        		.build();
        
        clientButton = Button.builder(Component.translatable("button." + DEMod.MOD_ID + ".client_button"), (button -> {minecraft.setScreen(new DEClientConfigScreen(this));}))
        		.bounds(this.width / 2 - 75, this.height / 4 + 60, 150, 20)
        		.build();
        
        commonButton = Button.builder(Component.translatable("button." + DEMod.MOD_ID + ".common_button"), (button -> {
            minecraft.setScreen(new DECommonConfigScreen(this));
        })).bounds(this.width / 2 - 75, this.height / 4 + 0, 150, 20).build();

        addRenderableWidget(clientButton);
        addRenderableWidget(commonButton);
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
