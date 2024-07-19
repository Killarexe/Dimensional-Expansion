package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class DECreativeTabs {
	
	public enum Tabs{
		BLOCKS,
		MISC,
		TOOLS,
		COMBAT,
		MOBS
	}
	
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DEMod.MOD_ID);
	
	public static final Supplier<CreativeModeTab> BLOCKS = createTab("blocks", DEBlocks.ORIGIN_GRASS_BLOCK);
	public static final Supplier<CreativeModeTab> MISC = createTab("misc", DEItems.EMERTYST_GEM);
	public static final Supplier<CreativeModeTab> TOOLS = createTab("tools", DEItems.SIMIX_HAMMER);
	public static final Supplier<CreativeModeTab> COMBAT = createTab("combat", DEItems.BASSMITE_AXE);
	public static final Supplier<CreativeModeTab> MOBS = createTab("mobs", DEItems.BLUE_SAND_MAN_SPAWN_EGG);
	
	private static Supplier<CreativeModeTab> createTab(String id, Supplier<? extends ItemLike> icon){
		return CREATIVE_MOD_TABS.register(id, () -> 
		CreativeModeTab.builder()
			.icon(() -> new ItemStack(icon.get()))
			.title(Component.translatable("itemGroup." + DEMod.MOD_ID + "." + id))
			.build()
		);
	}
	
	private static void addItemsToCreativeTab(BuildCreativeModeTabContentsEvent event, Tabs tab) {
    	DEItems.ITEMS.getEntries().forEach((item) -> {
    		if(DEItems.ITEM_TAB_MAP.get(item.getId().getPath()) == tab) {
    			event.accept(item.get());
    		}
    	});
    }
    
    public static void addItemsToCreativeTabs(BuildCreativeModeTabContentsEvent e) {
    	if (e.getTab() == MISC.get()) {
    		addItemsToCreativeTab(e, Tabs.MISC);
    	} else if (e.getTab() == BLOCKS.get()) {
    		addItemsToCreativeTab(e, Tabs.BLOCKS);
    	} else if (e.getTab() == COMBAT.get()) {
    		addItemsToCreativeTab(e, Tabs.COMBAT);
    	} else if (e.getTab() == TOOLS.get()) {
    		addItemsToCreativeTab(e, Tabs.TOOLS);
    	} else if (e.getTab() == MOBS.get()) {
    		addItemsToCreativeTab(e, Tabs.MOBS);
    	}
    }
}
