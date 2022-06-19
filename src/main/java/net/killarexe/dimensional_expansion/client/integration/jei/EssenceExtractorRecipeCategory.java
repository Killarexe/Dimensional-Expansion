package net.killarexe.dimensional_expansion.client.integration.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.data.recipes.EssenceExtractorRecipe;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class EssenceExtractorRecipeCategory implements IRecipeCategory<EssenceExtractorRecipe> {

    public final static ResourceLocation UID = new ResourceLocation(DEMod.MOD_ID, "essence_extractor");
    public final static ResourceLocation TEXTURE = new ResourceLocation(DEMod.MOD_ID, "textures/gui/jei/essence_extractor_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public EssenceExtractorRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(DEBlocks.ESSENCE_EXTRACTOR.get()));
    }

    @Override
    public Component getTitle() {
        return DEBlocks.ESSENCE_EXTRACTOR.get().getName();
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public RecipeType<EssenceExtractorRecipe> getRecipeType() {
        return new mezz.jei.api.recipe.RecipeType<>(UID, EssenceExtractorRecipe.class);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, EssenceExtractorRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 35).addIngredients(VanillaTypes.ITEM_STACK, List.of(recipe.getIngredients().get(0).getItems()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 35).addItemStack(recipe.getResultItem());
    }

    public ResourceLocation getUid() {
        return UID;
    }
}
