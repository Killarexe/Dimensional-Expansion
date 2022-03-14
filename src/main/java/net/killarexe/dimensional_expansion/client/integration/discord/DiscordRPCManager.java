package net.killarexe.dimensional_expansion.client.integration.discord;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.client.integration.discord.rpc.DiscordEventHandlers;
import net.killarexe.dimensional_expansion.client.integration.discord.rpc.DiscordRPC;
import net.killarexe.dimensional_expansion.client.integration.discord.rpc.DiscordRichPresence;

public class DiscordRPCManager {
    
    private static String appId, details, state, logoId, logoText, smallLogo, smallLogoText;

    public static void start(String appId, String details, String state, String logoId, String logoText, String smallLogo, String smallLogoText){
        setAppId(appId);
        setDetails(details);
        setState(state);
        setLogoId(logoId);
        setLogoText(logoText);
        setSmallLogo(smallLogo);
        setSmallLogoText(smallLogoText);
        DiscordRPC lib = DiscordRPC.INSTANCE;
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = (user) -> DEMod.LOGGER.info("Dimensional Expansion Discord RPC Ready!");
        lib.Discord_Initialize(appId, handlers, true, "");
        DiscordRichPresence presence = new DiscordRichPresence();
        presence.startTimestamp = System.currentTimeMillis() / 1000; // epoch second
        presence.details = details;
        presence.state = state;
        presence.largeImageKey = logoId;
        presence.largeImageText = logoText;
        presence.smallImageKey = smallLogo;
        presence.smallImageText = smallLogoText;
        lib.Discord_UpdatePresence(presence);
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(2000);
                    presence.details = details;
                    presence.state = state;
                    presence.largeImageKey = logoId;
                    presence.largeImageText = logoText;
                    presence.smallImageKey = smallLogo;
                    presence.smallImageText = smallLogoText;
                    lib.Discord_UpdatePresence(presence);
                } catch (InterruptedException ignored) {}
            }
        }, "RPC-Callback-Handler").start();
    }

    public static String getAppId() {
        return appId;
    }

    private static void setAppId(String appId) {
        DiscordRPCManager.appId = appId;
    }

    public static String getDetails() {
        return details;
    }

    public static void setDetails(String details) {
        DiscordRPCManager.details = details;
    }

    public static String getState() {
        return state;
    }

    public static void setState(String state) {
        DiscordRPCManager.state = state;
    }

    public static String getLogoId() {
        return logoId;
    }

    public static void setLogoId(String logoId) {
        DiscordRPCManager.logoId = logoId;
    }

    public static String getLogoText() {
        return logoText;
    }

    public static void setLogoText(String logoText) {
        DiscordRPCManager.logoText = logoText;
    }

    public static String getSmallLogo() {
        return smallLogo;
    }

    public static void setSmallLogo(String smallLogo) {
        DiscordRPCManager.smallLogo = smallLogo;
    }

    public static String getSmallLogoText() {
        return smallLogoText;
    }

    public static void setSmallLogoText(String smallLogoText) {
        DiscordRPCManager.smallLogoText = smallLogoText;
    }
}
