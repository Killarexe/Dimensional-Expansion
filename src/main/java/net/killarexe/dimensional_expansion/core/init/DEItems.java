package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.item.FuelItem;
import net.killarexe.dimensional_expansion.common.item.material.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.*;

public class DEItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DEMod.MODID);

    public static final RegistryObject<Item> RAW_PALON = createItem("raw_palon", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> PALON_INGOT = createItem("palon_ingot", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> PALON_NUGGET = createItem("palon_nugget", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> PALON_SWORD = createSwordItem("palon_sword", CustomItemTier.PALON, 3, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_PICKAXE = createPickaxeItem("palon_pickaxe", CustomItemTier.PALON, 6, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> PALON_AXE = createAxeItem("palon_axe", CustomItemTier.PALON, 6, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_SHOVEL = createShovelItem("palon_shovel", CustomItemTier.PALON, 1.5f, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> PALON_HOE = createHoeItem("palon_hoe", CustomItemTier.PALON, 0, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> PALON_HELMET = createArmorItem("palon_helmet", CustomArmorMaterial.PALON, EquipmentSlot.HEAD, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_CHESTPLATE = createArmorItem("palon_chestplate", CustomArmorMaterial.PALON, EquipmentSlot.CHEST, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_LEGGINGS = createArmorItem("palon_leggings", CustomArmorMaterial.PALON, EquipmentSlot.LEGS, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> PALON_BOOTS = createArmorItem("palon_boots", CustomArmorMaterial.PALON, EquipmentSlot.FEET, DEItemGroups.COMBAT);

    public static final RegistryObject<Item> BASSMITE_GEM = createItem("bassmite_gem", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> BASSMITE_SWORD = createSwordItem("bassmite_sword", CustomItemTier.BASSMITE, 3, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_PICKAXE = createPickaxeItem("bassmite_pickaxe", CustomItemTier.BASSMITE, 6, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> BASSMITE_AXE = createAxeItem("bassmite_axe", CustomItemTier.BASSMITE, 6, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_SHOVEL = createShovelItem("bassmite_shovel", CustomItemTier.BASSMITE, 1.5f, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> BASSMITE_HOE = createHoeItem("bassmite_hoe", CustomItemTier.BASSMITE, 0, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> BASSMITE_HELMET = createArmorItem("bassmite_helmet", CustomArmorMaterial.BASSMITE, EquipmentSlot.HEAD, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_CHESTPLATE = createArmorItem("bassmite_chestplate", CustomArmorMaterial.BASSMITE, EquipmentSlot.CHEST, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_LEGGINGS = createArmorItem("bassmite_leggings", CustomArmorMaterial.BASSMITE, EquipmentSlot.LEGS, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> BASSMITE_BOOTS = createArmorItem("bassmite_boots", CustomArmorMaterial.BASSMITE, EquipmentSlot.FEET, DEItemGroups.COMBAT);

    public static final RegistryObject<Item> RAW_SIMIX = createItem("raw_simix", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> SIMIX_INGOT = createItem("simix_ingot", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> SIMIX_NUGGET = createItem("simix_nugget", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> SIMIX_SWORD = createSwordItem("simix_sword", CustomItemTier.SIMIX, 3, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_PICKAXE = createPickaxeItem("simix_pickaxe", CustomItemTier.SIMIX, 6, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> SIMIX_AXE = createAxeItem("simix_axe", CustomItemTier.SIMIX, 6, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_SHOVEL = createShovelItem("simix_shovel", CustomItemTier.SIMIX, 1.5f, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> SIMIX_HOE = createHoeItem("simix_hoe", CustomItemTier.SIMIX, 0, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> SIMIX_HELMET = createArmorItem("simix_helmet", CustomArmorMaterial.SIMIX, EquipmentSlot.HEAD, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_CHESTPLATE = createArmorItem("simix_chestplate", CustomArmorMaterial.SIMIX, EquipmentSlot.CHEST, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_LEGGINGS = createArmorItem("simix_leggings", CustomArmorMaterial.SIMIX, EquipmentSlot.LEGS, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> SIMIX_BOOTS = createArmorItem("simix_boots", CustomArmorMaterial.SIMIX, EquipmentSlot.FEET, DEItemGroups.COMBAT);

    public static final RegistryObject<Item> EMERTYST_GEM = createItem("emertyst_gem", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> EMERTYST_SWORD = createSwordItem("emertyst_sword", CustomItemTier.EMERTYST, 3, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_PICKAXE = createPickaxeItem("emertyst_pickaxe", CustomItemTier.EMERTYST, 6, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> EMERTYST_AXE = createAxeItem("emertyst_axe", CustomItemTier.EMERTYST, 6, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_SHOVEL = createShovelItem("emertyst_shovel", CustomItemTier.EMERTYST, 1.5f, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> EMERTYST_HOE = createHoeItem("emertyst_hoe", CustomItemTier.EMERTYST, 0, DEItemGroups.TOOLS);
    public static final RegistryObject<Item> EMERTYST_HELMET = createArmorItem("emertyst_helmet", CustomArmorMaterial.EMERTYST, EquipmentSlot.HEAD, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_CHESTPLATE = createArmorItem("emertyst_chestplate", CustomArmorMaterial.EMERTYST, EquipmentSlot.CHEST, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_LEGGINGS = createArmorItem("emertyst_leggings", CustomArmorMaterial.EMERTYST, EquipmentSlot.LEGS, DEItemGroups.COMBAT);
    public static final RegistryObject<Item> EMERTYST_BOOTS = createArmorItem("emertyst_boots", CustomArmorMaterial.EMERTYST, EquipmentSlot.FEET, DEItemGroups.COMBAT);

    public static final RegistryObject<Item> DW_DISC = createDiscItem("dw_disc", 10, DESounds.DW, DEItemGroups.MISC);

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
        return ITEMS.register(id, () -> new RecordItem(comparatorValue, () -> sound.get(), new Item.Properties().tab(itemGroup)));
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

    private static RegistryObject<Item> createPotionItem(String id, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new PotionItem(new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createThrowbalePotionItem(String id, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new ThrowablePotionItem(new Item.Properties().tab(itemGroup)));
    }
}
