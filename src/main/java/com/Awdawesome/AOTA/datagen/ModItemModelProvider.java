package com.Awdawesome.AOTA.datagen;

import com.Awdawesome.AOTA.Ancient_Armor;
import com.Awdawesome.AOTA.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Ancient_Armor.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ALLOY_OF_THE_ARTIFEX.get());
        basicItem(ModItems.ALLOY_OF_THE_BERSERKER.get());
        basicItem(ModItems.ALLOY_OF_THE_CHAMPION.get());
        basicItem(ModItems.ALLOY_OF_THE_JUGGERNAUT.get());
        basicItem(ModItems.ANCIENT_ALLOY.get());
        basicItem(ModItems.DIAMOND_PLATING.get());
        basicItem(ModItems.ETERNAL_FLAME_BUCKET.get());
        basicItem(ModItems.NETHERITE_REINFORCEMENT.get());
        basicItem(ModItems.PRECIOUS_BLEND.get());
        basicItem(ModItems.RUNE_OF_POWER.get());
        basicItem(ModItems.SCRAP_OTF.get());
        basicItem(ModItems.THE_TEMPESTS_WRATH.get());
        basicItem(ModItems.DIVINE_GEM.get());
        basicItem(ModItems.LEATHER_BOUND_HANDLE.get());
        basicItem(ModItems.DEMON_HEART.get());
    }


}
