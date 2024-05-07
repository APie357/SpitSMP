package dev.andrewd1.spitsmp.entity.entities;

import dev.andrewd1.spitsmp.entity.ModEntities;
import net.minecraft.block.AbstractBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SpitProjectileEntity extends ProjectileEntity {
    private OnHitEntity onHitEntity = (a) -> {};
    private OnHitGround onHitGround = (a) -> {};

    public SpitProjectileEntity(EntityType<? extends SpitProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public SpitProjectileEntity(World world, PlayerEntity owner, OnHitEntity onHitEntity, OnHitGround onHitGround) {
        this(ModEntities.SPIT_PROJECTILE, world);
        this.setOwner(owner);
        this.setPosition(
                owner.getX() - (double)(owner.getWidth() + 1.0f) * 0.5 * (double) MathHelper.sin(owner.bodyYaw * ((float)Math.PI / 180)),
                owner.getEyeY() - (double)0.1f,
                owner.getZ() + (double)(owner.getWidth() + 1.0f) * 0.5 * (double)MathHelper.cos(owner.bodyYaw * ((float)Math.PI / 180))
        );

        this.onHitEntity = onHitEntity;
        this.onHitGround = onHitGround;
    }

    public SpitProjectileEntity(ServerPlayerEntity owner, OnHitEntity onHitEntity, OnHitGround onHitGround) {
        this(owner.getWorld(), owner, onHitEntity, onHitGround);
    }

    public SpitProjectileEntity(ServerPlayerEntity owner) {
        this(owner, (a) -> {}, (a) -> {});
    }

    public SpitProjectileEntity(ServerPlayerEntity owner, OnHitEntity onHitEntity) {
        this(owner, onHitEntity, (a) -> {});
    }

    @Override
    public void tick() {
        super.tick();
        Vec3d vec3d = this.getVelocity();
        HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
        this.onCollision(hitResult);
        double d = this.getX() + vec3d.x;
        double e = this.getY() + vec3d.y;
        double f = this.getZ() + vec3d.z;
        this.updateRotation();
        float g = 0.99f;
        float h = -0.06f;
        if (this.getWorld().getStatesInBox(this.getBoundingBox()).noneMatch(AbstractBlock.AbstractBlockState::isAir)) {
            this.discard();
            return;
        }
        if (this.isInsideWaterOrBubbleColumn()) {
            this.discard();
            return;
        }
        this.setVelocity(vec3d.multiply(g));
        if (!this.hasNoGravity()) {
            this.setVelocity(this.getVelocity().add(0.0, h, 0.0));
        }
        this.setPosition(d, e, f);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        onHitEntity.run(entityHitResult);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        onHitGround.run(blockHitResult);
        if (!this.getWorld().isClient) {
            this.discard();
        }
    }

    @Override
    protected void initDataTracker() {
    }

    @Override
    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        double d = packet.getVelocityX();
        double e = packet.getVelocityY();
        double f = packet.getVelocityZ();
        for (int i = 0; i < 7; ++i) {
            double g = 0.4 + 0.1 * (double)i;
            this.getWorld().addParticle(ParticleTypes.SPIT, this.getX(), this.getY(), this.getZ(), d * g, e, f * g);
        }
        this.setVelocity(d, e, f);
    }

    public interface OnHitGround {
        void run(BlockHitResult result);
    }

    public interface OnHitEntity {
        void run(EntityHitResult result);
    }
}
