package com.Awdawesome.AOTA.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record DivineSmiteEnchantmentEffect() implements EnchantmentEntityEffect {

    public static final MapCodec<DivineSmiteEnchantmentEffect> CODEC = MapCodec.unit(DivineSmiteEnchantmentEffect::new);



    @Override
    public void apply(ServerLevel serverLevel, int pEnchantmentLevel, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3) {
        if(pEnchantmentLevel >= 1) {
            for(int i=0;i<pEnchantmentLevel;i++)
                EntityType.LIGHTNING_BOLT.spawn(serverLevel, entity.getOnPos(), MobSpawnType.TRIGGERED);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
