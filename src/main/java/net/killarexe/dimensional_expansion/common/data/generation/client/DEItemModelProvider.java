package net.killarexe.dimensional_expansion.common.data.generation.client;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.init.DEBlocks;
import net.killarexe.dimensional_expansion.init.DEItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class DEItemModelProvider extends ItemModelProvider {
    public DEItemModelProvider(PackOutput generator, ExistingFileHelper helper) {
        super(generator, DEMod.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
    	//Items
    	oneLayerItem(DEItems.RAW_PALON);
    	oneLayerItem(DEItems.PALON_INGOT);
    	oneLayerItem(DEItems.PALON_NUGGET);
    	oneLayerItem(DEItems.PALON_MIXED_COAL);
    	
    	oneLayerItem(DEItems.BASSMITE_GEM);
    	oneLayerItem(DEItems.BASSMITE_SWORD, true);
    	oneLayerItem(DEItems.BASSMITE_PICKAXE, true);
    	oneLayerItem(DEItems.BASSMITE_AXE, true);
    	oneLayerItem(DEItems.BASSMITE_SHOVEL, true);
    	oneLayerItem(DEItems.BASSMITE_HOE, true);
    	oneLayerItem(DEItems.BASSMITE_HELMET);
    	oneLayerItem(DEItems.BASSMITE_CHESTPLATE);
    	oneLayerItem(DEItems.BASSMITE_LEGGINGS);
    	oneLayerItem(DEItems.BASSMITE_BOOTS);
    	oneLayerItem(DEItems.BASSMITE_HORSE_ARMOR);
    	oneLayerItem(DEItems.BASSMITE_MIXED_COAL);
    	
    	oneLayerItem(DEItems.RAW_SIMIX);
    	oneLayerItem(DEItems.SIMIX_INGOT);
    	oneLayerItem(DEItems.SIMIX_NUGGET);
    	oneLayerItem(DEItems.SIMIX_HAMMER, true);
    	oneLayerItem(DEItems.SIMIX_MIXED_COAL);
    	
    	oneLayerItem(DEItems.EMERTYST_GEM);
    	oneLayerItem(DEItems.EMERTYST_SWORD, true);
    	oneLayerItem(DEItems.EMERTYST_PICKAXE, true);
    	oneLayerItem(DEItems.EMERTYST_AXE, true);
    	oneLayerItem(DEItems.EMERTYST_SHOVEL, true);
    	oneLayerItem(DEItems.EMERTYST_HOE, true);
    	oneLayerItem(DEItems.EMERTYST_HELMET);
    	oneLayerItem(DEItems.EMERTYST_CHESTPLATE);
    	oneLayerItem(DEItems.EMERTYST_LEGGINGS);
    	oneLayerItem(DEItems.EMERTYST_BOOTS);
    	oneLayerItem(DEItems.EMERTYST_HORSE_ARMOR);
    	oneLayerItem(DEItems.EMERTYST_MIXED_COAL);
    	
    	oneLayerItem(DEItems.COORD_LINKER);
    	
    	oneLayerItem(DEItems.ORIGIN_PORTAL_KEY);
    	
    	oneLayerItem(DEItems.PURPLEHEART_SIGN);
    	oneLayerItem(DEItems.PURPLEHEART_BOAT);
    	oneLayerItem(DEItems.PURPLEHEART_CHEST_BOAT);
    	
    	oneLayerItem(DEItems.SWEDEN_DISC);
    	oneLayerItem(DEItems.PURPLE_BERRY);
    	oneLayerItem(DEItems.SAVORLEAF);
    	oneLayerItem(DEItems.VIOLET_CARROT);
    	oneLayerItem(DEItems.MOBOX);

        oneLayerItem(DEItems.BASSMITE_UPGRADE_SMITHING_TEMPLATE);
        oneLayerItem(DEItems.EMERTYST_UPGRADE_SMITHING_TEMPLATE);
    	
    	spawnEgg(DEItems.HEADED_SKELETON_SPAWN_EGG);
    	spawnEgg(DEItems.HEADED_GUARDIAN_SPAWN_EGG);
    	spawnEgg(DEItems.BLUE_SAND_MAN_SPAWN_EGG);
    	spawnEgg(DEItems.MOUVET_SPAWN_EGG);
    	spawnEgg(DEItems.JUGER_SPAWN_EGG);
    	
        //Block Items
        simpleBlockItem(DEBlocks.PALON_ORE);
        simpleBlockItem(DEBlocks.PALON_BLOCK);
        simpleBlockItem(DEBlocks.BASSMITE_ORE);
        simpleBlockItem(DEBlocks.BASSMITE_BLOCK);
        simpleBlockItem(DEBlocks.SIMIX_ORE);
        simpleBlockItem(DEBlocks.SIMIX_BLOCK);
        simpleBlockItem(DEBlocks.EMERTYST_ORE);
        simpleBlockItem(DEBlocks.EMERTYST_BLOCK);
        
        simpleBlockItem(DEBlocks.ORIGIN_GRASS_BLOCK);
        simpleBlockItem(DEBlocks.ORIGIN_DIRT_PATH);
        simpleBlockItem(DEBlocks.ORIGIN_DIRT);
        simpleBlockItem(DEBlocks.ORIGIN_FARMLAND);

        simpleBlockItem(DEBlocks.PURPLEHEART_LOG);
        simpleBlockItem(DEBlocks.STRIPPED_PURPLEHEART_LOG);
        simpleBlockItem(DEBlocks.PURPLEHEART_PLANKS);
        simpleBlockItem(DEBlocks.PURPLEHEART_SLAB);
        inventoryItem(DEBlocks.PURPLEHEART_FENCE);
        simpleBlockItem(DEBlocks.PURPLEHEART_FENCE_GATE);
        inventoryItem(DEBlocks.PURPLEHEART_BUTTON);
        simpleBlockItem(DEBlocks.PURPLEHEART_PRESSURE_PLATE);
        oneLayerItem(DEBlocks.PURPLEHEART_DOOR);
        trapDoorItem(DEBlocks.PURPLEHEART_TRAPDOOR);
        simpleBlockItem(DEBlocks.PURPLEHEART_LEAVES);
        simpleBlockItem(DEBlocks.PURPLEHEART_STAIRS);
        simpleBlockItem(DEBlocks.PURPLEHEART_BOOKSHELF);

        oneLayerItem(DEBlocks.PURPLE_ROSE);
        oneLayerItem(DEBlocks.PURPLEHEART_SAPLING);

        simpleBlockItem(DEBlocks.SULFUR_STONE);
        simpleBlockItem(DEBlocks.SULFUR_COBBLESTONE);
        simpleBlockItem(DEBlocks.SULFUR_COBBLESTONE_SLAB);
        simpleBlockItem(DEBlocks.SULFUR_COBBLESTONE_STAIRS);
        inventoryItem(DEBlocks.SULFUR_COBBLESTONE_WALL);
        simpleBlockItem(DEBlocks.SULFUR_STONE_PRESSURE_PLATE);
        simpleBlockItem(DEBlocks.SULFUR_STONE_SLAB);
        simpleBlockItem(DEBlocks.SULFUR_STONE_STAIRS);
        simpleBlockItem(DEBlocks.SULFUR_STONE_BUTTON);
        simpleBlockItem(DEBlocks.SULFUR_STONE_BRICKS);
        simpleBlockItem(DEBlocks.SULFUR_STONE_BRICKS_SLAB);
        simpleBlockItem(DEBlocks.SULFUR_STONE_BRICKS_STAIRS);
        inventoryItem(DEBlocks.SULFUR_STONE_BRICKS_WALL);
        simpleBlockItem(DEBlocks.VIOLET_STONE);
        simpleBlockItem(DEBlocks.VIOLET_STONE_SLAB);
        simpleBlockItem(DEBlocks.VIOLET_STONE_STAIRS);
        inventoryItem(DEBlocks.VIOLET_STONE_WALL);

        simpleBlockItem(DEBlocks.BLUE_SAND);
        simpleBlockItem(DEBlocks.BLUE_SANDSTONE);
        simpleBlockItem(DEBlocks.ORIGIN_FRAME);
        simpleBlockItem(DEBlocks.SAVORLEAF_BLOCK);
        
        simpleBlockItem(DEBlocks.DISPLAY_BLOCK);
        oneLayerItem(DEBlocks.PURPLE_BERRY_DEAD_BUSH, "block");
        oneLayerItem(DEBlocks.ORIGIN_TALL_GRASS, new ResourceLocation(DEMod.MOD_ID, "origin_tall_grass_top"), false, "block");
    }

    private <T extends Block> void simpleBlockItem(RegistryObject<T> block){
        getBuilder(block.getId().toString()).parent(getExistingFile(new ResourceLocation(DEMod.MOD_ID, "block/" + block.getId().getPath())));
    }

    private <T extends Block> void inventoryItem(RegistryObject<T> block) {
    	getBuilder(block.getId().toString()).parent(getExistingFile(new ResourceLocation(DEMod.MOD_ID, "block/" + block.getId().getPath() + "_inventory")));
    }

    private <T extends Block> void trapDoorItem(RegistryObject<T> block) {
    	getBuilder(block.getId().toString()).parent(getExistingFile(new ResourceLocation(DEMod.MOD_ID, "block/" + block.getId().getPath() + "_bottom")));
    }

    private void oneLayerItem(RegistryObject<?> item, ResourceLocation texture, boolean handheld, String baseDir){
        ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(), baseDir + "/" + texture.getPath());
        if(existingFileHelper.exists(itemTexture, PackType.CLIENT_RESOURCES, ".png", "textures")){
            if(!handheld) {
                getBuilder(item.getId().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", itemTexture);
            }else{
                getBuilder(item.getId().getPath()).parent(getExistingFile(mcLoc("item/handheld"))).texture("layer0", itemTexture);
            }
        }else{
            DEMod.LOGGER.warn("Failed to find texture for: " + item.getId().toString());
        }
    }
    
    private void spawnEgg(RegistryObject<ForgeSpawnEggItem> item) {
    	getBuilder(item.getId().getPath()).parent(getExistingFile(mcLoc("item/template_spawn_egg")));
    }

    private void oneLayerItem(RegistryObject<?> item, boolean handheld){
        oneLayerItem(item, item.getId(), handheld, "item");
    }

    private void oneLayerItem(RegistryObject<?> item){
        oneLayerItem(item, false);
    }
    
    private void oneLayerItem(RegistryObject<?> item, String baseDir) {
    	oneLayerItem(item, item.getId(), false, baseDir);
    }
}
