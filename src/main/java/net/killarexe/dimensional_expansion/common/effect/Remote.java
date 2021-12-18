package net.killarexe.dimensional_expansion.common.effect;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.EffectRenderer;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class Remote extends MobEffect {

    private int prevPosX, prevPosY, prevPosZ;

    public Remote() {
        super(MobEffectCategory.NEUTRAL, -16738048);
    }

    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap p_19479_, int p_19480_) {
        prevPosX = entity.getBlockX();
        prevPosY = entity.getBlockY();
        prevPosZ = entity.getBlockZ();
        DEMod.LOGGER.info("Set Pos!");
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap p_19470_, int p_19471_) {
        DEMod.LOGGER.info("Apply Pos!");
        entity.setPos(new Vec3(prevPosX, prevPosY, prevPosZ));
        prevPosX = entity.getBlockX();
        prevPosY = entity.getBlockY();
        prevPosZ = entity.getBlockZ();
    }
}
