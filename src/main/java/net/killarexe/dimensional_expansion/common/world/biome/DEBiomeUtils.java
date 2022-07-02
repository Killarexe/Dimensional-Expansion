package net.killarexe.dimensional_expansion.common.world.biome;

import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.*;

public class DEBiomeUtils {
    public static Biome biome(float temperature, float downFall, MobSpawnSettings.Builder mobBuilder,
                              BiomeGenerationSettings.Builder generationBuilder, Music music, int waterColor) {
        return biome(temperature, downFall, waterColor, 329011, mobBuilder, generationBuilder, music);
    }

    public static Biome biome(float temperature, float downFall, int waterColor, int p_194857_, MobSpawnSettings.Builder mobBuilder,
                              BiomeGenerationSettings.Builder generationBuilder, Music music) {
        return (new Biome.BiomeBuilder())
                .precipitation(Biome.Precipitation.RAIN)
                .temperature(temperature)
                .downfall(downFall)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(waterColor).waterFogColor(p_194857_)
                        .fogColor(12638463)
                        .skyColor(calculateSkyColor(temperature))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(music).build()).mobSpawnSettings(mobBuilder.build())
                .generationSettings(generationBuilder.build())
                .build();
    }

    public static int calculateSkyColor(float temperature) {
        float value = temperature / 3.0F;
        value = Mth.clamp(value, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - value * 0.05F, 0.5F + value * 0.1F, 1.0F);
    }
}
