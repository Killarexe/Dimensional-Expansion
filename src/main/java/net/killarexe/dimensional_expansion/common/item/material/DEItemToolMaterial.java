package net.killarexe.dimensional_expansion.common.item.material;

import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum DEItemToolMaterial implements ToolMaterial {
    PALON(5, 3592, 17.0f, 7f, 25, () -> {
        return Ingredient.ofItems(DEItems.PALON_INGOT);
    }),
    BASSMITE(6, 4092, 19.0f, 9f, 30, () -> {
        return Ingredient.ofItems(DEItems.BASSMITE_GEM);
    }),
    SIMIX(7, 5092, 27.0f, 10f, 35, () -> {
        return Ingredient.ofItems(DEItems.SIMIX_INGOT);
    }),
    EMERTYST(8, 3592*2, 17.0f*2, 14f, 50, () -> {
        return Ingredient.ofItems(DEItems.EMERTYST_GEM);
    });;

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Lazy<Ingredient> repairIngredient;

    private DEItemToolMaterial(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> p_43337_) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new Lazy<>(p_43337_);
    }

    @Override
    public int getDurability() {
        return this.uses;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.speed;
    }

    @Override
    public float getAttackDamage() {
        return this.damage;
    }

    @Override
    public int getMiningLevel() {
        return this.level;
    }

    @Override
    public int getEnchantability() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
