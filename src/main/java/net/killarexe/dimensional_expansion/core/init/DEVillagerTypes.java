package net.killarexe.dimensional_expansion.core.init;

import com.google.common.collect.ImmutableSet;
import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.*;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import javax.annotation.Nullable;

public class DEVillagerTypes {

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, DEMod.MOD_ID);

    //Villager Professions
    public static final RegistryObject<VillagerProfession> FORGER = createProfession("forger", DEPois.FORGER_POI, SoundEvents.ANVIL_LAND);
    public static final RegistryObject<VillagerProfession> FARMER = createProfession("farmer", DEPois.FARMER_POI, SoundEvents.COMPOSTER_FILL);
    public static final RegistryObject<VillagerProfession> MINER = createProfession("miner", DEPois.MINER_POI, SoundEvents.STONE_BREAK);
    
    //Villager Types
    public static final VillagerType ORIGIN_PLAINS = createVillagerType("origin_plains", Set.of(DEBiomes.ORIGIN_PLAINS));
    public static final VillagerType BLUE_SAND_DESERT = createVillagerType("blue_sand_desert", Set.of(DEBiomes.BLUE_SAND_DESERT));

    private static RegistryObject<VillagerProfession> createProfession(String name, RegistryObject<PoiType> poi, @Nullable SoundEvent sound) {
        return VILLAGER_PROFESSION.register(name, () -> new VillagerProfession(name, x -> x.get() == poi.get(), y -> y.get() == poi.get(), ImmutableSet.of(), ImmutableSet.of(), sound));
    }
    
    private static VillagerType createVillagerType(String name, Set<ResourceKey<Biome>> biomes) {
    	VillagerType type = Registry.register(BuiltInRegistries.VILLAGER_TYPE, new ResourceLocation(name, DEMod.MOD_ID), new VillagerType(name));
    	for(ResourceKey<Biome> biome: biomes) {
    		VillagerType.BY_BIOME.put(biome, type);
    	}
    	return type;
    }

    public static void register(IEventBus bus) {
    	VILLAGER_PROFESSION.register(bus);
    }
}
