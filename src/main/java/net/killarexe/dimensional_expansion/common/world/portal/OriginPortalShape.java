package net.killarexe.dimensional_expansion.common.world.portal;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Predicate;

public class OriginPortalShape {
	private static final int MIN_WIDTH = 2;
	public static final int MAX_WIDTH = 21;
	private static final int MIN_HEIGHT = 3;
	public static final int MAX_HEIGHT = 21;
	private static final BlockBehaviour.StatePredicate FRAME = net.neoforged.neoforge.common.extensions.IBlockStateExtension::isPortalFrame;
	private static final float SAFE_TRAVEL_MAX_ENTITY_XY = 4.0F;
	private static final double SAFE_TRAVEL_MAX_VERTICAL_DELTA = 1.0;
	private final LevelAccessor level;
	private final Direction.Axis axis;
	private final Direction rightDir;
	private int numPortalBlocks;
	@Nullable
	private BlockPos bottomLeft;
	private int height;
	private final int width;

	public static Optional<OriginPortalShape> findEmptyPortalShape(LevelAccessor pLevel, BlockPos pBottomLeft, Direction.Axis pAxis) {
		return findPortalShape(pLevel, pBottomLeft, p_77727_ -> p_77727_.isValid() && p_77727_.numPortalBlocks == 0, pAxis);
	}

	public static Optional<OriginPortalShape> findPortalShape(LevelAccessor pLevel, BlockPos pBottomLeft, Predicate<OriginPortalShape> pPredicate, Direction.Axis pAxis) {
		Optional<OriginPortalShape> optional = Optional.of(new OriginPortalShape(pLevel, pBottomLeft, pAxis)).filter(pPredicate);
		if (optional.isPresent()) {
			return optional;
		} else {
			Direction.Axis direction$axis = pAxis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
			return Optional.of(new OriginPortalShape(pLevel, pBottomLeft, direction$axis)).filter(pPredicate);
		}
	}

	public OriginPortalShape(LevelAccessor pLevel, BlockPos pBottomLeft, Direction.Axis pAxis) {
		this.level = pLevel;
		this.axis = pAxis;
		this.rightDir = pAxis == Direction.Axis.X ? Direction.WEST : Direction.SOUTH;
		this.bottomLeft = this.calculateBottomLeft(pBottomLeft);
		if (this.bottomLeft == null) {
			this.bottomLeft = pBottomLeft;
			this.width = 1;
			this.height = 1;
		} else {
			this.width = this.calculateWidth();
			if (this.width > 0) {
				this.height = this.calculateHeight();
			}
		}
	}

	@Nullable
	private BlockPos calculateBottomLeft(BlockPos pPos) {
		int i = Math.max(this.level.getMinBuildHeight(), pPos.getY() - 21);

		while (pPos.getY() > i && isEmpty(this.level.getBlockState(pPos.below()))) {
			pPos = pPos.below();
		}

		Direction direction = this.rightDir.getOpposite();
		int j = this.getDistanceUntilEdgeAboveFrame(pPos, direction) - 1;
		return j < 0 ? null : pPos.relative(direction, j);
	}

	private int calculateWidth() {
		int i = this.getDistanceUntilEdgeAboveFrame(this.bottomLeft, this.rightDir);
		return i >= 2 && i <= 21 ? i : 0;
	}

	private int getDistanceUntilEdgeAboveFrame(BlockPos pPos, Direction pDirection) {
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for (int i = 0; i <= 21; i++) {
			blockpos$mutableblockpos.set(pPos).move(pDirection, i);
			BlockState blockstate = this.level.getBlockState(blockpos$mutableblockpos);
			if (!isEmpty(blockstate)) {
				if (FRAME.test(blockstate, this.level, blockpos$mutableblockpos)) {
					return i;
				}
				break;
			}

			BlockState blockstate1 = this.level.getBlockState(blockpos$mutableblockpos.move(Direction.DOWN));
			if (!FRAME.test(blockstate1, this.level, blockpos$mutableblockpos)) {
				break;
			}
		}

		return 0;
	}

	private int calculateHeight() {
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
		int i = this.getDistanceUntilTop(blockpos$mutableblockpos);
		return i >= 3 && i <= 21 && this.hasTopFrame(blockpos$mutableblockpos, i) ? i : 0;
	}

