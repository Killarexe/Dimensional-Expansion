package net.killarexe.dimensional_expansion.common.event;

import java.util.List;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.killarexe.dimensional_expansion.common.event.DEVillagerTrades.*;

public class DEEvents {
	
	public static void addTrades(VillagerTradesEvent e) {
        DEMod.LOGGER.info("Init Dimensional Expansion Villager Trades");
        
        List<ItemListing> tradesLevel5 = e.getTrades().get(5);
        List<ItemListing> tradesLevel4 = e.getTrades().get(4);
        List<ItemListing> tradesLevel3 = e.getTrades().get(3);
        List<ItemListing> tradesLevel2 = e.getTrades().get(2);
        List<ItemListing> tradesLevel1 = e.getTrades().get(1);
        
        if (e.getType() == DEVillagerTypes.FORGER.get()) {
            
        	tradesLevel1.add(new EnchantedItemForEmeralds(Items.DIAMOND_AXE, 16, 5, 10));
        	tradesLevel1.add(new EnchantedItemForEmeralds(Items.DIAMOND_PICKAXE, 16, 5, 10));
        	tradesLevel1.add(new EnchantedItemForEmeralds(Items.DIAMOND_SWORD, 16, 5, 10));
        	
        	tradesLevel2.add(new EnchantedItemForEmeralds(Items.NETHERITE_AXE, 24, 4, 15));
        	tradesLevel2.add(new EnchantedItemForEmeralds(Items.NETHERITE_PICKAXE, 24, 4, 15));
        	tradesLevel2.add(new EnchantedItemForEmeralds(Items.NETHERITE_SWORD, 24, 4, 15));
        	
        	tradesLevel3.add(new EnchantedItemForEmeralds(DEItems.BASSMITE_AXE.get(), 32, 3, 20));
        	tradesLevel3.add(new EnchantedItemForEmeralds(DEItems.BASSMITE_PICKAXE.get(), 32, 3, 20));
        	tradesLevel3.add(new EnchantedItemForEmeralds(DEItems.BASSMITE_SWORD.get(), 32, 3, 20));
        	
        	tradesLevel4.add(new EnchantedItemForEmeralds(DEItems.EMERTYST_AXE.get(), 48, 2, 25));
        	tradesLevel4.add(new EnchantedItemForEmeralds(DEItems.EMERTYST_PICKAXE.get(), 48, 2, 25));
        	tradesLevel4.add(new EnchantedItemForEmeralds(DEItems.EMERTYST_SWORD.get(), 48, 2, 25));
        	
        	tradesLevel5.add(new EnchantedItemForEmeralds(DEItems.EMERTYST_HELMET.get(), 64, 1, 30));
        	tradesLevel5.add(new EnchantedItemForEmeralds(DEItems.EMERTYST_CHESTPLATE.get(), 64, 1, 30));
        	tradesLevel5.add(new EnchantedItemForEmeralds(DEItems.EMERTYST_LEGGINGS.get(), 64, 1, 30));
        	tradesLevel5.add(new EnchantedItemForEmeralds(DEItems.EMERTYST_BOOTS.get(), 64, 1, 30));

        } else if (e.getType() == DEVillagerTypes.FARMER.get()) {

        	tradesLevel1.add(new EmeraldForItems(DEItems.VIOLET_CARROT.get(), 2, 64, 10));
        	
        	tradesLevel2.add(new EmeraldForItems(DEItems.SAVORLEAF.get(), 4, 48, 15));
        	
        	tradesLevel3.add(new EmeraldForItems(DEBlocks.SAVORLEAF_BLOCK.get(), 8, 32, 20));
        	
        	tradesLevel4.add(new ItemsForEmeralds(DEItems.PEARL_ESSENCE.get(), 16, 24, 25));
        	
        	tradesLevel5.add(new ItemsForEmeralds(DEItems.EMERTYST_HOE.get(), 32, 1, 30));

        } else if (e.getType() == DEVillagerTypes.MINER.get()) {

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
    
    public static void diggingEvent(BlockEvent.BreakEvent e){
    	if(EnchantmentHelper.getEnchantmentLevel(DEEnchantments.SMELT.get(), e.getPlayer()) > 0 && e != null && e.isCancelable() && e.getResult() != Result.DENY && !e.getPlayer().isCreative()) {
    		e.setCanceled(true);
    		BlockPos pos = e.getPos();
    		Level level = e.getPlayer().getLevel();
    		ItemStack item = new ItemStack(e.getState().getBlock());
    		if(level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(new ItemStack(e.getState().getBlock())), level).isPresent()) {
    			item = level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(new ItemStack(e.getState().getBlock())), level).map(recipe -> recipe.getResultItem(level.registryAccess()).copy()).orElse(item);
    		}
    		if(EnchantmentHelper.getEnchantmentLevel(DEEnchantments.SMELT.get(), e.getPlayer()) > 1 && level.getRecipeManager().getRecipeFor(RecipeType.BLASTING, new SimpleContainer(new ItemStack(e.getState().getBlock())), level).isPresent()) {
    			item = level.getRecipeManager().getRecipeFor(RecipeType.BLASTING, new SimpleContainer(new ItemStack(e.getState().getBlock())), level).map(recipe -> recipe.getResultItem(level.registryAccess()).copy()).orElse(item);
    		}
    		level.destroyBlock(e.getPos(), false);
    		level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), item));
    	}
    }
}
