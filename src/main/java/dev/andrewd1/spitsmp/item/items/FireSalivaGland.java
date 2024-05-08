package dev.andrewd1.spitsmp.item.items;

import dev.andrewd1.spitsmp.item.SalivaGlandItem;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireSalivaGland extends SalivaGlandItem {
    public FireSalivaGland(Settings settings) {
        super(settings);
    }

    @Override
    public void useMainAbility(MinecraftServer server, ServerPlayerEntity player) {
        useSpit(player, result -> {
            Entity victim = result.getEntity();
            victim.damage(player.getDamageSources().playerAttack(player), 3f);
            victim.setOnFireFor(10);

            World world = victim.getWorld();
            BlockPos firePos = victim.getBlockPos();
            if (world.getBlockState(firePos).getBlock() == Blocks.AIR) {
                world.setBlockState(firePos, Blocks.FIRE.getDefaultState());
            }
        }, result -> {
            World world = player.getWorld();
            BlockPos firePos = result.getBlockPos().up();
            if (world.getBlockState(firePos).getBlock() == Blocks.AIR) {
                world.setBlockState(firePos, Blocks.FIRE.getDefaultState());
            }
        });
    }
}
