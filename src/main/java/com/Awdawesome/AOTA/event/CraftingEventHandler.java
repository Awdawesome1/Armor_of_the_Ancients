package com.Awdawesome.AOTA.event;

import com.Awdawesome.AOTA.Ancient_Armor;
import com.Awdawesome.AOTA.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ancient_Armor.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CraftingEventHandler {

    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        // Example: If the result is our custom item
        if (event.getCrafting().getItem() == ModItems.NETHERITE_REINFORCEMENT.get()) {
            if (!event.getEntity().level().isClientSide) {
                event.getEntity().level().playSound(
                        null, // null = heard by all nearby players
                        event.getEntity().blockPosition(),
                        SoundEvents.ITEM_BREAK, // generic item break sound
                        SoundSource.PLAYERS,
                        1.0f, // volume
                        1.0f  // pitch
                );
            }
        }
    }
}