package net.killarexe.dimensional_expansion.common.config;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public final class DEConfig {

    /*
    CLIENT
     */
    public static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CLIENT_SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> devMod;
    public static final ForgeConfigSpec.ConfigValue<Boolean> discordRPC;
    public static final ForgeConfigSpec.ConfigValue<Boolean> showVersion;
    public static final ForgeConfigSpec.ConfigValue<Boolean> moddedScreens;

    /*
    SERVER
     */
    public static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SERVER_SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> powerStoneDelay;
    public static final ForgeConfigSpec.ConfigValue<Boolean> enablePowerStones;

    static{
        CLIENT_BUILDER.push("Config for Dimensional Expansion Client");
        devMod = CLIENT_BUILDER.comment("Set Dimensional Expansion to dev mode. Not Recommended with huge modpack. By Default is false.").define("Debug Mod", false);
        discordRPC = CLIENT_BUILDER.comment("Enable discord rich presence. Not Recommended with huge modpack. By Default is true.").define("DiscordRPC", true);
        showVersion = CLIENT_BUILDER.comment("Show the version of Dimensional Expansion. Not Recommended with huge modpack. By Default is true.").define("Show Version", true);
        moddedScreens = CLIENT_BUILDER.comment("Show a custom title screen and pause screen. Not Recommended with huge modpack. By default is true.").define("Modded Screens", true);
        CLIENT_BUILDER.pop();
        CLIENT_SPEC = CLIENT_BUILDER.build();

        SERVER_BUILDER.push("Config for Dimensional Expansion Server");
        powerStoneDelay = SERVER_BUILDER.comment("Power stone delay. By Default is 100 seconds").define("Power Stone Delay", 100);
        enablePowerStones = SERVER_BUILDER.comment("Enable ALL power stones. By Default is true (for server recommended to be false)").define("Enable ALL Power Stone", true);
        SERVER_BUILDER.pop();
        SERVER_SPEC = SERVER_BUILDER.build();
    }
    
    public static void registerAll(){
        DEMod.LOGGER.info("Init Dimensional Expansion Config");
    	ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, DEConfig.CLIENT_SPEC, "dimensional_expansion-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, DEConfig.SERVER_SPEC, "dimensional_expansion-server.toml");
    }
}
