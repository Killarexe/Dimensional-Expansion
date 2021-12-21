package net.killarexe.dimensional_expansion.data.recipes;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.crafting.IShapedRecipe;

public interface IWeatherChangerRecipe extends IShapedRecipe<Container> {

    ResourceLocation TYPE_ID = new ResourceLocation(DEMod.MODID, "weather_changer");

    @Override
    default RecipeType<?> getType(){
        return Registry.RECIPE_TYPE.getOptional(TYPE_ID).get();
    }

    @Override
    default boolean canCraftInDimensions(int width, int height){
        return true;
    }

    @Override
    default boolean isSpecial() {
        return true;
    }
}
