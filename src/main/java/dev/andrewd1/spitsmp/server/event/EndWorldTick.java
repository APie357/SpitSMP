package dev.andrewd1.spitsmp.server.event;

import dev.andrewd1.spitsmp.SpitSMP;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class EndWorldTick {
    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(tick -> {
            SpitSMP.mainCooldownManager.tick();
            SpitSMP.altCooldownManager.tick();
        });
    }
}
