package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.block.*;
import net.killarexe.dimensional_expansion.common.item.FuelItem;
import net.killarexe.dimensional_expansion.common.item.TimePowerStone;
import net.killarexe.dimensional_expansion.common.item.WeatherPowerStone;
import net.killarexe.dimensional_expansion.common.item.XpPlants;
import net.killarexe.dimensional_expansion.common.item.material.DEArmorMaterial;
import net.killarexe.dimensional_expansion.common.item.material.DEItemTier;
import net.killarexe.dimensional_expansion.core.world.feature.tree.EndTreeGrower;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class DEItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DEMod.MODID);

    //ITEMS
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

    public static final RegistryObject<Item> WEATHER_POWER_STONE = createCustomItem("weather_power_stone", new WeatherPowerStone());
    public static final RegistryObject<Item> TIME_POWER_STONE = createCustomItem("time_power_stone", new TimePowerStone());

    public static final RegistryObject<Item> XP_SEEDS = ITEMS.register("xp_seeds", () -> new ItemNameBlockItem(DEBlocks.XP_CROPS.get(), new Item.Properties().tab(DEItemGroups.MISC)));
    public static final RegistryObject<Item> HEART_SEEDS = ITEMS.register("heart_seeds", () -> new ItemNameBlockItem(DEBlocks.HEALTH_CROPS.get(), new Item.Properties().tab(DEItemGroups.MISC)));
    public static final RegistryObject<Item> XP_PLANTS = createCustomItem("xp_plants", new XpPlants());
    public static final RegistryObject<Item> HEART = createFoodItem("heart", 2, 2, MobEffects.HEALTH_BOOST, 1, 1, 1,DEItemGroups.MISC, false);
    public static final RegistryObject<Item> XP_ESSENCE = createItem("xp_essence", DEItemGroups.MISC, false);
    public static final RegistryObject<Item> HEART_ESSENCE = createItem("heart_essence", DEItemGroups.MISC, false);

    //BLOCK ITEMS
    //public static final RegistryObject<Item> PALON_ORE = ITEMS.register("palon_ore", () -> new BlockItem(DEBlocks.PALON_ORE.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> PALON_BLOCK = ITEMS.register("palon_block", () -> new BlockItem(DEBlocks.PALON_BLOCK.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> BASSMITE_ORE = ITEMS.register("bassmite_ore", () -> new BlockItem(DEBlocks.BASSMITE_ORE.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> BASSMITE_BLOCK = ITEMS.register("bassmite_block", () -> new BlockItem(DEBlocks.BASSMITE_BLOCK.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> SIMIX_ORE = ITEMS.register("simix_ore", () -> new BlockItem(DEBlocks.SIMIX_ORE.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> SIMIX_BLOCK = ITEMS.register("simix_block", () -> new BlockItem(DEBlocks.SIMIX_BLOCK.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> EMERTYST_ORE = ITEMS.register("emertyst_ore", () -> new BlockItem(DEBlocks.EMERTYST_ORE.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> EMERTYST_BLOCK = ITEMS.register("emertyst_block", () -> new BlockItem(DEBlocks.EMERTYST_BLOCK.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
//
    //public static final RegistryObject<Item> END_GRASS_BLOCK = ITEMS.register("end_gra", () -> new BlockItem(DEBlocks.END_GRASS_BLOCK.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> END_LOG = ITEMS.register("end_log", () -> new BlockItem(DEBlocks.END_LOG.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> END_STRIPPED_LOG = ITEMS.register("end_stripped_log", () -> new BlockItem(DEBlocks.END_STRIPPED_LOG.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> END_PLANKS = ITEMS.register("end_planks", () -> new BlockItem(DEBlocks.END_PLANKS.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> END_SLAB = ITEMS.register("end_slab", () -> new BlockItem(DEBlocks.END_SLAB.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> END_FENCE = ITEMS.register("end_fence", () -> new BlockItem(DEBlocks.END_FENCE.get(), new Item.Properties().tab(DEItemGroups.DECORATION_BLOCKS)));
    //public static final RegistryObject<Item> END_FENCE_GATE = ITEMS.register("end_fence_gate", () -> new BlockItem(DEBlocks.END_FENCE_GATE.get(), new Item.Properties().tab(DEItemGroups.DECORATION_BLOCKS)));
    //public static final RegistryObject<Item> END_BUTTON = ITEMS.register("end_button", () -> new BlockItem(DEBlocks.END_BUTTON.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> END_PRESSURE_PLATE = ITEMS.register("end_pressure_plate", () -> new BlockItem(DEBlocks.END_PRESSURE_PLATE.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> END_DOOR = ITEMS.register("end_door", () -> new BlockItem(DEBlocks.END_DOOR.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> END_TRAPDOOR = ITEMS.register("end_trapdoor", () -> new BlockItem(DEBlocks.END_TRAPDOOR.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> END_LEAVES = ITEMS.register("end_leaves", () -> new BlockItem(DEBlocks.END_LEAVES.get(), new Item.Properties().tab(DEItemGroups.DECORATION_BLOCKS)));
    //public static final RegistryObject<Item> END_STAIRS = ITEMS.register("end_stairs", () -> new BlockItem(DEBlocks.END_STAIRS.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> END_BOOKSHELF = ITEMS.register("end_bookshelf", () -> new BlockItem(DEBlocks.END_BOOKSHELF.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    public static final RegistryObject<Item> END_SIGN = ITEMS.register("end_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(DEItemGroups.DECORATION_BLOCKS), DEBlocks.END_SIGN.get(), DEBlocks.END_WALL_SIGN.get()));
    //public static final RegistryObject<Item> END_ROSE = ITEMS.register("end_rose", () -> new BlockItem(DEBlocks.END_ROSE.get(), new Item.Properties().tab(DEItemGroups.DECORATION_BLOCKS)));
    //public static final RegistryObject<Item> END_SAPLING = ITEMS.register("end_sapling", () -> new BlockItem(DEBlocks.END_SAPLING.get(), new Item.Properties().tab(DEItemGroups.DECORATION_BLOCKS)));
