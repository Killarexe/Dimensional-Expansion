package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.common.block.entity.DisplayBlockEntity;
import net.killarexe.dimensional_expansion.init.DEBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;

public class DisplayBlock extends Block implements EntityBlock {

    public DisplayBlock() {
        super(Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.COLOR_YELLOW));
    }

    @Override
    public void attack(BlockState state, Level level, BlockPos pos, Player player) {
        if (!level.isClientSide && level.getBlockEntity(pos) instanceof final DisplayBlockEntity entity) {
            entity.prependItem(player);
        }
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> beType) {
        return level.isClientSide ? null : (level0, pos, state0, blockEntity) -> ((DisplayBlockEntity) blockEntity).tick();
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return DEBlockEntityTypes.DISPLAY_BLOCK.get().create(pos, state);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide && level.getBlockEntity(pos) instanceof final DisplayBlockEntity entity) {
            entity.appendItem(player.getItemInHand(hand));
        }
        return ItemInteractionResult.SUCCESS;
    }
}
