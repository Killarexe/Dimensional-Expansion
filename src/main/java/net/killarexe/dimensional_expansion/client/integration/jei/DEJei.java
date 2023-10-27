package net.killarexe.dimensional_expansion.client.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class DEJei implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(DEMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
    }

	@Override
    public void registerRecipes(IRecipeRegistration registration) {
    }
}
