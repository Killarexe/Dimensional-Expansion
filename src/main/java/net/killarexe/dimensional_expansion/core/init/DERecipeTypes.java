package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.data.recipes.EssenceExtractorRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DERecipeTypes {

    public static final RecipeSerializer<EssenceExtractorRecipe> ESSENCE_EXTRACTOR_SERIALIZER = Registry.register(Registry.RECIPE_SERIALIZER, EssenceExtractorRecipe.Serializer.ID, EssenceExtractorRecipe.Serializer.INSTANCE);
    public static final RecipeType<EssenceExtractorRecipe> ESSENCE_EXTRACTOR_RECIPE = Registry.register(Registry.RECIPE_TYPE, new Identifier(DEMod.MODID, EssenceExtractorRecipe.Type.ID), EssenceExtractorRecipe.Type.INSTANCE);

    public static void registerRecipeTypes(){

    }
}
