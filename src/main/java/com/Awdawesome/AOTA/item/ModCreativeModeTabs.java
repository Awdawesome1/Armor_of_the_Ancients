package com.Awdawesome.AOTA.item;

import com.Awdawesome.AOTA.Ancient_Armor;
import com.Awdawesome.AOTA.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ancient_Armor.MOD_ID);

    public static final RegistryObject<CreativeModeTab> AOTA_ITEMS_TAB = CREATIVE_MODE_TABS.register("aota_items_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.RUNE_OF_POWER.get()))
            .title(Component.translatable("creativetab.ancient_armor.aota_items_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                ModItems.getAllItems().forEach(output::accept);
            }).build());

    public static final RegistryObject<CreativeModeTab> AOTA_BLOCKS_TAB = CREATIVE_MODE_TABS.register("aota_blocks_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.BLOCK_OF_ANCIENT_ALLOY.get()))
            .withTabsBefore(AOTA_ITEMS_TAB.getId())
            .title(Component.translatable("creativetab.ancient_armor.aota_blocks_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                ModBlocks.getAllBlockItems().forEach(output::accept);
            }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
