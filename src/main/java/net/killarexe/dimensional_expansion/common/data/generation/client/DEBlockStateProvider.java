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

        logBlock((RotatedPillarBlock)END_LOG.get());
        logBlock((RotatedPillarBlock)STRIPPED_END_LOG.get());
        slabBlock((SlabBlock)END_SLAB.get(), END_SLAB.getId(), blockTexture(END_PLANKS.get()));
        simpleBlock(END_PLANKS.get());
        fenceBlock((FenceBlock) END_FENCE.get(), blockTexture(END_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) END_FENCE_GATE.get(), blockTexture(END_PLANKS.get()));
        buttonBlock((ButtonBlock) END_BUTTON.get(), blockTexture(END_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock)END_PRESSURE_PLATE.get(), blockTexture(END_PLANKS.get()));
        doorBlock((DoorBlock)END_DOOR.get(), "end", new ResourceLocation("end_" + blockTexture(END_DOOR.get()) + "_bottom"),
        		new ResourceLocation("end_" + blockTexture(END_DOOR.get()) + "_top"));
        trapdoorBlock((TrapDoorBlock)END_TRAPDOOR.get(), blockTexture(END_TRAPDOOR.get()), true);
        simpleBlock(END_LEAVES.get());
        stairsBlock((StairBlock)END_STAIRS.get(), blockTexture(END_PLANKS.get()));
        simpleBlock(END_SAND.get());
        getVariantBuilder(END_SANDSTONE.get()).partialState().setModels(new ConfiguredModel(models().cubeBottomTop(END_SANDSTONE.getId().getPath(),
        		blockTexture(END_SANDSTONE.get()),
        		new ResourceLocation(blockTexture(END_SANDSTONE.get()) + "_bottom"),
        		new ResourceLocation(blockTexture(END_SANDSTONE.get()) + "_top")
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
