package net.killarexe.dimensional_expansion.client.render.blockentity;

import org.joml.Vector3d;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.*;
import net.killarexe.dimensional_expansion.common.block.entity.DisplayBlockEntity;
import net.killarexe.dimensional_expansion.io.RenderManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;

public class DisplayBlockRenderer<T extends BlockEntity> implements BlockEntityRenderer<DisplayBlockEntity> {

    public DisplayBlockRenderer(BlockEntityRendererProvider.Context context){
    }

    @Override
    public void render(DisplayBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        if (pBlockEntity.getItemInSlot(0).equals(ItemStack.EMPTY) || pBlockEntity.getItemInSlot(0).getItem().equals(Items.AIR))
            return;
        Component label = Component.literal(pBlockEntity.getItemInSlot(0).getHoverName().getString());
        float delta = Minecraft.getInstance().getDeltaFrameTime();
        RenderManager.renderItem(
        		pBlockEntity.getItemInSlot(0),
        		new Vector3d(0.5, 1.5 + Mth.sin(pPartialTick * delta), 0.5),
        		Axis.XP.rotation(0),
        		pPoseStack, pBufferSource,
        		pBlockEntity.getLevel(),
        		pBlockEntity.getBlockPos().above(),
        		0.8f
        );
        if(pBlockEntity.isShowName()) {
        	RenderManager.renderLabel(pPoseStack, pBufferSource, LightTexture.FULL_BRIGHT, new Vector3d(0.5, 1.75, 0.5), label, 0xffffff);
        }
    }

    @Override
    public int getViewDistance() {
        return 32;
    }
}
