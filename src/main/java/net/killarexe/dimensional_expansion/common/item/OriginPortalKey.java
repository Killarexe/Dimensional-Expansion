package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.common.block.OriginPortalBlock;
import net.killarexe.dimensional_expansion.common.world.portal.OriginPortalForcer;
import net.killarexe.dimensional_expansion.common.world.portal.OriginPortalShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class OriginPortalKey extends Item{

	public OriginPortalKey() {
		super(new Item.Properties().durability(64));
	}
	
	@Override
	@NotNull
	public InteractionResult useOn(UseOnContext pContext) {
		Player player = pContext.getPlayer();
		BlockPos pos = pContext.getClickedPos().relative(pContext.getClickedFace());
		ItemStack item = pContext.getItemInHand();
		Level level = pContext.getLevel();
		if (!player.mayUseItemAt(pos, pContext.getClickedFace(), item)) {
			return InteractionResult.FAIL;
		}
		if (level.isEmptyBlock(pos)) {
			Optional<OriginPortalShape> shape = OriginPortalShape.findEmptyPortalShape(level, pos, Direction.Axis.X);
			if(shape.isPresent()) {
				shape.get().createPortalBlocks();
				item.hurtAndBreak(1, player, item.getEquipmentSlot());
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.FAIL;
	}
}
