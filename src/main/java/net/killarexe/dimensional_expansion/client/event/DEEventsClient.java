package net.killarexe.dimensional_expansion.client.event;

import net.killarexe.dimensional_expansion.client.gui.screen.DETitleScreen;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.layers.CapeLayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DEEventsClient {
	
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onPlayerJoinEvent(EntityJoinLevelEvent e){
    	if(e.getEntity() instanceof Player player) {
    		for(EntityRenderer<? extends Player> renderer: Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap().values()){
                if(renderer instanceof PlayerRenderer playerRenderer) {
                    playerRenderer.addLayer(new CapeLayer(playerRenderer));
                }
           }
    	}
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onScreenPost(final ScreenEvent.Init.Post event) {
        if(DEConfig.moddedScreens.get()){
            if(event.getScreen() instanceof TitleScreen screen){
                screen.getMinecraft().setScreen(new DETitleScreen(screen.fading));
            }
            /*if(event.getScreen() instanceof PauseScreen screen){
                ResourceLocation icons = new ResourceLocation(DEMod.MOD_ID, "textures/gui/widgets.png");
                Minecraft minecraft = screen.getMinecraft();
                int width = screen.width;
                int height = screen.height;

                screen.renderables.add(new ImageButton(width / 2 -200, height / 4 + 48 + 60, 16, 16, 0, 96, icons, (button -> {
                    minecraft.setScreen(new DEConfigScreen(screen));
                })));
                screen.renderables.add(new ImageButton(width / 2 -200, height / 4 + 48 + 40, 16, 16, 0, 0, icons, (button -> {
                    Util.getPlatform().openUri("https://discord.gg/xYytpBTd3r");
                })));
                screen.renderables.add(new ImageButton(width / 2 -200, height / 4 + 48 + 20, 16, 16, 0, 64, icons, (button -> {
                    Util.getPlatform().openUri("https://youtube.com/channel/UC7lHA5pMQMrTTeZg1yk2hXw");
                })));
                screen.renderables.add(new ImageButton(width / 2 -200, height / 4 + 48, 16, 16, 0, 32, icons, (button -> {
                    Util.getPlatform().openUri("https://github.com/Killarexe/Dimensional-Expansion");
                })));
            }*/
        }else {
        	if(event.getScreen() instanceof DETitleScreen screen) {
        		screen.getMinecraft().setScreen(new TitleScreen(true));
        	}
        }
    }

}
