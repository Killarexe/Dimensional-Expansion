package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.world.biome.EndForest;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DEBiomes {

    public static ResourceKey<Biome> END_FOREST_KEY, END_DESERT_KEY, END_JUNGLE_KEY;

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, DEMod.MODID);

    //public static final RegistryObject<Biome> END_FOREST = BIOMES.register("end_forest", () -> EndForest.getBiome());

    private static ResourceKey<Biome> registerBiome(String id){
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DEMod.MODID, id));
    }

    public static void registerBiomes(IEventBus bus){
        BIOMES.register(bus);
        END_FOREST_KEY = registerBiome("end_forest");
        END_DESERT_KEY = registerBiome("end_desert");
        END_JUNGLE_KEY = registerBiome("end_jungle");
    }
}