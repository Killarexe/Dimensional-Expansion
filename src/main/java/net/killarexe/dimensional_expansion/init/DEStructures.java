package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;

public class DEStructures {
	
	public static final ResourceKey<Structure> ABANDONNED_PORTAL = createStructure("abandonned_portal");
	public static final ResourceKey<Structure> VILLAGE_ORIGIN_PLAINS = createStructure("village_origin_plains");
	
	public static ResourceKey<Structure> createStructure(String name){
		return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(DEMod.MOD_ID, name));
	}
	
	public static void register(){
		DEMod.LOGGER.info("Init Dimensional Expansion Structures");
        //It's just to initialize the constants...
	}
}
