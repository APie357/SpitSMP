package dev.andrewd1.spitsmp.item.items;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class SilvererSalivaGland extends SilverSalivaGland {
    public SilvererSalivaGland(Settings settings) {
        super(settings);
    }

    @Override
    public void useMainAbility(MinecraftServer server, ServerPlayerEntity player) {
        useSpit(
                player,
                result -> spawnSilverfish(15, result.getEntity().getWorld(), result.getPos()),
                result -> spawnSilverfish(15, player.getWorld(), result.getPos())
        );
    }
}
