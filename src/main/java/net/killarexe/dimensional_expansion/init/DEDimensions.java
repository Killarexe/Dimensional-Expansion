package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class DEDimensions {
    public static final ResourceKey<Level> ORIGIN = ResourceKey.create(Registries.DIMENSION, DEMod.res("origin"));

    public static final ResourceKey<DimensionType> ORIGIN_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, ORIGIN.registry());

    public static void register(){
        //It's just to initialize the constants...
    }
}
