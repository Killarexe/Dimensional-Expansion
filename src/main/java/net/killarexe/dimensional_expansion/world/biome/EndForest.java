package net.killarexe.dimensional_expansion.world.biome;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBiomes;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class EndForest {

    private static final Map<ResourceLocation, ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = new HashMap<>();
    private static BlockStateProvider log = new BlockStateProvider() {
        @Override
        protected BlockStateProviderType<?> type() {
            return BlockStateProviderType.DUAL_NOISE_PROVIDER;
        }

        @Override
        public BlockState getState(Random p_68750_, BlockPos p_68751_) {
            return DEBlocks.END_LOG.get().defaultBlockState();
        }
    };

    private static BlockStateProvider leaves = new BlockStateProvider() {
        @Override
        protected BlockStateProviderType<?> type() {
            return BlockStateProviderType.DUAL_NOISE_PROVIDER;
        }

        @Override
        public BlockState getState(Random p_68750_, BlockPos p_68751_) {
            return DEBlocks.END_LEAVES.get().defaultBlockState();
        }
    };

    public static Biome createBiome(){
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(0x3f76e4)
                .waterFogColor(0x50533)
                .skyColor(0x50533)
                .waterColor(0xc0d8ff)
                .build();

        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder();
        //settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, register("end_tree", Feature.TREE.configured(new TreeConfiguration.TreeConfigurationBuilder(
        //                log,
        //                new StraightTrunkPlacer(5, 2, 0),
        //                leaves,
        //                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
        //                new TwoLayersFeatureSize(1, 0, 1)).build())
        //        ).)));

        MobSpawnSettings.Builder spawn = new MobSpawnSettings.Builder();
        spawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 5));

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .temperature(1f)
                .downfall(0f)
                .specialEffects(effects)
                .mobSpawnSettings(spawn.build())
                .generationSettings(settings.build())
                .build();
    }

    public static void init(){
        ResourceKey<Biome> key = ResourceKey.create(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(DEBiomes.END_FOREST.get())));
        CONFIGURED_FEATURES.forEach((resourceLocation, configuredFeature) -> Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, resourceLocation, configuredFeature));
        BiomeDictionary.addTypes(key, BiomeDictionary.Type.END);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(key, 5));
    }

    private static ConfiguredFeature<?, ?> register(String name, ConfiguredFeature<?, ?> configuredFeature) {
        CONFIGURED_FEATURES.put(new ResourceLocation(DEMod.MODID, name), configuredFeature);
        return configuredFeature;
    }
}
