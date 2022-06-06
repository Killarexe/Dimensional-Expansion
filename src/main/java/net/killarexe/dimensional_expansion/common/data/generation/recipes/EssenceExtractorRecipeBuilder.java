package net.killarexe.dimensional_expansion.common.data.generation.recipes;

import java.util.function.Consumer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.data.recipes.EssenceExtractorRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

public class EssenceExtractorRecipeBuilder implements RecipeBuilder{
	
	private final int count;
	private final Item output;
	private final Ingredient ingredient;
	private final Advancement.Builder advancement = Advancement.Builder.advancement();

	public EssenceExtractorRecipeBuilder(ItemLike ingredient, ItemLike output, int count){
		this.count = count;
		this.output = output.asItem();
		this.ingredient = Ingredient.of(ingredient);
	}
	
	@Override
	public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
		this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
		return this;
	}

	@Override
	public RecipeBuilder group(String pGroupName) {
		return this;
	}

	@Override
	public Item getResult() {
		return this.output;
	}

	@Override
	public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
		this.advancement.parent(new ResourceLocation("recipes/loot"))
			.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId))
			.rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);
		
		pFinishedRecipeConsumer.accept(new EssenceExtractorRecipeBuilder.Result(
				pRecipeId, this.output, this.count, this.ingredient, this.advancement,
				new ResourceLocation("recipes/" + this.output.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath())
		));
	}
	
	public static class Result implements FinishedRecipe{

		private final int count;
		private final Item output;
		private final Ingredient ingredient;
		private final Advancement.Builder advancement;
		@SuppressWarnings("unused")
		private final ResourceLocation id, advancementId;
		
		public Result(ResourceLocation id, Item output, int count, Ingredient ingredient,
				Advancement.Builder advancement, ResourceLocation advancementId) {
			this.id = id;
			this.output = output;
			this.count = count;
			this.ingredient = ingredient;
			this.advancement = advancement;
			this.advancementId = advancementId;
		}
		
		@Override
		public void serializeRecipeData(JsonObject pJson) {
			JsonArray jsonArray = new JsonArray();
			jsonArray.add(ingredient.toJson());
			
			pJson.add("ingredients", jsonArray);
			
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("item", this.output.getRegistryName().toString());
			if(this.count > 1) {
				jsonObject.addProperty("count", this.count);
			}
			pJson.add("output", jsonObject);
		}

		@Override
		public ResourceLocation getId() {
			return new ResourceLocation(DEMod.MODID, this.output.getRegistryName().getPath() + "_from_extractor");
		}

		@Override
		public RecipeSerializer<?> getType() {
			return EssenceExtractorRecipe.Serializer.INSTANCE;
		}

		@Override
		public JsonObject serializeAdvancement() {
			return this.advancement.serializeToJson();
		}

		@Override
		public ResourceLocation getAdvancementId() {
			return this.advancementId;
		}
	}

}
