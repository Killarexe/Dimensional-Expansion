package net.killarexe.dimensional_expansion.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.animations.JugerAnimations;
import net.killarexe.dimensional_expansion.common.entity.Juger;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

//Made with Blockbench 4.7.4
//Exported for Minecraft version 1.17 or later with Mojang mappings
//Paste this class into your mod and generate all required imports

public class JugerModel<T extends Juger> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(DEMod.MOD_ID, "juger"), "juger");
	
	private final ModelPart root;
	private final ModelPart head;

	public JugerModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(21, 16).addBox(-4.0F, -8.0F, -9.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		mouth.addOrReplaceChild("up", CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, -2.0F, -12.0F, 4.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(25, 5).addBox(-2.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(25, 2).addBox(-2.0F, -1.0F, -6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 24).addBox(-2.0F, -1.0F, -10.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(21, 16).addBox(1.0F, -1.0F, -10.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(21, 19).addBox(1.0F, -1.0F, -6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 24).addBox(1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -9.0F));

		mouth.addOrReplaceChild("down", CubeListBuilder.create().texOffs(21, 2).addBox(-2.0F, 1.0F, -12.0F, 4.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(6, 21).addBox(-2.0F, 0.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 21).addBox(-2.0F, 0.0F, -8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 18).addBox(-2.0F, 0.0F, -12.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(1.0F, 0.0F, -12.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 15).addBox(1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(1.0F, 0.0F, -8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -9.0F));

		head.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(0, 4).addBox(-6.0F, -6.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(4.0F, -6.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(28, 28).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_legs = legs.addOrReplaceChild("left_legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition first_left_part = left_legs.addOrReplaceChild("first_left_part", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition first_left = first_left_part.addOrReplaceChild("first_left", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		first_left.addOrReplaceChild("first_r1", CubeListBuilder.create().texOffs(35, 38).addBox(0.0F, -6.0F, -2.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0894F, 0.3829F, 0.6718F));

		PartDefinition third_left = first_left_part.addOrReplaceChild("third_left", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		third_left.addOrReplaceChild("third_r1", CubeListBuilder.create().texOffs(0, 35).addBox(0.0F, -5.0F, 0.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2182F, 0.4363F));

		PartDefinition second_left_part = left_legs.addOrReplaceChild("second_left_part", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition second_left = second_left_part.addOrReplaceChild("second_left", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		second_left.addOrReplaceChild("second_r1", CubeListBuilder.create().texOffs(17, 38).addBox(0.0F, -5.0F, -1.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1309F, 0.4363F));

		PartDefinition forth_left = second_left_part.addOrReplaceChild("forth_left", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		forth_left.addOrReplaceChild("forth_r1", CubeListBuilder.create().texOffs(0, 37).addBox(0.0F, -6.0F, 2.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0894F, -0.3829F, 0.6718F));

		PartDefinition right_legs = legs.addOrReplaceChild("right_legs", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition first_right_part = right_legs.addOrReplaceChild("first_right_part", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition first_right = first_right_part.addOrReplaceChild("first_right", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		first_right.addOrReplaceChild("first_r2", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -6.0F, 2.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0894F, -0.3829F, 0.6718F));

		PartDefinition third_right = first_right_part.addOrReplaceChild("third_right", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		third_right.addOrReplaceChild("third_r2", CubeListBuilder.create().texOffs(0, 29).addBox(0.0F, -5.0F, -1.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1309F, 0.4363F));

		PartDefinition second_right_part = right_legs.addOrReplaceChild("second_right_part", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition second_right = second_right_part.addOrReplaceChild("second_right", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		second_right.addOrReplaceChild("second_r2", CubeListBuilder.create().texOffs(25, 0).addBox(0.0F, -5.0F, 0.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2182F, 0.4363F));

		PartDefinition forth_right = second_right_part.addOrReplaceChild("forth_right", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		forth_right.addOrReplaceChild("forth_r2", CubeListBuilder.create().texOffs(0, 33).addBox(0.0F, -6.0F, -2.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0894F, 0.3829F, 0.6718F));

		PartDefinition ass = partdefinition.addOrReplaceChild("ass", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		ass.addOrReplaceChild("ass_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, 3.0F, 8.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root().getAllParts().forEach(ModelPart::resetPose);

		netHeadYaw = Mth.clamp(netHeadYaw, -30.0F, 30.0F);
		headPitch = Mth.clamp(headPitch, -25.0F, 45.0F);
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = headPitch * ((float)Math.PI / 180F);
		
		animateWalk(JugerAnimations.JUGER_WALK, limbSwing, limbSwingAmount, 2.5F, 2.0F);
		animate(entity.getAttackState(), JugerAnimations.JUGER_ATTACK, ageInTicks, 1.0F);
		animate(entity.getStandState(), JugerAnimations.JUGER_STAND, ageInTicks, 1.0F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root().render(poseStack, vertexConsumer, packedLight, packedOverlay);
	}

	@Override
	public ModelPart root() {
		return root;
	}
}