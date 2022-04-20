package net.killarexe.dimensional_expansion.common.data.generation.client.lang;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class DEEnUsProvider extends LanguageProvider {

    public DEEnUsProvider(DataGenerator generator) {
        super(generator, DEMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(DEBlocks.PALON_ORE.get(), "Palon Ore");
    }
}
