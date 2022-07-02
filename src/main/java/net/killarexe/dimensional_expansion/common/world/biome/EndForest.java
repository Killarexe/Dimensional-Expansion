package net.killarexe.dimensional_expansion.common.world.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Musics;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class EndForest{
    public static Biome get(){
        MobSpawnSettings.Builder modBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.endSpawns(modBuilder);
        BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addSurfaceFreezing(genBuilder);
        return DEBiomeUtils.biome(0.0f,0.0f, modBuilder, genBuilder, Musics.END, 0x7435e0);
    }
}
