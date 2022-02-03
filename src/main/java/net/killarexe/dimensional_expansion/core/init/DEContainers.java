package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.container.EssenceExtractorContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class DEContainers {

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, DEMod.MODID);

    public static final RegistryObject<MenuType<EssenceExtractorContainer>> ESSENCE_EXTRACTOR_CONTAINER = createContainer(
            "essence_extractor_container",
            () -> new MenuType<>(EssenceExtractorContainer::new));

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> createContainer(@Nonnull String name, Supplier<? extends MenuType<T>> type){
        return CONTAINERS.register(name, type);
    }
}
