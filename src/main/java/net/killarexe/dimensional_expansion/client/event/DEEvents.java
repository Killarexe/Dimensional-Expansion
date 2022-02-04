package net.killarexe.dimensional_expansion.client.event;

import net.killarexe.dimensional_expansion.DEMod;
import net.killarexe.dimensional_expansion.common.gui.screen.DETitleScreen;
import net.killarexe.dimensional_expansion.core.config.DEConfig;
import net.killarexe.dimensional_expansion.core.init.DEBlocks;
import net.killarexe.dimensional_expansion.core.init.DEFeatures;
import net.killarexe.dimensional_expansion.core.init.DEItems;
import net.killarexe.dimensional_expansion.core.init.DEVillagerTypes;
import net.killarexe.dimensional_expansion.core.world.structure.*;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.LoadingOverlay;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.client.loading.ClientModLoader;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;

public class DEEvents {

    private static final RuleTest NATURAL_NETHERRACK = new BlockMatchTest(Blocks.NETHERRACK);
    private static final RuleTest NATURAL_STONE = new BlockMatchTest(Blocks.STONE);
    private static final RuleTest NATURAL_END_STONE = new BlockMatchTest(Blocks.END_STONE);
    private static final RuleTest NATURAL_DEEPSLATE = new BlockMatchTest(Blocks.DEEPSLATE);

    @SubscribeEvent
    public static void addFeatures(final BiomeLoadingEvent e){
        addOres(e);
        addTrees(e);
        addStructures(e);
    }

