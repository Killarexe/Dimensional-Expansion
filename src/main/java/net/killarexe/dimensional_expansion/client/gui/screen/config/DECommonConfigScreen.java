package net.killarexe.dimensional_expansion.client.gui.screen.config;

import com.mojang.blaze3d.vertex.PoseStack;
import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DECommonConfigScreen extends Screen {

    private final Screen previousScreen;
    private Button cancelButton, applyButton;

    protected DECommonConfigScreen(Screen previousScreen) {
        super(new TranslatableComponent("narrator.screen.title"));
        this.previousScreen = previousScreen;
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        drawCenteredString(pPoseStack, font, new TranslatableComponent("config." + DEMod.MODID + ".common"), width/2, 10, 0xffffff);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    protected void init() {
        cancelButton = new Button(this.width / 2 -200, this.height / 4 + 48 + 80, 100, 20, new TranslatableComponent("button." + DEMod.MODID + ".cancel_button"), (button -> {
            onClose();
        }));
        applyButton = new Button(this.width / 2 +100, this.height / 4 + 48 + 80, 100, 20, new TranslatableComponent("button." + DEMod.MODID + ".apply_button"), (button -> {
            onClose();
        }));
        addRenderableWidget(cancelButton);
        addRenderableWidget(applyButton);

        super.init();
    }

    private void apply(){
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