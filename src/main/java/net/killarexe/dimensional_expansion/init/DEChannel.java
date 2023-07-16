package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.network.packet.MobSpawnPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class DEChannel {
	private static SimpleChannel INSTANCE;
	private static int packetId = 0;
	
	public static void register() {
		INSTANCE = NetworkRegistry.ChannelBuilder
				.named(new ResourceLocation(DEMod.MOD_ID, DEMod.MOD_ID + "_channel"))
				.networkProtocolVersion(() -> "1.0r")
				.clientAcceptedVersions(s -> true)
				.serverAcceptedVersions(s -> true)
				.simpleChannel();
		
		INSTANCE.messageBuilder(MobSpawnPacket.class, getPakectId(), NetworkDirection.PLAY_TO_SERVER)
			.decoder(MobSpawnPacket::new)
			.encoder(MobSpawnPacket::toBytes)
			.consumerMainThread(MobSpawnPacket::handle)
			.add();
	}
	
	public static <T> void sendToServer(T packet) {
		INSTANCE.sendToServer(packet);
	}
	
	public static <T> void sendToPlayer(T packet, ServerPlayer player) {
		INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), packet);
	}
	
	private static int getPakectId() {
		return packetId++;
	}
}
