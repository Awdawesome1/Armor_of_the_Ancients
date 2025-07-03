package com.Awdawesome.tutorialMod.item;

import com.Awdawesome.tutorialMod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> RUNE_OF_POWER = ITEMS.register("rune_of_power",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ANCIENT_ALLOY = ITEMS.register("ancient_alloy",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
    }



}
