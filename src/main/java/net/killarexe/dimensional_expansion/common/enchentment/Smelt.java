package net.killarexe.dimensional_expansion.common.enchentment;

import net.killarexe.dimensional_expansion.init.DEEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.DiggingEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event.Result;

public class Smelt extends DiggingEnchantment {

	public Smelt() {
		super(Rarity.VERY_RARE, EquipmentSlot.values());
	}

	@Override
	protected boolean checkCompatibility(Enchantment enchantment) {
		return enchantment != Enchantments.BLOCK_FORTUNE || enchantment != Enchantments.SILK_TOUCH;
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public int getMinLevel() {
		return 1;
	}

	public static void diggingEvent(BlockEvent.BreakEvent e) {
		if (EnchantmentHelper.getEnchantmentLevel(DEEnchantments.SMELT.get(), e.getPlayer()) > 0 && e != null
				&& e.isCancelable() && e.getResult() != Result.DENY && !e.getPlayer().isCreative()) {
			e.setCanceled(true);
			BlockPos pos = e.getPos();
			Level level = e.getPlayer().getLevel();
			ItemStack item = new ItemStack(e.getState().getBlock());
			if (level.getRecipeManager().getRecipeFor(RecipeType.SMELTING,
					new SimpleContainer(new ItemStack(e.getState().getBlock())), level).isPresent()) {
				item = level
						.getRecipeManager().getRecipeFor(RecipeType.SMELTING,
								new SimpleContainer(new ItemStack(e.getState().getBlock())), level)
						.map(recipe -> recipe.getResultItem(level.registryAccess()).copy()).orElse(item);
			}
			if (EnchantmentHelper.getEnchantmentLevel(DEEnchantments.SMELT.get(), e.getPlayer()) > 1
					&& level.getRecipeManager().getRecipeFor(RecipeType.BLASTING,
							new SimpleContainer(new ItemStack(e.getState().getBlock())), level).isPresent()) {
				item = level
						.getRecipeManager().getRecipeFor(RecipeType.BLASTING,
								new SimpleContainer(new ItemStack(e.getState().getBlock())), level)
						.map(recipe -> recipe.getResultItem(level.registryAccess()).copy()).orElse(item);
			}
			level.destroyBlock(e.getPos(), false);
			level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), item));
		}
	}
}
