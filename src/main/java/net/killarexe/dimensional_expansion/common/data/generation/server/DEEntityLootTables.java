package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;

public class DEEntityLootTables extends EntityLootSubProvider{

	protected DEEntityLootTables() {
		super(FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub
		
	}

}
