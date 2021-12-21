package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DEPoitions {

    public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DEMod.MODID);
    public static final DeferredRegister<Potion> POTION = DeferredRegister.create(ForgeRegistries.POTIONS, DEMod.MODID);

    //EFFECTS

    private static RegistryObject<MobEffect> createEffect(String name, MobEffect effect){
        return EFFECT.register(name, () -> effect);
    }

    //POTIONS

    private static RegistryObject<Potion> createPotion(String name, MobEffect effect){
        return POTION.register(name, () -> new Potion(new MobEffectInstance(effect)));
    }

    private static RegistryObject<Potion> createPotion(String name, RegistryObject<MobEffect> effect){
        return POTION.register(name, () -> new Potion(new MobEffectInstance(effect.get())));
    }
}
