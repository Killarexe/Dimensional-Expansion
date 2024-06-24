package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.entity.DEBoatEntity;
import net.killarexe.dimensional_expansion.common.entity.DEChestBoatEntity;
import net.killarexe.dimensional_expansion.common.item.*;
import net.killarexe.dimensional_expansion.common.item.BoatItem;
import net.killarexe.dimensional_expansion.common.item.material.*;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.renderer.item.CompassItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

public class DEItems {

	public static final HashMap<String, DECreativeTabs.Tabs> ITEM_TAB_MAP = new HashMap<>();
	
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, DEMod.MOD_ID);
    public static final Supplier<Item> RAW_PALON = createItem("raw_palon", DECreativeTabs.Tabs.MISC, false);
    public static final Supplier<Item> PALON_INGOT = createItem("palon_ingot", DECreativeTabs.Tabs.MISC, false);
    public static final Supplier<Item> PALON_NUGGET = createItem("palon_nugget", DECreativeTabs.Tabs.MISC, false);
    public static final DeferredHolder<Item, FuelItem> PALON_MIXED_COAL = createFuelItem("palon_mixed_coal", 3200, DECreativeTabs.Tabs.MISC, false);

    public static final Supplier<Item> BASSMITE_GEM = createItem("bassmite_gem", DECreativeTabs.Tabs.MISC, false);
    public static final DeferredHolder<Item, SwordItem> BASSMITE_SWORD = createSwordItem("bassmite_sword", DEItemTier.BASSMITE, DECreativeTabs.Tabs.COMBAT, false);
    public static final DeferredHolder<Item, PickaxeItem> BASSMITE_PICKAXE = createPickaxeItem("bassmite_pickaxe", DEItemTier.BASSMITE, DECreativeTabs.Tabs.TOOLS, false);
    public static final DeferredHolder<Item, AxeItem> BASSMITE_AXE = createAxeItem("bassmite_axe", DEItemTier.BASSMITE, DECreativeTabs.Tabs.COMBAT, false);
    public static final DeferredHolder<Item, ShovelItem> BASSMITE_SHOVEL = createShovelItem("bassmite_shovel", DEItemTier.BASSMITE, DECreativeTabs.Tabs.TOOLS, false);
    public static final DeferredHolder<Item, HoeItem> BASSMITE_HOE = createHoeItem("bassmite_hoe", DEItemTier.BASSMITE, DECreativeTabs.Tabs.TOOLS, false);
    public static final DeferredHolder<Item, ArmorItem> BASSMITE_HELMET = createArmorItem("bassmite_helmet", DEArmorMaterial.BASSMITE, ArmorItem.Type.HELMET, DECreativeTabs.Tabs.COMBAT, false);
    public static final DeferredHolder<Item, ArmorItem> BASSMITE_CHESTPLATE = createArmorItem("bassmite_chestplate", DEArmorMaterial.BASSMITE, ArmorItem.Type.CHESTPLATE, DECreativeTabs.Tabs.COMBAT, false);
    public static final DeferredHolder<Item, ArmorItem> BASSMITE_LEGGINGS = createArmorItem("bassmite_leggings", DEArmorMaterial.BASSMITE, ArmorItem.Type.LEGGINGS, DECreativeTabs.Tabs.COMBAT, false);
    public static final DeferredHolder<Item, ArmorItem> BASSMITE_BOOTS = createArmorItem("bassmite_boots", DEArmorMaterial.BASSMITE, ArmorItem.Type.BOOTS, DECreativeTabs.Tabs.COMBAT, false);
    public static final DeferredHolder<Item, AnimalArmorItem> BASSMITE_HORSE_ARMOR = createHorseArmorItem("bassmite_horse_armor", 10, "bassmite", DECreativeTabs.Tabs.COMBAT, false);
    public static final DeferredHolder<Item, FuelItem> BASSMITE_MIXED_COAL = createFuelItem("bassmite_mixed_coal", 6400, DECreativeTabs.Tabs.MISC, false);

    public static final Supplier<Item> RAW_SIMIX = createItem("raw_simix", DECreativeTabs.Tabs.MISC, true);
    public static final Supplier<Item> SIMIX_INGOT = createItem("simix_ingot", DECreativeTabs.Tabs.MISC, true);
    public static final Supplier<Item> SIMIX_NUGGET = createItem("simix_nugget", DECreativeTabs.Tabs.MISC, true);
    public static final DeferredHolder<Item, Item> SIMIX_HAMMER = createItem("simix_hammer", SimixHammerItem::new, DECreativeTabs.Tabs.TOOLS);
    public static final DeferredHolder<Item, FuelItem> SIMIX_MIXED_COAL = createFuelItem("simix_mixed_coal", 12800, DECreativeTabs.Tabs.MISC, true);

    public static final Supplier<Item> EMERTYST_GEM = createItem("emertyst_gem", DECreativeTabs.Tabs.MISC, true);
    public static final DeferredHolder<Item, SwordItem> EMERTYST_SWORD = createSwordItem("emertyst_sword", DEItemTier.EMERTYST, DECreativeTabs.Tabs.COMBAT, true);
    public static final DeferredHolder<Item, PickaxeItem> EMERTYST_PICKAXE = createPickaxeItem("emertyst_pickaxe", DEItemTier.EMERTYST, DECreativeTabs.Tabs.TOOLS, true);
    public static final DeferredHolder<Item, AxeItem> EMERTYST_AXE = createAxeItem("emertyst_axe", DEItemTier.EMERTYST, DECreativeTabs.Tabs.COMBAT, true);
    public static final DeferredHolder<Item, ShovelItem> EMERTYST_SHOVEL = createShovelItem("emertyst_shovel", DEItemTier.EMERTYST, DECreativeTabs.Tabs.TOOLS, true);
    public static final DeferredHolder<Item, HoeItem> EMERTYST_HOE = createHoeItem("emertyst_hoe", DEItemTier.EMERTYST, DECreativeTabs.Tabs.TOOLS, true);
    public static final DeferredHolder<Item, ArmorItem> EMERTYST_HELMET = createArmorItem("emertyst_helmet", DEArmorMaterial.EMERTYST, ArmorItem.Type.HELMET, DECreativeTabs.Tabs.COMBAT, true);
    public static final DeferredHolder<Item, ArmorItem> EMERTYST_CHESTPLATE = createArmorItem("emertyst_chestplate", DEArmorMaterial.EMERTYST, ArmorItem.Type.CHESTPLATE, DECreativeTabs.Tabs.COMBAT, true);
    public static final DeferredHolder<Item, ArmorItem> EMERTYST_LEGGINGS = createArmorItem("emertyst_leggings", DEArmorMaterial.EMERTYST, ArmorItem.Type.LEGGINGS, DECreativeTabs.Tabs.COMBAT, true);
    public static final DeferredHolder<Item, ArmorItem> EMERTYST_BOOTS = createArmorItem("emertyst_boots", DEArmorMaterial.EMERTYST, ArmorItem.Type.BOOTS, DECreativeTabs.Tabs.COMBAT, true);
    public static final DeferredHolder<Item, AnimalArmorItem> EMERTYST_HORSE_ARMOR = createHorseArmorItem("emertyst_horse_armor", 22, "emertyst", DECreativeTabs.Tabs.COMBAT, true);
    public static final DeferredHolder<Item, FuelItem> EMERTYST_MIXED_COAL = createFuelItem("emertyst_mixed_coal", 25600, DECreativeTabs.Tabs.MISC, true);

    public static final DeferredHolder<Item, PurpleBerry> PURPLE_BERRY = createItem("purple_berry", PurpleBerry::new, DECreativeTabs.Tabs.MISC);
    public static final DeferredHolder<Item, SavorleafItem> SAVORLEAF = createItem("savorleaf", SavorleafItem::new, DECreativeTabs.Tabs.MISC);
    public static final DeferredHolder<Item, VioletCarrot> VIOLET_CARROT = createItem("violet_carrot", VioletCarrot::new, DECreativeTabs.Tabs.MISC);
    public static final DeferredHolder<Item, Item> COORD_LINKER = createItem("coord_linker", CoordLinker::new, DECreativeTabs.Tabs.MISC);

    public static final DeferredHolder<Item, Item> ORIGIN_PORTAL_KEY = createItem("origin_portal_key", OriginPortalKey::new, DECreativeTabs.Tabs.TOOLS);
    
    public static final DeferredHolder<Item, Item> PURPLEHEART_SIGN = createItem("purpleheart_sign", () -> new SignItem(new Item.Properties().stacksTo(16), DEBlocks.PURPLEHEART_SIGN.get(), DEBlocks.PURPLEHEART_WALL_SIGN.get()), DECreativeTabs.Tabs.BLOCKS);
    public static final DeferredHolder<Item, Item> PURPLEHEART_BOAT = createItem("purpleheart_boat", () -> new BoatItem(new Item.Properties().stacksTo(1).fireResistant(), DEBoatEntity.Type.PURPLEHEART), DECreativeTabs.Tabs.MISC);
    public static final DeferredHolder<Item, Item> PURPLEHEART_CHEST_BOAT = createItem("purpleheart_chest_boat", () -> new ChestBoatItem(new Item.Properties().stacksTo(1).fireResistant(), DEChestBoatEntity.Type.PURPLEHEART), DECreativeTabs.Tabs.MISC);
    
    public static final DeferredHolder<Item, Item> SWEDEN_DISC = createDiscItem("sweden_disc", DEJukeboxSongs.SWEDEN_REMIX.getB(), DECreativeTabs.Tabs.MISC, 0);

    public static final DeferredHolder<Item, DeferredSpawnEggItem> HEADED_SKELETON_SPAWN_EGG = createSpawnEggItem("headed_skeleton_spawn_egg", DEEntityTypes.HEADED_SKELETON, 0xFFFFFF, 0xFFFFFF, DECreativeTabs.Tabs.MOBS);
    public static final DeferredHolder<Item, DeferredSpawnEggItem> HEADED_GUARDIAN_SPAWN_EGG = createSpawnEggItem("headed_guardian_spawn_egg", DEEntityTypes.HEADED_GUARDIAN, 0xFFFFFF, 0xFFFFFF, DECreativeTabs.Tabs.MOBS);
    public static final DeferredHolder<Item, DeferredSpawnEggItem> BLUE_SAND_MAN_SPAWN_EGG = createSpawnEggItem("blue_sand_man_spawn_egg", DEEntityTypes.BLUE_SAND_MAN, 0xFFFFFF, 0xFFFFFF, DECreativeTabs.Tabs.MOBS);
    public static final DeferredHolder<Item, DeferredSpawnEggItem> MOUVET_SPAWN_EGG = createSpawnEggItem("mouvet_spawn_egg", DEEntityTypes.MOUVET, 0xFFFFFF, 0xFFFFFF, DECreativeTabs.Tabs.MOBS);
    public static final DeferredHolder<Item, DeferredSpawnEggItem> JUGER_SPAWN_EGG = createSpawnEggItem("juger_spawn_egg", DEEntityTypes.JUGER, 0xFFFFFF, 0xFFFFFF, DECreativeTabs.Tabs.MOBS);
    
    public static final DeferredHolder<Item, MoboxItem> MOBOX = createItem("mobox", MoboxItem::new, DECreativeTabs.Tabs.MISC);

    public static final DeferredHolder<Item, SmithingTemplateItem> BASSMITE_UPGRADE_SMITHING_TEMPLATE = createSmithingTransformItem("bassmite_upgrade_smithing_template", "bassmite", DECreativeTabs.Tabs.MISC);

    public static final DeferredHolder<Item, SmithingTemplateItem> EMERTYST_UPGRADE_SMITHING_TEMPLATE = createSmithingTransformItem("emertyst_upgrade_smithing_template", "emertyst", DECreativeTabs.Tabs.MISC);

    public static <T extends Item> DeferredHolder<Item, T> createItem(String id, Supplier<T> item){
    	return ITEMS.register(id, item);
    }
    
    public static <T extends Item> DeferredHolder<Item, T> createItem(String id, Supplier<T> item, DECreativeTabs.Tabs tab){
    	ITEM_TAB_MAP.put(id, tab);
    	return ITEMS.register(id, item);
    }
    
    private static Supplier<Item> createItem(String id, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof){
            return ITEMS.register(id, () -> new Item(new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new Item(new Item.Properties()));
    }

    private static DeferredHolder<Item, FuelItem> createFuelItem(String id, int burnTime, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof){
            return ITEMS.register(id, () -> new FuelItem(new Item.Properties().fireResistant(), burnTime));
        }
        return ITEMS.register(id, () -> new FuelItem(new Item.Properties(), burnTime));
    }

    @SuppressWarnings("unused")
	private static DeferredHolder<Item, Item> createFoodItem(String id, float staturation, int nutrition, Holder<MobEffect> effect, int level, int duration, float probability, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof){
            return ITEMS.register(id, () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationModifier(staturation).alwaysEdible().nutrition(nutrition).effect(() ->  new MobEffectInstance(effect, level, duration), probability).build()).fireResistant()));
        }
        return ITEMS.register(id, () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationModifier(staturation).alwaysEdible().nutrition(nutrition).effect(() ->  new MobEffectInstance(effect, level, duration), probability).build())));
    }

    private static DeferredHolder<Item, SwordItem> createSwordItem(String id, Tier tier, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new SwordItem(tier, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new SwordItem(tier, new Item.Properties()));
    }

    private static DeferredHolder<Item, PickaxeItem> createPickaxeItem(String id, Tier tier, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new PickaxeItem(tier, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new PickaxeItem(tier, new Item.Properties()));
    }

    private static DeferredHolder<Item, AxeItem> createAxeItem(String id, Tier tier, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new AxeItem(tier, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new AxeItem(tier, new Item.Properties()));
    }

    private static DeferredHolder<Item, ShovelItem> createShovelItem(String id, Tier tier, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new ShovelItem(tier, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new ShovelItem(tier, new Item.Properties()));
    }

    private static DeferredHolder<Item, HoeItem> createHoeItem(String id, Tier tier, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new HoeItem(tier, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new HoeItem(tier, new Item.Properties()));
    }

    private static DeferredHolder<Item, ArmorItem> createArmorItem(String id, Holder<ArmorMaterial> material, ArmorItem.Type slot, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new ArmorItem(material, slot, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new ArmorItem(material, slot, new Item.Properties()));
    }

    private static Supplier<Item> createDiscItem(String id, ResourceKey<JukeboxSong> music, DECreativeTabs.Tabs tab){
        ITEM_TAB_MAP.put(id, tab);
        return ITEMS.register(id, () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(music)));
    }

    private static DeferredHolder<Item, AnimalArmorItem> createHorseArmorItem(String id, Holder<ArmorMaterial> material, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new AnimalArmorItem(material, AnimalArmorItem.BodyType.EQUESTRIAN, false, new Item.Properties().fireResistant()));
        }
    	return ITEMS.register(id, () -> new AnimalArmorItem(material, AnimalArmorItem.BodyType.EQUESTRIAN, false, new Item.Properties()));
    }
    
    private static DeferredHolder<Item, DeferredSpawnEggItem> createSpawnEggItem(String id, DeferredHolder<EntityType<?>, ? extends EntityType<? extends Mob>> entityType, int backgroundColor, int forgroundColor, DECreativeTabs.Tabs tab){
    	return createItem(id, () -> new DeferredSpawnEggItem(entityType, backgroundColor, forgroundColor, new Item.Properties()), tab);
    }

    private static DeferredHolder<Item, SmithingTemplateItem> createSmithingTransformItem(String id, String baseItemId, DECreativeTabs.Tabs tab) {
        return createItem(id, () -> new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", DEMod.res( "smithing_template." + baseItemId + "_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", DEMod.res("smithing_template." + baseItemId + "_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("upgrade", DEMod.res(baseItemId + "_upgrade"))).withStyle(ChatFormatting.GRAY),
                Component.translatable(Util.makeDescriptionId("item", DEMod.res("smithing_template." + baseItemId + "_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", DEMod.res("smithing_template." + baseItemId + "_upgrade.additions_slot_description"))),
                List.of(
                        ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet"),
                        ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate"),
                        ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings"),
                        ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots"),
                        ResourceLocation.withDefaultNamespace("item/empty_slot_sword"),
                        ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe"),
                        ResourceLocation.withDefaultNamespace("item/empty_slot_axe"),
                        ResourceLocation.withDefaultNamespace("item/empty_slot_shovel"),
                        ResourceLocation.withDefaultNamespace("item/empty_slot_hoe")
                ),
                List.of(DEMod.res( "item/empty_slot_" + baseItemId))
        ), tab);
    }

    @OnlyIn(Dist.CLIENT)
    public static void addItemsProperties(){
        addCompassProperties(COORD_LINKER.get());
    }
    
    @OnlyIn(Dist.CLIENT)
    private static void addCompassProperties(Item item) {
    	ItemProperties.register(
    			item,
    			ResourceLocation.withDefaultNamespace("angle"),
    			new CompassItemPropertyFunction((level, itemStack, entity) -> CompassItem.getSpawnPosition(level))
    	);
    }

}
