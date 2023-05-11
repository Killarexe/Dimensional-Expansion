package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DESounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DEMod.MOD_ID);

    public static final RegistryObject<SoundEvent> THE_ORIGIN = createSound("the_origin");
    public static final RegistryObject<SoundEvent> DOCTOR_WHO = createSound("doctor_who");
    public static final RegistryObject<SoundEvent> SWEDEN_REMIX = createSound("sweden_remix");
    public static final RegistryObject<SoundEvent> NIGHTLY_WALK = createSound("nightly_walk");  
    public static final RegistryObject<SoundEvent> SEEING_THE_STARS = createSound("seeing_the_stars");

    private static RegistryObject<SoundEvent> createSound(String name){
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DEMod.MOD_ID, name)));
    }
}
