package net.killarexe.dimensional_expansion.common.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class DEConfig {

    /*
    CLIENT
     */
    public static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CLIENT_SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> showVersion;

    public static final ForgeConfigSpec.ConfigValue<Boolean> coordLinkerOverlay;
    public static final ForgeConfigSpec.ConfigValue<Boolean> debugMod;

    /*
    SERVER
     */
    public static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SERVER_SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> powerStoneDelay;

    public static final ForgeConfigSpec.ConfigValue<Boolean> enablePowerStones;
    static{
        CLIENT_BUILDER.push("Config for Dimensional Expansion Client");
        showVersion = CLIENT_BUILDER.comment("Show the version of Dimensional Expansion. Not Recommended with multiple mods. By Default is true").define("Show Version", true);
        coordLinkerOverlay = CLIENT_BUILDER.comment("Show the coords directly on screen. Not Recommended with multiple mods. By Default is true").define("Coord Linker Overlay", true);
        debugMod = CLIENT_BUILDER.comment("Set Dimensional Expansion to debug mode. Not Recommended with multiple mods. By Default is false.").define("Debug Mod", false);
        CLIENT_BUILDER.pop();
        CLIENT_SPEC = CLIENT_BUILDER.build();

        SERVER_BUILDER.push("Config for Dimensional Expansion Server");
        powerStoneDelay = SERVER_BUILDER.comment("Power stone delay. By Default is 100 seconds").define("Power Stone Delay", 100);
        enablePowerStones = SERVER_BUILDER.comment("Enable ALL power stones. By Default is true (for server recommended to be false)").define("Enable ALL Power Stone", true);
        SERVER_BUILDER.pop();
        SERVER_SPEC = SERVER_BUILDER.build();
    }
}
