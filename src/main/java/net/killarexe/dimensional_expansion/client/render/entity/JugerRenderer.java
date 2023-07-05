package net.killarexe.dimensional_expansion.client.render.entity;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.models.JugerModel;
import net.killarexe.dimensional_expansion.common.entity.Juger;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;

public class JugerRenderer<T extends Juger> extends MobRenderer<T, JugerModel<T>>{

	public static final ResourceLocation TEXTURE = new ResourceLocation(DEMod.MOD_ID, "textures/entity/juger.png");
	
	public JugerRenderer(Context pContext) {
		super(pContext, new JugerModel<>(pContext.bakeLayer(JugerModel.LAYER_LOCATION)), 1.0f);
	}

	@Override
	public ResourceLocation getTextureLocation(T pEntity) {
		return TEXTURE;
	}
}
