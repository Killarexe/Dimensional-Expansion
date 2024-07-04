package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;

public class DEEntityLootTables extends EntityLootSubProvider{

	protected DEEntityLootTables(HolderLookup.Provider provider) {
		super(FeatureFlags.REGISTRY.allFlags(), provider);
	}

	@Override
	public void generate() {
		//TODO: Add loots to mobs...
	}
}
