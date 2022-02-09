package net.killarexe.dimensional_expansion.common.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class HealthCrops extends CropBlock {

    public HealthCrops() {
        super(FabricBlockSettings.copyOf(Blocks.WHEAT));
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return DEItems.HEART_SEEDS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return super.getOutlineShape(state, world, pos, context);
    }
}
