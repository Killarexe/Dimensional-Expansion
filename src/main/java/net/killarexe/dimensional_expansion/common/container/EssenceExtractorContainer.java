package net.killarexe.dimensional_expansion.common.container;

import net.killarexe.dimensional_expansion.common.block.entity.EssenceExtractorBlockEntity;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.killarexe.dimensional_expansion.core.init.DEContainers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class EssenceExtractorContainer extends AbstractContainerMenu {
    private final ContainerLevelAccess containerAccess;
    public final ContainerData data;

    // Client Constructor
    public EssenceExtractorContainer(int id, Inventory playerInv) {
        this(id, playerInv, new ItemStackHandler(2), BlockPos.ZERO, new SimpleContainerData(2));
    }

    // Server constructor
    private EssenceExtractorContainer(int id, Inventory playerInv, IItemHandler slots, BlockPos pos, ContainerData data) {
        super(DEContainers.ESSENCE_EXTRACTOR_CONTAINER.get(), id);
        this.containerAccess = ContainerLevelAccess.create(playerInv.player.level, pos);
        this.data = data;

        final int slotSizePlus2 = 18, startX = 8, startY = 86, hotbarY = 144;

        addSlot(new SlotItemHandler(slots, 0, 176/2+16, 37));
        addSlot(new SlotItemHandler(slots, 1, 176/2-16, 37));


        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(playerInv, 9 + row * 9 + column, startX + column * slotSizePlus2,
                        startY + row * slotSizePlus2));
            }
        }

        for (int column = 0; column < 9; column++) {
            addSlot(new Slot(playerInv, column, startX + column * slotSizePlus2, hotbarY));
        }

        addDataSlots(data);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        var retStack = ItemStack.EMPTY;
        final Slot slot = getSlot(index);
        if (slot.hasItem()) {
            final ItemStack item = slot.getItem();
            retStack = item.copy();
            if (index < 1) {
                if (!moveItemStackTo(item, 1, this.slots.size(), true))
                    return ItemStack.EMPTY;
            } else if (!moveItemStackTo(item, 0, 1, false))
                return ItemStack.EMPTY;

            if (item.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return retStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.containerAccess, player, DEBlocks.ESSENCE_EXTRACTOR.get());
    }

    public static MenuConstructor getServerContainer(EssenceExtractorBlockEntity be, BlockPos pos) {
        return (id, playerInv, player) -> new EssenceExtractorContainer(id, playerInv, be.inventory, pos, new EssenceExtractorContainerData(be, 2));
    }

    public static class EssenceExtractorContainerData extends SimpleContainerData{

        private final EssenceExtractorBlockEntity be;

        public EssenceExtractorContainerData(EssenceExtractorBlockEntity be, int amount) {
            super(amount);
            this.be = be;
        }

        @Override
        public int get(int key) {
            return switch (key) {
                case 0 -> this.be.getItemInSlot(0).getCount();
                case 1 -> this.be.getItemInSlot(1).getCount();
                default -> throw new UnsupportedOperationException(
                        "There is no value corresponding to key: '" + key + "' in: '" + this.be + "'");
            };
        }

        @Override
        public void set(int key, int value) {
            ItemStack stack;
            switch (key) {
                case 0:
                    stack = this.be.getItemInSlot(0);
                    if (value > 0 && value < stack.getMaxStackSize()) {
                        stack.setCount(value);
                    } else if (value <= 0) {
                        stack = ItemStack.EMPTY;
                    } else if (value > stack.getMaxStackSize()) {
                        stack.setCount(stack.getMaxStackSize());
                    }

                    this.be.inventory.setStackInSlot(0, stack);
                    break;
                case 1:
                    stack = this.be.getItemInSlot(1);
                    if (value > 1 && value < stack.getMaxStackSize()) {
                        stack.setCount(value);
                    } else if (value <= 1) {
                        stack = ItemStack.EMPTY;
                    } else if (value > stack.getMaxStackSize()) {
                        stack.setCount(stack.getMaxStackSize());
                    }

                    this.be.inventory.setStackInSlot(1, stack);
                    break;
                default:
                    throw new UnsupportedOperationException(
                            "There is no value corresponding to key: '" + key + "' in: '" + this.be + "'");
            }
        }
    }
}
