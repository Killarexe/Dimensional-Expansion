package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.world.structure.ForgerHouse;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.SquareDecorator;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DEFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, DEMod.MODID);

    private static final RuleTest NATURAL_END_STONE = new BlockMatchTest(Blocks.END_STONE);

    public static void addFeatures(final BiomeLoadingEvent e){
        addOre(e, NATURAL_END_STONE, DEBlocks.PALON_ORE.get().defaultBlockState(), 8, 64, 75, 1);
        addOre(e, OreConfiguration.Predicates.NATURAL_STONE, DEBlocks.BASSMITE_ORE.get().defaultBlockState(), 8, 0, 12, 1);
        addOre(e, OreConfiguration.Predicates.NETHERRACK, DEBlocks.SIMIX_ORE.get().defaultBlockState(), 8, 0, 14, 1);
        addOre(e, OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, DEBlocks.EMERTYST_ORE.get().defaultBlockState(), 8, 16, 0, 1);
        e.getGeneration().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ForgerHouse.CONFIGURED_FEATURE);
    }

    private static void addOre(final BiomeLoadingEvent e, RuleTest rule, BlockState state, int veinsize, int minHeight, int maxHeight, int amount){
        e.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreConfiguration(rule, state, veinsize))
                        .decorated(SquareDecorator.RANGE.configured(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)))))
                        .squared().count(amount));
    }

}
