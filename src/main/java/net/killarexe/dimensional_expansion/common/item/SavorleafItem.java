package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

public class SavorleafItem extends ItemNameBlockItem{
	public SavorleafItem() {
		super(DEBlocks.SAVORLEAF_CROP.get(), new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(5).build()));
	}
}
