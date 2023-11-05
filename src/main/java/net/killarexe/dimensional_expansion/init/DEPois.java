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
	
	//TODO: Create useful special blocks for the Miner Villager Job
    public static final RegistryObject<PoiType> MINER_POI = createPoiType("miner_poi", DEBlocks.MINERAL_STORAGE);
    
    private static RegistryObject<PoiType> createPoiType(String name, RegistryObject<? extends Block> targetBlock){
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
