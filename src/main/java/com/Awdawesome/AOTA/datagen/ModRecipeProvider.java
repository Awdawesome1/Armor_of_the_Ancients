package com.Awdawesome.AOTA.datagen;

import com.Awdawesome.AOTA.Ancient_Armor;
import com.Awdawesome.AOTA.block.ModBlocks;
import com.Awdawesome.AOTA.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {


    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCK_OF_ANCIENT_ALLOY.get())
                .pattern("aaa")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', ModItems.ANCIENT_ALLOY.get())
                .unlockedBy(getHasName(ModItems.ANCIENT_ALLOY.get()), has(ModItems.ANCIENT_ALLOY.get())).save(pRecipeOutput);


        //divine gem
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIVINE_GEM.get())
                .pattern(" c ")
                .pattern("cec")
                .pattern(" c ")
                .define('c', ModItems.ALLOY_OF_THE_CHAMPION.get())
                .define('e', Items.EMERALD)
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(pRecipeOutput);


        //champions sword
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHAMPIONS_SWORD.get())
                .pattern("ici")
                .pattern("idi")
                .pattern("glg")
                .define('c', ModItems.ALLOY_OF_THE_CHAMPION.get())
                .define('i', Items.IRON_INGOT)
                .define('g', Items.GOLD_INGOT)
                .define('l', ModItems.LEATHER_BOUND_HANDLE.get())
                .define('d', ModItems.DIVINE_GEM.get())
                .unlockedBy(getHasName(ModItems.DIVINE_GEM.get()), has(ModItems.DIVINE_GEM.get()))
                .save(pRecipeOutput);

        //demon heart
        ItemStack healingPotion = new ItemStack(Items.POTION);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DEMON_HEART.get())
                .pattern(" f ")
                .pattern("bae")
                .pattern(" g ")
                .define('f', Items.ROTTEN_FLESH)
                .define('a', ModItems.ALLOY_OF_THE_BERSERKER.get())
                .define('e', Items.ENCHANTED_GOLDEN_APPLE)
                .define('g', Items.GUNPOWDER)
                .define('b', Items.BONE)
                .unlockedBy(getHasName(Items.ENCHANTED_GOLDEN_APPLE), has(Items.ENCHANTED_GOLDEN_APPLE))
                .save(pRecipeOutput);


        //leather handle
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LEATHER_BOUND_HANDLE.get(), 1)
                .requires(Items.LEATHER, 2)
                .requires(Items.STICK)
                .unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER))
                .save(pRecipeOutput);

        //ancient alloy from block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ANCIENT_ALLOY.get(), 9).requires(ModBlocks.BLOCK_OF_ANCIENT_ALLOY.get())
                .unlockedBy(getHasName(ModItems.ANCIENT_ALLOY.get()), has(ModItems.ANCIENT_ALLOY.get())).save(pRecipeOutput, Ancient_Armor.MOD_ID + ":ancient_ally_from_block");
    }
}
