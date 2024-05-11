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
            damageAndSetOnFire(victim, player, 3f, 10);
            setFireIfEmpty(victim.getWorld(), result.getEntity().getBlockPos());
        }, result -> setFireIfEmpty(player.getWorld(), result.getBlockPos().offset(result.getSide())));
    }

    protected void damageAndSetOnFire(Entity victim, ServerPlayerEntity attacker, float damageAmount, int fireSeconds) {
            victim.damage(attacker.getDamageSources().playerAttack(attacker), damageAmount);
            victim.setOnFireFor(fireSeconds);
    }

    protected void setFireIfEmpty(World world, BlockPos pos) {
        if (world.getBlockState(pos).getBlock() == Blocks.AIR) {
            world.setBlockState(pos, Blocks.FIRE.getDefaultState());
        }
    }
}
