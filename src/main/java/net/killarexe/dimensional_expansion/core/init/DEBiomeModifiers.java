package net.killarexe.dimensional_expansion.core.init;

import com.mojang.serialization.Codec;
import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.world.DEBiomeModifier;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DEBiomeModifiers {

    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, DEMod.MOD_ID);

    public static final RegistryObject<Codec<? extends BiomeModifier>> DE_BIOME_MODIFIER = BIOME_MODIFIERS.register(DEMod.MOD_ID + "_biome_modifier", () -> Codec.unit(DEBiomeModifier::new));
}