    @SubscribeEvent
    public static void addNewTrade(VillagerTradesEvent e) {
        DEMod.LOGGER.info("Init Dimensional Expansion Villager Trades");
        List<VillagerTrades.ItemListing> tradesLevel5 = e.getTrades().get(5);
        List<VillagerTrades.ItemListing> tradesLevel4 = e.getTrades().get(4);
        List<VillagerTrades.ItemListing> tradesLevel3 = e.getTrades().get(3);
        List<VillagerTrades.ItemListing> tradesLevel2 = e.getTrades().get(2);
        List<VillagerTrades.ItemListing> tradesLevel1 = e.getTrades().get(1);
        if(e.getType() == DEVillagerTypes.FORGER.get()){
            addTrade(tradesLevel1, Items.DIAMOND, 1, Items.EMERALD, 32, Items.NETHERITE_INGOT, 1, 1, 10, 1);
            addTrade(tradesLevel1, Items.DIAMOND_SWORD, 1, Items.EMERALD, 32, Items.NETHERITE_SWORD, 1, 1, 10, 1);
            addTrade(tradesLevel1, Items.DIAMOND_PICKAXE, 1, Items.EMERALD, 32, Items.NETHERITE_PICKAXE, 1, 1, 10, 1);
            addTrade(tradesLevel1, Items.DIAMOND_AXE, 1, Items.EMERALD, 32, Items.NETHERITE_AXE, 1, 1, 10, 1);
            addTrade(tradesLevel1, Items.DIAMOND_SHOVEL, 1, Items.EMERALD, 32, Items.NETHERITE_SHOVEL, 1, 1, 10, 1);
            addTrade(tradesLevel1, Items.DIAMOND_HOE, 1, Items.EMERALD, 32, Items.NETHERITE_HOE, 1, 1, 10, 1);
            addTrade(tradesLevel1, Items.DIAMOND_HELMET, 1, Items.EMERALD, 32, Items.NETHERITE_HELMET, 1, 1, 10, 1);
            addTrade(tradesLevel1, Items.DIAMOND_CHESTPLATE, 1, Items.EMERALD, 32, Items.NETHERITE_CHESTPLATE, 1, 1, 10, 1);
            addTrade(tradesLevel1, Items.DIAMOND_LEGGINGS, 1, Items.EMERALD, 32, Items.NETHERITE_LEGGINGS, 1, 1, 10, 1);
            addTrade(tradesLevel1, Items.DIAMOND_BOOTS, 1, Items.EMERALD, 32, Items.NETHERITE_BOOTS, 1, 1, 10, 1);

            addTrade(tradesLevel2, Items.NETHERITE_INGOT, 1, Items.EMERALD, 40, DEItems.PALON_INGOT.get(), 1, 1, 12, 1);
            addTrade(tradesLevel2, Items.NETHERITE_SWORD, 1, Items.EMERALD, 40, DEItems.PALON_SWORD.get(), 1, 1, 12, 1);
            addTrade(tradesLevel2, Items.NETHERITE_PICKAXE, 1, Items.EMERALD, 40, DEItems.PALON_PICKAXE.get(), 1, 1, 12, 1);
            addTrade(tradesLevel2, Items.NETHERITE_AXE, 1, Items.EMERALD, 40, DEItems.PALON_AXE.get(), 1, 1, 12, 1);
            addTrade(tradesLevel2, Items.NETHERITE_SHOVEL, 1, Items.EMERALD, 40, DEItems.PALON_SHOVEL.get(), 1, 1, 12, 1);
            addTrade(tradesLevel2, Items.NETHERITE_HOE, 1, Items.EMERALD, 40, DEItems.PALON_HOE.get(), 1, 1, 12, 1);
            addTrade(tradesLevel2, Items.NETHERITE_HELMET, 1, Items.EMERALD, 40, DEItems.PALON_HELMET.get(), 1, 1, 12, 1);
            addTrade(tradesLevel2, Items.NETHERITE_CHESTPLATE, 1, Items.EMERALD, 40, DEItems.PALON_CHESTPLATE.get(), 1, 1, 12, 1);
            addTrade(tradesLevel2, Items.NETHERITE_LEGGINGS, 1, Items.EMERALD, 40, DEItems.PALON_LEGGINGS.get(), 1, 1, 12, 1);
            addTrade(tradesLevel2, Items.NETHERITE_BOOTS, 1, Items.EMERALD, 40, DEItems.PALON_BOOTS.get(), 1, 1, 12, 1);

            addTrade(tradesLevel3, DEItems.PALON_INGOT.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_GEM.get(), 1, 1, 18, 1);
            addTrade(tradesLevel3, DEItems.PALON_SWORD.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_SWORD.get(), 1, 1, 18, 1);
            addTrade(tradesLevel3, DEItems.PALON_PICKAXE.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_PICKAXE.get(), 1, 1, 18, 1);
            addTrade(tradesLevel3, DEItems.PALON_AXE.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_AXE.get(), 1, 1, 10, 1);
            addTrade(tradesLevel3, DEItems.PALON_SHOVEL.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_SHOVEL.get(), 1, 1, 18, 1);
            addTrade(tradesLevel3, DEItems.PALON_HOE.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_HOE.get(), 1, 1, 10, 1);
            addTrade(tradesLevel3, DEItems.PALON_HELMET.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_HELMET.get(), 1, 1, 18, 1);
            addTrade(tradesLevel3, DEItems.PALON_CHESTPLATE.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_CHESTPLATE.get(), 1, 1, 18, 1);
            addTrade(tradesLevel3, DEItems.PALON_LEGGINGS.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_LEGGINGS.get(), 1, 1, 18, 1);
            addTrade(tradesLevel3, DEItems.PALON_BOOTS.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_BOOTS.get(), 1, 1, 18, 1);

            addTrade(tradesLevel4, DEItems.BASSMITE_GEM.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_INGOT.get(), 1, 1, 22, 1);
            addTrade(tradesLevel4, DEItems.BASSMITE_SWORD.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_SWORD.get(), 1, 1, 22, 1);
            addTrade(tradesLevel4, DEItems.BASSMITE_PICKAXE.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_PICKAXE.get(), 1, 1, 22, 1);
            addTrade(tradesLevel4, DEItems.BASSMITE_AXE.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_AXE.get(), 1, 1, 22, 1);
            addTrade(tradesLevel4, DEItems.BASSMITE_SHOVEL.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_SHOVEL.get(), 1, 1, 22, 1);
            addTrade(tradesLevel4, DEItems.BASSMITE_HOE.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_HOE.get(), 1, 1, 22, 1);
            addTrade(tradesLevel4, DEItems.BASSMITE_HELMET.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_HELMET.get(), 1, 1, 22, 1);
            addTrade(tradesLevel4, DEItems.BASSMITE_CHESTPLATE.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_CHESTPLATE.get(), 1, 1, 22, 1);
            addTrade(tradesLevel4, DEItems.BASSMITE_LEGGINGS.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_LEGGINGS.get(), 1, 1, 22, 1);
            addTrade(tradesLevel4, DEItems.BASSMITE_BOOTS.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_BOOTS.get(), 1, 1, 22, 1);

            addTrade(tradesLevel5, DEItems.SIMIX_INGOT.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_GEM.get(), 1, 1, 30, 1);
            addTrade(tradesLevel5, DEItems.SIMIX_SWORD.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_SWORD.get(), 1, 1, 30, 1);
            addTrade(tradesLevel5, DEItems.SIMIX_PICKAXE.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_PICKAXE.get(), 1, 1, 30, 1);
            addTrade(tradesLevel5, DEItems.SIMIX_AXE.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_AXE.get(), 1, 1, 30, 1);
            addTrade(tradesLevel5, DEItems.SIMIX_SHOVEL.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_SHOVEL.get(), 1, 1, 30, 1);
            addTrade(tradesLevel5, DEItems.SIMIX_HOE.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_HOE.get(), 1, 1, 30, 1);
            addTrade(tradesLevel5, DEItems.SIMIX_HELMET.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_HELMET.get(), 1, 1, 30, 1);
            addTrade(tradesLevel5, DEItems.SIMIX_CHESTPLATE.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_CHESTPLATE.get(), 1, 1, 30, 1);
            addTrade(tradesLevel5, DEItems.SIMIX_LEGGINGS.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_LEGGINGS.get(), 1, 1, 30, 1);
            addTrade(tradesLevel5, DEItems.SIMIX_BOOTS.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_BOOTS.get(), 1, 1, 30, 1);

        }else if(e.getType() == DEVillagerTypes.FARMER.get()){

            addTrade(tradesLevel1, Items.EMERALD, 3, DEItems.XP_SEEDS.get(), 1, 16, 10, 1);
            addTrade(tradesLevel1, Items.EMERALD, 3, DEItems.HEART_SEEDS.get(), 1, 16, 10, 1);

            addTrade(tradesLevel2, Items.EMERALD, 6, DEItems.XP_PLANTS.get(), 1, 16, 12, 1);
            addTrade(tradesLevel2, Items.EMERALD, 6, DEItems.HEART.get(), 1, 16, 12, 1);

            addTrade(tradesLevel3, Items.EMERALD, 12, DEItems.XP_SEEDS.get(), 1, DEItems.XP_ESSENCE.get(), 1, 18, 12, 1);
            addTrade(tradesLevel3, Items.EMERALD, 12, DEItems.HEART_SEEDS.get(), 1, DEItems.HEART_ESSENCE.get(), 1, 18, 12, 1);

        }else if(e.getType() == DEVillagerTypes.MINER.get()){

            addTrade(tradesLevel1, Items.EMERALD, 1, Items.COAL, 16, 8, 30, 1);
            addTrade(tradesLevel1, Items.EMERALD, 1, Items.CHARCOAL, 16, 8, 30, 1);
            addTrade(tradesLevel1, Items.EMERALD, 8, Items.DIAMOND, 1, 3, 30, 1);
            addTrade(tradesLevel2, Items.EMERALD, 4, DEItems.PALON_MIXED_COAL.get(), 1, 16, 30, 1);
            addTrade(tradesLevel2, Items.EMERALD, 4, DEItems.PALON_NUGGET.get(), 1, 16, 30, 1);
            addTrade(tradesLevel2, DEItems.PALON_PICKAXE.get(), 1, Items.EMERALD, 44, DEItems.BASSMITE_PICKAXE.get(), 1, 1, 18, 1);
            addTrade(tradesLevel3, Items.EMERALD, 8, DEItems.BASSMITE_MIXED_COAL.get(), 1, 8, 30, 1);
            addTrade(tradesLevel3, DEItems.BASSMITE_PICKAXE.get(), 1, Items.EMERALD, 52, DEItems.SIMIX_PICKAXE.get(), 1, 1, 22, 1);
            addTrade(tradesLevel4, Items.EMERALD, 16, DEItems.SIMIX_MIXED_COAL.get(), 1, 4, 30, 1);
            addTrade(tradesLevel4, Items.EMERALD, 8, DEItems.SIMIX_NUGGET.get(), 1, 16, 30, 1);
            addTrade(tradesLevel4, DEItems.SIMIX_PICKAXE.get(), 1, Items.EMERALD, 52, DEItems.EMERTYST_PICKAXE.get(), 1, 1, 30, 1);
            addTrade(tradesLevel5, Items.EMERALD, 4, Items.COMPASS, 1, 32, 30, 1);
            addTrade(tradesLevel5, Items.EMERALD, 32, DEItems.EMERTYST_MIXED_COAL.get(), 1, 2, 30, 1);
        }
    }

