package net.killarexe.dimensional_expansion.client.render.entity;

import org.joml.Vector3d;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.models.MouvetModel;
import net.killarexe.dimensional_expansion.common.entity.Mouvet;
import net.killarexe.dimensional_expansion.client.render.RenderUtils;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.MobRenderer;

public class MouvetRenderer<T extends Mouvet> extends MobRenderer<T, MouvetModel<T>>{

	public static final ResourceLocation TEXTURE = DEMod.res("textures/entity/mouvet.png");
	
	public MouvetRenderer(Context pContext) {
		super(pContext, new MouvetModel<T>(pContext.bakeLayer(MouvetModel.LAYER_LOCATION)), 0.25f);
	}
	
	@Override
	public void render(T pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
			MultiBufferSource pBuffer, int pPackedLight) {
		if(!pEntity.getCurrentItem().isEmpty()) {
			float x = (float)Math.sin(Math.toRadians(pEntity.yBodyRot)) * 0.2F;
			float z	= (float)Math.cos(Math.toRadians(pEntity.yBodyRot)) * 0.2F;
	        RenderUtils.renderItem(
	        		pEntity.getCurrentItem(),
	        		new Vector3d(-x, 0.01F, z),
	        		Axis.XP.rotation((float)Math.toRadians(90.0)).mul(Axis.ZP.rotation((float)Math.toRadians(pEntity.yBodyRot - 25.0))),
	        		pMatrixStack, pBuffer,
	        		pEntity.level(),
	        		pEntity.blockPosition(),
	        		0.25f	
	        );
		}
		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
	}
	
	@Override
	public ResourceLocation getTextureLocation(T pEntity) {
		return TEXTURE;
	}

}
