package net.killarexe.dimensional_expansion.client.render.entity;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.entity.PurpleheartBoatEntity;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

public class PurpleheartBoatRenderer extends BoatRenderer {

    public PurpleheartBoatRenderer(EntityRendererProvider.Context context) {
        super(context, false);
        shadowRadius = 0.8f;
    }

    @Override
    public ResourceLocation getTextureLocation(Boat pEntity) {
        if(pEntity instanceof PurpleheartBoatEntity boat){
            return new ResourceLocation(DEMod.MOD_ID, "textures/entity/chest_boat/boat/purpleheart.png");
        }
        return new ResourceLocation(DEMod.MOD_ID, "textures/entity/chest_boat/boat/purpleheart.png");
    }
}
