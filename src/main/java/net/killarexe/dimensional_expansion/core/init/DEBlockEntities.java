package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.block.entity.DisplayBlockEntity;
import net.killarexe.dimensional_expansion.common.block.entity.EndSignBlockEntity;
import net.killarexe.dimensional_expansion.common.block.entity.EssenceExtractorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class DEBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES= DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, DEMod.MODID);

    public static final RegistryObject<BlockEntityType<EndSignBlockEntity>> END_SIGN = register("end_sign", () -> BlockEntityType.Builder.of(EndSignBlockEntity::new, DEBlocks.END_SIGN.get(), DEBlocks.END_WALL_SIGN.get()));
    public static final RegistryObject<BlockEntityType<EssenceExtractorBlockEntity>> ESSENCE_EXTRACTOR = register("essence_extractor", () -> BlockEntityType.Builder.of(EssenceExtractorBlockEntity::new, DEBlocks.ESSENCE_EXTRACTOR.get()));
    public static final RegistryObject<BlockEntityType<DisplayBlockEntity>> DISPLAY_BLOCK = register("display_block", () -> BlockEntityType.Builder.of(DisplayBlockEntity::new, DEBlocks.DISPLAY_BLOCK.get()));

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(@Nonnull String name, @Nonnull Supplier<BlockEntityType.Builder<T>> initializer) {
        return BLOCK_ENTITIES.register(name, () -> initializer.get().build(null));
    }
}
