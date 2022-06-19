package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DEEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DEMod.MOD_ID);

    @SuppressWarnings("unused")
	private static RegistryObject<Enchantment> createEnchantment(String name, Enchantment enchantment){
        return ENCHANTMENT.register(name, () -> enchantment);
    }
}
