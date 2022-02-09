package net.killarexe.dimensional_expansion.core.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class DEItemGroups {

    public static final ItemGroup MISC = FabricItemGroupBuilder.build(new Identifier(DEMod.MODID, "misc"), () -> new ItemStack(DEItems.PALON_INGOT));
    public static final ItemGroup BUILDING_BLOCKS = FabricItemGroupBuilder.build(new Identifier(DEMod.MODID, "building_blocks"), () -> new ItemStack(DEBlocks.PALON_BLOCK));
    public static final ItemGroup COMBAT = FabricItemGroupBuilder.build(new Identifier(DEMod.MODID, "combat"), () -> new ItemStack(DEItems.PALON_SWORD));
    public static final ItemGroup TOOLS = FabricItemGroupBuilder.build(new Identifier(DEMod.MODID, "tools"), () -> new ItemStack(DEItems.PALON_PICKAXE));
    public static final ItemGroup DECORATION_BLOCKS = FabricItemGroupBuilder.build(new Identifier(DEMod.MODID, "decoration_blocks"), () -> new ItemStack(DEBlocks.BASSMITE_BLOCK));
}
