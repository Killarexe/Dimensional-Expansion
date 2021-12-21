package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.item.FuelItem;
import net.killarexe.dimensional_expansion.common.item.material.DEArmorMaterial;
import net.killarexe.dimensional_expansion.common.item.material.DEItemTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DEItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DEMod.MODID);

    public static final RegistryObject<Item> RAW_PALON = createItem("raw_palon", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> PALON_INGOT = createItem("palon_ingot", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> PALON_NUGGET = createItem("palon_nugget", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> PALON_SWORD = createSwordItem("palon_sword", DEItemTier.PALON, 3, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_PICKAXE = createPickaxeItem("palon_pickaxe", DEItemTier.PALON, 6, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> PALON_AXE = createAxeItem("palon_axe", DEItemTier.PALON, 6, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_SHOVEL = createShovelItem("palon_shovel", DEItemTier.PALON, 1.5f, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> PALON_HOE = createHoeItem("palon_hoe", DEItemTier.PALON, 0, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> PALON_HELMET = createArmorItem("palon_helmet", DEArmorMaterial.PALON, EquipmentSlot.HEAD, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_CHESTPLATE = createArmorItem("palon_chestplate", DEArmorMaterial.PALON, EquipmentSlot.CHEST, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_LEGGINGS = createArmorItem("palon_leggings", DEArmorMaterial.PALON, EquipmentSlot.LEGS, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_BOOTS = createArmorItem("palon_boots", DEArmorMaterial.PALON, EquipmentSlot.FEET, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_HORSE_ARMOR = createHorseArmorItem("palon_horse_armor", 6, "palon", DEItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_MIXED_COAL = createFuelItem("palon_mixed_coal", 3200, DEItemGroups.MISC, true);

    public static final RegistryObject<Item> BASSMITE_GEM = createItem("bassmite_gem", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> BASSMITE_SWORD = createSwordItem("bassmite_sword", DEItemTier.BASSMITE, 3, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_PICKAXE = createPickaxeItem("bassmite_pickaxe", DEItemTier.BASSMITE, 6, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> BASSMITE_AXE = createAxeItem("bassmite_axe", DEItemTier.BASSMITE, 6, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_SHOVEL = createShovelItem("bassmite_shovel", DEItemTier.BASSMITE, 1.5f, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> BASSMITE_HOE = createHoeItem("bassmite_hoe", DEItemTier.BASSMITE, 0, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> BASSMITE_HELMET = createArmorItem("bassmite_helmet", DEArmorMaterial.BASSMITE, EquipmentSlot.HEAD, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_CHESTPLATE = createArmorItem("bassmite_chestplate", DEArmorMaterial.BASSMITE, EquipmentSlot.CHEST, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_LEGGINGS = createArmorItem("bassmite_leggings", DEArmorMaterial.BASSMITE, EquipmentSlot.LEGS, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_BOOTS = createArmorItem("bassmite_boots", DEArmorMaterial.BASSMITE, EquipmentSlot.FEET, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_HORSE_ARMOR = createHorseArmorItem("bassmite_horse_armor", 10, "bassmite", DEItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_MIXED_COAL = createFuelItem("bassmite_mixed_coal", 6400, DEItemGroups.MISC, true);

    public static final RegistryObject<Item> RAW_SIMIX = createItem("raw_simix", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> SIMIX_INGOT = createItem("simix_ingot", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> SIMIX_NUGGET = createItem("simix_nugget", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> SIMIX_SWORD = createSwordItem("simix_sword", DEItemTier.SIMIX, 3, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_PICKAXE = createPickaxeItem("simix_pickaxe", DEItemTier.SIMIX, 6, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> SIMIX_AXE = createAxeItem("simix_axe", DEItemTier.SIMIX, 6, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_SHOVEL = createShovelItem("simix_shovel", DEItemTier.SIMIX, 1.5f, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> SIMIX_HOE = createHoeItem("simix_hoe", DEItemTier.SIMIX, 0, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> SIMIX_HELMET = createArmorItem("simix_helmet", DEArmorMaterial.SIMIX, EquipmentSlot.HEAD, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_CHESTPLATE = createArmorItem("simix_chestplate", DEArmorMaterial.SIMIX, EquipmentSlot.CHEST, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_LEGGINGS = createArmorItem("simix_leggings", DEArmorMaterial.SIMIX, EquipmentSlot.LEGS, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_BOOTS = createArmorItem("simix_boots", DEArmorMaterial.SIMIX, EquipmentSlot.FEET, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_HORSE_ARMOR = createHorseArmorItem("simix_horse_armor", 14, "simix", DEItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_MIXED_COAL = createFuelItem("simix_mixed_coal", 12800, DEItemGroups.MISC, true);

    public static final RegistryObject<Item> EMERTYST_GEM = createItem("emertyst_gem", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> EMERTYST_SWORD = createSwordItem("emertyst_sword", DEItemTier.EMERTYST, 3, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_PICKAXE = createPickaxeItem("emertyst_pickaxe", DEItemTier.EMERTYST, 6, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> EMERTYST_AXE = createAxeItem("emertyst_axe", DEItemTier.EMERTYST, 6, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_SHOVEL = createShovelItem("emertyst_shovel", DEItemTier.EMERTYST, 1.5f, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> EMERTYST_HOE = createHoeItem("emertyst_hoe", DEItemTier.EMERTYST, 0, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> EMERTYST_HELMET = createArmorItem("emertyst_helmet", DEArmorMaterial.EMERTYST, EquipmentSlot.HEAD, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_CHESTPLATE = createArmorItem("emertyst_chestplate", DEArmorMaterial.EMERTYST, EquipmentSlot.CHEST, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_LEGGINGS = createArmorItem("emertyst_leggings", DEArmorMaterial.EMERTYST, EquipmentSlot.LEGS, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_BOOTS = createArmorItem("emertyst_boots", DEArmorMaterial.EMERTYST, EquipmentSlot.FEET, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_HORSE_ARMOR = createHorseArmorItem("emertyst_horse_armor", 22, "emertyst", DEItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_MIXED_COAL = createFuelItem("emertyst_mixed_coal", 25600, DEItemGroups.MISC, true);

    public static final RegistryObject<Item> XP_PLANTS = createItem("xp_plants", DEItemGroups.MISC, false);
    public static final RegistryObject<Item> HEART = createItem("heart", DEItemGroups.MISC, false);

    public static final RegistryObject<Item> END_SIGN = createSignItem("end_sign", DEBlocks.END_SIGN.get(), DEBlocks.END_WALL_SIGN.get(), DEItemGroups.DECORATION_BLOCKS);

    private static RegistryObject<Item> createItem(String id, CreativeModeTab itemGroup, boolean isFireProof){
        if(isFireProof){
            return ITEMS.register(id, () -> new Item(new Item.Properties().tab(itemGroup).fireResistant()));
        }
        return ITEMS.register(id, () -> new Item(new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createFuelItem(String id, int burnTime, CreativeModeTab itemGroup, boolean isFireProof){
        if(isFireProof){
            return ITEMS.register(id, () -> new FuelItem(new Item.Properties().tab(itemGroup).fireResistant(), burnTime));
        }
        return ITEMS.register(id, () -> new FuelItem(new Item.Properties().tab(itemGroup), burnTime));
    }

    private static RegistryObject<Item> createSwordItem(String id, Tier tier, int level, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new SwordItem(tier, level, -2.4F, new Item.Properties().tab(itemGroup).fireResistant()));
    }

    private static RegistryObject<Item> createPickaxeItem(String id, Tier tier, int level, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new PickaxeItem(tier, level, -2.8F, new Item.Properties().tab(itemGroup).fireResistant()));
    }

    private static RegistryObject<Item> createAxeItem(String id, Tier tier, float level, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new AxeItem(tier, level, -3.2F, new Item.Properties().tab(itemGroup).fireResistant()));
    }

    private static RegistryObject<Item> createShovelItem(String id, Tier tier, float level, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new ShovelItem(tier, level, -3F, new Item.Properties().tab(itemGroup).fireResistant()));
    }

    private static RegistryObject<Item> createHoeItem(String id, Tier tier, int level, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new HoeItem(tier, level, -3F, new Item.Properties().tab(itemGroup).fireResistant()));
    }

    private static RegistryObject<Item> createArmorItem(String id, ArmorMaterial material, EquipmentSlot slot, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new ArmorItem(material, slot, new Item.Properties().tab(itemGroup).fireResistant()));
    }

    private static RegistryObject<Item> createDiscItem(String id, int comparatorValue, RegistryObject<SoundEvent> sound, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new RecordItem(comparatorValue, () -> sound.get(), new Item.Properties().tab(itemGroup).stacksTo(1)));
    }

    private static RegistryObject<Item> createHorseArmorItem(String id, int armorValue, String tierID, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new HorseArmorItem(armorValue, new ResourceLocation(DEMod.MODID, tierID), new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createBlockItem(String id, RegistryObject<Block> block, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createBlockItem(String id, Block block, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new BlockItem(block, new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createBannerPatternItem(String id, BannerPattern pattern, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new BannerPatternItem(pattern, new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createSignItem(String id, Block standingBlock, Block wallBlock, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new SignItem(new Item.Properties().stacksTo(16).tab(itemGroup), standingBlock, wallBlock));
    }
}
