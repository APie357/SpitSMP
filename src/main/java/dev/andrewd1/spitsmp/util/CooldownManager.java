package dev.andrewd1.spitsmp.util;

import net.minecraft.server.network.ServerPlayerEntity;

import java.util.HashMap;

public class CooldownManager {
    protected final HashMap<ServerPlayerEntity, Integer> cooldowns = new HashMap<>();

    public void clear() {
        cooldowns.clear();
    }

    public void addCooldown(ServerPlayerEntity player, int cooldown) {
        if (cooldowns.containsKey(player)) cooldown += cooldowns.get(player);
        cooldowns.put(player, cooldown);
    }

    public void tick() {
        for (ServerPlayerEntity player : cooldowns.keySet()) {
            int cooldown = cooldowns.get(player);
            if (cooldown <= 0) continue;
            cooldowns.put(player, cooldown - 1);
        }
    }

    public boolean cooldownActive(ServerPlayerEntity player) {
        if (!cooldowns.containsKey(player)) return false;
        return cooldowns.get(player) > 0;
    }
}
