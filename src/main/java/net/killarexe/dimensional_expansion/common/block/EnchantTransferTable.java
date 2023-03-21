package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.common.block.entity.EnchantTransferTableEntity;
import net.killarexe.dimensional_expansion.common.container.EnchantTransferTableContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

public class EnchantTransferTable extends Block implements EntityBlock{

	public EnchantTransferTable() {
		super(BlockBehaviour.Properties
        		.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY)
        		.strength(6, 50)
        		.requiresCorrectToolForDrops()
        		.destroyTime(3)
        		.sound(SoundType.ANVIL)
        );
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new EnchantTransferTableEntity(pPos, pState);
	}
	
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
		return pLevel.isClientSide ? null : (level0, pos, state0, blockEntity) -> ((EnchantTransferTableEntity) blockEntity).tick();
	}
	
	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		if(!pLevel.isClientSide && pLevel.getBlockEntity(pPos) instanceof EnchantTransferTableEntity blockEntity) {
			final MenuProvider provider = new SimpleMenuProvider(EnchantTransferTableContainer.getServerContainer(blockEntity, pPos), EnchantTransferTableEntity.TITLE);
			NetworkHooks.openScreen((ServerPlayer)pPlayer, provider, pPos);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.sidedSuccess(true);
	}
}
