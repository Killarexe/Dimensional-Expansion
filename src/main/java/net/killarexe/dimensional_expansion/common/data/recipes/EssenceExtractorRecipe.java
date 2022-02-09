package net.killarexe.dimensional_expansion.common.data.recipes;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EssenceExtractorRecipe implements Recipe<Inventory> {

    private final Ingredient ingredient;
    private final ItemStack result;
    private final Identifier id;

    public EssenceExtractorRecipe(Identifier id, ItemStack result, Ingredient ingredient){
        this.id = id;
        this.result = result;
        this.ingredient = ingredient;
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        if(inventory.size() < 2){
            return false;
        }
        return ingredient.test(inventory.getStack(0));
    }

    @Override
    public ItemStack craft(Inventory inventory) {
        return this.getOutput().copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return this.getOutput().copy();
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public ItemStack getResult() {
        return result;
    }

    public static class Type implements RecipeType<EssenceExtractorRecipe>{
        private Type(){}
        public static final Type INSTANCE = new Type();
        public static final String ID = "essence_extractor_recipe";
    }

    public static class Serializer implements RecipeSerializer<EssenceExtractorRecipe>{

        @Override
        public EssenceExtractorRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(json.getAsJsonObject("output"));
            Ingredient input = Ingredient.fromJson(json.get("ingredients"));
            return new EssenceExtractorRecipe(id, output, input);
        }

        @Override
        public void write(PacketByteBuf buf, EssenceExtractorRecipe recipe) {
            buf.writeInt(1);
            recipe.getIngredient().write(buf);
            buf.writeItemStack(recipe.getResult());
        }

        @Override
        public EssenceExtractorRecipe read(Identifier id, PacketByteBuf buf) {
            Ingredient input = Ingredient.fromPacket(buf);
            ItemStack output = buf.readItemStack();
            return new EssenceExtractorRecipe(id, output, input);
        }
    }
}
