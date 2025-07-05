package com.Awdawesome.entity.client;

import com.Awdawesome.entity.custom.TempestsWrathEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class TempestRenderer extends EntityRenderer<TempestsWrathEntity> {


    protected TempestRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public void render(
            TempestsWrathEntity entity, float entityYaw, float partialTicks,
            PoseStack poseStack, MultiBufferSource buffer, int packedLight
    ) {
        // Renders nothing (invisible effect)
    }

    @Override
    public ResourceLocation getTextureLocation(TempestsWrathEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("minecraft", "textures/misc/empty.png");
    }

}
