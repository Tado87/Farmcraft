// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, ComponentNetherBridgeStartPiece, StructureBoundingBox, StructureComponent, 
//            Block, World

public class ComponentNetherBridgeStairs extends ComponentNetherBridgePiece
{

    public ComponentNetherBridgeStairs(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        func_40016_c((ComponentNetherBridgeStartPiece)structurecomponent, list, random, 6, 2, false);
    }

    public static ComponentNetherBridgeStairs func_40031_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -2, 0, 0, 7, 11, 7, l);
        if(!func_40021_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeStairs(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        func_35011_a(world, structureboundingbox, 0, 0, 0, 6, 1, 6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 2, 0, 6, 10, 6, 0, 0, false);
        func_35011_a(world, structureboundingbox, 0, 2, 0, 1, 8, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 5, 2, 0, 6, 8, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 2, 1, 0, 8, 6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 6, 2, 1, 6, 8, 6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 2, 6, 5, 8, 6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 0, 3, 2, 0, 5, 4, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 6, 3, 2, 6, 5, 2, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 6, 3, 4, 6, 5, 4, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        func_35018_a(world, Block.field_40206_bB.field_376_bc, 0, 5, 2, 5, structureboundingbox);
        func_35011_a(world, structureboundingbox, 4, 2, 5, 4, 3, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 3, 2, 5, 3, 4, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 2, 2, 5, 2, 5, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 2, 5, 1, 6, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 1, 7, 1, 5, 7, 4, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 6, 8, 2, 6, 8, 4, 0, 0, false);
        func_35011_a(world, structureboundingbox, 2, 6, 0, 4, 8, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
        func_35011_a(world, structureboundingbox, 2, 5, 0, 4, 5, 0, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
        for(int i = 0; i <= 6; i++)
        {
            for(int j = 0; j <= 6; j++)
            {
                func_35005_b(world, Block.field_40206_bB.field_376_bc, 0, i, -1, j, structureboundingbox);
            }

        }

        return true;
    }
}
