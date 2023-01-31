package net.killarexe.dimensional_expansion.common.data.generation.server;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DELootTableProvider {/*extends LootTableProvider {
	
	private final List<SubProviderEntry> lootTables = ImmutableList.of(DEBlocksLootTables::new, LootContextParamSets.BLOCK));
	
	public DELootTableProvider(PackOutput pOutput, Set<ResourceLocation> pRequiredTables,
			List<SubProviderEntry> pSubProviders) {
		super(pOutput, pRequiredTables, pSubProviders);
	}

    @Override
    public List<SubProviderEntry> getTables() {
    	// TODO Auto-generated method stub
    	return super.getTables();
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {

    }*/
}
