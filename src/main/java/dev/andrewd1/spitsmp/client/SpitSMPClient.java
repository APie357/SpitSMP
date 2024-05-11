package dev.andrewd1.spitsmp.client;

import dev.andrewd1.spitsmp.client.entity.renderers.SpitProjectileEntityRenderer;
import dev.andrewd1.spitsmp.entity.ModEntities;
import dev.andrewd1.spitsmp.network.ModPackets;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;


public class SpitSMPClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModPackets.registerS2CPackets();

        ModClientEvents.register();

        EntityRendererRegistry.register(ModEntities.SPIT_PROJECTILE, SpitProjectileEntityRenderer::new);
    }
}
