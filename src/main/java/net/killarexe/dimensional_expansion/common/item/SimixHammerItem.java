package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.core.init.DEItemGroups;
import net.minecraft.world.item.Item;

public class SimixHammerItem extends Item{

	public SimixHammerItem() {
		super(new Item.Properties().tab(DEItemGroups.TOOLS).durability(16).fireResistant());
	}
	
}
