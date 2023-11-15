package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.entity.DEBoatEntity;
import net.killarexe.dimensional_expansion.common.entity.DEChestBoatEntity;
import net.killarexe.dimensional_expansion.common.item.*;
import net.killarexe.dimensional_expansion.common.item.BoatItem;
import net.killarexe.dimensional_expansion.common.item.material.*;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.*;

import java.util.HashMap;
import java.util.function.Supplier;

import javax.annotation.Nullable;

public class DEItems {

	public static final HashMap<String, DECreativeTabs.Tabs> ITEM_TAB_MAP = new HashMap<>();
	
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DEMod.MOD_ID);

    public static final RegistryObject<Item> RAW_PALON = createItem("raw_palon", DECreativeTabs.Tabs.MISC, false);
    public static final RegistryObject<Item> PALON_INGOT = createItem("palon_ingot", DECreativeTabs.Tabs.MISC, false);
    public static final RegistryObject<Item> PALON_NUGGET = createItem("palon_nugget", DECreativeTabs.Tabs.MISC, false);
    public static final RegistryObject<FuelItem> PALON_MIXED_COAL = createFuelItem("palon_mixed_coal", 3200, DECreativeTabs.Tabs.MISC, false);

    public static final RegistryObject<Item> BASSMITE_GEM = createItem("bassmite_gem", DECreativeTabs.Tabs.MISC, false);
    public static final RegistryObject<SwordItem> BASSMITE_SWORD = createSwordItem("bassmite_sword", DEItemTier.BASSMITE, 3, DECreativeTabs.Tabs.COMBAT, false);
    public static final RegistryObject<PickaxeItem> BASSMITE_PICKAXE = createPickaxeItem("bassmite_pickaxe", DEItemTier.BASSMITE, 6, DECreativeTabs.Tabs.TOOLS, false);
    public static final RegistryObject<AxeItem> BASSMITE_AXE = createAxeItem("bassmite_axe", DEItemTier.BASSMITE, 6, DECreativeTabs.Tabs.COMBAT, false);
    public static final RegistryObject<ShovelItem> BASSMITE_SHOVEL = createShovelItem("bassmite_shovel", DEItemTier.BASSMITE, 1.5f, DECreativeTabs.Tabs.TOOLS, false);
    public static final RegistryObject<HoeItem> BASSMITE_HOE = createHoeItem("bassmite_hoe", DEItemTier.BASSMITE, 0, DECreativeTabs.Tabs.TOOLS, false);
    public static final RegistryObject<ArmorItem> BASSMITE_HELMET = createArmorItem("bassmite_helmet", DEArmorMaterial.BASSMITE, ArmorItem.Type.HELMET, DECreativeTabs.Tabs.COMBAT, false);
    public static final RegistryObject<ArmorItem> BASSMITE_CHESTPLATE = createArmorItem("bassmite_chestplate", DEArmorMaterial.BASSMITE, ArmorItem.Type.CHESTPLATE, DECreativeTabs.Tabs.COMBAT, false);
    public static final RegistryObject<ArmorItem> BASSMITE_LEGGINGS = createArmorItem("bassmite_leggings", DEArmorMaterial.BASSMITE, ArmorItem.Type.LEGGINGS, DECreativeTabs.Tabs.COMBAT, false);
    public static final RegistryObject<ArmorItem> BASSMITE_BOOTS = createArmorItem("bassmite_boots", DEArmorMaterial.BASSMITE, ArmorItem.Type.BOOTS, DECreativeTabs.Tabs.COMBAT, false);
    public static final RegistryObject<HorseArmorItem> BASSMITE_HORSE_ARMOR = createHorseArmorItem("bassmite_horse_armor", 10, "bassmite", DECreativeTabs.Tabs.COMBAT, false);
    public static final RegistryObject<FuelItem> BASSMITE_MIXED_COAL = createFuelItem("bassmite_mixed_coal", 6400, DECreativeTabs.Tabs.MISC, false);

    public static final RegistryObject<Item> RAW_SIMIX = createItem("raw_simix", DECreativeTabs.Tabs.MISC, true);
    public static final RegistryObject<Item> SIMIX_INGOT = createItem("simix_ingot", DECreativeTabs.Tabs.MISC, true);
    public static final RegistryObject<Item> SIMIX_NUGGET = createItem("simix_nugget", DECreativeTabs.Tabs.MISC, true);
    public static final RegistryObject<Item> SIMIX_HAMMER = createItem("simix_hammer", () -> new SimixHammerItem(), DECreativeTabs.Tabs.TOOLS);
    public static final RegistryObject<FuelItem> SIMIX_MIXED_COAL = createFuelItem("simix_mixed_coal", 12800, DECreativeTabs.Tabs.MISC, true);

    public static final RegistryObject<Item> EMERTYST_GEM = createItem("emertyst_gem", DECreativeTabs.Tabs.MISC, true);
    public static final RegistryObject<SwordItem> EMERTYST_SWORD = createSwordItem("emertyst_sword", DEItemTier.EMERTYST, 3, DECreativeTabs.Tabs.COMBAT, true);
    public static final RegistryObject<PickaxeItem> EMERTYST_PICKAXE = createPickaxeItem("emertyst_pickaxe", DEItemTier.EMERTYST, 5, DECreativeTabs.Tabs.TOOLS, true);
    public static final RegistryObject<AxeItem> EMERTYST_AXE = createAxeItem("emertyst_axe", DEItemTier.EMERTYST, 6, DECreativeTabs.Tabs.COMBAT, true);
    public static final RegistryObject<ShovelItem> EMERTYST_SHOVEL = createShovelItem("emertyst_shovel", DEItemTier.EMERTYST, 1.5f, DECreativeTabs.Tabs.TOOLS, true);
    public static final RegistryObject<HoeItem> EMERTYST_HOE = createHoeItem("emertyst_hoe", DEItemTier.EMERTYST, 0, DECreativeTabs.Tabs.TOOLS, true);
    public static final RegistryObject<ArmorItem> EMERTYST_HELMET = createArmorItem("emertyst_helmet", DEArmorMaterial.EMERTYST, ArmorItem.Type.HELMET, DECreativeTabs.Tabs.COMBAT, true);
    public static final RegistryObject<ArmorItem> EMERTYST_CHESTPLATE = createArmorItem("emertyst_chestplate", DEArmorMaterial.EMERTYST, ArmorItem.Type.CHESTPLATE, DECreativeTabs.Tabs.COMBAT, true);
    public static final RegistryObject<ArmorItem> EMERTYST_LEGGINGS = createArmorItem("emertyst_leggings", DEArmorMaterial.EMERTYST, ArmorItem.Type.LEGGINGS, DECreativeTabs.Tabs.COMBAT, true);
    public static final RegistryObject<ArmorItem> EMERTYST_BOOTS = createArmorItem("emertyst_boots", DEArmorMaterial.EMERTYST, ArmorItem.Type.BOOTS, DECreativeTabs.Tabs.COMBAT, true);
    public static final RegistryObject<HorseArmorItem> EMERTYST_HORSE_ARMOR = createHorseArmorItem("emertyst_horse_armor", 22, "emertyst", DECreativeTabs.Tabs.COMBAT, true);
    public static final RegistryObject<FuelItem> EMERTYST_MIXED_COAL = createFuelItem("emertyst_mixed_coal", 25600, DECreativeTabs.Tabs.MISC, true);

    public static final RegistryObject<Item> ALLOY_CRYSTAL = createItem("alloy_crystal", () -> new AlloyCrystal(), DECreativeTabs.Tabs.MISC);
    
    public static final RegistryObject<PurpleBerry> PURPLE_BERRY = createItem("purple_berry", () -> new PurpleBerry(), DECreativeTabs.Tabs.MISC);
    public static final RegistryObject<SavorleafItem> SAVORLEAF = createItem("savorleaf", () -> new SavorleafItem(), DECreativeTabs.Tabs.MISC);
    public static final RegistryObject<VioletCarrot> VIOLET_CARROT = createItem("violet_carrot", () -> new VioletCarrot(), DECreativeTabs.Tabs.MISC); 
    
    public static final RegistryObject<Item> WEATHER_POWER_STONE = createItem("weather_power_stone", () -> new WeatherPowerStone(), DECreativeTabs.Tabs.MISC);
    public static final RegistryObject<Item> REMOTE_POWER_STONE = createItem("remote_power_stone", () -> new RemotePowerStone(), DECreativeTabs.Tabs.MISC);
    public static final RegistryObject<Item> TIME_POWER_STONE = createItem("time_power_stone", () -> new TimePowerStone(), DECreativeTabs.Tabs.MISC);
    public static final RegistryObject<Item> WARP_POWER_STONE = createItem("warp_power_stone", () -> new WarpPowerStone(), DECreativeTabs.Tabs.MISC);
    public static final RegistryObject<Item> COORD_LINKER = createItem("coord_linker", () -> new CoordLinker(), DECreativeTabs.Tabs.MISC);

    public static final RegistryObject<Item> ORIGIN_PORTAL_KEY = createItem("origin_portal_key", () -> new OriginPortalKey(), DECreativeTabs.Tabs.TOOLS);
    
    public static final RegistryObject<Item> PURPLEHEART_SIGN = createItem("purpleheart_sign", () -> new SignItem(new Item.Properties().stacksTo(16), DEBlocks.PURPLEHEART_SIGN.get(), DEBlocks.PURPLEHEART_WALL_SIGN.get()), DECreativeTabs.Tabs.BLOCKS);
    public static final RegistryObject<Item> PURPLEHEART_BOAT = createItem("purpleheart_boat", () -> new BoatItem(new Item.Properties().stacksTo(1).fireResistant(), DEBoatEntity.Type.PURPLEHEART), DECreativeTabs.Tabs.MISC);
    public static final RegistryObject<Item> PURPLEHEART_CHEST_BOAT = createItem("purpleheart_chest_boat", () -> new ChestBoatItem(new Item.Properties().stacksTo(1).fireResistant(), DEChestBoatEntity.Type.PURPLEHEART), DECreativeTabs.Tabs.MISC);
    
    public static final RegistryObject<RecordItem> SWEDEN_DISC = createDiscItem("sweden_disc", 7, DESoundEvents.MUSIC_DISC_SWEDEN_REMIX, DECreativeTabs.Tabs.MISC, 0);

    public static final RegistryObject<ForgeSpawnEggItem> HEADED_SKELETON_SPAWN_EGG = createSpawnEggItem("headed_skeleton_spawn_egg", DEEntityTypes.HEADED_SKELETON, 0xFFFFFF, 0xFFFFFF, DECreativeTabs.Tabs.MOBS);
    public static final RegistryObject<ForgeSpawnEggItem> HEADED_GUARDIAN_SPAWN_EGG = createSpawnEggItem("headed_guardian_spawn_egg", DEEntityTypes.HEADED_GUARDIAN, 0xFFFFFF, 0xFFFFFF, DECreativeTabs.Tabs.MOBS);
    public static final RegistryObject<ForgeSpawnEggItem> BLUE_SAND_MAN_SPAWN_EGG = createSpawnEggItem("blue_sand_man_spawn_egg", DEEntityTypes.BLUE_SAND_MAN, 0xFFFFFF, 0xFFFFFF, DECreativeTabs.Tabs.MOBS);
    public static final RegistryObject<ForgeSpawnEggItem> MOUVET_SPAWN_EGG = createSpawnEggItem("mouvet_spawn_egg", DEEntityTypes.MOUVET, 0xFFFFFF, 0xFFFFFF, DECreativeTabs.Tabs.MOBS);
    public static final RegistryObject<ForgeSpawnEggItem> JUGER_SPAWN_EGG = createSpawnEggItem("juger_spawn_egg", DEEntityTypes.JUGER, 0xFFFFFF, 0xFFFFFF, DECreativeTabs.Tabs.MOBS);
    
    public static final RegistryObject<MoboxItem> MOBOX = createItem("mobox", () -> new MoboxItem(), DECreativeTabs.Tabs.MISC);
    
    public static <T extends Item> RegistryObject<T> createItem(String id, Supplier<T> item){
    	return ITEMS.register(id, item);
    }
    
    public static <T extends Item> RegistryObject<T> createItem(String id, Supplier<T> item, DECreativeTabs.Tabs tab){
    	ITEM_TAB_MAP.put(id, tab);
    	return ITEMS.register(id, item);
    }
    
    private static RegistryObject<Item> createItem(String id, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof){
            return ITEMS.register(id, () -> new Item(new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new Item(new Item.Properties()));
    }

    private static RegistryObject<FuelItem> createFuelItem(String id, int burnTime, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof){
            return ITEMS.register(id, () -> new FuelItem(new Item.Properties().fireResistant(), burnTime));
        }
        return ITEMS.register(id, () -> new FuelItem(new Item.Properties(), burnTime));
    }

    @SuppressWarnings("unused")
	private static RegistryObject<Item> createFoodItem(String id, float staturation, int nutrition, MobEffect effect, int level, int duration, float probability, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof){
            return ITEMS.register(id, () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(staturation).alwaysEat().nutrition(nutrition).effect(() ->  new MobEffectInstance(effect, level, duration), probability).build()).fireResistant()));
        }
        return ITEMS.register(id, () -> new Item(new Item.Properties().food(new FoodProperties.Builder().saturationMod(staturation).alwaysEat().nutrition(nutrition).effect(() ->  new MobEffectInstance(effect, level, duration), probability).build())));
    }

    private static RegistryObject<SwordItem> createSwordItem(String id, Tier tier, int level, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new SwordItem(tier, level, -2.4F, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new SwordItem(tier, level, -2.4F, new Item.Properties()));
    }

    private static RegistryObject<PickaxeItem> createPickaxeItem(String id, Tier tier, int level, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new PickaxeItem(tier, level, -2.8F, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new PickaxeItem(tier, level, -2.8F, new Item.Properties()));
    }

    private static RegistryObject<AxeItem> createAxeItem(String id, Tier tier, float level, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new AxeItem(tier, level, -3.2F, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new AxeItem(tier, level, -3.2F, new Item.Properties()));
    }

    private static RegistryObject<ShovelItem> createShovelItem(String id, Tier tier, float level, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new ShovelItem(tier, level, -3F, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new ShovelItem(tier, level, -3F, new Item.Properties()));
    }

    private static RegistryObject<HoeItem> createHoeItem(String id, Tier tier, int level, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new HoeItem(tier, level, -3F, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new HoeItem(tier, level, -3F, new Item.Properties()));
    }

    private static RegistryObject<ArmorItem> createArmorItem(String id, ArmorMaterial material, ArmorItem.Type slot, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new ArmorItem(material, slot, new Item.Properties().fireResistant()));
        }
        return ITEMS.register(id, () -> new ArmorItem(material, slot, new Item.Properties()));
    }

    private static RegistryObject<RecordItem> createDiscItem(String id, int comparatorValue, RegistryObject<SoundEvent> sound, DECreativeTabs.Tabs tab, int seconds){
        return ITEMS.register(id, () -> new RecordItem(comparatorValue, () -> sound.get(), new Item.Properties().stacksTo(1), seconds * 20));
    }

    private static RegistryObject<HorseArmorItem> createHorseArmorItem(String id, int armorValue, String tierID, DECreativeTabs.Tabs tab, boolean isFireProof){
    	ITEM_TAB_MAP.put(id, tab);
    	if(isFireProof) {
        	return ITEMS.register(id, () -> new HorseArmorItem(armorValue, new ResourceLocation(DEMod.MOD_ID, "textures/entity/horse/armor/horse_armor_" + tierID + ".png"), new Item.Properties().fireResistant()));
        }
    	return ITEMS.register(id, () -> new HorseArmorItem(armorValue, new ResourceLocation(DEMod.MOD_ID, "textures/entity/horse/armor/horse_armor_" + tierID + ".png"), new Item.Properties()));
    }
    
    private static RegistryObject<ForgeSpawnEggItem> createSpawnEggItem(String id, RegistryObject<? extends EntityType<? extends Mob>> entityType, int backgroundColor, int forgroundColor, DECreativeTabs.Tabs tab){
    	return createItem(id, () -> new ForgeSpawnEggItem(entityType, backgroundColor, forgroundColor, new Item.Properties()), tab);
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
                    if (level == null && entity.level() instanceof ClientLevel) {
                        level = (ClientLevel) entity.level();
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
				if(pEntity instanceof Player player) {
					if(player.hasEffect(DEEffects.REMOTE_EFFECT.get())) {
						int value = Mth.clamp(player.getEffect(DEEffects.REMOTE_EFFECT.get()).getDuration() / 20, 0, 30);
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
