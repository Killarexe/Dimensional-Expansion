package net.killarexe.dimensional_expansion.common.event;

import java.util.Map;

import javax.annotation.Nullable;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerDataHolder;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class DEVillagerTrades {
	public static class EmeraldForItems implements VillagerTrades.ItemListing {
	      private final Item item;
	      private final int cost;
	      private final int maxUses;
	      private final int villagerXp;
	      private final float priceMultiplier;

	      public EmeraldForItems(ItemLike pItem, int pCost, int pMaxUses, int pVillagerXp) {
	         this.item = pItem.asItem();
	         this.cost = pCost;
	         this.maxUses = pMaxUses;
	         this.villagerXp = pVillagerXp;
	         this.priceMultiplier = 0.05F;
	      }

	      public MerchantOffer getOffer(Entity pTrader, RandomSource pRandom) {
	         ItemStack itemstack = new ItemStack(this.item, this.cost);
	         return new MerchantOffer(itemstack, new ItemStack(Items.EMERALD), this.maxUses, this.villagerXp, this.priceMultiplier);
	      }
	   }

	public static class EmeraldsForVillagerTypeItem implements VillagerTrades.ItemListing {
	      private final Map<VillagerType, Item> trades;
	      private final int cost;
	      private final int maxUses;
	      private final int villagerXp;

	      public EmeraldsForVillagerTypeItem(int pCost, int pMaxUses, int pVillagerXp, Map<VillagerType, Item> pTrades) {
	         BuiltInRegistries.VILLAGER_TYPE.stream().filter((key) -> {
	            return !pTrades.containsKey(key);
	         }).findAny().ifPresent((p_258962_) -> {
	            throw new IllegalStateException("Missing trade for villager type: " + BuiltInRegistries.VILLAGER_TYPE.getKey(p_258962_));
	         });
	         this.trades = pTrades;
	         this.cost = pCost;
	         this.maxUses = pMaxUses;
	         this.villagerXp = pVillagerXp;
	      }

	      @Nullable
	      public MerchantOffer getOffer(Entity pTrader, RandomSource pRandom) {
	         if (pTrader instanceof VillagerDataHolder) {
	            ItemStack itemstack = new ItemStack(this.trades.get(((VillagerDataHolder)pTrader).getVillagerData().getType()), this.cost);
	            return new MerchantOffer(itemstack, new ItemStack(Items.EMERALD), this.maxUses, this.villagerXp, 0.05F);
	         } else {
	            return null;
	         }
	      }
	   }
	
	public static class ItemsAndEmeraldsToItems implements VillagerTrades.ItemListing {
	      private final ItemStack fromItem;
	      private final int fromCount;
	      private final int emeraldCost;
	      private final ItemStack toItem;
	      private final int toCount;
	      private final int maxUses;
	      private final int villagerXp;
	      private final float priceMultiplier;

	      public ItemsAndEmeraldsToItems(ItemLike pFromItem, int pFromCount, Item pToItem, int pToCount, int pMaxUses, int pVillagerXp) {
	         this(pFromItem, pFromCount, 1, pToItem, pToCount, pMaxUses, pVillagerXp);
	      }

	      public ItemsAndEmeraldsToItems(ItemLike pFromItem, int pFromCount, int pEmeraldCost, Item pToItem, int pToCount, int pMaxUses, int pVillagerXp) {
	         this.fromItem = new ItemStack(pFromItem);
	         this.fromCount = pFromCount;
	         this.emeraldCost = pEmeraldCost;
	         this.toItem = new ItemStack(pToItem);
	         this.toCount = pToCount;
	         this.maxUses = pMaxUses;
	         this.villagerXp = pVillagerXp;
	         this.priceMultiplier = 0.05F;
	      }

	      @Nullable
	      public MerchantOffer getOffer(Entity pTrader, RandomSource pRandom) {
	         return new MerchantOffer(new ItemStack(Items.EMERALD, this.emeraldCost), new ItemStack(this.fromItem.getItem(), this.fromCount), new ItemStack(this.toItem.getItem(), this.toCount), this.maxUses, this.villagerXp, this.priceMultiplier);
	      }
	   }

	   public static class ItemsForEmeralds implements VillagerTrades.ItemListing {
	      private final ItemStack itemStack;
	      private final int emeraldCost;
	      private final int numberOfItems;
	      private final int maxUses;
	      private final int villagerXp;
	      private final float priceMultiplier;

	      public ItemsForEmeralds(Block pBlock, int pEmeraldCost, int pNumberOfItems, int pMaxUses, int pVillagerXp) {
	         this(new ItemStack(pBlock), pEmeraldCost, pNumberOfItems, pMaxUses, pVillagerXp);
	      }

	      public ItemsForEmeralds(Item pItem, int pEmeraldCost, int pNumberOfItems, int pVillagerXp) {
	         this(new ItemStack(pItem), pEmeraldCost, pNumberOfItems, 12, pVillagerXp);
	      }

	      public ItemsForEmeralds(Item pItem, int pEmeraldCost, int pNumberOfItems, int pMaxUses, int pVillagerXp) {
	         this(new ItemStack(pItem), pEmeraldCost, pNumberOfItems, pMaxUses, pVillagerXp);
	      }

	      public ItemsForEmeralds(ItemStack pItemStack, int pEmeraldCost, int pNumberOfItems, int pMaxUses, int pVillagerXp) {
	         this(pItemStack, pEmeraldCost, pNumberOfItems, pMaxUses, pVillagerXp, 0.05F);
	      }

	      public ItemsForEmeralds(ItemStack pItemStack, int pEmeraldCost, int pNumberOfItems, int pMaxUses, int pVillagerXp, float pPriceMultiplier) {
	         this.itemStack = pItemStack;
	         this.emeraldCost = pEmeraldCost;
	         this.numberOfItems = pNumberOfItems;
	         this.maxUses = pMaxUses;
	         this.villagerXp = pVillagerXp;
	         this.priceMultiplier = pPriceMultiplier;
	      }

	      public MerchantOffer getOffer(Entity pTrader, RandomSource pRandom) {
	         return new MerchantOffer(new ItemStack(Items.EMERALD, this.emeraldCost), new ItemStack(this.itemStack.getItem(), this.numberOfItems), this.maxUses, this.villagerXp, this.priceMultiplier);
	      }
	   }
	   
	   public static class EnchantedItemForEmeralds implements VillagerTrades.ItemListing {
		      private final ItemStack itemStack;
		      private final int baseEmeraldCost;
		      private final int maxUses;
		      private final int villagerXp;
		      private final float priceMultiplier;

		      public EnchantedItemForEmeralds(Item pItem, int pBaseEmeraldCost, int pMaxUses, int pVillagerXp) {
		         this(pItem, pBaseEmeraldCost, pMaxUses, pVillagerXp, 0.05F);
		      }

		      public EnchantedItemForEmeralds(Item pItem, int pBaseEmeraldCost, int pMaxUses, int pVillagerXp, float pPriceMultiplier) {
		         this.itemStack = new ItemStack(pItem);
		         this.baseEmeraldCost = pBaseEmeraldCost;
		         this.maxUses = pMaxUses;
		         this.villagerXp = pVillagerXp;
		         this.priceMultiplier = pPriceMultiplier;
		      }

		      public MerchantOffer getOffer(Entity pTrader, RandomSource pRandom) {
		         int i = 5 + pRandom.nextInt(15);
		         ItemStack itemstack = EnchantmentHelper.enchantItem(pRandom, new ItemStack(this.itemStack.getItem()), i, false);
		         int j = Math.min(this.baseEmeraldCost + i, 64);
		         ItemStack itemstack1 = new ItemStack(Items.EMERALD, j);
		         return new MerchantOffer(itemstack1, itemstack, this.maxUses, this.villagerXp, this.priceMultiplier);
		      }
		   }
}
