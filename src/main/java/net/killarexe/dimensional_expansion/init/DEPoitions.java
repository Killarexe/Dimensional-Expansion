package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DEPoitions {

    public static final DeferredRegister<Potion> POTION = DeferredRegister.create(ForgeRegistries.POTIONS, DEMod.MOD_ID);

    /*POTIONS*/
	public static final RegistryObject<Potion> REMOTE_POTION = createPotion("remote", DEEffects.REMOTE_EFFECT, 30);

	private static RegistryObject<Potion> createPotion(String name, RegistryObject<? extends MobEffect> effect, int defaultDuration){
        return POTION.register(name, () -> new Potion(new MobEffectInstance(effect.get(), defaultDuration * 20)));
    }
}
