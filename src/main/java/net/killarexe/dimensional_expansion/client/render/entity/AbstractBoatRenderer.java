package net.killarexe.dimensional_expansion.client.render.entity;

import com.mojang.datafixers.util.Pair;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.utils.DEModelUtils;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ChestRaftModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.RaftModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

public class AbstractBoatRenderer extends BoatRenderer {

	private final ListModel<Boat> models;
	private final String textureLocation;
	private final boolean has_chest;
	private final Style style;
	
    public AbstractBoatRenderer(EntityRendererProvider.Context context, String name, Style style, boolean has_chest) {
        super(context, has_chest);
        this.style = style;
        this.has_chest = has_chest;
        textureLocation = has_chest ? "textures/entity/chest_boat/" + name + ".png" : "textures/entity/boat/" + name + ".png";
        models = createBoatModel(context);
    }
    
    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context) {
    	ModelLayerLocation model = DEModelUtils.createLocation("boat/oak", "main");
        if(has_chest) {
        	model = DEModelUtils.createLocation("chest_boat/oak", "main");
        }
        ModelPart modelpart = context.bakeLayer(model);
        if(style == Style.BAMBOO) {
        	return (ListModel<Boat>)(has_chest ? new ChestRaftModel(modelpart) : new RaftModel(modelpart));
        }
        return (ListModel<Boat>)(has_chest ? new ChestBoatModel(modelpart) : new BoatModel(modelpart));
    }
    
    @Override
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
    	return Pair.of(new ResourceLocation(DEMod.MOD_ID, textureLocation), models);
    }
    
    public enum Style{
    	CLASSIC,
    	BAMBOO
    }
}
