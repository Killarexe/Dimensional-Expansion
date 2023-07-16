package net.killarexe.dimensional_expansion.common.event.villager.trades;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Block;

public class ItemsForEmeralds implements ItemListing{
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

	public ItemsForEmeralds(ItemStack pItemStack, int pEmeraldCost, int pNumberOfItems, int pMaxUses, int pVillagerXp,
			float pPriceMultiplier) {
		this.itemStack = pItemStack;
		this.emeraldCost = pEmeraldCost;
		this.numberOfItems = pNumberOfItems;
		this.maxUses = pMaxUses;
		this.villagerXp = pVillagerXp;
		this.priceMultiplier = pPriceMultiplier;
	}

	public MerchantOffer getOffer(Entity pTrader, RandomSource pRandom) {
		return new MerchantOffer(new ItemStack(Items.EMERALD, this.emeraldCost),
				new ItemStack(this.itemStack.getItem(), this.numberOfItems), this.maxUses, this.villagerXp,
				this.priceMultiplier);
	}
}
