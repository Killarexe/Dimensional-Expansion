package net.killarexe.dimensional_expansion.common.block;

import com.mojang.serialization.MapCodec;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.world.portal.OriginPortalForcer;
import net.killarexe.dimensional_expansion.common.world.portal.OriginPortalShape;
import net.killarexe.dimensional_expansion.init.DEDimensions;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class OriginPortalBlock extends Block implements Portal {
	public static final MapCodec<OriginPortalBlock> CODEC = simpleCodec((_prop) -> new OriginPortalBlock());
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	private static final int AABB_OFFSET = 2;
	private static final VoxelShape X_AXIS_AABB = Block.box(0.0, 0.0, 6.0, 16.0, 16.0, 10.0);
	private static final VoxelShape Z_AXIS_AABB = Block.box(6.0, 0.0, 0.0, 10.0, 16.0, 16.0);

	public OriginPortalBlock() {
		super(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_PORTAL).noOcclusion());
		registerDefaultState(getStateDefinition().any().setValue(AXIS, Direction.Axis.X));
	}

	@Override
	protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(AXIS) == Direction.Axis.Z ? Z_AXIS_AABB : X_AXIS_AABB;
	}

	@Override
	protected BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
		Direction.Axis facingAxis = pDirection.getAxis();
		Direction.Axis currentAxis = pState.getValue(AXIS);
		boolean flag = currentAxis == facingAxis || currentAxis.isHorizontal();
		return !flag && !pState.is(this) && !new OriginPortalShape(pLevel, pPos, currentAxis).isComplete()
				? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
	}

	@Override
	protected void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
		if (pEntity.canUsePortal(false)) {
			pEntity.setAsInsidePortal(this, pPos);
		}
	}

	@Override
	public int getPortalTransitionTime(ServerLevel level, Entity entity) {
		if (entity instanceof Player player) {
			return Math.max(1, level.getGameRules().getInt(player.isCreative() ? GameRules.RULE_PLAYERS_NETHER_PORTAL_CREATIVE_DELAY : GameRules.RULE_PLAYERS_NETHER_PORTAL_DEFAULT_DELAY));
		}
		return 0;
	}

	@Nullable
	@Override
	public DimensionTransition getPortalDestination(ServerLevel level, Entity entity, BlockPos pos) {
		boolean isOrigin = level.dimension() == DEDimensions.ORIGIN;
		ResourceKey<Level> dimension = isOrigin ? Level.OVERWORLD : DEDimensions.ORIGIN;
		ServerLevel dimensionLevel = level.getServer().getLevel(dimension);
		if (dimensionLevel != null) {
			WorldBorder border = dimensionLevel.getWorldBorder();
			double teleportScale = DimensionType.getTeleportationScale(level.dimensionType(), dimensionLevel.dimensionType());
			BlockPos newPos = border.clampToBounds(pos.getX() * teleportScale, pos.getY(), pos.getZ() * teleportScale);
			Optional<DimensionTransition> transition = getExitPortal(dimensionLevel, entity, pos, newPos, isOrigin, border);
			if (transition.isPresent()) {
				return transition.get();
			}
			DEMod.LOGGER.error("Failed to get portal destination: Result out of world border.");
		}
		return null;
	}

	private Optional<DimensionTransition> getExitPortal(ServerLevel level, Entity entity, BlockPos oldPos, BlockPos newPos, boolean isOrigin, WorldBorder border) {
		OriginPortalForcer portalForcer = new OriginPortalForcer(level);
		Optional<BlockPos> optionalPos = portalForcer.findClosestPortalPosition(newPos, isOrigin, border);
		if (optionalPos.isPresent()) {
			BlockPos pos = optionalPos.get();
			BlockState state = level.getBlockState(pos);
			BlockUtil.FoundRectangle rectangle = BlockUtil.getLargestRectangleAround(
					pos, state.getValue(BlockStateProperties.HORIZONTAL_AXIS), OriginPortalShape.MAX_WIDTH,
					Direction.Axis.Y, OriginPortalShape.MAX_HEIGHT, indexPos -> level.getBlockState(indexPos) == state
			);
			DimensionTransition.PostDimensionTransition postDimensionTransition = DimensionTransition.PLAY_PORTAL_SOUND.then(currentEntity -> currentEntity.placePortalTicket(pos));
			return Optional.of(
					getDimensionTransitionFromExit(entity, oldPos, rectangle, level, postDimensionTransition)
			);
		}
		Direction.Axis axis = entity.level().getBlockState(oldPos).getOptionalValue(AXIS).orElse(Direction.Axis.X);
		Optional<BlockUtil.FoundRectangle> rectangle = portalForcer.createPortal(newPos, axis);
		if (rectangle.isPresent()) {
			DimensionTransition.PostDimensionTransition postDimensionTransition = DimensionTransition.PLAY_PORTAL_SOUND.then(DimensionTransition.PLACE_PORTAL_TICKET);
			return Optional.of(
					getDimensionTransitionFromExit(entity, oldPos, rectangle.get(), level, postDimensionTransition)
			);
		}
		return Optional.empty();
	}

	private static DimensionTransition getDimensionTransitionFromExit(
			Entity entity, BlockPos pos, BlockUtil.FoundRectangle rectangle, ServerLevel level, DimensionTransition.PostDimensionTransition transition
	) {
		BlockState state = entity.level().getBlockState(pos);
		if (state.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
			Direction.Axis axis = state.getValue(BlockStateProperties.HORIZONTAL_AXIS);
			BlockUtil.FoundRectangle foundRectangle = BlockUtil.getLargestRectangleAround(
					pos, axis, OriginPortalShape.MAX_WIDTH, Direction.Axis.Y, OriginPortalShape.MAX_HEIGHT, indexPos -> entity.level().getBlockState(indexPos) == state
			);
			Vec3 portalPosition = OriginPortalShape.getRelativePosition(foundRectangle, axis, entity.position(), entity.getDimensions(entity.getPose()));
			return createDimensionTransition(level, rectangle, axis, portalPosition, entity, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), transition);
		}
		return createDimensionTransition(
				level, rectangle, Direction.Axis.X, new Vec3(0.5, 0.0, 0.0), entity, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), transition
		);
	}

	private static DimensionTransition createDimensionTransition(
			ServerLevel level, BlockUtil.FoundRectangle rectangle, Direction.Axis axis, Vec3 portalPos, Entity entity,
			Vec3 deltaMovement, float yRot, float xRot, DimensionTransition.PostDimensionTransition transition
	) {
		BlockPos pos = rectangle.minCorner;
		BlockState blockstate = level.getBlockState(pos);
		Direction.Axis blockAxis = blockstate.getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X);
		EntityDimensions entitydimensions = entity.getDimensions(entity.getPose());
		int rotationOffset = axis == blockAxis ? 0 : 90;
		Vec3 movement = axis == blockAxis ? deltaMovement : new Vec3(deltaMovement.z, deltaMovement.y, -deltaMovement.x);
		double x = entitydimensions.width() / 2.0 + (rectangle.axis1Size - entitydimensions.width()) * portalPos.x();
		double y = (rectangle.axis2Size - entitydimensions.height()) * portalPos.y();
		double z = 0.5 + portalPos.z();
		boolean isXAxis = blockAxis == Direction.Axis.X;
		Vec3 newPos = new Vec3(pos.getX() + (isXAxis ? x : z), pos.getY() + y, pos.getZ() + (isXAxis ? z : x));
		Vec3 foundPos = PortalShape.findCollisionFreePosition(newPos, level, entity, entitydimensions);
		return new DimensionTransition(level, foundPos, movement, yRot + rotationOffset, xRot, transition);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(AXIS);
	}

	@Override
	protected MapCodec<? extends Block> codec() {
		return CODEC;
	}
}
