package net.killarexe.dimensional_expansion.mixin;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class DEMixin {
    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        DEMod.LOGGER.info("Dimensional Expansion v" + DEMod.VERSION);
    }
}
