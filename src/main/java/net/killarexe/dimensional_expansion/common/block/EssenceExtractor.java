package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.block.entity.EssenceExtractorBlockEntity;
import net.killarexe.dimensional_expansion.common.container.EssenceExtractorContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class EssenceExtractor extends BaseEntityBlock {
    public EssenceExtractor() {
        super(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).strength(6, 50).requiresCorrectToolForDrops().destroyTime(3).sound(SoundType.ANVIL).noOcclusion());
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide()){
            BlockEntity be = pLevel.getBlockEntity(pPos);
            if(be instanceof EssenceExtractorBlockEntity && pPlayer instanceof ServerPlayer){
                MenuProvider containerProvider = createContainerProvider(pLevel, pPos);
                NetworkHooks.openGui(((ServerPlayer) pPlayer), containerProvider, be.getBlockPos());
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new EssenceExtractorBlockEntity(blockPos, blockState);
    }

    private MenuProvider createContainerProvider(Level world, BlockPos pos){
        return new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return new TranslatableComponent("block." + DEMod.MODID + ".essence_extractor");
            }

            @Nullable
            @Override
            public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
                return new EssenceExtractorContainer(i, world, pos, inventory, player);
            }
        };
    }
}
