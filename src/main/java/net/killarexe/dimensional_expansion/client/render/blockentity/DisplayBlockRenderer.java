package net.killarexe.dimensional_expansion.client.render.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.*;
import net.killarexe.dimensional_expansion.common.block.entity.DisplayBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;

public class DisplayBlockRenderer<T extends BlockEntity> implements BlockEntityRenderer<DisplayBlockEntity> {

    private final Minecraft mc = Minecraft.getInstance();

    public DisplayBlockRenderer(BlockEntityRendererProvider.Context context){

    }

    @Override
    public void render(DisplayBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        if (pBlockEntity.getItemInSlot(0).equals(ItemStack.EMPTY) || pBlockEntity.getItemInSlot(0).getItem().equals(Items.AIR))
            return;

        renderItem(pBlockEntity.getItemInSlot(0), new Vector3d(0.5, 1.5, 0.5),
                Vector3f.YN.rotation(0), pPoseStack, pBufferSource, pPackedOverlay, pPackedLight, 0.8f);

        Component label = Component.literal(pBlockEntity.getItemInSlot(0).getHoverName().getString());

        renderLabel(pPoseStack, pBufferSource, pPackedLight, new Vector3d(0.5, 1.75, 0.5), label, 0xffffff);
    }

    private void renderItem(ItemStack stack, Vector3d translation, Quaternion rotation, PoseStack matrixStack,
                            MultiBufferSource buffer, int combinedOverlay, int combinedLight, float scale) {
        matrixStack.pushPose();
        matrixStack.translate(translation.x, translation.y, translation.z);
        matrixStack.mulPose(rotation);
        matrixStack.scale(scale, scale, scale);

        mc.getItemRenderer().renderStatic(
                Minecraft.getInstance().player, stack, ItemTransforms.TransformType.FIXED, false,
                matrixStack, buffer, Minecraft.getInstance().level, combinedLight, combinedOverlay, 0
        );
        matrixStack.popPose();
    }

    private void renderLabel(PoseStack stack, MultiBufferSource buffer, int lightLevel, Vector3d corner, Component text, int color) {

        Font font = mc.font;

        stack.pushPose();
        float scale = 0.025f;
        int opacity = (int) (.4f * 255.0f) << 24;
        float offset = (float) (-font.width(text) / 2);
        Matrix4f matrix = stack.last().pose();

        stack.translate(corner.x, corner.y + .4f, corner.z);
        stack.scale(scale, scale, scale);
        stack.mulPose(Vector3f.YP.rotationDegrees(-mc.player.getYRot()));
        stack.mulPose(Vector3f.ZP.rotationDegrees(180f));

        font.drawInBatch(text, offset, 0, color, false, matrix, buffer, false, opacity, lightLevel);
        stack.popPose();
    }

    @Override
    public int getViewDistance() {
        return 32;
    }
}
