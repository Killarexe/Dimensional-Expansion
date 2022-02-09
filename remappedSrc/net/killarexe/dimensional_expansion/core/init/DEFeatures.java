package net.killarexe.dimensional_expansion.core.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;

import java.util.function.Predicate;

public class DEFeatures {

    public static final ConfiguredFeature<?, ?> PALON_ORE_FEATURE = createOreConfiguredFeature(new BlockMatchRuleTest(Blocks.END_STONE), DEBlocks.PALON_ORE, 4);
    public static final PlacedFeature PALON_ORE_PLACED_FEATURE = createOrePlacedFeature(PALON_ORE_FEATURE, 1, 64, 85);
    public static final ConfiguredFeature<?, ?> BASSMITE_ORE_FEATURE = createOreConfiguredFeature(OreConfiguredFeatures.BASE_STONE_OVERWORLD, DEBlocks.PALON_ORE, 3);
    public static final PlacedFeature BASSMITE_ORE_PLACED_FEATURE = createOrePlacedFeature(BASSMITE_ORE_FEATURE, 1, 0, 24);
    public static final ConfiguredFeature<?, ?> SIMIX_ORE_FEATURE = createOreConfiguredFeature(OreConfiguredFeatures.NETHERRACK, DEBlocks.PALON_ORE, 2);
    public static final PlacedFeature SIMIX_ORE_PLACED_FEATURE = createOrePlacedFeature(SIMIX_ORE_FEATURE, 1, 0, 12);
    public static final ConfiguredFeature<?, ?> EMERTYST_ORE_FEATURE = createOreConfiguredFeature(new BlockMatchRuleTest(Blocks.DEEPSLATE), DEBlocks.PALON_ORE, 1);
    public static final PlacedFeature EMERTYST_ORE_PLACED_FEATURE = createOrePlacedFeature(EMERTYST_ORE_FEATURE, 1, -64, 0);

    public static void registerFeatures(){
        registerOreFeature("palon_ore", PALON_ORE_FEATURE, PALON_ORE_PLACED_FEATURE, BiomeSelectors.foundInTheEnd());
        registerOreFeature("bassmite_ore", BASSMITE_ORE_FEATURE, BASSMITE_ORE_PLACED_FEATURE, BiomeSelectors.foundInOverworld());
        registerOreFeature("simix_ore", SIMIX_ORE_FEATURE, SIMIX_ORE_PLACED_FEATURE, BiomeSelectors.foundInTheNether());
        registerOreFeature("emertyst_ore", EMERTYST_ORE_FEATURE, EMERTYST_ORE_PLACED_FEATURE, BiomeSelectors.foundInOverworld());
    }

    private static void registerOreFeature(String id, ConfiguredFeature<?, ?> oreFeature, PlacedFeature orePlacedFeature, Predicate<BiomeSelectionContext> biomeSelector){
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(DEMod.MODID, id), oreFeature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(DEMod.MODID, id), orePlacedFeature);
        BiomeModifications.addFeature(biomeSelector, GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(DEMod.MODID, id)));
    }

    private static ConfiguredFeature<?, ?> createOreConfiguredFeature(RuleTest rule, Block ore, int size){
        return Feature.ORE.configure(new OreFeatureConfig(rule, ore.getDefaultState(), size));
    }

    private static PlacedFeature createOrePlacedFeature(ConfiguredFeature<?, ?> configuredFeature, int num, int minheight, int maxHeight){
        return configuredFeature.withPlacement(CountPlacementModifier.of(num), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.fixed(minheight), YOffset.fixed(maxHeight)));
    }

}
