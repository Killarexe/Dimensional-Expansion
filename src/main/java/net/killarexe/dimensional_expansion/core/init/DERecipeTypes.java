package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.data.recipes.EssenceExtractorRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DERecipeTypes {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, DEMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<EssenceExtractorRecipe>> ESSENCE_EXTRACTOR_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register(
            "essence_extractor", () -> EssenceExtractorRecipe.Serializer.INSTANCE);
}
