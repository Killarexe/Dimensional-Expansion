package net.killarexe.dimensional_expansion.common.event.villager.trades;

import java.util.Map;

import javax.annotation.Nullable;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerDataHolder;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;

public class EmeraldsForVillagerTypeItem implements ItemListing{
	private final Map<VillagerType, Item> trades;
	private final int cost;
	private final int maxUses;
	private final int villagerXp;

	public EmeraldsForVillagerTypeItem(int pCost, int pMaxUses, int pVillagerXp, Map<VillagerType, Item> pTrades) {
		BuiltInRegistries.VILLAGER_TYPE.stream().filter((key) -> {
			return !pTrades.containsKey(key);
		}).findAny().ifPresent((p_258962_) -> {
			throw new IllegalStateException(
					"Missing trade for villager type: " + BuiltInRegistries.VILLAGER_TYPE.getKey(p_258962_));
		});
		this.trades = pTrades;
		this.cost = pCost;
		this.maxUses = pMaxUses;
		this.villagerXp = pVillagerXp;
	}

	@Nullable
	public MerchantOffer getOffer(Entity pTrader, RandomSource pRandom) {
		if (pTrader instanceof VillagerDataHolder) {
			ItemStack itemstack = new ItemStack(
					this.trades.get(((VillagerDataHolder) pTrader).getVillagerData().getType()), this.cost);
			return new MerchantOffer(itemstack, new ItemStack(Items.EMERALD), this.maxUses, this.villagerXp, 0.05F);
		} else {
			return null;
		}
	}
}
