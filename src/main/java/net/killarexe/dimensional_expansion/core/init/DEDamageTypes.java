package net.killarexe.dimensional_expansion.core.init;

import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;

public class DEDamageTypes {
	public static final DamageType BLUE_BERRY_BUSH = new DamageType("blueBerryBush", 0.1f);
	
	public static DamageSource fromType(DamageType type) {
		return new DamageSource(Holder.direct(type));
	}
}
