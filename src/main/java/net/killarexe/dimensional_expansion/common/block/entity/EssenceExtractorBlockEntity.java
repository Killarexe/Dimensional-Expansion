package net.killarexe.dimensional_expansion.common.block.entity;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.data.recipes.EssenceExtractorRecipe;
import net.killarexe.dimensional_expansion.core.init.DEBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class EssenceExtractorBlockEntity extends InventoryBlockEntity{

    public static final Component TITLE = MutableComponent.create(new TranslatableContents("block." + DEMod.MOD_ID + ".essence_extractor"));

    public EssenceExtractorBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(DEBlockEntityTypes.ESSENCE_EXTRACTOR.get(), pWorldPosition, pBlockState, 2);
    }

    private void craft(){
        SimpleContainer container = new SimpleContainer(inventory.getSlots());
        for(int i = 0; i < inventory.getSlots(); i++){
            container.setItem(i, inventory.getStackInSlot(i));
        }
        Optional<EssenceExtractorRecipe> recipe = level.getRecipeManager().getRecipeFor(EssenceExtractorRecipe.Type.INSTANCE, container, level);
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
