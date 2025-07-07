package com.Awdawesome.AOTA.item;

import com.Awdawesome.AOTA.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;



public class ModToolTiers {

    public static final Tier JUGGERNAUT = new ForgeTier(8096, 7, 8, 15, ModTags.Blocks.NEEDS_ANCIENT_ALLOY_TOOL,
            () -> Ingredient.of(ModItems.ALLOY_OF_THE_JUGGERNAUT.get()), ModTags.Blocks.INCORRECT_FOR_ANCIENT_ALLOY_TOOL);
    public static final Tier CHAMPION = new ForgeTier(4096, 15, 10, 20, ModTags.Blocks.NEEDS_ANCIENT_ALLOY_TOOL,
            () -> Ingredient.of(ModItems.ALLOY_OF_THE_CHAMPION.get()), ModTags.Blocks.INCORRECT_FOR_ANCIENT_ALLOY_TOOL);
    public static final Tier ARTIFEX = new ForgeTier(6144, 17, 6, 25, ModTags.Blocks.NEEDS_ANCIENT_ALLOY_TOOL,
            () -> Ingredient.of(ModItems.ALLOY_OF_THE_JUGGERNAUT.get()), ModTags.Blocks.INCORRECT_FOR_ANCIENT_ALLOY_TOOL);
    public static final Tier BERSERKER = new ForgeTier(2730, 8, 15, 10, ModTags.Blocks.NEEDS_ANCIENT_ALLOY_TOOL,
            () -> Ingredient.of(ModItems.ALLOY_OF_THE_JUGGERNAUT.get()), ModTags.Blocks.INCORRECT_FOR_ANCIENT_ALLOY_TOOL);


}
