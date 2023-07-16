package net.killarexe.dimensional_expansion.common.event.villager.trades;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;

public class EmeraldForItems implements ItemListing{
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
