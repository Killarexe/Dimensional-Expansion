package net.killarexe.dimensional_expansion.client.gui.screen.config;

import com.mojang.blaze3d.vertex.PoseStack;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.utils.DEWindowUtils;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DECommonConfigScreen extends Screen {

    private final Screen previousScreen;
    private Button cancelButton, applyButton;

    protected DECommonConfigScreen(Screen previousScreen) {
        super(MutableComponent.create(new TranslatableContents("narrator.screen.title")));
        this.previousScreen = previousScreen;
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
    	DEWindowUtils.setWindowTitle("Dimensional Expansion v" + DEMod.VERSION + " | Common Config screen");
        renderBackground(pPoseStack);
        drawCenteredString(pPoseStack, font, MutableComponent.create(new TranslatableContents("config." + DEMod.MOD_ID + ".common")), width/2, 10, 0xffffff);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    protected void init() {
        cancelButton = Button.builder(MutableComponent.create(new TranslatableContents("button." + DEMod.MOD_ID + ".cancel_button")), (button -> {onClose();}))
        		.bounds(this.width / 2 -200, this.height / 4 + 48 + 80, 100, 20)
        		.build();
        
        applyButton = Button.builder(MutableComponent.create(new TranslatableContents("button." + DEMod.MOD_ID + ".apply_button")), (button -> {apply();}))
        		.bounds(this.width / 2 +100, this.height / 4 + 48 + 80, 100, 20)
        		.build();
        
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
