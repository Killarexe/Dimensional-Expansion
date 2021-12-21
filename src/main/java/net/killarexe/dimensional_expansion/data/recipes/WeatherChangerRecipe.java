package net.killarexe.dimensional_expansion.data.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.killarexe.dimensional_expansion.core.init.DERecipeTypes;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class WeatherChangerRecipe implements IWeatherChangerRecipe{

    public enum Weather{
        CLEAR,
        RAIN,
        THUNDERING;
        public static Weather getWeatherByString(String s){
            return Objects.equals(s, "thundering") ? THUNDERING : Objects.equals(s, "rain") ? RAIN : CLEAR;
        }
    }

    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;
    private final Weather weather;

    public WeatherChangerRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems, Weather weather) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.weather = weather;
    }

    @Override
    public int getRecipeWidth() {
        return 0;
    }

    @Override
    public int getRecipeHeight() {
        return 0;
    }

    @Override
    public boolean matches(Container p_44002_, Level p_44003_) {
        if(recipeItems.get(0).test(p_44002_.getItem(0))){
            return recipeItems.get(1).test(p_44002_.getItem(1));
        }
        return false;
    }

    @Override
    public ItemStack assemble(Container p_44001_) {
        return output;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return DERecipeTypes.WEATHER_CHANGER_SERIALIZER.get();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    public ItemStack getIcon(){
        return new ItemStack(DEBlocks.WEATHER_CHANGER.get());
    }

    public Weather getWeather() {
        return weather;
    }

    public static class WeatherChangerRecipeType implements RecipeType<WeatherChangerRecipe> {
        @Override
        public String toString() {
            return WeatherChangerRecipe.TYPE_ID.toString();
        }
    }

    public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<WeatherChangerRecipe>{

        @Override
        public WeatherChangerRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(json);
            Ingredient ingredients = CraftingHelper.getIngredient(json);
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, ingredients);
            }

            return new WeatherChangerRecipe(recipeId, output, inputs, Weather.RAIN);
        }

        @Nullable
        @Override
        public WeatherChangerRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buffer));
            }

            ItemStack output = buffer.readItem();
            return new WeatherChangerRecipe(recipeId, output, inputs, Weather.RAIN);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, WeatherChangerRecipe recipe) {
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ingredient: recipe.getIngredients()) {
                ingredient.toNetwork(buffer);
            }
            buffer.writeItemStack(recipe.getResultItem(), false);
        }
    }
}
