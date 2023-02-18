package net.killarexe.dimensional_expansion.common.network.packet;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraftforge.network.NetworkEvent;

public class MobSpawnPacket extends ToServerPacket{
	
	public MobSpawnPacket() {
		
	}
	
	public MobSpawnPacket(FriendlyByteBuf buffer) {
		
	}
	
	@Override
	public void toBytes(FriendlyByteBuf buffer) {
		
	}
	
	@Override
	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			ServerLevel level = player.getLevel();
			EntityType.TNT.spawn(level, player.blockPosition(), MobSpawnType.COMMAND);
		});
		return true;
	}
}
