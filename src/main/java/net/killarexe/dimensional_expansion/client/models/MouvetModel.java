package net.killarexe.dimensional_expansion.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.entity.Mouvet;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

//Made with Blockbench 4.7.4
//Exported for Minecraft version 1.17 or later with Mojang mappings
//Paste this class into your mod and generate all required imports


public class MouvetModel<T extends Mouvet> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(DEMod.res("mouvet"), "main");
	private final ModelPart face;
	private final ModelPart body;

	public MouvetModel(ModelPart root) {
		this.face = root.getChild("face");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition face = partdefinition.addOrReplaceChild("face", CubeListBuilder.create().texOffs(10, 10).addBox(-0.25F, -0.75F, -2.25F, 0.5F, 0.5F, 0.25F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		face.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(7, 11).addBox(0.25F, -1.5F, -2.5F, 0.5F, 0.5F, 0.5F, new CubeDeformation(0.0F))
		.texOffs(3, 11).addBox(-0.75F, -1.5F, -2.5F, 0.5F, 0.5F, 0.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ears = face.addOrReplaceChild("ears", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		ears.addOrReplaceChild("left_ear_r1", CubeListBuilder.create().texOffs(8, 6).addBox(-1.0F, -2.0F, -1.5F, 1.0F, 1.0F, 0.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		ears.addOrReplaceChild("left_ear_r2", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -2.0F, -1.5F, 1.0F, 1.0F, 0.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.5F, -2.0F, 2.0F, 1.5F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(1, 7).addBox(-0.25F, -0.5F, 2.0F, 0.5F, 0.5F, 2.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		face.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
	
}