package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DESoundEvents{
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DEMod.MOD_ID);
	
	public static final RegistryObject<SoundEvent> MOUVET_AMBIENT = createFixedSound("entity.mouvet.ambient", 5.0f);
	public static final RegistryObject<SoundEvent> MOUVET_DEATH = createFixedSound("entity.mouvet.death", 5.0f);
	public static final RegistryObject<SoundEvent> JUGER_AMBIENT = createFixedSound("entity.juger.ambient", 3.0f);
	public static final RegistryObject<SoundEvent> JUGER_ATTACK = createFixedSound("entity.juger.attack", 16.0F);
	public static final RegistryObject<SoundEvent> JUGER_DEATH = createFixedSound("entity.juger.death", 16.0f);
	public static final RegistryObject<SoundEvent> BLUE_SAND_MAN_DEATH = createFixedSound("entity.blue_sand_man.death", 16.0f);
	public static final RegistryObject<SoundEvent> BLUE_SAND_MAN_AMBIENT = createFixedSound("entity.blue_sand_man.ambient", 16.0F);
	
	public static final RegistryObject<SoundEvent> ORIGIN_MUSIC = createVariableSound("music.origin");
	public static final RegistryObject<SoundEvent> MUSIC_DISC_SWEDEN_REMIX = createVariableSound("disc.sweden_remix");
	
	private static RegistryObject<SoundEvent> createFixedSound(String id, float range){
		return SOUND_EVENTS.register(id, () -> SoundEvent.createFixedRangeEvent(new ResourceLocation(DEMod.MOD_ID, id), range));
	}
	
	private static RegistryObject<SoundEvent> createVariableSound(String id){
		return SOUND_EVENTS.register(id, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DEMod.MOD_ID, id)));
	}
}
