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
	
	private final ModelPart head;
	private final ModelPart root;
	

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

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 28).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_legs = legs.addOrReplaceChild("left_legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		left_legs.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 35).addBox(0.0F, -5.0F, 0.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2182F, 0.4363F));

		left_legs.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(17, 38).addBox(0.0F, -5.0F, -1.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1309F, 0.4363F));

		left_legs.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 37).addBox(0.0F, -6.0F, 2.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0894F, -0.3829F, 0.6718F));

		left_legs.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(35, 38).addBox(0.0F, -6.0F, -2.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0894F, 0.3829F, 0.6718F));

		PartDefinition right_legs = legs.addOrReplaceChild("right_legs", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		right_legs.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(25, 0).addBox(0.0F, -5.0F, 0.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2182F, 0.4363F));

		right_legs.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 29).addBox(0.0F, -5.0F, -1.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1309F, 0.4363F));

		right_legs.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -6.0F, 2.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0894F, -0.3829F, 0.6718F));

		right_legs.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 33).addBox(0.0F, -6.0F, -2.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0894F, 0.3829F, 0.6718F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		bb_main.addOrReplaceChild("ass_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, 3.0F, 8.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root().getAllParts().forEach(ModelPart::resetPose);
		animateWalk(JugerAnimations.JUGER_WALK, limbSwing, limbSwingAmount, 1.0F, 1.0F);
		animate(entity.getAttackState(), JugerAnimations.JUGER_ATTACK, 1.0F);
		animate(entity.getStandState(), JugerAnimations.JUGER_STAND, 1.0F);
		netHeadYaw = Mth.clamp(netHeadYaw, -30.0F, 30.0F);
		headPitch = Mth.clamp(headPitch, -25.0F, 45.0F);
	    this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
	    this.head.xRot = headPitch * ((float)Math.PI / 180F);
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