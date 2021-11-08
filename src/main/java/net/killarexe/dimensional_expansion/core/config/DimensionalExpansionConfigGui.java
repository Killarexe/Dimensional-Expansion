package net.killarexe.dimensional_expansion.core.config;

import com.mojang.blaze3d.vertex.PoseStack;
import net.killarexe.dimensional_expansion.DimensionalExpansionMod;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;

public final class DimensionalExpansionConfigGui extends Screen{

    private static final String displayName = "Dimensional Expansion Config";
    private Screen parent;

    public DimensionalExpansionConfigGui() {
        super(new TextComponent(displayName));
        this.parent = parent;
    }

    @Override
    public void render(PoseStack p_96562_, int p_96563_, int p_96564_, float p_96565_) {
        super.render(p_96562_, p_96563_, p_96564_, p_96565_);
        this.renderBackground(p_96562_);
    }
}
