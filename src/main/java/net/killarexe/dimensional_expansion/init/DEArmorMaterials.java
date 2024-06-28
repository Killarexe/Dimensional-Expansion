package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public class DEArmorMaterials {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIAL = DeferredRegister.create(Registries.ARMOR_MATERIAL, DEMod.MOD_ID);

    public static final Holder<ArmorMaterial> BASSMITE = register(
            "bassmite",
            4, 7, 9 ,4, 12,
            25, SoundEvents.ARMOR_EQUIP_NETHERITE, DEItems.BASSMITE_GEM.get(),
            4.5F, 0.15F
    );

    public static final Holder<ArmorMaterial> EMERTYST = register(
            "emertyst",
            5, 8, 10 ,5, 13,
            30, SoundEvents.ARMOR_EQUIP_NETHERITE, DEItems.EMERTYST_GEM.get(),
            6.0F, 0.2F
    );

    private static Holder<ArmorMaterial> register(
            String id,
            int bootDefense, int leggingsDefense, int chestplateDefense, int helmetDefense, int bodyDefense,
            int enchantementValue, Holder<SoundEvent> equipSound, ItemLike repearItem,
            float thougness, float knockbackResistance
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(DEMod.res(id)));
        ArmorMaterial material = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, bootDefense);
            map.put(ArmorItem.Type.LEGGINGS, leggingsDefense);
            map.put(ArmorItem.Type.CHESTPLATE, chestplateDefense);
            map.put(ArmorItem.Type.HELMET, helmetDefense);
            map.put(ArmorItem.Type.BODY, bodyDefense);
        }), enchantementValue, equipSound, () -> Ingredient.of(repearItem), list, thougness, knockbackResistance);
        return ARMOR_MATERIAL.register(id, () -> material);
    }
}
