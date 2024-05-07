package dev.andrewd1.spitsmp.item.items;

import dev.andrewd1.spitsmp.item.SalivaGlandItem;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class ExplodoSalivaGland extends SalivaGlandItem {
    public ExplodoSalivaGland(Settings settings) {
        super(settings);
    }

    @Override
    public void useMainAbility(MinecraftServer server, ServerPlayerEntity player) {
        useSpit(
                player,
                result -> result.getEntity().getWorld().createExplosion(player, result.getEntity().getX(), result.getEntity().getY(), result.getEntity().getZ(), 1f, World.ExplosionSourceType.MOB),
                result -> player.getWorld().createExplosion(player, result.getPos().x, result.getPos().y, result.getPos().z, 1f, World.ExplosionSourceType.MOB)
        );
    }
}
