package net.killarexe.dimensional_expansion.common.block.entity;

import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class InventoryBlockEntity extends BlockEntity{

    public final int size;
    protected int timer;
    protected boolean requiresUpdate;

    public final ItemStackHandler inventory;
    protected Optional<Lazy<ItemStackHandler>> handler;

    public InventoryBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int size) {
        super(type, pos, state);
        this.size = size;
        this.inventory = createInventory();
        this.handler = Optional.of(Lazy.of(() -> this.inventory));
    }

    public ItemStack extractItem(int slot) {
        final int count = getItemInSlot(slot).getCount();
        this.requiresUpdate = true;
        return this.handler.map(inv -> inv.get().extractItem(slot, count, false)).orElse(ItemStack.EMPTY);
    }

    public ItemStack getItemInSlot(int slot) {
        this.requiresUpdate = true;
        return this.handler.map(inv -> inv.get().getStackInSlot(slot)).orElse(ItemStack.EMPTY);
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        CompoundTag tag = serializeAttachments(pRegistries);
        if (tag != null) {
            return tag;
        }
        return new CompoundTag();
    }

    @Override
    public void handleUpdateTag(CompoundTag tag, HolderLookup.Provider lookupProvider) {
        super.handleUpdateTag(tag, lookupProvider);
        loadAdditional(tag, lookupProvider);
    }

    public ItemStack insertItem(int slot, ItemStack stack) {
        final ItemStack copy = stack.copy();
        stack.shrink(copy.getCount());
        this.requiresUpdate = true;
        return this.handler.map(inv -> inv.get().insertItem(slot, copy, false)).orElse(ItemStack.EMPTY);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        this.inventory.deserializeNBT(pRegistries, pTag.getCompound("Inventory"));
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider lookupProvider) {
        super.onDataPacket(net, pkt, lookupProvider);
        handleUpdateTag(pkt.getTag(), lookupProvider);
    }

    public void tick() {
        this.timer++;
        if (this.requiresUpdate && this.level != null) {
            update();
            this.requiresUpdate = false;
        }
    }

    public void update() {
        requestModelDataUpdate();
        if (level != null) {
            BlockState state = level.getBlockState(worldPosition);
            level.setBlockAndUpdate(worldPosition, state);
            level.sendBlockUpdated(worldPosition, state, state, 3);
        }
        setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);
        pTag.put("Inventory", this.inventory.serializeNBT(pRegistries));
    }

    public int getLightLevel(){
        return LightTexture.pack(
                this.getLevel().getBrightness(LightLayer.BLOCK, this.getBlockPos()),
                this.getLevel().getBrightness(LightLayer.SKY, this.getBlockPos())
        );
    }

    private ItemStackHandler createInventory() {
        return new ItemStackHandler(this.size) {
            @Override
            public ItemStack extractItem(int slot, int amount, boolean simulate) {
                InventoryBlockEntity.this.update();
                return super.extractItem(slot, amount, simulate);
            }

            @Override
            public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
                InventoryBlockEntity.this.update();
                return super.insertItem(slot, stack, simulate);
            }
        };
    }
}
