package net.killarexe.dimensional_expansion.init;

import com.google.common.collect.ImmutableSet;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DEPois {
	public static final DeferredRegister<PoiType> POI_TYPE = DeferredRegister.create(ForgeRegistries.Keys.POI_TYPES, DEMod.MOD_ID);
	
	public static final RegistryObject<PoiType> FORGER_POI = createPoiType("forger_poi", DEBlocks.FORGE);
    public static final RegistryObject<PoiType> FARMER_POI = createPoiType("farmer_poi", DEBlocks.ESSENCE_EXTRACTOR);
    public static final RegistryObject<PoiType> MINER_POI = createPoiType("miner_poi", DEBlocks.MINERAL_STORAGE);

    public static final RegistryObject<PoiType> ORIGIN_PORTAL_POI = createPoiType("origin_portal", DEBlocks.ORIGIN_PORTAL);
    
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
}
