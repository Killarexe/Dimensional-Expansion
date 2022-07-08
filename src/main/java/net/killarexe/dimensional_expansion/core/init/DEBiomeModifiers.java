package net.killarexe.dimensional_expansion.core.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.world.biome.modifiers.DEOreModifier;
import net.killarexe.dimensional_expansion.common.world.biome.modifiers.DEVegatalModifier;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DEBiomeModifiers {

    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, DEMod.MOD_ID);

    public static final RegistryObject<Codec<DEOreModifier>> DE_ORE_MODIFIER = BIOME_MODIFIERS.register("ore_modifier", () ->
                    RecordCodecBuilder.create(builder -> builder.group(
                            Biome.LIST_CODEC.fieldOf("biomes").forGetter(DEOreModifier::biomes),
                            PlacedFeature.CODEC.fieldOf("feature").forGetter(DEOreModifier::feature)
                    ).apply(builder, DEOreModifier::new))
    );

    public static final RegistryObject<Codec<DEVegatalModifier>> DE_VEGETAL_MODIFIER = BIOME_MODIFIERS.register("vegetal_modifier", () ->
            RecordCodecBuilder.create(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(DEVegatalModifier::biomes),
                    PlacedFeature.CODEC.fieldOf("feature").forGetter(DEVegatalModifier::feature)
            ).apply(builder, DEVegatalModifier::new))
    );
}
