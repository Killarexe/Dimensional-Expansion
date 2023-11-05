package net.killarexe.dimensional_expansion.init;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.event.villager.trades.EmeraldForItems;
import net.killarexe.dimensional_expansion.common.event.villager.trades.EmeraldsForVillagerTypeItem;
import net.killarexe.dimensional_expansion.common.event.villager.trades.EnchantedItemForEmeralds;
import net.killarexe.dimensional_expansion.common.event.villager.trades.ItemsAndEmeraldsToItems;
import net.killarexe.dimensional_expansion.common.event.villager.trades.ItemsForEmeralds;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DEVillagerTypes {

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, DEMod.MOD_ID);
    public static final DeferredRegister<VillagerType> VILLAGER_TYPE = DeferredRegister.create(Registries.VILLAGER_TYPE, DEMod.MOD_ID);
    
    private static final Map<VillagerType, Set<ResourceKey<Biome>>> VILLAGER_TYPE_BY_BIOME = new HashMap<>();

    //Villager Professions
    public static final RegistryObject<VillagerProfession> MINER = createProfession("miner", DEPois.MINER_POI, SoundEvents.STONE_BREAK);
    
    //Villager Types
    public static final RegistryObject<VillagerType> ORIGIN_PLAINS = createVillagerType("origin_plains", Set.of(DEBiomes.ORIGIN_PLAINS, DEBiomes.PURPLEHEART_FOREST));
    public static final RegistryObject<VillagerType> BLUE_SAND_DESERT = createVillagerType("blue_sand_desert", Set.of(DEBiomes.BLUE_SAND_DESERT));

    private static RegistryObject<VillagerProfession> createProfession(String name, RegistryObject<PoiType> poi, @Nullable SoundEvent sound) {
        return VILLAGER_PROFESSION.register(name, () -> new VillagerProfession(name, x -> x.get() == poi.get(), y -> y.get() == poi.get(), ImmutableSet.of(), ImmutableSet.of(), sound));
    }
    
    private static RegistryObject<VillagerType> createVillagerType(String name, Set<ResourceKey<Biome>> biomes) {
    	VillagerType villagerType = new VillagerType(name);
    	RegistryObject<VillagerType> type = VILLAGER_TYPE.register(name, () -> villagerType);
    	VILLAGER_TYPE_BY_BIOME.put(villagerType, biomes);
    	return type;
    }

    public static void setTypeByBiome() {
	    ImmutableMap.Builder<VillagerType, Item> map = ImmutableMap.<VillagerType, Item>builder()
	    .put(VillagerType.PLAINS, Items.OAK_BOAT)
	    .put(VillagerType.TAIGA, Items.SPRUCE_BOAT)
	    .put(VillagerType.SNOW, Items.SPRUCE_BOAT)
	    .put(VillagerType.DESERT, Items.JUNGLE_BOAT)
	    .put(VillagerType.JUNGLE, Items.JUNGLE_BOAT)
	    .put(VillagerType.SAVANNA, Items.ACACIA_BOAT)
	    .put(VillagerType.SWAMP, Items.DARK_OAK_BOAT);
    	for(Map.Entry<VillagerType, Set<ResourceKey<Biome>>> entry: VILLAGER_TYPE_BY_BIOME.entrySet()) {
    		try {
    			map.put(entry.getKey(), DEItems.PURPLEHEART_BOAT.get());
    		}catch(Exception e) {
    			DEMod.LOGGER.error("Failed to put into map trades for villager type: " + e.getMessage());
    		}
    		for(ResourceKey<Biome> biome: entry.getValue()) {
	    		try {
	    			VillagerType.BY_BIOME.put(biome, entry.getKey());
	    		}catch(Exception e) {
	    			DEMod.LOGGER.error("Failed to register villager type!\n" + e.getMessage());
	    		}
    		}
    	}
    	
    	//Well I don't remember for why this part of code is here but I think it's related to the Purpleheart Boat...
    	try {
	    	VillagerTrades.TRADES.replace(
	        		VillagerProfession.FISHERMAN,
	        		new Int2ObjectOpenHashMap<>(
	        				ImmutableMap.of(
	        						1,new VillagerTrades.ItemListing[]{
	        								new EmeraldForItems(Items.STRING, 20, 16, 2),
	        								new EmeraldForItems(Items.COAL, 10, 16, 2),
	        								new ItemsAndEmeraldsToItems(Items.COD, 6, Items.COOKED_COD, 6, 16, 1),
	        								new ItemsForEmeralds(Items.COD_BUCKET, 3, 1, 16, 1)
	        						},
	        						2,new VillagerTrades.ItemListing[]{
	        								new EmeraldForItems(Items.COD, 15, 16, 10),
	        								new ItemsAndEmeraldsToItems(Items.SALMON, 6, Items.COOKED_SALMON, 6, 16, 5),
	        								new ItemsForEmeralds(Items.CAMPFIRE, 2, 1, 5)
	        						},
	        						3, new VillagerTrades.ItemListing[]{
	        								new EmeraldForItems(Items.SALMON, 13, 16, 20),
	        								new EnchantedItemForEmeralds(Items.FISHING_ROD, 3, 3, 10, 0.2F)
	        						},
	        						4, new VillagerTrades.ItemListing[]{
	        								new EmeraldForItems(Items.TROPICAL_FISH, 6, 12, 30)
	        						},
	        						5, new VillagerTrades.ItemListing[]{
	        								new EmeraldForItems(Items.PUFFERFISH, 4, 12, 30),
	        								new EmeraldsForVillagerTypeItem(
	        										1,
	        										12,
	        										30,
	        										map.build()
	        										)
	        								}
	        						)
	        				)
	        );
    	}catch(Exception e) {
    		DEMod.LOGGER.error("Failed refresh Fishman Trades! Error: " + e.getMessage());
    	}
    }
}
