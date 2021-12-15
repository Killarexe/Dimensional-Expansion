package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.world.structure.ForgerHouse;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class DEFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, DEMod.MODID);

    private static final RuleTest NATURAL_NETHERRACK = new BlockMatchTest(Blocks.NETHERRACK);
    private static final RuleTest NATURAL_STONE = new BlockMatchTest(Blocks.STONE);
    private static final RuleTest NATURAL_END_STONE = new BlockMatchTest(Blocks.END_STONE);
    private static final RuleTest NATURAL_DEEPSLATE = new BlockMatchTest(Blocks.DEEPSLATE);

    public static void addFeatures(final BiomeLoadingEvent e){
        addOre(e, NATURAL_END_STONE, DEBlocks.PALON_ORE.get().defaultBlockState(), 8, 54, 75, 1);
        addOre(e, NATURAL_STONE, DEBlocks.BASSMITE_ORE.get().defaultBlockState(), 8, 0, 12, 1);
        addOre(e, NATURAL_NETHERRACK, DEBlocks.SIMIX_ORE.get().defaultBlockState(), 8, 0, 14, 1);
        addOre(e, NATURAL_DEEPSLATE, DEBlocks.EMERTYST_ORE.get().defaultBlockState(), 8, 16, 0, 1);
        e.getGeneration().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ForgerHouse.CONFIGURED_FEATURE.placed());
    }

    private static void addOre(final BiomeLoadingEvent e, RuleTest rule, BlockState state, int veinsize, int minHeight, int maxHeight, int amount){
        e.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreConfiguration(rule, state, veinsize))
                        .placed(rareOrePlacement(amount, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)))));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

}
