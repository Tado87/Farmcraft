// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelZombie, ModelRenderer

public class ModelSkeleton extends ModelZombie
{

    public ModelSkeleton()
    {
        float f = 0.0F;
        field_1283_d = new ModelRenderer(this, 40, 16);
        field_1283_d.func_923_a(-1F, -2F, -1F, 2, 12, 2, f);
        field_1283_d.func_925_a(-5F, 2.0F, 0.0F);
        field_1282_e = new ModelRenderer(this, 40, 16);
        field_1282_e.field_1404_g = true;
        field_1282_e.func_923_a(-1F, -2F, -1F, 2, 12, 2, f);
        field_1282_e.func_925_a(5F, 2.0F, 0.0F);
        field_1281_f = new ModelRenderer(this, 0, 16);
        field_1281_f.func_923_a(-1F, 0.0F, -1F, 2, 12, 2, f);
        field_1281_f.func_925_a(-2F, 12F, 0.0F);
        field_1280_g = new ModelRenderer(this, 0, 16);
        field_1280_g.field_1404_g = true;
        field_1280_g.func_923_a(-1F, 0.0F, -1F, 2, 12, 2, f);
        field_1280_g.func_925_a(2.0F, 12F, 0.0F);
    }

    public void func_863_a(float f, float f1, float f2, float f3, float f4, float f5)
    {
        field_40333_u = true;
        super.func_863_a(f, f1, f2, f3, f4, f5);
    }
}
