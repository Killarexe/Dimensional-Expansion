package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.container.EnchantTransferTableContainer;
import net.killarexe.dimensional_expansion.common.container.EssenceExtractorContainer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DEMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DEMod.MOD_ID);

    public static final RegistryObject<MenuType<EssenceExtractorContainer>> ESSENCE_EXTRACTOR_MENU_TYPE = createContainer(
            "essence_extractor_container",
            () -> new MenuType<>(EssenceExtractorContainer::new)
    );
    
    public static final RegistryObject<MenuType<EnchantTransferTableContainer>> ENCHANT_TRANSFER_TABLE_MENU_TYPE = createContainer(
    		"enchant_transfer_table_container",
    		() -> new MenuType<>(EnchantTransferTableContainer::new)
    );

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> createContainer(String name, Supplier<? extends MenuType<T>> type){
        return MENU_TYPES.register(name, type);
    }
}
