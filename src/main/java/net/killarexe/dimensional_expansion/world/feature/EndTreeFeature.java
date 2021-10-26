package net.killarexe.dimensional_expansion.world.feature;

import com.mojang.serialization.Codec;
import net.killarexe.dimensional_expansion.core.init.DimensionalExpansionBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class EndTreeFeature extends Feature<NoneFeatureConfiguration> {

    private static final BlockState STEM_BLOCK = DimensionalExpansionBlocks.END_LOG.get().defaultBlockState();
    private static final BlockState LEAVES_BLOCK = DimensionalExpansionBlocks.END_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 3);
    private static final Direction[] DIRECTIONS = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};

    public EndTreeFeature(Codec<NoneFeatureConfiguration> p_65786_) {
        super(p_65786_);
    }

    @SuppressWarnings("deprecation")
    public boolean isAirOrLeaves(WorldGenLevel reader, BlockPos pos){
        if(!(reader instanceof WorldGenLevel)){
            return reader.isStateAtPosition(pos, blockState -> blockState.isAir() || blockState.is(BlockTags.LEAVES));
        }else{
            return reader.isStateAtPosition(pos, blockState -> blockState.canSurvive((WorldGenLevel)reader, pos));
        }
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_159749_) {

        BlockPos pos = p_159749_.origin();
        WorldGenLevel level = p_159749_.level();

        while(p_159749_.origin().getY() > 1 && isAirOrLeaves(level, pos)){
            pos = pos.below();
        }

        if(!isGrassOrDirt(level, pos)){
            return false;
        }

        //STEM
        int height = 4 + p_159749_.random().nextInt(4);
        if(pos.getY() >= 1 && pos.getY() + 7 + 1 < level.getHeight()){
            for (int i = pos.getY() + 1; i < pos.getY() + height + 1; i++) {
                level.setBlock(new BlockPos(pos.getX(), i, pos.getZ()), STEM_BLOCK, 3);
            }
        }else{
            return false;
        }

        //LEAVES
        level.setBlock(new BlockPos(pos.getX(), height + 2, pos.getY()), LEAVES_BLOCK, 3);
        level.setBlock(new BlockPos(pos.getX(), height + 3, pos.getY()), LEAVES_BLOCK, 3);
        for(Direction d : DIRECTIONS){

        }
        for (int i = 1; i < 3; i++) {
            for(Direction d : DIRECTIONS){
                level.setBlock(new BlockPos(pos.getX(), pos.getY() + height - i, pos.getZ()).relative(d, i), LEAVES_BLOCK, 3);
            }
        }

        return true;
    }
}
