package net.killarexe.dimensional_expansion.common.entity;

import net.killarexe.dimensional_expansion.core.init.DEEntityTypes;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class EndBoatEntity extends Boat {

    public static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(EndBoatEntity.class, EntityDataSerializers.INT);

    public EndBoatEntity(Level level, double x, double y, double z) {
        this(DEEntityTypes.END_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    public EndBoatEntity(EntityType<? extends Boat> type, Level level) {
        super(type, level);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", getDEBoatType().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if(pCompound.contains("Type", 8)){
            setDEBoatType(EndBoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_ID_TYPE, Type.END.ordinal());
    }

    @Override
    public Item getDropItem() {
        switch (getDEBoatType()){
            case END:
                return DEItems.END_BOAT.get();
            default:
                return Items.OAK_BOAT;
        }
    }

    public void setDEBoatType(EndBoatEntity.Type type){
        entityData.set(DATA_ID_TYPE, type.ordinal());
    }

    public EndBoatEntity.Type getDEBoatType(){
        return EndBoatEntity.Type.byId(entityData.get(DATA_ID_TYPE));
    }

    public enum Type {
        END("end");

        private final String name;
        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public static EndBoatEntity.Type byId(int id) {
            EndBoatEntity.Type[] types = values();
            if (id < 0 || id >= types.length) {
                id = 0;
            }

            return types[id];
        }

        public static EndBoatEntity.Type byName(String nameIn) {
            EndBoatEntity.Type[] types = values();

            for (int i = 0; i < types.length; ++i) {
                if (types[i].getName().equals(nameIn)) {
                    return types[i];
                }
            }

            return types[0];
        }
    }
}
