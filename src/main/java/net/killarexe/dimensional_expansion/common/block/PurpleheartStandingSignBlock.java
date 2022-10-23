package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.common.block.entity.PurpleheartSignBlockEntity;
import net.killarexe.dimensional_expansion.core.init.DEWoodTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class PurpleheartStandingSignBlock extends StandingSignBlock {

    public PurpleheartStandingSignBlock() {
        super(BlockBehaviour.Properties.of(Material.WOOD).color(MaterialColor.COLOR_MAGENTA).strength(1, 10).requiresCorrectToolForDrops().destroyTime(1).sound(SoundType.WOOD), DEWoodTypes.PURPLEHEART);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
        return new PurpleheartSignBlockEntity(p_154556_, p_154557_);
    }
}
