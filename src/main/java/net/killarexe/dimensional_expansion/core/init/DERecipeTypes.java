package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.data.recipes.WeatherChangerRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DERecipeTypes {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, DEMod.MODID);

    public static final RegistryObject<WeatherChangerRecipe.Serializer> WEATHER_CHANGER_SERIALIZER =
            RECIPE_SERIALIZER.register("weather_changer", WeatherChangerRecipe.Serializer::new);

    public static final RecipeType<WeatherChangerRecipe> WEATHER_CHANGER_RECIPE =
            new WeatherChangerRecipe.WeatherChangerRecipeType();

    public static void register(IEventBus bus){
        RECIPE_SERIALIZER.register(bus);
        Registry.register(Registry.RECIPE_TYPE, WeatherChangerRecipe.TYPE_ID, WEATHER_CHANGER_RECIPE);
    }
}
