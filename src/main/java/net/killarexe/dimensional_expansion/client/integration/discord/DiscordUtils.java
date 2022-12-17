package net.killarexe.dimensional_expansion.client.integration.discord;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.integration.discord.entities.DiscordBuild;
import net.killarexe.dimensional_expansion.client.integration.discord.entities.RichPresence;
import net.killarexe.dimensional_expansion.client.integration.discord.exceptions.NoDiscordClientException;
import net.killarexe.dimensional_expansion.utils.DEUtils;
import net.minecraft.SharedConstants;

public class DiscordUtils {
	public static final RichPresence.Builder DEFAULT_BUILDER =  new RichPresence.Builder()
			.setState("Minecraft: " + SharedConstants.getCurrentVersion().getName())
			.setDetails("Playing Dimensional Expansion v" + DEMod.VERSION)
			.setLargeImage("logo", "Dimensional Expansion")
			.setButton1("Download", "https://www.curseforge.com/minecraft/mc-mods/dimensional-expansion")
			.setButton2("Source Code", "https://github.com/Killarexe/Dimensional-Expansion");
	public static final long ID = DEUtils.isDev() ? 805057676282560543L : 945425580210389012L;
	public static IPCClient RPC;
	
	public static void start() {
        RPC = new IPCClient(ID);
        RPC.setListener(new IPCListener() {
        	@Override
        	public void onReady(IPCClient client) {
        		client.sendRichPresence(DEFAULT_BUILDER.build());
        	}
        });
        try {
        	RPC.connect(DiscordBuild.ANY);
		} catch (NoDiscordClientException e) {
			System.out.println("Discord RPC Failed:\n" + e.getMessage());
		}
        /*new Thread(() -> {
        	while(!Thread.currentThread().isInterrupted()) {
        		try {
					Thread.sleep(2000);
					RPC.sendRichPresence(DEFAULT_BUILDER.setEndTimestamp(System.currentTimeMillis()).build(), null, false);
				} catch (InterruptedException e) {}
        	}
        }, "RPC").start();*/
	}
}
