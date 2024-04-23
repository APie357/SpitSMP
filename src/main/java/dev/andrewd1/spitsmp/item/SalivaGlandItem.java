package dev.andrewd1.spitsmp.item;

import dev.andrewd1.spitsmp.util.ModTags;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public abstract class SalivaGlandItem extends TrinketItem {
    public SalivaGlandItem(Settings settings) {
        super(settings.maxCount(1));
    }

    public void useMainAbility(MinecraftServer server, ServerPlayerEntity player) { }
    public void useAltAbility(MinecraftServer server, ServerPlayerEntity player) { }

    @Nullable
    public static SalivaGlandItem getItemFromSlot(MinecraftServer server, ServerPlayerEntity player) {
        Optional<TrinketComponent> componentOptional = TrinketsApi.getTrinketComponent(player);
        if (componentOptional.isEmpty()) { return null; }

        TrinketComponent component = componentOptional.get();
        if (!component.isEquipped(ModTags.Items.salivaGlandPredicate)) { return null; }

        List<Pair<SlotReference, ItemStack>> equipped = component.getEquipped(ModTags.Items.salivaGlandPredicate);
        if (equipped.isEmpty()) { return null; }

        AtomicReference<SalivaGlandItem> item = new AtomicReference<>();
        equipped.forEach(slotReferenceItemStackPair -> item.set((SalivaGlandItem) slotReferenceItemStackPair.getRight().getItem()));
        return item.get();
    }
}
