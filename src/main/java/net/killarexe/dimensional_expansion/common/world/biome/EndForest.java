package net.killarexe.dimensional_expansion.common.world.biome;

import net.killarexe.dimensional_expansion.core.init.DEFeatures;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class EndForest {

    public static final Climate.ParameterPoint PARAMETER_POINT = new Climate.ParameterPoint(
            Climate.Parameter.span(1, 1),
            Climate.Parameter.span(0, 1),
            Climate.Parameter.span(64, 1),
            Climate.Parameter.span(10, 1),
            Climate.Parameter.point(0),
            Climate.Parameter.span(1, 1),
            0
    );

    public static final Climate.ParameterPoint UNDERGROUND_PARAMETER_POINT = new Climate.ParameterPoint(
            Climate.Parameter.span(-1, 1),
            Climate.Parameter.span(-1, 1),
            Climate.Parameter.span(64, 1),
            Climate.Parameter.span(10, 1),
            Climate.Parameter.span(0.2f, 0.9f),
            Climate.Parameter.span(1, 1),
            0
    );

    public static Biome getBiome(){
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(0xffffff)
                .waterColor(0xfffff)
                .waterFogColor(0xfffff)
                .skyColor(0xfffff)
                .foliageColorOverride(0xfffff)
                .grassColorOverride(0xfffff)
                .build();

        BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder();
        settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DEFeatures.Placed.END_TREE_PLACED);
        settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DEFeatures.Placed.END_ROSE_PLACED);
        settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DEFeatures.Placed.PALON_ORE_PLACED);

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .temperature(1f)
                .downfall(0f)
                .specialEffects(effects)
                .generationSettings(settings.build())
                .build();
    }
}
