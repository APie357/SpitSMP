package dev.andrewd1.spitsmp.item.items;

import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlameSalivaGland extends FireSalivaGland {
    public FlameSalivaGland(Settings settings) {
        super(settings);
    }

    @Override
    public void useMainAbility(MinecraftServer server, ServerPlayerEntity player) {
        useSpit(player, result -> {
            Entity victim = result.getEntity();
            World world = victim.getWorld();
            BlockPos pos = victim.getBlockPos();

            damageAndSetOnFire(victim, player, 4f, 15);

            setFireIfEmpty(world, pos);
            setFireIfEmptyRand(world, pos.north());
            setFireIfEmptyRand(world, pos.east());
            setFireIfEmptyRand(world, pos.south());
            setFireIfEmptyRand(world, pos.west());
            setFireIfEmptyRand(world, pos.down());
        }, result -> {
            World world = player.getWorld();
            BlockPos pos = result.getBlockPos().offset(result.getSide());

            setFireIfEmpty(world, pos);
            setFireIfEmptyRand(world, pos.north());
            setFireIfEmptyRand(world, pos.east());
            setFireIfEmptyRand(world, pos.south());
            setFireIfEmptyRand(world, pos.west());
            setFireIfEmptyRand(world, pos.down());
        });
    }

    protected void setFireIfEmptyRand(World world, BlockPos pos) {
        if (random.nextBoolean()) {
            setFireIfEmpty(world, pos);
        }
    }

    // TODO: Make alt flamethrower ability
}
