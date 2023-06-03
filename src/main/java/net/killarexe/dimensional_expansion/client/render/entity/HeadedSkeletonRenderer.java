package net.killarexe.dimensional_expansion.client.render.entity;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.models.HeadedSkeletonModel;
import net.killarexe.dimensional_expansion.common.entity.HeadedSkeleton;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HeadedSkeletonRenderer<T extends HeadedSkeleton> extends MobRenderer<T, HeadedSkeletonModel<T>> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(DEMod.MOD_ID, "textures/entity/headed_skeleton.png"); 
	
	public HeadedSkeletonRenderer(Context pContext) {
		super(pContext, new HeadedSkeletonModel<>(pContext.bakeLayer(HeadedSkeletonModel.LAYER_LOCATION)), 1.0F);
	}

	@Override
	public ResourceLocation getTextureLocation(T pEntity) {
		return TEXTURE;
	}
}
