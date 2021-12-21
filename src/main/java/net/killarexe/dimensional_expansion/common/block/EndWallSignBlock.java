package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.common.blockentity.EndSignBlockEntity;
import net.killarexe.dimensional_expansion.core.init.DEWoodTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class EndWallSignBlock extends WallSignBlock {

    public EndWallSignBlock() {
        super(BlockBehaviour.Properties.of(Material.WOOD).color(MaterialColor.COLOR_MAGENTA).strength(1, 10).requiresCorrectToolForDrops().destroyTime(1).sound(SoundType.WOOD), DEWoodTypes.END);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
        return new EndSignBlockEntity(p_154556_, p_154557_);
    }
}
