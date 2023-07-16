package net.killarexe.dimensional_expansion.common.block;

import java.util.List;
import java.util.Optional;

import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.lighting.LayerLightEngine;

public class OriginGrassBlock extends OriginDirtBlock implements BonemealableBlock{

	public OriginGrassBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK));
	}
	
	private static boolean canBeGrass(BlockState pState, LevelReader pLevelReader, BlockPos pPos) {
		BlockPos blockpos = pPos.above();
	    BlockState blockstate = pLevelReader.getBlockState(blockpos);
	    if (blockstate.is(Blocks.SNOW) && blockstate.getValue(SnowLayerBlock.LAYERS) == 1) {
	    	return true;
	    } else if (blockstate.getFluidState().getAmount() == 8) {
	        return false;
	    } else {
	        int i = LayerLightEngine.getLightBlockInto(pLevelReader, pState, pPos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(pLevelReader, blockpos));
	        return i < pLevelReader.getMaxLightLevel();
	    }
	}

	private static boolean canPropagate(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		BlockPos blockpos = pPos.above();
		return canBeGrass(pState, pLevel, pPos) && !pLevel.getFluidState(blockpos).is(FluidTags.WATER);
	}
	
	@Override
	public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
		if(!canBeGrass(pState, pLevel, pPos)) {
			pLevel.setBlockAndUpdate(pPos, DEBlocks.ORIGIN_DIRT.get().defaultBlockState());
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (!canBeGrass(pState, pLevel, pPos)) {
	         if (!pLevel.isLoaded(pPos)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
	         pLevel.setBlockAndUpdate(pPos, DEBlocks.ORIGIN_DIRT.get().defaultBlockState());
	    } else {
	    	if (!pLevel.isAreaLoaded(pPos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
	        if (pLevel.getMaxLocalRawBrightness(pPos.above()) >= 9) {
	            BlockState blockstate = this.defaultBlockState();
	            for(int i = 0; i < 4; ++i) {
	               BlockPos blockpos = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(5) - 3, pRandom.nextInt(3) - 1);
	               if (pLevel.getBlockState(blockpos).is(DEBlocks.ORIGIN_DIRT.get()) && canPropagate(blockstate, pLevel, blockpos)) {
	                  pLevel.setBlockAndUpdate(blockpos, DEBlocks.ORIGIN_GRASS_BLOCK.get().defaultBlockState());
	               }
	            }
	        }

	   }
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
		return pLevel.getBlockState(pPos.above()).isAir();
	}

	@Override
	public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
		BlockPos blockpos = pPos.above();
		BlockState blockstate = DEBlocks.ORIGIN_GRASS.get().defaultBlockState();
	    Optional<Holder.Reference<PlacedFeature>> optional = pLevel.registryAccess().registryOrThrow(Registries.PLACED_FEATURE).getHolder(VegetationPlacements.GRASS_BONEMEAL);

	    label49:
	    for(int i = 0; i < 128; ++i) {
	    	BlockPos blockpos1 = blockpos;

	    	for(int j = 0; j < i / 16; ++j) {
	    		blockpos1 = blockpos1.offset(pRandom.nextInt(3) - 1, (pRandom.nextInt(3) - 1) * pRandom.nextInt(3) / 2, pRandom.nextInt(3) - 1);
	            if (!pLevel.getBlockState(blockpos1.below()).is(this) || pLevel.getBlockState(blockpos1).isCollisionShapeFullBlock(pLevel, blockpos1)) {
	               continue label49;
	            }
	        }

	        BlockState blockstate1 = pLevel.getBlockState(blockpos1);
	        if (blockstate1.is(blockstate.getBlock()) && pRandom.nextInt(10) == 0) {
	            ((BonemealableBlock)blockstate.getBlock()).performBonemeal(pLevel, pRandom, blockpos1, blockstate1);
	        }

	        if (blockstate1.isAir()) {
	        	Holder<PlacedFeature> holder;
	            if (pRandom.nextInt(8) == 0) {
	               List<ConfiguredFeature<?, ?>> list = pLevel.getBiome(blockpos1).value().getGenerationSettings().getFlowerFeatures();
	               if (list.isEmpty()) {
	                  continue;
	               }

	               holder = ((RandomPatchConfiguration)list.get(0).config()).feature();
	            } else {
	               if (!optional.isPresent()) {
	                  continue;
	               }

	               holder = optional.get();
	            }

	            holder.value().place(pLevel, pLevel.getChunkSource().getGenerator(), pRandom, blockpos1);
	        }
	    }
	}
	
	

}
