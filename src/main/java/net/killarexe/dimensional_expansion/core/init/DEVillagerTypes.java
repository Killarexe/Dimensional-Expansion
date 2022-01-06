package net.killarexe.dimensional_expansion.core.init;

import com.google.common.collect.ImmutableSet;
import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.sounds.*;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.*;

import java.lang.reflect.InvocationTargetException;

public class DEVillagerTypes {

    public static final DeferredRegister<PoiType> POI_TYPE = DeferredRegister.create(ForgeRegistries.POI_TYPES, DEMod.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION = DeferredRegister.create(ForgeRegistries.PROFESSIONS, DEMod.MODID);

    //PoiTypes
    public static final RegistryObject<PoiType> FORGER_POI = createPoiType("forger_poi", DEBlocks.FORGE);
    public static final RegistryObject<PoiType> FARMER_POI = createPoiType("farmer_poi", DEBlocks.STORAGE);
    public static final RegistryObject<PoiType> MINER_POI = createPoiType("miner_poi", DEBlocks.MINERAL_STORAGE);

    //Villager Types
    public static final RegistryObject<VillagerProfession> FORGER = createProfession("forger", FORGER_POI, SoundEvents.ANVIL_LAND);
    public static final RegistryObject<VillagerProfession> FARMER = createProfession("farmer", FARMER_POI, SoundEvents.COMPOSTER_FILL);
    public static final RegistryObject<VillagerProfession> MINER = createProfession("miner", MINER_POI, SoundEvents.STONE_BREAK);

    private static RegistryObject<PoiType> createPoiType(String name, RegistryObject<Block> targetBlock){
        RegistryObject<PoiType> type = POI_TYPE.register(name, () -> new PoiType(name, PoiType.getBlockStates(targetBlock.get()), 1, 1));
        return type;
    }

    private static RegistryObject<VillagerProfession> createProfession(String name, RegistryObject<PoiType> type, SoundEvent workingSound){
        return VILLAGER_PROFESSION.register(name, () -> new VillagerProfession(name, type.get(), ImmutableSet.of(), ImmutableSet.of(), workingSound));
    }

    public static void registerPOI(PoiType type){
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, type);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
