package net.killarexe.dimensional_expansion.client.render.entity;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.models.HeadedSkeletonModel;
import net.killarexe.dimensional_expansion.common.entity.HeadedGuardian;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HeadedGuardianRenderer<T extends HeadedGuardian> extends MobRenderer<T, HeadedSkeletonModel<T>> {
	public static final ResourceLocation GUARDIAN_TEXTURE = new ResourceLocation(DEMod.MOD_ID, "textures/entity/headed/guardian.png"); 

	public HeadedGuardianRenderer(Context pContext) {
		super(pContext, new HeadedSkeletonModel<T>(pContext.bakeLayer(HeadedSkeletonModel.LAYER_LOCATION)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(T pEntity) {
		return GUARDIAN_TEXTURE;
	}
}
