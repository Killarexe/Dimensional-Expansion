package net.killarexe.dimensional_expansion.common.block.entity;

import net.killarexe.dimensional_expansion.init.DEBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PurpleheartSignBlockEntity extends SignBlockEntity {

    public PurpleheartSignBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
        super(p_155700_, p_155701_);
    }

    @Override
    public BlockEntityType<?> getType() {
        return DEBlockEntityTypes.PURPLEHEART_SIGN.get();
    }
}
