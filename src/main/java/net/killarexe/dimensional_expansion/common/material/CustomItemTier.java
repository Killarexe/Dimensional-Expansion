package net.killarexe.dimensional_expansion.common.material;

import net.killarexe.dimensional_expansion.core.init.DimensionalExpansionItems;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum CustomItemTier implements Tier {
	PALON(5, 3592, 17.0f, 7f, 25, () -> {
		return Ingredient.of(DimensionalExpansionItems.PALON_INGOT.get());
	}),
	EMERTYST(5, 3592, 17.0f, 7f, 25, () -> {
		return Ingredient.of(DimensionalExpansionItems.PALON_INGOT.get());
	}),
	SIMIX(5, 3592, 17.0f, 7f, 25, () -> {
		return Ingredient.of(DimensionalExpansionItems.PALON_INGOT.get());
	}),
	BASSMITE(5, 3592, 17.0f, 7f, 25, () -> {
		return Ingredient.of(DimensionalExpansionItems.PALON_INGOT.get());
	});

	private final int level;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantmentValue;
	private final LazyLoadedValue<Ingredient> repairIngredient;

	private CustomItemTier(int p_43332_, int p_43333_, float p_43334_, float p_43335_, int p_43336_, Supplier<Ingredient> p_43337_) {
		this.level = p_43332_;
		this.uses = p_43333_;
		this.speed = p_43334_;
		this.damage = p_43335_;
		this.enchantmentValue = p_43336_;
		this.repairIngredient = new LazyLoadedValue<>(p_43337_);
	}

	public int getUses() {
		return this.uses;
	}

	public float getSpeed() {
		return this.speed;
	}

	public float getAttackDamageBonus() {
		return this.damage;
	}

	public int getLevel() {
		return this.level;
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}
}
