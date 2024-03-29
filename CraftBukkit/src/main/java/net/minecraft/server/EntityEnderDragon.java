package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

// CraftBukkit start
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.Location;
import org.bukkit.event.entity.EntityCreatePortalEvent;

import java.util.ArrayList;
import org.bukkit.PortalType;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.util.BlockStateListPopulator;
// CraftBukkit end

public class EntityEnderDragon extends EntityComplex {

    public double a;
    public double b;
    public double c;
    public double[][] d = new double[64][3];
    public int e = -1;
    public EntityComplexPart[] children;
    public EntityComplexPart g;
    public EntityComplexPart h;
    public EntityComplexPart i;
    public EntityComplexPart j;
    public EntityComplexPart k;
    public EntityComplexPart l;
    public EntityComplexPart m;
    public float n = 0.0F;
    public float o = 0.0F;
    public boolean p = false;
    public boolean q = false;
    private Entity u;
    public int r = 0;
    public EntityEnderCrystal s = null;

    public EntityEnderDragon(World world) {
        super(world);
        this.children = new EntityComplexPart[] { this.g = new EntityComplexPart(this, "head", 6.0F, 6.0F), this.h = new EntityComplexPart(this, "body", 8.0F, 8.0F), this.i = new EntityComplexPart(this, "tail", 4.0F, 4.0F), this.j = new EntityComplexPart(this, "tail", 4.0F, 4.0F), this.k = new EntityComplexPart(this, "tail", 4.0F, 4.0F), this.l = new EntityComplexPart(this, "wing", 4.0F, 4.0F), this.m = new EntityComplexPart(this, "wing", 4.0F, 4.0F)};
        this.t = 200;
        this.setHealth(this.t);
        this.texture = "/mob/enderdragon/ender.png";
        this.b(16.0F, 8.0F);
        this.bQ = true;
        this.fireProof = true;
        this.b = 100.0D;
        this.cd = true;
    }

    protected void b() {
        super.b();
        this.datawatcher.a(16, new Integer(this.t));
    }

    public double[] a(int i, float f) {
        if (this.health <= 0) {
            f = 0.0F;
        }

        f = 1.0F - f;
        int j = this.e - i * 1 & 63;
        int k = this.e - i * 1 - 1 & 63;
        double[] adouble = new double[3];
        double d0 = this.d[j][0];

        double d1;

        for (d1 = this.d[k][0] - d0; d1 < -180.0D; d1 += 360.0D) {
            ;
        }

        while (d1 >= 180.0D) {
            d1 -= 360.0D;
        }

        adouble[0] = d0 + d1 * (double) f;
        d0 = this.d[j][1];
        d1 = this.d[k][1] - d0;
        adouble[1] = d0 + d1 * (double) f;
        adouble[2] = this.d[j][2] + (this.d[k][2] - this.d[j][2]) * (double) f;
        return adouble;
    }

