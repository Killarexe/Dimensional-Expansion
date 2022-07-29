package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class DEPlacedFeatures {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DEMod.MOD_ID);

    public static final RegistryObject<PlacedFeature> PALON_ORE = registerPlacedFeature(
            "palon_ore_placed",
            DEConfiguredFeatures.PALON_ORE.getHolder().get(),
            commonOrePlacement(1, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(46), VerticalAnchor.aboveBottom(72)))
    );

    public static final RegistryObject<PlacedFeature> BASSMITE_ORE = registerPlacedFeature(
            "bassmite_ore_placed",
            DEConfiguredFeatures.BASSMITE_ORE.getHolder().get(),
            commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(64), VerticalAnchor.aboveBottom(90)))
    );

    public static final RegistryObject<PlacedFeature> SIMIX_ORE = registerPlacedFeature(
            "simix_ore_placed",
            DEConfiguredFeatures.SIMIX_ORE.getHolder().get(),
            commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(64)))
    );

    public static final RegistryObject<PlacedFeature> EMERTYST_ORE = registerPlacedFeature(
            "emertyst_ore_placed",
            DEConfiguredFeatures.EMERTYST_ORE.getHolder().get(),
            commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))
    );

    private static RegistryObject<PlacedFeature> registerPlacedFeature(String name, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers){
        return PLACED_FEATURES.register(name, () -> new PlacedFeature(feature, modifiers));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
}
