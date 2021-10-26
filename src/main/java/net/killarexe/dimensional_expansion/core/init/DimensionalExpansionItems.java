package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DimensionalExpansionMod;
import net.killarexe.dimensional_expansion.common.material.CustomArmorMaterial;
import net.killarexe.dimensional_expansion.common.material.CustomItemTier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.*;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.*;

public class DimensionalExpansionItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DimensionalExpansionMod.MODID);

    public static final RegistryObject<Item> RAW_PALON = createItem("raw_palon", DimensionalExpansionItemGroups.MISC);
    public static final RegistryObject<Item> PALON_INGOT = createItem("palon_ingot", DimensionalExpansionItemGroups.MISC);
    public static final RegistryObject<Item> PALON_SWORD = createSwordItem("palon_sword", CustomItemTier.PALON, 3, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_PICKAXE = createPickaxeItem("palon_pickaxe", CustomItemTier.PALON, 6, DimensionalExpansionItemGroups.TOOLS);
    public static final RegistryObject<Item> PALON_AXE = createAxeItem("palon_axe", CustomItemTier.PALON, 6, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_SHOVEL = createShovelItem("palon_shovel", CustomItemTier.PALON, 1.5f, DimensionalExpansionItemGroups.TOOLS);
    public static final RegistryObject<Item> PALON_HOE = createHoeItem("palon_hoe", CustomItemTier.PALON, 0, DimensionalExpansionItemGroups.TOOLS);
    public static final RegistryObject<Item> PALON_HELMET = createArmorItem("palon_helmet", CustomArmorMaterial.PALON, EquipmentSlot.HEAD, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_CHESTPLATE = createArmorItem("palon_chestplate", CustomArmorMaterial.PALON, EquipmentSlot.CHEST, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_LEGGINGS = createArmorItem("palon_leggings", CustomArmorMaterial.PALON, EquipmentSlot.LEGS, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_BOOTS = createArmorItem("palon_boots", CustomArmorMaterial.PALON, EquipmentSlot.FEET, DimensionalExpansionItemGroups.COMBAT);

    public static final RegistryObject<Item> BASSMITE_GEM = createItem("bassmite_gem", DimensionalExpansionItemGroups.MISC);
    public static final RegistryObject<Item> BASSMITE_SWORD = createSwordItem("bassmite_sword", CustomItemTier.BASSMITE, 3, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_PICKAXE = createPickaxeItem("bassmite_pickaxe", CustomItemTier.BASSMITE, 6, DimensionalExpansionItemGroups.TOOLS);
    public static final RegistryObject<Item> BASSMITE_AXE = createAxeItem("bassmite_axe", CustomItemTier.BASSMITE, 6, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_SHOVEL = createShovelItem("bassmite_shovel", CustomItemTier.BASSMITE, 1.5f, DimensionalExpansionItemGroups.TOOLS);
    public static final RegistryObject<Item> BASSMITE_HOE = createHoeItem("bassmite_hoe", CustomItemTier.BASSMITE, 0, DimensionalExpansionItemGroups.TOOLS);
    public static final RegistryObject<Item> BASSMITE_HELMET = createArmorItem("bassmite_helmet", CustomArmorMaterial.BASSMITE, EquipmentSlot.HEAD, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_CHESTPLATE = createArmorItem("bassmite_chestplate", CustomArmorMaterial.BASSMITE, EquipmentSlot.CHEST, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_LEGGINGS = createArmorItem("bassmite_leggings", CustomArmorMaterial.BASSMITE, EquipmentSlot.LEGS, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_BOOTS = createArmorItem("bassmite_boots", CustomArmorMaterial.BASSMITE, EquipmentSlot.FEET, DimensionalExpansionItemGroups.COMBAT);

    public static final RegistryObject<Item> RAW_SIMIX = createItem("raw_simix", DimensionalExpansionItemGroups.MISC);
    public static final RegistryObject<Item> SIMIX_INGOT = createItem("simix_ingot", DimensionalExpansionItemGroups.MISC);
    public static final RegistryObject<Item> SIMIX_SWORD = createSwordItem("simix_sword", CustomItemTier.SIMIX, 3, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_PICKAXE = createPickaxeItem("simix_pickaxe", CustomItemTier.SIMIX, 6, DimensionalExpansionItemGroups.TOOLS);
    public static final RegistryObject<Item> SIMIX_AXE = createAxeItem("simix_axe", CustomItemTier.SIMIX, 6, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_SHOVEL = createShovelItem("simix_shovel", CustomItemTier.SIMIX, 1.5f, DimensionalExpansionItemGroups.TOOLS);
    public static final RegistryObject<Item> SIMIX_HOE = createHoeItem("simix_hoe", CustomItemTier.SIMIX, 0, DimensionalExpansionItemGroups.TOOLS);
    public static final RegistryObject<Item> SIMIX_HELMET = createArmorItem("simix_helmet", CustomArmorMaterial.SIMIX, EquipmentSlot.HEAD, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_CHESTPLATE = createArmorItem("simix_chestplate", CustomArmorMaterial.SIMIX, EquipmentSlot.CHEST, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_LEGGINGS = createArmorItem("simix_leggings", CustomArmorMaterial.SIMIX, EquipmentSlot.LEGS, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_BOOTS = createArmorItem("simix_boots", CustomArmorMaterial.SIMIX, EquipmentSlot.FEET, DimensionalExpansionItemGroups.COMBAT);


    public static final RegistryObject<Item> EMERTYST_GEM = createItem("emertyst_gem", DimensionalExpansionItemGroups.MISC);
    public static final RegistryObject<Item> EMERTYST_SWORD = createSwordItem("emertyst_sword", CustomItemTier.EMERTYST, 3, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_PICKAXE = createPickaxeItem("emertyst_pickaxe", CustomItemTier.EMERTYST, 6, DimensionalExpansionItemGroups.TOOLS);
    public static final RegistryObject<Item> EMERTYST_AXE = createAxeItem("emertyst_axe", CustomItemTier.EMERTYST, 6, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_SHOVEL = createShovelItem("emertyst_shovel", CustomItemTier.EMERTYST, 1.5f, DimensionalExpansionItemGroups.TOOLS);
    public static final RegistryObject<Item> EMERTYST_HOE = createHoeItem("emertyst_hoe", CustomItemTier.EMERTYST, 0, DimensionalExpansionItemGroups.TOOLS);
    public static final RegistryObject<Item> EMERTYST_HELMET = createArmorItem("emertyst_helmet", CustomArmorMaterial.EMERTYST, EquipmentSlot.HEAD, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_CHESTPLATE = createArmorItem("emertyst_chestplate", CustomArmorMaterial.EMERTYST, EquipmentSlot.CHEST, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_LEGGINGS = createArmorItem("emertyst_leggings", CustomArmorMaterial.EMERTYST, EquipmentSlot.LEGS, DimensionalExpansionItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_BOOTS = createArmorItem("emertyst_boots", CustomArmorMaterial.EMERTYST, EquipmentSlot.FEET, DimensionalExpansionItemGroups.COMBAT);

    private static RegistryObject<Item> createItem(String id, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new Item(new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createSwordItem(String id, Tier tier, int level, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new SwordItem(tier, level, -2.4F, new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createPickaxeItem(String id, Tier tier, int level, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new PickaxeItem(tier, level, -2.8F, new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createAxeItem(String id, Tier tier, float level, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new AxeItem(tier, level, -3.2F, new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createShovelItem(String id, Tier tier, float level, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new ShovelItem(tier, level, -3F, new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createHoeItem(String id, Tier tier, int level, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new HoeItem(tier, level, -3F, new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createArmorItem(String id, ArmorMaterial material, EquipmentSlot slot, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new ArmorItem(material, slot, new Item.Properties().tab(itemGroup)));
    }
}
