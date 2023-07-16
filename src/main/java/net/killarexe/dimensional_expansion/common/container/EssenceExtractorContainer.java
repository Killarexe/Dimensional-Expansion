package net.killarexe.dimensional_expansion.common.container;

import net.killarexe.dimensional_expansion.common.block.entity.EssenceExtractorBlockEntity;
import net.killarexe.dimensional_expansion.common.container.slot.ResultSlot;
import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.killarexe.dimensional_expansion.init.DEMenuTypes;
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
        super(DEMenuTypes.ESSENCE_EXTRACTOR_MENU_TYPE.get(), id);
        this.containerAccess = ContainerLevelAccess.create(playerInv.player.level, pos);
        this.data = data;

        final int slotSizePlus2 = 18, startX = 8, startY = 86, hotbarY = 144;

        addSlot(new SlotItemHandler(slots, 0, 44, 37));
        addSlot(new ResultSlot(slots, 1, 116, 37));

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
    
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 2;  // must match TileEntityInventoryBasic.NUMBER_OF_SLOTS
    
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
    	Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(player, sourceStack);
        return copyOfSourceStack;
    }
}
