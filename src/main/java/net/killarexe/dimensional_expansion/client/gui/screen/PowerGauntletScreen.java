package net.killarexe.dimensional_expansion.client.gui.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

public class PowerGauntletScreen extends Screen {

    private ImageButton weather, time, warp;

    public PowerGauntletScreen() {
        super(new TranslatableComponent("screen." + DEMod.MODID + ".power_gauntlet_screen"));
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    protected void init() {
        weather = new ImageButton(
                width/2, height/2, 16,
                16, 0, 0,
                height/2, new ResourceLocation(DEMod.MODID, "textures/items/palon_ingot.png"),
                256, 256, (pButton -> {weather();})
        );
        addRenderableWidget(weather);
        super.init();
    }

    @Override
    public boolean isPauseScreen() {
        return true;
    }

    private void weather(){

    }
}
