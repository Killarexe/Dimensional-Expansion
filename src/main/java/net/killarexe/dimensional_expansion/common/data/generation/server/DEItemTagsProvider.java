package net.killarexe.dimensional_expansion.common.data.generation.server;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class DEItemTagsProvider extends ItemTagsProvider {

    public DEItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper helper) {
        super(generator, blockTagsProvider, DEMod.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(ItemTags.PLANKS).add(DEBlocks.END_PLANKS.get().asItem());
    }
}
