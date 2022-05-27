package net.killarexe.dimensional_expansion.common.world.structure;

import net.killarexe.dimensional_expansion.core.init.DEBiomes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.BuiltinStructureSets;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;

import java.util.Optional;
import java.util.function.Predicate;


public class ForgerHouse extends StructureFeature<JigsawConfiguration> {

    public ForgerHouse() {
        super(JigsawConfiguration.CODEC, ForgerHouse::createPiecesGenerator);
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    @Override
    public boolean canGenerate(RegistryAccess p_197172_, ChunkGenerator p_197173_, BiomeSource source, StructureManager p_197175_, long p_197176_, ChunkPos p_197177_, JigsawConfiguration p_197178_, LevelHeightAccessor p_197179_, Predicate<Holder<Biome>> p_197180_) {
        return source.equals(Biomes.END_MIDLANDS) || source.equals(Biomes.END_BARRENS) || source.equals(Biomes.END_HIGHLANDS) ||
                source.equals(DEBiomes.END_FOREST_KEY) || source.equals(DEBiomes.END_DESERT_KEY) || source.equals(DEBiomes.END_JUNGLE_KEY);
    }

    private static boolean isFeatureChunk(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
        ChunkPos chunkpos = context.chunkPos();
        return !context.chunkGenerator().hasFeatureChunkInRange(BuiltinStructureSets.OCEAN_MONUMENTS, context.seed(), chunkpos.x, chunkpos.z, 10);
    }

    public static Optional<PieceGenerator<JigsawConfiguration>> createPiecesGenerator(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
        if (!ForgerHouse.isFeatureChunk(context)) {
            return Optional.empty();
        }
        BlockPos blockpos = context.chunkPos().getMiddleBlockPosition(0);
        int topLandY = context.chunkGenerator().getFirstFreeHeight(blockpos.getX(), blockpos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor());
        blockpos = blockpos.above(topLandY);

        Optional<PieceGenerator<JigsawConfiguration>> structurePiecesGenerator =
                JigsawPlacement.addPieces(
                        context,
                        PoolElementStructurePiece::new,
                        blockpos,
                        false,
                        false
                );
        return structurePiecesGenerator;
    }
}