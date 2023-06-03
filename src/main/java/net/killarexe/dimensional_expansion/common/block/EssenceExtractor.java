package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.common.block.entity.EssenceExtractorBlockEntity;
import net.killarexe.dimensional_expansion.common.container.EssenceExtractorContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;

import java.util.stream.Stream;

public class EssenceExtractor extends Block implements EntityBlock {
    public EssenceExtractor() {
        super(BlockBehaviour.Properties
        		.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY)
        		.strength(4, 20)
        		.requiresCorrectToolForDrops()
        		.destroyTime(3)
        		.sound(SoundType.ANVIL)
        		.noOcclusion()
        );
    }

    public static final VoxelShape SHAPE = Stream.of(
    		Stream.of(
    				Block.box(0, 0, 0, 1, 16, 1),
    				Block.box(15, 0, 0, 16, 16, 1),
    				Block.box(15, 0, 15, 16, 16, 16),
    				Block.box(0, 0, 15, 1, 16, 16))
    		.reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(),
    				Block.box(3, 8, 3, 13, 16, 13),
    				Block.box(1, 0, 1, 15, 8, 15))
    		.reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null
                : (level0, pos, state0, blockEntity) -> ((EssenceExtractorBlockEntity) blockEntity).tick();
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EssenceExtractorBlockEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (!level.isClientSide && level.getBlockEntity(pos) instanceof final EssenceExtractorBlockEntity be) {
            final MenuProvider container = new SimpleMenuProvider(EssenceExtractorContainer.getServerContainer(be, pos), EssenceExtractorBlockEntity.TITLE);
            NetworkHooks.openScreen((ServerPlayer) player, container, pos);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.sidedSuccess(true);
    }
}
