package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.entity.BlueSandMan;
import net.killarexe.dimensional_expansion.common.entity.DEBoatEntity;
import net.killarexe.dimensional_expansion.common.entity.DEChestBoatEntity;
import net.killarexe.dimensional_expansion.common.entity.HeadedGuardian;
import net.killarexe.dimensional_expansion.common.entity.HeadedSkeleton;
import net.killarexe.dimensional_expansion.common.entity.Juger;
import net.killarexe.dimensional_expansion.common.entity.Mouvet;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DEEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, DEMod.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<DEBoatEntity>> DE_BOAT = ENTITY_TYPES.register("purpleheart_boat",
            () -> EntityType.Builder.<DEBoatEntity>of(DEBoatEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(1.375F, 0.5625F)
					.clientTrackingRange(10)
                    .build("purpleheart_boat"));
    
    public static final DeferredHolder<EntityType<?>, EntityType<DEChestBoatEntity>> DE_CHEST_BOAT = ENTITY_TYPES.register("purpleheart_chest_boat",
            () -> EntityType.Builder.<DEChestBoatEntity>of(DEChestBoatEntity::new, MobCategory.MISC)
                    .fireImmune()
                    .sized(1.375F, 0.5625F)
					.clientTrackingRange(10)
                    .build("purpleheart_chest_boat"));
    
    public static final DeferredHolder<EntityType<?>, EntityType<HeadedSkeleton>> HEADED_SKELETON = ENTITY_TYPES.register("headed_skeleton",
    		() -> EntityType.Builder.<HeadedSkeleton>of(HeadedSkeleton::new, MobCategory.MONSTER)
    			.sized(0.5f, 0.5f)
    			.canSpawnFarFromPlayer()
    			.build("headed_skeleton")
    );
    
    public static final DeferredHolder<EntityType<?>, EntityType<HeadedGuardian>> HEADED_GUARDIAN = ENTITY_TYPES.register("headed_guardian",
    		() -> EntityType.Builder.<HeadedGuardian>of(HeadedGuardian::new, MobCategory.MISC)
    			.sized(0.5f, 0.5f)
    			.build("headed_gardian")
    );
    
    public static final DeferredHolder<EntityType<?>, EntityType<BlueSandMan>> BLUE_SAND_MAN = ENTITY_TYPES.register("blue_sand_man",
    		() -> EntityType.Builder.<BlueSandMan>of(BlueSandMan::new, MobCategory.AMBIENT)
    			.sized(1, 1.5f)
    			.canSpawnFarFromPlayer()
    			.build("blue_sand_man")
    );
    
    public static final DeferredHolder<EntityType<?>, EntityType<Mouvet>> MOUVET = ENTITY_TYPES.register("mouvet",
    		() -> EntityType.Builder.<Mouvet>of(Mouvet::new, MobCategory.AMBIENT)
    			.sized(0.5f, 0.5f)
    			.canSpawnFarFromPlayer()
    			.build("mouvet")
    );
    
    public static final DeferredHolder<EntityType<?>, EntityType<Juger>> JUGER = ENTITY_TYPES.register("juger",
    		() -> EntityType.Builder.<Juger>of(Juger::new, MobCategory.MONSTER)
    		.sized(1.5f, 0.5f)
    		.canSpawnFarFromPlayer()
    		.build("juger")
    );
    
    public static void registerAttributes(EntityAttributeCreationEvent e) {
    	e.put(HEADED_SKELETON.get(), HeadedSkeleton.ATTRIBUTES.build());
    	e.put(HEADED_GUARDIAN.get(), HeadedSkeleton.ATTRIBUTES.build());
    	e.put(BLUE_SAND_MAN.get(), BlueSandMan.ATTRIBUTES.build());
    	e.put(MOUVET.get(), Mouvet.ATTRIBUTES.build());
    	e.put(JUGER.get(), Juger.ATTRIBUTES.build());
    }
    
    public static void registerSpawns(SpawnPlacementRegisterEvent e) {
    	e.register(BLUE_SAND_MAN.get(), SpawnPlacementTypes.ON_GROUND, Types.WORLD_SURFACE_WG, AgeableMob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
    	e.register(HEADED_SKELETON.get(), SpawnPlacementTypes.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
    	e.register(MOUVET.get(), SpawnPlacementTypes.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, AgeableMob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
    	e.register(JUGER.get(), SpawnPlacementTypes.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
    }
}
