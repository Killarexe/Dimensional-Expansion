package net.killarexe.dimensional_expansion.core.config;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;

public final class DEConfigGui extends Screen{

    private static final String displayName = "Dimensional Expansion Config";
    private static final int TITLE_HEIGHT = 8;
    private Screen parent;

    public DEConfigGui() {
        super(new TextComponent(displayName));
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(poseStack);
        drawCenteredString(poseStack, this.font, this.title.getString(),
                this.width / 2, TITLE_HEIGHT, 0xFFFFFF);
        super.render(poseStack, mouseX, mouseY, partialTicks);
    }
}
