// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block, BlockLeaves, 
//            BlockGrass

public class WorldGenTaiga2 extends WorldGenerator
{

    public WorldGenTaiga2(boolean flag)
    {
        super(flag);
    }

    public boolean func_516_a(World world, Random random, int i, int j, int k)
    {
        int l = random.nextInt(4) + 6;
        int i1 = 1 + random.nextInt(2);
        int j1 = l - i1;
        int k1 = 2 + random.nextInt(2);
        boolean flag = true;
        if(j < 1 || j + l + 1 > world.field_35472_c)
        {
            return false;
        }
        for(int l1 = j; l1 <= j + 1 + l && flag; l1++)
        {
            int j2 = 1;
            if(l1 - j < i1)
            {
                j2 = 0;
            } else
            {
                j2 = k1;
            }
            for(int l2 = i - j2; l2 <= i + j2 && flag; l2++)
            {
                for(int j3 = k - j2; j3 <= k + j2 && flag; j3++)
                {
                    if(l1 >= 0 && l1 < world.field_35472_c)
                    {
                        int k3 = world.func_600_a(l2, l1, j3);
                        if(k3 != 0 && k3 != Block.field_384_L.field_376_bc)
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
        int i2 = world.func_600_a(i, j - 1, k);
        if(i2 != Block.field_337_v.field_376_bc && i2 != Block.field_336_w.field_376_bc || j >= world.field_35472_c - l - 1)
        {
            return false;
        }
        world.func_634_a(i, j - 1, k, Block.field_336_w.field_376_bc);
        int k2 = random.nextInt(2);
        int i3 = 1;
        boolean flag1 = false;
        for(int l3 = 0; l3 <= j1; l3++)
        {
            int j4 = (j + l) - l3;
            for(int l4 = i - k2; l4 <= i + k2; l4++)
            {
                int j5 = l4 - i;
                for(int k5 = k - k2; k5 <= k + k2; k5++)
                {
                    int l5 = k5 - k;
                    if((Math.abs(j5) != k2 || Math.abs(l5) != k2 || k2 <= 0) && !Block.field_343_p[world.func_600_a(l4, j4, k5)])
                    {
                        func_41060_a(world, l4, j4, k5, Block.field_384_L.field_376_bc, 1);
                    }
                }

            }

            if(k2 >= i3)
            {
                k2 = ((flag1) ? 1 : 0);
                flag1 = true;
                if(++i3 > k1)
                {
                    i3 = k1;
                }
            } else
            {
                k2++;
            }
        }

        int i4 = random.nextInt(3);
        for(int k4 = 0; k4 < l - i4; k4++)
        {
            int i5 = world.func_600_a(i, j + k4, k);
            if(i5 == 0 || i5 == Block.field_384_L.field_376_bc)
            {
                func_41060_a(world, i, j + k4, k, Block.field_385_K.field_376_bc, 1);
            }
        }

        return true;
    }
}
