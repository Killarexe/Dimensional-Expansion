package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;

public class DEWoodTypes {

    public static final WoodType END = createWoodType("end");

    private static WoodType createWoodType(String id){
        return WoodType.create(new ResourceLocation(DEMod.MODID, id).toString());
    }
}
