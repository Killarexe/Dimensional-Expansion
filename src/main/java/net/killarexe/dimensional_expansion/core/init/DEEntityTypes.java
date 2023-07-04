package net.killarexe.dimensional_expansion.core.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.entity.*;
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
    
    public static final RegistryObject<EntityType<DEChestBoatEntity>> DE_CHEST_BOAT = ENTITY_TYPES.register("purpleheart_chest_boat",
            () -> EntityType.Builder.<DEChestBoatEntity>of(DEChestBoatEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(1.375F, 0.5625F)
                    .setCustomClientFactory(((spawnEntity, level) -> new DEChestBoatEntity(level, 0, 0, 0)))
                    .build("purpleheart_chest_boat"));
    
    public static final RegistryObject<EntityType<HeadedSkeleton>> HEADED_SKELETON = ENTITY_TYPES.register("headed_skeleton",
    		() -> EntityType.Builder.<HeadedSkeleton>of(HeadedSkeleton::new, MobCategory.MONSTER)
    			.sized(0.5f, 0.5f)
    			.canSpawnFarFromPlayer()
    			.build("headed_skeleton")
    );
    
    public static final RegistryObject<EntityType<HeadedGuardian>> HEADED_GUARDIAN = ENTITY_TYPES.register("headed_guardian",
    		() -> EntityType.Builder.<HeadedGuardian>of(HeadedGuardian::new, MobCategory.MISC)
    			.sized(0.5f, 0.5f)
    			.build("headed_gardian")
    );
    
    public static final RegistryObject<EntityType<BlueSandMan>> BLUE_SAND_MAN = ENTITY_TYPES.register("blue_sand_man",
    		() -> EntityType.Builder.<BlueSandMan>of(BlueSandMan::new, MobCategory.AMBIENT)
    			.sized(1, 1.5f)
    			.canSpawnFarFromPlayer()
    			.build("blue_sand_man")
    );
}
