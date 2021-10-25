package net.killarexe.dimensional_expansion.uitls;

import java.util.List;

import net.killarexe.dimensional_expansion.core.init.DimensionalExpansionItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CustomVillagerTrades {

	@SubscribeEvent
	public void addNewTrade(VillagerTradesEvent e) {
		if(e.getType() == VillagerProfession.WEAPONSMITH) {
			List<VillagerTrades.ItemListing> trades = e.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 2), new ItemStack(DimensionalExpansionItems.PALON_SWORD.get()), 3, 0, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 3), new ItemStack(DimensionalExpansionItems.PALON_AXE.get()), 3, 0, 1));

		}else if(e.getType() == VillagerProfession.ARMORER) {
			List<VillagerTrades.ItemListing> trades = e.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 5), new ItemStack(DimensionalExpansionItems.PALON_HELMET.get()), 3, 0, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 8), new ItemStack(DimensionalExpansionItems.PALON_CHESTPLATE.get()), 3, 0, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 7), new ItemStack(DimensionalExpansionItems.PALON_LEGGINGS.get()), 3, 0, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 5), new ItemStack(DimensionalExpansionItems.PALON_BOOTS.get()), 3, 0, 1));

		}else if(e.getType() == VillagerProfession.TOOLSMITH) {
			List<VillagerTrades.ItemListing> trades = e.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 3), new ItemStack(DimensionalExpansionItems.PALON_AXE.get()), 3, 0, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 3), new ItemStack(DimensionalExpansionItems.PALON_PICKAXE.get()), 3, 0, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 2), new ItemStack(DimensionalExpansionItems.PALON_HOE.get()), 3, 0, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND), new ItemStack(DimensionalExpansionItems.PALON_SHOVEL.get()), 3, 0, 1));

		}else if(e.getType() == VillagerProfession.CLERIC) {
			List<VillagerTrades.ItemListing> trades = e.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(Items.ENDER_PEARL, 16), new ItemStack(Items.ENDER_PEARL, 16),new ItemStack(DimensionalExpansionItems.BASSMITE_GEM.get()), 3, 0, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.DIAMOND), new ItemStack(DimensionalExpansionItems.PALON_INGOT.get()), 3, 0, 0));
		}
	}
}
