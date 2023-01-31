package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class DEDimensions {
    public static final ResourceKey<Level> ORIGIN = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DEMod.MOD_ID, "origin"));

    public static final ResourceKey<DimensionType> ORIGIN_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, ORIGIN.registry());

    public static void register(){
        DEMod.LOGGER.info("Init Dimensional Expansion Dimensions");
    }
}
