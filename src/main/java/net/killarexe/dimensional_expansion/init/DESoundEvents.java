package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class DESoundEvents{
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, DEMod.MOD_ID);
	
	public static final Supplier<SoundEvent> MOUVET_AMBIENT = createFixedSound("entity.mouvet.ambient", 5.0f);
	public static final Supplier<SoundEvent> MOUVET_DEATH = createFixedSound("entity.mouvet.death", 5.0f);
	public static final Supplier<SoundEvent> MOUVET_HURT = createFixedSound("entity.mouvet.hurt", 5.0f);
	public static final Supplier<SoundEvent> JUGER_AMBIENT = createFixedSound("entity.juger.ambient", 3.0f);
	public static final Supplier<SoundEvent> JUGER_ATTACK = createFixedSound("entity.juger.attack", 7.0F);
	public static final Supplier<SoundEvent> JUGER_DEATH = createFixedSound("entity.juger.death", 7.0f);
	public static final Supplier<SoundEvent> JUGER_HURT = createFixedSound("entity.juger.hurt", 10.0f);
	public static final Supplier<SoundEvent> BLUE_SAND_MAN_DEATH = createFixedSound("entity.blue_sand_man.death", 6.0f);
	public static final Supplier<SoundEvent> BLUE_SAND_MAN_AMBIENT = createFixedSound("entity.blue_sand_man.ambient", 6.0F);
	public static final Supplier<SoundEvent> BLUE_SAND_MAN_HURT = createFixedSound("entity.blue_sand_man.hurt", 6.0F);
	
	public static final Supplier<SoundEvent> ORIGIN_MUSIC = createVariableSound("music.origin");

	public static final Supplier<SoundEvent> MUSIC_DISC_SWEDEN_REMIX = createVariableSound("disc.sweden_remix");
	public static final Supplier<SoundEvent> MUSIC_DISC_VERY_SPCIAL_DISC = createVariableSound("disc.very_special_disc");
	public static final Supplier<SoundEvent> MUSIC_DISC_GROOVY = createVariableSound("disc.groovy");

	private static Supplier<SoundEvent> createFixedSound(String id, float range){
		return SOUND_EVENTS.register(id, () -> SoundEvent.createFixedRangeEvent(DEMod.res(id), range));
	}
	
	private static Supplier<SoundEvent> createVariableSound(String id){
		return SOUND_EVENTS.register(id, () -> SoundEvent.createVariableRangeEvent(DEMod.res(id)));
	}
}
