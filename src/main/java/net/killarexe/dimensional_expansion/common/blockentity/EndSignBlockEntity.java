package net.killarexe.dimensional_expansion.common.blockentity;

import net.killarexe.dimensional_expansion.core.init.DEBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class EndSignBlockEntity extends SignBlockEntity {
    public EndSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return DEBlockEntities.END_SIGN_BLOCK_ENTITY;
    }
}
