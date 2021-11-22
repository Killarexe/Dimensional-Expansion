package net.killarexe.dimensional_expansion.uitls;

import com.mojang.blaze3d.platform.Window;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.gui.screen.WeatherChangerScreen;
import net.killarexe.dimensional_expansion.core.config.DEConfig;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.killarexe.dimensional_expansion.core.init.DEContainers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.inventory.ContainerScreen;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.inventory.MenuConstructor;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLPaths;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        final Window window = Minecraft.getInstance().getWindow();
        window.setTitle("Dimensional Expansion " + DEMod.VERSION);
        try {
            if(DEConfig.showIcon.get()) {
                window.setIcon(Files.newInputStream(Paths.get(FMLPaths.CONFIGDIR.get().toString(), "icon16x16.png"), StandardOpenOption.READ),
                        Files.newInputStream(Paths.get(FMLPaths.CONFIGDIR.get().toString(), "icon32x32.png"), StandardOpenOption.READ));
            }
        }catch (IOException io){
            DEMod.LOGGER.error(io);
        }

        MenuScreens.register(DEContainers.WEATHER_CHANGER_CONTAINER.get(), WeatherChangerScreen::new);

        DEMod.LOGGER.info("Set Blocks Settings");
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_LEAVES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(DEBlocks.END_DOOR.get(), RenderType.translucent());
    }
}
