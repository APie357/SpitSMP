package dev.andrewd1.spitsmp.item.items;

import dev.andrewd1.spitsmp.item.SalivaGlandItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SilverSalivaGland extends SalivaGlandItem {
    public SilverSalivaGland(Settings settings) {
        super(settings);
    }

    @Override
    public void useMainAbility(MinecraftServer server, ServerPlayerEntity player) {
        useSpit(
                player,
                result -> spawnSilverfish(7, result.getEntity().getWorld(), result.getPos()),
                result -> spawnSilverfish(7, player.getWorld(), result.getPos())
        );
    }

    protected void spawnSilverfish(int amount, World world, Vec3d pos) {
        for (int i = 0; i < amount; i++) {
            SilverfishEntity silverfish = new SilverfishEntity(EntityType.SILVERFISH, world);
            silverfish.setPosition(pos);
            world.spawnEntity(silverfish);
        }
    }
}
