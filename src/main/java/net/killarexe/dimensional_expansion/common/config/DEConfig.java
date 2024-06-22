package net.killarexe.dimensional_expansion.common.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class DEConfig {

    /*
    SERVER
     */
    public static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec COMMON_SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> enableWeatherPowerStone;
    public static final ForgeConfigSpec.ConfigValue<Boolean> enableTimePowerStone;

    static{
        COMMON_BUILDER.push("Config for Dimensional Expansion Common");
        enableWeatherPowerStone = COMMON_BUILDER.comment("Enable Weather power stone. By Default is true").define("Enable Weather Power Stone", true);
        enableTimePowerStone = COMMON_BUILDER.comment("Enable Time power stone. By Default is true").define("Enable Time Power Stone", true);
        COMMON_BUILDER.pop();
        COMMON_SPEC = COMMON_BUILDER.build();
    }
}
