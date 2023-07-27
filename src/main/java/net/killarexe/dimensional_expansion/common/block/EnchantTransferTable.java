package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.common.block.entity.EnchantTransferTableEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EnchantTransferTable extends Block implements EntityBlock{

	private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);
	
	public EnchantTransferTable() {
		super(BlockBehaviour.Properties
        		.of()
        		.strength(4, 20)
        		.requiresCorrectToolForDrops()
        		.destroyTime(3)
        		.sound(SoundType.ANVIL)
        		.noOcclusion()
        );
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new EnchantTransferTableEntity(pPos, pState);
	}
	
	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE;
	}
	
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
		return pLevel.isClientSide ? null : (level0, pos, state0, blockEntity) -> ((EnchantTransferTableEntity) blockEntity).tick();
	}
	
	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		if(!pLevel.isClientSide && pLevel.getBlockEntity(pPos) instanceof EnchantTransferTableEntity blockEntity) {
			if(pPlayer.isCrouching()) {
				blockEntity.prependItem(pPlayer);
			}else {
				if(!blockEntity.getItemInSlot(1).isEmpty()) {
					blockEntity.transferEnchant(pPlayer);
				}else {
					blockEntity.appendItem(pPlayer, pPlayer.getItemInHand(pHand));
				}
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.sidedSuccess(true);
	}
}
