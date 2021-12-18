package net.killarexe.dimensional_expansion.common.enchantment;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;

public class BurnProtection extends ProtectionEnchantment {

    public BurnProtection() {
        super(Rarity.VERY_RARE, Type.FIRE, EquipmentSlot.CHEST);
    }

    @Override
    public int getDamageProtection(int p_45133_, DamageSource p_45134_) {
        return super.getDamageProtection(p_45133_, p_45134_);
    }

    @Override
    public void doPostHurt(LivingEntity p_44692_, Entity p_44693_, int p_44694_) {
        if(p_44692_.isOnFire()){
            p_44692_.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2048, 5));
        }
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }
}
