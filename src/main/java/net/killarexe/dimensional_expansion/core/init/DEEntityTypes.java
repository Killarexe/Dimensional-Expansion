package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.entity.EndBoatEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DEEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DEMod.MOD_ID);

    public static final RegistryObject<EntityType<EndBoatEntity>> END_BOAT = ENTITY_TYPES.register("end_boat",
            () -> EntityType.Builder.<EndBoatEntity>of(EndBoatEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(1.375F, 0.5625F)
                    .setCustomClientFactory(((spawnEntity, level) -> new EndBoatEntity(level, 0, 0, 0)))
                    .build("end_boat"));
}
