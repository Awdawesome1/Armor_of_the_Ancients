package com.Awdawesome.AOTA.datagen;

import com.Awdawesome.AOTA.Ancient_Armor;
import com.Awdawesome.AOTA.block.ModBlocks;
import com.Awdawesome.AOTA.util.ModTags;
import com.jcraft.jorbis.Block;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ancient_Armor.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLOCK_OF_ANCIENT_ALLOY.get())
                .add(ModBlocks.THE_FALLENS_DEBRIS.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.THE_FALLENS_DEBRIS.get())
                .add(ModBlocks.BLOCK_OF_ANCIENT_ALLOY.get());

        tag(ModTags.Blocks.NEEDS_ANCIENT_ALLOY_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_ANCIENT_ALLOY_TOOL)
                .remove(ModTags.Blocks.NEEDS_ANCIENT_ALLOY_TOOL);
    }
}
