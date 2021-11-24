package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.world.biome.EndForest;
import net.minecraft.core.Registry;
import net.minecraft.resources.*;
import net.minecraft.world.level.biome.*;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class DEBiomes {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, DEMod.MODID);

    public static final RegistryObject<Biome> END_FOREST = createBiome("end_forest", () -> EndForest.createBiome());

    private static ResourceKey<Biome> registerBiome(String id){
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DEMod.MODID, id));
    }
    private static RegistryObject<Biome> createBiome(String id, Supplier<Biome> biome) {
        return BIOMES.register(id, biome);
    }

    public static void registerBiomes(){

    }
}
