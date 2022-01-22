package net.killarexe.dimensional_expansion.common.item;

import net.killarexe.dimensional_expansion.core.init.DEItemGroups;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class XpPlants extends Item {
    public XpPlants() {
        super(new Item.Properties().tab(DEItemGroups.MISC).food(new FoodProperties.Builder().nutrition(2).saturationMod(2).alwaysEat().build()));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if(livingEntity instanceof Player){
            Player player = (Player)livingEntity;
            player.giveExperiencePoints(player.experienceLevel * 20 - player.experienceLevel / 2);
        }
        return super.finishUsingItem(itemStack, level, livingEntity);
    }
}
