package net.killarexe.dimensional_expansion.common.data.generation.client;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DEItemModelProvider extends ItemModelProvider {
    public DEItemModelProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, DEMod.MODID, helper);
    }

    @Override
    protected void registerModels() {
    	//Items
    	oneLayerItem(DEItems.RAW_PALON.get());
    	oneLayerItem(DEItems.PALON_INGOT.get());
    	oneLayerItem(DEItems.PALON_NUGGET.get());
    	oneLayerItem(DEItems.PALON_SWORD.get(), true);
    	oneLayerItem(DEItems.PALON_PICKAXE.get(), true);
    	oneLayerItem(DEItems.PALON_AXE.get(), true);
    	oneLayerItem(DEItems.PALON_SHOVEL.get(), true);
    	oneLayerItem(DEItems.PALON_HOE.get(), true);
    	oneLayerItem(DEItems.PALON_HELMET.get());
    	oneLayerItem(DEItems.PALON_CHESTPLATE.get());
    	oneLayerItem(DEItems.PALON_LEGGINGS.get());
    	oneLayerItem(DEItems.PALON_BOOTS.get());
    	oneLayerItem(DEItems.PALON_HORSE_ARMOR.get());
    	oneLayerItem(DEItems.PALON_MIXED_COAL.get());
    	
    	oneLayerItem(DEItems.BASSMITE_GEM.get());
    	oneLayerItem(DEItems.BASSMITE_SWORD.get(), true);
    	oneLayerItem(DEItems.BASSMITE_PICKAXE.get(), true);
    	oneLayerItem(DEItems.BASSMITE_AXE.get(), true);
    	oneLayerItem(DEItems.BASSMITE_SHOVEL.get(), true);
    	oneLayerItem(DEItems.BASSMITE_HOE.get(), true);
    	oneLayerItem(DEItems.BASSMITE_HELMET.get());
    	oneLayerItem(DEItems.BASSMITE_CHESTPLATE.get());
    	oneLayerItem(DEItems.BASSMITE_LEGGINGS.get());
    	oneLayerItem(DEItems.BASSMITE_BOOTS.get());
    	oneLayerItem(DEItems.BASSMITE_HORSE_ARMOR.get());
    	oneLayerItem(DEItems.BASSMITE_MIXED_COAL.get());
    	
    	oneLayerItem(DEItems.RAW_SIMIX.get());
    	oneLayerItem(DEItems.SIMIX_INGOT.get());
    	oneLayerItem(DEItems.SIMIX_NUGGET.get());
    	oneLayerItem(DEItems.SIMIX_SWORD.get(), true);
    	oneLayerItem(DEItems.SIMIX_PICKAXE.get(), true);
    	oneLayerItem(DEItems.SIMIX_AXE.get(), true);
    	oneLayerItem(DEItems.SIMIX_SHOVEL.get(), true);
    	oneLayerItem(DEItems.SIMIX_HOE.get(), true);
    	oneLayerItem(DEItems.SIMIX_HELMET.get());
    	oneLayerItem(DEItems.SIMIX_CHESTPLATE.get());
    	oneLayerItem(DEItems.SIMIX_LEGGINGS.get());
    	oneLayerItem(DEItems.SIMIX_BOOTS.get());
    	oneLayerItem(DEItems.SIMIX_HORSE_ARMOR.get());
    	oneLayerItem(DEItems.SIMIX_MIXED_COAL.get());
    	
    	oneLayerItem(DEItems.EMERTYST_GEM.get());
    	oneLayerItem(DEItems.EMERTYST_SWORD.get(), true);
    	oneLayerItem(DEItems.EMERTYST_PICKAXE.get(), true);
    	oneLayerItem(DEItems.EMERTYST_AXE.get(), true);
    	oneLayerItem(DEItems.EMERTYST_SHOVEL.get(), true);
    	oneLayerItem(DEItems.EMERTYST_HOE.get(), true);
    	oneLayerItem(DEItems.EMERTYST_HELMET.get());
    	oneLayerItem(DEItems.EMERTYST_CHESTPLATE.get());
    	oneLayerItem(DEItems.EMERTYST_LEGGINGS.get());
    	oneLayerItem(DEItems.EMERTYST_BOOTS.get());
    	oneLayerItem(DEItems.EMERTYST_HORSE_ARMOR.get());
    	oneLayerItem(DEItems.EMERTYST_MIXED_COAL.get());
    	
    	oneLayerItem(DEItems.WEATHER_POWER_STONE.get());
    	oneLayerItem(DEItems.TIME_POWER_STONE.get());
    	oneLayerItem(DEItems.WARP_POWER_STONE.get());
    	oneLayerItem(DEItems.POWER_GAUNTLET.get());
    	
    	oneLayerItem(DEItems.COORD_LINKER.get());
    	
    	oneLayerItem(DEItems.XP_SEEDS.get());
    	oneLayerItem(DEItems.HEART_SEEDS.get());
    	oneLayerItem(DEItems.XP_PLANTS.get());
    	oneLayerItem(DEItems.HEART.get());
    	oneLayerItem(DEItems.XP_ESSENCE.get());
    	oneLayerItem(DEItems.HEART_ESSENCE.get());
    	oneLayerItem(DEItems.PEARL_ESSENCE.get());
    	
    	oneLayerItem(DEItems.END_SIGN.get());
    	oneLayerItem(DEItems.END_BOAT.get());
    	
    	oneLayerItem(DEItems.BJM_DISC.get());
    	oneLayerItem(DEItems.DW_DISC.get());
    	
        //Block Items
        simpleBlockItem(DEBlocks.PALON_ORE.get().asItem());
        simpleBlockItem(DEBlocks.PALON_BLOCK.get().asItem());
        simpleBlockItem(DEBlocks.BASSMITE_ORE.get().asItem());
        simpleBlockItem(DEBlocks.BASSMITE_BLOCK.get().asItem());
        simpleBlockItem(DEBlocks.SIMIX_ORE.get().asItem());
        simpleBlockItem(DEBlocks.SIMIX_BLOCK.get().asItem());
        simpleBlockItem(DEBlocks.EMERTYST_ORE.get().asItem());
        simpleBlockItem(DEBlocks.EMERTYST_BLOCK.get().asItem());
        
        simpleBlockItem(DEBlocks.END_GRASS_BLOCK.get().asItem());
        simpleBlockItem(DEBlocks.END_LOG.get().asItem());
        simpleBlockItem(DEBlocks.END_STRIPPED_LOG.get().asItem());
        simpleBlockItem(DEBlocks.END_PLANKS.get().asItem());
        simpleBlockItem(DEBlocks.END_SLAB.get().asItem());
        simpleBlockItem(DEBlocks.END_FENCE.get().asItem());
        simpleBlockItem(DEBlocks.END_FENCE_GATE.get().asItem());
        simpleBlockItem(DEBlocks.END_BUTTON.get().asItem());
        simpleBlockItem(DEBlocks.END_PRESSURE_PLATE.get().asItem());
        oneLayerItem(DEBlocks.END_DOOR.get());
        simpleBlockItem(DEBlocks.END_TRAPDOOR.get().asItem());
        simpleBlockItem(DEBlocks.END_LEAVES.get().asItem());
        simpleBlockItem(DEBlocks.END_STAIRS.get().asItem());
        simpleBlockItem(DEBlocks.END_BOOKSHELF.get().asItem());
        oneLayerItem(DEBlocks.END_ROSE.get());
        oneLayerItem(DEBlocks.END_SAPLING.get());
        simpleBlockItem(DEBlocks.END_SAND.get().asItem());
        simpleBlockItem(DEBlocks.END_SANDSTONE.get().asItem());
        
        simpleBlockItem(DEBlocks.FORGE.get().asItem());
        simpleBlockItem(DEBlocks.ESSENCE_EXTRACTOR.get().asItem());
        simpleBlockItem(DEBlocks.MINERAL_STORAGE.get().asItem());
        simpleBlockItem(DEBlocks.DISPLAY_BLOCK.get().asItem());
    }

    private void simpleBlockItem(Item item){
        getBuilder(item.getRegistryName().toString()).parent(getExistingFile(mcLoc("block/" + item.getRegistryName().getPath())));
    }

    private void oneLayerItem(ItemLike item, ResourceLocation texture, boolean handheld){
        ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath());
        if(existingFileHelper.exists(itemTexture, PackType.CLIENT_RESOURCES, ".png", "textures")){
            if(!handheld) {
                getBuilder(item.asItem().getRegistryName().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", itemTexture);
            }else{
                getBuilder(item.asItem().getRegistryName().getPath()).parent(getExistingFile(mcLoc("item/handheld"))).texture("layer0", itemTexture);
            }
        }else{
            DEMod.LOGGER.warn("Failed to find texture for: " + item.asItem().getRegistryName().toString());
        }
    }

    private void oneLayerItem(ItemLike item, boolean handheld){
        oneLayerItem(item, item.asItem().getRegistryName(), handheld);
    }

    private void oneLayerItem(ItemLike item){
        oneLayerItem(item, false);
    }
}
