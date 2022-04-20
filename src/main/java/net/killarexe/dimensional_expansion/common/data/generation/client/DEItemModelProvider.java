package net.killarexe.dimensional_expansion.common.data.generation.client;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DEItemModelProvider extends ItemModelProvider {
    public DEItemModelProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, DEMod.MODID, helper);
    }

    @Override
    protected void registerModels() {

        //Block Items
        simpleBlockItem(DEBlocks.PALON_ORE.get().asItem());
        simpleBlockItem(DEBlocks.PALON_BLOCK.get().asItem());
    }

    private void simpleBlockItem(Item item){
        getBuilder(item.getRegistryName().toString()).parent(getExistingFile(mcLoc("block/" + item.getRegistryName().getPath())));
    }

    private void oneLayerItem(Item item, ResourceLocation texture, boolean handheld){
        ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath());
        if(existingFileHelper.exists(itemTexture, PackType.CLIENT_RESOURCES, ".png", "textures")){
            if(!handheld) {
                getBuilder(item.getRegistryName().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", itemTexture);
            }else{
                getBuilder(item.getRegistryName().getPath()).parent(getExistingFile(mcLoc("item/handheld"))).texture("layer0", itemTexture);
            }
        }else{
            System.out.println("Failed to find texture for: " + item.getRegistryName().toString());
        }
    }

    private void oneLayerItem(Item item, boolean handheld){
        oneLayerItem(item, item.getRegistryName(), handheld);
    }

    private void oneLayerItem(Item item){
        oneLayerItem(item, item.getRegistryName(), false);
    }
}
