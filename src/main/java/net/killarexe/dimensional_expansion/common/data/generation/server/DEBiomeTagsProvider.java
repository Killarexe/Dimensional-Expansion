package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class DEBiomeTagsProvider extends BiomeTagsProvider {

    public DEBiomeTagsProvider(DataGenerator p_211094_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_211094_, DEMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        
    }
}
