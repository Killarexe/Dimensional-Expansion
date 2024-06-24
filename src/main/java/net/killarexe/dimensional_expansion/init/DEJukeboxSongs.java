package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class DEJukeboxSongs {
    public static final DeferredRegister<JukeboxSong> JUKEBOX_SONG = DeferredRegister.create(Registries.JUKEBOX_SONG, DEMod.MOD_ID);

    public static final Tuple<Supplier<JukeboxSong>, ResourceKey<JukeboxSong>> SWEDEN_REMIX = createJukeboxSong("sweden_remix", DESoundEvents.MUSIC_DISC_SWEDEN_REMIX, 10.0f, 7);

    private static Tuple<Supplier<JukeboxSong>, ResourceKey<JukeboxSong>> createJukeboxSong(String id, Supplier<SoundEvent> music, float length, int comparatorValue) {
        Supplier<JukeboxSong> song = JUKEBOX_SONG.register(id, () -> new JukeboxSong(
                Holder.direct(music.get()),
                Component.translatable("jukebox_song." + DEMod.MOD_ID + "." + id + ".desc"),
                length,
                comparatorValue)
        );
        ResourceKey<JukeboxSong> key = ResourceKey.create(Registries.JUKEBOX_SONG, DEMod.res(id));
        return new Tuple<>(song, key);
    }
}
