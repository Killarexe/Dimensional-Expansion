package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = DEMod.MOD_ID, bus = Bus.MOD)
public enum DECreativeTabs {
	MISC,
	BLOCKS,
	COMBAT,
	TOOLS;
	
	public static CreativeModeTab DE_MISC, DE_BLOCKS, DE_COMBAT, DE_TOOLS;
    
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
    		builder.icon(() -> new ItemStack(DEItems.SIMIX_SWORD.get()))
    				.title(Component.translatable("itemGroup.dimensional_expansion.combat"))
    				.build();	
    	});
    	DE_TOOLS = event.registerCreativeModeTab(new ResourceLocation(DEMod.MOD_ID, "tools"), builder -> {
    		builder.icon(() -> new ItemStack(DEItems.EMERTYST_PICKAXE.get()))
    				.title(Component.translatable("itemGroup.dimensional_expansion.tools"))
    				.build();	
    	});
    }
}
