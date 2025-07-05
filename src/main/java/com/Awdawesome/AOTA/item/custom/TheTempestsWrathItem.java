package com.Awdawesome.AOTA.item.custom;

import com.Awdawesome.entity.custom.TempestsWrathEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.client.event.sound.SoundEvent;


public class TheTempestsWrathItem extends Item {
    public TheTempestsWrathItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            Vec3 origin = player.position().add(0, player.getEyeHeight(), 0);
            Vec3 look = player.getLookAngle();

            TempestsWrathEntity blast = new TempestsWrathEntity(level, origin, look, player);
            level.addFreshEntity(blast);
            player.getItemInHand(hand).hurtAndBreak(1, player, hand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
            level.playSound(
                    null, // null = heard by all nearby players
                    player.blockPosition(),
                    SoundEvents.WIND_CHARGE_BURST.get(), // generic item break sound
                    SoundSource.PLAYERS,
                    1.0f, // volume
                    1.0f  // pitch
            );
            level.playSound(
                    null, // null = heard by all nearby players
                    player.blockPosition(),
                    SoundEvents.ENDER_DRAGON_HURT, // generic item break sound
                    SoundSource.PLAYERS,
                    1.0f, // volume
                    .1f  // pitch
            );
            level.playSound(
                    null, // null = heard by all nearby players
                    player.blockPosition(),
                    SoundEvents.BLAZE_SHOOT, // generic item break sound
                    SoundSource.PLAYERS,
                    1.0f, // volume
                    .25f  // pitch
            );
        }

        player.getCooldowns().addCooldown(this, 20); // 1s cooldown
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

}
