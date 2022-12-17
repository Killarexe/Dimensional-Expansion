package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.entity.PurpleheartBoatEntity;
import net.killarexe.dimensional_expansion.common.item.*;
import net.killarexe.dimensional_expansion.common.item.material.*;
import net.killarexe.dimensional_expansion.utils.DEMath;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.CompassItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.*;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class DEItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DEMod.MOD_ID);

    /* ITEMS */
    public static final RegistryObject<Item> RAW_PALON = createItem("raw_palon", DEItemGroups.MISC, false);
    public static final RegistryObject<Item> PALON_INGOT = createItem("palon_ingot", DEItemGroups.MISC, false);
    public static final RegistryObject<Item> PALON_NUGGET = createItem("palon_nugget", DEItemGroups.MISC, false);
    public static final RegistryObject<Item> PALON_SWORD = createSwordItem("palon_sword", DEItemTier.PALON, 3, DEItemGroups.COMBAT, false);
    public static final RegistryObject<Item> PALON_PICKAXE = createPickaxeItem("palon_pickaxe", DEItemTier.PALON, 6, DEItemGroups.TOOLS, false);
    public static final RegistryObject<Item> PALON_AXE = createAxeItem("palon_axe", DEItemTier.PALON, 6, DEItemGroups.COMBAT, false);
    public static final RegistryObject<Item> PALON_SHOVEL = createShovelItem("palon_shovel", DEItemTier.PALON, 1.5f, DEItemGroups.TOOLS, false);
    public static final RegistryObject<Item> PALON_HOE = createHoeItem("palon_hoe", DEItemTier.PALON, 0, DEItemGroups.TOOLS, false);
    public static final RegistryObject<Item> PALON_HELMET = createArmorItem("palon_helmet", DEArmorMaterial.PALON, EquipmentSlot.HEAD, DEItemGroups.COMBAT, false);
    public static final RegistryObject<Item> PALON_CHESTPLATE = createArmorItem("palon_chestplate", DEArmorMaterial.PALON, EquipmentSlot.CHEST, DEItemGroups.COMBAT, false);
    public static final RegistryObject<Item> PALON_LEGGINGS = createArmorItem("palon_leggings", DEArmorMaterial.PALON, EquipmentSlot.LEGS, DEItemGroups.COMBAT, false);
    public static final RegistryObject<Item> PALON_BOOTS = createArmorItem("palon_boots", DEArmorMaterial.PALON, EquipmentSlot.FEET, DEItemGroups.COMBAT, false);
    public static final RegistryObject<Item> PALON_HORSE_ARMOR = createHorseArmorItem("palon_horse_armor", 6, "palon", DEItemGroups.COMBAT, false);
    public static final RegistryObject<Item> PALON_MIXED_COAL = createFuelItem("palon_mixed_coal", 3200, DEItemGroups.MISC, false);

    public static final RegistryObject<Item> BASSMITE_GEM = createItem("bassmite_gem", DEItemGroups.MISC, false);
    public static final RegistryObject<Item> BASSMITE_SWORD = createSwordItem("bassmite_sword", DEItemTier.BASSMITE, 3, DEItemGroups.COMBAT, false);
    public static final RegistryObject<Item> BASSMITE_PICKAXE = createPickaxeItem("bassmite_pickaxe", DEItemTier.BASSMITE, 6, DEItemGroups.TOOLS, false);
    public static final RegistryObject<Item> BASSMITE_AXE = createAxeItem("bassmite_axe", DEItemTier.BASSMITE, 6, DEItemGroups.COMBAT, false);
    public static final RegistryObject<Item> BASSMITE_SHOVEL = createShovelItem("bassmite_shovel", DEItemTier.BASSMITE, 1.5f, DEItemGroups.TOOLS, false);
    public static final RegistryObject<Item> BASSMITE_HOE = createHoeItem("bassmite_hoe", DEItemTier.BASSMITE, 0, DEItemGroups.TOOLS, false);
    public static final RegistryObject<Item> BASSMITE_HELMET = createArmorItem("bassmite_helmet", DEArmorMaterial.BASSMITE, EquipmentSlot.HEAD, DEItemGroups.COMBAT, false);
    public static final RegistryObject<Item> BASSMITE_CHESTPLATE = createArmorItem("bassmite_chestplate", DEArmorMaterial.BASSMITE, EquipmentSlot.CHEST, DEItemGroups.COMBAT, false);
    public static final RegistryObject<Item> BASSMITE_LEGGINGS = createArmorItem("bassmite_leggings", DEArmorMaterial.BASSMITE, EquipmentSlot.LEGS, DEItemGroups.COMBAT, false);
    public static final RegistryObject<Item> BASSMITE_BOOTS = createArmorItem("bassmite_boots", DEArmorMaterial.BASSMITE, EquipmentSlot.FEET, DEItemGroups.COMBAT, false);
    public static final RegistryObject<Item> BASSMITE_HORSE_ARMOR = createHorseArmorItem("bassmite_horse_armor", 10, "bassmite", DEItemGroups.COMBAT, false);
    public static final RegistryObject<Item> BASSMITE_MIXED_COAL = createFuelItem("bassmite_mixed_coal", 6400, DEItemGroups.MISC, false);

    public static final RegistryObject<Item> RAW_SIMIX = createItem("raw_simix", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> SIMIX_INGOT = createItem("simix_ingot", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> SIMIX_NUGGET = createItem("simix_nugget", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> SIMIX_HAMMER = createCustomItem("simix_hammer", () -> new SimixHammerItem());
    public static final RegistryObject<Item> SIMIX_SWORD = createSwordItem("simix_sword", DEItemTier.SIMIX, 3, DEItemGroups.COMBAT, true);
    public static final RegistryObject<Item> SIMIX_PICKAXE = createPickaxeItem("simix_pickaxe", DEItemTier.SIMIX, 6, DEItemGroups.TOOLS, true);
    public static final RegistryObject<Item> SIMIX_AXE = createAxeItem("simix_axe", DEItemTier.SIMIX, 6, DEItemGroups.COMBAT, true);
    public static final RegistryObject<Item> SIMIX_SHOVEL = createShovelItem("simix_shovel", DEItemTier.SIMIX, 1.5f, DEItemGroups.TOOLS, true);
    public static final RegistryObject<Item> SIMIX_HOE = createHoeItem("simix_hoe", DEItemTier.SIMIX, 0, DEItemGroups.TOOLS, true);
    public static final RegistryObject<Item> SIMIX_HELMET = createArmorItem("simix_helmet", DEArmorMaterial.SIMIX, EquipmentSlot.HEAD, DEItemGroups.COMBAT, true);
    public static final RegistryObject<Item> SIMIX_CHESTPLATE = createArmorItem("simix_chestplate", DEArmorMaterial.SIMIX, EquipmentSlot.CHEST, DEItemGroups.COMBAT, true);
    public static final RegistryObject<Item> SIMIX_LEGGINGS = createArmorItem("simix_leggings", DEArmorMaterial.SIMIX, EquipmentSlot.LEGS, DEItemGroups.COMBAT, true);
    public static final RegistryObject<Item> SIMIX_BOOTS = createArmorItem("simix_boots", DEArmorMaterial.SIMIX, EquipmentSlot.FEET, DEItemGroups.COMBAT, true);
    public static final RegistryObject<Item> SIMIX_HORSE_ARMOR = createHorseArmorItem("simix_horse_armor", 14, "simix", DEItemGroups.COMBAT, true);
    public static final RegistryObject<Item> SIMIX_MIXED_COAL = createFuelItem("simix_mixed_coal", 12800, DEItemGroups.MISC, true);

    public static final RegistryObject<Item> EMERTYST_GEM = createItem("emertyst_gem", DEItemGroups.MISC, true);
    public static final RegistryObject<Item> EMERTYST_SWORD = createSwordItem("emertyst_sword", DEItemTier.EMERTYST, 3, DEItemGroups.COMBAT, true);
    public static final RegistryObject<Item> EMERTYST_PICKAXE = createPickaxeItem("emertyst_pickaxe", DEItemTier.EMERTYST, 5, DEItemGroups.TOOLS, true);
    public static final RegistryObject<Item> EMERTYST_AXE = createAxeItem("emertyst_axe", DEItemTier.EMERTYST, 6, DEItemGroups.COMBAT, true);
    public static final RegistryObject<Item> EMERTYST_SHOVEL = createShovelItem("emertyst_shovel", DEItemTier.EMERTYST, 1.5f, DEItemGroups.TOOLS, true);
    public static final RegistryObject<Item> EMERTYST_HOE = createHoeItem("emertyst_hoe", DEItemTier.EMERTYST, 0, DEItemGroups.TOOLS, true);
    public static final RegistryObject<Item> EMERTYST_HELMET = createArmorItem("emertyst_helmet", DEArmorMaterial.EMERTYST, EquipmentSlot.HEAD, DEItemGroups.COMBAT, true);
    public static final RegistryObject<Item> EMERTYST_CHESTPLATE = createArmorItem("emertyst_chestplate", DEArmorMaterial.EMERTYST, EquipmentSlot.CHEST, DEItemGroups.COMBAT, true);
    public static final RegistryObject<Item> EMERTYST_LEGGINGS = createArmorItem("emertyst_leggings", DEArmorMaterial.EMERTYST, EquipmentSlot.LEGS, DEItemGroups.COMBAT, true);
    public static final RegistryObject<Item> EMERTYST_BOOTS = createArmorItem("emertyst_boots", DEArmorMaterial.EMERTYST, EquipmentSlot.FEET, DEItemGroups.COMBAT, true);
    public static final RegistryObject<Item> EMERTYST_HORSE_ARMOR = createHorseArmorItem("emertyst_horse_armor", 22, "emertyst", DEItemGroups.COMBAT, true);
    public static final RegistryObject<Item> EMERTYST_MIXED_COAL = createFuelItem("emertyst_mixed_coal", 25600, DEItemGroups.MISC, true);

    public static final RegistryObject<Item> ALLOY_CRYSTAL = createCustomItem("alloy_crystal", () -> new AlloyCrystal());
    
    public static final RegistryObject<Item> WEATHER_POWER_STONE = createCustomItem("weather_power_stone", () -> new WeatherPowerStone());
    public static final RegistryObject<Item> TIME_POWER_STONE = createCustomItem("time_power_stone", () -> new TimePowerStone());
    public static final RegistryObject<Item> WARP_POWER_STONE = createCustomItem("warp_power_stone", () -> new WarpPowerStone());
    public static final RegistryObject<Item> COORD_LINKER = createCustomItem("coord_linker", () -> new CoordLinker());
    public static final RegistryObject<Item> REMOTE_TELEPORTER = createCustomItem("remote_teleporter", () -> new RemoteTeleporter());

    public static final RegistryObject<Item> PEARL_ESSENCE = createItem("pearl_essence", DEItemGroups.MISC, false);

    public static final RegistryObject<Item> ORIGIN_PORTAL_KEY = ITEMS.register("origin_portal_key", () -> new OriginPortalKey());
    
    public static final RegistryObject<Item> PURPLEHEART_SIGN = ITEMS.register("purpleheart_sign", () -> new SignItem(new Item.Properties().stacksTo(16).tab(DEItemGroups.BLOCKS), DEBlocks.PURPLEHEART_SIGN.get(), DEBlocks.PURPLEHEART_WALL_SIGN.get()));
    public static final RegistryObject<Item> PURPLEHEART_BOAT = ITEMS.register("purpleheart_boat", () -> new EndBoatItem(new Item.Properties().stacksTo(1).tab(DEItemGroups.MISC).fireResistant(), PurpleheartBoatEntity.Type.PURPLEHEART));

    public static final RegistryObject<Item> SWEDEN_DISC = createDiscItem("sweden_disc", 7, DESounds.SWEDEN_REMIX, DEItemGroups.MISC, 0);
    public static final RegistryObject<Item> DOCTOR_WHO_DISC = createDiscItem("doctor_who_disc", 3, DESounds.DOCTOR_WHO, DEItemGroups.MISC, 0);

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

    @SuppressWarnings("unused")
	private static RegistryObject<Item> createFoodItem(String id, float staturation, int nutrition, MobEffect effect, int level, int duration, float probability, CreativeModeTab itemGroup, boolean isFireProof){
        if(isFireProof){
            return ITEMS.register(id, () -> new Item(new Item.Properties().tab(itemGroup).food(new FoodProperties.Builder().saturationMod(staturation).alwaysEat().nutrition(nutrition).effect(() ->  new MobEffectInstance(effect, level, duration), probability).build()).fireResistant()));
        }
        return ITEMS.register(id, () -> new Item(new Item.Properties().tab(itemGroup).food(new FoodProperties.Builder().saturationMod(staturation).alwaysEat().nutrition(nutrition).effect(() ->  new MobEffectInstance(effect, level, duration), probability).build())));
    }

    private static RegistryObject<Item> createSwordItem(String id, Tier tier, int level, CreativeModeTab itemGroup, boolean isFireProof){
        if(isFireProof) {
        	return ITEMS.register(id, () -> new SwordItem(tier, level, -2.4F, new Item.Properties().tab(itemGroup).fireResistant()));
        }
        return ITEMS.register(id, () -> new SwordItem(tier, level, -2.4F, new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createPickaxeItem(String id, Tier tier, int level, CreativeModeTab itemGroup, boolean isFireProof){
        if(isFireProof) {
        	return ITEMS.register(id, () -> new PickaxeItem(tier, level, -2.8F, new Item.Properties().tab(itemGroup).fireResistant()));
        }
        return ITEMS.register(id, () -> new PickaxeItem(tier, level, -2.8F, new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createAxeItem(String id, Tier tier, float level, CreativeModeTab itemGroup, boolean isFireProof){
        if(isFireProof) {
        	return ITEMS.register(id, () -> new AxeItem(tier, level, -3.2F, new Item.Properties().tab(itemGroup).fireResistant()));
        }
        return ITEMS.register(id, () -> new AxeItem(tier, level, -3.2F, new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createShovelItem(String id, Tier tier, float level, CreativeModeTab itemGroup, boolean isFireProof){
        if(isFireProof) {
        	return ITEMS.register(id, () -> new ShovelItem(tier, level, -3F, new Item.Properties().tab(itemGroup).fireResistant()));
        }
        return ITEMS.register(id, () -> new ShovelItem(tier, level, -3F, new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createHoeItem(String id, Tier tier, int level, CreativeModeTab itemGroup, boolean isFireProof){
        if(isFireProof) {
        	return ITEMS.register(id, () -> new HoeItem(tier, level, -3F, new Item.Properties().tab(itemGroup).fireResistant()));
        }
        return ITEMS.register(id, () -> new HoeItem(tier, level, -3F, new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createArmorItem(String id, ArmorMaterial material, EquipmentSlot slot, CreativeModeTab itemGroup, boolean isFireProof){
        if(isFireProof) {
        	return ITEMS.register(id, () -> new ArmorItem(material, slot, new Item.Properties().tab(itemGroup).fireResistant()));
        }
        return ITEMS.register(id, () -> new ArmorItem(material, slot, new Item.Properties().tab(itemGroup)));
    }

    private static RegistryObject<Item> createDiscItem(String id, int comparatorValue, RegistryObject<SoundEvent> sound, CreativeModeTab itemGroup, int seconds){
        return ITEMS.register(id, () -> new RecordItem(comparatorValue, () -> sound.get(), new Item.Properties().tab(itemGroup).stacksTo(1), DEMath.secondsToTicks(seconds)));
    }

    private static RegistryObject<Item> createHorseArmorItem(String id, int armorValue, String tierID, CreativeModeTab itemGroup, boolean isFireProof){
        if(isFireProof) {
        	return ITEMS.register(id, () -> new HorseArmorItem(armorValue, new ResourceLocation(DEMod.MOD_ID, "textures/entity/horse/armor/horse_armor_" + tierID + ".png"), new Item.Properties().tab(itemGroup).fireResistant()));
        }
    	return ITEMS.register(id, () -> new HorseArmorItem(armorValue, new ResourceLocation(DEMod.MOD_ID, "textures/entity/horse/armor/horse_armor_" + tierID + ".png"), new Item.Properties().tab(itemGroup)));
    }

    @SuppressWarnings("unused")
	private static RegistryObject<Item> createBannerPatternItem(String id, TagKey<BannerPattern> pattern, CreativeModeTab itemGroup){
        return ITEMS.register(id, () -> new BannerPatternItem(pattern, new Item.Properties().tab(itemGroup)));
    }
    
    private static <T extends Item> RegistryObject<T> createCustomItem(String id, Supplier<T> item){
        return ITEMS.register(id, item);
    }

    @OnlyIn(Dist.CLIENT)
    public static void addItemsProperites(){
        addClockProperties(TIME_POWER_STONE.get());
        addCompassProperties(COORD_LINKER.get());
    }

    @OnlyIn(Dist.CLIENT)
    private static void addClockProperties(Item item){
        ItemProperties.register(item, new ResourceLocation("time"), new ClampedItemPropertyFunction() {
            private double rotation;
            private double rota;
            private long lastUpdateTick;

            public float unclampedCall(ItemStack p_174665_, @Nullable ClientLevel p_174666_, @Nullable LivingEntity p_174667_, int p_174668_) {
                Entity entity = p_174667_ != null ? p_174667_ : p_174665_.getEntityRepresentation();
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
                            d0 = p_174666_.getTimeOfDay(1.0F);
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
    
    @OnlyIn(Dist.CLIENT)
    private static void addCompassProperties(Item item) {
    	ItemProperties.register(
    			item,
    			new ResourceLocation("angle"),
    			new CompassItemPropertyFunction((p_234992_, p_234993_, p_234994_) -> {
    				return CompassItem.getSpawnPosition(p_234992_);
    			})
    	);
    }

}
