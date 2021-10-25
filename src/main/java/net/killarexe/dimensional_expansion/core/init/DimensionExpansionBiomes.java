package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DimensionalExpansionMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.*;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class DimensionExpansionBiomes {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, DimensionalExpansionMod.MODID);

    static{

    }

    public static ResourceKey<Biome> END_FOREST = registerBiome("end_forest");

    private static ResourceKey<Biome> registerBiome(String id){
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DimensionalExpansionMod.MODID, id));
    }
    private static RegistryObject<Biome> createBiome(String id, Supplier<Biome> biome) {
        return BIOMES.register(id, biome);
    }

    public static void registerBiomes(){
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(END_FOREST, 10));
    }
}
