package net.killarexe.dimensional_expansion.core.init;

import com.google.common.collect.ImmutableSet;
import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.sounds.SoundEvent;
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

    private static RegistryObject<PoiType> createPoiType(String name, Block targetBlock){
        RegistryObject<PoiType> type = POI_TYPE.register(name, () -> new PoiType(name, PoiType.getBlockStates(targetBlock), 1, 1));
        return type;
    }

    private static RegistryObject<VillagerProfession> createProfession(String name, PoiType type, SoundEvent workingSound){
        return VILLAGER_PROFESSION.register(name, () -> new VillagerProfession(name, type, ImmutableSet.of(), ImmutableSet.of(), workingSound));
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
