package com.Awdawesome.entity.custom;

import com.Awdawesome.entity.ModEntities;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;

public class TempestsWrathEntity extends Entity {
    private static final int MAX_TICKS = 20;
    private static final double CONE_ANGLE = Math.toRadians(45);
    private static final double PUSH_FORCE = 2;
    private static final double LIFT_FORCE = .5;

    private final Vec3 origin;
    private final Vec3 direction;
    private int age;

    @Nullable
    private Entity owner;

    @Nullable
    public Entity getOwner() {
        return this.owner;
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }






    public TempestsWrathEntity(EntityType<?> type, Level level) {
        super(type, level);
        this.origin = Vec3.ZERO;
        this.direction = Vec3.ZERO;
    }

    public TempestsWrathEntity(Level level, Vec3 origin, Vec3 direction, Entity owner) {
        super(ModEntities.TEMPESTS_BLAST.get(), level);
        this.origin = origin;
        this.direction = direction.normalize();
        this.age = 0;
        this.setPos(origin);
        this.setOwner(owner); // 👈 now you're assigning the owner
    }


    @Override
    public void tick() {
        super.tick();
        if (!level().isClientSide) {
            age++;
            if (age > MAX_TICKS) {
                this.discard();
                return;
            }

            Vec3 center = origin.add(direction.scale(age)); // advancing point

            List<Entity> targets = level().getEntitiesOfClass(Entity.class,
                    new AABB(center.subtract(2, 2, 2), center.add(2, 2, 2)),
                    e -> e != this.getOwner() && isInCone(e.getBoundingBox().getCenter(), center, direction, CONE_ANGLE, 2)
            );
            System.out.println("Targets found: " + targets.size());

            for (Entity entity : targets) {
                Vec3 pushDir = entity.position().subtract(origin).normalize();
                Vec3 motion = new Vec3(
                        pushDir.x * PUSH_FORCE,
                        LIFT_FORCE,
                        pushDir.z * PUSH_FORCE
                );
                entity.push(motion.x, motion.y, motion.z);

            }

            // Send particles along the cone edge
            for (int i = -5; i <= 5; i++) {
                double angle = i * (CONE_ANGLE / 5);
                Vec3 edgeDir = rotateY(direction, angle);
                Vec3 edge = center.add(edgeDir.scale(1.5));
                ((ServerLevel) level()).sendParticles(ParticleTypes.GUST,
                        edge.x, edge.y, edge.z, 1,
                        0, 0, 0, 0);
            }
        }
    }

    private boolean isInCone(Vec3 targetPos, Vec3 center, Vec3 look, double angle, double tolerance) {
        Vec3 toTarget = targetPos.subtract(center);
        if (toTarget.length() > tolerance) return false;
        double dot = look.normalize().dot(toTarget.normalize());
        double theta = Math.acos(dot);
        return theta < angle;
    }

    private Vec3 rotateY(Vec3 vector, double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return new Vec3(
                vector.x * cos - vector.z * sin,
                vector.y,
                vector.x * sin + vector.z * cos
        );
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        // No custom synced data needed — leave empty unless syncing something like state
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {}
    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {}
}
