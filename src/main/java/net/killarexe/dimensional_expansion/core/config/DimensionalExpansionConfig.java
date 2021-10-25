package net.killarexe.dimensional_expansion.core.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class DimensionalExpansionConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> showVersion;

    static{
        BUILDER.push("Config for Dimensional Expansion");
        showVersion = BUILDER.comment("Show the version of Dimensional Expansion. By Default is true").define("Show Version", true);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
