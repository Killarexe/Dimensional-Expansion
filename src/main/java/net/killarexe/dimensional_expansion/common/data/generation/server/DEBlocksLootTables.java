package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import static net.killarexe.dimensional_expansion.core.init.DEBlocks.*;

public class DEBlocksLootTables extends BlockLoot {

    @Override
    protected void addTables() {
        add(PALON_ORE.get(), (block) ->{return createOreDrop(PALON_ORE.get(), DEItems.RAW_PALON.get());});
        dropSelf(PALON_BLOCK.get());
        add(BASSMITE_ORE.get(), (block) ->{return createOreDrop(BASSMITE_ORE.get(), DEItems.BASSMITE_GEM.get());});
        dropSelf(BASSMITE_BLOCK.get());
        add(SIMIX_ORE.get(), (block) ->{return createOreDrop(SIMIX_ORE.get(), DEItems.RAW_SIMIX.get());});
        dropSelf(SIMIX_BLOCK.get());
        add(EMERTYST_ORE.get(), (block) ->{return createOreDrop(EMERTYST_ORE.get(), DEItems.EMERTYST_GEM.get());});
        dropSelf(EMERTYST_BLOCK.get());
        add(ORIGIN_PORTAL.get(), (block) -> {return noDrop();});

        add(ORIGIN_GRASS_BLOCK.get(), (block) -> {return createSilkTouchOrShearsDispatchTable(ORIGIN_DIRT.get(), LootItem.lootTableItem(ORIGIN_GRASS_BLOCK.get()));});
        add(ORIGIN_GRASS.get(), (block) -> {return createGrassDrops(ORIGIN_GRASS.get());});
        dropSelf(ORIGIN_DIRT.get());
        dropSelf(PURPLEHEART_LOG.get());
        dropSelf(STRIPPED_PURPLEHEART_LOG.get());
        dropSelf(PURPLEHEART_PLANKS.get());
        add(PURPLEHEART_SLAB.get(), (block) -> {return createSlabItemTable(PURPLEHEART_SLAB.get());});
        dropSelf(PURPLEHEART_FENCE.get());
        dropSelf(PURPLEHEART_FENCE_GATE.get());
        dropSelf(PURPLEHEART_BUTTON.get());
        dropSelf(PURPLEHEART_PRESSURE_PLATE.get());
        add(PURPLEHEART_DOOR.get(), (block) -> {return createDoorTable(PURPLEHEART_DOOR.get());});
        dropSelf(PURPLEHEART_TRAPDOOR.get());
        add(PURPLEHEART_LEAVES.get(), (block) -> {return createLeavesDrops(PURPLEHEART_LEAVES.get(), PURPLEHEART_SAPLING.get(), 1);});
        dropSelf(PURPLEHEART_STAIRS.get());
        dropSelf(PURPLEHEART_BOOKSHELF.get());
        dropOther(DEBlocks.PURPLEHEART_SIGN.get(), DEItems.PURPLEHEART_SIGN.get());
        dropOther(PURPLEHEART_WALL_SIGN.get(), DEItems.PURPLEHEART_SIGN.get());
        dropSelf(PURPLE_ROSE.get());
        dropSelf(PURPLEHEART_SAPLING.get());
        dropOther(SULFUR_STONE.get(), SULFUR_COBBLESTONE.get().asItem());
        dropSelf(SULFUR_COBBLESTONE.get());
        add(SULFUR_COBBLESTONE_SLAB.get(), (block) -> {return createSlabItemTable(SULFUR_COBBLESTONE_SLAB.get());});
        dropSelf(SULFUR_COBBLESTONE_STAIRS.get());
        dropSelf(SULFUR_STONE_BUTTON.get());
        dropSelf(SULFUR_STONE_PRESSURE_PLATE.get());
        dropSelf(SULFUR_STONE_STAIRS.get());
        add(SULFUR_STONE_SLAB.get(), (block) -> {return createSlabItemTable(SULFUR_STONE_SLAB.get());});
        dropSelf(BLUE_SAND.get());
        dropSelf(BLUE_SANDSTONE.get());
        
        dropPottedContents(POTTED_PURPLE_ROSE.get());
        dropPottedContents(POTTED_PURPLEHEART_SAPLING.get());
        dropSelf(ORIGIN_FRAME.get());

        dropSelf(FORGE.get());
        dropSelf(MINERAL_STORAGE.get());
        add(ESSENCE_EXTRACTOR.get(), (block) -> {return createNameableBlockEntityTable(ESSENCE_EXTRACTOR.get());});
        dropSelf(DISPLAY_BLOCK.get());
        
        add(PURPLE_BERRY_BUSH.get(), (block) -> {
            return applyExplosionDecay(
            		block,
            		LootTable.lootTable()
            		.withPool(LootPool.lootPool()
            				.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(PURPLE_BERRY_BUSH.get())
            						.setProperties(StatePropertiesPredicate.Builder.properties()
            								.hasProperty(SweetBerryBushBlock.AGE, 3)))
            				.add(LootItem.lootTableItem(DEItems.PURPLE_BERRY.get()))
            				.apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
            				.apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
            		.withPool(LootPool.lootPool()
            				.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(PURPLE_BERRY_BUSH.get())
            						.setProperties(StatePropertiesPredicate.Builder.properties()
            								.hasProperty(SweetBerryBushBlock.AGE, 2)))
            				.add(LootItem.lootTableItem(DEItems.PURPLE_BERRY.get()))
            				.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
            				.apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
         });
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BLOCK.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
