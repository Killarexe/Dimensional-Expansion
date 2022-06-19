package net.killarexe.dimensional_expansion.client.gui.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PowerGauntletScreen extends Screen {

    private ImageButton weather, time, warp;

    public PowerGauntletScreen() {
        super(Component.translatable("screen." + DEMod.MOD_ID + ".power_gauntlet_screen"));
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
                height/2, new ResourceLocation(DEMod.MOD_ID, "textures/item/palon_ingot.png"),
                256, 256, (pButton -> {weather();})
        );
        time = new ImageButton(
                width/2, height/2, 16,
                16, 0, 0,
                height/2, new ResourceLocation(DEMod.MOD_ID, "textures/item/palon_ingot.png"),
                256, 256, (pButton -> {time();})
        );
        warp = new ImageButton(
                width/2, height/2, 16,
                16, 0, 0,
                height/2, new ResourceLocation(DEMod.MOD_ID, "textures/item/palon_ingot.png"),
                256, 256, (pButton -> {warp();})
        );
        addRenderableWidget(weather);
        addRenderableWidget(time);
        addRenderableWidget(warp);
        super.init();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    private void weather(){
    	DEItems.WEATHER_POWER_STONE.get().use(minecraft.level, minecraft.player, minecraft.player.getUsedItemHand());
    }
    
    private void time() {
    	
    }
    
    private void warp() {
    	
    }
}
