package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.init.DESoundEvents;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;
import net.minecraftforge.registries.RegistryObject;

public class DESoundDefinitions extends SoundDefinitionsProvider{

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
		
		addMusic(DESoundEvents.ORIGIN_MUSIC, null, "nightly_walk", "seeing_the_stars", "the_origin");
	}
	
	private void addEntitySound(RegistryObject<SoundEvent> sound, String entityId, String title, String... files) {
		addMultiple(sound, "entity." + DEMod.MOD_ID + "." + entityId + "." + title, "entity/" + entityId, files);
	}
	
	private void addMusicDisc(RegistryObject<SoundEvent> sound, String name) {
		addSingle(sound, "record." + DEMod.MOD_ID + "." + name + ".subtitle", "record", name);
	}
	
	private void addMusic(RegistryObject<SoundEvent> sound, String title, String... files) {
		addMultiple(sound, title, "music", files);
	}
	
	private void addMultiple(RegistryObject<SoundEvent> sound, String title, String path, String... files) {
		SoundDefinition definition = definition().subtitle(title);
		for(String file: files) {
			definition.with(sound(new ResourceLocation(DEMod.MOD_ID, path + "/" + file)));
		}
		add(sound.get(), definition);
	}
	
	private void addSingle(RegistryObject<SoundEvent> sound, String title, String path, String file) {
		add(sound.get(), definition().subtitle(title).with(sound(new ResourceLocation(DEMod.MOD_ID, path + "/" + file))));
	}
}
