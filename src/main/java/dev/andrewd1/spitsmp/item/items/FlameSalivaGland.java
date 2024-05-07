package dev.andrewd1.spitsmp.item.items;

import dev.andrewd1.spitsmp.item.SalivaGlandItem;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class FlameSalivaGland extends SalivaGlandItem {
    public FlameSalivaGland(Settings settings) {
        super(settings);
    }

    @Override
    public void useMainAbility(MinecraftServer server, ServerPlayerEntity player) {
        useSpit(player, result -> {
            result.getEntity().damage(player.getDamageSources().playerAttack(player), 4f);
            result.getEntity().setOnFireFor(15);
        });
    }

    // TODO: Make alt flamethrower ability
}
