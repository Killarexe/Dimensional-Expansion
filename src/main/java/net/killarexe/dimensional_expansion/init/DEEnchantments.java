package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.enchentment.BurnProtection;
import net.killarexe.dimensional_expansion.common.enchentment.NoMagic;
import net.killarexe.dimensional_expansion.common.enchentment.Smelt;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DEEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DEMod.MOD_ID);
    
    public static final RegistryObject<Enchantment> BRUN_PROTECTION = createEnchantment("burn_protection", new BurnProtection());
    public static final RegistryObject<Enchantment> NO_MAGIC = createEnchantment("no_magic", new NoMagic());
    public static final RegistryObject<Enchantment> SMELT = createEnchantment("smelt", new Smelt());

	private static RegistryObject<Enchantment> createEnchantment(String name, Enchantment enchantment){
        return ENCHANTMENT.register(name, () -> enchantment);
    }
}
