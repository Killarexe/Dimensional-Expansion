package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class DEItemGroups {

    public static final CreativeModeTab MISC = new CreativeModeTab(DEMod.MODID+".misc") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DEItems.PALON_INGOT.get());
        }
    };

    public static final CreativeModeTab BLOCKS = new CreativeModeTab(DEMod.MODID+".blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DEBlocks.PALON_BLOCK.get());
        }
    };

    public static final CreativeModeTab COMBAT = new CreativeModeTab(DEMod.MODID+".combat") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DEItems.PALON_SWORD.get());
        }
    };

    public static final CreativeModeTab TOOLS = new CreativeModeTab(DEMod.MODID+".tools") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DEItems.PALON_PICKAXE.get());
        }
    };
}
