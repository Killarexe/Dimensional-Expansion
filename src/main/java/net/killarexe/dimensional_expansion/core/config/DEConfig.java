package net.killarexe.dimensional_expansion.core.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class DEConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> showVersion;
    public static final ForgeConfigSpec.ConfigValue<Boolean> showIcon;

    static{
        BUILDER.push("Config for Dimensional Expansion");
        showVersion = BUILDER.comment("Show the version of Dimensional Expansion. By Default is true").define("Show Version", true);
        showIcon = BUILDER.comment("Show a icon of Dimensional Expansion in the window. By Default is false").define("Show Version", false);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
