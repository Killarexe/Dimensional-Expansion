package net.killarexe.dimensional_expansion.common.world;

import com.mojang.serialization.Codec;
import net.killarexe.dimensional_expansion.core.init.DEBiomeModifiers;
import net.killarexe.dimensional_expansion.core.init.DEBiomes;
import net.killarexe.dimensional_expansion.core.init.DEFeatures;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public class DEBiomeModifier implements BiomeModifier{

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if(phase == Phase.ADD){
            if(biome.is(BiomeTags.IS_END)) {
                builder.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DEFeatures.Placed.PALON_ORE_FEATURE);
                builder.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DEFeatures.Placed.END_ROSE);
                if (biome.is(DEBiomes.END_FOREST_KEY)) {
                    builder.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DEFeatures.Placed.END_TREE);
                }
            }
            if(biome.is(BiomeTags.IS_NETHER)){
                builder.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DEFeatures.Placed.SIMIX_ORE_FEATURE);
            }
            if(biome.is(BiomeTags.IS_OVERWORLD)){
                builder.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DEFeatures.Placed.BASSMITE_ORE_FEATURE);
                builder.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DEFeatures.Placed.EMERTYST_ORE_FEATURE);
            }
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return DEBiomeModifiers.DE_BIOME_MODIFIER.get();
    }
}
