package net.killarexe.dimensional_expansion.common.data.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.killarexe.dimensional_expansion.core.init.DERecipeTypes;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class EssenceExtractorRecipe implements Recipe<SimpleContainer> {

    public static final ResourceLocation TYPE_ID = new ResourceLocation(DEMod.MOD_ID, "essence_extractor");
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public EssenceExtractorRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        return recipeItems.get(0).test(container.getItem(0));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public ItemStack assemble(SimpleContainer container) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
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
        return DERecipeTypes.ESSENCE_EXTRACTOR_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public ItemStack getIcon(){
        return new ItemStack(DEBlocks.ESSENCE_EXTRACTOR.get());
    }

    public NonNullList<Ingredient> getRecipeItems() {
        return recipeItems;
    }

    public static class Type implements RecipeType<EssenceExtractorRecipe> {
        private Type(){}
        public static final Type INSTANCE = new Type();
        public static final String ID = TYPE_ID.toString();
        @Override
        public String toString() {
            return ID;
        }
    }

    public static class Serializer implements RecipeSerializer<EssenceExtractorRecipe>{

        public static final Serializer INSTANCE = new Serializer();

        @Override
        public EssenceExtractorRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output"));
            JsonArray ingredients = GsonHelper.getAsJsonArray(jsonObject, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new EssenceExtractorRecipe(resourceLocation, output, inputs);
        }

        @Nullable
        @Override
        public EssenceExtractorRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(friendlyByteBuf));
            }

            ItemStack output = friendlyByteBuf.readItem();
            return new EssenceExtractorRecipe(resourceLocation, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, EssenceExtractorRecipe essenceExtractorRecipe) {
            friendlyByteBuf.writeInt(essenceExtractorRecipe.getIngredients().size());
            for (Ingredient ing : essenceExtractorRecipe.getIngredients()) {
                ing.toNetwork(friendlyByteBuf);
            }
            friendlyByteBuf.writeItemStack(essenceExtractorRecipe.getResultItem(), false);
        }
    }
}
