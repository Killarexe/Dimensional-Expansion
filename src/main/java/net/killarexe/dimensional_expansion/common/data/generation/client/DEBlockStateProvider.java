package net.killarexe.dimensional_expansion.common.data.generation.client;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

import static net.killarexe.dimensional_expansion.core.init.DEBlocks.*;

public class DEBlockStateProvider extends BlockStateProvider {
    public DEBlockStateProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, DEMod.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(PALON_ORE.get());
        simpleBlock(PALON_BLOCK.get());
        simpleBlock(BASSMITE_ORE.get());
        simpleBlock(BASSMITE_BLOCK.get());
        simpleBlock(SIMIX_ORE.get());
        simpleBlock(SIMIX_BLOCK.get());
        simpleBlock(EMERTYST_ORE.get());
        simpleBlock(EMERTYST_BLOCK.get());
        simpleBlock(ORIGIN_DIRT.get());
        simpleBlock(SULFUR_STONE.get());
        simpleBlock(SULFUR_COBBLESTONE.get());
        simpleBlock(PURPLEHEART_PLANKS.get());
        simpleBlock(PURPLEHEART_LEAVES.get());
        simpleBlock(BLUE_SAND.get());
        
        logBlock((RotatedPillarBlock)PURPLEHEART_LOG.get());
        logBlock((RotatedPillarBlock)STRIPPED_PURPLEHEART_LOG.get());
        
        slabBlock((SlabBlock)PURPLEHEART_SLAB.get(), PURPLEHEART_SLAB.getId(), blockTexture(PURPLEHEART_PLANKS.get()));
        slabBlock((SlabBlock)SULFUR_STONE_SLAB.get(), SULFUR_STONE_SLAB.getId(), blockTexture(SULFUR_STONE.get()));
        slabBlock((SlabBlock)SULFUR_COBBLESTONE_SLAB.get(), SULFUR_COBBLESTONE_SLAB.getId(), blockTexture(SULFUR_COBBLESTONE.get()));
        
        fenceBlock((FenceBlock) PURPLEHEART_FENCE.get(), blockTexture(PURPLEHEART_PLANKS.get()));
        
        fenceGateBlock((FenceGateBlock) PURPLEHEART_FENCE_GATE.get(), blockTexture(PURPLEHEART_PLANKS.get()));
        
        buttonBlock((ButtonBlock) PURPLEHEART_BUTTON.get(), blockTexture(PURPLEHEART_PLANKS.get()));
        buttonBlock((ButtonBlock) SULFUR_STONE_BUTTON.get(), blockTexture(SULFUR_STONE.get()));
        
        pressurePlateBlock((PressurePlateBlock)PURPLEHEART_PRESSURE_PLATE.get(), blockTexture(SULFUR_STONE.get()));
        pressurePlateBlock((PressurePlateBlock)SULFUR_STONE_PRESSURE_PLATE.get(), blockTexture(SULFUR_STONE.get()));
        
        doorBlock((DoorBlock)PURPLEHEART_DOOR.get(), new ResourceLocation(blockTexture(PURPLEHEART_DOOR.get()) + "_bottom"),
        		new ResourceLocation(blockTexture(PURPLEHEART_DOOR.get()) + "_top"));
        
        trapdoorBlock((TrapDoorBlock)PURPLEHEART_TRAPDOOR.get(), blockTexture(PURPLEHEART_TRAPDOOR.get()), true);
        
        stairsBlock((StairBlock)PURPLEHEART_STAIRS.get(), blockTexture(PURPLEHEART_PLANKS.get()));
        stairsBlock((StairBlock)SULFUR_STONE_STAIRS.get(), blockTexture(SULFUR_STONE.get()));
        stairsBlock((StairBlock)SULFUR_COBBLESTONE_STAIRS.get(), blockTexture(SULFUR_COBBLESTONE.get()));
        
        simpleBlock(ORIGIN_FRAME.get());
        
        getVariantBuilder(BLUE_SANDSTONE.get()).partialState().setModels(new ConfiguredModel(models().cubeBottomTop(BLUE_SANDSTONE.getId().getPath(),
        		blockTexture(BLUE_SANDSTONE.get()),
        		new ResourceLocation(blockTexture(BLUE_SANDSTONE.get()) + "_bottom"),
        		new ResourceLocation(blockTexture(BLUE_SANDSTONE.get()) + "_top")
        )));
        getVariantBuilder(ORIGIN_GRASS_BLOCK.get()).partialState().setModels(new ConfiguredModel(models().cubeBottomTop(ORIGIN_GRASS_BLOCK.getId().getPath(),
        		new ResourceLocation(blockTexture(ORIGIN_GRASS_BLOCK.get()) + "_side"),
        		blockTexture(ORIGIN_DIRT.get()),
        		new ResourceLocation(blockTexture(ORIGIN_GRASS_BLOCK.get()) + "_top")
        )));
        getVariantBuilder(PURPLEHEART_BOOKSHELF.get()).partialState().setModels(new ConfiguredModel(models().cubeBottomTop(PURPLEHEART_BOOKSHELF.getId().getPath(),
        		blockTexture(PURPLEHEART_BOOKSHELF.get()),
        		blockTexture(PURPLEHEART_PLANKS.get()),
        		blockTexture(PURPLEHEART_PLANKS.get())
        )));
        getVariantBuilder(FORGE.get()).partialState().setModels(new ConfiguredModel(models().cube(FORGE.getId().getPath(),
        		new ResourceLocation(blockTexture(FORGE.get()) + "_top"),
        		new ResourceLocation(blockTexture(FORGE.get()) + "_top"),
        		new ResourceLocation(blockTexture(FORGE.get()) + "_front"),
        		new ResourceLocation(blockTexture(FORGE.get()) + "_side"),
        		new ResourceLocation(blockTexture(FORGE.get()) + "_side"),
        		new ResourceLocation(blockTexture(FORGE.get()) + "_side")
        )));
        getVariantBuilder(MINERAL_STORAGE.get()).partialState().setModels(new ConfiguredModel(models().cubeBottomTop(MINERAL_STORAGE.getId().getPath(),
        		new ResourceLocation(blockTexture(MINERAL_STORAGE.get()) + "_side"),
        		new ResourceLocation(blockTexture(MINERAL_STORAGE.get()) + "_bottom"),
        		new ResourceLocation(blockTexture(MINERAL_STORAGE.get()) + "_top")
        )));
        getVariantBuilder(DISPLAY_BLOCK.get()).partialState().setModels(new ConfiguredModel(models().cubeBottomTop(DISPLAY_BLOCK.getId().getPath(),
        		new ResourceLocation(blockTexture(DISPLAY_BLOCK.get()) + "_side"),
        		blockTexture(Blocks.END_STONE),
        		new ResourceLocation(blockTexture(DISPLAY_BLOCK.get()) + "_top")
        )));
    }
}
