package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DEJukeboxSongs {
    public static final ResourceKey<JukeboxSong> SWEDEN_REMIX = createJukeboxSong("sweden_remix");
    public static final ResourceKey<JukeboxSong> VERY_SPECIAL_DISC = createJukeboxSong("very_special_disc");
    public static final ResourceKey<JukeboxSong> GROOVY = createJukeboxSong("groovy");

    private static ResourceKey<JukeboxSong> createJukeboxSong(String id) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, DEMod.res(id));
    }

    public static void register() {

    }
}
