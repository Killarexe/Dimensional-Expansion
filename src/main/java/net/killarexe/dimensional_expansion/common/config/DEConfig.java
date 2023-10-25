package net.killarexe.dimensional_expansion.common.config;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.client.Minecraft;
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
    public static final ForgeConfigSpec.ConfigValue<Boolean> showVersion;

    /*
    SERVER
     */
    public static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec COMMON_SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> powerStoneDelay;
    public static final ForgeConfigSpec.ConfigValue<Boolean> enablePowerStones;

    static{
        CLIENT_BUILDER.push("Config for Dimensional Expansion Client");
        devMod = CLIENT_BUILDER.comment("Set Dimensional Expansion to dev mode. Not Recommended with huge modpack. By Default is false.").define("Dev Mod", false);
        showVersion = CLIENT_BUILDER.comment("Show the version of Dimensional Expansion. Not Recommended with huge modpack. By Default is false.").define("Show Version", false);
        CLIENT_BUILDER.pop();
        CLIENT_SPEC = CLIENT_BUILDER.build();

        COMMON_BUILDER.push("Config for Dimensional Expansion Server");
        powerStoneDelay = COMMON_BUILDER.comment("Power stone delay. By Default is 100 seconds").define("Power Stone Delay", 100);
        enablePowerStones = COMMON_BUILDER.comment("Enable ALL power stones. By Default is true (If it's a big server is recommended to be false!)").define("Enable ALL Power Stone", true);
        COMMON_BUILDER.pop();
        COMMON_SPEC = COMMON_BUILDER.build();
    }
    
    public static void registerAll(){
        DEMod.LOGGER.info("Init Dimensional Expansion Config");
    	ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, DEConfig.CLIENT_SPEC, "dimensional_expansion-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DEConfig.COMMON_SPEC, "dimensional_expansion-server.toml");
    }
    
    public static boolean isDev(){
        return Minecraft.getInstance().getLaunchedVersion().equalsIgnoreCase("MOD_DEV");
    }

    public static boolean isDevAccount(){
    	String playerName = Minecraft.getInstance().getUser().getName();
        return playerName.equalsIgnoreCase("Killarexe");
    }
}
