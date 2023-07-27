package net.killarexe.dimensional_expansion.common.data.generation.client.advancement;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.killarexe.dimensional_expansion.init.DEDimensions;
import net.killarexe.dimensional_expansion.init.DEItems;
import net.killarexe.dimensional_expansion.init.DEStructures;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ChangeDimensionTrigger;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider.AdvancementGenerator;

public class DEAdvancementGenerator implements AdvancementGenerator{

	@Override
	public void generate(Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
		Advancement root = createRootAdvancement(
				DEBlocks.ORIGIN_GRASS_BLOCK.get(),
				new ResourceLocation(DEMod.MOD_ID, "textures/block/palon_block.png"),
				"dimensional_expansion",
				FrameType.TASK,
				false,
				saver,
				existingFileHelper
		);
		
		Advancement the_palon = createAdvancement(
				DEItems.PALON_INGOT.get(),
				"the_palon",
				FrameType.TASK,
				root,
				false,
				saver,
				existingFileHelper
		);
		
		Advancement bassmite = createAdvancement(
				DEItems.BASSMITE_GEM.get(),
				"bassmite",
				FrameType.TASK,
				the_palon,
				false,
				saver, 
				existingFileHelper
		);
		
		Advancement simix = createAdvancement(
				DEItems.SIMIX_INGOT.get(),
				"simix",
				FrameType.TASK,
				bassmite,
				false,
				saver,
				existingFileHelper
		);
		
		Advancement emertyst = createAdvancement(
				DEItems.EMERTYST_GEM.get(),
				"emertyst",
				FrameType.TASK,
				simix,
				false,
				saver,
				existingFileHelper
		);
		
		Advancement the_origin = createPreAdvancement(
				DEBlocks.ORIGIN_GRASS_BLOCK.get(),
				"the_origin",
				FrameType.TASK,
				root,
				false
		).addCriterion("is_in_dimension", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DEDimensions.ORIGIN))
		.save(saver, new ResourceLocation(DEMod.MOD_ID, "the_origin"), existingFileHelper);
		
		createPreAdvancement(
				DEBlocks.PURPLEHEART_LOG.get(),
				"purpleheart_wood",
				FrameType.TASK,
				the_origin,
				false
		).addCriterion("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(DEBlocks.PURPLEHEART_LOG.get()))
		.save(saver, new ResourceLocation(DEMod.MOD_ID, "purpleheart_wood"), existingFileHelper);
		
		createPreAdvancement(
				DEItems.EMERTYST_CHESTPLATE.get(),
				"cover_me_with_emertyst",
				FrameType.CHALLENGE,
				emertyst,
				false
		).rewards(AdvancementRewards.Builder.experience(50))
		.addCriterion("full_armor", InventoryChangeTrigger.TriggerInstance.hasItems(
				DEItems.EMERTYST_HELMET.get(),
				DEItems.EMERTYST_CHESTPLATE.get(),
				DEItems.EMERTYST_LEGGINGS.get(),
				DEItems.EMERTYST_BOOTS.get())
		).save(saver, new ResourceLocation(DEMod.MOD_ID, "cover_me_with_emertyst"), existingFileHelper);
		
		createPreAdvancement(
				DEItems.WARP_POWER_STONE.get(),
				"power_stones",
				FrameType.CHALLENGE,
				emertyst,
				false
		).rewards(AdvancementRewards.Builder.experience(100))
		.addCriterion("warp", InventoryChangeTrigger.TriggerInstance.hasItems(
				DEItems.WARP_POWER_STONE.get()
		)).addCriterion("time", InventoryChangeTrigger.TriggerInstance.hasItems(
				DEItems.TIME_POWER_STONE.get()
		)).addCriterion("remote", InventoryChangeTrigger.TriggerInstance.hasItems(
				DEItems.REMOTE_POWER_STONE.get()
		)).addCriterion("weather", InventoryChangeTrigger.TriggerInstance.hasItems(
				DEItems.WEATHER_POWER_STONE.get()
		)).save(saver, new ResourceLocation(DEMod.MOD_ID, "power_stones"), existingFileHelper);
		
		createPreAdvancement(
				DEItems.ORIGIN_PORTAL_KEY.get(),
				"origin_abandonned_portal",
				FrameType.GOAL,
				root,
				false)
		.addCriterion(
				"in_structure",
				PlayerTrigger.TriggerInstance.located(
						LocationPredicate.inStructure(DEStructures.ABANDONNED_PORTAL)
				)
		).save(saver, new ResourceLocation(DEMod.MOD_ID, "origin_abandonned_portal"), existingFileHelper);
		
		createPreAdvancement(
				DEBlocks.PURPLEHEART_SAPLING.get(),
				"village_origin_plains",
				FrameType.GOAL,
				the_origin,
				false)
		.addCriterion(
				"in_structure",
				PlayerTrigger.TriggerInstance.located(
						LocationPredicate.inStructure(DEStructures.VILLAGE_ORIGIN_PLAINS)
				)
		).save(saver, new ResourceLocation(DEMod.MOD_ID, "village_origin_plains"), existingFileHelper);
	}

	private Advancement createAdvancement(ItemLike icon, String name, FrameType type, Advancement parent, boolean hidden, Consumer<Advancement> saver, ExistingFileHelper helper) {
		return createPreAdvancement(icon, name, type, parent, hidden)
				.addCriterion("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(icon))
				.save(saver, new ResourceLocation(DEMod.MOD_ID, name), helper);
	}
	
	private Advancement.Builder createPreAdvancement(ItemLike icon, String name, FrameType type, Advancement parent, boolean hidden) {
		return Advancement.Builder.advancement()
				.display(
					icon,
					Component.translatable("advancement." + DEMod.MOD_ID + "." + name + ".title"),
					Component.translatable("advancement." + DEMod.MOD_ID + "." + name + ".desc"),
					null,
					type,
					true,
					true,
					hidden
				).parent(parent);
	}
	
	private Advancement createRootAdvancement(ItemLike icon, @Nullable ResourceLocation bkg, String name, FrameType type, boolean hidden, Consumer<Advancement> saver, ExistingFileHelper helper) {
		return Advancement.Builder.advancement()
				.display(
					icon,
					Component.translatable("advancement." + DEMod.MOD_ID + "." + name + ".title"),
					Component.translatable("advancement." + DEMod.MOD_ID + "." + name + ".desc"),
					bkg,
					type,
					true,
					true,
					hidden
				).addCriterion("tick", new PlayerTrigger.TriggerInstance(CriteriaTriggers.TICK.getId(), ContextAwarePredicate.ANY)).save(saver, new ResourceLocation(DEMod.MOD_ID, name), helper);
	}
	
	/*private AdvancementRewards unlockRecipes(String... names) {
		AdvancementRewards.Builder builder = new AdvancementRewards.Builder();
		for(String id: names) {
			builder.addRecipe(new ResourceLocation(DEMod.MOD_ID, id));
		}
		return builder.build();
	}*/
}
