package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.init.DESoundEvents;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;
import net.minecraftforge.registries.RegistryObject;

public class DESoundDefinitions extends SoundDefinitionsProvider{

	public DESoundDefinitions(PackOutput output, ExistingFileHelper helper) {
		super(output, DEMod.MOD_ID, helper);
	}
	
	@Override
	public void registerSounds() {
		addEntitySound(DESoundEvents.BLUE_SAND_MAN_AMBIENT, "blue_sand_man", "ambient");
		addEntitySound(DESoundEvents.BLUE_SAND_MAN_DEATH, "blue_sand_man", "death");
		addEntitySound(DESoundEvents.JUGER_AMBIENT, "juger", "ambient");
		addEntitySound(DESoundEvents.JUGER_ATTACK, "juger", "attack");
		addEntitySound(DESoundEvents.JUGER_DEATH, "juger", "death");
		addEntitySound(DESoundEvents.MOUVET_AMBIENT, "mouvet", "ambient");
		addEntitySound(DESoundEvents.MOUVET_DEATH, "mouvet", "death");
		addEntitySound(DESoundEvents.MOUVET_EASTER_DEATH, "mouvet", "easter_death");
		
		addMusicDisc(DESoundEvents.MUSIC_DISC_SWEDEN_REMIX, "sweden_remix");
		
		addMusic(DESoundEvents.ORIGIN_MUSIC, "origin");
	}
	
	private void addEntitySound(RegistryObject<SoundEvent> sound, String entityId, String name) {
		add(
			sound.get(),
			definition()
				.subtitle("entity." + entityId + "." + name)
				.with(sound(new ResourceLocation(DEMod.MOD_ID, "entity/" + entityId + "/" + name)))
		);
	}
	
	private void addMusicDisc(RegistryObject<SoundEvent> sound, String name) {
		add(
			sound.get(),
			definition()
				.subtitle("record." + name + ".subtitle")
				.with(sound(new ResourceLocation(DEMod.MOD_ID, "record/" + name)))
		);
	}
	
	private void addMusic(RegistryObject<SoundEvent> sound, String name) {
		add(
			sound.get(),
			definition()
				.with(sound(new ResourceLocation(DEMod.MOD_ID, "record/" + name)))
		);
	}
}
