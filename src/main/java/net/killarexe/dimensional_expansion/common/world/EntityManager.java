package net.killarexe.dimensional_expansion.common.world;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityManager {
	public static boolean teleportEntityTo(ResourceKey<Level> dim, Player player, BlockPos pos) {
		if(player instanceof ServerPlayer serverPlayer) {
			if(serverPlayer.level.dimension() != dim && serverPlayer.canChangeDimensions()) {
				ServerLevel dimLevel = serverPlayer.server.getLevel(dim);
				if(dimLevel != null) {
					serverPlayer.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
					serverPlayer.teleportTo(dimLevel, pos.getX(), pos.getY(), pos.getZ(), serverPlayer.getYRot(), serverPlayer.getXRot());
					serverPlayer.connection.send(new ClientboundPlayerAbilitiesPacket(serverPlayer.getAbilities()));
            		for(MobEffectInstance effect: serverPlayer.getActiveEffects()) {
            			serverPlayer.connection.send(new ClientboundUpdateMobEffectPacket(serverPlayer.getId(), effect));
            		}
            		serverPlayer.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
					return true;
				}
				return false;
			}
			serverPlayer.connection.teleport(pos.getX(), pos.getY(), pos.getZ(), serverPlayer.getYRot(), serverPlayer.getXRot());
            return true;
		}
		return false;
	}
}
