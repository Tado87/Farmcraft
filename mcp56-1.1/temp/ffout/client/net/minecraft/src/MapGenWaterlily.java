// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block

public class MapGenWaterlily extends WorldGenerator
{

    public MapGenWaterlily()
    {
    }

    public boolean func_516_a(World world, Random random, int i, int j, int k)
    {
        for(int l = 0; l < 10; l++)
        {
            int i1 = (i + random.nextInt(8)) - random.nextInt(8);
            int j1 = (j + random.nextInt(4)) - random.nextInt(4);
            int k1 = (k + random.nextInt(8)) - random.nextInt(8);
            if(world.func_20084_d(i1, j1, k1) && Block.field_40200_bA.func_243_a(world, i1, j1, k1))
            {
                world.func_634_a(i1, j1, k1, Block.field_40200_bA.field_376_bc);
            }
        }

        return true;
    }
}
