package net.killarexe.dimensional_expansion.core.init;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.blockentity.EndSignBlockEntity;
import net.killarexe.dimensional_expansion.common.blockentity.EssenceExtractorBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DEBlockEntities {

    public static final BlockEntityType<EndSignBlockEntity> END_SIGN_BLOCK_ENTITY = registerBlockEntity("end_sign", EndSignBlockEntity::new, DEBlocks.END_SIGN, DEBlocks.END_WALL_SIGN);
    public static final BlockEntityType<EssenceExtractorBlockEntity> ESSENCE_EXTRACTOR_BLOCK_ENTITY = registerBlockEntity("essence_extractor", EssenceExtractorBlockEntity::new, DEBlocks.ESSENCE_EXTRACTOR);

    public static void registerBlockEntities(){
        DEMod.LOGGER.info("Register Dimensional Expansion Block Entitys!");
    }

    private static BlockEntityType registerBlockEntity(String id, FabricBlockEntityTypeBuilder.Factory<? extends BlockEntity> factory, Block... blocks){
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DEMod.MODID, id), FabricBlockEntityTypeBuilder.create(factory, blocks).build(null));
    }
}
