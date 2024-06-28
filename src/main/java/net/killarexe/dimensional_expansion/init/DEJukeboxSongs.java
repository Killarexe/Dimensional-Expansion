package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DEJukeboxSongs {
    public static final ResourceKey<JukeboxSong> SWEDEN_REMIX = createJukeboxSong("sweden_remix");

    private static ResourceKey<JukeboxSong> createJukeboxSong(String id) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, DEMod.res(id));
    }

    public static void register() {

    }
}
