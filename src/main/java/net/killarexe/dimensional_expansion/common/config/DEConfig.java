package net.killarexe.dimensional_expansion.common.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class DEConfig {

    /*
    CLIENT
     */
    public static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CLIENT_SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> showVersion;
    public static final ForgeConfigSpec.ConfigValue<Boolean> moddedTitleScreen;
    public static final ForgeConfigSpec.ConfigValue<Boolean> debugMod;

    /*
    SERVER
     */
    public static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SERVER_SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> enableWeatherPowerStone;
    public static final ForgeConfigSpec.ConfigValue<Boolean> enableTimePowerStone;
    public static final ForgeConfigSpec.ConfigValue<Boolean> enableWarpPowerStone;

    static{
        CLIENT_BUILDER.push("Config for Dimensional Expansion Client");
        showVersion = CLIENT_BUILDER.comment("Show the version of Dimensional Expansion. Not Recommended with multiple mods. By Default is true").define("Show Version", true);
        moddedTitleScreen = CLIENT_BUILDER.comment("Add some things to the title screen. Not Recommended with multiple mods. By Default is true").define("Modded Title Screen", true);
        debugMod = CLIENT_BUILDER.comment("Set Dimensional Expansion to debug mode. Not Recommended with multiple mods. By Default is false.").define("Debug Mod", false);
        CLIENT_BUILDER.pop();
        CLIENT_SPEC = CLIENT_BUILDER.build();

        SERVER_BUILDER.push("Config for Dimensional Expansion Server");
        enableWeatherPowerStone = SERVER_BUILDER.comment("Enable Weather power stone. By Default is true").define("Enable Weather Power Stone", true);
        enableTimePowerStone = SERVER_BUILDER.comment("Enable Time power stone. By Default is true").define("Enable Time Power Stone", true);
        enableWarpPowerStone = SERVER_BUILDER.comment("Enable Warp power stone. By Default is true").define("Enable Warp Power Stone", true);
        SERVER_BUILDER.pop();
        SERVER_SPEC = SERVER_BUILDER.build();
    }
}
