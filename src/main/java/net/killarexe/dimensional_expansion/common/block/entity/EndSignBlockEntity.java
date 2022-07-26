package net.killarexe.dimensional_expansion.common.block.entity;

import net.killarexe.dimensional_expansion.core.init.DEBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EndSignBlockEntity extends SignBlockEntity {

    public EndSignBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
        super(p_155700_, p_155701_);
    }

    @Override
    public BlockEntityType<?> getType() {
        return DEBlockEntityTypes.END_SIGN.get();
    }
}
