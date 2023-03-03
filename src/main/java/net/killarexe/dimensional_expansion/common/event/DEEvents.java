package net.killarexe.dimensional_expansion.common.event;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.Event.Result;
public class DEEvents {
	
	public static void addTrades(VillagerTradesEvent e) {
        DEMod.LOGGER.info("Init Dimensional Expansion Villager Trades");
        
        if (e.getType() == DEVillagerTypes.FORGER.get()) {
            
        	//TODO: Make forger trades

        } else if (e.getType() == DEVillagerTypes.FARMER.get()) {

        	//TODO: Make farmer trades

        } else if (e.getType() == DEVillagerTypes.MINER.get()) {

            //TODO: Make trades for miner
        }
    }
    
    public static void diggingEvent(BlockEvent.BreakEvent e){
    	if(EnchantmentHelper.getEnchantmentLevel(DEEnchantments.SMELT.get(), e.getPlayer()) > 0 && e != null && e.isCancelable() && e.getResult() != Result.DENY && !e.getPlayer().isCreative()) {
    		e.setCanceled(true);
    		BlockPos pos = e.getPos();
    		Level level = e.getPlayer().getLevel();
    		ItemStack item = new ItemStack(e.getState().getBlock());
    		if(level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(new ItemStack(e.getState().getBlock())), level).isPresent()) {
    			item = level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(new ItemStack(e.getState().getBlock())), level).get().getResultItem();
    		}
    		if(EnchantmentHelper.getEnchantmentLevel(DEEnchantments.SMELT.get(), e.getPlayer()) > 1 && level.getRecipeManager().getRecipeFor(RecipeType.BLASTING, new SimpleContainer(new ItemStack(e.getState().getBlock())), level).isPresent()) {
    			item = level.getRecipeManager().getRecipeFor(RecipeType.BLASTING, new SimpleContainer(new ItemStack(e.getState().getBlock())), level).get().getResultItem();
    		}
    		level.destroyBlock(e.getPos(), false);
    		level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), item));
    	}
    }
}
