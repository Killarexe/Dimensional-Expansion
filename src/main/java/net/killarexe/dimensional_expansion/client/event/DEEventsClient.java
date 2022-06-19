package net.killarexe.dimensional_expansion.client.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DEEventsClient {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onScreenPost(final ScreenEvent.InitScreenEvent.Post event) {

    }

}
