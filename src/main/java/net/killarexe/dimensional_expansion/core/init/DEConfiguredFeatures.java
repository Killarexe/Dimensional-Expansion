package net.killarexe.dimensional_expansion.core.init;

import com.google.common.base.Suppliers;
import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class DEConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, DEMod.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> PALON_ORE = registerOreFeature(
            "palon_ore_configured",
            new BlockMatchTest(Blocks.END_STONE), DEBlocks.PALON_ORE,
            8
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> BASSMITE_ORE = registerOreFeature(
            "bassmite_ore_configured",
            OreFeatures.STONE_ORE_REPLACEABLES, DEBlocks.BASSMITE_ORE,
            7
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> SIMIX_ORE = registerOreFeature(
            "simix_ore_configured",
            OreFeatures.NETHER_ORE_REPLACEABLES, DEBlocks.SIMIX_ORE,
            6
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> EMERTYST_ORE = registerOreFeature(
            "emertyst_ore_configured",
            OreFeatures.DEEPSLATE_ORE_REPLACEABLES, DEBlocks.EMERTYST_ORE,
            4
    );

    private static RegistryObject<ConfiguredFeature<?, ?>> registerOreFeature(String name, RuleTest rule, RegistryObject<Block> target, int blocksPerVeins){
        return FEATURES.register(name, () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(rule, target.get().defaultBlockState())), blocksPerVeins)));
    }
}
