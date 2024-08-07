package net.killarexe.dimensional_expansion.common.data.generation.client.lang;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.killarexe.dimensional_expansion.init.DEEntityTypes;
import net.killarexe.dimensional_expansion.init.DEItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

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
        add(DEBlocks.ORIGIN_FARMLAND.get(), "Origin Farmland");
        add(DEBlocks.ORIGIN_DIRT_PATH.get(), "Origin Dirt Path");
        
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
        add(DEBlocks.SULFUR_COBBLESTONE_WALL.get(), "Sulfur Cobblestone Wall");

        add(DEBlocks.SULFUR_STONE_BRICKS.get(), "Sulfur Stone Bricks");
        add(DEBlocks.SULFUR_STONE_BRICKS_SLAB.get(), "Sulfur Stone Bricks Slab");
        add(DEBlocks.SULFUR_STONE_BRICKS_STAIRS.get(), "Sulfur Stone Bricks Stairs");
        add(DEBlocks.SULFUR_STONE_BRICKS_WALL.get(), "Sulfur Stone Bricks Wall");

        add(DEBlocks.VIOLET_STONE.get(), "Violet Stone");
        add(DEBlocks.VIOLET_STONE_SLAB.get(), "Violet Stone Slab");
        add(DEBlocks.VIOLET_STONE_STAIRS.get(), "Violet Stone Stairs");
        add(DEBlocks.VIOLET_STONE_WALL.get(), "Violet Stone Wall");

        add(DEBlocks.BLUE_SAND.get(), "Blue Sand");
        add(DEBlocks.BLUE_SANDSTONE.get(), "Blue Sandstone");
        
        add(DEBlocks.ORIGIN_FRAME.get(), "Origin Frame");
        add(DEBlocks.ORIGIN_PORTAL.get(), "Origin Portal");

        add(DEBlocks.DISPLAY_BLOCK.get(), "Display Block");
        add(DEBlocks.ENCHANT_TRANSFER_TABLE.get(), "Enchant Transfer Table");
        
        add(DEBlocks.PURPLE_BERRY_BUSH.get(), "Purple Berry Block");
        add(DEBlocks.SAVORLEAF_BLOCK.get(), "Savorleaf Block");
        add(DEBlocks.PURPLEISH_CACTUS.get(), "Purpleish Cactus");
        add(DEBlocks.ORIGIN_TALL_GRASS.get(), "Origin Tall Grass");
        add(DEBlocks.PURPLE_BERRY_DEAD_BUSH.get(), "Purple Berry Dead Bush");

        /*ITEMS*/
        add(DEItems.RAW_PALON.get(), "Raw Palon");
        add(DEItems.PALON_INGOT.get(), "Palon Ingot");
        add(DEItems.PALON_NUGGET.get(), "Palon Nugget");
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
        
        add(DEItems.COORD_LINKER.get(), "Coord Linker");

        add(DEItems.PURPLE_BERRY.get(), "Purple Berry");
        
        add(DEItems.ORIGIN_PORTAL_KEY.get(), "Origin Portal Key");

        add(DEItems.PURPLEHEART_SIGN.get(), "Purpleheart Sign");
        add(DEItems.PURPLEHEART_BOAT.get(), "Purpleheart Boat");
        add(DEItems.PURPLEHEART_CHEST_BOAT.get(), "Purpleheart Chest Boat");
        
        add(DEItems.SAVORLEAF.get(), "Savorleaf");
        add(DEItems.VIOLET_CARROT.get(), "Violet Carrot");
        
        add(DEItems.MOBOX.get(), "Mobox");

        add(DEItems.BASSMITE_UPGRADE_SMITHING_TEMPLATE.get(), "Bassmite Template");
        add(DEItems.EMERTYST_UPGRADE_SMITHING_TEMPLATE.get(), "Emertyst Template");

        add(DEItems.HEADED_SKELETON_SPAWN_EGG.get(), "Headed Skeleton Spawn Egg");
        add(DEItems.HEADED_GUARDIAN_SPAWN_EGG.get(), "Headed Guardian Spawn Egg");
        add(DEItems.BLUE_SAND_MAN_SPAWN_EGG.get(), "Blue Sand Man Spawn Egg");
        add(DEItems.MOUVET_SPAWN_EGG.get(), "Mouvet Spawn Egg");
        add(DEItems.JUGER_SPAWN_EGG.get(), "Juger Spawn Egg");
        
        /*Discs*/
        add(DEItems.SWEDEN_DISC.get(), "Sweden in the 90's Disc");
        add(DEItems.SWEDEN_DISC.get().getDescriptionId() + ".desc", "Sweden in the 90's by Killar.exe");
        add(DEItems.VERY_SPECIAL_DISC.get(), "Very Special Disc");
        add(DEItems.VERY_SPECIAL_DISC.get().getDescriptionId() + ".desc", "A Very Spcial Disc by Killar.exe");
        add(DEItems.GROOVY_DISC.get(), "Groovy Disc");
        add(DEItems.GROOVY_DISC.get().getDescriptionId() + ".desc", "Groovy by Killar.exe");

        /*ItemGroups*/
        add("itemGroup." + DEMod.MOD_ID + ".combat", "Dimensional Expansion Combat");
        add("itemGroup." + DEMod.MOD_ID + ".tools", "Dimensional Expansion Tools");
        add("itemGroup." + DEMod.MOD_ID + ".misc", "Dimensional Expansion Misc");
        add("itemGroup." + DEMod.MOD_ID + ".blocks", "Dimensional Expansion Blocks");
        add("itemGroup." + DEMod.MOD_ID + ".mobs", "Dimensional Expansion Mobs");

        /*Tooltips*/
        add("tooltip." + DEMod.MOD_ID + ".shift", "Hold §eSHIFT §ffor more info.");
        add("tooltip." + DEMod.MOD_ID + ".mobox.current_entity", "Current entity: %s");
        add("tooltip." + DEMod.MOD_ID + ".is_lost", "The Coord Linker is lost...");

        add("item." + DEMod.MOD_ID + ".smithing_template.bassmite_upgrade.applies_to", "Netherite Armors & Gears");
        add("item." + DEMod.MOD_ID + ".smithing_template.bassmite_upgrade.ingredients", "Bassmite Gem");
        add("upgrade." + DEMod.MOD_ID + ".bassmite_upgrade", "Bassmite Upgrade");
        add("item." + DEMod.MOD_ID + ".smithing_template.bassmite_upgrade.base_slot_description", "Add netherite armor, weapon or tool");
        add("item." + DEMod.MOD_ID + ".smithing_template.bassmite_upgrade.additions_slot_description", "Add Bassmite Gem");

        add("item." + DEMod.MOD_ID + ".smithing_template.emertyst_upgrade.applies_to", "Bassmite Armors & Gears");
        add("item." + DEMod.MOD_ID + "smithing_template.emertyst_upgrade.ingredients", "Emertyst Gem");
        add("upgrade." + DEMod.MOD_ID + ".emertyst_upgrade", "Emertyst Upgrade");
        add("item." + DEMod.MOD_ID + ".smithing_template.emertyst_upgrade.base_slot_description", "Add bassmite armor, weapon or tool");
        add("item." + DEMod.MOD_ID + ".smithing_template.emertyst_upgrade.additions_slot_description", "Add Emertyst Gem");


        /*
         *Advancements 
         */
        add("advancement." + DEMod.MOD_ID + ".village_origin_plains.title", "A New village ?");
        add("advancement." + DEMod.MOD_ID + ".village_origin_plains.desc", "Wow that's... new...");
        add("advancement." + DEMod.MOD_ID + ".origin_abandonned_portal.title", "An abandonned portal...");
        add("advancement." + DEMod.MOD_ID + ".origin_abandonned_portal.desc", "Mmmphhh... Sus...");
        add("advancement." + DEMod.MOD_ID + ".bassmite.title", "Bassmite!");
        add("advancement." + DEMod.MOD_ID + ".bassmite.desc", "I'm not like lapis...");
        add("advancement." + DEMod.MOD_ID + ".cover_me_with_emertyst.title", "Cover Me With Emertyst!");
        add("advancement." + DEMod.MOD_ID + ".cover_me_with_emertyst.desc", "The best armor you can have on this mod.");
        add("advancement." + DEMod.MOD_ID + "." + DEMod.MOD_ID + ".title", "Dimensional Expansion");
        add("advancement." + DEMod.MOD_ID + "." + DEMod.MOD_ID + ".desc", "Thanks for downloading this mod - Killar.exe.");
        add("advancement." + DEMod.MOD_ID + ".emertyst.title", "Emertyst!");
        add("advancement." + DEMod.MOD_ID + ".emertyst.desc", "The purplest gem.");
        add("advancement." + DEMod.MOD_ID + ".power_stones.desc", "Collect them'all!");
        add("advancement." + DEMod.MOD_ID + ".power_stones.title", "Power Stones");
        add("advancement." + DEMod.MOD_ID + ".purpleheart_wood.title", "Purpleheart wood...?");
        add("advancement." + DEMod.MOD_ID + ".purpleheart_wood.desc", "The legend says that Purpleheart Forests are alive...");
        add("advancement." + DEMod.MOD_ID + ".simix.title", "Nether's Simix");
        add("advancement." + DEMod.MOD_ID + ".simix.desc", "Netherite combined fresh made Obsidian and an unkown ingredient...");
        add("advancement." + DEMod.MOD_ID + ".the_origin.title", "The Origin...");
        add("advancement." + DEMod.MOD_ID + ".the_origin.desc", "Get into The Origin by making a portal from Origin Frames");
        add("advancement." + DEMod.MOD_ID + ".the_palon.title", "The Palon!");
        add("advancement." + DEMod.MOD_ID + ".the_palon.desc", "Finaly something we can get on this mod!");
        
        /*
         *	Entities 
         */
        add("entity.minecraft.villager." + DEMod.MOD_ID + ".forger", "Forger");
        add("entity.minecraft.villager." + DEMod.MOD_ID + ".farmer", "Farmer");
        add("entity.minecraft.villager." + DEMod.MOD_ID + ".miner", "Miner");
        add("entity." + DEMod.MOD_ID + ".purpleheart_chest_boat", "Purpleheart Chest Boat");
        add("entity." + DEMod.MOD_ID + ".headed_skeleton", "Headed Skeleton");
        add("entity." + DEMod.MOD_ID + ".headed_guardian", "Headed Guardian");
        add("entity." + DEMod.MOD_ID + ".blue_sand_man", "Blue Sand Man");
        add("entity." + DEMod.MOD_ID + ".mouvet", "Mouvet");
        add(DEEntityTypes.JUGER.get(), "Juger");
        
        /*
         * Messages
         */
        
        add("message." + DEMod.MOD_ID + ".need_enchanted_item", "You need to put a enchanted item first!");
        add("message." + DEMod.MOD_ID + ".cost_too_high", "Not enough experience to do this...");
        
        /*
         * Records
         */
        add("record." + DEMod.MOD_ID + ".sweden_remix.subtitle", "Sweden Remix by Killar.exe");
        
        /*
         * Sounds
         */
        add("entity." + DEMod.MOD_ID + ".blue_sand_man.ambient", "Blue Sand Man Ambient");
        add("entity." + DEMod.MOD_ID + ".blue_sand_man.death", "Blue Sand Man Death");
        add("entity." + DEMod.MOD_ID + ".blue_sand_man.hurt", "Blue Sand Man Hurt");
        add("entity." + DEMod.MOD_ID + ".juger.ambient", "Juger Ambient");
        add("entity." + DEMod.MOD_ID + ".juger.attack", "Juger Attack");
        add("entity." + DEMod.MOD_ID + ".juger.death", "Juger Death");
        add("entity." + DEMod.MOD_ID + ".juger.hurt", "Juger Hurt");
        add("entity." + DEMod.MOD_ID + ".mouvet.ambient", "Mouvet Squick");
        add("entity." + DEMod.MOD_ID + ".mouvet.death", "Mouvet Death");
        add("entity." + DEMod.MOD_ID + ".mouvet.hurt", "Mouvet Hurt");
    }
}
