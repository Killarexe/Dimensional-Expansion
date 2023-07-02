package net.killarexe.dimensional_expansion.client.integration.discord;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.integration.discord.entities.DiscordBuild;
import net.killarexe.dimensional_expansion.client.integration.discord.entities.RichPresence;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.minecraft.SharedConstants;

public class DiscordUtils {
	public static final RichPresence.Builder DEFAULT_BUILDER =  new RichPresence.Builder()
			.setState("Minecraft: " + SharedConstants.getCurrentVersion().getName())
			.setDetails("Playing Dimensional Expansion v" + DEMod.VERSION)
			.setLargeImage("delogo", "Dimensional Expansion")
			.setButton1("Download", "https://www.curseforge.com/minecraft/mc-mods/dimensional-expansion")
			.setButton2("Source Code", "https://github.com/Killarexe/Dimensional-Expansion");
	public static final long ID = DEConfig.isDev() ? 805057676282560543L : 945425580210389012L;
	public static IPCClient RPC;
	
	public static void start() {
		try {
	        RPC = new IPCClient(ID);
	        RPC.setListener(new IPCListener(){
	        	@Override
	        	public void onReady(IPCClient client) {
	        		client.sendRichPresence(DEFAULT_BUILDER.build());
	        	}
	        });
        	RPC.connect(DiscordBuild.ANY);
		} catch (Exception e) {
			DEMod.LOGGER.warn("Discord RPC Failed:\n" + e.getMessage());
		}
	}
}
