package net.killarexe.dimensional_expansion.core.init;

import com.google.common.collect.ImmutableSet;
import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.*;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.*;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class DEVillagerTypes {

    public static final DeferredRegister<PoiType> POI_TYPE = DeferredRegister.create(ForgeRegistries.POI_TYPES, DEMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, DEMod.MOD_ID);

    //PoiTypes
    public static final RegistryObject<PoiType> FORGER_POI = createPoiType("forger_poi", DEBlocks.FORGE);
    public static final RegistryObject<PoiType> FARMER_POI = createPoiType("farmer_poi", DEBlocks.ESSENCE_EXTRACTOR);
    public static final RegistryObject<PoiType> MINER_POI = createPoiType("miner_poi", DEBlocks.MINERAL_STORAGE);

    //Villager Types
    public static final RegistryObject<VillagerProfession> FORGER = createProfession("forger", FORGER_POI.getKey(), SoundEvents.ANVIL_LAND);
    public static final RegistryObject<VillagerProfession> FARMER = createProfession("farmer", FARMER_POI.getKey(), SoundEvents.COMPOSTER_FILL);
    public static final RegistryObject<VillagerProfession> MINER = createProfession("miner", MINER_POI.getKey(), SoundEvents.STONE_BREAK);

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

    private static RegistryObject<VillagerProfession> createProfession(String name, ResourceKey<PoiType> poi, @Nullable SoundEvent sound) {
        return createProfession(name, (type_1) -> type_1.is(poi), (type_2) -> type_2.is(poi), sound);
    }
    private static RegistryObject<VillagerProfession> createProfession(String name, Predicate<Holder<PoiType>> type_1, Predicate<Holder<PoiType>> type_2, @Nullable SoundEvent sound) {
        return createProfession(name, type_1, type_2, ImmutableSet.of(), ImmutableSet.of(), sound);
    }
    @SuppressWarnings("unused")
    private static RegistryObject<VillagerProfession> createProfession(String name, ResourceKey<PoiType> poi, ImmutableSet<Item> items, ImmutableSet<Block> blocks, @Nullable SoundEvent sound) {
        return createProfession(name, (type_1) -> type_1.is(poi), (type_2) -> type_2.is(poi), items, blocks, sound);
    }
    private static RegistryObject<VillagerProfession> createProfession(String name, Predicate<Holder<PoiType>> type_1, Predicate<Holder<PoiType>> type_2, ImmutableSet<Item> items, ImmutableSet<Block> blocks, @Nullable SoundEvent sound){
        return VILLAGER_PROFESSION.register(name, () -> new VillagerProfession(name, type_1, type_2, items, blocks, sound));
    }
}
