package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.blockentity.WeatherChangerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class DEBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES= DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, DEMod.MODID);

    public static final RegistryObject<BlockEntityType<WeatherChangerBlockEntity>> WEATHER_CHANGER = register("weather_changer", () -> BlockEntityType.Builder.of(WeatherChangerBlockEntity::new, DEBlocks.WEATHER_CHANGER.get()));

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(@Nonnull String name, @Nonnull Supplier<BlockEntityType.Builder<T>> initializer) {
        return BLOCK_ENTITIES.register(name, () -> initializer.get().build(null));
    }
}
