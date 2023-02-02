package net.killarexe.dimensional_expansion.common.data.generation.client.lang;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class DEEnUsProvider extends LanguageProvider {

    public DEEnUsProvider(PackOutput generator) {
        super(generator, DEMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
    	/*BLOCKS*/
        add(DEBlocks.PALON_ORE.get(), "Palon Ore");
        add(DEBlocks.PALON_BLOCK.get(), "Palon Block");
        add(DEBlocks.BASSMITE_ORE.get(), "Bassmite Ore");
        add(DEBlocks.BASSMITE_BLOCK.get(), "Bassmite Block");
        add(DEBlocks.SIMIX_ORE.get(), "Simix Ore");
        add(DEBlocks.SIMIX_BLOCK.get(), "Simix Block");
        add(DEBlocks.EMERTYST_ORE.get(), "Emertyst Ore");
        add(DEBlocks.EMERTYST_BLOCK.get(), "Emertyst Block");

        add(DEBlocks.ORIGIN_GRASS_BLOCK.get(), "Origin Grass Block");
        add(DEBlocks.ORIGIN_GRASS.get(), "Origin Grass");
        add(DEBlocks.ORIGIN_DIRT.get(), "Origin Dirt");
        add(DEBlocks.PURPLEHEART_LOG.get(), "PurpleHeart Log");
        add(DEBlocks.STRIPPED_PURPLEHEART_LOG.get(), "PurpleHeart Stripped Log");
        add(DEBlocks.PURPLEHEART_PLANKS.get(), "PurpleHeart Planks");
        add(DEBlocks.PURPLEHEART_SLAB.get(), "PurpleHeart Slab");
        add(DEBlocks.PURPLEHEART_FENCE.get(), "PurpleHeart Fence");
        add(DEBlocks.PURPLEHEART_FENCE_GATE.get(), "PurpleHeart Fence Gate");
        add(DEBlocks.PURPLEHEART_BUTTON.get(), "PurpleHeart Button");
        add(DEBlocks.PURPLEHEART_PRESSURE_PLATE.get(), "PurpleHeart Pressure Plate");
        add(DEBlocks.PURPLEHEART_DOOR.get(), "PurpleHeart Door");
        add(DEBlocks.PURPLEHEART_TRAPDOOR.get(), "PurpleHeart Trapdoor");
        add(DEBlocks.PURPLEHEART_LEAVES.get(), "PurpleHeart Leaves");
        add(DEBlocks.PURPLEHEART_STAIRS.get(), "PurpleHeart Stairs");
        add(DEBlocks.PURPLEHEART_BOOKSHELF.get(), "PurpleHeart Bookshelf");
        add(DEBlocks.PURPLE_ROSE.get(), "Origin Rose");
        add(DEBlocks.POTTED_PURPLE_ROSE.get(), "Potted Origin Rose");
        add(DEBlocks.PURPLEHEART_SAPLING.get(), "PurpleHeart Sapling");
        add(DEBlocks.POTTED_PURPLEHEART_SAPLING.get(), "Potted PurpleHeart Sapling");
        add(DEBlocks.SULFUR_STONE.get(), "Origin Stone");
        add(DEBlocks.SULFUR_STONE_SLAB.get(), "Sulfur Stone Slab");
        add(DEBlocks.SULFUR_STONE_STAIRS.get(), "Sulfur Stone Stairs");
        add(DEBlocks.SULFUR_STONE_BUTTON.get(), "Sulfur Stone Button");
        add(DEBlocks.SULFUR_STONE_PRESSURE_PLATE.get(), "Sulfur Stone Pressure Plate");
        add(DEBlocks.SULFUR_COBBLESTONE.get(), "Sulfur Cobblestone");
        add(DEBlocks.SULFUR_COBBLESTONE_SLAB.get(), "Sulfur Cobblestone Slab");
        add(DEBlocks.SULFUR_COBBLESTONE_STAIRS.get(), "Sulfur Cobblestone Stairs");
        add(DEBlocks.BLUE_SAND.get(), "Blue Sand");
        add(DEBlocks.BLUE_SANDSTONE.get(), "Blue Sandstone");
        
        add(DEBlocks.ORIGIN_FRAME.get(), "Origin Frame");
        add(DEBlocks.ORIGIN_PORTAL.get(), "Origin Portal");

        add(DEBlocks.FORGE.get(), "Forge");
        add(DEBlocks.ESSENCE_EXTRACTOR.get(), "Essence Extractor");
        add(DEBlocks.MINERAL_STORAGE.get(), "Mineral Storage");
        add(DEBlocks.DISPLAY_BLOCK.get(), "Display Block");
        
        add(DEBlocks.PURPLE_BERRY_BUSH.get(), "Purple Berry Block");

        /*ITEMS*/
        add(DEItems.RAW_PALON.get(), "Raw Palon");
        add(DEItems.PALON_INGOT.get(), "Palon Ingot");
        add(DEItems.PALON_NUGGET.get(), "Palon Nugget");
        add(DEItems.PALON_SWORD.get(), "Palon Sword");
        add(DEItems.PALON_PICKAXE.get(), "Palon Pickaxe");
        add(DEItems.PALON_AXE.get(), "Palon Axe");
        add(DEItems.PALON_SHOVEL.get(), "Palon Shovel");
        add(DEItems.PALON_HOE.get(), "Palon Hoe");
        add(DEItems.PALON_HELMET.get(), "Palon Helmet");
        add(DEItems.PALON_CHESTPLATE.get(), "Palon Chestplate");
        add(DEItems.PALON_LEGGINGS.get(), "Palon Leggings");
        add(DEItems.PALON_BOOTS.get(), "Palon Boots");
        add(DEItems.PALON_HORSE_ARMOR.get(), "Palon Horse Armor");
        add(DEItems.PALON_MIXED_COAL.get(), "Palon Mixed Coal");

        add(DEItems.BASSMITE_GEM.get(), "Bassmite Gem");
        add(DEItems.BASSMITE_SWORD.get(), "Bassmite Sword");
        add(DEItems.BASSMITE_PICKAXE.get(), "Bassmite Pickaxe");
        add(DEItems.BASSMITE_AXE.get(), "Bassmite Axe");
        add(DEItems.BASSMITE_SHOVEL.get(), "Bassmite Shovel");
        add(DEItems.BASSMITE_HOE.get(), "Bassmite Hoe");
        add(DEItems.BASSMITE_HELMET.get(), "Bassmite Helmet");
        add(DEItems.BASSMITE_CHESTPLATE.get(), "Bassmite Chestplate");
        add(DEItems.BASSMITE_LEGGINGS.get(), "Bassmite Leggings");
        add(DEItems.BASSMITE_BOOTS.get(), "Bassmite Boots");
        add(DEItems.BASSMITE_HORSE_ARMOR.get(), "Bassmite Horse Armor");
        add(DEItems.BASSMITE_MIXED_COAL.get(), "Bassmite Mixed Coal");

        add(DEItems.RAW_SIMIX.get(), "Raw Simix");
        add(DEItems.SIMIX_INGOT.get(), "Simix Ingot");
        add(DEItems.SIMIX_NUGGET.get(), "Simix Nugget");
        add(DEItems.SIMIX_HAMMER.get(), "Simix Hammer");
        add(DEItems.SIMIX_SWORD.get(), "Simix Sword");
        add(DEItems.SIMIX_PICKAXE.get(), "Simix Pickaxe");
        add(DEItems.SIMIX_AXE.get(), "Simix Axe Axe");
        add(DEItems.SIMIX_SHOVEL.get(), "Simix Shovel");
        add(DEItems.SIMIX_HOE.get(), "Simix Hoe");
        add(DEItems.SIMIX_HELMET.get(), "Simix Helmet");
        add(DEItems.SIMIX_CHESTPLATE.get(), "Simix Chestplate");
        add(DEItems.SIMIX_LEGGINGS.get(), "Simix Leggings");
        add(DEItems.SIMIX_BOOTS.get(), "Simix Boots");
        add(DEItems.SIMIX_HORSE_ARMOR.get(), "Simix Horse Armor");
        add(DEItems.SIMIX_MIXED_COAL.get(), "Simix Mixed Coal");

        add(DEItems.EMERTYST_GEM.get(), "Emertyst Gem");
        add(DEItems.EMERTYST_SWORD.get(), "Emertyst Sword");
        add(DEItems.EMERTYST_PICKAXE.get(), "Emertyst Pickaxe");
        add(DEItems.EMERTYST_AXE.get(), "Emertyst Axe");
        add(DEItems.EMERTYST_SHOVEL.get(), "Emertyst Shovel");
        add(DEItems.EMERTYST_HOE.get(), "Emertyst Hoe");
        add(DEItems.EMERTYST_HELMET.get(), "Emertyst Helmet");
        add(DEItems.EMERTYST_CHESTPLATE.get(), "Emertyst Chestplate");
        add(DEItems.EMERTYST_LEGGINGS.get(), "Emertyst Leggings");
        add(DEItems.EMERTYST_BOOTS.get(), "Emertyst Boots");
        add(DEItems.EMERTYST_HORSE_ARMOR.get(), "Emertyst Horse Armor");
        add(DEItems.EMERTYST_MIXED_COAL.get(), "Emertyst Mixed Coal");
        
        add(DEItems.ALLOY_CRYSTAL.get(), "Alloy Crystal");

        add(DEItems.WEATHER_POWER_STONE.get(), "Weather Power Stone");
        add(DEItems.TIME_POWER_STONE.get(), "Time Power Stone");
        add(DEItems.WARP_POWER_STONE.get(), "Warp Power Stone");

        add(DEItems.COORD_LINKER.get(), "Coord Linker");
        add(DEItems.REMOTE_TELEPORTER.get(), "Remote Teleporter");

        add(DEItems.PEARL_ESSENCE.get(), "Pearl Essence");
        
        add(DEItems.PURPLE_BERRY.get(), "Purple Berry");
        
        add(DEItems.ORIGIN_PORTAL_KEY.get(), "Origin Portal Key");

        add(DEItems.PURPLEHEART_SIGN.get(), "PurpleHeart Sign");
        add(DEItems.PURPLEHEART_BOAT.get(), "PurpleHeart Boat");

        /*Discs*/
        add(DEItems.SWEDEN_DISC.get(), "Sweden in the 90's Disc");
        add(DEItems.SWEDEN_DISC.get().getDescriptionId() + ".desc", "Sweden in the 90's by Killar.exe");
        add(DEItems.DOCTOR_WHO_DISC.get(), "Doctor Who Disc");
        add(DEItems.DOCTOR_WHO_DISC.get().getDescriptionId() + ".desc", "Doctor Who by Killar.exe");
        
        /*ItemGroups*/
        add("itemGroup." + DEMod.MOD_ID + ".combat", "DE Combat");
        add("itemGroup." + DEMod.MOD_ID + ".tools", "DE Tools");
        add("itemGroup." + DEMod.MOD_ID + ".misc", "DE Misc");
        add("itemGroup." + DEMod.MOD_ID + ".blocks", "DE Blocks");

        /*Screens*/
        add("config." + DEMod.MOD_ID + ".title", "Dimensional Expansion Config");
        add("config." + DEMod.MOD_ID + ".client", "Dimensional Expansion §3Client §fConfig");
        add("config." + DEMod.MOD_ID + ".common", "Dimensional Expansion §6Common §fConfig");

        add("button." + DEMod.MOD_ID + ".cancel_button", "§4Cancel");
        add("button." + DEMod.MOD_ID + ".apply_button", "§2Apply");
        add("button." + DEMod.MOD_ID + ".youtube", "Youtube");
        add("button." + DEMod.MOD_ID + ".discord", "Discord §4(Not avalable)");
        add("button." + DEMod.MOD_ID + ".config", "Config");
        add("button." + DEMod.MOD_ID + ".github", "Github");
        add("button." + DEMod.MOD_ID + ".client_button", "§3Client §fConfig");
        add("button." + DEMod.MOD_ID + ".common_button", "§6Common §fConfig");
        
        add("button." + DEMod.MOD_ID + ".client_button_desc", "");
        add("button." + DEMod.MOD_ID + ".common_button_desc", "");

        add("checkbox." + DEMod.MOD_ID + ".show_version", "Show Version");
        add("checkbox." + DEMod.MOD_ID + ".discord_rpc", "Discord RPC");
        add("checkbox." + DEMod.MOD_ID + ".modded_screens", "Modded Screens");
        add("checkbox." + DEMod.MOD_ID + ".debug_mod", "Debug Mod");
        
        /*Tooltips*/
        add("tooltip." + DEMod.MOD_ID + ".shift", "Hold §eSHIFT §ffor more info.");
        add("tooltip." + DEMod.MOD_ID + ".remote_teleporter", "Give you an effect of Remote for 30 seconds.");
        add("tooltip." + DEMod.MOD_ID + ".time_power_stone", "Change between day and night.");
        add("tooltip." + DEMod.MOD_ID + ".warp_power_stone", "Teleport you at spawn point.");
        add("tooltip." + DEMod.MOD_ID + ".weather_power_stone", "Switch between raing and sun.");
        
        /*
         *Advancements 
         */
        add("advancements." + DEMod.MOD_ID + ".bassmite.title", "Bassmite!");
        add("advancements." + DEMod.MOD_ID + ".bassmite.desc", "I'm not like lapis...");
        add("advancements." + DEMod.MOD_ID + ".cover_me_with_emertyst.title", "Cover Me With Emertyst!");
        add("advancements." + DEMod.MOD_ID + ".cover_me_with_emertyst.desc", "The best armor you can have on this mod.");
        add("advancements." + DEMod.MOD_ID + "." + DEMod.MOD_ID + ".title", "Dimensional Expansion");
        add("advancements." + DEMod.MOD_ID + "." + DEMod.MOD_ID + ".desc", "Thanks for downloading this mod - Killar.exe.");
        add("advancements." + DEMod.MOD_ID + ".emertyst.title", "Emertyst!");
        add("advancements." + DEMod.MOD_ID + ".emertyst.desc", "The purplest gem.");
        add("advancements." + DEMod.MOD_ID + ".purpleheart_wood.title", "Purpleheart wood...?");
        add("advancements." + DEMod.MOD_ID + ".purpleheart_wood.desc", "The legend says that Purpleheart Forests are alive...");
        add("advancements." + DEMod.MOD_ID + ".simix.title", "Nether's Simix");
        add("advancements." + DEMod.MOD_ID + ".simix.desc", "Netherite combined fresh made Obsidian and an unkown ingredient...");
        add("advancements." + DEMod.MOD_ID + ".the_origin.title", "The Origin...");
        add("advancements." + DEMod.MOD_ID + ".the_origin.desc", "An anternative...");
        add("advancements." + DEMod.MOD_ID + ".the_palon.title", "The Palon!");
        add("advancements." + DEMod.MOD_ID + ".the_palon.desc", "Finaly something we can get on this mod!");
        
        /*
         *	Villagers 
         */
        add("entity." + DEMod.MOD_ID + ".villager.forger", "Forger");
        add("entity." + DEMod.MOD_ID + ".villager.farmer", "Farmer");
        add("entity." + DEMod.MOD_ID + ".villager.miner", "Miner");
    }
}
