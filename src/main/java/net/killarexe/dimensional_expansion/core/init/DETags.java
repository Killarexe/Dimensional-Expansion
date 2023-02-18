package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class DETags {
	
	public static final TagKey<Block> IS_ORE = createBlockTag("is_ore");
	public static final TagKey<Biome> IS_ORIGIN = createBiomeTag("is_origin");
	public static final TagKey<Block> END_STONE_ORE_REPLACEABLES = createBlockTag("end_stone_ore_replaceables");
	public static final TagKey<Block> SULFUR_STONE_ORE_REPLACEABLES = createBlockTag("sulfur_stone_ore_replaceables");
	
	private static TagKey<Block> createBlockTag(String pName) {
		return TagKey.create(Registries.BLOCK, new ResourceLocation(DEMod.MOD_ID, pName));
	}
	
	private static TagKey<Biome> createBiomeTag(String pName) {
		return TagKey.create(Registries.BIOME, new ResourceLocation(DEMod.MOD_ID, pName));
	}
}
