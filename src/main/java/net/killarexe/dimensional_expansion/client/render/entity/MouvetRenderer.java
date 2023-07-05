package net.killarexe.dimensional_expansion.client.render.entity;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.models.MouvetModel;
import net.killarexe.dimensional_expansion.common.entity.Mouvet;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;

public class MouvetRenderer<T extends Mouvet> extends MobRenderer<T, MouvetModel<T>>{

	public static final ResourceLocation TEXTURE = new ResourceLocation(DEMod.MOD_ID, "textures/entity/mouvet.png");
	
	public MouvetRenderer(Context pContext) {
		super(pContext, new MouvetModel<>(pContext.bakeLayer(MouvetModel.LAYER_LOCATION)), 0.25f);
	}
	
	@Override
	public ResourceLocation getTextureLocation(T pEntity) {
		return TEXTURE;
	}

}
