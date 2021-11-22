package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.container.WeatherChangerContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class DEContainers {

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, DEMod.MODID);

    public static final RegistryObject<MenuType<WeatherChangerContainer>> WEATHER_CHANGER_CONTAINER = createContainer("weather_changer_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                Level world = inv.player.level;
                return new WeatherChangerContainer(windowId, world, pos, inv, inv.player);
            })));

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> createContainer(@Nonnull String name, Supplier<? extends MenuType<T>> type){
        return CONTAINERS.register(name, type);
    }
}
