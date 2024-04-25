package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class OriginFarmlandBlock extends FarmBlock{

	public OriginFarmlandBlock() {
		super(BlockBehaviour.Properties.ofFullCopy(Blocks.FARMLAND));
	}
	
	public static void turnToOriginDirt(BlockState pState, Level pLevel, BlockPos pPos) {
		pLevel.setBlockAndUpdate(pPos, pushEntitiesUp(pState, DEBlocks.ORIGIN_DIRT.get().defaultBlockState(), pLevel, pPos));
	}
	
	@Override
	public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if(!pState.canSurvive(pLevel, pPos)) {
			turnToOriginDirt(pState, pLevel, pPos);
		}
	}
	
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		int i = pState.getValue(MOISTURE);
	    if (!isNearWater(pLevel, pPos) && !pLevel.isRainingAt(pPos.above())) {
	    	if (i > 0) {
	            pLevel.setBlock(pPos, pState.setValue(MOISTURE, Integer.valueOf(i - 1)), 2);
	        } else if (!isUnderCrops(pLevel, pPos)) {
	        	turnToOriginDirt(pState, pLevel, pPos);
	        }
	    } else if (i < 7) {
	    	pLevel.setBlock(pPos, pState.setValue(MOISTURE, Integer.valueOf(7)), 2);
	    }
	}

	public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
		if (!pLevel.isClientSide && net.minecraftforge.common.ForgeHooks.onFarmlandTrample(pLevel, pPos, DEBlocks.ORIGIN_DIRT.get().defaultBlockState(), pFallDistance, pEntity)) { // Forge: Move logic to Entity#canTrample
			turnToOriginDirt(pState, pLevel, pPos);
	    }
	    super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);
	}
	
	private static boolean isUnderCrops(BlockGetter pLevel, BlockPos pPos) {
		BlockState plant = pLevel.getBlockState(pPos.above());
	    BlockState state = pLevel.getBlockState(pPos);
	    return plant.getBlock() instanceof net.minecraftforge.common.IPlantable && state.canSustainPlant(pLevel, pPos, Direction.UP, (net.minecraftforge.common.IPlantable)plant.getBlock());
	}
	
	private static boolean isNearWater(LevelReader pLevel, BlockPos pPos) {
		BlockState state = pLevel.getBlockState(pPos);
	    for(BlockPos blockpos : BlockPos.betweenClosed(pPos.offset(-4, 0, -4), pPos.offset(4, 1, 4))) {
	    	if (state.canBeHydrated(pLevel, pPos, pLevel.getFluidState(blockpos), blockpos)) {
	    		return true;
	        }
	    }
	    return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(pLevel, pPos);
	}
}
