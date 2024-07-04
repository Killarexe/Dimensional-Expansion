package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class DETags {
	public static final TagKey<Biome> IS_ORIGIN = TagKey.create(Registries.BIOME, DEMod.res("is_origin"));
	public static final TagKey<Block> END_STONE_ORE_REPLACEABLES = TagKey.create(Registries.BLOCK, DEMod.res("end_stone_ore_replaceables"));
	public static final TagKey<Block> SULFUR_STONE_ORE_REPLACEABLES = TagKey.create(Registries.BLOCK, DEMod.res("sulfur_stone_ore_replaceables"));
}
