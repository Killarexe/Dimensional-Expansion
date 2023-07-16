package net.killarexe.dimensional_expansion.common.block;

import org.jetbrains.annotations.Nullable;

import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class OriginDirtBlock extends Block{

	public OriginDirtBlock() {
		this(BlockBehaviour.Properties.copy(Blocks.DIRT_PATH).sound(SoundType.GRAVEL));
	}
	
	protected OriginDirtBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
		if(toolAction == ToolActions.SHOVEL_FLATTEN) {
			return DEBlocks.ORIGIN_DIRT_PATH.get().defaultBlockState();
		}
		if(toolAction == ToolActions.HOE_TILL) {
			return DEBlocks.ORIGIN_FARMLAND.get().defaultBlockState();
		}
		return state;
	}
}
