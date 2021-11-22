package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.effect.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.*;

public class DEPoitions {

    public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DEMod.MODID);
    public static final DeferredRegister<Potion> POTION = DeferredRegister.create(ForgeRegistries.POTIONS, DEMod.MODID);

    //EFFECTS
    public static final RegistryObject<MobEffect> REMOTE_EFFECT = createEffect("remote", new Remote());

    private static RegistryObject<MobEffect> createEffect(String name, MobEffect effect){
        return EFFECT.register(name, () -> effect);
    }

    //POTIONS
    public static final RegistryObject<Potion> REMOTE_POTION = createPotion("remote", REMOTE_EFFECT);

    private static RegistryObject<Potion> createPotion(String name, MobEffect effect){
        return POTION.register(name, () -> new Potion(new MobEffectInstance(effect)));
    }

    private static RegistryObject<Potion> createPotion(String name, RegistryObject<MobEffect> effect){
        return POTION.register(name, () -> new Potion(new MobEffectInstance(effect.get())));
    }
}
