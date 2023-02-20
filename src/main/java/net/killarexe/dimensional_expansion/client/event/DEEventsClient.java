package net.killarexe.dimensional_expansion.client.event;

import net.killarexe.dimensional_expansion.client.gui.screen.DETitleScreen;
import net.killarexe.dimensional_expansion.common.config.DEConfig;
import net.killarexe.dimensional_expansion.core.init.DEKeyBindings;
import net.killarexe.dimensional_expansion.utils.DEUtils;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.common.Tags;

public class DEEventsClient {

	@OnlyIn(Dist.CLIENT)
    public static void onScreenPost(final ScreenEvent.Init.Post event) {
        if(DEConfig.moddedScreens.get()){
            if(event.getScreen() instanceof TitleScreen screen){
                screen.getMinecraft().setScreen(new DETitleScreen(screen.fading));
            }
        }else {
        	if(event.getScreen() instanceof DETitleScreen screen) {
        		screen.getMinecraft().setScreen(new TitleScreen(screen.fading));
        	}
        }
    }

	public static void onKeyRegister(RegisterKeyMappingsEvent e) {
		for(KeyMapping key: DEKeyBindings.KEYS) {
			e.register(key);
		}
	}
	
	public static void onKeyInput(InputEvent.Key e) {
		if(DEKeyBindings.RENDER_KEY.consumeClick() && (DEUtils.isDev() || DEUtils.isDevAccount()) && DEConfig.devMod.get()) {
			isActive = !isActive;
		}
	}
	
	public static boolean isActive = false;
	public static final int range = 16;
	@SuppressWarnings("deprecation")
	@OnlyIn(Dist.CLIENT)
    public static void renderLayer(RenderLevelStageEvent event) {
    	if(event.getStage() == Stage.AFTER_SOLID_BLOCKS && isActive) {
    		Minecraft mc = Minecraft.getInstance();
    		Level level = mc.level;
    		Player player = mc.player;
    		if(player == null || level == null) {
    			return;
    		}
    		BlockPos playerPos = player.blockPosition();
    		Vec3 cameraPos = event.getCamera().getPosition();
    		for(BlockPos pos: BlockPos.betweenClosed(
    				playerPos.getX() - range, playerPos.getY() - range, playerPos.getZ() - range,
    				playerPos.getX() + range, playerPos.getY() + range, playerPos.getZ() + range
    		)) {
    			BlockState state = level.getBlockState(pos);
    			if(state.getTags().toList().contains(Tags.Blocks.ORES)){
    				event.getPoseStack().pushPose();
    				event.getPoseStack().translate(pos.getX() - cameraPos.x, pos.getY() - cameraPos.y, pos.getZ() - cameraPos.z);
    				mc.getBlockRenderer().renderSingleBlock(state, event.getPoseStack(), mc.renderBuffers().bufferSource(), LightTexture.FULL_BRIGHT, LightTexture.FULL_BLOCK, ModelData.EMPTY, 
    						RenderType.textSeeThrough(TextureAtlas.LOCATION_BLOCKS));
    				event.getPoseStack().popPose();
    			}
    		}
    	}
    }
}
