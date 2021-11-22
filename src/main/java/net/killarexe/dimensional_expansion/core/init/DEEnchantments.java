package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.enchantment.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DEEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DEMod.MODID);

    public static final RegistryObject<Enchantment> BURN_PROTECTION = createEnchantment("burn_protection", new BurnProtection());

    private static RegistryObject<Enchantment> createEnchantment(String name, Enchantment enchantment){
        return ENCHANTMENT.register(name, () -> enchantment);
    }

    @SubscribeEvent
    public static void applyEnchanements(EntityEvent e){
        Entity entity = e.getEntity();
        if(entity instanceof LivingEntity){
            if(EnchantmentHelper.getEnchantmentLevel(BURN_PROTECTION.get(), (LivingEntity) entity) < 0){
                if(((LivingEntity) entity).getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, 2)) != ItemStack.EMPTY){
                    ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE));
                }
            }
        }
    }
}
