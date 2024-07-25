package net.killarexe.dimensional_expansion.common.block;

import java.util.Optional;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.world.portal.OriginPortalShape;
import net.killarexe.dimensional_expansion.common.world.portal.OriginTeleporter;
import net.killarexe.dimensional_expansion.init.DEDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class OriginPortalBlock extends NetherPortalBlock{

	public OriginPortalBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL).noOcclusion());
	}

	public static void portalSpawn(Level level, BlockPos pos) {
		Optional<OriginPortalShape> shape = OriginPortalShape.findEmptyPortalShape(level, pos, Direction.Axis.X);
		if(shape.isPresent()) {
			shape.get().createPortalBlocks();;
		}
	}
	
	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
	}
	
	@Override
	public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel,
			BlockPos pCurrentPos, BlockPos pFacingPos) {
		Direction.Axis direction$axis = pFacing.getAxis();
		Direction.Axis direction$axis1 = pState.getValue(AXIS);
		boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
		return !flag && !pFacingState.is(this) && !(new OriginPortalShape(pLevel, pCurrentPos, direction$axis1)).isComplete() ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
		for(int i = 0; i < 4; i++) {
			double posX = pPos.getX() + pRandom.nextFloat();
			double posY = pPos.getY() + pRandom.nextFloat();
			double posZ = pPos.getZ() + pRandom.nextFloat();
			double velX = (pRandom.nextFloat() - 0.5f) / 2.0f;
			double velY = (pRandom.nextFloat() - 0.5f) / 2.0f;
			double velZ = (pRandom.nextFloat() - 0.5f) / 2.0f;
			int j = pRandom.nextInt(4) - 1;
			if(pLevel.getBlockState(pPos.west()).getBlock() != this && pLevel.getBlockState(pPos.east()).getBlock() != this) {
				posX = pPos.getX() + 0.5f + 0.25f * j;
				velX = pRandom.nextFloat() * 2 * j;
			}else {
				posZ = pPos.getZ() + 0.5f + 0.25f * j;
				velZ = pRandom.nextFloat() * 2 * j;
			}
			pLevel.addParticle(ParticleTypes.PORTAL, posX, posY, posZ, velX, velY, velZ);
		}
		if(pRandom.nextInt(110) == 0) {
			pLevel.playSound(null, pPos.getX() + 0.5f, pPos.getY() + 0.5f, pPos.getZ() + 0.5f, SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5f, pRandom.nextFloat() * 0.4f + 0.8f);
		}
	}
	
	@Override
	public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
		if(!pEntity.isPassenger() && !pEntity.isVehicle() && pEntity.canChangeDimensions() && !pEntity.level().isClientSide) {
			if(pEntity.isOnPortalCooldown()) {
				pEntity.setPortalCooldown();
			}else if(pEntity.level().dimension() != DEDimensions.ORIGIN) {
				pEntity.setPortalCooldown();
				teleport(pEntity, pPos, DEDimensions.ORIGIN);
			}else {
				pEntity.setPortalCooldown();
				teleport(pEntity, pPos, Level.OVERWORLD);
			}
		}
	}
	
	private void teleport(Entity entity, BlockPos pos, ResourceKey<Level> dimension) {
		ServerLevel level = entity.getServer().getLevel(dimension);
		if(level != null) {
			entity.changeDimension(level, new OriginTeleporter(level, pos));
		}else {
			DEMod.LOGGER.error("Dimension "+ dimension +" don't exsit!");
		}
	}
}