    public void d() {
        this.n = this.o;
        if (!this.world.isStatic) {
            this.datawatcher.watch(16, Integer.valueOf(this.health));
        }

        float f;
        float f1;
        float d05;

        if (this.health <= 0) {
            f = (this.random.nextFloat() - 0.5F) * 8.0F;
            d05 = (this.random.nextFloat() - 0.5F) * 4.0F;
            f1 = (this.random.nextFloat() - 0.5F) * 8.0F;
            this.world.a("largeexplode", this.locX + (double) f, this.locY + 2.0D + (double) d05, this.locZ + (double) f1, 0.0D, 0.0D, 0.0D);
        } else {
            this.v();
            f = 0.2F / (MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ) * 10.0F + 1.0F);
            f *= (float) Math.pow(2.0D, this.motY);
            if (this.q) {
                this.o += f * 0.5F;
            } else {
                this.o += f;
            }

            while (this.yaw >= 180.0F) {
                this.yaw -= 360.0F;
            }

            while (this.yaw < -180.0F) {
                this.yaw += 360.0F;
            }

            if (this.e < 0) {
                for (int i = 0; i < this.d.length; ++i) {
                    this.d[i][0] = (double) this.yaw;
                    this.d[i][1] = this.locY;
                }
            }

            if (++this.e == this.d.length) {
                this.e = 0;
            }

            this.d[this.e][0] = (double) this.yaw;
            this.d[this.e][1] = this.locY;
            double d0;
            double d1;
            double d2;
            double d3;
            float f3;

            if (this.world.isStatic) {
                if (this.aN > 0) {
                    d0 = this.locX + (this.aO - this.locX) / (double) this.aN;
                    d1 = this.locY + (this.aP - this.locY) / (double) this.aN;
                    d2 = this.locZ + (this.aQ - this.locZ) / (double) this.aN;

                    for (d3 = this.aR - (double) this.yaw; d3 < -180.0D; d3 += 360.0D) {
                        ;
                    }

                    while (d3 >= 180.0D) {
                        d3 -= 360.0D;
                    }

                    this.yaw = (float) ((double) this.yaw + d3 / (double) this.aN);
                    this.pitch = (float) ((double) this.pitch + (this.aS - (double) this.pitch) / (double) this.aN);
                    --this.aN;
                    this.setPosition(d0, d1, d2);
                    this.c(this.yaw, this.pitch);
                }
            } else {
                d0 = this.a - this.locX;
                d1 = this.b - this.locY;
                d2 = this.c - this.locZ;
                d3 = d0 * d0 + d1 * d1 + d2 * d2;
                if (this.u != null) {
                    this.a = this.u.locX;
                    this.c = this.u.locZ;
                    double d4 = this.a - this.locX;
                    double d5 = this.c - this.locZ;
                    double d6 = Math.sqrt(d4 * d4 + d5 * d5);
                    double d7 = 0.4000000059604645D + d6 / 80.0D - 1.0D;

                    if (d7 > 10.0D) {
                        d7 = 10.0D;
                    }

                    this.b = this.u.boundingBox.b + d7;
                } else {
                    this.a += this.random.nextGaussian() * 2.0D;
                    this.c += this.random.nextGaussian() * 2.0D;
                }

                if (this.p || d3 < 100.0D || d3 > 22500.0D || this.positionChanged || this.bz) {
                    this.B();
                }

                d1 /= (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
                f3 = 0.6F;
                if (d1 < (double) (-f3)) {
                    d1 = (double) (-f3);
                }

                if (d1 > (double) f3) {
                    d1 = (double) f3;
                }

                for (this.motY += d1 * 0.10000000149011612D; this.yaw < -180.0F; this.yaw += 360.0F) {
                    ;
                }

                while (this.yaw >= 180.0F) {
                    this.yaw -= 360.0F;
                }

                double d8 = 180.0D - Math.atan2(d0, d2) * 180.0D / 3.1415927410125732D;

                double d9;

                for (d9 = d8 - (double) this.yaw; d9 < -180.0D; d9 += 360.0D) {
                    ;
                }

                while (d9 >= 180.0D) {
                    d9 -= 360.0D;
                }

                if (d9 > 50.0D) {
                    d9 = 50.0D;
                }

                if (d9 < -50.0D) {
                    d9 = -50.0D;
                }

                Vec3D vec3d = Vec3D.create(this.a - this.locX, this.b - this.locY, this.c - this.locZ).b();
                Vec3D vec3d1 = Vec3D.create((double) MathHelper.sin(this.yaw * 3.1415927F / 180.0F), this.motY, (double) (-MathHelper.cos(this.yaw * 3.1415927F / 180.0F))).b();
                float f4 = (float) (vec3d1.a(vec3d) + 0.5D) / 1.5F;

                if (f4 < 0.0F) {
                    f4 = 0.0F;
                }

                this.aY *= 0.8F;
                float f5 = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ) * 1.0F + 1.0F;
                double d10 = Math.sqrt(this.motX * this.motX + this.motZ * this.motZ) * 1.0D + 1.0D;

                if (d10 > 40.0D) {
                    d10 = 40.0D;
                }

                this.aY = (float) ((double) this.aY + d9 * (0.699999988079071D / d10 / (double) f5));
                this.yaw += this.aY * 0.1F;
                float f6 = (float) (2.0D / (d10 + 1.0D));
                float f7 = 0.06F;

                this.a(0.0F, -1.0F, f7 * (f4 * f6 + (1.0F - f6)));
                if (this.q) {
                    this.move(this.motX * 0.800000011920929D, this.motY * 0.800000011920929D, this.motZ * 0.800000011920929D);
                } else {
                    this.move(this.motX, this.motY, this.motZ);
                }

                Vec3D vec3d2 = Vec3D.create(this.motX, this.motY, this.motZ).b();
                float f8 = (float) (vec3d2.a(vec3d1) + 1.0D) / 2.0F;

                f8 = 0.8F + 0.15F * f8;
                this.motX *= (double) f8;
                this.motZ *= (double) f8;
                this.motY *= 0.9100000262260437D;
            }

            this.V = this.yaw;
            this.g.width = this.g.length = 3.0F;
            this.i.width = this.i.length = 2.0F;
            this.j.width = this.j.length = 2.0F;
            this.k.width = this.k.length = 2.0F;
            this.h.length = 3.0F;
            this.h.width = 5.0F;
            this.l.length = 2.0F;
            this.l.width = 4.0F;
            this.m.length = 3.0F;
            this.m.width = 4.0F;
            d05 = (float) (this.a(5, 1.0F)[1] - this.a(10, 1.0F)[1]) * 10.0F / 180.0F * 3.1415927F;
            f1 = MathHelper.cos(d05);
            float f9 = -MathHelper.sin(d05);
            float f10 = this.yaw * 3.1415927F / 180.0F;
            float f11 = MathHelper.sin(f10);
            float f12 = MathHelper.cos(f10);

            this.h.y_();
            this.h.setPositionRotation(this.locX + (double) (f11 * 0.5F), this.locY, this.locZ - (double) (f12 * 0.5F), 0.0F, 0.0F);
            this.l.y_();
            this.l.setPositionRotation(this.locX + (double) (f12 * 4.5F), this.locY + 2.0D, this.locZ + (double) (f11 * 4.5F), 0.0F, 0.0F);
            this.m.y_();
            this.m.setPositionRotation(this.locX - (double) (f12 * 4.5F), this.locY + 2.0D, this.locZ - (double) (f11 * 4.5F), 0.0F, 0.0F);
            if (!this.world.isStatic) {
                this.z();
            }

            if (!this.world.isStatic && this.at == 0) {
                this.a(this.world.getEntities(this, this.l.boundingBox.grow(4.0D, 2.0D, 4.0D).d(0.0D, -2.0D, 0.0D)));
                this.a(this.world.getEntities(this, this.m.boundingBox.grow(4.0D, 2.0D, 4.0D).d(0.0D, -2.0D, 0.0D)));
                this.b(this.world.getEntities(this, this.g.boundingBox.grow(1.0D, 1.0D, 1.0D)));
            }

            double[] adouble = this.a(5, 1.0F);
            double[] adouble1 = this.a(0, 1.0F);

            f3 = MathHelper.sin(this.yaw * 3.1415927F / 180.0F - this.aY * 0.01F);
            float f13 = MathHelper.cos(this.yaw * 3.1415927F / 180.0F - this.aY * 0.01F);

            this.g.y_();
            this.g.setPositionRotation(this.locX + (double) (f3 * 5.5F * f1), this.locY + (adouble1[1] - adouble[1]) * 1.0D + (double) (f9 * 5.5F), this.locZ - (double) (f13 * 5.5F * f1), 0.0F, 0.0F);

            for (int j = 0; j < 3; ++j) {
                EntityComplexPart entitycomplexpart = null;

                if (j == 0) {
                    entitycomplexpart = this.i;
                }

                if (j == 1) {
                    entitycomplexpart = this.j;
                }

                if (j == 2) {
                    entitycomplexpart = this.k;
                }

                double[] adouble2 = this.a(12 + j * 2, 1.0F);
                float f14 = this.yaw * 3.1415927F / 180.0F + this.a(adouble2[0] - adouble[0]) * 3.1415927F / 180.0F * 1.0F;
                float f15 = MathHelper.sin(f14);
                float f16 = MathHelper.cos(f14);
                float f17 = 1.5F;
                float f18 = (float) (j + 1) * 2.0F;

                entitycomplexpart.y_();
                entitycomplexpart.setPositionRotation(this.locX - (double) ((f11 * f17 + f15 * f18) * f1), this.locY + (adouble2[1] - adouble[1]) * 1.0D - (double) ((f18 + f17) * f9) + 1.5D, this.locZ + (double) ((f12 * f17 + f16 * f18) * f1), 0.0F, 0.0F);
            }

            if (!this.world.isStatic) {
                this.q = this.a(this.g.boundingBox) | this.a(this.h.boundingBox);
            }
        }
    }

    private void v() {
        if (this.s != null) {
            if (this.s.dead) {
                if (!this.world.isStatic) {
                    this.a(this.g, DamageSource.EXPLOSION, 10);
                }

                this.s = null;
            } else if (this.ticksLived % 10 == 0 && this.health < this.t) {
                ++this.health;
            }
        }

        if (this.random.nextInt(10) == 0) {
            float f = 32.0F;
            List list = this.world.a(EntityEnderCrystal.class, this.boundingBox.grow((double) f, (double) f, (double) f));
            EntityEnderCrystal entityendercrystal = null;
            double d0 = Double.MAX_VALUE;
            Iterator iterator = list.iterator();

            while (iterator.hasNext()) {
                Entity entity = (Entity) iterator.next();
                double d1 = entity.i(this);

                if (d1 < d0) {
                    d0 = d1;
                    entityendercrystal = (EntityEnderCrystal) entity;
                }
            }

            this.s = entityendercrystal;
        }
    }

    private void z() {
        if (this.ticksLived % 20 == 0) {
            Vec3D vec3d = this.e(1.0F);
            double d0 = 0.0D;
            double d1 = -1.0D;
            double d2 = 0.0D;
        }
    }

    private void a(List list) {
        double d0 = (this.h.boundingBox.a + this.h.boundingBox.d) / 2.0D;
        double d1 = (this.h.boundingBox.c + this.h.boundingBox.f) / 2.0D;
        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            Entity entity = (Entity) iterator.next();

            if (entity instanceof EntityLiving) {
                double d2 = entity.locX - d0;
                double d3 = entity.locZ - d1;
                double d4 = d2 * d2 + d3 * d3;

                entity.b_(d2 / d4 * 4.0D, 0.20000000298023224D, d3 / d4 * 4.0D);
            }
        }
    }

    private void b(List list) {
        for (int i = 0; i < list.size(); ++i) {
            Entity entity = (Entity) list.get(i);

            if (entity instanceof EntityLiving) {
                // CraftBukkit start - throw damage events when the dragon attacks
                // The EntityHuman case is handled in EntityHuman, so don't throw it here
                if (!(entity instanceof EntityHuman)) {
                    EntityDamageByEntityEvent damageEvent = new EntityDamageByEntityEvent(this.getBukkitEntity(), entity.getBukkitEntity(), EntityDamageEvent.DamageCause.ENTITY_ATTACK, 10);
                    Bukkit.getPluginManager().callEvent(damageEvent);

                    if (!damageEvent.isCancelled()) {
                        entity.damageEntity(DamageSource.mobAttack(this), damageEvent.getDamage());
                    }
                } else {
                    entity.damageEntity(DamageSource.mobAttack(this), 10);
                }
                // CraftBukkit end
            }
        }
    }

    private void B() {
        this.p = false;
        if (this.random.nextInt(2) == 0 && this.world.players.size() > 0) {
            this.u = (Entity) this.world.players.get(this.random.nextInt(this.world.players.size()));
        } else {
            boolean flag = false;

            do {
                this.a = 0.0D;
                this.b = (double) (70.0F + this.random.nextFloat() * 50.0F);
                this.c = 0.0D;
                this.a += (double) (this.random.nextFloat() * 120.0F - 60.0F);
                this.c += (double) (this.random.nextFloat() * 120.0F - 60.0F);
                double d0 = this.locX - this.a;
                double d1 = this.locY - this.b;
                double d2 = this.locZ - this.c;

                flag = d0 * d0 + d1 * d1 + d2 * d2 > 100.0D;
            } while (!flag);

            this.u = null;
        }
    }

    private float a(double d0) {
        while (d0 >= 180.0D) {
            d0 -= 360.0D;
        }

        while (d0 < -180.0D) {
            d0 += 360.0D;
        }

        return (float) d0;
    }

    private boolean a(AxisAlignedBB axisalignedbb) {
        int i = MathHelper.floor(axisalignedbb.a);
        int j = MathHelper.floor(axisalignedbb.b);
        int k = MathHelper.floor(axisalignedbb.c);
        int l = MathHelper.floor(axisalignedbb.d);
        int i1 = MathHelper.floor(axisalignedbb.e);
        int j1 = MathHelper.floor(axisalignedbb.f);
        boolean flag = false;
        boolean flag1 = false;

        // CraftBukkit start - create a list to hold all the destroyed blocks
        List<org.bukkit.block.Block> destroyedBlocks = new ArrayList<org.bukkit.block.Block>();
        CraftWorld craftWorld = this.world.getWorld();
        // CraftBukkit end
        for (int k1 = i; k1 <= l; ++k1) {
            for (int l1 = j; l1 <= i1; ++l1) {
                for (int i2 = k; i2 <= j1; ++i2) {
                    int j2 = this.world.getTypeId(k1, l1, i2);

                    if (j2 != 0) {
                        if (j2 != Block.OBSIDIAN.id && j2 != Block.WHITESTONE.id && j2 != Block.BEDROCK.id) {
                            flag1 = true;
                            // CraftBukkit start - add blocks to list rather than destroying them
                            //this.world.setTypeId(k1, l1, i2, 0);
                            destroyedBlocks.add(craftWorld.getBlockAt(k1, l1, i2));
                            // CraftBukkit end
                        } else {
                            flag = true;
                        }
                    }
                }
            }
        }

        if (flag1) {
            // CraftBukkit start - set off an EntityExplodeEvent for the dragon exploding all these blocks
            org.bukkit.entity.Entity bukkitEntity = this.getBukkitEntity();
            EntityExplodeEvent event = new EntityExplodeEvent(bukkitEntity, bukkitEntity.getLocation(), destroyedBlocks, 0F);
            Bukkit.getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                // this flag literally means 'Dragon hit something hard' (Obsidian, White Stone or Bedrock) and will cause the dragon to slow down.
                // We should consider adding an event extension for it, or perhaps returning true if the event is cancelled.
                return flag;
            } else {
                for (org.bukkit.block.Block block : event.blockList()) {
                    craftWorld.explodeBlock(block, event.getYield());
                }
            }
            // CraftBukkit end
            double d0 = axisalignedbb.a + (axisalignedbb.d - axisalignedbb.a) * (double) this.random.nextFloat();
            double d1 = axisalignedbb.b + (axisalignedbb.e - axisalignedbb.b) * (double) this.random.nextFloat();
            double d2 = axisalignedbb.c + (axisalignedbb.f - axisalignedbb.c) * (double) this.random.nextFloat();

            this.world.a("largeexplode", d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }

        return flag;
    }

    public boolean a(EntityComplexPart entitycomplexpart, DamageSource damagesource, int i) {
        if (entitycomplexpart != this.g) {
            i = i / 4 + 1;
        }

        float f = this.yaw * 3.1415927F / 180.0F;
        float f1 = MathHelper.sin(f);
        float f2 = MathHelper.cos(f);

        this.a = this.locX + (double) (f1 * 5.0F) + (double) ((this.random.nextFloat() - 0.5F) * 2.0F);
        this.b = this.locY + (double) (this.random.nextFloat() * 3.0F) + 1.0D;
        this.c = this.locZ - (double) (f2 * 5.0F) + (double) ((this.random.nextFloat() - 0.5F) * 2.0F);
        this.u = null;
        if (damagesource.getEntity() instanceof EntityHuman || damagesource == DamageSource.EXPLOSION) {
            this.e(damagesource, i);
        }

        return true;
    }

    protected void an() {
        ++this.r;
        if (this.r >= 180 && this.r <= 200) {
            float f = (this.random.nextFloat() - 0.5F) * 8.0F;
            float f1 = (this.random.nextFloat() - 0.5F) * 4.0F;
            float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;

            this.world.a("hugeexplosion", this.locX + (double) f, this.locY + 2.0D + (double) f1, this.locZ + (double) f2, 0.0D, 0.0D, 0.0D);
        }

        int i;
        int j;

        if (!this.world.isStatic && this.r > 150 && this.r % 5 == 0) {
            i = expToDrop / 20; // CraftBukkit - drop experience as dragon falls from sky. use experience drop from death event. This is now set in getExpReward()

            while (i > 0) {
                j = EntityExperienceOrb.getOrbValue(i);
                i -= j;
                this.world.addEntity(new EntityExperienceOrb(this.world, this.locX, this.locY, this.locZ, j));
            }
        }

        this.move(0.0D, 0.10000000149011612D, 0.0D);
        this.V = this.yaw += 20.0F;
        if (this.r == 200) {
            i = expToDrop - 10 * (expToDrop / 20); // CraftBukkit - drop the remaining experience

            while (i > 0) {
                j = EntityExperienceOrb.getOrbValue(i);
                i -= j;
                this.world.addEntity(new EntityExperienceOrb(this.world, this.locX, this.locY, this.locZ, j));
            }

            j = 5 + this.random.nextInt(2) * 2 - 1;
            int k = 5 + this.random.nextInt(2) * 2 - 1;

            if (this.random.nextInt(2) == 0) {
                boolean flag = false;
            } else {
                boolean flag1 = false;
            }

            this.a(MathHelper.floor(this.locX), MathHelper.floor(this.locZ));
            this.ay();
            this.die();
        }
    }

    private void a(int i, int j) {
        int k = this.world.height / 2;

        BlockEnderPortal.a = true;
        byte b0 = 4;
        
        // CraftBukkit start - Replace any "this.world" in the following with just "world"!
        EntityCreatePortalEvent event = new EntityCreatePortalEvent(this.getBukkitEntity(), new ArrayList<BlockState>(), PortalType.ENDER);
        BlockStateListPopulator world = new BlockStateListPopulator(this.world.getWorld(), event.getBlocks());

        for (int l = k - 1; l <= k + 32; ++l) {
            for (int i1 = i - b0; i1 <= i + b0; ++i1) {
                for (int j1 = j - b0; j1 <= j + b0; ++j1) {
                    double d0 = (double) (i1 - i);
                    double d1 = (double) (j1 - j);
                    double d2 = (double) MathHelper.sqrt(d0 * d0 + d1 * d1);

                    if (d2 <= (double) b0 - 0.5D) {
                        if (l < k) {
                            if (d2 <= (double) (b0 - 1) - 0.5D) {
                                world.setTypeId(i1, l, j1, Block.BEDROCK.id);
                            }
                        } else if (l > k) {
                            world.setTypeId(i1, l, j1, 0);
                        } else if (d2 > (double) (b0 - 1) - 0.5D) {
                            world.setTypeId(i1, l, j1, Block.BEDROCK.id);
                        } else {
                            world.setTypeId(i1, l, j1, Block.ENDER_PORTAL.id);
                        }
                    }
                }
            }
        }

        world.setTypeId(i, k + 0, j, Block.BEDROCK.id);
        world.setTypeId(i, k + 1, j, Block.BEDROCK.id);
        world.setTypeId(i, k + 2, j, Block.BEDROCK.id);
        world.setTypeId(i - 1, k + 2, j, Block.TORCH.id);
        world.setTypeId(i + 1, k + 2, j, Block.TORCH.id);
        world.setTypeId(i, k + 2, j - 1, Block.TORCH.id);
        world.setTypeId(i, k + 2, j + 1, Block.TORCH.id);
        world.setTypeId(i, k + 3, j, Block.BEDROCK.id);
        world.setTypeId(i, k + 4, j, Block.DRAGON_EGG.id);

        this.world.getServer().getPluginManager().callEvent(event);

        if (!event.isCancelled()) {
            for (BlockState state : event.getBlocks()) {
                state.update(true);
            }
        }
        // CraftBukkit end

        BlockEnderPortal.a = false;
    }

    protected void au() {}

    public Entity[] aR() {
        return this.children;
    }

    public boolean e_() {
        return false;
    }

    // CraftBukkit start
    public int getExpReward() {
        // This value is equal to the amount of experience dropped while falling from the sky (10 * 1000)
        // plus what is dropped when the dragon hits the ground (10000)
        return 20000;
    }
    // CraftBukkit end
}
