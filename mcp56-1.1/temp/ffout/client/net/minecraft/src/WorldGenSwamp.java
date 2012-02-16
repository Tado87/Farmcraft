// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Material, Block, 
//            BlockLeaves, BlockGrass

public class WorldGenSwamp extends WorldGenerator
{

    public WorldGenSwamp()
    {
    }

    public boolean func_516_a(World world, Random random, int i, int j, int k)
    {
        int l = random.nextInt(4) + 5;
        for(; world.func_599_f(i, j - 1, k) == Material.field_1332_f; j--) { }
        boolean flag = true;
        if(j < 1 || j + l + 1 > world.field_35472_c)
        {
            return false;
        }
        for(int i1 = j; i1 <= j + 1 + l; i1++)
        {
            byte byte0 = 1;
            if(i1 == j)
            {
                byte0 = 0;
            }
            if(i1 >= (j + 1 + l) - 2)
            {
                byte0 = 3;
            }
            for(int j2 = i - byte0; j2 <= i + byte0 && flag; j2++)
            {
                for(int j3 = k - byte0; j3 <= k + byte0 && flag; j3++)
                {
                    if(i1 >= 0 && i1 < world.field_35472_c)
                    {
                        int i4 = world.func_600_a(j2, i1, j3);
                        if(i4 == 0 || i4 == Block.field_384_L.field_376_bc)
                        {
                            continue;
                        }
                        if(i4 == Block.field_399_C.field_376_bc || i4 == Block.field_401_B.field_376_bc)
                        {
                            if(i1 > j)
                            {
                                flag = false;
                            }
                        } else
                        {
                            flag = false;
                        }
                    } else
                    {
                        flag = false;
                    }
                }

            }

        }

        if(!flag)
        {
            return false;
        }
        int j1 = world.func_600_a(i, j - 1, k);
        if(j1 != Block.field_337_v.field_376_bc && j1 != Block.field_336_w.field_376_bc || j >= world.field_35472_c - l - 1)
        {
            return false;
        }
        world.func_634_a(i, j - 1, k, Block.field_336_w.field_376_bc);
        for(int k1 = (j - 3) + l; k1 <= j + l; k1++)
        {
            int k2 = k1 - (j + l);
            int k3 = 2 - k2 / 2;
            for(int j4 = i - k3; j4 <= i + k3; j4++)
            {
                int l4 = j4 - i;
                for(int j5 = k - k3; j5 <= k + k3; j5++)
                {
                    int k5 = j5 - k;
                    if((Math.abs(l4) != k3 || Math.abs(k5) != k3 || random.nextInt(2) != 0 && k2 != 0) && !Block.field_343_p[world.func_600_a(j4, k1, j5)])
                    {
                        world.func_634_a(j4, k1, j5, Block.field_384_L.field_376_bc);
                    }
                }

            }

        }

        for(int l1 = 0; l1 < l; l1++)
        {
            int l2 = world.func_600_a(i, j + l1, k);
            if(l2 == 0 || l2 == Block.field_384_L.field_376_bc || l2 == Block.field_401_B.field_376_bc || l2 == Block.field_399_C.field_376_bc)
            {
                world.func_634_a(i, j + l1, k, Block.field_385_K.field_376_bc);
            }
        }

        for(int i2 = (j - 3) + l; i2 <= j + l; i2++)
        {
            int i3 = i2 - (j + l);
            int l3 = 2 - i3 / 2;
            for(int k4 = i - l3; k4 <= i + l3; k4++)
            {
                for(int i5 = k - l3; i5 <= k + l3; i5++)
                {
                    if(world.func_600_a(k4, i2, i5) != Block.field_384_L.field_376_bc)
                    {
                        continue;
                    }
                    if(random.nextInt(4) == 0 && world.func_600_a(k4 - 1, i2, i5) == 0)
                    {
                        func_35265_a(world, k4 - 1, i2, i5, 8);
                    }
                    if(random.nextInt(4) == 0 && world.func_600_a(k4 + 1, i2, i5) == 0)
                    {
                        func_35265_a(world, k4 + 1, i2, i5, 2);
                    }
                    if(random.nextInt(4) == 0 && world.func_600_a(k4, i2, i5 - 1) == 0)
                    {
                        func_35265_a(world, k4, i2, i5 - 1, 1);
                    }
                    if(random.nextInt(4) == 0 && world.func_600_a(k4, i2, i5 + 1) == 0)
                    {
                        func_35265_a(world, k4, i2, i5 + 1, 4);
                    }
                }

            }

        }

        return true;
    }

    private void func_35265_a(World world, int i, int j, int k, int l)
    {
        world.func_688_b(i, j, k, Block.field_35278_bv.field_376_bc, l);
        for(int i1 = 4; world.func_600_a(i, --j, k) == 0 && i1 > 0; i1--)
        {
            world.func_688_b(i, j, k, Block.field_35278_bv.field_376_bc, l);
        }

    }
}
