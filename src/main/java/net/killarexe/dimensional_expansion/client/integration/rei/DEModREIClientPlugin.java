package net.killarexe.dimensional_expansion.client.integration.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.entry.EntryRegistry;

public class DEModREIClientPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new EssenceExtractorRecipeCategory());
    }

    @Override
    public void registerEntries(EntryRegistry registry) {

    }
}
