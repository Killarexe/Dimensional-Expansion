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
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.*;

import java.util.HashMap;
import java.util.function.Supplier;

import javax.annotation.Nullable;

public class DEItems {

	public static final HashMap<String, DECreativeTabs> itemsTab = new HashMap<>();
	
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DEMod.MOD_ID);

    /* ITEMS */
    public static final RegistryObject<Item> RAW_PALON = createItem("raw_palon", DECreativeTabs.MISC, false);
    public static final RegistryObject<Item> PALON_INGOT = createItem("palon_ingot", DECreativeTabs.MISC, false);
    public static final RegistryObject<Item> PALON_NUGGET = createItem("palon_nugget", DECreativeTabs.MISC, false);
    public static final RegistryObject<Item> PALON_SWORD = createSwordItem("palon_sword", DEItemTier.PALON, 3, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<Item> PALON_PICKAXE = createPickaxeItem("palon_pickaxe", DEItemTier.PALON, 6, DECreativeTabs.TOOLS, false);
    public static final RegistryObject<Item> PALON_AXE = createAxeItem("palon_axe", DEItemTier.PALON, 6, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<Item> PALON_SHOVEL = createShovelItem("palon_shovel", DEItemTier.PALON, 1.5f, DECreativeTabs.TOOLS, false);
    public static final RegistryObject<Item> PALON_HOE = createHoeItem("palon_hoe", DEItemTier.PALON, 0, DECreativeTabs.TOOLS, false);
    public static final RegistryObject<Item> PALON_HELMET = createArmorItem("palon_helmet", DEArmorMaterial.PALON, EquipmentSlot.HEAD, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<Item> PALON_CHESTPLATE = createArmorItem("palon_chestplate", DEArmorMaterial.PALON, EquipmentSlot.CHEST, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<Item> PALON_LEGGINGS = createArmorItem("palon_leggings", DEArmorMaterial.PALON, EquipmentSlot.LEGS, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<Item> PALON_BOOTS = createArmorItem("palon_boots", DEArmorMaterial.PALON, EquipmentSlot.FEET, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<Item> PALON_HORSE_ARMOR = createHorseArmorItem("palon_horse_armor", 6, "palon", DECreativeTabs.COMBAT, false);
    public static final RegistryObject<Item> PALON_MIXED_COAL = createFuelItem("palon_mixed_coal", 3200, DECreativeTabs.MISC, false);

    public static final RegistryObject<Item> BASSMITE_GEM = createItem("bassmite_gem", DECreativeTabs.MISC, false);
    public static final RegistryObject<Item> BASSMITE_SWORD = createSwordItem("bassmite_sword", DEItemTier.BASSMITE, 3, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<Item> BASSMITE_PICKAXE = createPickaxeItem("bassmite_pickaxe", DEItemTier.BASSMITE, 6, DECreativeTabs.TOOLS, false);
    public static final RegistryObject<Item> BASSMITE_AXE = createAxeItem("bassmite_axe", DEItemTier.BASSMITE, 6, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<Item> BASSMITE_SHOVEL = createShovelItem("bassmite_shovel", DEItemTier.BASSMITE, 1.5f, DECreativeTabs.TOOLS, false);
    public static final RegistryObject<Item> BASSMITE_HOE = createHoeItem("bassmite_hoe", DEItemTier.BASSMITE, 0, DECreativeTabs.TOOLS, false);
    public static final RegistryObject<Item> BASSMITE_HELMET = createArmorItem("bassmite_helmet", DEArmorMaterial.BASSMITE, EquipmentSlot.HEAD, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<Item> BASSMITE_CHESTPLATE = createArmorItem("bassmite_chestplate", DEArmorMaterial.BASSMITE, EquipmentSlot.CHEST, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<Item> BASSMITE_LEGGINGS = createArmorItem("bassmite_leggings", DEArmorMaterial.BASSMITE, EquipmentSlot.LEGS, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<Item> BASSMITE_BOOTS = createArmorItem("bassmite_boots", DEArmorMaterial.BASSMITE, EquipmentSlot.FEET, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<Item> BASSMITE_HORSE_ARMOR = createHorseArmorItem("bassmite_horse_armor", 10, "bassmite", DECreativeTabs.COMBAT, false);
    public static final RegistryObject<Item> BASSMITE_MIXED_COAL = createFuelItem("bassmite_mixed_coal", 6400, DECreativeTabs.MISC, false);

    public static final RegistryObject<Item> RAW_SIMIX = createItem("raw_simix", DECreativeTabs.MISC, true);
    public static final RegistryObject<Item> SIMIX_INGOT = createItem("simix_ingot", DECreativeTabs.MISC, true);
    public static final RegistryObject<Item> SIMIX_NUGGET = createItem("simix_nugget", DECreativeTabs.MISC, true);
    public static final RegistryObject<Item> SIMIX_HAMMER = ITEMS.register("simix_hammer", () -> new SimixHammerItem());
    public static final RegistryObject<Item> SIMIX_SWORD = createSwordItem("simix_sword", DEItemTier.SIMIX, 3, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<Item> SIMIX_PICKAXE = createPickaxeItem("simix_pickaxe", DEItemTier.SIMIX, 6, DECreativeTabs.TOOLS, true);
    public static final RegistryObject<Item> SIMIX_AXE = createAxeItem("simix_axe", DEItemTier.SIMIX, 6, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<Item> SIMIX_SHOVEL = createShovelItem("simix_shovel", DEItemTier.SIMIX, 1.5f, DECreativeTabs.TOOLS, true);
    public static final RegistryObject<Item> SIMIX_HOE = createHoeItem("simix_hoe", DEItemTier.SIMIX, 0, DECreativeTabs.TOOLS, true);
    public static final RegistryObject<Item> SIMIX_HELMET = createArmorItem("simix_helmet", DEArmorMaterial.SIMIX, EquipmentSlot.HEAD, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<Item> SIMIX_CHESTPLATE = createArmorItem("simix_chestplate", DEArmorMaterial.SIMIX, EquipmentSlot.CHEST, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<Item> SIMIX_LEGGINGS = createArmorItem("simix_leggings", DEArmorMaterial.SIMIX, EquipmentSlot.LEGS, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<Item> SIMIX_BOOTS = createArmorItem("simix_boots", DEArmorMaterial.SIMIX, EquipmentSlot.FEET, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<Item> SIMIX_HORSE_ARMOR = createHorseArmorItem("simix_horse_armor", 14, "simix", DECreativeTabs.COMBAT, true);
    public static final RegistryObject<Item> SIMIX_MIXED_COAL = createFuelItem("simix_mixed_coal", 12800, DECreativeTabs.MISC, true);

    public static final RegistryObject<Item> EMERTYST_GEM = createItem("emertyst_gem", DECreativeTabs.MISC, true);
    public static final RegistryObject<Item> EMERTYST_SWORD = createSwordItem("emertyst_sword", DEItemTier.EMERTYST, 3, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<Item> EMERTYST_PICKAXE = createPickaxeItem("emertyst_pickaxe", DEItemTier.EMERTYST, 5, DECreativeTabs.TOOLS, true);
    public static final RegistryObject<Item> EMERTYST_AXE = createAxeItem("emertyst_axe", DEItemTier.EMERTYST, 6, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<Item> EMERTYST_SHOVEL = createShovelItem("emertyst_shovel", DEItemTier.EMERTYST, 1.5f, DECreativeTabs.TOOLS, true);
    public static final RegistryObject<Item> EMERTYST_HOE = createHoeItem("emertyst_hoe", DEItemTier.EMERTYST, 0, DECreativeTabs.TOOLS, true);
    public static final RegistryObject<Item> EMERTYST_HELMET = createArmorItem("emertyst_helmet", DEArmorMaterial.EMERTYST, EquipmentSlot.HEAD, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<Item> EMERTYST_CHESTPLATE = createArmorItem("emertyst_chestplate", DEArmorMaterial.EMERTYST, EquipmentSlot.CHEST, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<Item> EMERTYST_LEGGINGS = createArmorItem("emertyst_leggings", DEArmorMaterial.EMERTYST, EquipmentSlot.LEGS, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<Item> EMERTYST_BOOTS = createArmorItem("emertyst_boots", DEArmorMaterial.EMERTYST, EquipmentSlot.FEET, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<Item> EMERTYST_HORSE_ARMOR = createHorseArmorItem("emertyst_horse_armor", 22, "emertyst", DECreativeTabs.COMBAT, true);
    public static final RegistryObject<Item> EMERTYST_MIXED_COAL = createFuelItem("emertyst_mixed_coal", 25600, DECreativeTabs.MISC, true);

    public static final RegistryObject<Item> ALLOY_CRYSTAL = createItem("alloy_crystal", () -> new AlloyCrystal(), DECreativeTabs.MISC);
    
    public static final RegistryObject<Item> PURPLE_BERRY = createItem("purple_berry", () -> new PurpleBerry(), DECreativeTabs.MISC);

    public static final RegistryObject<Item> WEATHER_POWER_STONE = createItem("weather_power_stone", () -> new WeatherPowerStone(), DECreativeTabs.MISC);
    public static final RegistryObject<Item> TIME_POWER_STONE = createItem("time_power_stone", () -> new TimePowerStone(), DECreativeTabs.MISC);
    public static final RegistryObject<Item> WARP_POWER_STONE = createItem("warp_power_stone", () -> new WarpPowerStone(), DECreativeTabs.MISC);
    public static final RegistryObject<Item> COORD_LINKER = createItem("coord_linker", () -> new CoordLinker(), DECreativeTabs.MISC);
    public static final RegistryObject<Item> REMOTE_TELEPORTER = createItem("remote_teleporter", () -> new RemoteTeleporter(), DECreativeTabs.MISC);

    public static final RegistryObject<Item> PEARL_ESSENCE = createItem("pearl_essence", DECreativeTabs.MISC, false);

    public static final RegistryObject<Item> ORIGIN_PORTAL_KEY = createItem("origin_portal_key", () -> new OriginPortalKey(), DECreativeTabs.TOOLS);
    
    public static final RegistryObject<Item> PURPLEHEART_SIGN = createItem("purpleheart_sign", () -> new SignItem(new Item.Properties().stacksTo(16), DEBlocks.PURPLEHEART_SIGN.get(), DEBlocks.PURPLEHEART_WALL_SIGN.get()), DECreativeTabs.BLOCKS);
    public static final RegistryObject<Item> PURPLEHEART_BOAT = createItem("purpleheart_boat", () -> new EndBoatItem(new Item.Properties().stacksTo(1).fireResistant(), PurpleheartBoatEntity.Type.PURPLEHEART), DECreativeTabs.MISC);

    public static final RegistryObject<Item> SWEDEN_DISC = createDiscItem("sweden_disc", 7, DESounds.SWEDEN_REMIX, DECreativeTabs.MISC, 0);
    public static final RegistryObject<Item> DOCTOR_WHO_DISC = createDiscItem("doctor_who_disc", 3, DESounds.DOCTOR_WHO, DECreativeTabs.MISC, 0);

    public static RegistryObject<Item> createItem(String id, Supplier<Item> item, DECreativeTabs tab){
    	itemsTab.put(id, tab);
    	return ITEMS.register(id, item);
    }
    
    private static RegistryObject<Item> createItem(String id, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof){
            return ITEMS.register(id, () -> new Item(new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new Item(new Item.Properties()));
    }

    private static RegistryObject<Item> createFuelItem(String id, int burnTime, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof){
            return ITEMS.register(id, () -> new FuelItem(new Item.Properties().fireResistant(), burnTime));
        }
        return ITEMS.register(id, () -> new FuelItem(new Item.Properties(), burnTime));
    }

    @SuppressWarnings("unused")
	private static RegistryObject<Item> createFoodItem(String id, float staturation, int nutrition, MobEffect effect, int level, int duration, float probability, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof){
            return ITEMS.register(id, () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(staturation).alwaysEat().nutrition(nutrition).effect(() ->  new MobEffectInstance(effect, level, duration), probability).build()).fireResistant()));
        }
        return ITEMS.register(id, () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(staturation).alwaysEat().nutrition(nutrition).effect(() ->  new MobEffectInstance(effect, level, duration), probability).build())));
    }

    private static RegistryObject<Item> createSwordItem(String id, Tier tier, int level, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new SwordItem(tier, level, -2.4F, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new SwordItem(tier, level, -2.4F, new Item.Properties()));
    }

    private static RegistryObject<Item> createPickaxeItem(String id, Tier tier, int level, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new PickaxeItem(tier, level, -2.8F, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new PickaxeItem(tier, level, -2.8F, new Item.Properties()));
    }

    private static RegistryObject<Item> createAxeItem(String id, Tier tier, float level, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new AxeItem(tier, level, -3.2F, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new AxeItem(tier, level, -3.2F, new Item.Properties()));
    }

    private static RegistryObject<Item> createShovelItem(String id, Tier tier, float level, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new ShovelItem(tier, level, -3F, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new ShovelItem(tier, level, -3F, new Item.Properties()));
    }

    private static RegistryObject<Item> createHoeItem(String id, Tier tier, int level, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new HoeItem(tier, level, -3F, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new HoeItem(tier, level, -3F, new Item.Properties()));
    }

    private static RegistryObject<Item> createArmorItem(String id, ArmorMaterial material, EquipmentSlot slot, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new ArmorItem(material, slot, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new ArmorItem(material, slot, new Item.Properties()));
    }

    private static RegistryObject<Item> createDiscItem(String id, int comparatorValue, RegistryObject<SoundEvent> sound, DECreativeTabs tab, int seconds){
        return ITEMS.register(id, () -> new RecordItem(comparatorValue, () -> sound.get(), new Item.Properties().stacksTo(1), DEMath.secondsToTicks(seconds)));
    }

    private static RegistryObject<Item> createHorseArmorItem(String id, int armorValue, String tierID, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new HorseArmorItem(armorValue, new ResourceLocation(DEMod.MOD_ID, "textures/entity/horse/armor/horse_armor_" + tierID + ".png"), new Item.Properties().fireResistant()));
        }
    	return ITEMS.register(id, () -> new HorseArmorItem(armorValue, new ResourceLocation(DEMod.MOD_ID, "textures/entity/horse/armor/horse_armor_" + tierID + ".png"), new Item.Properties()));
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
