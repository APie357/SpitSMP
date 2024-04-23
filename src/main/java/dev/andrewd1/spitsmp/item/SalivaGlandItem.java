package dev.andrewd1.spitsmp.item;

import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public abstract class SalivaGlandItem extends TrinketItem {
    public SalivaGlandItem(Settings settings) {
        super(settings.maxCount(1));
    }

    public void useMainAbility(MinecraftServer server, ServerPlayerEntity player) { }
    public void useAltAbility(MinecraftServer server, ServerPlayerEntity player) { }
}
