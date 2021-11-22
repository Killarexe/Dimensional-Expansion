package net.killarexe.dimensional_expansion.common.block;

import net.killarexe.dimensional_expansion.common.blockentity.WeatherChangerBlockEntity;
import net.killarexe.dimensional_expansion.common.container.WeatherChangerContainer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fml.config.ConfigTracker;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

import javax.annotation.Nullable;

public class WeatherChangerBlock extends BaseEntityBlock {

    public WeatherChangerBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_, Player p_60506_, InteractionHand p_60507_, BlockHitResult p_60508_) {
        if(p_60504_.isClientSide()){
            BlockEntity be = p_60504_.getBlockEntity(p_60505_);

            if(!p_60506_.isCrouching()){
                if(be instanceof WeatherChangerBlockEntity && p_60506_ instanceof ServerPlayer){
                    MenuProvider containerProvider = createContainerProvider(p_60504_, p_60505_);
                    NetworkHooks.openGui(((ServerPlayer) p_60506_), containerProvider, be.getBlockPos());
                }
            }else{
                //TODO change weather
            }
        }
        return InteractionResult.SUCCESS;
    }

    private MenuProvider createContainerProvider(Level world, BlockPos pos){
        return new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return new TextComponent("Weather Changer");
            }

            @Nullable
            @Override
            public AbstractContainerMenu createMenu(int p_39954_, Inventory p_39955_, Player p_39956_) {
                return new WeatherChangerContainer(p_39954_, world, pos, p_39955_, p_39956_);
            }
        };
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new WeatherChangerBlockEntity(p_153215_, p_153216_);
    }

    @Override
    public boolean hasDynamicShape() {
        return true;
    }
}
