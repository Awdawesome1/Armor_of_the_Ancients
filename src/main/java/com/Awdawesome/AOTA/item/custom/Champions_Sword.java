package com.Awdawesome.AOTA.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class Champions_Sword extends SwordItem {
    public Champions_Sword(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }
}
