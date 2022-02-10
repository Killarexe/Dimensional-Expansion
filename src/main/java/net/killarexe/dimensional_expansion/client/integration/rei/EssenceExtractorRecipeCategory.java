package net.killarexe.dimensional_expansion.client.integration.rei;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.data.recipes.EssenceExtractorRecipe;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

import java.util.List;

public class EssenceExtractorRecipeCategory implements DisplayCategory {

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(DEBlocks.ESSENCE_EXTRACTOR);
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("block." + DEMod.MODID + ".essence_extractor");
    }

    @Override
    public CategoryIdentifier getCategoryIdentifier() {
        return new CategoryIdentifier() {
            @Override
            public Identifier getIdentifier() {
                    return EssenceExtractorRecipe.Serializer.ID;
            }
        };
    }

    @Override
    public List<Widget> setupDisplay(Display display, Rectangle bounds) {
        return DisplayCategory.super.setupDisplay(display, bounds);
    }
}
