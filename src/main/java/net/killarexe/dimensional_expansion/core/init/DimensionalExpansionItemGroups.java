package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DimensionalExpansionMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class DimensionalExpansionItemGroups {

    public static final CreativeModeTab MISC = new CreativeModeTab(DimensionalExpansionMod.MODID+".misc") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DimensionalExpansionItems.PALON_INGOT.get());
        }
    };

    public static final CreativeModeTab BUILDING_BLOCKS = new CreativeModeTab(DimensionalExpansionMod.MODID+".building_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DimensionalExpansionBlocks.PALON_BLOCK.get());
        }
    };

    public static final CreativeModeTab COMBAT = new CreativeModeTab(DimensionalExpansionMod.MODID+".combat") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DimensionalExpansionItems.PALON_SWORD.get());
        }
    };

    public static final CreativeModeTab TOOLS = new CreativeModeTab(DimensionalExpansionMod.MODID+".tools") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DimensionalExpansionItems.PALON_PICKAXE.get());
        }
    };

    public static final CreativeModeTab DECORATION_BLOCKS = new CreativeModeTab(DimensionalExpansionMod.MODID+".decoration_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DimensionalExpansionBlocks.BASSMITE_BLOCK.get());
        }
    };
}
