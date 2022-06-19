package net.killarexe.dimensional_expansion.client.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.data.recipes.EssenceExtractorRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class DEJei implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(DEMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new EssenceExtractorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

	@Override
	@SuppressWarnings("resource")
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<EssenceExtractorRecipe> recipes = rm.getAllRecipesFor(EssenceExtractorRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(EssenceExtractorRecipeCategory.UID, EssenceExtractorRecipe.class), recipes);
    }
}
