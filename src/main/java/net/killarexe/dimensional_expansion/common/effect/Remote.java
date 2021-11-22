package net.killarexe.dimensional_expansion.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class Remote extends MobEffect {

    private double prevPosX;
    private double prevPosY;
    private double prevPosZ;

    public Remote() {
        super(MobEffectCategory.NEUTRAL, -16738048);
    }

    @Override
    public void addAttributeModifiers(LivingEntity p_19478_, AttributeMap p_19479_, int p_19480_) {
        prevPosX = p_19478_.getX();
        prevPosY = p_19478_.getY();
        prevPosZ = p_19478_.getZ();
    }

    @Override
    public void removeAttributeModifiers(LivingEntity p_19469_, AttributeMap p_19470_, int p_19471_) {
        p_19469_.setPos(prevPosX, prevPosY, prevPosZ);
        prevPosX = Double.parseDouble(null);
        prevPosY = Double.parseDouble(null);
        prevPosZ = Double.parseDouble(null);
    }
}
