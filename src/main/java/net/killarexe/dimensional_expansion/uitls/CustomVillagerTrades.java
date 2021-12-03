package net.killarexe.dimensional_expansion.uitls;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.killarexe.dimensional_expansion.core.init.DEVillagerTypes;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class CustomVillagerTrades{

	@SubscribeEvent
	public static void addNewTrade(VillagerTradesEvent e) {
		DEMod.LOGGER.info("Init Dimensional Expansion Villager Trades");
		List<VillagerTrades.ItemListing> tradesLevel5 = e.getTrades().get(5);
		List<VillagerTrades.ItemListing> tradesLevel4 = e.getTrades().get(4);
		List<VillagerTrades.ItemListing> tradesLevel3 = e.getTrades().get(3);
		List<VillagerTrades.ItemListing> tradesLevel2 = e.getTrades().get(2);
		List<VillagerTrades.ItemListing> tradesLevel1 = e.getTrades().get(1);
		if(e.getType() == DEVillagerTypes.END_FORGER.get()){
			addTrade(tradesLevel1, Items.DIAMOND, 1, Items.EMERALD, 32, Items.NETHERITE_INGOT, 1, 1, 10, 1);
			addTrade(tradesLevel1, Items.DIAMOND_SWORD, 1, Items.EMERALD, 32, Items.NETHERITE_SWORD, 1, 1, 10, 1);
			addTrade(tradesLevel1, Items.DIAMOND_PICKAXE, 1, Items.EMERALD, 32, Items.NETHERITE_PICKAXE, 1, 1, 10, 1);
			addTrade(tradesLevel1, Items.DIAMOND_AXE, 1, Items.EMERALD, 32, Items.NETHERITE_AXE, 1, 1, 10, 1);
			addTrade(tradesLevel1, Items.DIAMOND_SHOVEL, 1, Items.EMERALD, 32, Items.NETHERITE_SHOVEL, 1, 1, 10, 1);
			addTrade(tradesLevel1, Items.DIAMOND_HOE, 1, Items.EMERALD, 32, Items.NETHERITE_HOE, 1, 1, 10, 1);
			addTrade(tradesLevel1, Items.DIAMOND_HELMET, 1, Items.EMERALD, 32, Items.NETHERITE_HELMET, 1, 1, 10, 1);
			addTrade(tradesLevel1, Items.DIAMOND_CHESTPLATE, 1, Items.EMERALD, 32, Items.NETHERITE_CHESTPLATE, 1, 1, 10, 1);
			addTrade(tradesLevel1, Items.DIAMOND_LEGGINGS, 1, Items.EMERALD, 32, Items.NETHERITE_LEGGINGS, 1, 1, 10, 1);
			addTrade(tradesLevel1, Items.DIAMOND_BOOTS, 1, Items.EMERALD, 32, Items.NETHERITE_BOOTS, 1, 1, 10, 1);

			addTrade(tradesLevel2, Items.NETHERITE_INGOT, 1, Items.EMERALD, 40, DEItems.PALON_INGOT.get(), 1, 1, 12, 1);
			addTrade(tradesLevel2, Items.NETHERITE_SWORD, 1, Items.EMERALD, 40, DEItems.PALON_SWORD.get(), 1, 1, 12, 1);
			addTrade(tradesLevel2, Items.NETHERITE_PICKAXE, 1, Items.EMERALD, 40, DEItems.PALON_PICKAXE.get(), 1, 1, 12, 1);
			addTrade(tradesLevel2, Items.NETHERITE_AXE, 1, Items.EMERALD, 40, DEItems.PALON_AXE.get(), 1, 1, 12, 1);
			addTrade(tradesLevel2, Items.NETHERITE_SHOVEL, 1, Items.EMERALD, 40, DEItems.PALON_SHOVEL.get(), 1, 1, 12, 1);
			addTrade(tradesLevel2, Items.NETHERITE_HOE, 1, Items.EMERALD, 40, DEItems.PALON_HOE.get(), 1, 1, 12, 1);
			addTrade(tradesLevel2, Items.NETHERITE_HELMET, 1, Items.EMERALD, 40, DEItems.PALON_HELMET.get(), 1, 1, 12, 1);
			addTrade(tradesLevel2, Items.NETHERITE_CHESTPLATE, 1, Items.EMERALD, 40, DEItems.PALON_CHESTPLATE.get(), 1, 1, 12, 1);
			addTrade(tradesLevel2, Items.NETHERITE_LEGGINGS, 1, Items.EMERALD, 40, DEItems.PALON_LEGGINGS.get(), 1, 1, 12, 1);
			addTrade(tradesLevel2, Items.NETHERITE_BOOTS, 1, Items.EMERALD, 40, DEItems.PALON_BOOTS.get(), 1, 1, 12, 1);

			addTrade(tradesLevel3, DEItems.PALON_INGOT.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_GEM.get(), 1, 1, 18, 1);
			addTrade(tradesLevel3, DEItems.PALON_SWORD.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_SWORD.get(), 1, 1, 18, 1);
			addTrade(tradesLevel3, DEItems.PALON_PICKAXE.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_PICKAXE.get(), 1, 1, 18, 1);
			addTrade(tradesLevel3, DEItems.PALON_AXE.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_AXE.get(), 1, 1, 10, 1);
			addTrade(tradesLevel3, DEItems.PALON_SHOVEL.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_SHOVEL.get(), 1, 1, 18, 1);
			addTrade(tradesLevel3, DEItems.PALON_HOE.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_HOE.get(), 1, 1, 10, 1);
			addTrade(tradesLevel3, DEItems.PALON_HELMET.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_HELMET.get(), 1, 1, 18, 1);
			addTrade(tradesLevel3, DEItems.PALON_CHESTPLATE.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_CHESTPLATE.get(), 1, 1, 18, 1);
			addTrade(tradesLevel3, DEItems.PALON_LEGGINGS.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_LEGGINGS.get(), 1, 1, 18, 1);
			addTrade(tradesLevel3, DEItems.PALON_BOOTS.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_BOOTS.get(), 1, 1, 18, 1);

			addTrade(tradesLevel4, DEItems.BASSMITE_GEM.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_INGOT.get(), 1, 1, 22, 1);
			addTrade(tradesLevel4, DEItems.BASSMITE_SWORD.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_SWORD.get(), 1, 1, 22, 1);
			addTrade(tradesLevel4, DEItems.BASSMITE_PICKAXE.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_PICKAXE.get(), 1, 1, 22, 1);
			addTrade(tradesLevel4, DEItems.BASSMITE_AXE.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_AXE.get(), 1, 1, 22, 1);
			addTrade(tradesLevel4, DEItems.BASSMITE_SHOVEL.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_SHOVEL.get(), 1, 1, 22, 1);
			addTrade(tradesLevel4, DEItems.BASSMITE_HOE.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_HOE.get(), 1, 1, 22, 1);
			addTrade(tradesLevel4, DEItems.BASSMITE_HELMET.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_HELMET.get(), 1, 1, 22, 1);
			addTrade(tradesLevel4, DEItems.BASSMITE_CHESTPLATE.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_CHESTPLATE.get(), 1, 1, 22, 1);
			addTrade(tradesLevel4, DEItems.BASSMITE_LEGGINGS.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_LEGGINGS.get(), 1, 1, 22, 1);
			addTrade(tradesLevel4, DEItems.BASSMITE_BOOTS.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_BOOTS.get(), 1, 1, 22, 1);

			addTrade(tradesLevel5, DEItems.SIMIX_INGOT.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_GEM.get(), 1, 1, 30, 1);
			addTrade(tradesLevel5, DEItems.SIMIX_SWORD.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_SWORD.get(), 1, 1, 30, 1);
			addTrade(tradesLevel5, DEItems.SIMIX_PICKAXE.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_PICKAXE.get(), 1, 1, 30, 1);
			addTrade(tradesLevel5, DEItems.SIMIX_AXE.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_AXE.get(), 1, 1, 30, 1);
			addTrade(tradesLevel5, DEItems.SIMIX_SHOVEL.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_SHOVEL.get(), 1, 1, 30, 1);
			addTrade(tradesLevel5, DEItems.SIMIX_HOE.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_HOE.get(), 1, 1, 30, 1);
			addTrade(tradesLevel5, DEItems.SIMIX_HELMET.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_HELMET.get(), 1, 1, 30, 1);
			addTrade(tradesLevel5, DEItems.SIMIX_CHESTPLATE.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_CHESTPLATE.get(), 1, 1, 30, 1);
			addTrade(tradesLevel5, DEItems.SIMIX_LEGGINGS.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_LEGGINGS.get(), 1, 1, 30, 1);
			addTrade(tradesLevel5, DEItems.SIMIX_BOOTS.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_BOOTS.get(), 1, 1, 30, 1);

		}
	}

	private static void addTrade(List<VillagerTrades.ItemListing> trades, Item tradeItem1, int number1, Item tradeItem2, int number2, Item receveItem, int number, int maxTrades, int xp, int priceMult){
		trades.add(new BasicTrade(new ItemStack(tradeItem1, number1), new ItemStack(tradeItem2, number2), new ItemStack(receveItem, number), maxTrades, xp, priceMult));
	}

	private static void addTrade(List<VillagerTrades.ItemListing> trades, Item tradeItem1, int number1, Item receveItem, int number, int maxTrades, int xp, int priceMult){
		trades.add(new BasicTrade(new ItemStack(tradeItem1, number1), new ItemStack(receveItem, number), maxTrades, xp, priceMult));
	}
}
