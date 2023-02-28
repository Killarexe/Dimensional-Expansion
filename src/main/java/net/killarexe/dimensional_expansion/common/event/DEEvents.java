package net.killarexe.dimensional_expansion.common.event;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.*;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class DEEvents {

    @SubscribeEvent
    public static void addVillagerFeatures(VillagerTradesEvent e){
        VillagerFeatures.addTrades(e);
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

    private static class VillagerFeatures {
        public static void addTrades(VillagerTradesEvent e) {
            DEMod.LOGGER.info("Init Dimensional Expansion Villager Trades");
            List<VillagerTrades.ItemListing> tradesLevel5 = e.getTrades().get(5);
            List<VillagerTrades.ItemListing> tradesLevel4 = e.getTrades().get(4);
            List<VillagerTrades.ItemListing> tradesLevel3 = e.getTrades().get(3);
            List<VillagerTrades.ItemListing> tradesLevel2 = e.getTrades().get(2);
            List<VillagerTrades.ItemListing> tradesLevel1 = e.getTrades().get(1);
            if (e.getType() == DEVillagerTypes.FORGER.get()) {
                
            	//TODO: Make forger trades

            } else if (e.getType() == DEVillagerTypes.FARMER.get()) {

            	//TODO: Make farmer trades

            } else if (e.getType() == DEVillagerTypes.MINER.get()) {

                addTrade(tradesLevel1, Items.EMERALD, 1, Items.COAL, 16, 8, 30, 1);
                addTrade(tradesLevel1, Items.EMERALD, 1, Items.CHARCOAL, 16, 8, 30, 1);
                addTrade(tradesLevel1, Items.EMERALD, 8, Items.DIAMOND, 1, 3, 30, 1);
                addTrade(tradesLevel2, Items.EMERALD, 4, DEItems.PALON_MIXED_COAL.get(), 1, 16, 30, 1);
                addTrade(tradesLevel2, Items.EMERALD, 4, DEItems.PALON_NUGGET.get(), 1, 16, 30, 1);
                addTrade(tradesLevel3, Items.EMERALD, 8, DEItems.BASSMITE_MIXED_COAL.get(), 1, 8, 30, 1);
                addTrade(tradesLevel4, Items.EMERALD, 16, DEItems.SIMIX_MIXED_COAL.get(), 1, 4, 30, 1);
                addTrade(tradesLevel4, Items.EMERALD, 8, DEItems.SIMIX_NUGGET.get(), 1, 16, 30, 1);
                addTrade(tradesLevel5, Items.EMERALD, 4, Items.COMPASS, 1, 32, 30, 1);
                addTrade(tradesLevel5, Items.EMERALD, 32, DEItems.EMERTYST_MIXED_COAL.get(), 1, 2, 30, 1);
            }
        }

        private static void addTrade(List<VillagerTrades.ItemListing> trades, Item tradeItem1, int number1, Item tradeItem2, int number2, Item receveItem, int number, int maxTrades, int xp, int priceMult) {
            trades.add(new CustomTrade(new ItemStack(tradeItem1, number1), new ItemStack(tradeItem2, number2), new ItemStack(receveItem, number), maxTrades, xp, priceMult));
        }

        private static void addTrade(List<VillagerTrades.ItemListing> trades, Item tradeItem1, int number1, Item receveItem, int number, int maxTrades, int xp, int priceMult) {
            trades.add(new CustomTrade(new ItemStack(tradeItem1, number1), new ItemStack(receveItem, number), maxTrades, xp, priceMult));
        }

        private static class CustomTrade implements VillagerTrades.ItemListing {
            private final ItemStack tradeItem1;
            private ItemStack tradeItem2;
            private final ItemStack reciveItem;
            private final int maxUses;
            private final int villagerXp;
            private final float priceMultiplier;

            public CustomTrade(ItemStack tradeItem1, ItemStack tradeItem2, ItemStack reciveItem, int maxTrades, int xp, int priceMult) {
                this.tradeItem1 = tradeItem1;
                this.tradeItem2 = tradeItem2;
                this.reciveItem = reciveItem;
                this.maxUses = maxTrades;
                this.villagerXp = xp;
                this.priceMultiplier = priceMult;
            }

            public CustomTrade(ItemStack tradeItem1, ItemStack reciveItem, int maxTrades, int xp, int priceMult) {
                this.tradeItem1 = tradeItem1;
                this.reciveItem = reciveItem;
                this.maxUses = maxTrades;
                this.villagerXp = xp;
                this.priceMultiplier = priceMult;
            }

            @Override
            public MerchantOffer getOffer(Entity p_219693_, RandomSource p_219694_) {
                if (tradeItem2 == null) {
                    return new MerchantOffer(tradeItem1, reciveItem, this.maxUses, this.villagerXp, this.priceMultiplier);
                }
                return new MerchantOffer(tradeItem1, tradeItem2, reciveItem, this.maxUses, this.villagerXp, this.priceMultiplier);
            }
        }
    }
}
