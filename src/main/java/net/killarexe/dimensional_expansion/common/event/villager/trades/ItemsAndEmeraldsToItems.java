package net.killarexe.dimensional_expansion.common.event.villager.trades;

import javax.annotation.Nullable;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;

public class ItemsAndEmeraldsToItems implements ItemListing{
	private final ItemStack fromItem;
	private final int fromCount;
	private final int emeraldCost;
	private final ItemStack toItem;
	private final int toCount;
	private final int maxUses;
	private final int villagerXp;
	private final float priceMultiplier;

	public ItemsAndEmeraldsToItems(ItemLike pFromItem, int pFromCount, Item pToItem, int pToCount, int pMaxUses,
			int pVillagerXp) {
		this(pFromItem, pFromCount, 1, pToItem, pToCount, pMaxUses, pVillagerXp);
	}

	public ItemsAndEmeraldsToItems(ItemLike pFromItem, int pFromCount, int pEmeraldCost, Item pToItem, int pToCount,
			int pMaxUses, int pVillagerXp) {
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
		return new MerchantOffer(new ItemStack(Items.EMERALD, this.emeraldCost),
				new ItemStack(this.fromItem.getItem(), this.fromCount),
				new ItemStack(this.toItem.getItem(), this.toCount), this.maxUses, this.villagerXp,
				this.priceMultiplier);
	}
}
