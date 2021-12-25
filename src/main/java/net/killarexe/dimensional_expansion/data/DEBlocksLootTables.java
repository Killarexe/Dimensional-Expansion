package net.killarexe.dimensional_expansion.data;

import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import static net.killarexe.dimensional_expansion.core.init.DEBlocks.*;
import static net.killarexe.dimensional_expansion.core.init.DEItems.*;

public class DEBlocksLootTables extends BlockLoot {

    @Override
    protected void addTables() {
        //add(PALON_ORE.get(), (block) ->{return createOreDrop(PALON_ORE.get(), RAW_PALON.get());});
        //dropSelf(PALON_BLOCK.get());
        //add(BASSMITE_ORE.get(), (block) ->{return createOreDrop(BASSMITE_ORE.get(), BASSMITE_GEM.get());});
        //dropSelf(BASSMITE_BLOCK.get());
        //add(SIMIX_ORE.get(), (block) ->{return createOreDrop(SIMIX_ORE.get(), RAW_SIMIX.get());});
        //dropSelf(SIMIX_BLOCK.get());
        //add(EMERTYST_ORE.get(), (block) ->{return createOreDrop(EMERTYST_ORE.get(), EMERTYST_GEM.get());});
        //dropSelf(EMERTYST_BLOCK.get());
//
        //dropSelf(END_GRASS_BLOCK.get());
        //dropSelf(END_LOG.get());
        //dropSelf(END_STRIPPED_LOG.get());
        //dropSelf(END_PLANKS.get());
        //add(END_SLAB.get(), (block) -> {return createSlabItemTable(END_SLAB.get());});
        //dropSelf(END_FENCE.get());
        //dropSelf(END_FENCE_GATE.get());
        //dropSelf(END_BUTTON.get());
        //dropSelf(END_PRESSURE_PLATE.get());
        //add(END_DOOR.get(), (block) -> {return createDoorTable(END_DOOR.get());});
        //dropSelf(END_TRAPDOOR.get());
        //add(END_LEAVES.get(), (block) -> {return createLeavesDrops(END_LEAVES.get(), END_LEAVES.get(), 1);});
        //dropSelf(END_STAIRS.get());
        dropSelf(END_BOOKSHELF.get());
        dropOther(DEBlocks.END_SIGN.get(), DEItems.END_SIGN.get());
        dropOther(END_WALL_SIGN.get(), DEItems.END_SIGN.get());
        dropSelf(END_ROSE.get());

        LootItemCondition.Builder lBuilderXp = LootItemBlockStatePropertyCondition.hasBlockStateProperties(XP_CROPS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(XP_CROPS.get(), (block) -> {return createCropDrops(XP_CROPS.get(), XP_PLANTS.get(), XP_SEEDS.get(), lBuilderXp); });
        LootItemCondition.Builder lBuilderHealth = LootItemBlockStatePropertyCondition.hasBlockStateProperties(HEALTH_CROPS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(HEALTH_CROPS.get(), (block) -> {return createCropDrops(HEALTH_CROPS.get(), HEART.get(), HEART_SEEDS.get(), lBuilderHealth); });

        //dropSelf(END_FORGE.get());
        //add(WEATHER_CHANGER.get(), (block) -> {return createNameableBlockEntityTable(WEATHER_CHANGER.get());});
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BLOCK.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