    @SubscribeEvent
    public static void onScreenPost(final ScreenEvent.InitScreenEvent.Post event) {
        if (event.getScreen() instanceof TitleScreen && DEConfig.moddedTitleScreen.get()) {
            event.getScreen().getMinecraft().setScreen(new DETitleScreen(true));
        }
    }

    private static void addTrees(final BiomeLoadingEvent e){
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, e.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if(types.contains(BiomeDictionary.Type.fromVanilla(Biome.BiomeCategory.THEEND))) {
            List<Supplier<PlacedFeature>> base =
                    e.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
            base.add(() -> DEFeatures.END_TREE_PLACED);
        }
    }

    private static void addStructures(final BiomeLoadingEvent e){
        e.getGeneration().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ForgerHouse.CONFIGURED_FEATURE.placed());
        e.getGeneration().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, FarmerHouse.CONFIGURED_FEATURE.placed());
        e.getGeneration().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, MinerHouse.CONFIGURED_FEATURE.placed());
    }

    private static void addOres(final BiomeLoadingEvent e){
        addOre(e, NATURAL_END_STONE, DEBlocks.PALON_ORE.get().defaultBlockState(), 8, 54, 75, 1);
        addOre(e, NATURAL_STONE, DEBlocks.BASSMITE_ORE.get().defaultBlockState(), 8, 0, 12, 1);
        addOre(e, NATURAL_NETHERRACK, DEBlocks.SIMIX_ORE.get().defaultBlockState(), 8, 0, 14, 1);
        addOre(e, NATURAL_DEEPSLATE, DEBlocks.EMERTYST_ORE.get().defaultBlockState(), 8, 16, 0, 1);
    }

    private static void addOre(final BiomeLoadingEvent e, RuleTest rule, BlockState state, int veinsize, int minHeight, int maxHeight, int amount){
        e.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreConfiguration(rule, state, veinsize))
                        .placed(rareOrePlacement(amount, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)))));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    private static void addTrade(List<VillagerTrades.ItemListing> trades, Item tradeItem1, int number1, Item tradeItem2, int number2, Item receveItem, int number, int maxTrades, int xp, int priceMult){
        trades.add(new CustomTrade(new ItemStack(tradeItem1, number1), new ItemStack(tradeItem2, number2), new ItemStack(receveItem, number), maxTrades, xp, priceMult));
    }

    private static void addTrade(List<VillagerTrades.ItemListing> trades, Item tradeItem1, int number1, Item receveItem, int number, int maxTrades, int xp, int priceMult) {
        trades.add(new CustomTrade(new ItemStack(tradeItem1, number1), new ItemStack(receveItem, number), maxTrades, xp, priceMult));
    }

    public static class CustomTrade implements VillagerTrades.ItemListing {
        private ItemStack tradeItem1, tradeItem2, reciveItem;
        private final int maxUses;
        private final int villagerXp;
        private final float priceMultiplier;

        public CustomTrade(ItemStack tradeItem1, ItemStack tradeItem2, ItemStack reciveItem, int maxTrades, int xp, int priceMult) {
            this.tradeItem1 = tradeItem1;
            this.tradeItem2 = tradeItem2;
            this.reciveItem = reciveItem;
            this.maxUses = maxTrades;
            this.villagerXp = xp;
            this.priceMultiplier = priceMult;
        }

        public CustomTrade(ItemStack tradeItem1, ItemStack reciveItem, int maxTrades, int xp, int priceMult) {
            this.tradeItem1 = tradeItem1;
            this.reciveItem = reciveItem;
            this.maxUses = maxTrades;
            this.villagerXp = xp;
            this.priceMultiplier = priceMult;
        }

        public MerchantOffer getOffer(Entity p_35771_, Random p_35772_) {
            if(tradeItem2 == null){
                return new MerchantOffer(tradeItem1, reciveItem, this.maxUses, this.villagerXp, this.priceMultiplier);
            }
            return new MerchantOffer(tradeItem1, tradeItem2, reciveItem, this.maxUses, this.villagerXp, this.priceMultiplier);
        }
    }
}