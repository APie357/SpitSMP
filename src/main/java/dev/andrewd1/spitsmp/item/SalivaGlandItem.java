package dev.andrewd1.spitsmp.item;

import dev.andrewd1.spitsmp.entity.entities.SpitProjectileEntity;
import dev.andrewd1.spitsmp.util.ModTags;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public abstract class SalivaGlandItem extends TrinketItem {
    protected static final Random random = new Random();

    public SalivaGlandItem(Settings settings) {
        super(settings.maxCount(1));
    }

    public void useMainAbility(MinecraftServer server, ServerPlayerEntity player) { }
    public void useAltAbility(MinecraftServer server, ServerPlayerEntity player) { }

    @Nullable
    public static SalivaGlandItem getItemFromSlot(ServerPlayerEntity player) {
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

    public static void useSpit(ServerPlayerEntity player, SpitProjectileEntity.OnHitEntity onHitEntity, SpitProjectileEntity.OnHitGround onHitGround, float speed) {
        SpitProjectileEntity spitEntity = new SpitProjectileEntity(player, onHitEntity, onHitGround);
        spitEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0f, speed, 10.0f);

        player.getWorld().playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.ENTITY_LLAMA_SPIT,
                player.getSoundCategory(),
                1.0f,
                1.0f + (random.nextFloat() - random.nextFloat()) * 0.2f
        );

        player.getWorld().spawnEntity(spitEntity);
    }

    public static void useSpit(ServerPlayerEntity player) {
        useSpit(player, (a) -> {}, (a) -> {}, 1.5f);
    }

    public static void useSpit(ServerPlayerEntity player, SpitProjectileEntity.OnHitEntity onHitEntity) {
        useSpit(player, onHitEntity, (a) -> {}, 1.5f);
    }

    public static void useSpit(ServerPlayerEntity player, SpitProjectileEntity.OnHitEntity onHitEntity, SpitProjectileEntity.OnHitGround onHitGround) {
        useSpit(player, onHitEntity, onHitGround, 1.5f);
    }
}
