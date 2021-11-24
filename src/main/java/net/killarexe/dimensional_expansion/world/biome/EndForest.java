package net.killarexe.dimensional_expansion.world.biome;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBiomes;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.data.worldgen.biome.Biomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.*;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EndForest {

    private static final Map<ResourceLocation, ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = new HashMap<>();
    private static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderBaseConfiguration(
            DEBlocks.END_GRASS_BLOCK.get().defaultBlockState(),
            Blocks.END_STONE.defaultBlockState(),
            Blocks.END_STONE.defaultBlockState()
    ));

    public static Biome createBiome(){

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(0x3f76e4)
                .waterFogColor(0x50533)
                .skyColor(0x50533)
                .waterColor(0xc0d8ff)
                .build();

        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder().surfaceBuilder(SURFACE_BUILDER);
        settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, register("end_tree", Feature.TREE.configured(new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(DEBlocks.END_LOG.get().defaultBlockState()),
                new StraightTrunkPlacer(5, 2, 0),
                new SimpleStateProvider(DEBlocks.END_LEAVES.get().defaultBlockState()),
                new SimpleStateProvider(DEBlocks.END_LEAVES.get().defaultBlockState()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build())
                .decorated(Features.Decorators.HEIGHTMAP_SQUARE)
                .decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(5, 0.1F, 1)
                ))));

        MobSpawnSettings.Builder spawn = new MobSpawnSettings.Builder().setPlayerCanSpawn();
        spawn.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 5));

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .biomeCategory(Biome.BiomeCategory.ICY)
                .depth(72f)
                .scale(3f)
                .temperature(1f)
                .downfall(0f)
                .specialEffects(effects)
                .mobSpawnSettings(spawn.build())
                .generationSettings(settings.build())
                .build();
    }

    public static void init(){
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(DEMod.MODID, "end_forest"), SURFACE_BUILDER);
        ResourceKey<Biome> key = ResourceKey.create(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(DEBiomes.END_FOREST.get())));
        CONFIGURED_FEATURES.forEach((resourceLocation, configuredFeature) -> Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, resourceLocation, configuredFeature));
        BiomeDictionary.addTypes(key, BiomeDictionary.Type.END);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(key, 5));
    }

    private static ConfiguredFeature<?, ?> register(String name, ConfiguredFeature<?, ?> configuredFeature) {
        CONFIGURED_FEATURES.put(new ResourceLocation(DEMod.MODID, name), configuredFeature);
        return configuredFeature;
    }
}
