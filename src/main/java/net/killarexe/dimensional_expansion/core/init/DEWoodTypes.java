package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class DEWoodTypes {

    public static final WoodType PURPLEHEART = createWoodType("purpleheart");

    private static WoodType createWoodType(String id){
        return WoodType.register(new WoodType(new ResourceLocation(DEMod.MOD_ID, id).toString(), BlockSetType.OAK));
    }

    public static void setWoodTypes(){
        Sheets.addWoodType(DEWoodTypes.PURPLEHEART);
    }
}
