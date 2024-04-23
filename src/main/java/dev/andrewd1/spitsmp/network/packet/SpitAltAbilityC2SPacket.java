package dev.andrewd1.spitsmp.network.packet;

import dev.andrewd1.spitsmp.item.SalivaGlandItem;
import dev.andrewd1.spitsmp.util.ModTags;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Pair;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class SpitAltAbilityC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        Optional<TrinketComponent> componentOptional = TrinketsApi.getTrinketComponent(player);
        if (componentOptional.isEmpty()) { return; }
        TrinketComponent component = componentOptional.get();
        if (!component.isEquipped(ModTags.Items.salivaGlandPredicate)) { return; }
        List<Pair<SlotReference, ItemStack>> equipped = component.getEquipped(ModTags.Items.salivaGlandPredicate);
        if (equipped.isEmpty()) { return; }
        AtomicReference<SalivaGlandItem> item = new AtomicReference<>();
        equipped.forEach(slotReferenceItemStackPair -> item.set((SalivaGlandItem) slotReferenceItemStackPair.getRight().getItem()));
        item.get().useAltAbility(server, player);
    }
}
