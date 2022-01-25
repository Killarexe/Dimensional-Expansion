package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DESounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DEMod.MODID);

    public static final RegistryObject<SoundEvent> DW = createSound("dw");

    private static RegistryObject<SoundEvent> createSound(String name){
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(DEMod.MODID, name)));
    }
}