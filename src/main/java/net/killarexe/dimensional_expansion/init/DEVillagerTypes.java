package net.killarexe.dimensional_expansion.init;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DEVillagerTypes {

    public static final DeferredRegister<VillagerType> VILLAGER_TYPE = DeferredRegister.create(Registries.VILLAGER_TYPE, DEMod.MOD_ID);
    
    private static final Map<VillagerType, Set<ResourceKey<Biome>>> VILLAGER_TYPE_BY_BIOME = new HashMap<>();

    //Villager Types
    public static final Supplier<VillagerType> ORIGIN_PLAINS = createVillagerType("origin_plains", Set.of(DEBiomes.ORIGIN_PLAINS, DEBiomes.PURPLEHEART_FOREST));
    public static final Supplier<VillagerType> BLUE_SAND_DESERT = createVillagerType("blue_sand_desert", Set.of(DEBiomes.BLUE_SAND_DESERT));

    private static Supplier<VillagerType> createVillagerType(String name, Set<ResourceKey<Biome>> biomes) {
    	VillagerType villagerType = new VillagerType(name);
    	Supplier<VillagerType> type = VILLAGER_TYPE.register(name, () -> villagerType);
    	VILLAGER_TYPE_BY_BIOME.put(villagerType, biomes);
    	return type;
    }

	//FIXME: This function always failed due to "Registry object not present...(Item)"
    public static void setTypeByBiome() {
    	for(Map.Entry<VillagerType, Set<ResourceKey<Biome>>> entry: VILLAGER_TYPE_BY_BIOME.entrySet()) {
    		for(ResourceKey<Biome> biome: entry.getValue()) {
	    		try {
	    			VillagerType.BY_BIOME.put(biome, entry.getKey());
					VillagerTrades.ItemListing[] fishermanTrades = VillagerTrades.TRADES.get(VillagerProfession.FISHERMAN).get(5);
					if(fishermanTrades[fishermanTrades.length - 1] instanceof VillagerTrades.EmeraldsForVillagerTypeItem trade) {
						trade.trades.put(entry.getKey(), DEItems.PURPLEHEART_BOAT.get());
					}
	    		}catch(Exception e) {
	    			DEMod.LOGGER.error("Failed to register villager type \"" + entry.getKey() + "\" for biome: \"" + biome + "\":\n\t" + e.getMessage());
	    		}
    		}
    	}
    }
}
