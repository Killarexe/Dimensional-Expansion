package net.killarexe.dimensional_expansion.common.event.villager.trades;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.trading.MerchantOffer;

public class EnchantedItemForEmeralds implements ItemListing{
	private final ItemStack itemStack;
	private final int baseEmeraldCost;
	private final int maxUses;
	private final int villagerXp;
	private final float priceMultiplier;

	public EnchantedItemForEmeralds(Item pItem, int pBaseEmeraldCost, int pMaxUses, int pVillagerXp) {
		this(pItem, pBaseEmeraldCost, pMaxUses, pVillagerXp, 0.05F);
	}

	public EnchantedItemForEmeralds(Item pItem, int pBaseEmeraldCost, int pMaxUses, int pVillagerXp,
			float pPriceMultiplier) {
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
