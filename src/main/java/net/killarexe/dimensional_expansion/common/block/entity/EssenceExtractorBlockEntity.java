package net.killarexe.dimensional_expansion.common.block.entity;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBlockEntities;
import net.killarexe.dimensional_expansion.core.init.DERecipeTypes;
import net.killarexe.dimensional_expansion.common.data.recipes.EssenceExtractorRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.*;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class EssenceExtractorBlockEntity extends InventoryBlockEntity{

    public static final Component TITLE = new TranslatableComponent("block." + DEMod.MODID + ".essence_extractor");

    public EssenceExtractorBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(DEBlockEntities.ESSENCE_EXTRACTOR.get(), pWorldPosition, pBlockState, 2);
    }

    private void craft(){
        SimpleContainer container = new SimpleContainer(inventory.getSlots());
        for(int i = 0; i < inventory.getSlots(); i++){
            container.setItem(i, inventory.getStackInSlot(i));
        }
        Optional<EssenceExtractorRecipe> recipe = level.getRecipeManager().getRecipeFor(DERecipeTypes.ESSENCE_EXTRACTOR_RECIPE_TYPE, container, level);
        if(recipe.isPresent()){
            ParticleUtils.spawnParticlesOnBlockFaces(level, worldPosition, ParticleTypes.COMPOSTER, UniformInt.of(3, 5));
            extract(new ItemStack(recipe.get().getResultItem().getItem(), inventory.getStackInSlot(1).getCount() + 1));
        }
    }

    private void extract(ItemStack output){
        inventory.extractItem(0, 1, false);
        inventory.setStackInSlot(1, output);
    }

    @Override
    public void tick() {
        if(level.isClientSide()){
            return;
        }
        setChanged();
        craft();
    }
}
