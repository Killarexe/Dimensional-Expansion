package net.killarexe.dimensional_expansion.core.init;

import com.google.common.collect.ImmutableSet;
import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.*;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

public class DEVillagerTypes {

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, DEMod.MOD_ID);
    public static final DeferredRegister<VillagerType> VILLAGER_TYPE = DeferredRegister.create(Registries.VILLAGER_TYPE, DEMod.MOD_ID);
    
    private static final Map<RegistryObject<VillagerType>, Set<ResourceKey<Biome>>> VILLAGER_TYPE_BY_BIOME = new HashMap<>();

    //Villager Professions
    public static final RegistryObject<VillagerProfession> FORGER = createProfession("forger", DEPois.FORGER_POI, SoundEvents.ANVIL_LAND);
    public static final RegistryObject<VillagerProfession> FARMER = createProfession("farmer", DEPois.FARMER_POI, SoundEvents.COMPOSTER_FILL);
    public static final RegistryObject<VillagerProfession> MINER = createProfession("miner", DEPois.MINER_POI, SoundEvents.STONE_BREAK);
    
    //Villager Types
    public static final RegistryObject<VillagerType> ORIGIN_PLAINS = createVillagerType("origin_plains", Set.of(DEBiomes.ORIGIN_PLAINS));
    public static final RegistryObject<VillagerType> BLUE_SAND_DESERT = createVillagerType("blue_sand_desert", Set.of(DEBiomes.BLUE_SAND_DESERT));

    private static RegistryObject<VillagerProfession> createProfession(String name, RegistryObject<PoiType> poi, @Nullable SoundEvent sound) {
        return VILLAGER_PROFESSION.register(name, () -> new VillagerProfession(name, x -> x.get() == poi.get(), y -> y.get() == poi.get(), ImmutableSet.of(), ImmutableSet.of(), sound));
    }
    
    private static RegistryObject<VillagerType> createVillagerType(String name, Set<ResourceKey<Biome>> biomes) {
    	RegistryObject<VillagerType> type = VILLAGER_TYPE.register(name, () -> new VillagerType(name));
    	VILLAGER_TYPE_BY_BIOME.put(type, biomes);
    	return type;
    }

    public static void setTypeByBiome() {
    	for(RegistryObject<VillagerType> type: VILLAGER_TYPE_BY_BIOME.keySet()) {
    		for(ResourceKey<Biome> biome: VILLAGER_TYPE_BY_BIOME.get(type)) {
    			VillagerType.BY_BIOME.put(biome, type.get());
    		}
    	}
    }
}