//
    //public static final RegistryObject<Item> FORGE = ITEMS.register("forge", () -> new BlockItem(DEBlocks.FORGE.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> ESSENCE_EXTRACTOR = ITEMS.register("essence_extractor", () -> new BlockItem(DEBlocks.ESSENCE_EXTRACTOR.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> MINERAL_STORAGE = ITEMS.register("mineral_storage", () -> new BlockItem(DEBlocks.MINERAL_STORAGE.get(), new Item.Properties().tab(DEItemGroups.BUILDING_BLOCKS)));

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

    private static RegistryObject<Item> createFoodItem(String id, float staturation, int nutrition, MobEffect effect, int level, int duration, float probability, CreativeModeTab itemGroup, boolean isFireProof){
        if(isFireProof){
            return ITEMS.register(id, () -> new Item(new Item.Properties().tab(itemGroup).food(new FoodProperties.Builder().saturationMod(staturation).alwaysEat().nutrition(nutrition).effect(() ->  new MobEffectInstance(effect, level, duration), probability).build()).fireResistant()));
        }
        return ITEMS.register(id, () -> new Item(new Item.Properties().tab(itemGroup).food(new FoodProperties.Builder().saturationMod(staturation).alwaysEat().nutrition(nutrition).effect(() ->  new MobEffectInstance(effect, level, duration), probability).build())));
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
        return ITEMS.register(id, () -> new HorseArmorItem(armorValue, new ResourceLocation(DEMod.MODID, "textures/entity/horse/armor/horse_armor_" + tierID + ".png"), new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createCustomItem(String id, Item item){
        return ITEMS.register(id, () -> item);
    }

    private static RegistryObject<Item> createBannerPatternItem(String id, BannerPattern pattern, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new BannerPatternItem(pattern, new Item.Properties().tab(itemGroup)));
    }

    @OnlyIn(Dist.CLIENT)
    public static void addItemsProperites(){
        addClockProperties(TIME_POWER_STONE.get());
    }

    @OnlyIn(Dist.CLIENT)
    private static void addClockProperties(Item item){
        ItemProperties.register(item, new ResourceLocation("time"), new ClampedItemPropertyFunction() {
            private double rotation;
            private double rota;
            private long lastUpdateTick;

            public float unclampedCall(ItemStack p_174665_, @Nullable ClientLevel p_174666_, @Nullable LivingEntity p_174667_, int p_174668_) {
                Entity entity = (Entity) (p_174667_ != null ? p_174667_ : p_174665_.getEntityRepresentation());
                if (entity == null) {
                    return 0.0F;
                } else {
                    if (p_174666_ == null && entity.level instanceof ClientLevel) {
                        p_174666_ = (ClientLevel) entity.level;
                    }

                    if (p_174666_ == null) {
                        return 0.0F;
                    } else {
                        double d0;
                        if (p_174666_.dimensionType().natural()) {
                            d0 = (double) p_174666_.getTimeOfDay(1.0F);
                        } else {
                            d0 = Math.random();
                        }

                        d0 = this.wobble(p_174666_, d0);
                        return (float) d0;
                    }
                }
            }

            private double wobble(Level p_117904_, double p_117905_) {
                if (p_117904_.getGameTime() != this.lastUpdateTick) {
                    this.lastUpdateTick = p_117904_.getGameTime();
                    double d0 = p_117905_ - this.rotation;
                    d0 = Mth.positiveModulo(d0 + 0.5D, 1.0D) - 0.5D;
                    this.rota += d0 * 0.1D;
                    this.rota *= 0.9D;
                    this.rotation = Mth.positiveModulo(this.rotation + this.rota, 1.0D);
                }

                return this.rotation;
            }
        });
    }

}
