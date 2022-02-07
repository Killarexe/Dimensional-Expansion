package net.killarexe.dimensional_expansion.client.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.data.recipes.EssenceExtractorRecipe;
import net.killarexe.dimensional_expansion.core.init.DERecipeTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.Objects;
import java.util.stream.Collectors;

@JeiPlugin
public class DEJei implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(DEMod.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new EssenceExtractorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        registration.addRecipes(
                rm.getAllRecipesFor(DERecipeTypes.ESSENCE_EXTRACTOR_RECIPE_TYPE)
                        .stream()
                        .filter(r -> r instanceof EssenceExtractorRecipe)
                        .collect(Collectors.toList()),
                EssenceExtractorRecipeCategory.UID);
    }
}
