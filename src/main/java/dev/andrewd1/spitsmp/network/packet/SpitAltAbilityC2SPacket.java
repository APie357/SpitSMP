package dev.andrewd1.spitsmp.network.packet;

import dev.andrewd1.spitsmp.SpitSMP;
import dev.andrewd1.spitsmp.item.SalivaGlandItem;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class SpitAltAbilityC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        if (SpitSMP.altCooldownManager.cooldownActive(player)) return;
        SalivaGlandItem item = SalivaGlandItem.getItemFromSlot(player);
        if (item == null) { return; }
        item.useAltAbility(server, player);
        SpitSMP.altCooldownManager.addCooldown(player, item.altCooldownTicks);
    }
}
