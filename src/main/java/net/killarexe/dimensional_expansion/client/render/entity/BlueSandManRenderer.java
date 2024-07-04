package net.killarexe.dimensional_expansion.client.render.entity;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.models.BlueSandManModel;
import net.killarexe.dimensional_expansion.common.entity.BlueSandMan;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BlueSandManRenderer<T extends BlueSandMan> extends MobRenderer<T, BlueSandManModel<T>>{

	public static final ResourceLocation TEXTURE = DEMod.res("textures/entity/blue_sand_man.png");
	
	public BlueSandManRenderer(Context pContext) {
		super(pContext, new BlueSandManModel<>(pContext.bakeLayer(BlueSandManModel.LAYER_LOCATION)), 1.0F);
	}

	@Override
	public ResourceLocation getTextureLocation(T pEntity) {
		return TEXTURE;
	}
	
}
