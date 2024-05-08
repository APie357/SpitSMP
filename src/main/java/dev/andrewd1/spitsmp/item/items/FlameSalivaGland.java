package dev.andrewd1.spitsmp.item.items;

import dev.andrewd1.spitsmp.item.SalivaGlandItem;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlameSalivaGland extends SalivaGlandItem {
    public FlameSalivaGland(Settings settings) {
        super(settings);
    }

    @Override
    public void useMainAbility(MinecraftServer server, ServerPlayerEntity player) {
        useSpit(player, result -> {
            Entity victim = result.getEntity();
            victim.damage(player.getDamageSources().playerAttack(player), 4f);
            victim.setOnFireFor(15);

            World world = victim.getWorld();
            BlockPos firePos = victim.getBlockPos();

            if (world.getBlockState(firePos).getBlock() == Blocks.AIR)
                world.setBlockState(firePos, Blocks.FIRE.getDefaultState());
            if (random.nextBoolean() && world.getBlockState(firePos.north()).getBlock() == Blocks.AIR)
                world.setBlockState(firePos.north(), Blocks.FIRE.getDefaultState());
            if (random.nextBoolean() && world.getBlockState(firePos.south()).getBlock() == Blocks.AIR)
                world.setBlockState(firePos.south(), Blocks.FIRE.getDefaultState());
            if (random.nextBoolean() && world.getBlockState(firePos.east()).getBlock() == Blocks.AIR)
                world.setBlockState(firePos.east(), Blocks.FIRE.getDefaultState());
            if (random.nextBoolean() && world.getBlockState(firePos.west()).getBlock() == Blocks.AIR)
                world.setBlockState(firePos.west(), Blocks.FIRE.getDefaultState());

        }, result -> {
            World world = player.getWorld();
            BlockPos firePos = result.getBlockPos().up();
            if (world.getBlockState(firePos).getBlock() == Blocks.AIR)
                world.setBlockState(firePos, Blocks.FIRE.getDefaultState());
            if (random.nextBoolean() && world.getBlockState(firePos.north()).getBlock() == Blocks.AIR)
                world.setBlockState(firePos.north(), Blocks.FIRE.getDefaultState());
            if (random.nextBoolean() && world.getBlockState(firePos.south()).getBlock() == Blocks.AIR)
                world.setBlockState(firePos.south(), Blocks.FIRE.getDefaultState());
            if (random.nextBoolean() && world.getBlockState(firePos.east()).getBlock() == Blocks.AIR)
                world.setBlockState(firePos.east(), Blocks.FIRE.getDefaultState());
            if (random.nextBoolean() && world.getBlockState(firePos.west()).getBlock() == Blocks.AIR)
                world.setBlockState(firePos.west(), Blocks.FIRE.getDefaultState());
        });
    }

    // TODO: Make alt flamethrower ability
}
