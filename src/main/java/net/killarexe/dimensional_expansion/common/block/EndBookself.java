package net.killarexe.dimensional_expansion.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class EndBookself extends Block {
    public EndBookself() {
        super(BlockBehaviour.Properties.of(Material.WOOD).color(MaterialColor.COLOR_BLUE).strength(1, 10).requiresCorrectToolForDrops().destroyTime(1).sound(SoundType.WOOD));
    }

    @Override
    public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos) {
        return 1.5f;
    }
}
