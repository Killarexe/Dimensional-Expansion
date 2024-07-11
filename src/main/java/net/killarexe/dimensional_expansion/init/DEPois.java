package net.killarexe.dimensional_expansion.init;

import com.google.common.collect.ImmutableSet;
import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DEPois {
    public static final DeferredRegister<PoiType> POI_TYPE = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, DEMod.MOD_ID);

    public static final DeferredHolder<PoiType, PoiType> ORIGIN_PORTAL = createPoi("origin_portal", DEBlocks.ORIGIN_PORTAL);

    private static DeferredHolder<PoiType, PoiType> createPoi(String name, Holder<Block> block) {
        return POI_TYPE.register(name, () -> new PoiType(ImmutableSet.copyOf(block.value().getStateDefinition().getPossibleStates()), 0, 1));
    }
}
