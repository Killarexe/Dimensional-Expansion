package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.data.recipes.EssenceExtractorRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DERecipeTypes {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, DEMod.MODID);

    public static final RegistryObject<EssenceExtractorRecipe.Serializer> ESSENCE_EXTRACTOR_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register(
            "essence_extractor", EssenceExtractorRecipe.Serializer::new);

    public static final RecipeType<EssenceExtractorRecipe> ESSENCE_EXTRACTOR_RECIPE_TYPE = new EssenceExtractorRecipe.EssenceExtractorRecipeType();

    public static void register(IEventBus bus){
        RECIPE_SERIALIZERS.register(bus);
        Registry.register(Registry.RECIPE_TYPE, EssenceExtractorRecipe.TYPE_ID, ESSENCE_EXTRACTOR_RECIPE_TYPE);
    }
}
