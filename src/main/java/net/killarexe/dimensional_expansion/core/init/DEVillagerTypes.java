package net.killarexe.dimensional_expansion.core.init;

import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.mixin.DEPoiTypeAccessor;
import net.minecraft.block.Block;
import net.minecraft.datafixer.fix.VillagerProfessionFix;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.VillagerData;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterest;
import net.minecraft.world.poi.PointOfInterestType;

public class DEVillagerTypes {

    public static final PointOfInterestType FORGER_POI_TYPE = createPoi("forger", DEBlocks.FORGE);

    public static final VillagerProfession FORGER = createProfesstion("forger", SoundEvents.BLOCK_ANVIL_FALL, FORGER_POI_TYPE);

    public static void registerVillagerTypes(){

    }

    private static VillagerProfession createProfesstion(String id, SoundEvent event, PointOfInterestType poiType){
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(DEMod.MODID, id), VillagerProfessionBuilder.create().id(new Identifier(DEMod.MODID, id)).workSound(event).workstation(poiType).build());
    }

    private static PointOfInterestType createPoi(String id, Block block){
        PointOfInterestType poiType = Registry.register(Registry.POINT_OF_INTEREST_TYPE, new Identifier(DEMod.MODID, id), null);
        DEPoiTypeAccessor.getBLOCK_STATE_TO_POINT_OF_INTEREST_TYPE().put(block.getDefaultState(), poiType);
        return poiType;
    }
}
