package net.killarexe.dimensional_expansion.common.blockentity;

import net.killarexe.dimensional_expansion.common.container.ImplementedInventory;
import net.killarexe.dimensional_expansion.core.init.DEBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class EssenceExtractorBlockEntity extends BlockEntity implements ImplementedInventory {

    public EssenceExtractorBlockEntity(BlockPos pos, BlockState state) {
        super(DEBlockEntities.ESSENCE_EXTRACTOR_BLOCK_ENTITY, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return null;
    }

    @Override
    public int size() {
        return ImplementedInventory.super.size();
    }

    @Override
    public boolean isEmpty() {
        return ImplementedInventory.super.isEmpty();
    }

    @Override
    public ItemStack getStack(int slot) {
        return ImplementedInventory.super.getStack(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int count) {
        return ImplementedInventory.super.removeStack(slot, count);
    }

    @Override
    public ItemStack removeStack(int slot) {
        return ImplementedInventory.super.removeStack(slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        ImplementedInventory.super.setStack(slot, stack);
    }

    @Override
    public int getMaxCountPerStack() {
        return ImplementedInventory.super.getMaxCountPerStack();
    }

    @Override
    public void clear() {
        ImplementedInventory.super.clear();
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return ImplementedInventory.super.canPlayerUse(player);
    }

    @Override
    public void onOpen(PlayerEntity player) {
        ImplementedInventory.super.onOpen(player);
    }

    @Override
    public void onClose(PlayerEntity player) {
        ImplementedInventory.super.onClose(player);
    }

    @Override
    public boolean isValid(int slot, ItemStack stack) {
        return ImplementedInventory.super.isValid(slot, stack);
    }

    @Override
    public int count(Item item) {
        return ImplementedInventory.super.count(item);
    }

    @Override
    public boolean containsAny(Set<Item> items) {
        return ImplementedInventory.super.containsAny(items);
    }
}
