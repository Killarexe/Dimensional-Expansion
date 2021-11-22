package net.killarexe.dimensional_expansion.uitls;

import java.util.List;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CustomVillagerTrades{

	@SubscribeEvent
	public static void addNewTrade(VillagerTradesEvent e) {
		DEMod.LOGGER.info("Init Dimensional Expansion Villager Trades");
		if(e.getType() == VillagerProfession.WEAPONSMITH) {
			List<VillagerTrades.ItemListing> trades = e.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 2), new ItemStack(DEItems.PALON_SWORD.get()), 3, 10, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 3), new ItemStack(DEItems.PALON_AXE.get()), 3, 10, 1));

		}else if(e.getType() == VillagerProfession.ARMORER) {
			List<VillagerTrades.ItemListing> trades = e.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 5), new ItemStack(DEItems.PALON_HELMET.get()), 3, 10, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 8), new ItemStack(DEItems.PALON_CHESTPLATE.get()), 3, 10, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 7), new ItemStack(DEItems.PALON_LEGGINGS.get()), 3, 10, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 5), new ItemStack(DEItems.PALON_BOOTS.get()), 3, 10, 1));

		}else if(e.getType() == VillagerProfession.TOOLSMITH) {
			List<VillagerTrades.ItemListing> trades = e.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 3), new ItemStack(DEItems.PALON_AXE.get()), 3, 10, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 3), new ItemStack(DEItems.PALON_PICKAXE.get()), 3, 10, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND, 2), new ItemStack(DEItems.PALON_HOE.get()), 3, 10, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.DIAMOND), new ItemStack(DEItems.PALON_SHOVEL.get()), 3, 10, 1));

		}else if(e.getType() == VillagerProfession.CLERIC) {
			List<VillagerTrades.ItemListing> trades = e.getTrades().get(5);
			trades.add(new BasicTrade(new ItemStack(Items.ENDER_PEARL, 16), new ItemStack(Items.ENDER_PEARL, 16),new ItemStack(DEItems.BASSMITE_GEM.get()), 3, 10, 1));
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.DIAMOND), new ItemStack(DEItems.PALON_INGOT.get()), 3, 10, 0));
		}else if(e.getType() == VillagerProfession.BUTCHER){

		}
	}
}
