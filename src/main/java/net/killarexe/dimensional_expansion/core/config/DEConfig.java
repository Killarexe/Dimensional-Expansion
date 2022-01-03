package net.killarexe.dimensional_expansion.core.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class DEConfig {

    /*
    CLIENT
     */
    public static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CLIENT_SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> showVersion;

    /*
    SERVER
     */
    public static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SERVER_SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> enableWeatherPowerStone;
    public static final ForgeConfigSpec.ConfigValue<Boolean> enableTimePowerStone;

    static{
        CLIENT_BUILDER.push("Config for Dimensional Expansion Client");
        showVersion = CLIENT_BUILDER.comment("Show the version of Dimensional Expansion. By Default is true").define("Show Version", true);
        CLIENT_BUILDER.pop();
        CLIENT_SPEC = CLIENT_BUILDER.build();

        SERVER_BUILDER.push("Config for Dimensional Expansion Server");
        enableWeatherPowerStone = SERVER_BUILDER.comment("Enable Weather power stone. By Default is true").define("Enable Weather Power Stone", true);
        enableTimePowerStone = SERVER_BUILDER.comment("Enable Time power stone. By Default is true").define("Enable Time Power Stone", true);
        SERVER_BUILDER.pop();
        SERVER_SPEC = SERVER_BUILDER.build();
    }
}
