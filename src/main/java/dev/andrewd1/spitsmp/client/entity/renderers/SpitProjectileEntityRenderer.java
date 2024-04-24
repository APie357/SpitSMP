package dev.andrewd1.spitsmp.client.entity.renderers;

import dev.andrewd1.spitsmp.entity.entities.SpitProjectileEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.LlamaSpitEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class SpitProjectileEntityRenderer extends EntityRenderer<SpitProjectileEntity> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/llama/spit.png");
    private final LlamaSpitEntityModel<SpitProjectileEntity> model;

    public SpitProjectileEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new LlamaSpitEntityModel<>(ctx.getPart(EntityModelLayers.LLAMA_SPIT));
    }

    @Override
    public void render(SpitProjectileEntity entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.translate(0.0f, 0.15f, 0.0f);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(g, entity.prevYaw, entity.getYaw()) - 90.0f));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(g, entity.prevPitch, entity.getPitch())));
        this.model.setAngles(entity, g, 0.0f, -0.1f, 0.0f, 0.0f);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(TEXTURE));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        matrixStack.pop();
        super.render(entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(SpitProjectileEntity entity) {
        return TEXTURE;
    }
}
