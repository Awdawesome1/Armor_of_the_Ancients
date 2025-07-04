package com.Awdawesome.AOTA.block;

import com.Awdawesome.AOTA.Ancient_Armor;
import com.Awdawesome.AOTA.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Ancient_Armor.MOD_ID);


    public static final RegistryObject<Block> BLOCK_OF_ANCIENT_ALLOY = registerBlock("block_of_ancient_alloy", () -> new Block(BlockBehaviour.Properties.of()
            .strength(10f, 18000000).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)), new Item.Properties().fireResistant());

    public static final RegistryObject<Block> THE_FALLENS_DEBRIS = registerBlock("debris_otf", () -> new Block(BlockBehaviour.Properties.of()
            .strength(7f, 18000000).requiresCorrectToolForDrops().sound(SoundType.ANCIENT_DEBRIS)), new Item.Properties().fireResistant().stacksTo(8));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Item.Properties properties) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, properties);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, Item.Properties properties) {

        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }

    public static List<Item> getAllBlockItems() {
        List<Item> items = new ArrayList<>();
        for (Field field : ModBlocks.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) &&
                    Modifier.isFinal(field.getModifiers()) &&
                    RegistryObject.class.isAssignableFrom(field.getType())) {
                try {
                    RegistryObject<?> regObj = (RegistryObject<?>) field.get(null);
                    Object obj = regObj.get();

                    // Convert block to item, safely
                    if (obj instanceof Block block) {
                        Item item = ForgeRegistries.BLOCKS.getKey(block) != null
                                ? ForgeRegistries.BLOCKS.getValue(ForgeRegistries.BLOCKS.getKey(block)).asItem()
                                : null;
                        if (item != null && item != Items.AIR) {
                            items.add(item);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace(); // Handle safely/log errors
                }
            }
        }
        return items;
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
