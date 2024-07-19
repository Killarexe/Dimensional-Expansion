package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class DEBiomes {

    public static final ResourceKey<Biome> PURPLEHEART_FOREST = registerBiome("purpleheart_forest", 10);
    public static final ResourceKey<Biome> BLUE_SAND_DESERT = registerBiome("blue_sand_desert", 10);
    public static final ResourceKey<Biome> ORIGIN_DEADLAND = registerBiome("origin_deadland", 10);
    public static final ResourceKey<Biome> ORIGIN_PLAINS = registerBiome("origin_plains", 10);

    private static ResourceKey<Biome> registerBiome(String name, int weight){
        ResourceKey<Biome> biome = ResourceKey.create(Registries.BIOME, DEMod.res(name));
        return biome;
    }

    public static void register() {

    }
}
