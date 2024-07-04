package net.killarexe.dimensional_expansion.mixin;

import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(targets = "net.minecraft.world.entity.npc.VillagerTrades$EmeraldsForVillagerTypeItem")
public interface EmeraldsForVillagerTypeItemAccessor {
    @Accessor("trades")
    Map<VillagerType, Item> getTrades();
}
