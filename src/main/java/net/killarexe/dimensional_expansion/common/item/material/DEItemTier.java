package net.killarexe.dimensional_expansion.common.item.material;

import net.killarexe.dimensional_expansion.init.DEItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum DEItemTier implements Tier {
	BASSMITE(5, 3096, 9.5f, 4.5f, 17, () -> Ingredient.of(DEItems.BASSMITE_GEM.get())),
	EMERTYST(6, 4096, 10.0f, 5f, 20, () -> Ingredient.of(DEItems.EMERTYST_GEM.get()));

	private final int level;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantmentValue;
	private final Supplier<Ingredient> repairIngredient;

	DEItemTier(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
		this.level = level;
		this.uses = uses;
		this.speed = speed;
		this.damage = damage;
		this.enchantmentValue = enchantmentValue;
		this.repairIngredient = repairIngredient;
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

	@Override
	public TagKey<Block> getIncorrectBlocksForDrops() {
		return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
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

	@Override
	public Tool createToolProperties(TagKey<Block> pBlock) {
		return Tier.super.createToolProperties(pBlock);
	}
}
