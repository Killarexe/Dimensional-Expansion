package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.init.DEItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class PurpleBerryBush extends SweetBerryBushBlock{

	public PurpleBerryBush() {
		super(Properties.copy(Blocks.SWEET_BERRY_BUSH));
	}
	
	@Override
	public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
		return new ItemStack(DEItems.PURPLE_BERRY.get());
	}
	
	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		int i = pState.getValue(AGE);
	      boolean flag = i == 3;
	      if (!flag && pPlayer.getItemInHand(pHand).is(Items.BONE_MEAL)) {
	         return InteractionResult.PASS;
	      } else if (i > 1) {
	         int j = 1 + pLevel.random.nextInt(2);
	         popResource(pLevel, pPos, new ItemStack(DEItems.PURPLE_BERRY.get(), j + (flag ? 1 : 0)));
	         pLevel.playSound((Player)null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);
	         BlockState blockstate = pState.setValue(AGE, Integer.valueOf(1));
	         pLevel.setBlock(pPos, blockstate, 2);
	         pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, blockstate));
	         return InteractionResult.sidedSuccess(pLevel.isClientSide);
	      } else {
	         return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
	      }
	}
	
	@Override
	public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
		if (pEntity instanceof LivingEntity && pEntity.getType() != EntityType.FOX && pEntity.getType() != EntityType.BEE) {
	         pEntity.makeStuckInBlock(pState, new Vec3((double)0.8F, 0.75D, (double)0.8F));
	         if (!pLevel.isClientSide && pState.getValue(AGE) > 0 && (pEntity.xOld != pEntity.getX() || pEntity.zOld != pEntity.getZ())) {
	            double d0 = Math.abs(pEntity.getX() - pEntity.xOld);
	            double d1 = Math.abs(pEntity.getZ() - pEntity.zOld);
	            if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
	               pEntity.hurt(pLevel.damageSources().sweetBerryBush(), 1.0F);
	            }
	         }
	      }
	}

}
