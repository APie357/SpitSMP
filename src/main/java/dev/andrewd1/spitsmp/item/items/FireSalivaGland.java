package dev.andrewd1.spitsmp.item.items;

import dev.andrewd1.spitsmp.item.SalivaGlandItem;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class FireSalivaGland extends SalivaGlandItem {
    public FireSalivaGland(Settings settings) {
        super(settings);
    }

    @Override
    public void useMainAbility(MinecraftServer server, ServerPlayerEntity player) {
        useSpit(player, result -> {
            result.getEntity().damage(player.getDamageSources().playerAttack(player), 3f);
            result.getEntity().setOnFireFor(10);
        });
    }
}
