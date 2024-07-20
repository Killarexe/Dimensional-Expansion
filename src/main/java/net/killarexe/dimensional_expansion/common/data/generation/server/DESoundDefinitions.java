package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.init.DESoundEvents;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

import java.util.function.Supplier;

public class DESoundDefinitions extends SoundDefinitionsProvider {

	public DESoundDefinitions(PackOutput output, ExistingFileHelper helper) {
		super(output, DEMod.MOD_ID, helper);
	}
	
	@Override
	public void registerSounds() {
		addEntitySound(DESoundEvents.BLUE_SAND_MAN_AMBIENT, "blue_sand_man", "ambient", "say1", "say2");
		addEntitySound(DESoundEvents.BLUE_SAND_MAN_DEATH, "blue_sand_man", "death", "death");
		addEntitySound(DESoundEvents.BLUE_SAND_MAN_HURT, "blue_sand_man", "hurt", "hurt");
		addEntitySound(DESoundEvents.JUGER_AMBIENT, "juger", "ambient", "say1");
		addEntitySound(DESoundEvents.JUGER_ATTACK, "juger", "attack", "attack");
		addEntitySound(DESoundEvents.JUGER_DEATH, "juger", "death", "death");
		addEntitySound(DESoundEvents.JUGER_HURT, "juger", "hurt", "hurt");
		addEntitySound(DESoundEvents.MOUVET_AMBIENT, "mouvet", "ambient", "say1");
		addEntitySound(DESoundEvents.MOUVET_DEATH, "mouvet", "death", "death");
		addEntitySound(DESoundEvents.MOUVET_HURT, "mouvet", "hurt", "hurt");
		
		addMusicDisc(DESoundEvents.MUSIC_DISC_SWEDEN_REMIX, "sweden_remix");
		addMusicDisc(DESoundEvents.MUSIC_DISC_VERY_SPCIAL_DISC, "very_special_disc");
		addMusicDisc(DESoundEvents.MUSIC_DISC_GROOVY, "groovy");

		addMusic(DESoundEvents.ORIGIN_MUSIC, "origin_music", "nightly_walk", "seeing_the_stars", "the_origin");
	}
	
	private void addEntitySound(Supplier<SoundEvent> sound, String entityId, String title, String... files) {
		addMultiple(sound, "entity." + DEMod.MOD_ID + "." + entityId + "." + title, "entity/" + entityId, files);
	}
	
	private void addMusicDisc(Supplier<SoundEvent> sound, String name) {
		addSingle(sound, "record." + DEMod.MOD_ID + "." + name + ".subtitle", "record", name);
	}
	
	private void addMusic(Supplier<SoundEvent> sound, String title, String... files) {
		addMultiple(sound, title, "music", files);
	}
	
	private void addMultiple(Supplier<SoundEvent> sound, String title, String path, String... files) {
		SoundDefinition definition = definition().subtitle(title);
		for(String file: files) {
			definition.with(sound(DEMod.res(path + "/" + file)));
		}
		add(sound.get(), definition);
	}
	
	private void addSingle(Supplier<SoundEvent> sound, String title, String path, String file) {
		add(sound.get(), definition().subtitle(title).with(sound(DEMod.res(path + "/" + file))));
	}
}
