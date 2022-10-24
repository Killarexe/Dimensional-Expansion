package net.killarexe.dimensional_expansion.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.uitls.DEUtils;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class CapeLayer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>>{

	public CapeLayer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> pRenderer) {
		super(pRenderer);
	}

	@Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int p_117351_, AbstractClientPlayer player, float p_117353_, float p_117354_, float p_116621_, float p_117356_, float p_117357_, float p_117358_) {
		String url = "https://raw.githubusercontent.com/Killarexe/Dimensional-Expansion/main/src/main/resources/assets/dimensional_expansion/textures/models/capes/" + player.getName().getString() + ".png";
		DEMod.LOGGER.warn(url);
		if(!DEUtils.isResponsive(url)) {
			return;
		}
        ItemStack itemstack = player.getItemBySlot(EquipmentSlot.CHEST);
        if (!itemstack.is(Items.ELYTRA)) {
            poseStack.pushPose();
            poseStack.translate(0.0D, 0.0D, 0.125D);
            double d0 = Mth.lerp((double)p_116621_, player.xCloakO, player.xCloak) - Mth.lerp((double)p_116621_, player.xo, player.getX());
            double d1 = Mth.lerp((double)p_116621_, player.yCloakO, player.yCloak) - Mth.lerp((double)p_116621_, player.yo, player.getY());
            double d2 = Mth.lerp((double)p_116621_, player.zCloakO, player.zCloak) - Mth.lerp((double)p_116621_, player.zo, player.getZ());
            float f = player.yBodyRotO + (player.yBodyRot - player.yBodyRotO);
            double d3 = (double)Mth.sin(f * ((float)Math.PI / 180F));
            double d4 = (double)(-Mth.cos(f * ((float)Math.PI / 180F)));
            float f1 = (float)d1 * 10.0F;
            f1 = Mth.clamp(f1, -6.0F, 32.0F);
            float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
            f2 = Mth.clamp(f2, 0.0F, 150.0F);
            float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;
            f3 = Mth.clamp(f3, -20.0F, 20.0F);
            if (f2 < 0.0F) {
                f2 = 0.0F;
            }

            float f4 = Mth.lerp(p_116621_, player.oBob, player.bob);
            f1 += Mth.sin(Mth.lerp(p_116621_, player.walkDistO, player.walkDist) * 6.0F) * 32.0F * f4;
            if (player.isCrouching()) {
                f1 += 25.0F;
            }

            poseStack.mulPose(Vector3f.XP.rotationDegrees(6.0F + f2 / 2.0F + f1));
            poseStack.mulPose(Vector3f.ZP.rotationDegrees(f3 / 2.0F));
            poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - f3 / 2.0F));
            checkCapeAndApply(url, poseStack, buffer, player, p_117351_);
            poseStack.popPose();
        }
    }
	
	private void checkCapeAndApply(String url, PoseStack poseStack, MultiBufferSource multiBufferSource, AbstractClientPlayer abstractClientPlayer, int integer){
		VertexConsumer vertexconsumer;
		vertexconsumer = multiBufferSource.getBuffer(RenderType.entitySolid(DEUtils.getImageFromURL(url, abstractClientPlayer.getName().getString())));
        this.getParentModel().renderCloak(poseStack, vertexconsumer, integer, OverlayTexture.NO_OVERLAY);
    }
}
