package net.killarexe.dimensional_expansion.common.block.entity;

import net.killarexe.dimensional_expansion.core.init.DEBlockEntities;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class EssenceExtractorBlockEntity extends BlockEntity {

    private final ItemStackHandler itemHandler = createHandeler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public EssenceExtractorBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(DEBlockEntities.ESSENCE_EXTRACTOR.get(), pWorldPosition, pBlockState);
    }

    @Override
    public void saveAdditional(CompoundTag pTag) {
        pTag.put("inv", itemHandler.serializeNBT());
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        itemHandler.deserializeNBT(pTag.getCompound("inv"));
        super.load(pTag);
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        return super.getCapability(cap);
    }

    private ItemStackHandler createHandeler(){
        return new ItemStackHandler(1){
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

                switch (slot){
                    case 0: return stack.getItem() == DEItems.XP_PLANTS.get() || stack.getItem() == DEItems.HEART.get();
                    default: return false;
                }
            }

            @Override
            public int getSlotLimit(int slot) {
                return 1;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if(!isItemValid(slot, stack)){
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }
}
