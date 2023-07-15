package net.killarexe.dimensional_expansion.client.render.entity;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.models.HeadedSkeletonModel;
import net.killarexe.dimensional_expansion.common.entity.HeadedSkeleton;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HeadedSkeletonRenderer<T extends HeadedSkeleton> extends MobRenderer<T, HeadedSkeletonModel<T>> {

	public static final ResourceLocation SKELETON_TEXTURE = new ResourceLocation(DEMod.MOD_ID, "textures/entity/headed/skeleton.png"); 
	
	public HeadedSkeletonRenderer(Context pContext) {
		super(pContext, new HeadedSkeletonModel<>(pContext.bakeLayer(HeadedSkeletonModel.LAYER_LOCATION)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(T pEntity) {
		return SKELETON_TEXTURE;
	}
}
