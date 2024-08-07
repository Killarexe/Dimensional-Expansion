package net.killarexe.dimensional_expansion.common.block.entity;

import net.killarexe.dimensional_expansion.init.DEBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class DisplayBlockEntity extends InventoryBlockEntity{

    private static final int LIMIT = 1;
    private boolean showName;

    public DisplayBlockEntity(BlockPos pos, BlockState state) {
        super(DEBlockEntityTypes.DISPLAY_BLOCK.get(), pos, state, LIMIT);
        this.showName = true;
    }

    public boolean appendItem(ItemStack stack) {
    	final ItemStack current = getItemInSlot(0);
        final int currentCount = current.getCount();
        if (current.getCount() < 0 || current.isEmpty()) {
            current.setCount(0);
        }
        
        if (!current.isEmpty() && !ItemStack.isSameItem(stack, current))
            return false;
        
        if (stack.getCount() < 0) {
            stack.setCount(0);
            return false;
        }
        
        if (current.getCount() >= LIMIT)
            return false;
        
        boolean increment = false;
        if (current.isEmpty() || current.getCount() == 0) {
            insertItem(0, new ItemStack(stack.getItem(), 1));
            increment = true;
        }
        
        final var copy = new ItemStack(stack.getItem(), getItemInSlot(0).getCount());
        if (current.getCount() + stack.getCount() > LIMIT) {
            final int available = LIMIT - copy.getCount();
            stack.shrink(available);
            copy.setCount(LIMIT);
        } else {
            copy.grow(stack.getCount());
            stack.shrink(stack.getCount());
        }
        
        if (increment) {
            copy.shrink(1);
            stack.shrink(1);
        }
        
        if (currentCount != copy.getCount()) {
            this.inventory.setStackInSlot(0, copy);
            update();
            return true;
        }
        
        return false;
    }

    @Override
    public void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        final CompoundTag inventory = compound.getCompound("Inventory");
        this.inventory.setSize(
                inventory.contains("Size", Tag.TAG_INT) ? inventory.getInt("Size") : this.inventory.getSlots());

        if(compound.contains("showName")) {
        	showName = compound.getBoolean("showName");
        }

        final ListTag items = inventory.getList("Items", Tag.TAG_COMPOUND);
        for (int index = 0; index < items.size(); index++) {
            final CompoundTag itemTags = items.getCompound(index);
            final int slot = itemTags.getInt("Slot");

            if (slot >= 0 && slot < this.inventory.getSlots()) {
                final var stack = ItemStack.parseOptional(provider, itemTags);
                stack.setCount(itemTags.getInt("RealCount"));
                this.inventory.setStackInSlot(slot, stack);
            }
        }

        this.setChanged();
    }

    public boolean prependItem(Player player) {
        final ItemStack current = getItemInSlot(0);
        final ItemStack copy = current.copy();

        final int currentCount = current.getCount();
        if (current.getCount() <= 0)
            return false;

        getItemInSlot(0).shrink(1);

        if (currentCount != current.getCount()) {
            copy.setCount(1);
            final ItemEntity item = new ItemEntity(this.level, player.getX(), player.getY() + 0.5D, player.getZ(), copy);
            this.level.addFreshEntity(item);
            update();
            return true;
        }

        return false;
    }

    public boolean prependStack(Player player) {
        final ItemStack current = getItemInSlot(0);
        final ItemStack copy = current.copy();

        final int currentCount = current.getCount();
        if (current.getCount() <= 0)
            return false;

        int count = 0;
        if (currentCount >= 64) {
            count = 64;
            current.shrink(64);
        } else {
            count = currentCount;
            this.inventory.setStackInSlot(0, ItemStack.EMPTY);
        }

        if (currentCount != current.getCount() && count != 0) {
            copy.setCount(count);
            final ItemEntity item = new ItemEntity(this.level, player.getX(), player.getY() + 0.5D, player.getZ(), copy);
            this.level.addFreshEntity(item);
            update();
            return true;
        }

        return false;
    }

    @Override
    public void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        final ListTag items = new ListTag();
        for (int slot = 0; slot < this.inventory.getSlots(); slot++) {
            if (!this.inventory.getStackInSlot(slot).isEmpty()) {
                final CompoundTag item = new CompoundTag();
                item.putInt("Slot", slot);
                this.inventory.getStackInSlot(slot).save(provider, item);
                item.putInt("RealCount", this.inventory.getStackInSlot(slot).getCount());
                items.add(item);
            }
        }

        final CompoundTag inventory = new CompoundTag();
        inventory.put("Items", items);
        inventory.putInt("Size", this.inventory.getSlots());
        compound.put("Inventory", inventory);
        
        compound.putBoolean("showName", showName);
    }
    
    @Override
    public void tick() {
    	update();
    	super.tick();
    }
    
    public boolean isShowName() {
		return showName;
	}
}
