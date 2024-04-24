package dev.andrewd1.spitsmp.entity;

import dev.andrewd1.spitsmp.SpitSMP;
import dev.andrewd1.spitsmp.entity.entities.SpitProjectileEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<SpitProjectileEntity> SPIT_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(SpitSMP.MOD_ID, "spit_projectile"),
            FabricEntityTypeBuilder.<SpitProjectileEntity>create(SpawnGroup.MISC, SpitProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .build()
    );
}
