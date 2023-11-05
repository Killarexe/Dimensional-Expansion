package net.killarexe.dimensional_expansion.common.event.villager;

import java.util.List;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.event.villager.trades.ItemsForEmeralds;
import net.killarexe.dimensional_expansion.init.DEItems;
import net.killarexe.dimensional_expansion.init.DEVillagerTypes;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.village.VillagerTradesEvent;

public class DEVillagerTrades {
	public static void addTrades(VillagerTradesEvent e) {
        DEMod.LOGGER.info("Init Dimensional Expansion Villager Trades");
        
        List<ItemListing> tradesLevel5 = e.getTrades().get(5);
        List<ItemListing> tradesLevel4 = e.getTrades().get(4);
        List<ItemListing> tradesLevel3 = e.getTrades().get(3);
        List<ItemListing> tradesLevel2 = e.getTrades().get(2);
        List<ItemListing> tradesLevel1 = e.getTrades().get(1);
        
        if (e.getType() == DEVillagerTypes.MINER.get()) {

        	tradesLevel1.add(new ItemsForEmeralds(DEItems.RAW_PALON.get(), 2, 1, 24, 10));
        	tradesLevel1.add(new ItemsForEmeralds(Items.DIAMOND, 4, 1, 24, 10));
        	
        	tradesLevel2.add(new ItemsForEmeralds(DEItems.BASSMITE_GEM.get(), 4, 1, 16, 10));
        	tradesLevel2.add(new ItemsForEmeralds(DEItems.PALON_MIXED_COAL.get(), 4, 1, 10));
        	
        	tradesLevel3.add(new ItemsForEmeralds(DEItems.RAW_SIMIX.get(), 8, 1, 12, 10));
        	tradesLevel3.add(new ItemsForEmeralds(DEItems.BASSMITE_MIXED_COAL.get(), 6, 1, 12, 10));
        	
        	tradesLevel4.add(new ItemsForEmeralds(DEItems.SIMIX_MIXED_COAL.get(), 16, 1, 12, 10));
        	
        	tradesLevel5.add(new ItemsForEmeralds(DEItems.EMERTYST_MIXED_COAL.get(), 10, 1, 12, 10));
        }
    }
}
