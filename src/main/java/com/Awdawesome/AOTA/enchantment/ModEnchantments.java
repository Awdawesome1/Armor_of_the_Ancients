package com.Awdawesome.AOTA.enchantment;

import com.Awdawesome.AOTA.Ancient_Armor;
import com.Awdawesome.AOTA.enchantment.custom.DivineSmiteEnchantmentEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;

public class ModEnchantments {

    public static final ResourceKey<Enchantment> DIVINE_SMITE =
            ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Ancient_Armor.MOD_ID, "divine_smite"));

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        register(context, DIVINE_SMITE, Enchantment.enchantment(Enchantment.definition(
            items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
            items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
            5,
            3,
            Enchantment.dynamicCost(5, 8),
            Enchantment.dynamicCost(25, 8),
            10,
            EquipmentSlotGroup.MAINHAND))
            .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.SMELTS_LOOT))
            .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.CURSE))
            .withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER,
                        EnchantmentTarget.VICTIM, new DivineSmiteEnchantmentEffect()));
    }

    private static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.location()));
    }
}
