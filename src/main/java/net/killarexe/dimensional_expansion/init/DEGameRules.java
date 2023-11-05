package net.killarexe.dimensional_expansion.init;

import net.killarexe.dimensional_expansion.DEMod;
import net.minecraft.world.level.GameRules;

public class DEGameRules {
	public static final GameRules.Key<GameRules.IntegerValue> POWER_STONES_DELAY = GameRules.register("power_stones_delay", GameRules.Category.MISC, GameRules.IntegerValue.create(120));
	public static final GameRules.Key<GameRules.BooleanValue> ENABLE_POWER_STONES = GameRules.register("enable_power_stones", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	
	public static void register() {
		DEMod.LOGGER.info("Init Dimensional Expansion GameRules...");
		//Just to init constants...
	}
}
