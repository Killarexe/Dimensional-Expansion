package net.killarexe.dimensional_expansion.client.render.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Matrix4f;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3d;
import com.mojang.math.Vector3f;
import net.killarexe.dimensional_expansion.common.block.entity.DisplayBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class DisplayBlockRenderer implements BlockEntityRenderer<DisplayBlockEntity> {

    private Minecraft mc = Minecraft.getInstance();

    public DisplayBlockRenderer(BlockEntityRendererProvider.Context context){

    }

    @Override
    public void render(DisplayBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        if (pBlockEntity.getItemInSlot(0).equals(ItemStack.EMPTY) || pBlockEntity.getItemInSlot(0).getItem().equals(Items.AIR))
            return;

        int lightLevel = getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos().above());

        renderItem(pBlockEntity.getItemInSlot(0), new Vector3d(0.5, 1.5, 0.5),
                Vector3f.YN.rotation(0), pPoseStack, pBufferSource, pPackedOverlay, lightLevel, 0.8f);

        TextComponent label = new TextComponent(pBlockEntity.getItemInSlot(0).getDisplayName().getContents());

        renderLabel(pPoseStack, pBufferSource, lightLevel, new Vector3d(0.5, 1.75, 0.5), label, 0xffffff);
    }

    private void renderItem(ItemStack stack, Vector3d translation, Quaternion rotation, PoseStack matrixStack,
                            MultiBufferSource buffer, int combinedOverlay, int lightLevel, float scale) {
        matrixStack.pushPose();
        matrixStack.translate(translation.x, translation.y, translation.z);
        matrixStack.mulPose(rotation);
        matrixStack.scale(scale, scale, scale);

        BakedModel model = mc.getItemRenderer().getModel(stack, null, null, 0);
        mc.getItemRenderer().render(stack, ItemTransforms.TransformType.GROUND, true, matrixStack, buffer,
                lightLevel, combinedOverlay, model);
        matrixStack.popPose();
    }

    private void renderLabel(PoseStack stack, MultiBufferSource buffer, int lightLevel, Vector3d corner, TextComponent text, int color) {

        Font font = mc.font;

        stack.pushPose();
        float scale = 0.1f;
        int opacity = (int) (.4f * 255.0f) << 24;
        float offset = (float) (font.width(text) / 2);
        Matrix4f matrix = stack.last().pose();

        stack.translate(corner.x, corner.y + .4f, corner.z);
        stack.scale(scale, scale, scale);
        stack.mulPose(Vector3f.YP.rotationDegrees(-mc.player.getYRot()));
        stack.mulPose(Vector3f.ZP.rotationDegrees(90f));

        font.drawInBatch(text, offset, 0, color, false, matrix, buffer, false, opacity, lightLevel);
        stack.popPose();
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBlockState(pos).getLightEmission(level, pos);
        int sLight = level.getSkyDarken();
        return level.getMaxLightLevel();
    }
}
