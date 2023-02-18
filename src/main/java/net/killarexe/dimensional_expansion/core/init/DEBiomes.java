package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DEBiomes {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, DEMod.MOD_ID);

    public static final ResourceKey<Biome> PURPLEHEART_FOREST = registerBiome("purpleheart_forest", BiomeType.WARM, 10, false);
    public static final ResourceKey<Biome> BLUE_SAND_DESERT = registerBiome("blue_sand_desert", BiomeType.DESERT, 10, false);
    public static final ResourceKey<Biome> ORIGIN_PLAINS = registerBiome("origin_plains", BiomeType.WARM, 10, false);

    private static ResourceKey<Biome> registerBiome(String name, BiomeManager.BiomeType type, int weight, boolean addToOverworld){
        ResourceKey<Biome> biome = ResourceKey.create(Registries.BIOME, new ResourceLocation(DEMod.MOD_ID, name));
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(biome, weight));
        if(addToOverworld) {
        	BiomeManager.addAdditionalOverworldBiomes(biome);
        }
        return biome;
    }
}
