package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DELootTableProvider extends LootTableProvider {
	
	public DELootTableProvider(PackOutput pOutput) {
		super(pOutput, Set.of(), List.of(new LootTableProvider.SubProviderEntry(DEBlocksLootTables::new, LootContextParamSets.BLOCK)));
	}

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {

    }
}
