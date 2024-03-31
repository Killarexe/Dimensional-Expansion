package net.killarexe.dimensional_expansion.client.render.blockentity;

import org.joml.Vector3d;
import org.joml.Vector3f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.killarexe.dimensional_expansion.common.block.entity.EnchantTransferTableEntity;
import net.killarexe.dimensional_expansion.client.render.RenderUtils;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;

public class EnchantTransferTableRenderer<T extends BlockEntity> implements BlockEntityRenderer<EnchantTransferTableEntity> {
	
	public EnchantTransferTableRenderer(BlockEntityRendererProvider.Context context){
    }

	@Override
	public void render(EnchantTransferTableEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		RenderUtils.renderItem(
				pBlockEntity.getItemInSlot(0),
        		new Vector3d(0.314, 0.8, 0.25),
        		Axis.of(new Vector3f(1, 0, 0)).rotationDegrees(-90),
        		pPoseStack, pBufferSource,
        		pBlockEntity.getLevel(),
        		pBlockEntity.getBlockPos().above(),
        		0.5f
		);
		RenderUtils.renderItem(
				pBlockEntity.getItemInSlot(1),
        		new Vector3d(0.60, 0.8, 0.75),
        		Axis.of(new Vector3f(1, 0, 0)).rotationDegrees(90),
        		pPoseStack, pBufferSource,
        		pBlockEntity.getLevel(),
        		pBlockEntity.getBlockPos().above(),
        		0.5f
		);
	}
}
