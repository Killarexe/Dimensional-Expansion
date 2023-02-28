package net.killarexe.dimensional_expansion.common.container;

import net.killarexe.dimensional_expansion.common.block.entity.EnchantTransferTableEntity;
import net.killarexe.dimensional_expansion.common.container.slot.ResultSlot;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.killarexe.dimensional_expansion.core.init.DEMenuTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuConstructor;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class EnchantTransferTableContainer extends AbstractContainerMenu{

	public static final int SLOTS = 3;
	
	private final ContainerLevelAccess containerAccess;
	public final ContainerData data;
	
	public EnchantTransferTableContainer(int id, Inventory playerInv) {
		this(id, playerInv, new ItemStackHandler(SLOTS), BlockPos.ZERO, new SimpleContainerData(SLOTS));
	}
	
	private EnchantTransferTableContainer(int id, Inventory playerInv, IItemHandler slots, BlockPos pos, ContainerData data) {
		super(DEMenuTypes.ENCHANT_TRANSFER_TABLE_MENU_TYPE.get(), id);
		this.containerAccess = ContainerLevelAccess.create(playerInv.player.getLevel(), pos);
		this.data = data;
		
		final int slotSizePlus2 = 18, startX = 8, startY = 86, hotbarY = 144;

        addSlot(new SlotItemHandler(slots, 0, 44, 37));
        addSlot(new SlotItemHandler(slots, 1, 89, 37));
        addSlot(new ResultSlot(slots, 2, 116, 37));

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
		return stillValid(containerAccess, player, DEBlocks.ENCHANT_TRANSFER_TABLE.get());
	}
	
	public static MenuConstructor getServerContainer(EnchantTransferTableEntity be, BlockPos pos) {
        return (id, playerInv, player) -> new EnchantTransferTableContainer(id, playerInv, be.inventory, pos, new SimpleContainerData(SLOTS));
    }

	private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 3;  // must match TileEntityInventoryBasic.NUMBER_OF_SLOTS
    
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
