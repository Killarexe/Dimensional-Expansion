package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.block.entity.DisplayBlockEntity;
import net.killarexe.dimensional_expansion.common.block.entity.EnchantTransferTableEntity;
import net.killarexe.dimensional_expansion.common.block.entity.PurpleheartSignBlockEntity;
import net.killarexe.dimensional_expansion.common.block.entity.EssenceExtractorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class DEBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DEMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<PurpleheartSignBlockEntity>> PURPLEHEART_SIGN = register(
    		"purpleheart_sign",
    		() -> BlockEntityType.Builder.of(
    				PurpleheartSignBlockEntity::new,
    				DEBlocks.PURPLEHEART_SIGN.get(),
    				DEBlocks.PURPLEHEART_WALL_SIGN.get()
    		)
    );
    public static final RegistryObject<BlockEntityType<EssenceExtractorBlockEntity>> ESSENCE_EXTRACTOR = register(
    		"essence_extractor",
    		() -> BlockEntityType.Builder.of(
    				EssenceExtractorBlockEntity::new,
    				DEBlocks.ESSENCE_EXTRACTOR.get()
    		)
    );
    public static final RegistryObject<BlockEntityType<DisplayBlockEntity>> DISPLAY_BLOCK = register(
    		"display_block",
    		() -> BlockEntityType.Builder.of(
    				DisplayBlockEntity::new,
    				DEBlocks.DISPLAY_BLOCK.get()
    		)
    );
    public static final RegistryObject<BlockEntityType<EnchantTransferTableEntity>> ENCHANT_TRANSFER_TABLE = register(
    		"enchant_transfer_table",
    		() -> BlockEntityType.Builder.of(
    				EnchantTransferTableEntity::new,
    				DEBlocks.ENCHANT_TRANSFER_TABLE.get()
    		)
    );
    
    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(@Nonnull String name, @Nonnull Supplier<BlockEntityType.Builder<T>> initializer) {
        return BLOCK_ENTITY_TYPES.register(name, () -> initializer.get().build(null));
    }
}
