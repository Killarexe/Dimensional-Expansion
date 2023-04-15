package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.entity.DEBoatEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DEEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DEMod.MOD_ID);

    public static final RegistryObject<EntityType<DEBoatEntity>> DE_BOAT = ENTITY_TYPES.register("purpleheart_boat",
            () -> EntityType.Builder.<DEBoatEntity>of(DEBoatEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(1.375F, 0.5625F)
                    .setCustomClientFactory(((spawnEntity, level) -> new DEBoatEntity(level, 0, 0, 0)))
                    .build("purpleheart_boat"));
    
    public static final RegistryObject<EntityType<DEBoatEntity>> DE_CHEST_BOAT = ENTITY_TYPES.register("purpleheart_chest_boat",
            () -> EntityType.Builder.<DEBoatEntity>of(DEBoatEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(1.375F, 0.5625F)
                    .setCustomClientFactory(((spawnEntity, level) -> new DEBoatEntity(level, 0, 0, 0)))
                    .build("purpleheart_chest_boat"));
}
