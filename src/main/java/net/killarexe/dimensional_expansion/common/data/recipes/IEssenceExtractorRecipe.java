package net.killarexe.dimensional_expansion.common.data.recipes;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public interface IEssenceExtractorRecipe extends Recipe<Container> {

    ResourceLocation TYPE_ID = new ResourceLocation(DEMod.MODID, "essence_extractor");

    @Override
    default RecipeType<?> getType() {
        return Registry.RECIPE_TYPE.getOptional(TYPE_ID).get();
    }

    @Override
    default boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    default boolean isIncomplete() {
        return true;
    }
}