	private boolean hasTopFrame(BlockPos.MutableBlockPos pPos, int pDistanceToTop) {
		for (int i = 0; i < this.width; i++) {
			BlockPos.MutableBlockPos blockpos$mutableblockpos = pPos.set(this.bottomLeft).move(Direction.UP, pDistanceToTop).move(this.rightDir, i);
			if (!FRAME.test(this.level.getBlockState(blockpos$mutableblockpos), this.level, blockpos$mutableblockpos)) {
				return false;
			}
		}

		return true;
	}

	private int getDistanceUntilTop(BlockPos.MutableBlockPos pPos) {
		for (int i = 0; i < 21; i++) {
			pPos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, -1);
			if (!FRAME.test(this.level.getBlockState(pPos), this.level, pPos)) {
				return i;
			}

			pPos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, this.width);
			if (!FRAME.test(this.level.getBlockState(pPos), this.level, pPos)) {
				return i;
			}

			for (int j = 0; j < this.width; j++) {
				pPos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, j);
				BlockState blockstate = this.level.getBlockState(pPos);
				if (!isEmpty(blockstate)) {
					return i;
				}

				if (blockstate.is(Blocks.NETHER_PORTAL)) {
					this.numPortalBlocks++;
				}
			}
		}

		return 21;
	}

	private static boolean isEmpty(BlockState pState) {
		return pState.isAir() || pState.is(BlockTags.FIRE) || pState.is(Blocks.NETHER_PORTAL);
	}

	public boolean isValid() {
		return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
	}

	public void createPortalBlocks() {
		BlockState blockstate = Blocks.NETHER_PORTAL.defaultBlockState().setValue(NetherPortalBlock.AXIS, this.axis);
		BlockPos.betweenClosed(this.bottomLeft, this.bottomLeft.relative(Direction.UP, this.height - 1).relative(this.rightDir, this.width - 1))
				.forEach(p_77725_ -> this.level.setBlock(p_77725_, blockstate, 18));
	}

	public boolean isComplete() {
		return this.isValid() && this.numPortalBlocks == this.width * this.height;
	}

	public static Vec3 getRelativePosition(BlockUtil.FoundRectangle pFoundRectangle, Direction.Axis pAxis, Vec3 pPos, EntityDimensions pEntityDimensions) {
		double d0 = (double)pFoundRectangle.axis1Size - (double)pEntityDimensions.width();
		double d1 = (double)pFoundRectangle.axis2Size - (double)pEntityDimensions.height();
		BlockPos blockpos = pFoundRectangle.minCorner;
		double d2;
		if (d0 > 0.0) {
			double d3 = (double)blockpos.get(pAxis) + (double)pEntityDimensions.width() / 2.0;
			d2 = Mth.clamp(Mth.inverseLerp(pPos.get(pAxis) - d3, 0.0, d0), 0.0, 1.0);
		} else {
			d2 = 0.5;
		}

		double d5;
		if (d1 > 0.0) {
			Direction.Axis direction$axis = Direction.Axis.Y;
			d5 = Mth.clamp(Mth.inverseLerp(pPos.get(direction$axis) - (double)blockpos.get(direction$axis), 0.0, d1), 0.0, 1.0);
		} else {
			d5 = 0.0;
		}

		Direction.Axis direction$axis1 = pAxis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
		double d4 = pPos.get(direction$axis1) - ((double)blockpos.get(direction$axis1) + 0.5);
		return new Vec3(d2, d5, d4);
	}

	public static Vec3 findCollisionFreePosition(Vec3 pPos, ServerLevel pLevel, Entity pEntity, EntityDimensions pDimensions) {
		if (!(pDimensions.width() > 4.0F) && !(pDimensions.height() > 4.0F)) {
			double d0 = (double)pDimensions.height() / 2.0;
			Vec3 vec3 = pPos.add(0.0, d0, 0.0);
			VoxelShape voxelshape = Shapes.create(
					AABB.ofSize(vec3, (double)pDimensions.width(), 0.0, (double)pDimensions.width()).expandTowards(0.0, 1.0, 0.0).inflate(1.0E-6)
			);
			Optional<Vec3> optional = pLevel.findFreePosition(
					pEntity, voxelshape, vec3, (double)pDimensions.width(), (double)pDimensions.height(), (double)pDimensions.width()
			);
			Optional<Vec3> optional1 = optional.map(p_259019_ -> p_259019_.subtract(0.0, d0, 0.0));
			return optional1.orElse(pPos);
		} else {
			return pPos;
		}
	}
}
