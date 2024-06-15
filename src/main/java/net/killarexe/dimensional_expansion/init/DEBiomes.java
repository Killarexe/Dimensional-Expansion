package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.BiomeManager;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DEBiomes {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registries.BIOME, DEMod.MOD_ID);

    public static final ResourceKey<Biome> PURPLEHEART_FOREST = registerBiome("purpleheart_forest", BiomeManager.BiomeType.WARM, 10, false);
    public static final ResourceKey<Biome> BLUE_SAND_DESERT = registerBiome("blue_sand_desert", BiomeManager.BiomeType.DESERT, 10, false);
    public static final ResourceKey<Biome> ORIGIN_DEADLAND = registerBiome("origin_deadland", BiomeManager.BiomeType.DESERT, 10, false);
    public static final ResourceKey<Biome> ORIGIN_PLAINS = registerBiome("origin_plains", BiomeManager.BiomeType.WARM, 10, false);

    private static ResourceKey<Biome> registerBiome(String name, BiomeManager.BiomeType type, int weight, boolean addToOverworld){
        ResourceKey<Biome> biome = ResourceKey.create(Registries.BIOME, DEMod.res(name));
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(biome, weight));
        if(addToOverworld) {
        	BiomeManager.addAdditionalOverworldBiomes(biome);
        }
        return biome;
    }
}
