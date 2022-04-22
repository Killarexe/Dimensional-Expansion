package net.killarexe.dimensional_expansion.common.data.generation.client.lang;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class DEEnUsProvider extends LanguageProvider {

    public DEEnUsProvider(DataGenerator generator) {
        super(generator, DEMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(DEBlocks.PALON_ORE.get(), "Palon Ore");
        add(DEBlocks.PALON_BLOCK.get(), "Palon Block");
        add(DEBlocks.BASSMITE_ORE.get(), "Bassmite Ore");
        add(DEBlocks.BASSMITE_BLOCK.get(), "Bassmite Block");
        add(DEBlocks.SIMIX_ORE.get(), "Simix Ore");
        add(DEBlocks.SIMIX_BLOCK.get(), "Simix Block");
        add(DEBlocks.EMERTYST_ORE.get(), "Emertyst Ore");
        add(DEBlocks.EMERTYST_BLOCK.get(), "Emertyst Block");

        add(DEBlocks.END_GRASS_BLOCK.get(), "End Grass Block");
        add(DEBlocks.END_LOG.get(), "End Log");
        add(DEBlocks.END_STRIPPED_LOG.get(), "End Stripped Log");
        add(DEBlocks.END_PLANKS.get(), "End Planks");
        add(DEBlocks.END_SLAB.get(), "End Slab");
        add(DEBlocks.END_FENCE.get(), "End Fence");
        add(DEBlocks.END_FENCE_GATE.get(), "End Fence Gate");
        add(DEBlocks.END_BUTTON.get(), "End Button");
        add(DEBlocks.END_PRESSURE_PLATE.get(), "End Pressure Plate");
        add(DEBlocks.END_DOOR.get(), "End Door");
        add(DEBlocks.END_TRAPDOOR.get(), "End Trapdoor");
        add(DEBlocks.END_LEAVES.get(), "End Leaves");
        add(DEBlocks.END_STAIRS.get(), "End Stairs");
        add(DEBlocks.END_BOOKSHELF.get(), "End Bookshelf");
        add(DEBlocks.END_SIGN.get(), "End Sign");
        add(DEBlocks.END_WALL_SIGN.get(), "End Wall Sign");
        add(DEBlocks.END_ROSE.get(), "End Rose");
        add(DEBlocks.POTTED_END_ROSE.get(), "Potted End Rose");
        add(DEBlocks.END_SAPLING.get(), "End Sapling");
        add(DEBlocks.POTTED_END_SAPLING.get(), "Potted End Sapling");
        add(DEBlocks.END_SAND.get(), "End Sand");
        add(DEBlocks.END_SANDSTONE.get(), "End Sandstone");

        add(DEBlocks.FORGE.get(), "Forge");
        add(DEBlocks.ESSENCE_EXTRACTOR.get(), "Essence Extractor");
        add(DEBlocks.MINERAL_STORAGE.get(), "Mineral Storage");
        add(DEBlocks.DISPLAY_BLOCK.get(), "Display Block");

        add(DEBlocks.XP_CROPS.get(), "Xp Crops");
        add(DEBlocks.HEALTH_CROPS.get(), "Health Crops");

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

        add(DEItems.WEATHER_POWER_STONE.get(), "Weather Power Stone");
        add(DEItems.TIME_POWER_STONE.get(), "Time Power Stone");
        add(DEItems.WARP_POWER_STONE.get(), "Warp Power Stone");

        add(DEItems.COORD_LINKER.get(), "Coord Linker");

        add(DEItems.XP_SEEDS.get(), "Xp Seeds");
        add(DEItems.HEART_SEEDS.get(), "Heart Seeds");
        add(DEItems.XP_PLANTS.get(), "Xp Plants");
        add(DEItems.HEART.get(), "Heart");
        add(DEItems.XP_ESSENCE.get(), "Xp Essence");
        add(DEItems.HEART_ESSENCE.get(), "Heart Essence");
        add(DEItems.PEARL_ESSENCE.get(), "Pearl Essence");

        add(DEItems.END_SIGN.get(), "End Sign");
        add(DEItems.END_BOAT.get(), "End Boat");

        add(DEItems.BJM_DISC.get(), "VHL Disc");
        add(DEItems.DW_DISC.get(), "SM Disc");

        add("config." + DEMod.MODID + ".title", "Dimensional Expansion Config");
        add("config." + DEMod.MODID + ".client", "Dimensional Expansion Client Config");
        add("config." + DEMod.MODID + ".common", "Dimensional Expansion Common Config");

        add("button." + DEMod.MODID + ".cancel_button", "Cancel");
        add("button." + DEMod.MODID + ".apply_button", "Apply");
        add("button." + DEMod.MODID + ".client_button", "Client Config");
        add("button." + DEMod.MODID + ".common_button", "Common Config");

        add("checkbox." + DEMod.MODID + ".show_version", "Show Version");
        add("checkbox." + DEMod.MODID + ".coord_linker", "Coord Linker Overlay");
        add("checkbox." + DEMod.MODID + ".modded_title_screen", "Modded Title Screen");
        add("checkbox." + DEMod.MODID + ".debug_mod", "Debug Mod");
    }
}
