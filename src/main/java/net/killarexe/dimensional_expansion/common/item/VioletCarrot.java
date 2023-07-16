package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

public class VioletCarrot  extends ItemNameBlockItem{
	public VioletCarrot() {
		super(DEBlocks.VIOLET_CARROT_CROP.get(), new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(5).build()));
	}
}
