package net.killarexe.dimensional_expansion.common.world.portal;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

import com.google.common.collect.ImmutableSet;

import net.killarexe.dimensional_expansion.common.block.OriginPortalBlock;
import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.killarexe.dimensional_expansion.init.DEPois;
import net.minecraft.BlockUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OriginTeleporter implements ITeleporter{
	private static final int TICKET_RADIUS = 3;
	private static final int SEARCH_RADIUS = 128;
	private static final int CREATE_RADIUS = 16;
	private static final int FRAME_HEIGHT = 5;
	private static final int FRAME_WIDTH = 4;
	private static final int FRAME_BOX = 3;
	private static final int FRAME_HEIGHT_START = -1;
	private static final int FRAME_HEIGHT_END = 4;
	private static final int FRAME_WIDTH_START = -1;
	private static final int FRAME_WIDTH_END = 3;
	private static final int FRAME_BOX_START = -1;
	private static final int FRAME_BOX_END = 2;
	private static final int NOTHING_FOUND = -1;

	public static final TicketType<BlockPos> PORTAL = TicketType.create("origin_portal", Vec3i::compareTo, 300);

	private final ServerLevel level;
	private final BlockPos entityPos;
	
	public OriginTeleporter(ServerLevel level, BlockPos entityPos) {
		this.level = level;
		this.entityPos = entityPos;
	}

	public Optional<BlockUtil.FoundRectangle> findPortalAround(BlockPos pPos, boolean isOrigin, WorldBorder pWorldBorder) {
		PoiManager poimanager = this.level.getPoiManager();
		int i = isOrigin ? CREATE_RADIUS : SEARCH_RADIUS;
		poimanager.ensureLoadedAndValid(this.level, pPos, i);
		Optional<PoiRecord> optional = poimanager
				.getInSquare(poiType -> poiType.is(DEPois.ORIGIN_PORTAL_POI.getKey()), pPos, i, PoiManager.Occupancy.ANY)
				.filter(poiRecord -> pWorldBorder.isWithinBounds(poiRecord.getPos()))
				.sorted(Comparator.<PoiRecord>comparingDouble(poiRecord -> poiRecord.getPos().distSqr(pPos))
						.thenComparingInt(poiRecord -> poiRecord.getPos().getY()))
				.filter(poiRecord -> this.level.getBlockState(poiRecord.getPos())
						.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)).findFirst();
		return optional.map(poiRecord -> {
			BlockPos blockpos = poiRecord.getPos();
			this.level.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockpos), 3, blockpos);
			BlockState blockstate = this.level.getBlockState(blockpos);
			return BlockUtil.getLargestRectangleAround(
					blockpos,
					blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS),
					21, Direction.Axis.Y, 21,
					(pos) -> this.level.getBlockState(pos) == blockstate);
		});
	}

	public Optional<BlockUtil.FoundRectangle> createPortal(BlockPos pPos, Direction.Axis pAxis) {
		Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, pAxis);
		double d0 = -1.0D;
		BlockPos blockpos = null;
		double d1 = -1.0D;
		BlockPos blockpos1 = null;
		WorldBorder worldborder = this.level.getWorldBorder();
		int i = Math.min(this.level.getMaxBuildHeight(), this.level.getMinBuildHeight() + this.level.getLogicalHeight()) - 1;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = pPos.mutable();
		for(BlockPos.MutableBlockPos blockpos$mutableblockpos1 : BlockPos.spiralAround(pPos, 16, Direction.EAST, Direction.SOUTH)) {
			int j = Math.min(i, this.level.getHeight(Heightmap.Types.MOTION_BLOCKING, blockpos$mutableblockpos1.getX(), blockpos$mutableblockpos1.getZ()));
			if (worldborder.isWithinBounds(blockpos$mutableblockpos1) && worldborder.isWithinBounds(blockpos$mutableblockpos1.move(direction, 1))) {
				blockpos$mutableblockpos1.move(direction.getOpposite(), 1);
				for(int l = j; l >= this.level.getMinBuildHeight(); --l) {
					blockpos$mutableblockpos1.setY(l);
					if (this.level.isEmptyBlock(blockpos$mutableblockpos1)) {
						int i1;
						for(i1 = l; l > this.level.getMinBuildHeight() && this.level.isEmptyBlock(blockpos$mutableblockpos1.move(Direction.DOWN)); --l) {
						}
						if (l + 4 <= i) {
							int j1 = i1 - l;
							if (j1 <= 0 || j1 >= 3) {
								blockpos$mutableblockpos1.setY(l);
								if (this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, 0)) {
									double d2 = pPos.distSqr(blockpos$mutableblockpos1);
									if (this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, -1) && this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, 1) && (d0 == -1.0D || d0 > d2)) {
										d0 = d2;
										blockpos = blockpos$mutableblockpos1.immutable();
									}
									if (d0 == -1.0D && (d1 == -1.0D || d1 > d2)) {
										d1 = d2;
										blockpos1 = blockpos$mutableblockpos1.immutable();
									}
								}
							}
						}
					}
				}
			}
		}
		if (d0 == -1.0D && d1 != -1.0D) {
			blockpos = blockpos1;
			d0 = d1;
		}
		if (d0 == -1.0D) {
			int k1 = Math.max(this.level.getMinBuildHeight() - -1, 70);
			int i2 = i - 9;
			if (i2 < k1) {
				return Optional.empty();
			}
			blockpos = (new BlockPos(pPos.getX(), Mth.clamp(pPos.getY(), k1, i2), pPos.getZ())).immutable();
			Direction direction1 = direction.getClockWise();
			if (!worldborder.isWithinBounds(blockpos)) {
				return Optional.empty();
			}
			for(int i3 = -1; i3 < 2; ++i3) {
				for(int j3 = 0; j3 < 2; ++j3) {
					for(int k3 = -1; k3 < 3; ++k3) {
						BlockState blockstate1 = k3 < 0 ? DEBlocks.ORIGIN_FRAME.get().defaultBlockState() : Blocks.AIR.defaultBlockState();
						blockpos$mutableblockpos.setWithOffset(blockpos, j3 * direction.getStepX() + i3 * direction1.getStepX(), k3, j3 * direction.getStepZ() + i3 * direction1.getStepZ());
						this.level.setBlockAndUpdate(blockpos$mutableblockpos, blockstate1);
					}
				}
			}
		}
		for(int l1 = -1; l1 < 3; ++l1) {
			for(int j2 = -1; j2 < 4; ++j2) {
				if (l1 == -1 || l1 == 2 || j2 == -1 || j2 == 3) {
					blockpos$mutableblockpos.setWithOffset(blockpos, l1 * direction.getStepX(), j2, l1 * direction.getStepZ());
					this.level.setBlock(blockpos$mutableblockpos, DEBlocks.ORIGIN_FRAME.get().defaultBlockState(), 3);
				}
			}
		}
		BlockState blockstate = DEBlocks.ORIGIN_PORTAL.get().defaultBlockState().setValue(OriginPortalBlock.AXIS, pAxis);
		for(int k2 = 0; k2 < 2; ++k2) {
			for(int l2 = 0; l2 < 3; ++l2) {
				blockpos$mutableblockpos.setWithOffset(blockpos, k2 * direction.getStepX(), l2, k2 * direction.getStepZ());
				this.level.setBlock(blockpos$mutableblockpos, blockstate, 18);
				this.level.getPoiManager().add(blockpos$mutableblockpos, DEPois.ORIGIN_PORTAL_POI.getHolder().get());
			}
		}
		return Optional.of(new BlockUtil.FoundRectangle(blockpos.immutable(), 2, 3));
	}
	
	private boolean canHostFrame(BlockPos pOriginalPos, BlockPos.MutableBlockPos pOffsetPos, Direction pDirection, int pOffsetScale) {
		Direction direction = pDirection.getClockWise();
		for(int i = -1; i < 3; ++i) {
			for(int j = -1; j < 4; ++j) {
				pOffsetPos.setWithOffset(pOriginalPos, pDirection.getStepX() * i + direction.getStepX() * pOffsetScale, j, pDirection.getStepZ() * i + direction.getStepZ() * pOffsetScale);
				if (j < 0 && this.level.getBlockState(pOffsetPos).isAir()) {
					return false;
				}
				if (j >= 0 && !this.level.isEmptyBlock(pOffsetPos)) {
					return false;
	            }
	         }
		}
		return true;
	}

	@Override
	public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel server, float yaw, Function<Boolean, Entity> repositionEntity) {
		PortalInfo portalinfo = getPortalInfo(entity, server);
		if (entity instanceof ServerPlayer player) {
			player.setServerLevel(server);
			server.addDuringPortalTeleport(player);
			player.connection.teleport(portalinfo.pos.x, portalinfo.pos.y, portalinfo.pos.z, portalinfo.yRot, portalinfo.xRot);
			player.connection.resetPosition();
			CriteriaTriggers.CHANGED_DIMENSION.trigger(player, currentWorld.dimension(), server.dimension());
			return entity;
		}
		Entity entityNew = entity.getType().create(server);
		if (entityNew != null) {
			entityNew.restoreFrom(entity);
			entityNew.moveTo(portalinfo.pos.x, portalinfo.pos.y, portalinfo.pos.z, portalinfo.yRot, entityNew.getXRot());
			entityNew.setDeltaMovement(portalinfo.speed);
			server.addDuringTeleport(entityNew);
		}
		return entityNew;
	}

	private PortalInfo getPortalInfo(Entity entity, ServerLevel server) {
		WorldBorder worldborder = server.getWorldBorder();
		double d0 = DimensionType.getTeleportationScale(entity.level().dimensionType(), server.dimensionType());
		BlockPos blockpos1 = worldborder.clampToBounds(entity.getX() * d0, entity.getY(), entity.getZ() * d0);
		return this.getExitPortal(entity, blockpos1, worldborder).map(repositioner -> {
			BlockState blockstate = entity.level().getBlockState(this.entityPos);
			Direction.Axis direction$axis;
			Vec3 vector3d;

			if (blockstate.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
				direction$axis = blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS);
				BlockUtil.FoundRectangle teleportationrepositioner$result = BlockUtil.getLargestRectangleAround(this.entityPos, direction$axis, 21, Direction.Axis.Y, 21,
						pos -> entity.level().getBlockState(pos) == blockstate);
				vector3d = OriginPortalShape.getRelativePosition(teleportationrepositioner$result, direction$axis, entity.position(), entity.getDimensions(entity.getPose()));
			} else {
				direction$axis = Direction.Axis.X;
				vector3d = new Vec3(0.5, 0, 0);
			}

			return OriginPortalShape.createPortalInfo(server, repositioner, direction$axis, vector3d, entity, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
		}).orElse(new PortalInfo(entity.position(), Vec3.ZERO, entity.getYRot(), entity.getXRot()));
	}
	
	protected Optional<BlockUtil.FoundRectangle> getExitPortal(Entity entity, BlockPos pos, WorldBorder border){
		Optional<BlockUtil.FoundRectangle> result = this.findPortalAround(pos, false, border);
		if(entity instanceof ServerPlayer) {
			if(result.isPresent()) {
				return result;
			}
			Direction.Axis dir = entity.level().getBlockState(pos).getOptionalValue(OriginPortalBlock.AXIS).orElse(Direction.Axis.X);
			return this.createPortal(pos, dir);
		}
		return result;
	}
}
