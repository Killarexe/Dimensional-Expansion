package net.killarexe.dimensional_expansion.common.data.generation.client;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
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

        simpleBlock(END_PLANKS.get());
        fenceBlock((FenceBlock) END_FENCE.get(), END_PLANKS.get().getRegistryName());
        fenceGateBlock((FenceGateBlock) END_FENCE_GATE.get(), END_PLANKS.get().getRegistryName());
        buttonBlock((ButtonBlock) END_BUTTON.get(), END_PLANKS.get().getRegistryName());
    }
}
