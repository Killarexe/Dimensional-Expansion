package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.entity.DEBoatEntity;
import net.killarexe.dimensional_expansion.common.entity.DEChestBoatEntity;
import net.killarexe.dimensional_expansion.common.item.*;
import net.killarexe.dimensional_expansion.common.item.BoatItem;
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
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
    public static final RegistryObject<FuelItem> PALON_MIXED_COAL = createFuelItem("palon_mixed_coal", 3200, DECreativeTabs.MISC, false);

    public static final RegistryObject<Item> BASSMITE_GEM = createItem("bassmite_gem", DECreativeTabs.MISC, false);
    public static final RegistryObject<SwordItem> BASSMITE_SWORD = createSwordItem("bassmite_sword", DEItemTier.BASSMITE, 3, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<PickaxeItem> BASSMITE_PICKAXE = createPickaxeItem("bassmite_pickaxe", DEItemTier.BASSMITE, 6, DECreativeTabs.TOOLS, false);
    public static final RegistryObject<AxeItem> BASSMITE_AXE = createAxeItem("bassmite_axe", DEItemTier.BASSMITE, 6, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<ShovelItem> BASSMITE_SHOVEL = createShovelItem("bassmite_shovel", DEItemTier.BASSMITE, 1.5f, DECreativeTabs.TOOLS, false);
    public static final RegistryObject<HoeItem> BASSMITE_HOE = createHoeItem("bassmite_hoe", DEItemTier.BASSMITE, 0, DECreativeTabs.TOOLS, false);
    public static final RegistryObject<ArmorItem> BASSMITE_HELMET = createArmorItem("bassmite_helmet", DEArmorMaterial.BASSMITE, ArmorItem.Type.HELMET, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<ArmorItem> BASSMITE_CHESTPLATE = createArmorItem("bassmite_chestplate", DEArmorMaterial.BASSMITE, ArmorItem.Type.CHESTPLATE, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<ArmorItem> BASSMITE_LEGGINGS = createArmorItem("bassmite_leggings", DEArmorMaterial.BASSMITE, ArmorItem.Type.LEGGINGS, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<ArmorItem> BASSMITE_BOOTS = createArmorItem("bassmite_boots", DEArmorMaterial.BASSMITE, ArmorItem.Type.BOOTS, DECreativeTabs.COMBAT, false);
    public static final RegistryObject<HorseArmorItem> BASSMITE_HORSE_ARMOR = createHorseArmorItem("bassmite_horse_armor", 10, "bassmite", DECreativeTabs.COMBAT, false);
    public static final RegistryObject<FuelItem> BASSMITE_MIXED_COAL = createFuelItem("bassmite_mixed_coal", 6400, DECreativeTabs.MISC, false);

    public static final RegistryObject<Item> RAW_SIMIX = createItem("raw_simix", DECreativeTabs.MISC, true);
    public static final RegistryObject<Item> SIMIX_INGOT = createItem("simix_ingot", DECreativeTabs.MISC, true);
    public static final RegistryObject<Item> SIMIX_NUGGET = createItem("simix_nugget", DECreativeTabs.MISC, true);
    public static final RegistryObject<Item> SIMIX_HAMMER = createItem("simix_hammer", () -> new SimixHammerItem(), DECreativeTabs.TOOLS);
    public static final RegistryObject<FuelItem> SIMIX_MIXED_COAL = createFuelItem("simix_mixed_coal", 12800, DECreativeTabs.MISC, true);

    public static final RegistryObject<Item> EMERTYST_GEM = createItem("emertyst_gem", DECreativeTabs.MISC, true);
    public static final RegistryObject<SwordItem> EMERTYST_SWORD = createSwordItem("emertyst_sword", DEItemTier.EMERTYST, 3, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<PickaxeItem> EMERTYST_PICKAXE = createPickaxeItem("emertyst_pickaxe", DEItemTier.EMERTYST, 5, DECreativeTabs.TOOLS, true);
    public static final RegistryObject<AxeItem> EMERTYST_AXE = createAxeItem("emertyst_axe", DEItemTier.EMERTYST, 6, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<ShovelItem> EMERTYST_SHOVEL = createShovelItem("emertyst_shovel", DEItemTier.EMERTYST, 1.5f, DECreativeTabs.TOOLS, true);
    public static final RegistryObject<HoeItem> EMERTYST_HOE = createHoeItem("emertyst_hoe", DEItemTier.EMERTYST, 0, DECreativeTabs.TOOLS, true);
    public static final RegistryObject<ArmorItem> EMERTYST_HELMET = createArmorItem("emertyst_helmet", DEArmorMaterial.EMERTYST, ArmorItem.Type.HELMET, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<ArmorItem> EMERTYST_CHESTPLATE = createArmorItem("emertyst_chestplate", DEArmorMaterial.EMERTYST, ArmorItem.Type.CHESTPLATE, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<ArmorItem> EMERTYST_LEGGINGS = createArmorItem("emertyst_leggings", DEArmorMaterial.EMERTYST, ArmorItem.Type.LEGGINGS, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<ArmorItem> EMERTYST_BOOTS = createArmorItem("emertyst_boots", DEArmorMaterial.EMERTYST, ArmorItem.Type.BOOTS, DECreativeTabs.COMBAT, true);
    public static final RegistryObject<HorseArmorItem> EMERTYST_HORSE_ARMOR = createHorseArmorItem("emertyst_horse_armor", 22, "emertyst", DECreativeTabs.COMBAT, true);
    public static final RegistryObject<FuelItem> EMERTYST_MIXED_COAL = createFuelItem("emertyst_mixed_coal", 25600, DECreativeTabs.MISC, true);

    public static final RegistryObject<Item> ALLOY_CRYSTAL = createItem("alloy_crystal", () -> new AlloyCrystal(), DECreativeTabs.MISC);
    
    public static final RegistryObject<PurpleBerry> PURPLE_BERRY = createItem("purple_berry", () -> new PurpleBerry(), DECreativeTabs.MISC);
    public static final RegistryObject<SavorleafItem> SAVORLEAF = createItem("savorleaf", () -> new SavorleafItem(), DECreativeTabs.MISC);
    public static final RegistryObject<VioletCarrot> VIOLET_CARROT = createItem("violet_carrot", () -> new VioletCarrot(), DECreativeTabs.MISC); 
    
    public static final RegistryObject<Item> WEATHER_POWER_STONE = createItem("weather_power_stone", () -> new WeatherPowerStone(), DECreativeTabs.MISC);
    public static final RegistryObject<Item> REMOTE_POWER_STONE = createItem("remote_power_stone", () -> new RemotePowerStone(), DECreativeTabs.MISC);
    public static final RegistryObject<Item> TIME_POWER_STONE = createItem("time_power_stone", () -> new TimePowerStone(), DECreativeTabs.MISC);
    public static final RegistryObject<Item> WARP_POWER_STONE = createItem("warp_power_stone", () -> new WarpPowerStone(), DECreativeTabs.MISC);
    public static final RegistryObject<Item> COORD_LINKER = createItem("coord_linker", () -> new CoordLinker(), DECreativeTabs.MISC);

    public static final RegistryObject<Item> PEARL_ESSENCE = createItem("pearl_essence", DECreativeTabs.MISC, false);

    public static final RegistryObject<Item> ORIGIN_PORTAL_KEY = createItem("origin_portal_key", () -> new OriginPortalKey(), DECreativeTabs.TOOLS);
    
    public static final RegistryObject<Item> PURPLEHEART_SIGN = createItem("purpleheart_sign", () -> new SignItem(new Item.Properties().stacksTo(16), DEBlocks.PURPLEHEART_SIGN.get(), DEBlocks.PURPLEHEART_WALL_SIGN.get()), DECreativeTabs.BLOCKS);
    public static final RegistryObject<Item> PURPLEHEART_BOAT = createItem("purpleheart_boat", () -> new BoatItem(new Item.Properties().stacksTo(1).fireResistant(), DEBoatEntity.Type.PURPLEHEART), DECreativeTabs.MISC);
    public static final RegistryObject<Item> PURPLEHEART_CHEST_BOAT = createItem("purpleheart_chest_boat", () -> new ChestBoatItem(new Item.Properties().stacksTo(1).fireResistant(), DEChestBoatEntity.Type.PURPLEHEART), DECreativeTabs.MISC);
    
    public static final RegistryObject<RecordItem> SWEDEN_DISC = createDiscItem("sweden_disc", 7, DESounds.SWEDEN_REMIX, DECreativeTabs.MISC, 0);
    public static final RegistryObject<RecordItem> DOCTOR_WHO_DISC = createDiscItem("doctor_who_disc", 3, DESounds.DOCTOR_WHO, DECreativeTabs.MISC, 0);

    public static <T extends Item> RegistryObject<T> createItem(String id, Supplier<T> item){
    	return ITEMS.register(id, item);
    }
    
    public static <T extends Item> RegistryObject<T> createItem(String id, Supplier<T> item, DECreativeTabs tab){
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

    private static RegistryObject<FuelItem> createFuelItem(String id, int burnTime, DECreativeTabs tab, boolean isFireProof){
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

    private static RegistryObject<SwordItem> createSwordItem(String id, Tier tier, int level, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new SwordItem(tier, level, -2.4F, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new SwordItem(tier, level, -2.4F, new Item.Properties()));
    }

    private static RegistryObject<PickaxeItem> createPickaxeItem(String id, Tier tier, int level, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new PickaxeItem(tier, level, -2.8F, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new PickaxeItem(tier, level, -2.8F, new Item.Properties()));
    }

    private static RegistryObject<AxeItem> createAxeItem(String id, Tier tier, float level, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new AxeItem(tier, level, -3.2F, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new AxeItem(tier, level, -3.2F, new Item.Properties()));
    }

    private static RegistryObject<ShovelItem> createShovelItem(String id, Tier tier, float level, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new ShovelItem(tier, level, -3F, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new ShovelItem(tier, level, -3F, new Item.Properties()));
    }

    private static RegistryObject<HoeItem> createHoeItem(String id, Tier tier, int level, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new HoeItem(tier, level, -3F, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new HoeItem(tier, level, -3F, new Item.Properties()));
    }

    private static RegistryObject<ArmorItem> createArmorItem(String id, ArmorMaterial material, ArmorItem.Type slot, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new ArmorItem(material, slot, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new ArmorItem(material, slot, new Item.Properties()));
    }

    private static RegistryObject<RecordItem> createDiscItem(String id, int comparatorValue, RegistryObject<SoundEvent> sound, DECreativeTabs tab, int seconds){
        return ITEMS.register(id, () -> new RecordItem(comparatorValue, () -> sound.get(), new Item.Properties().stacksTo(1), DEMath.secondsToTicks(seconds)));
    }

    private static RegistryObject<HorseArmorItem> createHorseArmorItem(String id, int armorValue, String tierID, DECreativeTabs tab, boolean isFireProof){
    	itemsTab.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new HorseArmorItem(armorValue, new ResourceLocation(DEMod.MOD_ID, "textures/entity/horse/armor/horse_armor_" + tierID + ".png"), new Item.Properties().fireResistant()));
        }
    	return ITEMS.register(id, () -> new HorseArmorItem(armorValue, new ResourceLocation(DEMod.MOD_ID, "textures/entity/horse/armor/horse_armor_" + tierID + ".png"), new Item.Properties()));
    }

    @OnlyIn(Dist.CLIENT)
    public static void addItemsProperites(){
    	addRemoteProperties(REMOTE_POWER_STONE.get());
        addClockProperties(TIME_POWER_STONE.get());
        addCompassProperties(COORD_LINKER.get());
    }

    @OnlyIn(Dist.CLIENT)
    private static void addClockProperties(Item item){
        ItemProperties.register(item, new ResourceLocation("time"), new ClampedItemPropertyFunction() {
            private double rotation;
            private double rota;
            private long lastUpdateTick;

            public float unclampedCall(ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity livingEntity, int seed) {
                Entity entity = livingEntity != null ? livingEntity : stack.getEntityRepresentation();
                if (entity == null) {
                    return 0.0F;
                } else {
                    if (level == null && entity.level instanceof ClientLevel) {
                        level = (ClientLevel) entity.level;
                    }

                    if (level == null) {
                        return 0.0F;
                    } else {
                        double value;
                        if (level.dimensionType().natural()) {
                        	value = level.getTimeOfDay(1.0F);
                        } else {
                        	value = Math.random();
                        }

                        value = this.wobble(level, value);
                        return (float) value;
                    }
                }
            }

            private double wobble(Level level, double value) {
                if (level.getGameTime() != this.lastUpdateTick) {
                    this.lastUpdateTick = level.getGameTime();
                    double d0 = value - this.rotation;
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
    private static void addRemoteProperties(Item item) {
    	ItemProperties.register(item, new ResourceLocation("duration"), new ClampedItemPropertyFunction() {
			@Override
			public float unclampedCall(ItemStack pStack, ClientLevel pLevel, LivingEntity pEntity, int pSeed) {
				if(pLevel == null && pEntity.getLevel() instanceof @SuppressWarnings("resource") ClientLevel level) {
					pLevel = level;
				}
				if(pLevel == null) {
					return 0;
				}
				if(pEntity instanceof Player player) {
					if(player.hasEffect(DEPoitions.REMOTE_EFFECT.get())) {
						int value = DEMath.clamp(player.getEffect(DEPoitions.REMOTE_EFFECT.get()).getDuration(), 0, 30);
						DEMod.LOGGER.info(value);
						return value;
					}
				}
				return 0;
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
