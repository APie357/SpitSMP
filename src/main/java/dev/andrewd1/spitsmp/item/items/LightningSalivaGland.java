package dev.andrewd1.spitsmp.item.items;

import dev.andrewd1.spitsmp.item.SalivaGlandItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class LightningSalivaGland extends SalivaGlandItem {
    public LightningSalivaGland(Settings settings) {
        super(settings);
    }

    @Override
    public void useMainAbility(MinecraftServer server, ServerPlayerEntity player) {
        useSpit(player, result -> {
            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, result.getEntity().getWorld());
            lightning.setPosition(result.getPos());
            result.getEntity().getWorld().spawnEntity(lightning);
        }, result -> {
            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, player.getWorld());
            lightning.setPosition(result.getPos());
            player.getWorld().spawnEntity(lightning);
        });
    }
}
