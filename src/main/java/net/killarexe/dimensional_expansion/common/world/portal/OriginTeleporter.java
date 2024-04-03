package net.killarexe.dimensional_expansion.common.world.portal;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;

import com.google.common.collect.ImmutableSet;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.block.OriginPortalBlock;
import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.minecraft.BlockUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.entity.ai.village.poi.PoiType;
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
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OriginTeleporter implements ITeleporter{
	public static final TicketType<BlockPos> CUSTOM_PORTAL = TicketType.create("origin_portal", Vec3i::compareTo, 300);

	public static Holder<PoiType> poi = null;

	@SubscribeEvent
	public static void registerPointOfInterest(RegisterEvent event) {
		event.register(Registries.POINT_OF_INTEREST_TYPE, registerHelper -> {
			PoiType poiType = new PoiType(ImmutableSet.copyOf(DEBlocks.ORIGIN_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1);
			registerHelper.register(new ResourceLocation(DEMod.MOD_ID, "origin_portal"), poiType);
			poi = BuiltInRegistries.POINT_OF_INTEREST_TYPE.wrapAsHolder(poiType);
		});
	}

	private final ServerLevel level;
	private final BlockPos entityEnterPos;

	public OriginTeleporter(ServerLevel worldServer, BlockPos entityEnterPos) {
		this.level = worldServer;
		this.entityEnterPos = entityEnterPos;
	}

	public Optional<BlockUtil.FoundRectangle> findPortalAround(BlockPos pPos, boolean pIsNether, WorldBorder pWorldBorder) {
		PoiManager poimanager = this.level.getPoiManager();
		int i = pIsNether ? 16 : 128;
		poimanager.ensureLoadedAndValid(this.level, pPos, i);
		Optional<PoiRecord> optional = poimanager.getInSquare((p_230634_) -> {
			return p_230634_.is(poi.unwrapKey().get());
		}, pPos, i, PoiManager.Occupancy.ANY).filter((p_192981_) -> {
			return pWorldBorder.isWithinBounds(p_192981_.getPos());
		}).sorted(Comparator.<PoiRecord>comparingDouble((p_192984_) -> {
			return p_192984_.getPos().distSqr(pPos);
		}).thenComparingInt((p_192992_) -> {
			return p_192992_.getPos().getY();
		})).filter((p_192990_) -> {
			return this.level.getBlockState(p_192990_.getPos()).hasProperty(BlockStateProperties.HORIZONTAL_AXIS);
		}).findFirst();
		return optional.map((p_192975_) -> {
			BlockPos blockpos = p_192975_.getPos();
			this.level.getChunkSource().addRegionTicket(CUSTOM_PORTAL, new ChunkPos(blockpos), 3, blockpos);
			BlockState blockstate = this.level.getBlockState(blockpos);
			return BlockUtil.getLargestRectangleAround(blockpos, (Direction.Axis)blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, (p_192978_) -> {
				return this.level.getBlockState(p_192978_) == blockstate;
			});
		});
	}

	public Optional<BlockUtil.FoundRectangle> createPortal(BlockPos pPos, Direction.Axis pAxis) {
		Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, pAxis);
		double d0 = -1.0;
		BlockPos blockpos = null;
		double d1 = -1.0;
		BlockPos blockpos1 = null;
		WorldBorder worldborder = this.level.getWorldBorder();
		int i = Math.min(this.level.getMaxBuildHeight(), this.level.getMinBuildHeight() + this.level.getLogicalHeight()) - 1;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = pPos.mutable();
		Iterator var13 = BlockPos.spiralAround(pPos, 16, Direction.EAST, Direction.SOUTH).iterator();

		while(true) {
			BlockPos.MutableBlockPos blockpos$mutableblockpos1;
			int l2;
			int l;
			int k3;
			do {
				do {
					if (!var13.hasNext()) {
						if (d0 == -1.0 && d1 != -1.0) {
							blockpos = blockpos1;
							d0 = d1;
						}

						int l1;
						int k2;
						if (d0 == -1.0) {
							l1 = Math.max(this.level.getMinBuildHeight() - -1, 70);
							k2 = i - 9;
							if (k2 < l1) {
								return Optional.empty();
							}

							blockpos = (new BlockPos(pPos.getX(), Mth.clamp(pPos.getY(), l1, k2), pPos.getZ())).immutable();
							Direction direction1 = direction.getClockWise();
							if (!worldborder.isWithinBounds(blockpos)) {
								return Optional.empty();
							}

							for(int i3 = -1; i3 < 2; ++i3) {
								for(l = 0; l < 2; ++l) {
									for(k3 = -1; k3 < 3; ++k3) {
										BlockState blockstate1 = k3 < 0 ? DEBlocks.ORIGIN_FRAME.get().defaultBlockState() : Blocks.AIR.defaultBlockState();
										blockpos$mutableblockpos.setWithOffset(blockpos, l * direction.getStepX() + i3 * direction1.getStepX(), k3, l * direction.getStepZ() + i3 * direction1.getStepZ());
										this.level.setBlockAndUpdate(blockpos$mutableblockpos, blockstate1);
									}
								}
							}
						}

						for(l1 = -1; l1 < 3; ++l1) {
							for(k2 = -1; k2 < 4; ++k2) {
								if (l1 == -1 || l1 == 2 || k2 == -1 || k2 == 3) {
									blockpos$mutableblockpos.setWithOffset(blockpos, l1 * direction.getStepX(), k2, l1 * direction.getStepZ());
									this.level.setBlock(blockpos$mutableblockpos, DEBlocks.ORIGIN_FRAME.get().defaultBlockState(), 3);
								}
							}
						}

						BlockState blockstate = DEBlocks.ORIGIN_PORTAL.get().defaultBlockState().setValue(OriginPortalBlock.AXIS, pAxis);

						for(k2 = 0; k2 < 2; ++k2) {
							for(l2 = 0; l2 < 3; ++l2) {
								blockpos$mutableblockpos.setWithOffset(blockpos, k2 * direction.getStepX(), l2, k2 * direction.getStepZ());
								this.level.setBlock(blockpos$mutableblockpos, blockstate, 18);
								this.level.getPoiManager().add(blockpos$mutableblockpos, poi);
							}
						}

						return Optional.of(new BlockUtil.FoundRectangle(blockpos.immutable(), 2, 3));
					}

					blockpos$mutableblockpos1 = (BlockPos.MutableBlockPos)var13.next();
					l2 = Math.min(i, this.level.getHeight(Heightmap.Types.MOTION_BLOCKING, blockpos$mutableblockpos1.getX(), blockpos$mutableblockpos1.getZ()));
				} while(!worldborder.isWithinBounds(blockpos$mutableblockpos1));
			} while(!worldborder.isWithinBounds(blockpos$mutableblockpos1.move(direction, 1)));

			blockpos$mutableblockpos1.move(direction.getOpposite(), 1);

			for(l = l2; l >= this.level.getMinBuildHeight(); --l) {
				blockpos$mutableblockpos1.setY(l);
				if (this.canPortalReplaceBlock(blockpos$mutableblockpos1)) {
					for(k3 = l; l > this.level.getMinBuildHeight() && this.canPortalReplaceBlock(blockpos$mutableblockpos1.move(Direction.DOWN)); --l) {
					}

					if (l + 4 <= i) {
						int j1 = k3 - l;
						if (j1 <= 0 || j1 >= 3) {
							blockpos$mutableblockpos1.setY(l);
							if (this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, 0)) {
								double d2 = pPos.distSqr(blockpos$mutableblockpos1);
								if (this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, -1) && this.canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, 1) && (d0 == -1.0 || d0 > d2)) {
									d0 = d2;
									blockpos = blockpos$mutableblockpos1.immutable();
								}

								if (d0 == -1.0 && (d1 == -1.0 || d1 > d2)) {
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

	private boolean canHostFrame(BlockPos pOriginalPos, BlockPos.MutableBlockPos pOffsetPos, Direction pDirection, int pOffsetScale) {
		Direction direction = pDirection.getClockWise();

		for(int i = -1; i < 3; ++i) {
			for(int j = -1; j < 4; ++j) {
				pOffsetPos.setWithOffset(pOriginalPos, pDirection.getStepX() * i + direction.getStepX() * pOffsetScale, j, pDirection.getStepZ() * i + direction.getStepZ() * pOffsetScale);
				if (j < 0 && !this.level.getBlockState(pOffsetPos).isSolid()) {
					return false;
				}

				if (j >= 0 && !this.canPortalReplaceBlock(pOffsetPos)) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel server, float yaw,
							  Function<Boolean, Entity> repositionEntity) {
		PortalInfo portalinfo = getPortalInfo(entity, server);

		if (entity instanceof ServerPlayer player) {
			player.setServerLevel(server);
			server.addDuringPortalTeleport(player);

			player.connection.teleport(portalinfo.pos.x, portalinfo.pos.y, portalinfo.pos.z, portalinfo.yRot, portalinfo.xRot);
			player.connection.resetPosition();

			CriteriaTriggers.CHANGED_DIMENSION.trigger(player, currentWorld.dimension(), server.dimension());

			return entity;
		} else {
			Entity entityNew = entity.getType().create(server);
			if (entityNew != null) {
				entityNew.restoreFrom(entity);
				entityNew.moveTo(portalinfo.pos.x, portalinfo.pos.y, portalinfo.pos.z, portalinfo.yRot, entityNew.getXRot());
				entityNew.setDeltaMovement(portalinfo.speed);
				server.addDuringTeleport(entityNew);
			}
			return entityNew;
		}
	}

	private PortalInfo getPortalInfo(Entity entity, ServerLevel server) {
		WorldBorder worldborder = server.getWorldBorder();
		double d0 = DimensionType.getTeleportationScale(entity.level().dimensionType(), server.dimensionType());
		BlockPos blockpos1 = worldborder.clampToBounds(entity.getX() * d0, entity.getY(), entity.getZ() * d0);
		return this.getExitPortal(entity, blockpos1, worldborder).map(repositioner -> {
			BlockState blockstate = entity.level().getBlockState(this.entityEnterPos);
			Direction.Axis direction$axis;
			Vec3 vector3d;

			if (blockstate.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
				direction$axis = blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS);
				BlockUtil.FoundRectangle teleportationrepositioner$result = BlockUtil.getLargestRectangleAround(this.entityEnterPos, direction$axis, 21, Direction.Axis.Y, 21,
						pos -> entity.level().getBlockState(pos) == blockstate);
				vector3d = OriginPortalShape.getRelativePosition(teleportationrepositioner$result, direction$axis, entity.position(), entity.getDimensions(entity.getPose()));
			} else {
				direction$axis = Direction.Axis.X;
				vector3d = new Vec3(0.5, 0, 0);
			}

			return OriginPortalShape.createPortalInfo(server, repositioner, direction$axis, vector3d, entity, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
		}).orElse(new PortalInfo(entity.position(), Vec3.ZERO, entity.getYRot(), entity.getXRot()));
	}

	protected Optional<BlockUtil.FoundRectangle> getExitPortal(Entity entity, BlockPos pos, WorldBorder worldBorder) {
		Optional<BlockUtil.FoundRectangle> optional = this.findPortalAround(pos, false, worldBorder);

		if (entity instanceof ServerPlayer) {
			if (optional.isPresent()) {
				return optional;
			} else {
				Direction.Axis direction$axis = entity.level().getBlockState(this.entityEnterPos).getOptionalValue(OriginPortalBlock.AXIS).orElse(Direction.Axis.X);
				return this.createPortal(pos, direction$axis);
			}
		} else {
			return optional;
		}
	}

	private boolean canPortalReplaceBlock(BlockPos.MutableBlockPos pos) {
		BlockState blockstate = this.level.getBlockState(pos);
		return blockstate.canBeReplaced() && blockstate.getFluidState().isEmpty();
	}
}
