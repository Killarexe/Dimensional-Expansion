package net.killarexe.dimensional_expansion.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class SavorleafBlock extends Block{
	public SavorleafBlock() {
		super(
			BlockBehaviour.Properties.of(Material.DIRT)
			.color(MaterialColor.COLOR_BLACK)
			.destroyTime(1)
			.strength(2, 2)
			.friction(0.1f)
			.sound(SoundType.GRASS)
		);
	}
}
