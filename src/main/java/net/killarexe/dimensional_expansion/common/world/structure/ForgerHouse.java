package net.killarexe.dimensional_expansion.common.world.structure;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.Set;


public class ForgerHouse extends Feature<NoneFeatureConfiguration> {

    public static final Feature FEATURE = (ForgerHouse)new ForgerHouse().setRegistryName(DEMod.MODID + ":forger_house");
    public static final ConfiguredFeature<?, ?> CONFIGURED_FEATURE = FEATURE.configured(FeatureConfiguration.NONE);

    public static final Set<ResourceLocation> GENERATE_BIOMES = Set.of(new ResourceLocation("minecraft:end_highlands"));

    private StructureTemplate template = null;

    public ForgerHouse() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        ResourceKey<Level> dimensionType = featurePlaceContext.level().getLevel().dimension();

        if(template == null){
            template = featurePlaceContext.level().getLevel().getStructureManager().getOrCreate(new ResourceLocation(DEMod.MODID + ":forger_house"));
        }

        if(template == null){
            return false;
        }

        if(dimensionType == Level.END && (featurePlaceContext.random().nextInt(1000000) + 1) <= 1000/3){
            boolean isPlaced = false;
            int i = featurePlaceContext.origin().getX() + featurePlaceContext.random().nextInt(16);
            int k = featurePlaceContext.origin().getZ() + featurePlaceContext.random().nextInt(16);
            int j = featurePlaceContext.level().getHeight(Heightmap.Types.WORLD_SURFACE_WG, i, k);
            j -= 1;
            BlockPos spawnTo = new BlockPos(i, j, k);
            if(template.placeInWorld(featurePlaceContext.level(), spawnTo, spawnTo, new StructurePlaceSettings()
            .setMirror(Mirror.NONE)
            .setRotation(Rotation.NONE)
            .addProcessor(BlockIgnoreProcessor.AIR)
            .setIgnoreEntities(false), featurePlaceContext.random(), 1)){
                isPlaced = true;
            }
            return isPlaced;
        }
        return false;
    }
}
