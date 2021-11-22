package net.killarexe.dimensional_expansion.common.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.container.WeatherChangerContainer;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class WeatherChangerScreen extends AbstractContainerScreen<WeatherChangerContainer> {

    private final ResourceLocation GUI = new ResourceLocation(DEMod.MODID, "textures/gui/weather_changer_gui.png");

    public WeatherChangerScreen(WeatherChangerContainer p_97741_, Inventory p_97742_, Component p_97743_) {
        super(p_97741_, p_97742_, p_97743_);
    }

    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(stack);
        super.render(stack, mouseX, mouseY, partialTicks);
        this.renderTooltip(stack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack p_97787_, float p_97788_, int p_97789_, int p_97790_) {
        RenderSystem.clearColor(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().getTexture(GUI);
        int i = this.getGuiLeft();
        int j = this.getGuiTop();
        this.blit(p_97787_, i, j, 0, 0, this.getXSize(), this.getYSize());


    }


}
