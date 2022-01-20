package net.killarexe.dimensional_expansion.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.world.poi.PointOfInterestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

@Mixin(PointOfInterestType.class)
public interface DEPoiTypeAccessor {
    @Accessor("BLOCK_STATE_TO_POINT_OF_INTEREST_TYPE")
    public static Map<BlockState, PointOfInterestType> getBLOCK_STATE_TO_POINT_OF_INTEREST_TYPE(){
        throw new AssertionError();
    };
}
