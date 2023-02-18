package net.killarexe.dimensional_expansion.common.network.packet;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public abstract class ToServerPacket {
	
	public ToServerPacket() {
		
	}
	
	public ToServerPacket(FriendlyByteBuf buffer) {
		
	}
	
	public abstract void toBytes(FriendlyByteBuf buffer);
	
	public abstract boolean handle(Supplier<NetworkEvent.Context> supplier);
}
