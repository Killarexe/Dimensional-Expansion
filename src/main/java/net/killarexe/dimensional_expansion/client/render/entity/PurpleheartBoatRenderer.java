package net.killarexe.dimensional_expansion.client.render.entity;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.entity.PurpleheartBoatEntity;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Map;
import java.util.stream.Stream;

public class PurpleheartBoatRenderer extends BoatRenderer {

    private final Map<PurpleheartBoatEntity.Type, Pair<ResourceLocation, BoatModel>> boatResources;

    public PurpleheartBoatRenderer(EntityRendererProvider.Context context) {
        super(context, false);
        shadowRadius = 0.8f;
        boatResources = Stream.of(PurpleheartBoatEntity.Type.values())
                .collect(ImmutableMap.toImmutableMap((p_173938_) -> p_173938_, (type) ->
                        Pair.of(new ResourceLocation(DEMod.MOD_ID, "textures/entity/boat/" + type.getName() + ".png"),
                                new BoatModel(context.bakeLayer(new ModelLayerLocation(
                                                        new ResourceLocation("minecraft", "boat/oak"),
                                                        "main")), false
                                ))));
    }

    @Override
    public ResourceLocation getTextureLocation(Boat pEntity) {
        if(pEntity instanceof PurpleheartBoatEntity boat){
            return boatResources.get(boat.getDEBoatType()).getFirst();
        }
        return new ResourceLocation("minecraft", "boat/oak");
    }

    @Override
    public Pair<ResourceLocation, BoatModel> getModelWithLocation(Boat boat) {
        if(boat instanceof PurpleheartBoatEntity entity){
            return boatResources.get(entity.getDEBoatType());
        }
        return null;
    }
}
