package net.killarexe.dimensional_expansion.client.integration.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.data.recipes.EssenceExtractorRecipe;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class EssenceExtractorRecipeCategory implements IRecipeCategory<EssenceExtractorRecipe> {

    public final static ResourceLocation UID = new ResourceLocation(DEMod.MODID, "essence_extractor");
    public final static ResourceLocation TEXTURE = new ResourceLocation(DEMod.MODID, "textures/gui/jei/essence_extractor_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public EssenceExtractorRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(DEBlocks.ESSENCE_EXTRACTOR.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends EssenceExtractorRecipe> getRecipeClass() {
        return EssenceExtractorRecipe.class;
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
    public void setRecipe(IRecipeLayoutBuilder builder, EssenceExtractorRecipe recipe, IFocusGroup focuses) {
        IRecipeCategory.super.setRecipe(builder, recipe, focuses);
    }
}
