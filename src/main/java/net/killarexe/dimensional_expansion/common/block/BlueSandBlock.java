package net.killarexe.dimensional_expansion.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;
import org.jetbrains.annotations.NotNull;

public class BlueSandBlock extends FallingBlock {
    public static final MapCodec<BlueSandBlock> CODEC = simpleCodec(BlueSandBlock::new);

    public BlueSandBlock(Properties properties) {
        super(properties);
    }

    @Override
    @NotNull
    protected MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }
}
