package net.killarexe.dimensional_expansion.common.item.material;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;


@SuppressWarnings("deprecation")
public enum DEArmorMaterial implements ArmorMaterial {
	PALON(DEMod.MOD_ID + ":palon", 38, new int[] {3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
		return Ingredient.of(DEItems.PALON_INGOT.get());
	}),

	BASSMITE(DEMod.MOD_ID + ":bassmite", 39, new int[] {4, 7, 8, 3}, 16, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
		return Ingredient.of(DEItems.BASSMITE_GEM.get());
	}),

	SIMIX(DEMod.MOD_ID + ":simix", 40, new int[] {4, 7, 9, 4}, 17, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
		return Ingredient.of(DEItems.SIMIX_INGOT.get());
	}),
	
	EMERTYST(DEMod.MOD_ID + ":emertyst", 64, new int[] {5, 11, 15, 5}, 30, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.2F, () -> {
		return Ingredient.of(DEItems.EMERTYST_GEM.get());
	});

	private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
	private final String name;
	private final int durabilityMultiplier;
	private final int[] slotProtections;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final LazyLoadedValue<Ingredient> repairIngredient;

	DEArmorMaterial(String p_40474_, int p_40475_, int[] p_40476_, int p_40477_, SoundEvent p_40478_, float p_40479_, float p_40480_, Supplier<Ingredient> p_40481_) {
		this.name = p_40474_;
		this.durabilityMultiplier = p_40475_;
		this.slotProtections = p_40476_;
		this.enchantmentValue = p_40477_;
		this.sound = p_40478_;
		this.toughness = p_40479_;
		this.knockbackResistance = p_40480_;
		this.repairIngredient = new LazyLoadedValue<>(p_40481_);
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlot p_40484_) {
		return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlot p_40487_) {
		return this.slotProtections[p_40487_.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.sound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
