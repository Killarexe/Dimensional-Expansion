package net.killarexe.dimensional_expansion.core.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class DEJei implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(DEMod.MODID, "jei_plugin");
    }
}
