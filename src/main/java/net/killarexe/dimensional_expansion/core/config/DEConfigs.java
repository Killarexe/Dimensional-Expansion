package net.killarexe.dimensional_expansion.core.config;

import com.mojang.datafixers.util.Pair;
import net.killarexe.dimensional_expansion.DEMod;

public class DEConfigs {

    private static DEConfigProvider configs;
    public static SimpleConfig CONFIG;
    public static boolean SHOWVERSION;

    public static void registerConfigs(){
        configs = new DEConfigProvider();
        CONFIG = SimpleConfig.of(DEMod.MODID + "_config").provider(configs).request();
        assignConfigs();
    }

    private static void createConfigs(){
        configs.addKeyValuePair(new Pair<>(DEMod.MODID + ".show_version", true), "By Default True");
    }

    private static void assignConfigs(){
        SHOWVERSION = CONFIG.getOrDefault(DEMod.MODID + ".show_version", true);
    }
}
