package net.killarexe.dimensional_expansion.common.item.material;

import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum DEItemTier implements Tier {
	BASSMITE(6, 4092, 11.0f, 6f, 16, () -> {
		return Ingredient.of(DEItems.BASSMITE_GEM.get());
	}),
	EMERTYST(8, 6000, 15.0f, 9f, 19, () -> {
		return Ingredient.of(DEItems.EMERTYST_GEM.get());
	});

	private final int level;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantmentValue;
	private final Supplier<Ingredient> repairIngredient;

	DEItemTier(int p_43332_, int p_43333_, float p_43334_, float p_43335_, int p_43336_, Supplier<Ingredient> p_43337_) {
		this.level = p_43332_;
		this.uses = p_43333_;
		this.speed = p_43334_;
		this.damage = p_43335_;
		this.enchantmentValue = p_43336_;
		this.repairIngredient = p_43337_;
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
