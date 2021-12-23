package net.killarexe.dimensional_expansion.common.blockentity;

import net.killarexe.dimensional_expansion.core.init.DEBlockEntities;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class WeatherChangerBlockEntity extends BlockEntity {

    private final ItemStackHandler itemHandler = createHandeler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public WeatherChangerBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(DEBlockEntities.WEATHER_CHANGER.get(), p_155229_, p_155230_);
    }


    @Override
    public CompoundTag save(CompoundTag p_58888_) {
        p_58888_.put("inv", itemHandler.serializeNBT());
        return super.save(p_58888_);
    }

    @Override
    public void load(CompoundTag p_155245_) {
        itemHandler.deserializeNBT(p_155245_.getCompound("inv"));
        super.load(p_155245_);
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
                    case 0: return stack.getItem() == DEItems.EMERTYST_GEM.get();
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

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return handler.cast();
        }
        return super.getCapability(cap);
    }

    public void changeWeather(){
        if(itemHandler.isItemValid(0, itemHandler.getStackInSlot(0))){
            Level level = this.getLevel();
            if(level.isRaining()){
                level.setRainLevel(1);
            }else{
                level.setRainLevel(-1);
            }
        }
    }

}
