package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.world.biome.EndForest;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.*;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DEBiomes {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, DEMod.MOD_ID);

    public static final RegistryObject<Biome> END_FOREST = BIOMES.register("end_forest", EndForest::get);
    public static final ResourceKey<Biome> END_FOREST_KEY = registerBiome("end_forest", 10);

    private static ResourceKey<Biome> registerBiome(String name, int weight){
        ResourceKey<Biome> biome = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DEMod.MOD_ID, name));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(biome, weight));
        BiomeManager.addAdditionalOverworldBiomes(biome);
        return biome;
    }
}
