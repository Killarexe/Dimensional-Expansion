package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.block.OriginPortalBlock;
import net.killarexe.dimensional_expansion.core.init.DEItemGroups;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class OriginPortalKey extends Item{

	public OriginPortalKey() {
		super(new Item.Properties().tab(DEItemGroups.TOOLS).durability(64));
	}
	
	@Override
	public InteractionResult useOn(UseOnContext pContext) {
		Player player = pContext.getPlayer();
		BlockPos pos = pContext.getClickedPos().relative(pContext.getClickedFace());
		ItemStack item = pContext.getItemInHand();
		Level level = pContext.getLevel();
		if(!player.mayUseItemAt(pos, pContext.getClickedFace(), item)) {
			DEMod.LOGGER.warn("Failed to create portal");
			return InteractionResult.FAIL;
		}
		if(level.isEmptyBlock(pos)) {
			OriginPortalBlock.portalSpawn(level, pos);
			item.hurtAndBreak(1, player, c -> c.broadcastBreakEvent(pContext.getHand()));
			return InteractionResult.SUCCESS;
		}
		DEMod.LOGGER.warn("Failed to create portal");
		return InteractionResult.FAIL;
	}
}
