package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.effect.Remote;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DEPoitions {

    public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DEMod.MOD_ID);
    public static final DeferredRegister<Potion> POTION = DeferredRegister.create(ForgeRegistries.POTIONS, DEMod.MOD_ID);

    /*EFFECTS*/
    public static final RegistryObject<MobEffect> REMOTE_EFFECT = createEffect("remote", new Remote());
    
	private static RegistryObject<MobEffect> createEffect(String name, MobEffect effect){
        return EFFECT.register(name, () -> effect);
    }

    /*POTIONS*/
	public static final RegistryObject<Potion> REMOTE_POTION = createPotion("remote", REMOTE_EFFECT, 30);

	private static RegistryObject<Potion> createPotion(String name, RegistryObject<MobEffect> effect, int defaultDuration){
        return POTION.register(name, () -> new Potion(new MobEffectInstance(effect.get(), defaultDuration * 20)));
    }
}
