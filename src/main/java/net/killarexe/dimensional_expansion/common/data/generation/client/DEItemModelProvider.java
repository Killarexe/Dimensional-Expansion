package net.killarexe.dimensional_expansion.common.data.generation.client;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class DEItemModelProvider extends ItemModelProvider {
    public DEItemModelProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, DEMod.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
    	//Items
    	oneLayerItem(DEItems.RAW_PALON);
    	oneLayerItem(DEItems.PALON_INGOT);
    	oneLayerItem(DEItems.PALON_NUGGET);
    	oneLayerItem(DEItems.PALON_SWORD, true);
    	oneLayerItem(DEItems.PALON_PICKAXE, true);
    	oneLayerItem(DEItems.PALON_AXE, true);
    	oneLayerItem(DEItems.PALON_SHOVEL, true);
    	oneLayerItem(DEItems.PALON_HOE, true);
    	oneLayerItem(DEItems.PALON_HELMET);
    	oneLayerItem(DEItems.PALON_CHESTPLATE);
    	oneLayerItem(DEItems.PALON_LEGGINGS);
    	oneLayerItem(DEItems.PALON_BOOTS);
    	oneLayerItem(DEItems.PALON_HORSE_ARMOR);
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
    	oneLayerItem(DEItems.SIMIX_SWORD, true);
    	oneLayerItem(DEItems.SIMIX_PICKAXE, true);
    	oneLayerItem(DEItems.SIMIX_AXE, true);
    	oneLayerItem(DEItems.SIMIX_SHOVEL, true);
    	oneLayerItem(DEItems.SIMIX_HOE, true);
    	oneLayerItem(DEItems.SIMIX_HELMET);
    	oneLayerItem(DEItems.SIMIX_CHESTPLATE);
    	oneLayerItem(DEItems.SIMIX_LEGGINGS);
    	oneLayerItem(DEItems.SIMIX_BOOTS);
    	oneLayerItem(DEItems.SIMIX_HORSE_ARMOR);
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
    	
    	oneLayerItem(DEItems.WEATHER_POWER_STONE);
    	oneLayerItem(DEItems.TIME_POWER_STONE);
    	oneLayerItem(DEItems.WARP_POWER_STONE);
    	oneLayerItem(DEItems.POWER_GAUNTLET);
    	
    	oneLayerItem(DEItems.COORD_LINKER);
    	oneLayerItem(DEItems.REMOTE_TELEPORTER);
    	
    	oneLayerItem(DEItems.XP_SEEDS);
    	oneLayerItem(DEItems.HEART_SEEDS);
    	oneLayerItem(DEItems.XP_PLANTS);
    	oneLayerItem(DEItems.HEART);
    	oneLayerItem(DEItems.XP_ESSENCE);
    	oneLayerItem(DEItems.HEART_ESSENCE);
    	oneLayerItem(DEItems.PEARL_ESSENCE);
    	
    	oneLayerItem(DEItems.END_SIGN);
    	oneLayerItem(DEItems.END_BOAT);
    	
    	oneLayerItem(DEItems.BJM_DISC);
    	oneLayerItem(DEItems.DW_DISC);
    	
        //Block Items
        simpleBlockItem(DEBlocks.PALON_ORE);
        simpleBlockItem(DEBlocks.PALON_BLOCK);
        simpleBlockItem(DEBlocks.BASSMITE_ORE);
        simpleBlockItem(DEBlocks.BASSMITE_BLOCK);
        simpleBlockItem(DEBlocks.SIMIX_ORE);
        simpleBlockItem(DEBlocks.SIMIX_BLOCK);
        simpleBlockItem(DEBlocks.EMERTYST_ORE);
        simpleBlockItem(DEBlocks.EMERTYST_BLOCK);
        
        simpleBlockItem(DEBlocks.END_GRASS_BLOCK);
        simpleBlockItem(DEBlocks.END_LOG);
        simpleBlockItem(DEBlocks.STRIPPED_END_LOG);
        simpleBlockItem(DEBlocks.END_PLANKS);
        simpleBlockItem(DEBlocks.END_SLAB);
        inventoryItem(DEBlocks.END_FENCE);
        simpleBlockItem(DEBlocks.END_FENCE_GATE);
        inventoryItem(DEBlocks.END_BUTTON);
        simpleBlockItem(DEBlocks.END_PRESSURE_PLATE);
        oneLayerItem(DEBlocks.END_DOOR);
        trapDoorItem(DEBlocks.END_TRAPDOOR);
        simpleBlockItem(DEBlocks.END_LEAVES);
        simpleBlockItem(DEBlocks.END_STAIRS);
        simpleBlockItem(DEBlocks.END_BOOKSHELF);
        oneLayerItem(DEBlocks.END_ROSE);
        oneLayerItem(DEBlocks.END_SAPLING);
        simpleBlockItem(DEBlocks.END_SAND);
        simpleBlockItem(DEBlocks.END_SANDSTONE);
        
        simpleBlockItem(DEBlocks.FORGE);
        simpleBlockItem(DEBlocks.ESSENCE_EXTRACTOR);
        simpleBlockItem(DEBlocks.MINERAL_STORAGE);
        simpleBlockItem(DEBlocks.DISPLAY_BLOCK);
    }

    private void simpleBlockItem(RegistryObject<Block> block){
        getBuilder(block.getId().toString()).parent(getExistingFile(new ResourceLocation(DEMod.MOD_ID, "block/" + block.getId().getPath())));
    }

    private void inventoryItem(RegistryObject<Block> block) {
    	getBuilder(block.getId().toString()).parent(getExistingFile(new ResourceLocation(DEMod.MOD_ID, "block/" + block.getId().getPath() + "_inventory")));
    }

    private void trapDoorItem(RegistryObject<Block> block) {
    	getBuilder(block.getId().toString()).parent(getExistingFile(new ResourceLocation(DEMod.MOD_ID, "block/" + block.getId().getPath() + "_bottom")));
    }

    private void oneLayerItem(RegistryObject<?> item, ResourceLocation texture, boolean handheld){
        ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath());
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

    private void oneLayerItem(RegistryObject<?> item, boolean handheld){
        oneLayerItem(item, item.getId(), handheld);
    }

    private void oneLayerItem(RegistryObject<?> item){
        oneLayerItem(item, false);
    }
}
