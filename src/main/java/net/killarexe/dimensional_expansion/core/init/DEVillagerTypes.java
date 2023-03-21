package net.killarexe.dimensional_expansion.core.init;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.event.DEVillagerTrades;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.*;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

public class DEVillagerTypes {

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, DEMod.MOD_ID);
    public static final DeferredRegister<VillagerType> VILLAGER_TYPE = DeferredRegister.create(Registries.VILLAGER_TYPE, DEMod.MOD_ID);
    
    private static final Map<VillagerType, Set<ResourceKey<Biome>>> VILLAGER_TYPE_BY_BIOME = new HashMap<>();

    //Villager Professions
    public static final RegistryObject<VillagerProfession> FORGER = createProfession("forger", DEPois.FORGER_POI, SoundEvents.ANVIL_LAND);
    public static final RegistryObject<VillagerProfession> FARMER = createProfession("farmer", DEPois.FARMER_POI, SoundEvents.COMPOSTER_FILL);
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
    	for(VillagerType type: VILLAGER_TYPE_BY_BIOME.keySet()) {
    		for(ResourceKey<Biome> biome: VILLAGER_TYPE_BY_BIOME.get(type)) {
    			DEMod.LOGGER.info(biome.toString());
    			try {
    				VillagerType.BY_BIOME.put(biome, type);
    			}catch(Exception e) {
    				DEMod.LOGGER.info("Failed to register villager type!\n" + e.getMessage());
    			}
    		}
    	}
    	try {
	    	VillagerTrades.TRADES.replace(
	        		VillagerProfession.FISHERMAN,
	        		new Int2ObjectOpenHashMap<>(
	        				ImmutableMap.of(
	        						1,new VillagerTrades.ItemListing[]{
	        								new DEVillagerTrades.EmeraldForItems(Items.STRING, 20, 16, 2),
	        								new DEVillagerTrades.EmeraldForItems(Items.COAL, 10, 16, 2),
	        								new DEVillagerTrades.ItemsAndEmeraldsToItems(Items.COD, 6, Items.COOKED_COD, 6, 16, 1),
	        								new DEVillagerTrades.ItemsForEmeralds(Items.COD_BUCKET, 3, 1, 16, 1)
	        						},
	        						2,new VillagerTrades.ItemListing[]{
	        								new DEVillagerTrades.EmeraldForItems(Items.COD, 15, 16, 10),
	        								new DEVillagerTrades.ItemsAndEmeraldsToItems(Items.SALMON, 6, Items.COOKED_SALMON, 6, 16, 5),
	        								new DEVillagerTrades.ItemsForEmeralds(Items.CAMPFIRE, 2, 1, 5)
	        						},
	        						3, new VillagerTrades.ItemListing[]{
	        								new DEVillagerTrades.EmeraldForItems(Items.SALMON, 13, 16, 20),
	        								new DEVillagerTrades.EnchantedItemForEmeralds(Items.FISHING_ROD, 3, 3, 10, 0.2F)
	        						},
	        						4, new VillagerTrades.ItemListing[]{
	        								new DEVillagerTrades.EmeraldForItems(Items.TROPICAL_FISH, 6, 12, 30)
	        						},
	        						5, new VillagerTrades.ItemListing[]{
	        								new DEVillagerTrades.EmeraldForItems(Items.PUFFERFISH, 4, 12, 30),
	        								new DEVillagerTrades.EmeraldsForVillagerTypeItem(
	        										1,
	        										12,
	        										30,
	        										ImmutableMap.<VillagerType, Item>builder()
	        										.put(VillagerType.PLAINS, Items.OAK_BOAT)
	        										.put(VillagerType.TAIGA, Items.SPRUCE_BOAT)
	        										.put(VillagerType.SNOW, Items.SPRUCE_BOAT)
	        										.put(VillagerType.DESERT, Items.JUNGLE_BOAT)
	        										.put(VillagerType.JUNGLE, Items.JUNGLE_BOAT)
	        										.put(VillagerType.SAVANNA, Items.ACACIA_BOAT)
	        										.put(VillagerType.SWAMP, Items.DARK_OAK_BOAT)
	        										.put(DEVillagerTypes.ORIGIN_PLAINS.get(), DEItems.PURPLEHEART_BOAT.get())
	        										.put(DEVillagerTypes.BLUE_SAND_DESERT.get(), DEItems.PURPLEHEART_BOAT.get())
	        										.build()
	        										)
	        								}
	        						)
	        				)
	        );
    	}catch(Exception e) {
    		DEMod.LOGGER.info("Oh no!");
    	}
    }
}
