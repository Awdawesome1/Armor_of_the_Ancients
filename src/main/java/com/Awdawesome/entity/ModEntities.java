package com.Awdawesome.entity;

import com.Awdawesome.AOTA.Ancient_Armor;
import com.Awdawesome.entity.custom.TempestsWrathEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Ancient_Armor.MOD_ID);

    public static final RegistryObject<EntityType<TempestsWrathEntity>> TEMPESTS_BLAST = ENTITY_TYPES.register(
            "wind_blast",
            () -> EntityType.Builder.<TempestsWrathEntity>of(TempestsWrathEntity::new, MobCategory.MISC)
                    .sized(0.1F, 0.1F)
                    .clientTrackingRange(32)
                    .updateInterval(1)
                    .build("wind_blast")
    );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
