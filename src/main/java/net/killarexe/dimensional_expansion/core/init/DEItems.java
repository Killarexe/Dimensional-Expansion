package net.killarexe.dimensional_expansion.core.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.item.*;
import net.killarexe.dimensional_expansion.common.item.material.*;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BannerPattern;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DEItems {

    public static final Item RAW_PALON = createItem("raw_palon", DEItemGroups.MISC, true);
    public static final Item PALON_INGOT = createItem("palon_ingot", DEItemGroups.MISC, true);
    public static final Item PALON_NUGGET = createItem("palon_nugget", DEItemGroups.MISC, true);
    public static final Item PALON_SWORD = createSwordItem("palon_sword", DEItemToolMaterial.PALON, 3, DEItemGroups.COMBAT);
    public static final Item PALON_PICKAXE = createPickaxeItem("palon_pickaxe", DEItemToolMaterial.PALON, 6, DEItemGroups.TOOLS);
    public static final Item PALON_AXE = createAxeItem("palon_axe", DEItemToolMaterial.PALON, 6, DEItemGroups.COMBAT);
    public static final Item PALON_SHOVEL = createShovelItem("palon_shovel", DEItemToolMaterial.PALON, 1.5f, DEItemGroups.TOOLS);
    public static final Item PALON_HOE = createHoeItem("palon_hoe", DEItemToolMaterial.PALON, 0, DEItemGroups.TOOLS);
    public static final Item PALON_HELMET = createArmorItem("palon_helmet", DEArmorMaterial.PALON, EquipmentSlot.HEAD, DEItemGroups.COMBAT);
    public static final Item PALON_CHESTPLATE = createArmorItem("palon_chestplate", DEArmorMaterial.PALON, EquipmentSlot.CHEST, DEItemGroups.COMBAT);
    public static final Item PALON_LEGGINGS = createArmorItem("palon_leggings", DEArmorMaterial.PALON, EquipmentSlot.LEGS, DEItemGroups.COMBAT);
    public static final Item PALON_BOOTS = createArmorItem("palon_boots", DEArmorMaterial.PALON, EquipmentSlot.FEET, DEItemGroups.COMBAT);
    public static final Item PALON_HORSE_ARMOR = createHorseArmorItem("palon_horse_armor", 6, "palon", DEItemGroups.COMBAT);
    public static final Item PALON_MIXED_COAL = createItem("palon_mixed_coal", DEItemGroups.MISC, true);

    public static final Item BASSMITE_GEM = createItem("bassmite_gem", DEItemGroups.MISC, true);
    public static final Item BASSMITE_SWORD = createSwordItem("bassmite_sword", DEItemToolMaterial.BASSMITE, 3, DEItemGroups.COMBAT);
    public static final Item BASSMITE_PICKAXE = createPickaxeItem("bassmite_pickaxe", DEItemToolMaterial.BASSMITE, 6, DEItemGroups.TOOLS);
    public static final Item BASSMITE_AXE = createAxeItem("bassmite_axe", DEItemToolMaterial.BASSMITE, 6, DEItemGroups.COMBAT);
    public static final Item BASSMITE_SHOVEL = createShovelItem("bassmite_shovel", DEItemToolMaterial.BASSMITE, 1.5f, DEItemGroups.TOOLS);
    public static final Item BASSMITE_HOE = createHoeItem("bassmite_hoe", DEItemToolMaterial.BASSMITE, 0, DEItemGroups.TOOLS);
    public static final Item BASSMITE_HELMET = createArmorItem("bassmite_helmet", DEArmorMaterial.BASSMITE, EquipmentSlot.HEAD, DEItemGroups.COMBAT);
    public static final Item BASSMITE_CHESTPLATE = createArmorItem("bassmite_chestplate", DEArmorMaterial.BASSMITE, EquipmentSlot.CHEST, DEItemGroups.COMBAT);
    public static final Item BASSMITE_LEGGINGS = createArmorItem("bassmite_leggings", DEArmorMaterial.BASSMITE, EquipmentSlot.LEGS, DEItemGroups.COMBAT);
    public static final Item BASSMITE_BOOTS = createArmorItem("bassmite_boots", DEArmorMaterial.BASSMITE, EquipmentSlot.FEET, DEItemGroups.COMBAT);
    public static final Item BASSMITE_HORSE_ARMOR = createHorseArmorItem("bassmite_horse_armor", 10, "bassmite", DEItemGroups.COMBAT);
    public static final Item BASSMITE_MIXED_COAL = createItem("bassmite_mixed_coal", DEItemGroups.MISC, true);

    public static final Item RAW_SIMIX = createItem("raw_simix", DEItemGroups.MISC, true);
    public static final Item SIMIX_INGOT = createItem("simix_ingot", DEItemGroups.MISC, true);
    public static final Item SIMIX_NUGGET = createItem("simix_nugget", DEItemGroups.MISC, true);
    public static final Item SIMIX_SWORD = createSwordItem("simix_sword", DEItemToolMaterial.SIMIX, 3, DEItemGroups.COMBAT);
    public static final Item SIMIX_PICKAXE = createPickaxeItem("simix_pickaxe", DEItemToolMaterial.SIMIX, 6, DEItemGroups.TOOLS);
    public static final Item SIMIX_AXE = createAxeItem("simix_axe", DEItemToolMaterial.SIMIX, 6, DEItemGroups.COMBAT);
    public static final Item SIMIX_SHOVEL = createShovelItem("simix_shovel", DEItemToolMaterial.SIMIX, 1.5f, DEItemGroups.TOOLS);
    public static final Item SIMIX_HOE = createHoeItem("simix_hoe", DEItemToolMaterial.SIMIX, 0, DEItemGroups.TOOLS);
    public static final Item SIMIX_HELMET = createArmorItem("simix_helmet", DEArmorMaterial.SIMIX, EquipmentSlot.HEAD, DEItemGroups.COMBAT);
    public static final Item SIMIX_CHESTPLATE = createArmorItem("simix_chestplate", DEArmorMaterial.SIMIX, EquipmentSlot.CHEST, DEItemGroups.COMBAT);
    public static final Item SIMIX_LEGGINGS = createArmorItem("simix_leggings", DEArmorMaterial.SIMIX, EquipmentSlot.LEGS, DEItemGroups.COMBAT);
    public static final Item SIMIX_BOOTS = createArmorItem("simix_boots", DEArmorMaterial.SIMIX, EquipmentSlot.FEET, DEItemGroups.COMBAT);
    public static final Item SIMIX_HORSE_ARMOR = createHorseArmorItem("simix_horse_armor", 14, "simix", DEItemGroups.COMBAT);
    public static final Item SIMIX_MIXED_COAL = createItem("simix_mixed_coal", DEItemGroups.MISC, true);

    public static final Item EMERTYST_GEM = createItem("emertyst_gem", DEItemGroups.MISC, true);
    public static final Item EMERTYST_SWORD = createSwordItem("emertyst_sword", DEItemToolMaterial.EMERTYST, 3, DEItemGroups.COMBAT);
    public static final Item EMERTYST_PICKAXE = createPickaxeItem("emertyst_pickaxe", DEItemToolMaterial.EMERTYST, 6, DEItemGroups.TOOLS);
    public static final Item EMERTYST_AXE = createAxeItem("emertyst_axe", DEItemToolMaterial.EMERTYST, 6, DEItemGroups.COMBAT);
    public static final Item EMERTYST_SHOVEL = createShovelItem("emertyst_shovel", DEItemToolMaterial.EMERTYST, 1.5f, DEItemGroups.TOOLS);
    public static final Item EMERTYST_HOE = createHoeItem("emertyst_hoe", DEItemToolMaterial.EMERTYST, 0, DEItemGroups.TOOLS);
    public static final Item EMERTYST_HELMET = createArmorItem("emertyst_helmet", DEArmorMaterial.EMERTYST, EquipmentSlot.HEAD, DEItemGroups.COMBAT);
    public static final Item EMERTYST_CHESTPLATE = createArmorItem("emertyst_chestplate", DEArmorMaterial.EMERTYST, EquipmentSlot.CHEST, DEItemGroups.COMBAT);
    public static final Item EMERTYST_LEGGINGS = createArmorItem("emertyst_leggings", DEArmorMaterial.EMERTYST, EquipmentSlot.LEGS, DEItemGroups.COMBAT);
    public static final Item EMERTYST_BOOTS = createArmorItem("emertyst_boots", DEArmorMaterial.EMERTYST, EquipmentSlot.FEET, DEItemGroups.COMBAT);
    public static final Item EMERTYST_HORSE_ARMOR = createHorseArmorItem("emertyst_horse_armor", 22, "emertyst", DEItemGroups.COMBAT);
    public static final Item EMERTYST_MIXED_COAL = createItem("emertyst_mixed_coal", DEItemGroups.MISC, true);

    public static void registerItems(){
        DEMod.LOGGER.info("Register Dimensional Expansion Items!");
        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(PALON_MIXED_COAL, 3200);
        registry.add(BASSMITE_MIXED_COAL, 6400);
        registry.add(SIMIX_MIXED_COAL, 12800);
        registry.add(EMERTYST_MIXED_COAL, 25600);
    }

    private static Item createItem(String id, ItemGroup group, boolean isFireProof){
        if(isFireProof){
            return Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new Item(new FabricItemSettings().group(group).fireproof()));
        }
        return Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new Item(new FabricItemSettings().group(group)));
    }

    private static Item createFoodItem(String id, float staturation, int nutrition, StatusEffect effect, int level, int duration, float probability, ItemGroup itemGroup, boolean isFireProof){
        if(isFireProof){
            return Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new Item(new FabricItemSettings().group(itemGroup).food(new FoodComponent.Builder().saturationModifier(staturation).hunger(nutrition).statusEffect( new StatusEffectInstance(effect, level, duration), probability).build()).fireproof()));
        }
        return Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new Item(new FabricItemSettings().group(itemGroup).food(new FoodComponent.Builder().saturationModifier(staturation).hunger(nutrition).statusEffect( new StatusEffectInstance(effect, level, duration), probability).build())));
    }

    private static Item createSwordItem(String id, ToolMaterial ToolMaterial, int level, ItemGroup itemGroup){
        return Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new SwordItem(ToolMaterial, level, -2.4F, new FabricItemSettings().group(itemGroup).fireproof()));
    }

    private static Item createPickaxeItem(String id, ToolMaterial ToolMaterial, int level, ItemGroup itemGroup){
        return Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new DEPickaxeItem(ToolMaterial, level, -2.8F, new FabricItemSettings().group(itemGroup).fireproof()));
    }

    private static Item createAxeItem(String id, ToolMaterial ToolMaterial, float level, ItemGroup itemGroup){
        return Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new DEAxeItem(ToolMaterial, level, -3.2F, new FabricItemSettings().group(itemGroup).fireproof()));
    }

    private static Item createShovelItem(String id, ToolMaterial ToolMaterial, float level, ItemGroup itemGroup){
        return Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new ShovelItem(ToolMaterial, level, -3F, new FabricItemSettings().group(itemGroup).fireproof()));
    }

    private static Item createHoeItem(String id, ToolMaterial ToolMaterial, int level, ItemGroup itemGroup){
        return Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new DEHoeItem(ToolMaterial, level, -3F, new FabricItemSettings().group(itemGroup).fireproof()));
    }

    private static Item createArmorItem(String id, ArmorMaterial material, EquipmentSlot slot, ItemGroup itemGroup){
        return Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new ArmorItem(material, slot, new FabricItemSettings().group(itemGroup).fireproof()));
    }

    private static Item createDiscItem(String id, int comparatorValue, SoundEvent sound, ItemGroup itemGroup){
        return Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new DEMusicDiscItem(comparatorValue, sound, new FabricItemSettings().group(itemGroup).maxCount(1)));
    }

    private static Item createHorseArmorItem(String id, int armorValue, String ToolMaterialID, ItemGroup itemGroup){
        return Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new HorseArmorItem(armorValue, ToolMaterialID,  new FabricItemSettings().group(itemGroup)));
    }

    private static Item createCustomItem(String id, Item item){
        return Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), item);
    }

    private static Item createBlockItem(String id, Block block, ItemGroup itemGroup){
        return Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BlockItem(block, new FabricItemSettings().group(itemGroup)));
    }

    private static Item createBannerPatternItem(String id, BannerPattern pattern, ItemGroup itemGroup){
        return Registry.register(Registry.ITEM, new Identifier(DEMod.MODID, id), new BannerPatternItem(pattern, new FabricItemSettings().group(itemGroup)));
    }

}
