package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import net.killarexe.dimensional_expansion.common.block.SavorleafCropBlock;
import net.killarexe.dimensional_expansion.common.block.VioletCarrotCropBlock;
import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.killarexe.dimensional_expansion.init.DEItems;
import org.jetbrains.annotations.NotNull;

import static net.killarexe.dimensional_expansion.init.DEBlocks.*;

public class DEBlocksLootTables extends VanillaBlockLoot {

	public DEBlocksLootTables(HolderLookup.Provider provider) {
		super(provider);
	}

	@Override
	protected void generate() {
		add(PALON_ORE.get(), (block) -> createOreDrop(block, DEItems.RAW_PALON.get()));
		dropSelf(PALON_BLOCK.get());
		add(BASSMITE_ORE.get(), (block) -> createOreDrop(block, DEItems.BASSMITE_GEM.get()));
		dropSelf(BASSMITE_BLOCK.get());
		add(SIMIX_ORE.get(), (block) -> createOreDrop(block, DEItems.RAW_SIMIX.get()));
		dropSelf(SIMIX_BLOCK.get());
		add(EMERTYST_ORE.get(), (block) -> createOreDrop(block, DEItems.EMERTYST_GEM.get()));
		dropSelf(EMERTYST_BLOCK.get());
		add(ORIGIN_PORTAL.get(), (block) -> noDrop());

		add(ORIGIN_GRASS_BLOCK.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(ORIGIN_DIRT.get())));
		add(ORIGIN_GRASS.get(), this::createGrassDrops);
		add(ORIGIN_TALL_GRASS.get(), this::createGrassDrops);
		add(PURPLE_BERRY_DEAD_BUSH.get(), (block) -> noDrop());
		dropSelf(ORIGIN_DIRT.get());
		add(ORIGIN_FARMLAND.get(), (block) -> createSilkTouchDispatchTable(block, LootItem.lootTableItem(ORIGIN_DIRT.get())));
		add(ORIGIN_DIRT_PATH.get(), (block) -> createSilkTouchDispatchTable(ORIGIN_DIRT_PATH.get(), LootItem.lootTableItem(ORIGIN_DIRT.get())));
		dropSelf(PURPLEISH_CACTUS.get());

		LootItemCondition.Builder savorleafCondition = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(SAVORLEAF_CROP.get()).setProperties(StatePropertiesPredicate.Builder
						.properties().hasProperty(SavorleafCropBlock.AGE, SavorleafCropBlock.MAX_AGE));
		add(SAVORLEAF_CROP.get(), createCropDrops(SAVORLEAF_CROP.get(), DEItems.SAVORLEAF.get(),
				DEItems.SAVORLEAF.get(), savorleafCondition));
		LootItemCondition.Builder violetCarrotCondition = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(VIOLET_CARROT_CROP.get()).setProperties(StatePropertiesPredicate.Builder
						.properties().hasProperty(VioletCarrotCropBlock.AGE, VioletCarrotCropBlock.MAX_AGE));
		add(VIOLET_CARROT_CROP.get(), createCropDrops(VIOLET_CARROT_CROP.get(), DEItems.VIOLET_CARROT.get(),
				DEItems.VIOLET_CARROT.get(), violetCarrotCondition));

		dropSelf(PURPLEHEART_LOG.get());
		dropSelf(STRIPPED_PURPLEHEART_LOG.get());
		dropSelf(PURPLEHEART_PLANKS.get());
		add(PURPLEHEART_SLAB.get(), this::createSlabItemTable);
		dropSelf(PURPLEHEART_FENCE.get());
		dropSelf(PURPLEHEART_FENCE_GATE.get());
		dropSelf(PURPLEHEART_BUTTON.get());
		dropSelf(PURPLEHEART_PRESSURE_PLATE.get());
		add(PURPLEHEART_DOOR.get(), this::createDoorTable);
		dropSelf(PURPLEHEART_TRAPDOOR.get());
		add(PURPLEHEART_LEAVES.get(), (block) -> createLeavesDrops(block, PURPLEHEART_SAPLING.get(), 1));
		dropSelf(PURPLEHEART_STAIRS.get());
		dropSelf(PURPLEHEART_BOOKSHELF.get());
		dropOther(DEBlocks.PURPLEHEART_SIGN.get(), DEItems.PURPLEHEART_SIGN.get());
		dropOther(PURPLEHEART_WALL_SIGN.get(), DEItems.PURPLEHEART_SIGN.get());
		dropSelf(PURPLE_ROSE.get());
		dropSelf(PURPLEHEART_SAPLING.get());

		dropOther(SULFUR_STONE.get(), SULFUR_COBBLESTONE.get().asItem());
		dropSelf(SULFUR_COBBLESTONE.get());
		add(SULFUR_COBBLESTONE_SLAB.get(), this::createSlabItemTable);
		dropSelf(SULFUR_COBBLESTONE_STAIRS.get());
		dropSelf(SULFUR_STONE_BUTTON.get());
		dropSelf(SULFUR_STONE_PRESSURE_PLATE.get());
		dropSelf(SULFUR_STONE_STAIRS.get());
		add(SULFUR_STONE_SLAB.get(), this::createSlabItemTable);
		dropSelf(SULFUR_COBBLESTONE_WALL.get());
		dropSelf(SULFUR_STONE_BRICKS.get());
		dropSelf(SULFUR_STONE_BRICKS_STAIRS.get());
		dropSelf(SULFUR_STONE_BRICKS_WALL.get());
		add(SULFUR_STONE_BRICKS_SLAB.get(), this::createSlabItemTable);
		dropSelf(VIOLET_STONE.get());
		dropSelf(VIOLET_STONE_STAIRS.get());
		dropSelf(VIOLET_STONE_WALL.get());
		add(VIOLET_STONE_SLAB.get(), this::createSlabItemTable);

		dropSelf(BLUE_SAND.get());
		dropSelf(BLUE_SANDSTONE.get());

		dropPottedContents(POTTED_PURPLE_ROSE.get());
		dropPottedContents(POTTED_PURPLEHEART_SAPLING.get());
		dropPottedContents(POTTED_PURPLEISH_CACTUS.get());
		dropSelf(ORIGIN_FRAME.get());
		dropSelf(SAVORLEAF_BLOCK.get());

		add(ENCHANT_TRANSFER_TABLE.get(), this::createNameableBlockEntityTable);
		dropSelf(DISPLAY_BLOCK.get());

		HolderLookup.RegistryLookup<Enchantment> enchantments = registries.lookup(Registries.ENCHANTMENT).get();

		add(PURPLE_BERRY_BUSH.get(), (block) -> applyExplosionDecay(block,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(PURPLE_BERRY_BUSH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SweetBerryBushBlock.AGE, 3)))
                        .add(LootItem.lootTableItem(DEItems.PURPLE_BERRY.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE))))
                        .withPool(LootPool.lootPool()
                                .when(LootItemBlockStatePropertyCondition
                                        .hasBlockStateProperties(PURPLE_BERRY_BUSH.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(SweetBerryBushBlock.AGE, 2)))
                                .add(LootItem.lootTableItem(DEItems.PURPLE_BERRY.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE))))));
	}

	@Override
	@NotNull
	protected Iterable<Block> getKnownBlocks() {
		return BLOCK.getEntries().stream().map((holder) -> (Block)holder.get()).toList();
	}
}
