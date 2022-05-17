package net.killarexe.dimensional_expansion.common.data.generation.client;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static net.killarexe.dimensional_expansion.core.init.DEBlocks.*;

public class DEBlockStateProvider extends BlockStateProvider {
    public DEBlockStateProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, DEMod.MODID, helper);
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
        logBlock((RotatedPillarBlock)END_STRIPPED_LOG.get());
        slabBlock((SlabBlock)END_SLAB.get(), END_SLAB.get().getRegistryName(), END_PLANKS.get().getRegistryName());
        simpleBlock(END_PLANKS.get());
        fenceBlock((FenceBlock) END_FENCE.get(), END_PLANKS.get().getRegistryName());
        fenceGateBlock((FenceGateBlock) END_FENCE_GATE.get(), END_PLANKS.get().getRegistryName());
        buttonBlock((ButtonBlock) END_BUTTON.get(), END_PLANKS.get().getRegistryName());
        pressurePlateBlock((PressurePlateBlock)END_PRESSURE_PLATE.get(), END_PLANKS.get().getRegistryName());
        doorBlock((DoorBlock)END_DOOR.get(), new ResourceLocation(END_DOOR.get().getRegistryName() + "_bottom"),
        		new ResourceLocation(END_DOOR.get().getRegistryName() + "_top"));
        trapdoorBlock((TrapDoorBlock)END_TRAPDOOR.get(), END_TRAPDOOR.get().getRegistryName(), true);
        simpleBlock(END_LEAVES.get());
        stairsBlock((StairBlock)END_STAIRS.get(), END_PLANKS.get().getRegistryName());
        simpleBlock(END_SAND.get());
        simpleBlock(END_SANDSTONE.get());
    }
}
