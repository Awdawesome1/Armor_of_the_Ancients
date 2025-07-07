package com.Awdawesome.AOTA.enchantment;

import com.Awdawesome.AOTA.Ancient_Armor;
import com.Awdawesome.AOTA.enchantment.custom.DivineSmiteEnchantmentEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantmentEffects {

    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Ancient_Armor.MOD_ID);

    public static final RegistryObject<MapCodec<? extends EnchantmentEntityEffect>> DIVINE_SMITE =
            ENTITY_ENCHANTMENT_EFFECTS.register("divine_smite", () -> DivineSmiteEnchantmentEffect.CODEC);

    public static void register(IEventBus eventBus) {
        ENTITY_ENCHANTMENT_EFFECTS.register(eventBus);
    }

}
