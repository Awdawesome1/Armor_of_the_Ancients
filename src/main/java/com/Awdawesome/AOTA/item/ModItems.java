package com.Awdawesome.AOTA.item;

import com.Awdawesome.AOTA.Ancient_Armor;
import com.Awdawesome.AOTA.item.custom.Champions_Sword;
import com.Awdawesome.AOTA.item.custom.TheTempestsWrathItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, Ancient_Armor.MOD_ID);

    //raw materials
    public static final RegistryObject<Item> SCRAP_OTF = ITEMS.register("scrap_otf",
            () -> new Item(new Item.Properties()));

    //base materials
    public static final RegistryObject<Item> RUNE_OF_POWER = ITEMS.register("rune_of_power",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ANCIENT_ALLOY = ITEMS.register("ancient_alloy",
            () -> new Item(new Item.Properties().fireResistant()));

    //binding agents
    public static final RegistryObject<Item> PRECIOUS_BLEND = ITEMS.register("precious_blend",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_PLATING = ITEMS.register("diamond_plating",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_REINFORCEMENT = ITEMS.register("netherite_reinforcement",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ETERNAL_FLAME_BUCKET = ITEMS.register("eternal_flame_bucket",
            () -> new Item(new Item.Properties()));



    //alloys
    public static final RegistryObject<Item> ALLOY_OF_THE_JUGGERNAUT = ITEMS.register("juggernaut_alloy",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> ALLOY_OF_THE_CHAMPION = ITEMS.register("champion_alloy",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> ALLOY_OF_THE_ARTIFEX = ITEMS.register("artifex_alloy",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> ALLOY_OF_THE_BERSERKER = ITEMS.register("berserker_alloy",
            () -> new Item(new Item.Properties().fireResistant()));

    //items
    public static final RegistryObject<Item> THE_TEMPESTS_WRATH = ITEMS.register("tempests_wrath",
            () -> new TheTempestsWrathItem(new Item.Properties().durability(64)));

    public static final RegistryObject<Item> CHAMPIONS_SWORD = ITEMS.register("champions_sword", () ->
            new Champions_Sword(ModToolTiers.CHAMPION, new Item.Properties().stacksTo(1)
                    .fireResistant()
                    .attributes(SwordItem.createAttributes(ModToolTiers.CHAMPION, 3, -2f))));



    public static List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        for (Field field : ModItems.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) &&
                    Modifier.isFinal(field.getModifiers()) &&
                    field.getType().equals(RegistryObject.class)) {
                try {
                    RegistryObject<?> regObj = (RegistryObject<?>) field.get(null);
                    Object obj = regObj.get();
                    if (obj instanceof Item item) {
                        items.add(item);
                    }
                } catch (Exception e) {
                    e.printStackTrace(); // Handle gracefully
                }
            }
        }
        return items;
    }


    public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
    }



}
