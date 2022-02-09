package net.killarexe.dimensional_expansion.common.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.SignBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.SignType;
import net.minecraft.util.math.BlockPos;

public class EndStandingSignBlock extends SignBlock {

    public EndStandingSignBlock() {
        super(FabricBlockSettings.copyOf(DEBlocks.END_PLANKS), SignType.ACACIA);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return super.createBlockEntity(pos, state);
    }
}
