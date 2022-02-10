package net.killarexe.dimensional_expansion.common.blockentity;

import net.killarexe.dimensional_expansion.common.data.recipes.EssenceExtractorRecipe;
import net.killarexe.dimensional_expansion.core.init.DEBlockEntities;
import net.killarexe.dimensional_expansion.core.init.DERecipeTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class EssenceExtractorBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    public EssenceExtractorBlockEntity(BlockPos pos, BlockState state) {
        super(DEBlockEntities.ESSENCE_EXTRACTOR_BLOCK_ENTITY, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return null;
    }

    @Override
    public Text getDisplayName() {
        return null;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return null;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);
    }

    public void tick(){
        if(world.isClient){
            return;
        }
        markDirty();
        craft();
    }

    private void craft(){
        SimpleInventory container = new SimpleInventory(inventory.size());
        for(int i = 0; i < inventory.size(); i++){
            container.setStack(i, inventory.get(i));
        }
        Optional<EssenceExtractorRecipe> recipe = world.getRecipeManager().getFirstMatch(DERecipeTypes.ESSENCE_EXTRACTOR_RECIPE, container, world);
        if(recipe.isPresent()){
            ParticleUtil.spawnParticle(world, pos, ParticleTypes.COMPOSTER, UniformIntProvider.create(3, 5));
            extract(new ItemStack(recipe.get().getResult().getItem(), inventory.get(1).getCount() + 1));
        }
    }

    private void extract(ItemStack output){
        inventory.remove(0);
        inventory.set(1, output);
    }

}
