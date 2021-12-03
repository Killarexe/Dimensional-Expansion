package net.killarexe.dimensional_expansion.core.init;

import com.google.common.collect.ImmutableSet;
import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.InvocationTargetException;

public class DEVillagerTypes {

    public static final DeferredRegister<PoiType> POI_TYPE = DeferredRegister.create(ForgeRegistries.POI_TYPES, DEMod.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION = DeferredRegister.create(ForgeRegistries.PROFESSIONS, DEMod.MODID);

    //PoiTypes
    public static final RegistryObject<PoiType> END_FORGER_POI = createPoiType("end_forger_poi", DEBlocks.END_FORGE);

    //Villager Types
    public static final RegistryObject<VillagerProfession> END_FORGER = createProfession("end_forger", END_FORGER_POI, SoundEvents.ANVIL_LAND);

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
