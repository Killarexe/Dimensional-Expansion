package net.killarexe.dimensional_expansion.utils;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3d;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class DERenderUtils {
	public static void renderItem(ItemStack stack, Vector3d translation, Quaternionf rotation, PoseStack matrixStack, MultiBufferSource buffer, Level level, BlockPos pos, float scale) {
        matrixStack.pushPose();
        matrixStack.translate(translation.x, translation.y, translation.z);
        matrixStack.mulPose(rotation);
        matrixStack.scale(scale, scale, scale);

        Minecraft.getInstance().getItemRenderer().renderStatic(
				stack,
				ItemDisplayContext.FIXED,
				getLightLevel(level, pos),
				OverlayTexture.NO_OVERLAY,
				matrixStack,
				buffer,
				level,
				1
		);
        matrixStack.popPose();
    }
	
	public static void renderLabel(PoseStack stack, MultiBufferSource buffer, int lightLevel, Vector3d corner, Component text, int color) {
    	Minecraft mc = Minecraft.getInstance();
		Font font = mc.font;
        float scale = 0.025f;
        int opacity = (int) (.4f * 255.0f) << 24;
        float offset = (float) (-font.width(text) / 2);
        stack.pushPose();
        Matrix4f matrix = stack.last().pose();
        stack.translate(corner.x, corner.y + .4f, corner.z);
        stack.scale(scale, scale, scale);
        stack.mulPose(Axis.YP.rotationDegrees(-mc.player.getYRot()));
        stack.mulPose(Axis.ZP.rotationDegrees(180f));
        font.drawInBatch(text, offset, 0, color, false, matrix, buffer, Font.DisplayMode.NORMAL, opacity, lightLevel);
        stack.popPose();
    }
	
	public static int getLightLevel(Level level, BlockPos pos){
		int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);	
	}
}
