package net.killarexe.dimensional_expansion;

import net.killarexe.dimensional_expansion.client.DEModClient;
import net.killarexe.dimensional_expansion.common.block.StrippingMap;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.common.event.DEEvents;
import net.killarexe.dimensional_expansion.common.event.DEVillagerTrades;
import net.killarexe.dimensional_expansion.core.init.*;
import net.killarexe.dimensional_expansion.server.DEModServer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(DEMod.MOD_ID)
public class DEMod
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "dimensional_expansion";
    public static final String VERSION = "0.8a";

    public DEMod() {
        LOGGER.info("Starting Init Dimensional Expansion");
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        LOGGER.info("Init Dimensional Expansion Sounds");
        DESounds.SOUNDS.register(bus);
        LOGGER.info("Init Dimensional Expansion Blocks");
        DEBlocks.BLOCK.register(bus);
        LOGGER.info("Init Dimensional Expansion Items");
        DEItems.ITEMS.register(bus);
        LOGGER.info("Init Dimensional Expansion Recipe Types");
        DERecipeTypes.RECIPE_SERIALIZERS.register(bus);
        LOGGER.info("Init Dimensional Potions Items");
        DEPoitions.EFFECT.register(bus);
        DEPoitions.POTION.register(bus);
        LOGGER.info("Init Dimensional Enchantments");
        DEEnchantments.ENCHANTMENT.register(bus);
        LOGGER.info("Init Dimensional Expansion Block Entities");
        DEBlockEntityTypes.BLOCK_ENTITY_TYPES.register(bus);
        LOGGER.info("Init Dimensional Expansion Entities");
        DEEntityTypes.ENTITY_TYPES.register(bus);
        LOGGER.info("Init Dimensional Expansion Menu Types");
        DEMenuTypes.MENU_TYPES.register(bus);
        LOGGER.info("Init Dimensional Expansion Villager Professions");
        DEVillagerTypes.VILLAGER_PROFESSION.register(bus);
        DEVillagerTypes.VILLAGER_TYPE.register(bus);
        LOGGER.info("Init Dimensional Expansion Biomes");
        DEBiomes.BIOMES.register(bus);
        DEDimensions.register();
        LOGGER.info("Init Dimensional Expansion Config");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, DEConfig.CLIENT_SPEC, "dimensional_expansion-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, DEConfig.SERVER_SPEC, "dimensional_expansion-server.toml");
        LOGGER.info("Set Dimensional Expansion Event Listeners");
        MinecraftForge.EVENT_BUS.addListener(DEEvents::diggingEvent);
        MinecraftForge.EVENT_BUS.addListener(DEEvents::addTrades);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> DEModClient.clientFeatures(bus, MinecraftForge.EVENT_BUS));
        DistExecutor.unsafeRunWhenOn(Dist.DEDICATED_SERVER, () -> () -> DEModServer.serverFeatures(bus, MinecraftForge.EVENT_BUS));
        bus.addListener(this::commonSetup);
        bus.addListener(this::addItemsToCreativeTabs);
        bus.addListener(DEKeyBindings::onKeyRegister);
        MinecraftForge.EVENT_BUS.register(this);
        DEVillagerTypes.setTypeByBiome();
        LOGGER.info("Init Dimensional Expansion Complete!");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    	new DEVillagerTrades.EmeraldForItems(Items.STRING, 20, 16, 2);
        event.enqueueWork(() ->{
        	LOGGER.info("Dimensional Expansion Common Setup");
        	LOGGER.info("Register Dimensional Expansion Packets");
        	DEChannel.register();
        	LOGGER.info("Register Dimensional Expansion WoodTypes");
        	WoodType.register(DEWoodTypes.PURPLEHEART);
        	LOGGER.info("Put Dimensional Expansion Strippables");
        	StrippingMap.putStrippables();
        	LOGGER.info("Put Dimensional Expansion Compostables");
        	ComposterBlock.COMPOSTABLES.put(DEBlocks.PURPLEHEART_LEAVES.get(), 0.6f);
        	ComposterBlock.COMPOSTABLES.put(DEBlocks.PURPLE_ROSE.get(), 0.4f);
        	ComposterBlock.COMPOSTABLES.put(DEBlocks.PURPLEHEART_SAPLING.get(), 0.6f);
        	LOGGER.info("Put Dimensional Expansion Flower Pots");
        	((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DEBlocks.PURPLE_ROSE.getId(), DEBlocks.POTTED_PURPLE_ROSE);
        	((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(DEBlocks.PURPLEHEART_SAPLING.getId(), DEBlocks.POTTED_PURPLEHEART_SAPLING);
        	LOGGER.info("Register Dimensional Expansion Villager Jobs");
        	DEPois.registerPOIs();
        });
    }
    
    private void addItemsToCreativeTabs(CreativeModeTabEvent.BuildContents e) {
    	if(e.getTab() == DECreativeTabs.DE_MISC) {
    		for(RegistryObject<Item> item: DEItems.ITEMS.getEntries()) {
    			if(DEItems.itemsTab.get(item.getId().getPath()) == DECreativeTabs.MISC) {
    				e.accept(item.get());
    			}
    		}
    	}
    	if(e.getTab() == DECreativeTabs.DE_BLOCKS) {
    		for(RegistryObject<Item> item: DEItems.ITEMS.getEntries()) {
    			if(DEItems.itemsTab.get(item.getId().getPath()) == DECreativeTabs.BLOCKS) {
    				e.accept(item.get());
    			}
    		}
    	}
    	if(e.getTab() == DECreativeTabs.DE_COMBAT) {
    		for(RegistryObject<Item> item: DEItems.ITEMS.getEntries()) {
    			if(DEItems.itemsTab.get(item.getId().getPath()) == DECreativeTabs.COMBAT) {
    				e.accept(item.get());
    			}
    		}
    	}
    	if(e.getTab() == DECreativeTabs.DE_TOOLS) {
    		for(RegistryObject<Item> item: DEItems.ITEMS.getEntries()) {
    			if(DEItems.itemsTab.get(item.getId().getPath()) == DECreativeTabs.TOOLS) {
    				e.accept(item.get());
    			}
    		}
    	}
    }
}
