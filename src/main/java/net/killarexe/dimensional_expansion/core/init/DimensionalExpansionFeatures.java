package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DimensionalExpansionMod;
import net.killarexe.dimensional_expansion.world.feature.EndTreeFeature;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.SquareDecorator;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.*;

public class DimensionalExpansionFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, DimensionalExpansionMod.MODID);

    public static final RegistryObject<EndTreeFeature> END_TREE = FEATURES.register("end_tree", () -> new EndTreeFeature(NoneFeatureConfiguration.CODEC));

    private static final RuleTest NATURAL_END_STONE = new BlockMatchTest(Blocks.END_STONE);

    public static void addOres(final BiomeLoadingEvent e){
        addOre(e, NATURAL_END_STONE, DimensionalExpansionBlocks.PALON_ORE.get().defaultBlockState(), 8, 64, 75, 1);
        addOre(e, OreConfiguration.Predicates.NATURAL_STONE, DimensionalExpansionBlocks.BASSMITE_ORE.get().defaultBlockState(), 8, 0, 12, 1);
        addOre(e, OreConfiguration.Predicates.NETHERRACK, DimensionalExpansionBlocks.SIMIX_ORE.get().defaultBlockState(), 8, 0, 14, 1);
        addOre(e, NATURAL_END_STONE, DimensionalExpansionBlocks.EMERTYST_ORE.get().defaultBlockState(), 8, 16, 0, 1);
    }

    private static void addOre(final BiomeLoadingEvent e, RuleTest rule, BlockState state, int veinsize, int minHeight, int maxHeight, int amount){
        e.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreConfiguration(rule, state, veinsize))
                        .decorated(SquareDecorator.RANGE.configured(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)))))
                        .squared().count(amount));
    }

}
