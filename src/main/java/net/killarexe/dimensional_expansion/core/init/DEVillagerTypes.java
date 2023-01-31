package net.killarexe.dimensional_expansion.core.init;

import com.google.common.collect.ImmutableSet;
import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.sounds.*;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.*;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.Nullable;

public class DEVillagerTypes {

    public static final DeferredRegister<PoiType> POI_TYPE = DeferredRegister.create(ForgeRegistries.POI_TYPES, DEMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, DEMod.MOD_ID);
    
    //PoiTypes
    public static final RegistryObject<PoiType> FORGER_POI = createPoiType("forger_poi", DEBlocks.FORGE);
    public static final RegistryObject<PoiType> FARMER_POI = createPoiType("farmer_poi", DEBlocks.ESSENCE_EXTRACTOR);
    public static final RegistryObject<PoiType> MINER_POI = createPoiType("miner_poi", DEBlocks.MINERAL_STORAGE);
    
    //TODO: Separate POI and Villager Jobs into 2 different classes
    public static final RegistryObject<PoiType> ORIGIN_PORTAL = createPoiType("origin_portal", DEBlocks.ORIGIN_PORTAL);

    //Villager Types
    public static final RegistryObject<VillagerProfession> FORGER = createProfession("forger", FORGER_POI, SoundEvents.ANVIL_LAND);
    public static final RegistryObject<VillagerProfession> FARMER = createProfession("farmer", FARMER_POI, SoundEvents.COMPOSTER_FILL);
    public static final RegistryObject<VillagerProfession> MINER = createProfession("miner", MINER_POI, SoundEvents.STONE_BREAK);

    private static RegistryObject<PoiType> createPoiType(String name, RegistryObject<Block> targetBlock){
        RegistryObject<PoiType> type = POI_TYPE.register(
                name,
                () -> new PoiType(
                        ImmutableSet.copyOf(targetBlock.get().getStateDefinition().getPossibleStates()),
                        1,
                        1
                ));
        return type;
    }

    private static RegistryObject<VillagerProfession> createProfession(String name, RegistryObject<PoiType> poi, @Nullable SoundEvent sound) {
        return VILLAGER_PROFESSION.register(name, () -> new VillagerProfession(name, x -> x.get() == poi.get(), y -> y.get() == poi.get(), ImmutableSet.of(), ImmutableSet.of(), sound));
    }

    public static void register(IEventBus bus) {
    	POI_TYPE.register(bus);
    	VILLAGER_PROFESSION.register(bus);
    }
    
    public static void registerPOIs() {
    	try {
    		ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, FORGER_POI.get());
    	}catch(InvocationTargetException | IllegalAccessException e) {
    		e.printStackTrace();
    	}
    }
}
