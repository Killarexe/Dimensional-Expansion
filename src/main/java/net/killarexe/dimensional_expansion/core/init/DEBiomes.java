package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.EndBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DEBiomes {

    public static ResourceKey<Biome> END_FOREST_KEY;

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, DEMod.MODID);

    public static final RegistryObject<Biome> END_FOREST = createBiome("end_forest", () -> EndBiomes.endHighlands());

    private static ResourceKey<Biome> registerBiome(String id){
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DEMod.MODID, id));
    }
    private static RegistryObject<Biome> createBiome(String id, Supplier<Biome> biome) {
        return BIOMES.register(id, biome);
    }

    public static void registerBiomes(){
        END_FOREST_KEY = registerBiome("end_forest");
    }
}