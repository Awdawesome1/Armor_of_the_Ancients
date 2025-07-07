package com.Awdawesome.AOTA.util;

import com.Awdawesome.AOTA.Ancient_Armor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {



    public static class Blocks {
        public static final TagKey<Block> NEEDS_ANCIENT_ALLOY_TOOL = createTag("needs_ancient_alloy_tool");
        public static final TagKey<Block> INCORRECT_FOR_ANCIENT_ALLOY_TOOL = createTag("incorrect_for_ancient_alloy_tool");


        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Ancient_Armor.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Ancient_Armor.MOD_ID, name));
        }
    }

}
