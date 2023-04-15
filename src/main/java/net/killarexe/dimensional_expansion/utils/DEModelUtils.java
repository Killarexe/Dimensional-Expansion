package net.killarexe.dimensional_expansion.utils;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class DEModelUtils {
	public static ModelLayerLocation createLocation(String pPath, String pModel) {
		return new ModelLayerLocation(new ResourceLocation("minecraft", pPath), pModel);
	}
}
