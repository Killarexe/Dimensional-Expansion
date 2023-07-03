package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public enum DECreativeTabs {
	MISC,
	BLOCKS,
	COMBAT,
	TOOLS,
	MOBS;
	
	public static CreativeModeTab DE_MISC, DE_BLOCKS, DE_COMBAT, DE_TOOLS, DE_MOBS;
    
    @SubscribeEvent
    public static void registerCreativeTabs(CreativeModeTabEvent.Register event) {
    	DEMod.LOGGER.info("Init Dimensional Expansion Createive Tabs...");
    	DE_MISC = event.registerCreativeModeTab(new ResourceLocation(DEMod.MOD_ID, "misc"), builder -> {
    		builder.icon(() -> new ItemStack(DEItems.PALON_INGOT.get()))
    				.title(Component.translatable("itemGroup.dimensional_expansion.misc"))
    				.build();	
    	});
    	DE_BLOCKS = event.registerCreativeModeTab(new ResourceLocation(DEMod.MOD_ID, "blocks"), builder -> {
    		builder.icon(() -> new ItemStack(DEBlocks.ORIGIN_GRASS_BLOCK.get()))
    				.title(Component.translatable("itemGroup.dimensional_expansion.blocks"))
    				.build();	
    	});
    	DE_COMBAT = event.registerCreativeModeTab(new ResourceLocation(DEMod.MOD_ID, "combat"), builder -> {
    		builder.icon(() -> new ItemStack(DEItems.EMERTYST_SWORD.get()))
    				.title(Component.translatable("itemGroup.dimensional_expansion.combat"))
    				.build();	
    	});
    	DE_TOOLS = event.registerCreativeModeTab(new ResourceLocation(DEMod.MOD_ID, "tools"), builder -> {
    		builder.icon(() -> new ItemStack(DEItems.EMERTYST_PICKAXE.get()))
    				.title(Component.translatable("itemGroup.dimensional_expansion.tools"))
    				.build();	
    	});
    	DE_MOBS = event.registerCreativeModeTab(new ResourceLocation(DEMod.MOD_ID, "mobs"), builder -> {
    		builder.icon(() -> new ItemStack(DEItems.HEADED_GUARDIAN_SPAWN_EGG.get()))
    				.title(Component.translatable("itemGroup.dimensional_expansion.mobs"))
    				.build();	
    	});
    }
   
    private static void addItemsToCreativeTab(CreativeModeTabEvent.BuildContents event, DECreativeTabs tab) {
    	DEItems.ITEMS.getEntries().forEach((item) -> {
    		if(DEItems.ITEM_TAB_MAP.get(item.getId().getPath()) == tab) {
    			event.accept(item.get());
    		}
    	});
    }
    
    @SubscribeEvent
    public static void addItemsToCreativeTabs(CreativeModeTabEvent.BuildContents e) {
    	if(e.getTab() == DE_MISC) {
    		addItemsToCreativeTab(e, MISC);
    	}else if(e.getTab() == DE_BLOCKS) {
    		addItemsToCreativeTab(e, BLOCKS);
    	}else if(e.getTab() == DE_COMBAT) {
    		addItemsToCreativeTab(e, COMBAT);
    	}else if(e.getTab() == DE_TOOLS) {
    		addItemsToCreativeTab(e, TOOLS);
    	}else if(e.getTab() == DE_MOBS) {
    		addItemsToCreativeTab(e, MOBS);
    	}
    }
}
